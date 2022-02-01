package com.tencent.mobileqq.tofumsg;

import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="frdUin,busId")
@KeepClassConstructor
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
    }
    catch (Exception localException)
    {
      long l;
      label19:
      oidb_0xe61.BeancurdCubeInfo localBeancurdCubeInfo;
      break label19;
    }
    l = 0L;
    if (l == 0L) {
      return null;
    }
    localBeancurdCubeInfo = new oidb_0xe61.BeancurdCubeInfo();
    localBeancurdCubeInfo.uint64_frd_uin.set(this.frdUin);
    localBeancurdCubeInfo.uint64_busi_id.set(TofuConst.a(this.busId));
    localBeancurdCubeInfo.uint64_uin.set(l);
    localBeancurdCubeInfo.uint64_last_pull_time.set(this.lastPullTsSvr);
    return localBeancurdCubeInfo;
  }
  
  protected void postRead()
  {
    try
    {
      if (this.msgData != null)
      {
        this.msg = new String(this.msgData, "UTF-8");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void prewrite()
  {
    String str = this.msg;
    if ((str != null) && (str != null)) {
      try
      {
        this.msgData = str.getBytes("UTF-8");
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("frdUin");
    localStringBuilder.append("=");
    localStringBuilder.append(MobileQQ.getShortUinStr(Long.toString(this.frdUin)));
    localStringBuilder.append("|");
    localStringBuilder.append("busId");
    localStringBuilder.append("=");
    localStringBuilder.append(TofuConst.b(this.busId));
    localStringBuilder.append("|");
    localStringBuilder.append("eventTs");
    localStringBuilder.append("=");
    localStringBuilder.append(this.eventTs);
    localStringBuilder.append("|");
    localStringBuilder.append("pullInterval");
    localStringBuilder.append("=");
    localStringBuilder.append(this.pullInterval);
    localStringBuilder.append("|");
    localStringBuilder.append("lastPullTsLocal");
    localStringBuilder.append("=");
    localStringBuilder.append(this.lastPullTsLocal);
    localStringBuilder.append("|");
    localStringBuilder.append("lastPullTsSvr");
    localStringBuilder.append("=");
    localStringBuilder.append(this.lastPullTsSvr);
    localStringBuilder.append("|");
    localStringBuilder.append("validTime");
    localStringBuilder.append("=");
    localStringBuilder.append(this.validTime);
    localStringBuilder.append("|");
    localStringBuilder.append("flags");
    localStringBuilder.append("=");
    localStringBuilder.append(this.flags);
    localStringBuilder.append("|");
    localStringBuilder.append("msg");
    localStringBuilder.append("=");
    localStringBuilder.append(this.msg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuItem
 * JD-Core Version:    0.7.0.1
 */