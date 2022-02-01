package com.tencent.mobileqq.guild.message.base;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import tencent.im.group_pro_proto.user.msgTransData.ClientIdentity;

class BaseGuildMessageProcessor$3
  implements IGProClientIdentityInfo
{
  BaseGuildMessageProcessor$3(BaseGuildMessageProcessor paramBaseGuildMessageProcessor, msgTransData.ClientIdentity paramClientIdentity) {}
  
  public String a()
  {
    return Integer.toString(this.a.client_id.get());
  }
  
  public String b()
  {
    return this.a.desc.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.base.BaseGuildMessageProcessor.3
 * JD-Core Version:    0.7.0.1
 */