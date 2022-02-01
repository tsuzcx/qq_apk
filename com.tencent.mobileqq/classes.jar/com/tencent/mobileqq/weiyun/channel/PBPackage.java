package com.tencent.mobileqq.weiyun.channel;

import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.MsgHead;
import com.tencent.mobileqq.weiyun.utils.PackageUtils;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class PBPackage
{
  private static final AtomicInteger c = new AtomicInteger(0);
  private final WeiyunPB.MsgHead a;
  private final byte[] b;
  
  PBPackage(int paramInt, byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
    this.a = a(paramInt);
  }
  
  PBPackage(WeiyunPB.MsgHead paramMsgHead, byte[] paramArrayOfByte)
  {
    this.a = paramMsgHead;
    this.b = paramArrayOfByte;
  }
  
  private WeiyunPB.MsgHead a(int paramInt)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    WeiyunPB.MsgHead localMsgHead = new WeiyunPB.MsgHead();
    localMsgHead.uin.set(localAppRuntime.getLongAccountUin());
    localMsgHead.seq.set(a());
    localMsgHead.type.set(1);
    localMsgHead.cmd.set(paramInt);
    localMsgHead.emulator_flag.set(0);
    localMsgHead.appid.set(31532);
    localMsgHead.encrypt.set(0);
    localMsgHead.zip_flag.set(0);
    localMsgHead.version.set(PackageUtils.c());
    localMsgHead.fix_version.set(PackageUtils.d());
    localMsgHead.nettype.set(NetworkUtil.getNetworkType(localAppRuntime.getApplication()));
    localMsgHead.major_version.set(PackageUtils.a());
    localMsgHead.minor_version.set(PackageUtils.b());
    return localMsgHead;
  }
  
  public int a()
  {
    return c.getAndIncrement();
  }
  
  public WeiyunPB.MsgHead b()
  {
    return this.a;
  }
  
  public byte[] c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.channel.PBPackage
 * JD-Core Version:    0.7.0.1
 */