package com.tencent.mobileqq.vas.qvip.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPubAccountConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPubAccountProocessor;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigGroupInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.RetInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QQVipHelper
{
  static BusinessObserver a = new QQVipHelper.1();
  
  public static Intent a(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("qqvip_pubaccount_msg_list", a(paramQQAppInterface));
    return localIntent;
  }
  
  public static AppInterface a()
  {
    Object localObject3 = BaseApplicationImpl.getApplication();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
      if ((localObject3 instanceof ToolAppRuntime))
      {
        localObject3 = ((AppRuntime)localObject3).getAppRuntime("modular_web");
        localObject1 = localObject2;
        if ((localObject3 instanceof AppInterface)) {
          return (AppInterface)localObject3;
        }
      }
      else
      {
        localObject1 = localObject2;
        if ((localObject3 instanceof QQAppInterface)) {
          localObject1 = (QQAppInterface)localObject3;
        }
      }
    }
    return localObject1;
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
        if (a(paramQQAppInterface, localArrayList, i)) {
          return localArrayList;
        }
        i -= 1;
      }
    }
    return localArrayList;
  }
  
  public static void a(int paramInt1, QQVipMsgInfo paramQQVipMsgInfo, int paramInt2)
  {
    if (paramQQVipMsgInfo == null) {
      return;
    }
    String str;
    if (!TextUtils.isEmpty(paramQQVipMsgInfo.mAdvId)) {
      str = paramQQVipMsgInfo.mAdvId;
    } else {
      str = "";
    }
    if (TextUtils.isEmpty(str)) {
      return;
    }
    PublicAccountEventReport.a(paramInt1, paramInt2, str, paramQQVipMsgInfo.mTriggerInfo);
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
      localIntent.putExtra("uinname", ResourceUtil.getString(2131695227));
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
    Object localObject = new String[11];
    int i = 0;
    localObject[0] = "OpenUrl";
    localObject[1] = "NavigateTo";
    localObject[2] = "SendMessage";
    localObject[3] = "OpenView";
    localObject[4] = "OpenVideo";
    localObject[5] = "ChooseImage";
    localObject[6] = "CloseView";
    localObject[7] = "ShareView";
    localObject[8] = "ShowShareMenu";
    localObject[9] = "HideShareMenu";
    localObject[10] = "PreviewImage";
    while ((i < localObject.length) && (!localObject[i].equals(paramString)))
    {
      if (i == localObject.length - 1) {
        return;
      }
      i += 1;
    }
    if ((paramActivity instanceof PublicFragmentActivityForTool))
    {
      paramActivity = ((PublicFragmentActivityForTool)paramActivity).a();
      if ((paramActivity instanceof QQVipFeedWedFragment))
      {
        paramActivity = (QQVipFeedWedFragment)paramActivity;
        i = paramActivity.a();
        paramActivity = paramActivity.a();
        paramString = MobileReportManager.getInstance();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i + 1);
        ((StringBuilder)localObject).append("");
        paramString.reportAction("QQVipAccount", "1", "1", ((StringBuilder)localObject).toString(), "", "1", 102, 1);
        try
        {
          a(118, paramActivity, i);
          return;
        }
        catch (Throwable paramActivity)
        {
          paramActivity.printStackTrace();
        }
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = a((QQAppInterface)a());
    PublicFragmentActivityForTool.b((Activity)paramContext, localIntent, QQVipFeedWedFragment.class, 10000);
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = (IPublicAccountDataManager)((QQAppInterface)a()).getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = ((IPublicAccountDataManager)localObject).findAccountDetailInfoCache(AppConstants.QQ_VIP_UIN);
      if (localObject != null) {
        return ((IPublicAccountDetail)localObject).isRecvPush();
      }
      c(paramContext);
    }
    return false;
  }
  
  private static boolean a(List<MessageRecord> paramList, ArrayList<QQVipMsgInfo> paramArrayList, int paramInt)
  {
    paramList = (MessageRecord)paramList.get(paramInt);
    if (AppConstants.QQ_VIP_UIN.equals(paramList.frienduin))
    {
      if (((paramList instanceof MessageForArkApp)) || ((paramList instanceof MessageForPubAccount)) || ((paramList instanceof MessageForStructing)))
      {
        paramList = QQVipMsgInfo.parseMessageRecord(paramList);
        if ((paramList != null) && (paramList.mMsgType != 0)) {
          paramArrayList.add(paramList);
        }
      }
      if (paramArrayList.size() == 4) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfByte, oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse1)
  {
    if (paramGetPublicAccountDetailInfoResponse == null) {
      return false;
    }
    if (a(paramArrayOfByte, paramGetPublicAccountDetailInfoResponse, new oidb_sso.OIDBSSOPkg())) {
      return false;
    }
    if (paramGetPublicAccountDetailInfoResponse.ret_info.has())
    {
      paramArrayOfByte = new mobileqq_mp.RetInfo();
      paramArrayOfByte.ret_code.set(((oidb_cmd0xcf8.RetInfo)paramGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get());
      paramArrayOfByte.err_info.set(((oidb_cmd0xcf8.RetInfo)paramGetPublicAccountDetailInfoResponse.ret_info.get()).err_info.get());
      paramGetPublicAccountDetailInfoResponse1.ret_info.set(paramArrayOfByte);
    }
    paramGetPublicAccountDetailInfoResponse1.seqno.set(paramGetPublicAccountDetailInfoResponse.seqno.get());
    paramGetPublicAccountDetailInfoResponse1.uin.set((int)paramGetPublicAccountDetailInfoResponse.luin.get());
    paramGetPublicAccountDetailInfoResponse1.name.set(paramGetPublicAccountDetailInfoResponse.name.get());
    paramGetPublicAccountDetailInfoResponse1.display_number.set(paramGetPublicAccountDetailInfoResponse.display_number.get());
    paramGetPublicAccountDetailInfoResponse1.summary.set(paramGetPublicAccountDetailInfoResponse.summary.get());
    paramGetPublicAccountDetailInfoResponse1.is_recv_msg.set(paramGetPublicAccountDetailInfoResponse.is_recv_msg.get());
    paramGetPublicAccountDetailInfoResponse1.is_recv_push.set(paramGetPublicAccountDetailInfoResponse.is_recv_push.get());
    paramGetPublicAccountDetailInfoResponse1.certified_grade.set(paramGetPublicAccountDetailInfoResponse.certified_grade.get());
    Iterator localIterator;
    Object localObject;
    ArrayList localArrayList;
    oidb_cmd0xcf8.ConfigInfo localConfigInfo;
    mobileqq_mp.ConfigInfo localConfigInfo1;
    if (paramGetPublicAccountDetailInfoResponse.config_group_info.has())
    {
      paramArrayOfByte = new ArrayList();
      localIterator = paramGetPublicAccountDetailInfoResponse.config_group_info.get().iterator();
      while (localIterator.hasNext())
      {
        localObject = (oidb_cmd0xcf8.ConfigGroupInfo)localIterator.next();
        localArrayList = new ArrayList();
        localObject = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject).config_info.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject).next();
          localConfigInfo1 = new mobileqq_mp.ConfigInfo();
          localConfigInfo1.type.set(localConfigInfo.type.get());
          localConfigInfo1.title.set(localConfigInfo.title.get());
          localConfigInfo1.content.set(localConfigInfo.content.get());
          localConfigInfo1.event_id.set(localConfigInfo.event_id.get());
          localConfigInfo1.url.set(localConfigInfo.url.get());
          localConfigInfo1.auth_type.set(localConfigInfo.auth_type.get());
          localConfigInfo1.state.set(localConfigInfo.state.get());
          localConfigInfo1.confirm_flag.set(localConfigInfo.confirm_flag.get());
          localConfigInfo1.confirm_tips.set(localConfigInfo.confirm_tips.get());
          localConfigInfo1.state_id.set(localConfigInfo.state_id.get());
          localArrayList.add(localConfigInfo1);
        }
        localObject = new mobileqq_mp.ConfigGroupInfo();
        ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.set(localArrayList);
        paramArrayOfByte.add(localObject);
      }
      paramGetPublicAccountDetailInfoResponse1.config_group_info.set(paramArrayOfByte);
    }
    paramGetPublicAccountDetailInfoResponse1.is_show_share_button.set(paramGetPublicAccountDetailInfoResponse.is_show_share_button.get());
    paramGetPublicAccountDetailInfoResponse1.is_show_follow_button.set(paramGetPublicAccountDetailInfoResponse.is_show_follow_button.get());
    paramGetPublicAccountDetailInfoResponse1.follow_type.set(paramGetPublicAccountDetailInfoResponse.follow_type.get());
    paramGetPublicAccountDetailInfoResponse1.is_sync_lbs.set(paramGetPublicAccountDetailInfoResponse.is_sync_lbs.get());
    paramGetPublicAccountDetailInfoResponse1.group_id.set(paramGetPublicAccountDetailInfoResponse.group_id.get());
    paramGetPublicAccountDetailInfoResponse1.show_flag.set(paramGetPublicAccountDetailInfoResponse.show_flag.get());
    paramGetPublicAccountDetailInfoResponse1.account_flag.set(paramGetPublicAccountDetailInfoResponse.account_flag.get());
    paramGetPublicAccountDetailInfoResponse1.luin.set(paramGetPublicAccountDetailInfoResponse.luin.get());
    paramGetPublicAccountDetailInfoResponse1.config_background_color.set(paramGetPublicAccountDetailInfoResponse.config_background_color.get());
    paramGetPublicAccountDetailInfoResponse1.config_background_img.set(paramGetPublicAccountDetailInfoResponse.config_background_img.get());
    if (paramGetPublicAccountDetailInfoResponse.config_group_info_new.has())
    {
      paramArrayOfByte = new ArrayList();
      localIterator = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get().iterator();
      while (localIterator.hasNext())
      {
        localObject = (oidb_cmd0xcf8.ConfigGroupInfo)localIterator.next();
        localArrayList = new ArrayList();
        localObject = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject).config_info.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject).next();
          localConfigInfo1 = new mobileqq_mp.ConfigInfo();
          localConfigInfo1.type.set(localConfigInfo.type.get());
          localConfigInfo1.title.set(localConfigInfo.title.get());
          localConfigInfo1.content.set(localConfigInfo.content.get());
          localConfigInfo1.event_id.set(localConfigInfo.event_id.get());
          localConfigInfo1.url.set(localConfigInfo.url.get());
          localConfigInfo1.auth_type.set(localConfigInfo.auth_type.get());
          localConfigInfo1.state.set(localConfigInfo.state.get());
          localConfigInfo1.confirm_flag.set(localConfigInfo.confirm_flag.get());
          localConfigInfo1.confirm_tips.set(localConfigInfo.confirm_tips.get());
          localConfigInfo1.state_id.set(localConfigInfo.state_id.get());
          localArrayList.add(localConfigInfo1);
        }
        localObject = new mobileqq_mp.ConfigGroupInfo();
        ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.set(localArrayList);
        paramArrayOfByte.add(localObject);
      }
      paramGetPublicAccountDetailInfoResponse1.config_group_info_new.set(paramArrayOfByte);
    }
    paramGetPublicAccountDetailInfoResponse1.certified_description.set(paramGetPublicAccountDetailInfoResponse.certified_description.get());
    paramGetPublicAccountDetailInfoResponse1.unified_account_descrpition.set(paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.get());
    paramGetPublicAccountDetailInfoResponse1.account_flag2.set(paramGetPublicAccountDetailInfoResponse.account_flag2.get());
    return true;
  }
  
  private static boolean a(byte[] paramArrayOfByte, oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)paramOIDBSSOPkg.mergeFrom(paramArrayOfByte);
      int i = -1;
      if (paramArrayOfByte.uint32_result.has())
      {
        int j = paramArrayOfByte.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          paramOIDBSSOPkg = new StringBuilder();
          paramOIDBSSOPkg.append("handle OidbSvc.0xcf8|OIDBSSOPke.result=");
          paramOIDBSSOPkg.append(j);
          QLog.i("QQVipHelper", 2, paramOIDBSSOPkg.toString());
          i = j;
        }
      }
      if ((i == 0) && (paramArrayOfByte.bytes_bodybuffer.has()) && (paramArrayOfByte.bytes_bodybuffer.get() != null))
      {
        paramGetPublicAccountDetailInfoResponse.mergeFrom(paramArrayOfByte.bytes_bodybuffer.get().toByteArray());
        return false;
      }
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.w("QQVipHelper", 4, paramArrayOfByte.getMessage(), paramArrayOfByte);
      return true;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.w("QQVipHelper", 4, paramArrayOfByte.getMessage(), paramArrayOfByte);
    }
    return true;
  }
  
  public static void b(Context paramContext)
  {
    PublicFragmentActivityForTool.b(paramContext, a((QQAppInterface)a()), QQVipFeedWedFragment.class);
  }
  
  public static boolean b(Context paramContext)
  {
    QVipPubAccountConfig localQVipPubAccountConfig = QVipPubAccountProocessor.c();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localQVipPubAccountConfig != null)
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
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.7.0,3,5295");
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(AppConstants.QQ_VIP_UIN));
      label81:
      paramContext.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localGetPublicAccountDetailInfoRequest.version.set(1);
      paramContext.setObserver(a);
      localQQAppInterface.startServlet(paramContext);
      return;
    }
    catch (Exception localException)
    {
      break label81;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.util.QQVipHelper
 * JD-Core Version:    0.7.0.1
 */