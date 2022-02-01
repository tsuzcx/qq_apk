package com.tencent.mobileqq.kandian.repo.playfeeds;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;

public class VideoPlayDianZanObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject != null)
    {
      a(paramBoolean, (Bundle)paramObject);
      return;
    }
    a(paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.playfeeds.VideoPlayDianZanObserver
 * JD-Core Version:    0.7.0.1
 */