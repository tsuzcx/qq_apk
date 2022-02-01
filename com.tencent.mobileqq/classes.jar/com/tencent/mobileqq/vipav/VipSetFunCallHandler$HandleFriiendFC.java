package com.tencent.mobileqq.vipav;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.pb.funcall.VipFunCallAndRing.TSourceInfo;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x2Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x2Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoReq;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoRsp;

class VipSetFunCallHandler$HandleFriiendFC
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private IVipFunCallManager jdField_a_of_type_ComTencentMobileqqVasVipavApiIVipFunCallManager;
  private VipFunCallAndRing.TSsoReq jdField_a_of_type_ComTencentPbFuncallVipFunCallAndRing$TSsoReq;
  private VipFunCallAndRing.TSsoRsp jdField_a_of_type_ComTencentPbFuncallVipFunCallAndRing$TSsoRsp;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public VipSetFunCallHandler$HandleFriiendFC(VipSetFunCallHandler paramVipSetFunCallHandler, VipFunCallAndRing.TSsoReq paramTSsoReq, Bundle paramBundle, int paramInt1, VipFunCallAndRing.TSsoRsp paramTSsoRsp, IVipFunCallManager paramIVipFunCallManager, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentPbFuncallVipFunCallAndRing$TSsoReq = paramTSsoReq;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentPbFuncallVipFunCallAndRing$TSsoRsp = paramTSsoRsp;
    this.jdField_a_of_type_ComTencentMobileqqVasVipavApiIVipFunCallManager = paramIVipFunCallManager;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public HandleFriiendFC a()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      VipFunCallAndRing.TSsoCmd0x2Rsp localTSsoCmd0x2Rsp = (VipFunCallAndRing.TSsoCmd0x2Rsp)this.jdField_a_of_type_ComTencentPbFuncallVipFunCallAndRing$TSsoRsp.st_cmd0x2_rsp.get();
      VipFunCallAndRing.TSsoCmd0x2Req localTSsoCmd0x2Req = (VipFunCallAndRing.TSsoCmd0x2Req)this.jdField_a_of_type_ComTencentPbFuncallVipFunCallAndRing$TSsoReq.st_cmd0x2_req.get();
      String str = String.valueOf(localTSsoCmd0x2Req.u64_friend_uin.get());
      int i = localTSsoCmd0x2Rsp.i32_funcall_id.get();
      int j = VipFunCallUtil.a(VipSetFunCallHandler.a(this.jdField_a_of_type_ComTencentMobileqqVipavVipSetFunCallHandler), str, 6, true, null);
      this.jdField_a_of_type_ComTencentMobileqqVasVipavApiIVipFunCallManager.setFunCallData(VipSetFunCallHandler.a(this.jdField_a_of_type_ComTencentMobileqqVipavVipSetFunCallHandler), 0, str, i, localTSsoCmd0x2Rsp.i32_ring_id.get(), null, 0L);
      VipFunCallManager.a(VipSetFunCallHandler.a(this.jdField_a_of_type_ComTencentMobileqqVipavVipSetFunCallHandler), localTSsoCmd0x2Rsp.i32_funcall_id.get(), null, (VipFunCallAndRing.TSourceInfo)localTSsoCmd0x2Rsp.st_src_info.get(), true);
      if (VipFunCallUtil.a()) {
        this.jdField_a_of_type_ComTencentMobileqqVasVipavApiIVipFunCallManager.downloadFCSuit(i, localTSsoCmd0x2Rsp.i32_ring_id.get(), false, 0, null);
      }
      VipSetFunCallHandler.a(this.jdField_a_of_type_ComTencentMobileqqVipavVipSetFunCallHandler, str, i, j);
      Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localTSsoCmd0x2Req.u64_friend_uin.get());
      localStringBuilder.append("");
      localBundle.putString("uin", localStringBuilder.toString());
      this.b = localTSsoCmd0x2Rsp.i32_ring_id.get();
      this.jdField_a_of_type_JavaLangString = str;
    }
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipSetFunCallHandler.HandleFriiendFC
 * JD-Core Version:    0.7.0.1
 */