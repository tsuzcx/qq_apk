package com.tencent.mobileqq.colornote.swipeback;

import android.app.Activity;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.swipe.OnPageSwipeListener;
import com.tencent.mobileqq.swipe.SwipeBackLayout.OnSwipeListener;
import com.tencent.mobileqq.utils.TranslucentConvertor;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IColorNoteSwipeLayout
  extends QRouteApi
{
  public abstract void attachToActivity(Activity paramActivity);
  
  public abstract void bringButtonToFront(Activity paramActivity);
  
  public abstract void disablePostTable();
  
  public abstract void disableSwipe();
  
  public abstract void enablePostTable();
  
  public abstract void enableSwipe();
  
  public abstract boolean getIsSwipeAdd();
  
  public abstract boolean getIsSwipeBacked();
  
  public abstract int getScrollX();
  
  public abstract void noticeRecentColorNote();
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void setBackgroundResource(int paramInt);
  
  public abstract void setLeftScope(int paramInt);
  
  public abstract void setOnColorNoteCurdListener(OnColorNoteCurdListener paramOnColorNoteCurdListener);
  
  public abstract void setOnPageSwipeListener(OnPageSwipeListener paramOnPageSwipeListener);
  
  public abstract void setOnSwipeListener(SwipeBackLayout.OnSwipeListener paramOnSwipeListener);
  
  public abstract void setReadyToSlide(boolean paramBoolean);
  
  public abstract void setServiceInfo(IServiceInfo paramIServiceInfo);
  
  public abstract void setTranslucentConvertor(TranslucentConvertor paramTranslucentConvertor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout
 * JD-Core Version:    0.7.0.1
 */