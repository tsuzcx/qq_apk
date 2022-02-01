package dov.com.qq.im.ae.biz.qcircle.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class AECircleTitleAlbumMenuChangeEvent
  extends SimpleBaseEvent
{
  private boolean isShow;
  
  public AECircleTitleAlbumMenuChangeEvent(boolean paramBoolean)
  {
    this.isShow = paramBoolean;
  }
  
  public boolean getIsShow()
  {
    return this.isShow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.event.AECircleTitleAlbumMenuChangeEvent
 * JD-Core Version:    0.7.0.1
 */