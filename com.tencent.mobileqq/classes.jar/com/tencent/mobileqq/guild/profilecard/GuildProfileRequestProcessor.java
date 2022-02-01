package com.tencent.mobileqq.guild.profilecard;

import android.os.Bundle;
import com.tencent.mobileqq.activity.home.FrameAddPushNotifier;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

@KeepClassConstructor
public class GuildProfileRequestProcessor
  extends AbsProfileCommonProcessor
{
  private long a;
  
  public GuildProfileRequestProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
    FrameAddPushNotifier.a().a(new GuildProfileRequestProcessor.TabFrameAddCallback());
  }
  
  public String getProcessorKey()
  {
    return "GuildProfileRequestProcessor";
  }
  
  public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb.ReqBody paramReqBody)
  {
    paramReqBody.uint32_guild_gray_flag.set(1);
    if (QLog.isDevelopLevel()) {
      QLog.d("GuildProfileRequestProcessor", 4, new Object[] { "onGetProfileDetailRequestForLogin: ", Integer.valueOf(45091) });
    }
    return true;
  }
  
  public void onGetProfileDetailResponse(Bundle paramBundle, boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (paramUdcUinData.uint32_guild_gray_flag.has())
    {
      int i = paramUdcUinData.uint32_guild_gray_flag.get();
      QLog.d("GuildProfileRequestProcessor", 1, new Object[] { "onGetProfileDetailResponse: ", Integer.toBinaryString(i) });
      ((QQGuildHandler)QQGuildUtil.a(QQGuildHandler.class)).a(i, 1);
    }
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    int i = 0;
    if (paramInt != 45091)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("GuildProfileRequestProcessor", 4, new Object[] { "onProcessProfileModifyPush: don't care id:", Integer.valueOf(paramInt) });
      }
      return;
    }
    if (this.a != this.appRuntime.getLongAccountUin())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("GuildProfileRequestProcessor", 4, new Object[] { "onProcessProfileModifyPush: don't care uin:", Long.valueOf(this.a) });
      }
      return;
    }
    int j = paramByteStringMicro.size();
    if (j != 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt = i;
      while (paramInt < j)
      {
        localStringBuilder.append(Integer.toBinaryString(paramByteStringMicro.byteAt(paramInt)));
        paramInt += 1;
      }
      paramByteStringMicro = new StringBuilder();
      paramByteStringMicro.append("onProcessProfileModifyPush, type: 45091 size=");
      paramByteStringMicro.append(j);
      paramByteStringMicro.append(" which!=2! content=");
      paramByteStringMicro.append(localStringBuilder.toString());
      QLog.w("GuildProfileRequestProcessor", 1, paramByteStringMicro.toString());
      return;
    }
    paramInt = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).order(ByteOrder.BIG_ENDIAN).getShort();
    if (QLog.isDevelopLevel()) {
      QLog.d("GuildProfileRequestProcessor", 4, new Object[] { "onProcessProfileModifyPush, type: ", Integer.valueOf(45091), " flag: ", Integer.toBinaryString(paramInt) });
    }
    ((QQGuildHandler)QQGuildUtil.a(QQGuildHandler.class)).a(paramInt, 2);
  }
  
  public void onProcessProfileModifyPushBegin(long paramLong)
  {
    this.a = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.GuildProfileRequestProcessor
 * JD-Core Version:    0.7.0.1
 */