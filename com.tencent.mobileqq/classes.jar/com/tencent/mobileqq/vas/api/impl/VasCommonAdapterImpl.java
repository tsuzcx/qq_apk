package com.tencent.mobileqq.vas.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import com.Vas.ColorFont.FastColorFontHelper;
import com.Vas.ColorFont.FreeTypeLib;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.mobileqq.apollo.utils.api.IApolloConfigDataReportHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService;
import com.tencent.mobileqq.emoticonview.EmoticonStoreTabEntryUtils;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hiboom.BaseChatPieAdapter;
import com.tencent.mobileqq.hiboom.api.IBaseChatPieAdapter;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.hiboom.api.impl.HiBoomAuthObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import tencent.hiboom.hiboomauth.hiboom_auth.TTipsInfo;

public class VasCommonAdapterImpl
  implements IVasCommonAdapter
{
  private static final int TIPS_TYPE_DIALOG = 1;
  private static final int TIPS_TYPE_PAY = 2;
  
  public String addParamToUrl(String paramString1, String paramString2)
  {
    return HtmlOffline.a(paramString1, paramString2);
  }
  
  public void checkFZEngineReady()
  {
    if (!FastColorFontHelper.a().c.get())
    {
      FastColorFontHelper.a().a().a();
      FastColorFontHelper.a().c.set(true);
    }
  }
  
  public void clearMagicFontCache(AppRuntime paramAppRuntime)
  {
    synchronized (TextItemBuilder.a)
    {
      TextItemBuilder.a.clear();
      VasUtils.a((AppInterface)paramAppRuntime);
      return;
    }
  }
  
  public Bitmap decodeFileWithBufferedStream(String paramString, BitmapFactory.Options paramOptions)
  {
    return ImageUtil.a(paramString, paramOptions);
  }
  
  public IBaseChatPieAdapter getBaseChatPieAdapter(Context paramContext)
  {
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = (BaseActivity)paramContext;
      if ((paramContext.getChatFragment() != null) && (paramContext.getChatFragment().a() != null)) {
        return new BaseChatPieAdapter(paramContext.getChatFragment().a());
      }
    }
    return null;
  }
  
  public int getChatTextSize(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ChatTextSizeSettingActivity.a(((QQAppInterface)paramAppRuntime).getApp());
    }
    return 0;
  }
  
  public BusinessObserver getHiBoomAuthObserver(Context paramContext)
  {
    return new HiBoomAuthObserver(paramContext);
  }
  
  public int getInvalidateHiBoomPreviewType()
  {
    return 19;
  }
  
  public String getKeyIsKandianEmoticon()
  {
    return "EXTRA_KEY_IS_KANDIAN_EMOTICON";
  }
  
  public String getKeyIsShowAD()
  {
    return "isShowAd";
  }
  
  public String getKeyIsSmallEmoticon()
  {
    return "EXTRA_KEY_IS_SMALL_EMOTICON";
  }
  
  public QQProgressDialog getProgressDialog(Context paramContext)
  {
    BaseActivity localBaseActivity = (BaseActivity)paramContext;
    if ((localBaseActivity.getChatFragment() != null) && (localBaseActivity.getChatFragment().a() != null))
    {
      if (localBaseActivity.getChatFragment().a().a == null) {
        localBaseActivity.getChatFragment().a().a = new QQProgressDialog(paramContext);
      }
      return localBaseActivity.getChatFragment().a().a;
    }
    return null;
  }
  
  public Class<?> getQQBrowserActivityClass()
  {
    return QQBrowserActivity.class;
  }
  
  public void getRichTextChatConfig(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      RichTextChatManager.a((QQAppInterface)paramAppInterface).a(paramAppInterface);
    }
  }
  
  public String getUserDataString()
  {
    return "content://qq.friendlist/individuationUserData";
  }
  
  public void handleHiBoomMsg(IBaseChatPieAdapter paramIBaseChatPieAdapter, String paramString)
  {
    if ((paramIBaseChatPieAdapter != null) && (paramIBaseChatPieAdapter.a() != null))
    {
      if (!(paramIBaseChatPieAdapter.a() instanceof BaseChatPie)) {
        return;
      }
      Object localObject = (BaseChatPie)paramIBaseChatPieAdapter.a();
      paramIBaseChatPieAdapter = new ChatActivityFacade.SendMsgParams();
      ((BaseChatPie)localObject).a(paramIBaseChatPieAdapter);
      AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)((BaseChatPie)localObject).a(52);
      if (localAIOShortcutBarHelper != null)
      {
        AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(18);
        localAIOShortcutBarEvent.a().putBoolean("isSendToRobotServer", false);
        localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
        paramIBaseChatPieAdapter.i = localAIOShortcutBarEvent.a().getBoolean("result", false);
      }
      if (localObject != null)
      {
        localObject = (QWalletAIOLifeCycleHelper)((BaseChatPie)localObject).a(27);
        if (localObject != null) {
          ((QWalletAIOLifeCycleHelper)localObject).a(paramString, paramIBaseChatPieAdapter, 0);
        }
      }
    }
  }
  
  public void handleHiBoomTipsInfo(Context paramContext, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      Object localObject3 = new hiboom_auth.TTipsInfo();
      try
      {
        ((hiboom_auth.TTipsInfo)localObject3).mergeFrom(paramArrayOfByte);
        int i = ((hiboom_auth.TTipsInfo)localObject3).i32_type.get();
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("onHiBoomAuthResult tipsType = ");
          paramArrayOfByte.append(i);
          QLog.d("HiBoomManager", 2, paramArrayOfByte.toString());
        }
        paramArrayOfByte = ((hiboom_auth.TTipsInfo)localObject3).str_title.get();
        Object localObject2 = paramArrayOfByte;
        if (android.text.TextUtils.isEmpty(paramArrayOfByte)) {
          localObject2 = HardCodeUtil.a(2131705560);
        }
        Object localObject1 = ((hiboom_auth.TTipsInfo)localObject3).str_msg.get();
        paramArrayOfByte = (byte[])localObject1;
        if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
          if (i == 1)
          {
            paramArrayOfByte = HardCodeUtil.a(2131705564);
          }
          else
          {
            paramArrayOfByte = (byte[])localObject1;
            if (i == 2) {
              paramArrayOfByte = HardCodeUtil.a(2131705569);
            }
          }
        }
        String str1 = ((hiboom_auth.TTipsInfo)localObject3).str_button.get();
        localObject1 = str1;
        if (android.text.TextUtils.isEmpty(str1)) {
          if (i == 1)
          {
            localObject1 = HardCodeUtil.a(2131705565);
          }
          else
          {
            localObject1 = str1;
            if (i == 2) {
              localObject1 = HardCodeUtil.a(2131705562);
            }
          }
        }
        String str2 = ((hiboom_auth.TTipsInfo)localObject3).str_url.get();
        str1 = HardCodeUtil.a(2131705568);
        localObject3 = new VasCommonAdapterImpl.1(this, i, str2, paramContext, (hiboom_auth.TTipsInfo)localObject3, paramInt);
        try
        {
          DialogUtil.a(paramContext, 230, (String)localObject2, paramArrayOfByte, str1, (String)localObject1, (DialogInterface.OnClickListener)localObject3, new VasCommonAdapterImpl.2(this)).show();
          paramContext = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getBaseChatPieAdapter(paramContext);
          if (paramContext == null) {
            return;
          }
          ((IVasService)paramContext.a().getRuntimeService(IVasService.class, "")).getHiBoomManager().setIsHiBoomListInit(false);
          return;
        }
        catch (Exception paramContext) {}
        paramArrayOfByte = new StringBuilder();
      }
      catch (Exception paramContext) {}
      paramArrayOfByte.append("onHiBoomAuthResult merge error: ");
      paramArrayOfByte.append(paramContext.getLocalizedMessage());
      paramArrayOfByte.append(" trace: ");
      paramArrayOfByte.append(Log.getStackTraceString(paramContext));
      QLog.e("HiBoomManager", 1, paramArrayOfByte.toString());
      return;
    }
  }
  
  public boolean hasSysEmotion(String paramString)
  {
    return com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramString);
  }
  
  public void hiboomAuthForward(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 37);
    localBundle.putInt("emoInputType", 5);
    localBundle.putString("forward_text", paramString);
    localBundle.putInt("key_hiboom_id", paramInt1);
    localBundle.putInt("key_hiboom_type", paramInt2);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    ForwardBaseOption.a(paramActivity, paramString, 21);
  }
  
  public int initColorFont(int paramInt, String paramString)
  {
    return FastColorFontHelper.a().a(paramInt, paramString);
  }
  
  public String insertMtype(String paramString1, String paramString2)
  {
    return EmosmUtils.a(paramString1, paramString2);
  }
  
  public Intent insertWbPlugin(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return null;
    }
    if (WebViewPluginFactory.a.containsKey(paramString)) {
      paramIntent.putExtra("insertPluginsArray", new String[] { paramString });
    }
    return paramIntent;
  }
  
  public boolean isFZEngineInited()
  {
    return FastColorFontHelper.a().a.get();
  }
  
  public boolean isFZSoLoaded()
  {
    return FastColorFontHelper.a().b.get();
  }
  
  public boolean isFragmentStyleOrEmoStore(Intent paramIntent)
  {
    boolean bool = false;
    if (paramIntent == null) {
      return false;
    }
    if (paramIntent.getIntExtra("fragmentStyle", 0) == 4) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isLaterVersionByUrlConfig(String paramString1, String paramString2)
  {
    return SwiftWebViewUtils.a(paramString1, "8.7.0");
  }
  
  public String isShowAdKey()
  {
    return "isShowAd";
  }
  
  public void parseURLJson(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((URLInterceptManager)paramAppRuntime.getManager(QQManagerFactory.URL_INTECEPT_MANAGER)).a((QQAppInterface)paramAppRuntime);
    }
  }
  
  public String processEmoStoreHomeUrl(String paramString)
  {
    return EmoticonStoreTabEntryUtils.processEmoStoreHomeUrl(paramString);
  }
  
  public Bundle putSrcType(Bundle paramBundle)
  {
    paramBundle.putInt("srcType", 2);
    return paramBundle;
  }
  
  public Intent putWebViewTitleStyle(Intent paramIntent, String paramString)
  {
    paramString = (WebViewTitleStyle)WebViewTitleStyleHelper.a().a.get(paramString);
    if (paramString != null) {
      paramIntent.putExtra("titleStyle", paramString);
    }
    return paramIntent;
  }
  
  public void reportClickEventTo644(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    String str;
    if ((paramAppInterface instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
      if (android.text.TextUtils.isEmpty(paramString1)) {
        str = "UNKNOWN";
      } else {
        str = paramString1;
      }
      ReportController.b(localQQAppInterface, "P_CliOper", str, "", paramString2, paramString3, paramInt1, paramInt2, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], paramArrayOfString[3]);
    }
    else if (paramAppInterface != null)
    {
      if (android.text.TextUtils.isEmpty(paramString1)) {
        str = "UNKNOWN";
      } else {
        str = paramString1;
      }
      AppIntefaceReportWrap.a(paramAppInterface, "P_CliOper", str, "", paramString2, paramString3, paramInt1, paramInt2, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], paramArrayOfString[3]);
    }
    else
    {
      if (android.text.TextUtils.isEmpty(paramString1)) {
        str = "UNKNOWN";
      } else {
        str = paramString1;
      }
      ReportController.b(null, "P_CliOper", str, "", paramString2, paramString3, paramInt1, paramInt2, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], paramArrayOfString[3]);
    }
    try
    {
      ((IApolloConfigDataReportHelper)QRoute.api(IApolloConfigDataReportHelper.class)).interceptReport(paramAppInterface, paramString1, paramString2, paramString3, "", paramInt1, paramInt2, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], paramArrayOfString[3]);
      return;
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public void reportClickEventTo644V2(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    String str;
    if ((paramAppInterface instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
      if (android.text.TextUtils.isEmpty(paramString1)) {
        str = "UNKNOWN";
      } else {
        str = paramString1;
      }
      ReportController.b(localQQAppInterface, "P_CliOper", str, paramString4, paramString2, paramString3, paramInt1, paramInt2, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], paramArrayOfString[3]);
    }
    else if (paramAppInterface != null)
    {
      if (android.text.TextUtils.isEmpty(paramString1)) {
        str = "UNKNOWN";
      } else {
        str = paramString1;
      }
      AppIntefaceReportWrap.a(paramAppInterface, "P_CliOper", str, paramString4, paramString2, paramString3, paramInt1, paramInt2, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], paramArrayOfString[3]);
    }
    else
    {
      if (android.text.TextUtils.isEmpty(paramString1)) {
        str = "UNKNOWN";
      } else {
        str = paramString1;
      }
      ReportController.b(null, "P_CliOper", str, paramString4, paramString2, paramString3, paramInt1, paramInt2, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], paramArrayOfString[3]);
    }
    ((IApolloConfigDataReportHelper)QRoute.api(IApolloConfigDataReportHelper.class)).interceptReport(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], paramArrayOfString[3]);
  }
  
  public void reportRedPacket(AppRuntime paramAppRuntime)
  {
    String str;
    if (((IndividualRedPacketManager)paramAppRuntime.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER)).a()) {
      str = "1";
    } else {
      str = "0";
    }
    ReportController.b(paramAppRuntime, "CliOper", "", "", "0X800612B", "0X800612B", 0, 0, str, "0", "", "");
  }
  
  public void resolveFunnyPicJson(AppRuntime paramAppRuntime)
  {
    ((IFunnyPicHelperService)QRoute.api(IFunnyPicHelperService.class)).resolveFunnyPicJson((AppInterface)paramAppRuntime);
  }
  
  public void sendHiBoomMessage(AppInterface paramAppInterface, BaseSessionInfo paramBaseSessionInfo, HiBoomMessage paramHiBoomMessage, Object paramObject)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && ((paramBaseSessionInfo instanceof SessionInfo))) {
      ChatActivityFacade.a((QQAppInterface)paramAppInterface, (SessionInfo)paramBaseSessionInfo, paramHiBoomMessage, null);
    }
  }
  
  public Intent setBrowserTitleStyle(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return null;
    }
    paramString = (WebViewTitleStyle)WebViewTitleStyleHelper.a().a.get(paramString);
    if (paramString != null) {
      paramIntent.putExtra("titleStyle", paramString);
    }
    return paramIntent;
  }
  
  public void setColorNickEnabke(boolean paramBoolean)
  {
    ColorNickManager.a.set(paramBoolean);
  }
  
  public void setHiBoomMaxSize(int paramInt)
  {
    com.tencent.mobileqq.hiboom.HiBoomConstants.a = paramInt;
  }
  
  public void setSignatureEnable(boolean paramBoolean)
  {
    SignatureManager.a = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("diySigEnable = ");
      localStringBuilder.append(SignatureManager.a);
      QLog.d("DiySignature", 2, localStringBuilder.toString());
    }
  }
  
  public void setVipCardDrawable(Resources paramResources, ImageView paramImageView, String paramString)
  {
    if (paramResources != null) {
      VipUtils.a(paramResources, paramImageView, paramString, paramResources.getDrawable(2130847296));
    }
  }
  
  public void startWebSoRequest(String paramString) {}
  
  public void updateMsgFieldByUniseq(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getMessageFacade().a(paramString1, paramInt, paramLong, "extStr", paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasCommonAdapterImpl
 * JD-Core Version:    0.7.0.1
 */