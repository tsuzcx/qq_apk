package com.tencent.mobileqq.nearby;

import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x938.cmd0x938.CommParamReq;
import tencent.im.oidb.cmd0x938.cmd0x938.ReqBody;
import tencent.im.oidb.oidb_0x8da.oidb_0x8da.ReqBody;
import tencent.im.oidb.oidb_0x8da.oidb_0x8da.UserInfo;

public class NearbyFaceScoreManager
  implements INearbyFaceScoreManager, Manager
{
  AppInterface a;
  
  public NearbyFaceScoreManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public void a(long paramLong, FaceScoreCallBack paramFaceScoreCallBack)
  {
    oidb_0x8da.ReqBody localReqBody = new oidb_0x8da.ReqBody();
    Object localObject = new oidb_0x8da.UserInfo();
    ((oidb_0x8da.UserInfo)localObject).uint64_uin.set(paramLong);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localReqBody.rpt_msg_user_info.set(localArrayList);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTinyIdByUin, uin=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.e("Q..troop.faceScore", 2, ((StringBuilder)localObject).toString());
    }
    ProtoUtils.a(this.a, new NearbyFaceScoreManager.3(this, paramFaceScoreCallBack, paramLong), localReqBody.toByteArray(), "OidbSvc.0x8da_1", 2266, 0, null, 0L);
  }
  
  public void a(FaceScoreCallBack paramFaceScoreCallBack)
  {
    cmd0x938.ReqBody localReqBody = new cmd0x938.ReqBody();
    cmd0x938.CommParamReq localCommParamReq = new cmd0x938.CommParamReq();
    localCommParamReq.bytes_version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
    localCommParamReq.uint32_platform.set(1);
    localReqBody.msg_comm_param.set(localCommParamReq);
    if (QLog.isColorLevel()) {
      QLog.e("Q..troop.faceScore", 2, "fetchGrayAbility");
    }
    ProtoUtils.a(this.a, new NearbyFaceScoreManager.1(this, paramFaceScoreCallBack), localReqBody.toByteArray(), "OidbSvc.0x938_1", 2360, 1, null, 0L);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFaceScoreManager
 * JD-Core Version:    0.7.0.1
 */