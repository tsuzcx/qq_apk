package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import java.util.concurrent.ConcurrentHashMap;

public class FrameAdapter
{
  private ConcurrentHashMap a;
  
  public FramesProcessor.Frame a(int paramInt)
  {
    return (FramesProcessor.Frame)this.a.get(Integer.valueOf(paramInt));
  }
  
  public boolean a()
  {
    return this.a.size() == 0;
  }
  
  public boolean a(int paramInt)
  {
    return this.a.containsKey(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FrameAdapter
 * JD-Core Version:    0.7.0.1
 */