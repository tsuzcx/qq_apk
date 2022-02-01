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
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.qroute.QRoute;
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
  private static String c = "ForwardMultServerShare";
  protected Bundle a;
  protected List<ResultRecord> b;
  private final MqqHandler d = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private boolean e = false;
  private long f = -1L;
  private Activity g;
  private QQAppInterface h;
  private AbsShareMsg i;
  private ForwardDialogMgr j;
  private OpenSdkShareModel k;
  
  ForwardMultServerShare(Bundle paramBundle)
  {
    this.a = paramBundle;
    this.k = ((OpenSdkShareModel)paramBundle.getParcelable("KEY_MINI_PROGRAM_SHARE_OBJ"));
  }
  
  private ResultRecord a(long paramLong)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (Long.toString(paramLong).equals(localResultRecord.uin)) {
        return localResultRecord;
      }
    }
    QLog.e(c, 1, "recvUin not found");
    return null;
  }
  
  private oidb_cmd0xb77.ImageInfo a(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null) {
      return null;
    }
    if (!(paramSendResult.l instanceof int[])) {
      return null;
    }
    int[] arrayOfInt = (int[])paramSendResult.l;
    if (arrayOfInt.length != 5) {
      return null;
    }
    oidb_cmd0xb77.ImageInfo localImageInfo = new oidb_cmd0xb77.ImageInfo();
    localImageInfo.md5.set(paramSendResult.g);
    localImageInfo.uuid.set(paramSendResult.f);
    localImageInfo.file_size.set(arrayOfInt[0]);
    localImageInfo.img_type.set(arrayOfInt[1]);
    localImageInfo.width.set(arrayOfInt[2]);
    localImageInfo.height.set(arrayOfInt[3]);
    localImageInfo.original.set(arrayOfInt[4]);
    localImageInfo.file_id.set((int)paramSendResult.h);
    return localImageInfo;
  }
  
  private oidb_cmd0xdc2.ReqBody a(String paramString1, String paramString2, Map<ResultRecord, UpCallBack.SendResult> paramMap)
  {
    oidb_cmd0xdc2.ReqBody localReqBody = new oidb_cmd0xdc2.ReqBody();
    localReqBody.msg_body.set(ForwardShareByServerHelper.a(this.a, paramString1, paramString2, null));
    paramString1 = new ArrayList();
    paramString2 = this.b.iterator();
    while (paramString2.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)paramString2.next();
      oidb_cmd0xdc2.BatchSendReq localBatchSendReq = new oidb_cmd0xdc2.BatchSendReq();
      localBatchSendReq.recv_uin.set(ForwardUtils.a(localResultRecord.uin));
      if (localResultRecord.uinType == 0)
      {
        localBatchSendReq.send_type.set(0);
      }
      else if (localResultRecord.uinType == 1)
      {
        localBatchSendReq.send_type.set(1);
      }
      else if (localResultRecord.uinType == 3000)
      {
        localBatchSendReq.send_type.set(2);
      }
      else if (localResultRecord.uinType == 10014)
      {
        localBatchSendReq.send_type.set(3);
        long l = ForwardUtils.a(localResultRecord.guildId);
        localBatchSendReq.recv_guild_id.set(l);
      }
      a(paramMap, localResultRecord, localBatchSendReq);
      paramString1.add(localBatchSendReq);
    }
    localReqBody.batch_send_req.set(paramString1);
    return localReqBody;
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
          QLog.d(c, 2, "buildResult SHARE_ERROR_NOT_FRIEND");
        }
        paramIntent.putExtra("sdk_mult_share_result_code", 901503);
        localObject1 = ((oidb_cmd0xdc2.BatchSendRsp)localObject1).rsp_body.wording.get();
        paramList = (List<oidb_cmd0xdc2.BatchSendRsp>)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramList = ForwardShareByServerHelper.a;
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
        QLog.d(c, 2, new Object[] { "rsp.recv_uin=", ((oidb_cmd0xdc2.BatchSendRsp)localObject2).recv_uin, ", rsp.err_msg=", ((oidb_cmd0xdc2.BatchSendRsp)localObject2).err_msg, ", rsp.err_code=", ((oidb_cmd0xdc2.BatchSendRsp)localObject2).err_code });
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
    if (((ArrayList)localObject1).size() == this.b.size())
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
    ForwardShareByServerHelper.a(this.k, this.a, paramString1.msg_body);
    paramString2 = BaseApplicationImpl.getApplication().getRuntime();
    if (paramString2 == null)
    {
      QLog.e(c, 1, "notifyNormalSendMessage send runtime = null");
      g();
      return;
    }
    this.f = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putLong("0xdc2_9_sendTime", this.f);
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "notifyNormalSendMessage sendOIDBRequest");
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
      QLog.e(c, 1, "notifyImageSendMessage runtime = null ");
      g();
      return;
    }
    Bundle localBundle = new Bundle();
    this.f = System.currentTimeMillis();
    localBundle.putLong("0xdc2_9_sendTime", this.f);
    QLog.i(c, 1, "notifyImageSendMessage OIDBRequest ");
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
  
  private void b(List<oidb_cmd0xdc2.BatchSendRsp> paramList)
  {
    if (this.a.getInt("uintype") == 10014)
    {
      ForwardUtils.a(this.b, paramList, this.a.getString("share_comment_message_for_server"));
      return;
    }
    ForwardUtils.a(this.b, paramList, this.g, this.a.getString("share_comment_message_for_server"));
  }
  
  private void c(List<oidb_cmd0xdc2.BatchSendRsp> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "onShareEnd");
    }
    this.d.removeMessages(94);
    this.d.removeMessages(93);
    Intent localIntent;
    if (c()) {
      localIntent = b();
    } else {
      localIntent = a();
    }
    localIntent.putExtra("k_from_login", true);
    localIntent.putExtra("sdk_mult_share_app_name", this.a.getString("app_name"));
    localIntent.putExtra("sdk_mult_share_source_app_id", this.i.mSourceAppid);
    localIntent.putExtra("sdk_mult_share_msg_service_id", this.i.mMsgServiceID);
    localIntent.putExtra("sdk_mult_share", true);
    a(localIntent, paramList);
    paramList = this.a;
    int m = -1;
    if (paramList.getInt("forward_type", -1) == 11)
    {
      long l = this.a.getLong("req_share_id");
      ForwardUtils.a(this.g, this.a.getString("pkg_name"), localIntent, l);
    }
    if (c()) {
      m = 10014;
    }
    ForwardUtils.a(m, localIntent, this.a);
    this.g.startActivity(localIntent);
    this.j.b(this.g);
    ForwardUtils.a(this.g);
  }
  
  private void e()
  {
    MqqHandler localMqqHandler = this.d;
    localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(93), 500L);
    if ((this.i instanceof StructMsgForImageShare))
    {
      h();
      return;
    }
    f();
  }
  
  private void f()
  {
    QLog.d(c, 1, "-->ForwardMultServerShare requestNormalShare");
    WeakReference localWeakReference = new WeakReference(new ForwardMultServerShare.1(this));
    int m = this.a.getInt("uintype");
    String str1 = this.a.getString("uin");
    String str2 = this.a.getString("troop_uin");
    ForwardStatisticsReporter.a("KEY_STAGE_2_SEND_MSG_BY_SERVER");
    AbsShareMsg.sendSdkShareMessageByServer(this.h, this.i, str1, m, str2, (UpCallBack)localWeakReference.get());
  }
  
  private void g()
  {
    QLog.e(c, 1, "onError");
    this.d.removeMessages(94);
    this.d.removeMessages(93);
    this.j.b(this.g);
    ForwardUtils.a(this.g, this.a, ForwardShareByServerHelper.a);
  }
  
  private void h()
  {
    QLog.d(c, 1, "-->ForwardMultServerShare requestImageShare");
    HashMap localHashMap = new HashMap();
    ForwardStatisticsReporter.a("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ThreadManager.post(new ForwardMultServerShare.2(this, (ResultRecord)localIterator.next(), localHashMap), 8, null, false);
    }
  }
  
  private void i()
  {
    QLog.d(c, 1, "reportException");
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    List localList = this.b;
    int m;
    if (localList == null) {
      m = 0;
    } else {
      m = localList.size();
    }
    ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { Integer.toString(m) });
  }
  
  protected Intent a()
  {
    Intent localIntent = new Intent(this.g, SplashActivity.class);
    if (!this.a.getBoolean("share_from_aio", false))
    {
      localIntent = AIOUtils.a(localIntent, new int[] { 2 });
      this.a.remove("share_from_aio");
    }
    else
    {
      localIntent = AIOUtils.a(localIntent, null);
      localIntent.putExtra("share_from_aio", true);
    }
    localIntent.putExtra("open_chatfragment", false);
    localIntent.putExtra("fragment_id", 1);
    return localIntent;
  }
  
  void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.h = paramQQAppInterface;
    this.g = paramActivity;
    this.j = new ForwardDialogMgr();
  }
  
  void a(List<ResultRecord> paramList)
  {
    this.b = paramList;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (this.h == null)
      {
        QLog.e(c, 1, " sendArkWithStruct error null == mApp");
        i();
        return;
      }
      paramList = this.a;
      if (paramList == null)
      {
        QLog.e(c, 1, " sendArkWithStruct error null == mExtraData");
        i();
        return;
      }
      if (this.g == null)
      {
        QLog.e(c, 1, " sendArkWithStruct error null == mActivity");
        i();
        return;
      }
      paramList = StructMsgFactory.a(paramList);
      if (!(paramList instanceof AbsShareMsg))
      {
        QLog.e(c, 1, " sendArkWithStruct error !(structMsg instanceof AbsShareMsg)");
        i();
        return;
      }
      this.i = ((AbsShareMsg)paramList);
      if (!NetworkUtil.isNetSupport(this.g))
      {
        QLog.d(c, 1, "sendArkWithStruct no network");
        ForwardUtils.a(this.g, this.a, HardCodeUtil.a(2131902786));
        return;
      }
      e();
      return;
    }
    QLog.e(c, 1, "null == multiTargetWithoutDataLine || multiTargetWithoutDataLine.isEmpty()");
    i();
  }
  
  protected Intent b()
  {
    if (!this.a.getBoolean("share_from_aio", false)) {
      this.a.remove("share_from_aio");
    } else {
      this.a.putBoolean("share_from_aio", true);
    }
    LaunchGuildChatPieParam localLaunchGuildChatPieParam = new LaunchGuildChatPieParam().a(((ResultRecord)this.b.get(0)).guildId).b(((ResultRecord)this.b.get(0)).uin).a(null).b(false).c(true).d(true).b();
    return ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(this.g, localLaunchGuildChatPieParam);
  }
  
  protected boolean c()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return false;
      }
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((ResultRecord)((Iterator)localObject).next()).uinType != 10014) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 93)
    {
      if (m == 94)
      {
        QLog.d(c, 1, "MSG_SDK_SHARE_REQUEST_TIMEOUT_STATUS");
        this.e = true;
        if (!this.g.isFinishing())
        {
          this.j.b(this.g);
          ForwardUtils.a(this.g, this.a, HardCodeUtil.a(2131902785));
        }
        else
        {
          i();
        }
      }
    }
    else
    {
      QLog.d(c, 1, "MSG_SDK_SHARE_REQUEST_LOADING_STATUS");
      this.j.a(this.g);
      paramMessage = this.d;
      paramMessage.sendMessageDelayed(paramMessage.obtainMessage(94), 10000L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMultServerShare
 * JD-Core Version:    0.7.0.1
 */