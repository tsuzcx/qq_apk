package com.tencent.mobileqq.vipav;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewTempUtil;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x3Req;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x3Rsp;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoReq;
import com.tencent.pb.funcall.VipFunCallAndRing.TSsoRsp;

class VipSetFunCallHandler$HandleMyDefaultFC
{
  private VipFunCallAndRing.TSsoReq b;
  private int c;
  private Bundle d;
  private int e;
  private VipFunCallAndRing.TSsoRsp f;
  private IVipFunCallManager g;
  private int h;
  private String i;
  
  public VipSetFunCallHandler$HandleMyDefaultFC(VipSetFunCallHandler paramVipSetFunCallHandler, VipFunCallAndRing.TSsoReq paramTSsoReq, int paramInt1, Bundle paramBundle, int paramInt2, VipFunCallAndRing.TSsoRsp paramTSsoRsp, IVipFunCallManager paramIVipFunCallManager, int paramInt3, String paramString)
  {
    this.b = paramTSsoReq;
    this.c = paramInt1;
    this.d = paramBundle;
    this.e = paramInt2;
    this.f = paramTSsoRsp;
    this.g = paramIVipFunCallManager;
    this.h = paramInt3;
    this.i = paramString;
  }
  
  public int a()
  {
    return this.h;
  }
  
  public String b()
  {
    return this.i;
  }
  
  public HandleMyDefaultFC c()
  {
    Object localObject1 = (VipFunCallAndRing.TSsoCmd0x3Req)this.b.st_cmd0x3_req.get();
    this.d.putInt("callId", ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_funcall_id.get());
    Object localObject2;
    if (this.e == 0)
    {
      localObject2 = (VipFunCallAndRing.TSsoCmd0x3Rsp)this.f.st_cmd0x3_rsp.get();
      this.g.setFunCallData(VipSetFunCallHandler.a(this.a), 0, VipSetFunCallHandler.a(this.a).getAccount(), ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_funcall_id.get(), ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_ring_id.get(), null, 0L);
      this.h = ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_ring_id.get();
      this.i = VipSetFunCallHandler.a(this.a).getAccount();
    }
    if (1 == this.c)
    {
      localObject2 = VipSetFunCallHandler.a(this.a);
      int j = ((VipFunCallAndRing.TSsoCmd0x3Req)localObject1).i32_funcall_id.get();
      if (this.e == 0) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      VasWebviewTempUtil.reportVASTo00145((AppInterface)localObject2, String.valueOf(j), "preview", "SetComCall", (String)localObject1, new String[0]);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipSetFunCallHandler.HandleMyDefaultFC
 * JD-Core Version:    0.7.0.1
 */