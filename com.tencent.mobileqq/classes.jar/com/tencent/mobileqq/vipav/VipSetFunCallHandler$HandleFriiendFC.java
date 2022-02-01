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
  private VipFunCallAndRing.TSsoReq b;
  private Bundle c;
  private int d;
  private VipFunCallAndRing.TSsoRsp e;
  private IVipFunCallManager f;
  private int g;
  private String h;
  
  public VipSetFunCallHandler$HandleFriiendFC(VipSetFunCallHandler paramVipSetFunCallHandler, VipFunCallAndRing.TSsoReq paramTSsoReq, Bundle paramBundle, int paramInt1, VipFunCallAndRing.TSsoRsp paramTSsoRsp, IVipFunCallManager paramIVipFunCallManager, int paramInt2, String paramString)
  {
    this.b = paramTSsoReq;
    this.c = paramBundle;
    this.d = paramInt1;
    this.e = paramTSsoRsp;
    this.f = paramIVipFunCallManager;
    this.g = paramInt2;
    this.h = paramString;
  }
  
  public int a()
  {
    return this.g;
  }
  
  public String b()
  {
    return this.h;
  }
  
  public HandleFriiendFC c()
  {
    if (this.d == 0)
    {
      VipFunCallAndRing.TSsoCmd0x2Rsp localTSsoCmd0x2Rsp = (VipFunCallAndRing.TSsoCmd0x2Rsp)this.e.st_cmd0x2_rsp.get();
      VipFunCallAndRing.TSsoCmd0x2Req localTSsoCmd0x2Req = (VipFunCallAndRing.TSsoCmd0x2Req)this.b.st_cmd0x2_req.get();
      String str = String.valueOf(localTSsoCmd0x2Req.u64_friend_uin.get());
      int i = localTSsoCmd0x2Rsp.i32_funcall_id.get();
      int j = VipFunCallUtil.a(VipSetFunCallHandler.a(this.a), str, 6, true, null);
      this.f.setFunCallData(VipSetFunCallHandler.a(this.a), 0, str, i, localTSsoCmd0x2Rsp.i32_ring_id.get(), null, 0L);
      VipFunCallManager.a(VipSetFunCallHandler.a(this.a), localTSsoCmd0x2Rsp.i32_funcall_id.get(), null, (VipFunCallAndRing.TSourceInfo)localTSsoCmd0x2Rsp.st_src_info.get(), true);
      if (VipFunCallUtil.b()) {
        this.f.downloadFCSuit(i, localTSsoCmd0x2Rsp.i32_ring_id.get(), false, 0, null);
      }
      VipSetFunCallHandler.a(this.a, str, i, j);
      Bundle localBundle = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localTSsoCmd0x2Req.u64_friend_uin.get());
      localStringBuilder.append("");
      localBundle.putString("uin", localStringBuilder.toString());
      this.g = localTSsoCmd0x2Rsp.i32_ring_id.get();
      this.h = str;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipSetFunCallHandler.HandleFriiendFC
 * JD-Core Version:    0.7.0.1
 */