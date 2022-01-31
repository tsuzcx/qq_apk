package dov.com.qq.im.capture.data;

import android.os.Bundle;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData;

public abstract interface CaptureComboManager$CaptureComboListener
{
  public abstract void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle);
  
  public abstract void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle);
  
  public abstract void a(VideoFilterTools.ComboFilterData paramComboFilterData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.data.CaptureComboManager.CaptureComboListener
 * JD-Core Version:    0.7.0.1
 */