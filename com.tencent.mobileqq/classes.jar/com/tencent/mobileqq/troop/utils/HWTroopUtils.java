package com.tencent.mobileqq.troop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateUpdateMsgInfoUtil;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi.LinkParams;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;

public class HWTroopUtils
{
  public static final Integer a = Integer.valueOf(1);
  public static final Integer b = Integer.valueOf(4);
  public static final Integer c = Integer.valueOf(2);
  
  public static String a(String paramString)
  {
    try
    {
      int i = paramString.lastIndexOf(".");
      if (i != -1)
      {
        paramString = paramString.substring(i, paramString.length());
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("hw_troop", 2, "getFileSuffix:", paramString);
      }
    }
    return "";
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://qun.qq.com/homework/features/guide.html?ishw=1&_wv=1027&_bid=2146&gid=");
    localStringBuilder.append(paramString);
    localIntent.putExtra("url", localStringBuilder.toString());
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("isShowAd", false);
    paramContext.startActivity(localIntent);
  }
  
  public static final void a(Context paramContext, String paramString, Integer paramInteger)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("url", String.format("https://admin.qun.qq.com/mcreatev4/classinfo?gc=%1$s&from=%2$s", new Object[] { paramString, paramInteger }));
    paramContext.startActivity(localIntent);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("url", String.format("https://admin.qun.qq.com/mcreatev3/joingroup.html?_bid=206&_wv=2098179&groupCode=%1$s&source=%2$s&uin=%3$s", new Object[] { paramString2, paramString3, paramString1 }));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    ITroopLinkApi localITroopLinkApi = (ITroopLinkApi)QRoute.api(ITroopLinkApi.class);
    Object localObject2 = localITroopLinkApi.getUrl("troop_create_homework");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>";
    }
    localObject2 = new ITroopLinkApi.LinkParams();
    ((ITroopLinkApi.LinkParams)localObject2).a = paramString;
    ((ITroopLinkApi.LinkParams)localObject2).c = "aio";
    ((ITroopLinkApi.LinkParams)localObject2).i = "";
    paramString = localITroopLinkApi.replaceParams((String)localObject1, (ITroopLinkApi.LinkParams)localObject2);
    if (paramString != null) {
      if (paramString.startsWith("mqqapi://"))
      {
        paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramContext, paramString);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.a();
        }
      }
      else
      {
        paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramQQAppInterface.putExtra("finish_animation_up_down", true);
        paramQQAppInterface.putExtra("url", paramString);
        paramContext.startActivity(paramQQAppInterface);
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(2130772434, 2130772007);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopTipsEntity paramTroopTipsEntity)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("insertTroopHomeworkPriseGrayTips:");
      ((StringBuilder)localObject1).append(paramTroopTipsEntity.troopUin);
      ((StringBuilder)localObject1).append(", optContent:");
      ((StringBuilder)localObject1).append(paramTroopTipsEntity.optContent);
      ((StringBuilder)localObject1).append(", , remindFlag:");
      ((StringBuilder)localObject1).append(paramTroopTipsEntity.grayTipsRemindFlag);
      ((StringBuilder)localObject1).append(", serviceType:3, msgSeq:");
      ((StringBuilder)localObject1).append(paramTroopTipsEntity.msgSeq);
      ((StringBuilder)localObject1).append(", time:");
      ((StringBuilder)localObject1).append(paramTroopTipsEntity.time);
      ((StringBuilder)localObject1).append(", expireTime:");
      ((StringBuilder)localObject1).append(paramTroopTipsEntity.expireTime);
      ((StringBuilder)localObject1).append(", isOfflineMsg:");
      ((StringBuilder)localObject1).append(paramTroopTipsEntity.isOfflineMsg);
      ((StringBuilder)localObject1).append(", optShowLatest:");
      ((StringBuilder)localObject1).append(paramTroopTipsEntity.optShowLatest);
      ((StringBuilder)localObject1).append(", highlightItems:");
      ((StringBuilder)localObject1).append(paramTroopTipsEntity.highlightItems);
      ((StringBuilder)localObject1).append(", highLightNum:");
      ((StringBuilder)localObject1).append(paramTroopTipsEntity.highlightNum);
      QLog.d("hw_troop", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (MessageForGrayTips)MessageRecordFactory.a(-2043);
    ((MessageForGrayTips)localObject1).frienduin = paramTroopTipsEntity.troopUin;
    ((MessageForGrayTips)localObject1).init(paramQQAppInterface.getCurrentAccountUin(), paramTroopTipsEntity.troopUin, paramTroopTipsEntity.troopUin, paramTroopTipsEntity.optContent, paramTroopTipsEntity.time, -2043, 1, paramTroopTipsEntity.msgSeq);
    if (paramTroopTipsEntity.highlightNum != 0) {
      TroopTipsMsgMgr.a((MessageForGrayTips)localObject1, paramTroopTipsEntity.highlightItems);
    }
    if (paramTroopTipsEntity.optShowLatest == 1) {
      ((MessageForGrayTips)localObject1).shmsgseq = 0L;
    }
    if (!MessageHandlerUtils.a(paramQQAppInterface, (MessageRecord)localObject1, false))
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("insertTroopHomeworkPriseGrayTips, after msgFilter:");
        ((StringBuilder)localObject2).append(paramTroopTipsEntity.troopUin);
        QLog.d("hw_troop", 2, ((StringBuilder)localObject2).toString());
      }
      paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, paramQQAppInterface.getCurrentAccountUin());
      if (!((TroopBindPublicAccountMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).f(paramTroopTipsEntity.troopUin))
      {
        localObject2 = new MessageInfo();
        Object localObject3 = new MessageInfo();
        ((MessageInfo)localObject3).c.a(4, ((MessageForGrayTips)localObject1).shmsgseq, ((MessageForGrayTips)localObject1).uniseq);
        ((MessageInfo)localObject2).a((MessageInfo)localObject3);
        ((MessageForGrayTips)localObject1).mMessageInfo = ((MessageInfo)localObject3);
        ((TroopInfoManager)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(paramTroopTipsEntity.troopUin, (MessageInfo)localObject2);
        Object localObject4 = new BaseMessageManager.AddMessageContext(paramQQAppInterface);
        localObject3 = ((BaseMessageManager.AddMessageContext)localObject4).k;
        localObject4 = ((BaseMessageManager.AddMessageContext)localObject4).a;
        localObject3 = ((RecentUserProxy)localObject3).b(paramTroopTipsEntity.troopUin, 1);
        int i = ((MessageInfo)localObject2).a();
        if (i >= ((RecentUser)localObject3).msgType)
        {
          ((RecentUser)localObject3).msgType = i;
          ((RecentUser)localObject3).msg = TroopAioMsgNavigateUpdateMsgInfoUtil.a(paramQQAppInterface, paramTroopTipsEntity.troopUin, (MessageInfo)localObject2, ((RecentUser)localObject3).msg, (MessageRecord)localObject1, true);
          ((Map)localObject4).put(UinTypeUtil.a(paramTroopTipsEntity.troopUin, 1), localObject3);
        }
        ((ITroopListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).a(TroopObserver.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, null);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("insertAddHWTroopGrayTips:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("hw_troop", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (MessageForGrayTips)MessageRecordFactory.a(-1013);
    ((MessageForGrayTips)localObject1).frienduin = paramString;
    Object localObject2 = BaseApplicationImpl.getApplication().getResources();
    String str = ((Resources)localObject2).getString(2131895282);
    localObject2 = ((Resources)localObject2).getString(2131895278);
    ((MessageForGrayTips)localObject1).init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, str, NetConnInfoCenter.getServerTime(), -1013, 1, paramInt);
    ((MessageForGrayTips)localObject1).time = paramLong;
    paramString = new Bundle();
    paramString.putInt("key_action", 10);
    paramInt = str.indexOf((String)localObject2);
    ((MessageForGrayTips)localObject1).addHightlightItem(paramInt, ((String)localObject2).length() + paramInt, paramString);
    if (!MessageHandlerUtils.a(paramQQAppInterface, (MessageRecord)localObject1, false)) {
      paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, paramQQAppInterface.getCurrentAccountUin());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, HWTroopUtils.OnHomeworkTroopIdentityCheckListener paramOnHomeworkTroopIdentityCheckListener, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString1, paramString2, new HWTroopUtils.1(paramString1, paramString2, paramBoolean, paramQQAppInterface, paramOnHomeworkTroopIdentityCheckListener));
      return;
    }
    if (QLog.isColorLevel())
    {
      paramOnHomeworkTroopIdentityCheckListener = new StringBuilder();
      paramOnHomeworkTroopIdentityCheckListener.append("checkIdentity error. app null: ");
      if (paramQQAppInterface == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramOnHomeworkTroopIdentityCheckListener.append(String.valueOf(paramBoolean));
      paramOnHomeworkTroopIdentityCheckListener.append(", troopUin: ");
      paramQQAppInterface = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramQQAppInterface = "";
      }
      paramOnHomeworkTroopIdentityCheckListener.append(paramQQAppInterface);
      paramOnHomeworkTroopIdentityCheckListener.append(", memberUin: ");
      paramQQAppInterface = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramQQAppInterface = "";
      }
      paramOnHomeworkTroopIdentityCheckListener.append(paramQQAppInterface);
      QLog.i("hw_troop", 2, paramOnHomeworkTroopIdentityCheckListener.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      paramString1 = paramQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("homework_troop_config");
      localStringBuilder.append(paramQQAppInterface.getCurrentUin());
      paramString1.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean(paramString2, paramBoolean).commit();
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 332) && (paramInt != 333);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Object localObject1 = new File(paramString1);
      if (((File)localObject1).exists())
      {
        if (((File)localObject1).isDirectory()) {
          return false;
        }
        FileInfo localFileInfo = new FileInfo();
        localFileInfo.d(paramString2);
        localFileInfo.b(false);
        localFileInfo.f(((File)localObject1).getPath());
        localFileInfo.a(((File)localObject1).length());
        localFileInfo.b(((File)localObject1).lastModified());
        Object localObject2 = FileManagerUtil.a(localFileInfo);
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.b(((FileManagerEntity)localObject2).nSessionId);
        localForwardFileInfo.d(3);
        localForwardFileInfo.b(10000);
        localForwardFileInfo.a(localFileInfo.d());
        localForwardFileInfo.d(localFileInfo.e());
        localForwardFileInfo.d(localFileInfo.f());
        localObject1 = new Intent(paramContext, FileBrowserActivity.class);
        ((Intent)localObject1).putExtra("fileinfo", localForwardFileInfo);
        if ((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 1))
        {
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(localFileInfo);
          ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).addFileViewerLocalFiles((ArrayList)localObject2);
          ((Intent)localObject1).putExtra("clicked_file_hashcode", localFileInfo.hashCode());
        }
        ((Intent)localObject1).putExtra("selectMode", false);
        ((Intent)localObject1).putExtra("enableDelete", false);
        ((Intent)localObject1).putExtra("peerType", 0);
        ((Intent)localObject1).putExtra("busiType", 0);
        ((Intent)localObject1).putExtra("enterfrom", 0);
        ((Intent)localObject1).putExtra("sendprepare", -100);
        ((Intent)localObject1).putExtra("apautocreate", false);
        ((Intent)localObject1).putExtra("qlinkselect", false);
        ((Intent)localObject1).putExtra("max_select_size", 0);
        ((Intent)localObject1).putExtra("max_select_count", 20);
        ((Intent)localObject1).putExtra("rootEntrace", false);
        ((Intent)localObject1).setFlags(268435456);
        paramContext.startActivity((Intent)localObject1);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("openLocalFilePreview:");
          paramContext.append(paramString1);
          paramContext.append(",");
          paramContext.append(paramString2);
          QLog.d("hw_troop", 2, paramContext.toString());
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("hw_troop", 2, "openLocalFilePreview:", paramContext);
      }
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString1 = paramQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("homework_troop_config");
      localStringBuilder.append(paramQQAppInterface.getCurrentUin());
      return paramString1.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean(paramString2, false);
    }
    return false;
  }
  
  public static boolean a(TroopMemberInfo paramTroopMemberInfo)
  {
    return (paramTroopMemberInfo != null) && (((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).hasHomeworkTroopIdentity(paramTroopMemberInfo.level));
  }
  
  private static void b(HWTroopUtils.OnHomeworkTroopIdentityCheckListener paramOnHomeworkTroopIdentityCheckListener, int paramInt)
  {
    if (paramOnHomeworkTroopIdentityCheckListener == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramOnHomeworkTroopIdentityCheckListener.a(paramInt);
      return;
    }
    ThreadManager.getUIHandler().post(new HWTroopUtils.2(paramOnHomeworkTroopIdentityCheckListener, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.HWTroopUtils
 * JD-Core Version:    0.7.0.1
 */