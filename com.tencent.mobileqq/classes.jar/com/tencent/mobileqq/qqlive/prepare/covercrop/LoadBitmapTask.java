package com.tencent.mobileqq.qqlive.prepare.covercrop;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqlive.widget.PortraitImageView;
import com.tencent.mobileqq.qqlive.widget.RegionView;
import mqq.os.MqqHandler;

class LoadBitmapTask
{
  private PortraitImageView a;
  private RegionView b;
  private int c;
  
  public LoadBitmapTask(int paramInt1, int paramInt2, Activity paramActivity, ViewGroup paramViewGroup, ImageView paramImageView, String paramString, int paramInt3, int paramInt4)
  {
    this.a = new PortraitImageView(paramActivity);
    ThreadManager.getFileThreadHandler().post(new LoadBitmapTask.1(this, paramActivity, paramString, paramInt3, paramInt4, paramInt1, paramInt2, paramViewGroup, paramImageView));
  }
  
  public RegionView a()
  {
    return this.b;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.b;
    int j = 0;
    int i;
    if (localObject != null)
    {
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      ((RegionView)localObject).setVisibility(i);
    }
    localObject = this.a;
    if (localObject != null)
    {
      if (paramBoolean) {
        i = j;
      } else {
        i = 8;
      }
      ((PortraitImageView)localObject).setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.covercrop.LoadBitmapTask
 * JD-Core Version:    0.7.0.1
 */