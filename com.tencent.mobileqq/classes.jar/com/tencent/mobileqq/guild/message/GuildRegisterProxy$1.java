package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.guild.message.registerproxy.observer.GuildRegisterProxyObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.group_pro_proto.synclogic.synclogic.FirstViewRsp;
import tencent.im.group_pro_proto.synclogic.synclogic.GuildNode;

class GuildRegisterProxy$1
  extends GuildRegisterProxyObserver
{
  GuildRegisterProxy$1(GuildRegisterProxy paramGuildRegisterProxy) {}
  
  protected void a(boolean paramBoolean, ArrayList<synclogic.GuildNode> paramArrayList)
  {
    GuildRegisterProxy.a(this.a).clear();
    GuildRegisterProxy.a(this.a).addAll(paramArrayList);
    this.a.setResult(7);
    QLog.i(GuildRegisterProxy.a(), 1, "首屏包处理完成");
  }
  
  protected void a(boolean paramBoolean, synclogic.FirstViewRsp paramFirstViewRsp)
  {
    if (!paramBoolean) {
      this.a.setResult(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildRegisterProxy.1
 * JD-Core Version:    0.7.0.1
 */