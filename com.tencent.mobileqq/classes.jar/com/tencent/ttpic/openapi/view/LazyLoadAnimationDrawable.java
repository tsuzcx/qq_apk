package com.tencent.ttpic.openapi.view;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;

public class LazyLoadAnimationDrawable
  extends AnimationDrawable
{
  private int cur = 0;
  private BitmapDrawable currentDrawable;
  private int[] durations = null;
  private String[] filenames = null;
  private BitmapDrawable nextDrawable;
  private Resources res;
  private int totalDuration = 0;
  
  public LazyLoadAnimationDrawable(LazyLoadAnimationDrawable.Info paramInfo)
  {
    this.res = paramInfo.res;
    this.filenames = paramInfo.filenames;
    this.durations = paramInfo.durations;
    this.totalDuration = paramInfo.totalDuration;
    int i = this.cur;
    paramInfo = this.filenames;
    if (i < paramInfo.length)
    {
      this.nextDrawable = new BitmapDrawable(this.res, paramInfo[i]);
      addFrame(this.nextDrawable, this.durations[this.cur]);
    }
  }
  
  public void clear()
  {
    this.res = null;
    BitmapDrawable localBitmapDrawable = this.currentDrawable;
    if (localBitmapDrawable != null) {
      BitmapUtils.recycle(localBitmapDrawable.getBitmap());
    }
    localBitmapDrawable = this.nextDrawable;
    if (localBitmapDrawable != null) {
      BitmapUtils.recycle(localBitmapDrawable.getBitmap());
    }
  }
  
  public int getTotalDuration()
  {
    return this.totalDuration;
  }
  
  public void run()
  {
    LogUtils.d("111", "test animation running");
    this.cur += 1;
    Object localObject = this.currentDrawable;
    if (localObject != null) {
      BitmapUtils.recycle(((BitmapDrawable)localObject).getBitmap());
    }
    this.currentDrawable = this.nextDrawable;
    int i = this.cur;
    localObject = this.filenames;
    if (i < localObject.length)
    {
      this.nextDrawable = new BitmapDrawable(this.res, localObject[i]);
      addFrame(this.nextDrawable, this.durations[this.cur]);
      super.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */