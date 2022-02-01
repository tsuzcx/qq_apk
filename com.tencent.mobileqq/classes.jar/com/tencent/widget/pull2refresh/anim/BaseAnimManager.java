package com.tencent.widget.pull2refresh.anim;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.IPullRefreshHeader;

abstract class BaseAnimManager
  implements IAnimManager
{
  protected Context mContext;
  protected IPullRefreshHeader mTopRefresh;
  
  public BaseAnimManager(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void endOfRefresh() {}
  
  public boolean isSkinAnimManager()
  {
    return false;
  }
  
  public void onDestroy() {}
  
  public void onPullRefreshCancel() {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.anim.BaseAnimManager
 * JD-Core Version:    0.7.0.1
 */