package com.tencent.mobileqq.nearby.now.protocol;

import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xada.oidb_0xada.ReqBody;

public class CsTask
{
  public int a;
  public int b;
  public long c = 0L;
  public CsTask.Callback d;
  public CsTask.OnCsError e;
  public int f = 0;
  public AppInterface g;
  
  public CsTask(AppInterface paramAppInterface)
  {
    this.g = paramAppInterface;
  }
  
  private boolean a(oidb_0xada.ReqBody paramReqBody)
  {
    paramReqBody.uid.set(Long.parseLong(this.g.getCurrentAccountUin()));
    paramReqBody.tinyid.set(Long.parseLong(this.g.getCurrentAccountUin()));
    Object localObject = (TicketManager)this.g.getManager(2);
    String str = ((TicketManager)localObject).getA2(this.g.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(this.g.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramReqBody.a2.set(str);
      paramReqBody.platform.set(1);
      paramReqBody.version.set("8.8.17");
      paramReqBody.original_id.set(this.g.getCurrentAccountUin());
      paramReqBody.original_key.set((String)localObject);
      paramReqBody.original_id_type.set(1);
      return true;
    }
    return false;
  }
  
  public CsTask a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public CsTask a(CsTask.Callback paramCallback)
  {
    this.d = paramCallback;
    return this;
  }
  
  public CsTask a(CsTask.OnCsError paramOnCsError)
  {
    this.e = paramOnCsError;
    return this;
  }
  
  public CsTask a(byte[] paramArrayOfByte)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (a(localReqBody))
    {
      localReqBody.cmd.set(this.a);
      localReqBody.subcmd.set(this.b);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      ProtoUtils.a(this.g, new CsTask.1(this), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
    return this;
  }
  
  public CsTask b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.protocol.CsTask
 * JD-Core Version:    0.7.0.1
 */