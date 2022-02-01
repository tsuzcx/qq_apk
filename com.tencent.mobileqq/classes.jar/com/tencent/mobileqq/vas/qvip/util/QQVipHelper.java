package com.tencent.mobileqq.vas.qvip.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.hippy.qq.view.tkd.listview.ResourceUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.config.business.qvip.QVipPubAccountConfig;
import com.tencent.mobileqq.config.business.qvip.QVipPubAccountProocessor;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class QQVipHelper
{
  public static Intent a(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("qqvip_pubaccount_msg_list", a(paramQQAppInterface));
    return localIntent;
  }
  
  public static AppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
        if (!(localObject instanceof AppInterface)) {
          break label53;
        }
        return (AppInterface)localObject;
      }
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
    label53:
    return null;
  }
  
  public static ArrayList<QQVipMsgInfo> a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(AppConstants.QQ_VIP_UIN, 1008, 50);
    ArrayList localArrayList = new ArrayList();
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      int i = paramQQAppInterface.size() - 1;
      while (i >= 0)
      {
        Object localObject = (MessageRecord)paramQQAppInterface.get(i);
        if (AppConstants.QQ_VIP_UIN.equals(((MessageRecord)localObject).frienduin))
        {
          if (((localObject instanceof MessageForArkApp)) || ((localObject instanceof MessageForPubAccount)) || ((localObject instanceof MessageForStructing)))
          {
            localObject = QQVipMsgInfo.parseMessageRecord((MessageRecord)localObject);
            if ((localObject != null) && (((QQVipMsgInfo)localObject).msgType != 0)) {
              localArrayList.add(localObject);
            }
          }
          if (localArrayList.size() == 4) {
            return localArrayList;
          }
        }
        i -= 1;
      }
    }
    return localArrayList;
  }
  
  public static void a(int paramInt1, QQVipMsgInfo paramQQVipMsgInfo, int paramInt2)
  {
    if (paramQQVipMsgInfo == null) {}
    String str;
    do
    {
      return;
      str = "";
      if (!TextUtils.isEmpty(paramQQVipMsgInfo.advId)) {
        str = paramQQVipMsgInfo.advId;
      }
    } while (TextUtils.isEmpty(str));
    PublicAccountEventReport.a(paramInt1, paramInt2, str, paramQQVipMsgInfo.triggerInfo);
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(paramActivity, SplashActivity.class.getName());
      localIntent = AIOUtils.a(localIntent, new int[] { 1 });
      localIntent.putExtra("shouldreport", true);
      localIntent.putExtra("has_unread_msg", false);
      localIntent.putExtra("jump_from", 1);
      localIntent.setClass(paramActivity, ChatActivity.class);
      localIntent.putExtra("uin", AppConstants.QQ_VIP_UIN);
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", ResourceUtil.getString(2131695231));
      localIntent.putExtra("entrance", 1);
      localIntent.putExtra("aio_msg_source", 0);
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    int i = 0;
    String[] arrayOfString = new String[11];
    arrayOfString[0] = "OpenUrl";
    arrayOfString[1] = "NavigateTo";
    arrayOfString[2] = "SendMessage";
    arrayOfString[3] = "OpenView";
    arrayOfString[4] = "OpenVideo";
    arrayOfString[5] = "ChooseImage";
    arrayOfString[6] = "CloseView";
    arrayOfString[7] = "ShareView";
    arrayOfString[8] = "ShowShareMenu";
    arrayOfString[9] = "HideShareMenu";
    arrayOfString[10] = "PreviewImage";
    for (;;)
    {
      if ((i >= arrayOfString.length) || (arrayOfString[i].equals(paramString))) {
        if ((paramActivity instanceof PublicFragmentActivityForTool))
        {
          paramActivity = ((PublicFragmentActivityForTool)paramActivity).a();
          if ((paramActivity instanceof QQVipFeedWedFragment))
          {
            i = ((QQVipFeedWedFragment)paramActivity).a();
            paramActivity = ((QQVipFeedWedFragment)paramActivity).a();
            MobileReportManager.getInstance().reportAction("QQVipAccount", "1", "1", i + 1 + "", "", "1", 102, 1);
          }
        }
      }
      do
      {
        try
        {
          a(118, paramActivity, i);
          return;
        }
        catch (Throwable paramActivity)
        {
          paramActivity.printStackTrace();
        }
      } while (i == arrayOfString.length - 1);
      i += 1;
    }
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = a((QQAppInterface)a());
    PublicFragmentActivityForTool.b((Activity)paramContext, localIntent, QQVipFeedWedFragment.class, 10000);
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = (PublicAccountDataManager)((QQAppInterface)a()).getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      localObject = ((PublicAccountDataManager)localObject).b(AppConstants.QQ_VIP_UIN);
      if (localObject != null) {
        return ((AccountDetail)localObject).isRecvPush;
      }
      c(paramContext);
    }
    return false;
  }
  
  public static void b(Context paramContext)
  {
    PublicFragmentActivityForTool.b(paramContext, a((QQAppInterface)a()), QQVipFeedWedFragment.class);
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (QVipPubAccountProocessor.c() != null)
    {
      bool1 = bool2;
      if (QVipPubAccountProocessor.c().a().booleanValue())
      {
        bool1 = bool2;
        if (a(paramContext)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void c(Context paramContext)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)a();
    paramContext = new NewIntent(paramContext, ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    paramContext.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.5.5,3,5105");
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(AppConstants.QQ_VIP_UIN));
      label81:
      paramContext.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localGetPublicAccountDetailInfoRequest.version.set(1);
      paramContext.setObserver(new QQVipHelper.1(localQQAppInterface));
      localQQAppInterface.startServlet(paramContext);
      return;
    }
    catch (Exception localException)
    {
      break label81;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.util.QQVipHelper
 * JD-Core Version:    0.7.0.1
 */