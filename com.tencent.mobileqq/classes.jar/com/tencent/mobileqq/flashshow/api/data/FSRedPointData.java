package com.tencent.mobileqq.flashshow.api.data;

import com.tencent.mobileqq.flashshow.api.IFlashShowEeveeManagerService;
import com.tencent.mobileqq.flashshow.util.FSProtoUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.concurrent.atomic.AtomicInteger;
import qflash.QFlashBadge.BadgeDisplayInfo;
import qflash.QFlashBadge.BadgeJumpInfo;
import qflash.QFlashBadge.BadgeTypeInfo;
import qflash.QFlashBadge.QFlashBadgeContentInfo;
import qflash.QFlashBadge.QFlashBadgeInfo;

public class FSRedPointData
{
  private QFlashBadge.QFlashBadgeInfo mBadgeInfo;
  private final int mSeq;
  
  public FSRedPointData(QFlashBadge.QFlashBadgeInfo paramQFlashBadgeInfo)
  {
    this.mBadgeInfo = paramQFlashBadgeInfo;
    this.mSeq = ((IFlashShowEeveeManagerService)QRoute.api(IFlashShowEeveeManagerService.class)).getAtomicInteger().getAndIncrement();
  }
  
  private void setBadgeInfo(QFlashBadge.QFlashBadgeInfo paramQFlashBadgeInfo)
  {
    this.mBadgeInfo = paramQFlashBadgeInfo;
  }
  
  public void clearBadgeInfo()
  {
    QFlashBadge.QFlashBadgeInfo localQFlashBadgeInfo = this.mBadgeInfo;
    if (localQFlashBadgeInfo != null) {
      localQFlashBadgeInfo.clear();
    }
  }
  
  public byte[] getBadgeContentTraceInfoByte()
  {
    QFlashBadge.QFlashBadgeInfo localQFlashBadgeInfo = this.mBadgeInfo;
    if (localQFlashBadgeInfo == null) {
      return null;
    }
    if (localQFlashBadgeInfo.contentInfo.traceInfo.get() == null) {
      return null;
    }
    return this.mBadgeInfo.contentInfo.traceInfo.get().toByteArray();
  }
  
  public byte[] getBadgeInfoByte()
  {
    QFlashBadge.QFlashBadgeInfo localQFlashBadgeInfo = this.mBadgeInfo;
    if (localQFlashBadgeInfo != null) {
      return localQFlashBadgeInfo.toByteArray();
    }
    return null;
  }
  
  public int getBadgeMainTypeValue()
  {
    QFlashBadge.QFlashBadgeInfo localQFlashBadgeInfo = this.mBadgeInfo;
    if (localQFlashBadgeInfo == null) {
      return -1;
    }
    return localQFlashBadgeInfo.contentInfo.typeInfo.badgeMainTypeValue.get();
  }
  
  public int getBadgeSubTypeValue()
  {
    QFlashBadge.QFlashBadgeInfo localQFlashBadgeInfo = this.mBadgeInfo;
    if (localQFlashBadgeInfo == null) {
      return -1;
    }
    return localQFlashBadgeInfo.contentInfo.typeInfo.badgeSubTypeValue.get();
  }
  
  public String getDisplayInfoJumpLink()
  {
    QFlashBadge.QFlashBadgeInfo localQFlashBadgeInfo = this.mBadgeInfo;
    if (localQFlashBadgeInfo == null) {
      return "";
    }
    return localQFlashBadgeInfo.contentInfo.displayInfo.jumpInfo.jumpLink.get();
  }
  
  public int getDisplayInfoNum()
  {
    QFlashBadge.QFlashBadgeInfo localQFlashBadgeInfo = this.mBadgeInfo;
    if (localQFlashBadgeInfo == null) {
      return 0;
    }
    return localQFlashBadgeInfo.contentInfo.displayInfo.number.get();
  }
  
  public long getLastClearTimestamp()
  {
    QFlashBadge.QFlashBadgeInfo localQFlashBadgeInfo = this.mBadgeInfo;
    if (localQFlashBadgeInfo == null) {
      return -1L;
    }
    return localQFlashBadgeInfo.lastClearTimestamp.get();
  }
  
  public int getSeq()
  {
    return this.mSeq;
  }
  
  public boolean hasRedPointInfo()
  {
    QFlashBadge.QFlashBadgeInfo localQFlashBadgeInfo = this.mBadgeInfo;
    return (localQFlashBadgeInfo != null) && (localQFlashBadgeInfo.contentInfo.has()) && (this.mBadgeInfo.contentInfo.displayInfo.has());
  }
  
  public boolean hasShowBadgeRedPoint()
  {
    QFlashBadge.QFlashBadgeInfo localQFlashBadgeInfo = this.mBadgeInfo;
    if (localQFlashBadgeInfo == null) {
      return false;
    }
    return localQFlashBadgeInfo.contentInfo.displayInfo.showBadge.get();
  }
  
  public void setBadgeInfoByByte(byte[] paramArrayOfByte)
  {
    setBadgeInfo(FSProtoUtil.a(paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.data.FSRedPointData
 * JD-Core Version:    0.7.0.1
 */