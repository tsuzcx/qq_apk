package com.tencent.mobileqq.tofumsg;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="businessId,businessMsgId")
public class TofuLimitMsg
  extends Entity
{
  public static final int FLAG_VER = 1;
  public static final long S_TO_MILLISECOND = 1000L;
  public long businessId;
  public String businessMsgId;
  public String extra;
  public int flag;
  public String friendUin;
  public long insertMsgTime;
  
  public static TofuLimitMsg create(BeancurdMsg paramBeancurdMsg)
  {
    TofuLimitMsg localTofuLimitMsg = new TofuLimitMsg();
    localTofuLimitMsg.friendUin = paramBeancurdMsg.frienduin;
    localTofuLimitMsg.businessId = paramBeancurdMsg.busiid;
    if (paramBeancurdMsg.msgTime >= 0L) {
      localTofuLimitMsg.insertMsgTime = (paramBeancurdMsg.msgTime * 1000L);
    } else {
      localTofuLimitMsg.insertMsgTime = (NetConnInfoCenter.getServerTime() * 1000L);
    }
    localTofuLimitMsg.flag = 0;
    localTofuLimitMsg.extra = "";
    return localTofuLimitMsg;
  }
  
  public static TofuLimitMsg create(@NonNull NewBeancurdMsg paramNewBeancurdMsg)
  {
    TofuLimitMsg localTofuLimitMsg = new TofuLimitMsg();
    localTofuLimitMsg.friendUin = paramNewBeancurdMsg.frienduin;
    localTofuLimitMsg.businessId = paramNewBeancurdMsg.busiid;
    localTofuLimitMsg.businessMsgId = paramNewBeancurdMsg.busiUuid;
    localTofuLimitMsg.insertMsgTime = (NetConnInfoCenter.getServerTime() * 1000L);
    localTofuLimitMsg.flag = 0;
    localTofuLimitMsg.flag |= 0x1;
    localTofuLimitMsg.extra = "";
    return localTofuLimitMsg;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TofuLimitMsg{friendUin='");
    localStringBuilder.append(this.friendUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", businessId=");
    localStringBuilder.append(this.businessId);
    localStringBuilder.append(", businessMsgId=");
    localStringBuilder.append(this.businessMsgId);
    localStringBuilder.append(", insertMsgTime=");
    localStringBuilder.append(this.insertMsgTime);
    localStringBuilder.append(", flag=");
    localStringBuilder.append(this.flag);
    localStringBuilder.append(", extra='");
    localStringBuilder.append(this.extra);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuLimitMsg
 * JD-Core Version:    0.7.0.1
 */