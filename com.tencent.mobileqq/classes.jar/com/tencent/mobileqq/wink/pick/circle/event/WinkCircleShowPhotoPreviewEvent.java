package com.tencent.mobileqq.wink.pick.circle.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.List;

public class WinkCircleShowPhotoPreviewEvent
  extends SimpleBaseEvent
{
  public List<LocalMediaInfo> mPhotoInfoList;
  public int mPosition;
  
  public WinkCircleShowPhotoPreviewEvent(List<LocalMediaInfo> paramList, int paramInt)
  {
    this.mPhotoInfoList = paramList;
    this.mPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.event.WinkCircleShowPhotoPreviewEvent
 * JD-Core Version:    0.7.0.1
 */