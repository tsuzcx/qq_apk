package com.tencent.mobileqq.tofumsg;

import androidx.annotation.NonNull;
import bdqn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="frdUin,busId")
public class TofuItem
  extends Entity
{
  public static final long ONE_DAY_SECONDS = 86400L;
  public int busId;
  @notColumn
  public byte[] bytesFromClient;
  @notColumn
  public byte[] bytesFromServer;
  @notColumn
  public long eventTs;
  @notColumn
  public long flags;
  public long frdUin;
  public long lastPullTsLocal;
  public long lastPullTsSvr;
  @notColumn
  public String msg;
  public byte[] msgData;
  public long pullInterval = 86400L;
  @notColumn
  public long validTime;
  
  public TofuItem() {}
  
  public TofuItem(String paramString, int paramInt)
  {
    this.frdUin = Long.valueOf(paramString).longValue();
    this.busId = paramInt;
  }
  
  public boolean bInsertImmediate()
  {
    return (this.flags & 0x2) != 0L;
  }
  
  public boolean bNeedDelHistory()
  {
    return (this.flags & 1L) != 0L;
  }
  
  public void cloneFrom(@NotNull TofuItem paramTofuItem)
  {
    this.eventTs = paramTofuItem.eventTs;
    this.pullInterval = paramTofuItem.pullInterval;
    this.lastPullTsSvr = paramTofuItem.lastPullTsSvr;
    this.lastPullTsLocal = paramTofuItem.lastPullTsLocal;
    this.validTime = paramTofuItem.validTime;
    this.flags = paramTofuItem.flags;
    this.bytesFromServer = paramTofuItem.bytesFromServer;
    this.bytesFromClient = paramTofuItem.bytesFromClient;
  }
  
  public oidb_0xe61.BeancurdCubeInfo packToPbReq()
  {
    try
    {
      l = Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()).longValue();
      if (l == 0L) {
        return null;
      }
    }
    catch (Exception localException)
    {
      long l;
      for (;;)
      {
        l = 0L;
      }
      oidb_0xe61.BeancurdCubeInfo localBeancurdCubeInfo = new oidb_0xe61.BeancurdCubeInfo();
      localBeancurdCubeInfo.uint64_frd_uin.set(this.frdUin);
      localBeancurdCubeInfo.uint64_busi_id.set(bdqn.a(this.busId));
      localBeancurdCubeInfo.uint64_uin.set(l);
      localBeancurdCubeInfo.uint64_last_pull_time.set(this.lastPullTsSvr);
      return localBeancurdCubeInfo;
    }
  }
  
  public void postRead()
  {
    try
    {
      if (this.msgData != null) {
        this.msg = new String(this.msgData, "UTF-8");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void prewrite()
  {
    if (this.msg != null) {}
    try
    {
      if (this.msg != null) {
        this.msgData = this.msg.getBytes("UTF-8");
      }
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("frdUin").append("=").append(MobileQQ.getShortUinStr(Long.toString(this.frdUin)));
    localStringBuilder.append("|").append("busId").append("=").append(bdqn.a(this.busId));
    localStringBuilder.append("|").append("eventTs").append("=").append(this.eventTs);
    localStringBuilder.append("|").append("pullInterval").append("=").append(this.pullInterval);
    localStringBuilder.append("|").append("lastPullTsLocal").append("=").append(this.lastPullTsLocal);
    localStringBuilder.append("|").append("lastPullTsSvr").append("=").append(this.lastPullTsSvr);
    localStringBuilder.append("|").append("validTime").append("=").append(this.validTime);
    localStringBuilder.append("|").append("flags").append("=").append(this.flags);
    localStringBuilder.append("|").append("msg").append("=").append(this.msg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuItem
 * JD-Core Version:    0.7.0.1
 */