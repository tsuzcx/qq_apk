package com.tencent.mobileqq.tofumsg;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult;

public abstract class TofuDataBaseHandler
  implements ITofuDataHandler
{
  protected QQAppInterface a;
  
  public TofuDataBaseHandler(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public abstract int a();
  
  public TofuItem a(@NotNull TofuItem paramTofuItem, long paramLong, int paramInt)
  {
    boolean bool2 = a(paramInt);
    boolean bool1;
    if (paramLong - paramTofuItem.lastPullTsLocal >= paramTofuItem.pullInterval) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Tofu_TofuDataBaseHandler", 2, String.format("makeReqItemIfPull [%s] [canPull,tsCheck]=[%b,%b] [curTs,lastTs,interval]=[%d,%d,%d]", new Object[] { TofuConst.a(paramTofuItem.busId), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(paramLong), Long.valueOf(paramTofuItem.lastPullTsLocal), Long.valueOf(paramTofuItem.pullInterval) }));
    }
    if ((bool2) && (bool1))
    {
      TofuItem localTofuItem = new TofuItem(Long.toString(paramTofuItem.frdUin), paramTofuItem.busId);
      localTofuItem.cloneFrom(paramTofuItem);
      return localTofuItem;
    }
    return null;
  }
  
  public abstract String a(TofuItem paramTofuItem);
  
  public final oidb_0xe61.BeancurdCubeInfo a(TofuItem paramTofuItem)
  {
    oidb_0xe61.BeancurdCubeInfo localBeancurdCubeInfo = paramTofuItem.packToPbReq();
    if (localBeancurdCubeInfo != null)
    {
      paramTofuItem = a(paramTofuItem);
      if (paramTofuItem != null) {
        localBeancurdCubeInfo.bytes_busi_data_req.set(ByteStringMicro.copyFrom(paramTofuItem));
      }
    }
    return localBeancurdCubeInfo;
  }
  
  public void a() {}
  
  protected void a(TofuItem paramTofuItem) {}
  
  public final void a(@NotNull TofuItem paramTofuItem, oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult, long paramLong)
  {
    if ((paramBeancurdCubeInfoResult.uint32_result.has()) && (paramBeancurdCubeInfoResult.uint32_result.get() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramBeancurdCubeInfoResult.beancurdCubeInfo.has()) {
      paramBeancurdCubeInfoResult = (oidb_0xe61.BeancurdCubeInfo)paramBeancurdCubeInfoResult.beancurdCubeInfo.get();
    } else {
      paramBeancurdCubeInfoResult = null;
    }
    boolean bool = a(paramTofuItem, bool, paramLong, paramBeancurdCubeInfoResult);
    if (bool) {
      try
      {
        paramBeancurdCubeInfoResult = a(paramTofuItem);
        if (!TextUtils.isEmpty(paramBeancurdCubeInfoResult))
        {
          localObject = new BeancurdMsg();
          ((BeancurdMsg)localObject).frienduin = Long.toString(paramTofuItem.frdUin);
          ((BeancurdMsg)localObject).busiid = a();
          ((BeancurdMsg)localObject).isNeedDelHistory = paramTofuItem.bNeedDelHistory();
          ((BeancurdMsg)localObject).ispush = paramTofuItem.bInsertImmediate();
          ((BeancurdMsg)localObject).originTime = paramTofuItem.eventTs;
          ((BeancurdMsg)localObject).startTime = MessageCache.a();
          ((BeancurdMsg)localObject).validTime = paramTofuItem.validTime;
          ((BeancurdMsg)localObject).buffer = paramBeancurdCubeInfoResult;
          TofuHelper.a(this.a, (BeancurdMsg)localObject, a((BeancurdMsg)localObject), a());
        }
        else
        {
          a(paramTofuItem);
        }
      }
      catch (Exception paramBeancurdCubeInfoResult)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetRsp exception=");
        ((StringBuilder)localObject).append(paramBeancurdCubeInfoResult.getMessage());
        QLog.d("Tofu_TofuDataBaseHandler", 1, ((StringBuilder)localObject).toString(), paramBeancurdCubeInfoResult);
      }
    }
    QLog.d("Tofu_TofuDataBaseHandler", 1, String.format("onGetRsp [%s] bNew=%b ts=%d item=%s", new Object[] { TofuConst.a(paramTofuItem.busId), Boolean.valueOf(bool), Long.valueOf(paramLong), paramTofuItem }));
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  public boolean a(BeancurdMsg paramBeancurdMsg)
  {
    return false;
  }
  
  public boolean a(TofuItem paramTofuItem, boolean paramBoolean, long paramLong, oidb_0xe61.BeancurdCubeInfo paramBeancurdCubeInfo)
  {
    if ((paramBoolean) && (paramBeancurdCubeInfo != null))
    {
      long l1 = paramTofuItem.eventTs;
      long l2 = paramTofuItem.lastPullTsSvr;
      paramTofuItem.lastPullTsLocal = paramLong;
      if (paramBeancurdCubeInfo.uint64_event_time.has()) {
        paramLong = paramBeancurdCubeInfo.uint64_event_time.get();
      } else {
        paramLong = paramTofuItem.eventTs;
      }
      paramTofuItem.eventTs = paramLong;
      if (paramBeancurdCubeInfo.uint64_pull_interval_time.has()) {
        paramLong = paramBeancurdCubeInfo.uint64_pull_interval_time.get();
      } else {
        paramLong = 86400L;
      }
      paramTofuItem.pullInterval = paramLong;
      if (paramTofuItem.pullInterval <= 0L) {
        paramTofuItem.pullInterval = 86400L;
      }
      if (paramBeancurdCubeInfo.uint64_last_pull_time.has()) {
        paramLong = paramBeancurdCubeInfo.uint64_last_pull_time.get();
      } else {
        paramLong = paramTofuItem.lastPullTsSvr;
      }
      paramTofuItem.lastPullTsSvr = paramLong;
      if (paramBeancurdCubeInfo.uint64_valid_time.has()) {
        paramLong = paramBeancurdCubeInfo.uint64_valid_time.get();
      } else {
        paramLong = paramTofuItem.validTime;
      }
      paramTofuItem.validTime = paramLong;
      if (paramBeancurdCubeInfo.uint64_flag.has()) {
        paramLong = paramBeancurdCubeInfo.uint64_flag.get();
      } else {
        paramLong = paramTofuItem.flags;
      }
      paramTofuItem.flags = paramLong;
      paramBoolean = paramBeancurdCubeInfo.bytes_busi_data_rsp.has();
      Object localObject2 = null;
      if (paramBoolean) {
        localObject1 = paramBeancurdCubeInfo.bytes_busi_data_rsp.get().toByteArray();
      } else {
        localObject1 = null;
      }
      paramTofuItem.bytesFromServer = ((byte[])localObject1);
      Object localObject1 = localObject2;
      if (paramBeancurdCubeInfo.bytes_busi_data_req.has()) {
        localObject1 = paramBeancurdCubeInfo.bytes_busi_data_req.get().toByteArray();
      }
      paramTofuItem.bytesFromClient = ((byte[])localObject1);
      if ((paramTofuItem.eventTs > l1) && (paramTofuItem.lastPullTsSvr > l2)) {
        return true;
      }
    }
    else
    {
      paramTofuItem.lastPullTsLocal = paramLong;
    }
    return false;
  }
  
  public abstract byte[] a(TofuItem paramTofuItem);
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuDataBaseHandler
 * JD-Core Version:    0.7.0.1
 */