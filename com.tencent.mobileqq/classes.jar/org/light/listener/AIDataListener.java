package org.light.listener;

import java.util.List;
import org.light.bean.BodyData;
import org.light.bean.FaceData;
import org.light.bean.HandData;

public abstract interface AIDataListener
{
  public abstract void onBodyDataUpdated(List<BodyData> paramList);
  
  public abstract void onFaceDataUpdated(List<FaceData> paramList);
  
  public abstract void onHandDataUpdated(List<HandData> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.listener.AIDataListener
 * JD-Core Version:    0.7.0.1
 */