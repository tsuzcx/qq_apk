package com.tencent.ttpic.videoshelf.model.processor;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.template.VideoFrameItem;
import java.util.List;

public abstract interface IVideoShelfProcessor
{
  public static final int FILE_NOT_EXIT = 1;
  public static final String OUT_VIDEO_WIDTH_HEIGHT = "outVideoWidthHeight";
  public static final int VERSION_LOW = 2;
  
  public abstract void clear();
  
  public abstract Frame draw();
  
  public abstract long getCurFrameTimeStamp();
  
  public abstract int getProgress();
  
  public abstract void init(int[] paramArrayOfInt, List<VideoFrameItem> paramList, List<NodeGroup> paramList1);
  
  public abstract int isPrepareInit();
  
  public abstract int parseFrame();
  
  public abstract void setParam(String paramString, Object paramObject);
  
  public abstract boolean updateFrameCursor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
 * JD-Core Version:    0.7.0.1
 */