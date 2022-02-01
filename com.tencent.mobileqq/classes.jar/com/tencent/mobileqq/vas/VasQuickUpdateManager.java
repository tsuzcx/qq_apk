package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.comic.api.IQQComicSoHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.IEmoticonHandler;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.diy.VipProfileDiyCardConfig;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableDownloadHelper;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.theme.ThemeCleaner;
import com.tencent.mobileqq.vas.updatesystem.api.IVasEngine;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.vip.TMSManager.DynamicLoadHelper;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xaction.openapi.api.IXADownload;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Deprecated
public class VasQuickUpdateManager
  implements Manager
{
  private static final String TAG = "VasQuickUpdateManager";
  public QQAppInterface app = null;
  ConcurrentHashMap<Integer, CallBacker> callBackers = new ConcurrentHashMap();
  private BaseUpdateCallback defaultCallback = new VasQuickUpdateManager.DefaultUpdateCallback(this);
  private IVasEngine mEngineProxy;
  AtomicInteger mKey = new AtomicInteger(0);
  public IApolloExtensionObserver mQuickUpdateObserver = new VasQuickUpdateManager.DefaultVasExtensionObserver(this);
  
  public VasQuickUpdateManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    initEngine();
    paramQQAppInterface.addObserver(this.mQuickUpdateObserver, true);
  }
  
  @NotNull
  private Boolean checkFileExist(String paramString, StringBuilder paramStringBuilder)
  {
    Object localObject2 = new File(paramStringBuilder.toString());
    boolean bool2 = ((File)localObject2).exists();
    boolean bool1 = false;
    Object localObject1 = Boolean.valueOf(false);
    if (bool2)
    {
      if (((File)localObject2).isDirectory())
      {
        if (((File)localObject2).listFiles() == null) {
          return localObject1;
        }
        int i = ((File)localObject2).listFiles().length;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("isFileExists scid = ");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(" listFile length = ");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(" filepath = ");
          ((StringBuilder)localObject1).append(paramStringBuilder.toString());
          QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject1).toString());
        }
        if (i > 0) {
          bool1 = true;
        }
        return Boolean.valueOf(bool1);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isFileExists scid = ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" exists filepath = ");
        ((StringBuilder)localObject1).append(paramStringBuilder.toString());
        QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject1).toString());
      }
      return Boolean.valueOf(true);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isFileExists scid = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" not exists filepath = ");
      ((StringBuilder)localObject2).append(paramStringBuilder.toString());
      QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  @NotNull
  private Boolean checkZipExsit()
  {
    String str = TroopEnterEffectController.a();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("VasQuickUpdateManager", 1, "VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS: get null zipPath");
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(new File(str).exists());
  }
  
  public static void cleanCache()
  {
    try
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      if (localBaseApplication != null)
      {
        deleteJSON("VASBiz_FuncDev_webview.json");
        ThemeCleaner.a(localBaseApplication);
        UpdateCallbackSelector.cleanCache(localBaseApplication);
      }
      else
      {
        QLog.e("VasQuickUpdateManager", 1, "cleanCache: null Context");
      }
      return;
    }
    finally {}
  }
  
  private boolean deleteFiles2(long paramLong, String paramString, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public static void deleteJSON(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString);
      paramString = new File(localStringBuilder.toString());
      if (paramString.exists()) {
        paramString.delete();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private boolean getItemInfo1(long paramLong, String paramString, TagItemInfo paramTagItemInfo)
  {
    Object localObject;
    if (paramLong == 1003L)
    {
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.b = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.app.getApplication().getFilesDir());
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramString);
      paramTagItemInfo.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      return true;
    }
    if (paramLong == 8L)
    {
      localObject = (ChatBackgroundManager)this.app.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
      paramString = paramString.substring(7, paramString.length());
      paramTagItemInfo.b = false;
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = ((ChatBackgroundManager)localObject).e(paramString);
      return true;
    }
    if (paramLong == 27L)
    {
      paramString = paramString.substring(14, paramString.length());
      paramTagItemInfo.b = true;
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ColorNickManager.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(paramString);
      paramTagItemInfo.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      return true;
    }
    if (paramLong == 33L)
    {
      paramString = paramString.substring(12);
      paramTagItemInfo.b = false;
      paramTagItemInfo.jdField_a_of_type_Boolean = false;
      paramTagItemInfo.jdField_a_of_type_JavaLangString = ProfileCardManager.a(paramString);
      return true;
    }
    return false;
  }
  
  private void initEngine()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initEngine: ");
    ((StringBuilder)localObject).append(this);
    QLog.e("VasQuickUpdateManager", 1, ((StringBuilder)localObject).toString());
    this.mEngineProxy = ((IVasEngine)this.app.getRuntimeService(IVasEngine.class, ""));
    UpdateCallbackSelector.setDefaultCallback(this.defaultCallback);
    localObject = this.mEngineProxy;
    if (localObject != null)
    {
      ((IVasEngine)localObject).setRequestHandler(new VasQuickUpdateManager.1(this));
      this.mEngineProxy.startUpdateAllItem();
    }
  }
  
  private boolean isResult(String paramString)
  {
    Object localObject = null;
    paramString = IndividualRedPacketManager.a(paramString, null, 24, 0, 0);
    if (TextUtils.isEmpty(paramString)) {
      paramString = localObject;
    } else {
      paramString = new File(paramString);
    }
    boolean bool = true;
    if ((paramString == null) || (!paramString.exists()) || (!paramString.isDirectory()) || (paramString.list() == null) || (paramString.list().length <= 1)) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isFileExists VasUpdateConstants.SCID_REDPACKET_PACKETS_ZIP result = ");
      paramString.append(bool);
      QLog.d("VasQuickUpdateManager", 2, paramString.toString());
    }
    return bool;
  }
  
  private void onJsonCompleted1(String paramString, int paramInt)
  {
    if (paramString.equals("keywordList_2.json"))
    {
      paramString = (IEmoticonManagerService)this.app.getRuntimeService(IEmoticonManagerService.class);
      if (paramString != null) {
        paramString.parseCloudKeywordsJson();
      }
    }
    else
    {
      if (paramString.startsWith("signature.item."))
      {
        VasUtils.a(this.app);
        return;
      }
      boolean bool2 = "vipData_individuation_url.android.json".equals(paramString);
      boolean bool1 = true;
      if (bool2)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("onCompleted url_configurable ,errorCode = ");
          paramString.append(paramInt);
          paramString.append(", app=");
          if (this.app == null) {
            bool1 = false;
          }
          paramString.append(bool1);
          QLog.d("VasQuickUpdateManager", 2, paramString.toString());
        }
        IndividuationUrlHelper.a(this.app);
        return;
      }
      if ("changeVoice_json".equals(paramString))
      {
        ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).preCheckData(null, null, this.app);
        return;
      }
      if ("blessVoiceList.json".equals(paramString))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("onCompleted blessVoiceChange ,errorCode = ");
          paramString.append(paramInt);
          QLog.d("VasQuickUpdateManager", 2, paramString.toString());
        }
      }
      else if ("vip_personal_card.json".equals(paramString))
      {
        VipGrayConfigHelper.a().a(this.app, true);
        ClubContentJsonTask.b(this.app);
        AioVipKeywordHelper.a().a(this.app);
      }
    }
  }
  
  private void onJsonCompleted2(String paramString)
  {
    if ("monitorAppid".equals(paramString))
    {
      ((VasMonitorHandler)this.app.getBusinessHandler(BusinessHandlerFactory.VAS_MONITOR_HANDLER)).a(this.app, true);
      return;
    }
    if ("praise.config.json".equals(paramString))
    {
      PraiseConfigHelper.a(this.app);
      return;
    }
    if ("card.diyFontConfig.json".equals(paramString))
    {
      VipProfileDiyCardConfig.a(this.app);
      return;
    }
    if ("vipData_app_webviewNavStyle.json".equals(paramString))
    {
      WebViewTitleStyleHelper.a().a(this.app);
      return;
    }
    if ("VASBiz_FuncDev_webview.json".equals(paramString))
    {
      AuthorizeConfig.a().j();
      AuthorizeConfig.a().e();
      AuthorizeConfig.a().c();
      return;
    }
    if ("watch_focus.json".equals(paramString))
    {
      paramString = (IEmoticonHandler)this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
      if (paramString != null) {
        paramString.c();
      }
    }
    else
    {
      if ("groupeffect_config.json".equals(paramString))
      {
        ((ITroopEnterEffectService)this.app.getRuntimeService(ITroopEnterEffectService.class, "all")).readEffectConfigData(false);
        return;
      }
      if ("emoji.systemEmojiWhiteList.json".equals(paramString)) {
        SystemEmoticonInfo.parseWhiteList(this.app, true);
      }
    }
  }
  
  private boolean onMaterialCompleted2(String paramString, int paramInt)
  {
    if (paramString.equals("libqgplayer_841"))
    {
      ((IQQComicSoHelper)QRoute.api(IQQComicSoHelper.class)).onSoDownloadCompleted(this.app, paramInt);
      return false;
    }
    if (paramString.equals("kcsdk_4_4_7_3661"))
    {
      TMSManager.a().a(this.app.getApp(), paramInt);
      return false;
    }
    if (paramString.equals("GLDrawableV860"))
    {
      GLDrawableDownloadHelper.a(this.app.getApp(), paramInt);
      return false;
    }
    if (paramString.equals("XA_865"))
    {
      ((IXADownload)QRoute.api(IXADownload.class)).onComplete(paramInt);
      return false;
    }
    if (paramString.equals("libAPNG_845"))
    {
      VasApngIPCModule.a().a(paramInt);
      return false;
    }
    if (paramString.equals("defaultFont_775"))
    {
      VasShieldFont.a(this.app, paramInt);
      return false;
    }
    if ((paramString.equals("enterEffectVipIcons")) && (paramInt == 0))
    {
      paramString = TroopEnterEffectController.a();
      String str = TroopEnterEffectController.b();
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str))) {
        try
        {
          FileUtils.uncompressZip(paramString, str, false);
          return false;
        }
        catch (IOException paramString)
        {
          QLog.e("VasQuickUpdateManager", 1, "VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS onCompleted error", paramString);
          return false;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS onComplete null path: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",");
      localStringBuilder.append(str);
      QLog.e("VasQuickUpdateManager", 1, localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  public void addCallBacker(CallBacker paramCallBacker)
  {
    if (paramCallBacker == null) {
      return;
    }
    if (!this.callBackers.containsValue(paramCallBacker))
    {
      int i = this.mKey.addAndGet(1);
      this.callBackers.put(Integer.valueOf(i), paramCallBacker);
      paramCallBacker.key = i;
    }
  }
  
  public void addWeakCallback(CallBacker paramCallBacker)
  {
    Object localObject = this.callBackers.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      CallBacker localCallBacker = (CallBacker)((Iterator)localObject).next();
      if (((localCallBacker instanceof VasQuickUpdateManager.WeakCallbacker)) && (((VasQuickUpdateManager.WeakCallbacker)localCallBacker).isWrapOf(paramCallBacker))) {
        return;
      }
    }
    localObject = new VasQuickUpdateManager.WeakCallbacker(paramCallBacker, this);
    addCallBacker((CallBacker)localObject);
    paramCallBacker.key = ((VasQuickUpdateManager.WeakCallbacker)localObject).key;
  }
  
  public void callBackToAll(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callBackToAll Error bid = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", cfgScid=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",scid = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", from = ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", errorCode = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.e("VasQuickUpdateManager", 2, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.callBackers.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((CallBacker)((Iterator)localObject).next()).callback(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelDwonloadItem bid = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" scid = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mEngineProxy;
    if (localObject != null) {
      ((IVasEngine)localObject).cancelDwonloadItem(paramLong, paramString);
    }
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadGatherItem bid = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" scid = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" scidList = ");
      ((StringBuilder)localObject).append(TextUtils.join(",", paramArrayOfString));
      ((StringBuilder)localObject).append(" from = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mEngineProxy;
    if (localObject != null) {
      ((IVasEngine)localObject).downloadGatherItem(paramLong, paramString1, paramArrayOfString, paramString2);
    }
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadItem bid = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" scid = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" from = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("VasQuickUpdateManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mEngineProxy;
    if (localObject != null) {
      ((IVasEngine)localObject).downloadItem(paramLong, paramString1, paramString2);
    }
  }
  
  public IVasEngine getVasEngine()
  {
    return this.mEngineProxy;
  }
  
  public void onDestroy()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDestroy: ");
    ((StringBuilder)localObject).append(this);
    QLog.e("VasQuickUpdateManager", 1, ((StringBuilder)localObject).toString());
    this.app.removeObserver(this.mQuickUpdateObserver);
    UpdateCallbackSelector.unsetDefaultCallback(this.defaultCallback);
    this.callBackers.clear();
    localObject = this.mEngineProxy;
    if (localObject != null)
    {
      ((IVasEngine)localObject).onDestroy();
      this.mEngineProxy = null;
    }
  }
  
  public void onProgressToAll(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callBackToAll Error bid = ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", cfgScid=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",scid = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.e("VasQuickUpdateManager", 2, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = this.callBackers.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((CallBacker)((Iterator)localObject).next()).onProgress(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong, QueryItemCallback paramQueryItemCallback)
  {
    if (this.mEngineProxy != null)
    {
      paramQueryItemCallback = new VasQuickUpdateManager.TimeoutWrapper(paramQueryItemCallback, paramBoolean2, null);
      if (paramLong > 0L) {
        ThreadManager.getSubThreadHandler().postDelayed(paramQueryItemCallback, paramLong);
      }
      this.mEngineProxy.queryItemVersion(paramInt, paramString, paramBoolean1, paramQueryItemCallback);
      return;
    }
    paramQueryItemCallback.onQueryItemVer(2, "", "");
  }
  
  public void removeCallBacker(CallBacker paramCallBacker)
  {
    if (paramCallBacker == null) {
      return;
    }
    this.callBackers.remove(Integer.valueOf(paramCallBacker.key));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager
 * JD-Core Version:    0.7.0.1
 */