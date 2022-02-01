package com.tencent.mobileqq.colornote.swipeback.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.colornote.ColorNoteConstants;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.colornote.share.ColorNoteStateNotice;
import com.tencent.mobileqq.colornote.smallscreen.IServiceSyncListener;
import com.tencent.mobileqq.colornote.swipeback.IColorNoteSwipeLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.swipe.OnPageSwipeListener;
import com.tencent.mobileqq.swipe.PostTable;
import com.tencent.mobileqq.swipe.SwipeBackLayout;
import com.tencent.mobileqq.swipe.SwipeBackLayout.OnSwipeListener;
import com.tencent.mobileqq.swipe.SwipeBackLayout.SwipeLayoutHandler;
import com.tencent.mobileqq.swipe.TouchStateDetector;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.TranslucentConvertor;
import com.tencent.mobileqq.utils.TranslucentConvertor.OnTranslucentConversionListener;
import com.tencent.qphone.base.util.QLog;

public class SwipePostTableLayoutImpl
  extends SwipeBackLayout
  implements IColorNoteSwipeLayout, TranslucentConvertor.OnTranslucentConversionListener
{
  private static final String TAG = "SwipePostTableLayout";
  private ColorNoteCurd mColorNoteCurd;
  private ColorNoteStateNotice mColorNoteStateNotice;
  private boolean mEnablePostTable = true;
  private boolean mFirstShow = true;
  private boolean mFirstVib = true;
  public boolean mIsSwipeAdd = false;
  public boolean mIsSwipeBacked = false;
  private PostTable mPostTable;
  private boolean mPostTableVisible = false;
  private IServiceInfo mServiceInfo;
  private IServiceSyncListener mServiceSyncListener = new SwipePostTableLayoutImpl.1(this);
  private TouchStateDetector mTouchStateDetector;
  private Vibrator mVibrator;
  private boolean pendingFinish;
  private boolean pendingScroll;
  private TranslucentConvertor translucentConvertor;
  
  public SwipePostTableLayoutImpl(Context paramContext)
  {
    super(paramContext);
    this.mPostTable = new PostTable(paramContext);
    this.mTouchStateDetector = new TouchStateDetector(paramContext);
    this.mColorNoteCurd = new ColorNoteCurd();
    this.mColorNoteCurd.a(new OnColorNoteCurdListener());
    this.mColorNoteStateNotice = new ColorNoteStateNotice();
    this.mColorNoteStateNotice.a(this.mColorNoteCurd);
    this.mVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.mGestureDetector = new GestureDetector(paramContext, new SwipePostTableLayoutImpl.SwipeGestureDetector(this));
    ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).setServiceSyncListener(this.mServiceSyncListener);
    WEBVIEW_LEFT_SWIPE_SCOPE = DisplayUtil.a(paramContext, 18.0F);
  }
  
  private ColorNote generateColorNote()
  {
    IServiceInfo localIServiceInfo = this.mServiceInfo;
    if (localIServiceInfo != null) {
      return localIServiceInfo.getColorNote();
    }
    return null;
  }
  
  private boolean insertColorNote(ColorNote paramColorNote)
  {
    ColorNoteUtils.a(paramColorNote);
    Object localObject = paramColorNote.parseBundle();
    ((Bundle)localObject).putInt("color_note_curd_from_type", 1);
    this.mColorNoteCurd.a((Bundle)localObject);
    this.mIsSwipeAdd = true;
    if (this.mOnPageSwipeListener != null) {
      this.mOnPageSwipeListener.a();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add colornote from swipe entrance:\n");
      ((StringBuilder)localObject).append(paramColorNote.mServiceType);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(paramColorNote.mSubType);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(paramColorNote.mMainTitle);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(paramColorNote.mSubTitle);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(paramColorNote.mPicUrl);
      QLog.d("SwipePostTableLayout", 1, ((StringBuilder)localObject).toString());
    }
    ReportController.b(null, "dc00898", "", "", "0X800A742", "0X800A742", ColorNoteConstants.a(this.mServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
    return true;
  }
  
  private void onActionMove(MotionEvent paramMotionEvent, double paramDouble, ColorNote paramColorNote, boolean paramBoolean)
  {
    if (this.allowedSliding)
    {
      if (!ColorNoteUtils.a(paramColorNote)) {
        return;
      }
      if (!this.mTouchStateDetector.a(paramMotionEvent, getContext()))
      {
        this.mFirstVib = true;
      }
      else if ((this.mEnablePostTable) && (this.allowedSliding) && (this.mFirstVib) && (!paramBoolean))
      {
        this.mVibrator.vibrate(50L);
        this.mFirstVib = false;
      }
      if ((this.mEnablePostTable) && (this.allowedSliding)) {
        if (paramDouble > 1.0E-008D)
        {
          if (!paramBoolean)
          {
            int i = (int)paramMotionEvent.getRawX();
            if ((i - this.downX > this.mTouchSlop) && (Math.abs((int)paramMotionEvent.getRawY() - this.downY) < this.mTouchSlop)) {
              this.isSilding = true;
            }
            if ((i - this.downX > 0) && (this.isSilding))
            {
              if (!this.mPostTableVisible)
              {
                this.mPostTable.setVisibility(0);
                this.mPostTableVisible = true;
              }
              if (this.mColorNoteCurd.a())
              {
                if (this.mTouchStateDetector.a(paramMotionEvent, getContext())) {
                  this.mPostTable.b();
                } else {
                  this.mPostTable.a();
                }
              }
              else {
                this.mPostTable.c();
              }
              this.mPostTable.a(paramDouble);
              if (this.mFirstShow)
              {
                ReportController.b(null, "dc00898", "", "", "0X800A741", "0X800A741", ColorNoteConstants.a(this.mServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
                this.mFirstShow = false;
              }
            }
          }
        }
        else
        {
          this.mPostTable.setVisibility(4);
          this.mPostTableVisible = false;
        }
      }
    }
  }
  
  private boolean onActionUp(MotionEvent paramMotionEvent, ColorNote paramColorNote, boolean paramBoolean)
  {
    this.mFirstShow = true;
    this.mFirstVib = true;
    boolean bool;
    if ((this.mEnablePostTable) && (this.allowedSliding) && (this.mTouchStateDetector.a(paramMotionEvent, getContext())) && (!paramBoolean) && (paramColorNote != null) && (ColorNoteUtils.a(paramColorNote)))
    {
      if (this.mColorNoteCurd.a())
      {
        bool = insertColorNote(paramColorNote);
      }
      else
      {
        this.mPostTable.a(0.0D);
        scrollOrigin();
        ColorNoteUtils.a(getContext());
        ReportController.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        return true;
      }
    }
    else {
      bool = false;
    }
    if (((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).getFloatingWindowPosition().x < this.screenWidth / 2) {
      fastScrollOrigin();
    }
    paramColorNote = this.mPostTable;
    if (paramColorNote != null)
    {
      paramColorNote.setVisibility(4);
      this.mPostTableVisible = false;
    }
    if (paramMotionEvent.getRawX() - this.downX >= this.screenWidth / 2)
    {
      this.mIsSwipeBacked = true;
      if (this.mOnPageSwipeListener != null) {
        this.mOnPageSwipeListener.a();
      }
    }
    if (((bool) || (paramBoolean)) && (paramMotionEvent.getRawX() - this.downX >= this.screenWidth / 2))
    {
      this.mHandler.sendEmptyMessage(1);
      postInvalidate();
      return true;
    }
    return false;
  }
  
  public void attachToActivity(Activity paramActivity)
  {
    super.attachToActivity(paramActivity);
    ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(this.mPostTable);
    this.mPostTable.setVisibility(4);
    this.mPostTable.a(0.0D);
    this.mPostTableVisible = false;
  }
  
  public void bringButtonToFront(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    if ((paramActivity != null) && (paramActivity.getChildCount() > 1) && (!(paramActivity.getChildAt(paramActivity.getChildCount() - 1) instanceof PostTable)))
    {
      int i = 0;
      while (i < paramActivity.getChildCount())
      {
        if ((paramActivity.getChildAt(i) instanceof PostTable))
        {
          paramActivity.getChildAt(i).bringToFront();
          return;
        }
        i += 1;
      }
    }
  }
  
  public void disablePostTable()
  {
    this.mEnablePostTable = false;
    this.mColorNoteStateNotice.a(false);
  }
  
  public void enablePostTable()
  {
    this.mEnablePostTable = true;
    this.mColorNoteStateNotice.a(true);
  }
  
  public boolean getIsSwipeAdd()
  {
    return this.mIsSwipeAdd;
  }
  
  public boolean getIsSwipeBacked()
  {
    return this.mIsSwipeBacked;
  }
  
  public void noticeRecentColorNote()
  {
    this.mColorNoteStateNotice.c();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.mColorNoteStateNotice.b();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mColorNoteStateNotice.a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mColorNoteCurd.b()) {
      disablePostTable();
    }
    double d = this.mTouchStateDetector.a(paramMotionEvent);
    this.mColorNoteCurd.a();
    Object localObject = this.mServiceInfo;
    if (localObject == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    localObject = ((IServiceInfo)localObject).getColorNote();
    if ((localObject != null) && (this.mContentView.getScrollX() != 0) && (!TextUtils.isEmpty(((ColorNote)localObject).mSubType)))
    {
      boolean bool = this.mColorNoteCurd.a(((ColorNote)localObject).getServiceType(), ((ColorNote)localObject).getSubType());
      int i = paramMotionEvent.getAction();
      if (i != 1)
      {
        if (i == 2) {
          onActionMove(paramMotionEvent, d, (ColorNote)localObject, bool);
        }
      }
      else if (onActionUp(paramMotionEvent, (ColorNote)localObject, bool)) {
        return true;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onTranslucentConversionComplete(boolean paramBoolean)
  {
    if (this.pendingFinish)
    {
      this.pendingFinish = false;
      this.mHandler.sendEmptyMessage(1);
    }
    if (this.pendingScroll)
    {
      this.pendingScroll = false;
      scrollRight();
    }
  }
  
  public void setLeftScope(int paramInt)
  {
    this.leftSwipeScope = paramInt;
  }
  
  public void setOnColorNoteCurdListener(OnColorNoteCurdListener paramOnColorNoteCurdListener)
  {
    this.mColorNoteCurd.a(paramOnColorNoteCurdListener);
  }
  
  public void setOnPageSwipeListener(OnPageSwipeListener paramOnPageSwipeListener)
  {
    this.mOnPageSwipeListener = paramOnPageSwipeListener;
  }
  
  public void setOnSwipeListener(SwipeBackLayout.OnSwipeListener paramOnSwipeListener)
  {
    super.setOnSwipeListener(paramOnSwipeListener);
  }
  
  public void setServiceInfo(IServiceInfo paramIServiceInfo)
  {
    if (paramIServiceInfo != null)
    {
      this.mServiceInfo = paramIServiceInfo;
      this.mColorNoteStateNotice.a(paramIServiceInfo);
      paramIServiceInfo = paramIServiceInfo.getColorNote();
      if ((paramIServiceInfo != null) && (paramIServiceInfo.mServiceType == 16908288)) {
        this.leftSwipeScope = WEBVIEW_LEFT_SWIPE_SCOPE;
      }
    }
  }
  
  public void setTranslucentConvertor(TranslucentConvertor paramTranslucentConvertor)
  {
    this.translucentConvertor = paramTranslucentConvertor;
    paramTranslucentConvertor.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.impl.SwipePostTableLayoutImpl
 * JD-Core Version:    0.7.0.1
 */