package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.BatchSendRsp;>;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ImageInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RspBody;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.BatchSendReq;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.BatchSendRsp;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.ReqBody;

public class ForwardMultServerShare
  implements Handler.Callback
{
  private static String jdField_a_of_type_JavaLangString = "ForwardMultServerShare";
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ForwardDialogMgr jdField_a_of_type_ComTencentMobileqqForwardForwardDialogMgr;
  private OpenSdkShareModel jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel;
  private AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  private List<ResultRecord> jdField_a_of_type_JavaUtilList;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean = false;
  
  ForwardMultServerShare(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel = ((OpenSdkShareModel)paramBundle.getParcelable("KEY_MINI_PROGRAM_SHARE_OBJ"));
  }
  
  private ResultRecord a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (Long.toString(paramLong).equals(localResultRecord.uin)) {
        return localResultRecord;
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "recvUin not found");
    return null;
  }
  
  private oidb_cmd0xb77.ImageInfo a(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null) {
      return null;
    }
    if (!(paramSendResult.a instanceof int[])) {
      return null;
    }
    int[] arrayOfInt = (int[])paramSendResult.a;
    if (arrayOfInt.length != 5) {
      return null;
    }
    oidb_cmd0xb77.ImageInfo localImageInfo = new oidb_cmd0xb77.ImageInfo();
    localImageInfo.md5.set(paramSendResult.d);
    localImageInfo.uuid.set(paramSendResult.c);
    localImageInfo.file_size.set(arrayOfInt[0]);
    localImageInfo.img_type.set(arrayOfInt[1]);
    localImageInfo.width.set(arrayOfInt[2]);
    localImageInfo.height.set(arrayOfInt[3]);
    localImageInfo.original.set(arrayOfInt[4]);
    localImageInfo.file_id.set((int)paramSendResult.b);
    return localImageInfo;
  }
  
  private oidb_cmd0xdc2.ReqBody a(String paramString1, String paramString2, Map<ResultRecord, UpCallBack.SendResult> paramMap)
  {
    oidb_cmd0xdc2.ReqBody localReqBody = new oidb_cmd0xdc2.ReqBody();
    localReqBody.msg_body.set(ForwardShareByServerHelper.a(this.jdField_a_of_type_AndroidOsBundle, paramString1, paramString2, null));
    paramString1 = new ArrayList();
    paramString2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString2.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)paramString2.next();
      oidb_cmd0xdc2.BatchSendReq localBatchSendReq = new oidb_cmd0xdc2.BatchSendReq();
      localBatchSendReq.recv_uin.set(ForwardUtils.a(localResultRecord.uin));
      if (localResultRecord.uinType == 0) {
        localBatchSendReq.send_type.set(0);
      } else if (localResultRecord.uinType == 1) {
        localBatchSendReq.send_type.set(1);
      } else if (localResultRecord.uinType == 3000) {
        localBatchSendReq.send_type.set(2);
      }
      a(paramMap, localResultRecord, localBatchSendReq);
      paramString1.add(localBatchSendReq);
    }
    localReqBody.batch_send_req.set(paramString1);
    return localReqBody;
  }
  
  private void a()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(93), 500L);
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
    {
      d();
      return;
    }
    b();
  }
  
  private void a(Intent paramIntent, List<oidb_cmd0xdc2.BatchSendRsp> paramList)
  {
    paramIntent.putExtra("sdk_mult_share_total_count", paramList.size());
    if (paramList.size() == 1)
    {
      localObject1 = (oidb_cmd0xdc2.BatchSendRsp)paramList.get(0);
      if (((oidb_cmd0xdc2.BatchSendRsp)localObject1).err_code.get() == 901503)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "buildResult SHARE_ERROR_NOT_FRIEND");
        }
        paramIntent.putExtra("sdk_mult_share_result_code", 901503);
        localObject1 = ((oidb_cmd0xdc2.BatchSendRsp)localObject1).rsp_body.wording.get();
        paramList = (List<oidb_cmd0xdc2.BatchSendRsp>)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramList = ForwardShareByServerHelper.jdField_a_of_type_JavaLangString;
        }
        paramIntent.putExtra("sdk_mult_share_error_wording", paramList);
        return;
      }
    }
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (oidb_cmd0xdc2.BatchSendRsp)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "rsp.recv_uin=", ((oidb_cmd0xdc2.BatchSendRsp)localObject2).recv_uin, ", rsp.err_msg=", ((oidb_cmd0xdc2.BatchSendRsp)localObject2).err_msg, ", rsp.err_code=", ((oidb_cmd0xdc2.BatchSendRsp)localObject2).err_code });
      }
      if (((oidb_cmd0xdc2.BatchSendRsp)localObject2).err_code.get() != 0)
      {
        localObject2 = a(((oidb_cmd0xdc2.BatchSendRsp)localObject2).recv_uin.get());
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
    }
    if (((ArrayList)localObject1).isEmpty())
    {
      paramIntent.putExtra("sdk_mult_share_result_code", 0);
      return;
    }
    if (((ArrayList)localObject1).size() == this.jdField_a_of_type_JavaUtilList.size())
    {
      paramIntent.putExtra("sdk_mult_share_result_code", 2);
      return;
    }
    paramIntent.putExtra("sdk_mult_share_result_code", 1);
    paramIntent.putParcelableArrayListExtra("sdk_mult_share_fail_record", (ArrayList)localObject1);
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2, null);
    ForwardShareByServerHelper.a(this.jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel, this.jdField_a_of_type_AndroidOsBundle, paramString1.msg_body);
    paramString2 = BaseApplicationImpl.getApplication().getRuntime();
    if (paramString2 == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "notifyNormalSendMessage send runtime = null");
      c();
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putLong("0xdc2_9_sendTime", this.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "notifyNormalSendMessage sendOIDBRequest");
    }
    ForwardStatisticsReporter.a("KEY_STAGE_2_NORMAL_DC2");
    ProtoUtils.a(paramString2, new ForwardMultServerShare.4(this), paramString1.toByteArray(), "OidbSvc.0xdc2_9", 3522, 9, localBundle, 0L);
  }
  
  private void a(Map<ResultRecord, UpCallBack.SendResult> paramMap)
  {
    paramMap = a(null, null, paramMap);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "notifyImageSendMessage runtime = null ");
      c();
      return;
    }
    Bundle localBundle = new Bundle();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    localBundle.putLong("0xdc2_9_sendTime", this.jdField_a_of_type_Long);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "notifyImageSendMessage OIDBRequest ");
    ForwardStatisticsReporter.a("KEY_STAGE_2_IMAGE_DC2");
    ProtoUtils.a(localAppRuntime, new ForwardMultServerShare.3(this), paramMap.toByteArray(), "OidbSvc.0xdc2_9", 3522, 9, localBundle, 0L);
  }
  
  private void a(Map<ResultRecord, UpCallBack.SendResult> paramMap, ResultRecord paramResultRecord, oidb_cmd0xdc2.BatchSendReq paramBatchSendReq)
  {
    if (paramMap != null)
    {
      paramMap = a((UpCallBack.SendResult)paramMap.get(paramResultRecord));
      if (paramMap != null) {
        paramBatchSendReq.image_info.set(paramMap);
      }
    }
  }
  
  private void b()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "-->ForwardMultServerShare requestNormalShare");
    WeakReference localWeakReference = new WeakReference(new ForwardMultServerShare.1(this));
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    ForwardStatisticsReporter.a("KEY_STAGE_2_SEND_MSG_BY_SERVER");
    AbsShareMsg.sendSdkShareMessageByServer(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg, str1, i, str2, (UpCallBack)localWeakReference.get());
  }
  
  private void b(List<oidb_cmd0xdc2.BatchSendRsp> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onShareEnd");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(94);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(93);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    localIntent.putExtra("k_from_login", true);
    localIntent.putExtra("sdk_mult_share_app_name", this.jdField_a_of_type_AndroidOsBundle.getString("app_name"));
    localIntent.putExtra("sdk_mult_share_source_app_id", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceAppid);
    localIntent.putExtra("sdk_mult_share_msg_service_id", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID);
    localIntent.putExtra("sdk_mult_share", true);
    a(localIntent, paramList);
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("forward_type", -1) == 11)
    {
      long l = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
      ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name"), localIntent, l);
    }
    if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("share_from_aio", false))
    {
      paramList = AIOUtils.a(localIntent, new int[] { 2 });
      this.jdField_a_of_type_AndroidOsBundle.remove("share_from_aio");
    }
    else
    {
      paramList = AIOUtils.a(localIntent, null);
      paramList.putExtra("share_from_aio", true);
    }
    paramList.putExtra("open_chatfragment", false);
    paramList.putExtra("fragment_id", 1);
    paramList.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramList);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardDialogMgr.b(this.jdField_a_of_type_AndroidAppActivity);
    ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void c()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onError");
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(94);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(93);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardDialogMgr.b(this.jdField_a_of_type_AndroidAppActivity);
    ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, ForwardShareByServerHelper.jdField_a_of_type_JavaLangString);
  }
  
  private void d()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "-->ForwardMultServerShare requestImageShare");
    HashMap localHashMap = new HashMap();
    ForwardStatisticsReporter.a("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ThreadManager.post(new ForwardMultServerShare.2(this, (ResultRecord)localIterator.next(), localHashMap), 8, null, false);
    }
  }
  
  private void e()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "reportException");
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { Integer.toString(i) });
  }
  
  void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardDialogMgr = new ForwardDialogMgr();
  }
  
  void a(List<ResultRecord> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, " sendArkWithStruct error null == mApp");
        e();
        return;
      }
      paramList = this.jdField_a_of_type_AndroidOsBundle;
      if (paramList == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, " sendArkWithStruct error null == mExtraData");
        e();
        return;
      }
      if (this.jdField_a_of_type_AndroidAppActivity == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, " sendArkWithStruct error null == mActivity");
        e();
        return;
      }
      paramList = StructMsgFactory.a(paramList);
      if (!(paramList instanceof AbsShareMsg))
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, " sendArkWithStruct error !(structMsg instanceof AbsShareMsg)");
        e();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)paramList);
      if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "sendArkWithStruct no network");
        ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, HardCodeUtil.a(2131704894));
        return;
      }
      a();
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "null == multiTargetWithoutDataLine || multiTargetWithoutDataLine.isEmpty()");
    e();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 93)
    {
      if (i == 94)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "MSG_SDK_SHARE_REQUEST_TIMEOUT_STATUS");
        this.jdField_a_of_type_Boolean = true;
        if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
        {
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardDialogMgr.b(this.jdField_a_of_type_AndroidAppActivity);
          ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, HardCodeUtil.a(2131704893));
        }
        else
        {
          e();
        }
      }
    }
    else
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "MSG_SDK_SHARE_REQUEST_LOADING_STATUS");
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardDialogMgr.a(this.jdField_a_of_type_AndroidAppActivity);
      paramMessage = this.jdField_a_of_type_MqqOsMqqHandler;
      paramMessage.sendMessageDelayed(paramMessage.obtainMessage(94), 10000L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMultServerShare
 * JD-Core Version:    0.7.0.1
 */