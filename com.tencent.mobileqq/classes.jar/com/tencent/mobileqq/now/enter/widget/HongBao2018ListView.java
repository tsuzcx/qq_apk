package com.tencent.mobileqq.now.enter.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager;
import com.tencent.mobileqq.now.enter.NowPendantHolder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ListView.FixedViewInfo;
import com.tencent.widget.OverScrollViewListener;
import java.util.ArrayList;
import java.util.Iterator;

public class HongBao2018ListView
  extends ARMapHongBaoListView
{
  protected int a;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  public Drawable a;
  public View a;
  protected NowPendantHolder a;
  HongBao2018ListView.NowFloatViewCallBack jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView$NowFloatViewCallBack;
  private HongbaoListViewEventCallback jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback;
  public OverScrollViewListener a;
  public boolean a;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  public boolean b;
  private View c;
  public boolean c;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q = true;
  private boolean r;
  
  public HongBao2018ListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    t();
  }
  
  public HongBao2018ListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    t();
  }
  
  private void a(Canvas paramCanvas)
  {
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap == null) && (!this.o)) {}
    int m;
    try
    {
      this.o = true;
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(super.getResources(), 2130839539);
      this.g = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
      this.h = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        m = -getScrollY();
        if (m > 0) {}
      }
      else
      {
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("HongBao2018ListView", 1, "load new year arc bitmap failed");
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
        this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      }
      if (this.jdField_b_of_type_AndroidGraphicsRect == null) {
        this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
      }
      int i1 = super.getWidth();
      if ((i1 != 0) && (this.k != i1)) {
        this.k = i1;
      }
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.g, this.h);
      if (m > this.i) {
        break label254;
      }
    }
    this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, this.k, m);
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, -this.jdField_b_of_type_AndroidGraphicsRect.bottom);
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
      return;
      label254:
      this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, this.k, this.i);
    }
  }
  
  private void t() {}
  
  public int a()
  {
    View localView = getChildAt(0);
    if (localView == null) {
      return getScrollY();
    }
    int i2 = getFirstVisiblePosition();
    if (i2 >= this.mHeaderViewInfos.size())
    {
      Iterator localIterator = this.mHeaderViewInfos.iterator();
      for (m = 0; localIterator.hasNext(); m = ((ListView.FixedViewInfo)localIterator.next()).jdField_a_of_type_AndroidViewView.getHeight() + m) {}
      return -localView.getTop() + (i2 - this.mHeaderViewInfos.size()) * localView.getHeight() + m;
    }
    int m = 0;
    int i1 = 0;
    while (m < i2)
    {
      i1 += ((ListView.FixedViewInfo)this.mHeaderViewInfos.get(m)).jdField_a_of_type_AndroidViewView.getHeight();
      m += 1;
    }
    return -localView.getTop() + i1;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongBao2018ListView", 1, new Object[] { "[enableTouchEvent] enableTouchEvent=", Boolean.valueOf(paramBoolean) });
    }
    this.q = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("now_enter.pendant", 2, "showNowPendant, isShow:" + paramBoolean1 + " isDynamic:" + paramBoolean2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder == null) {
      if (QLog.isColorLevel()) {
        QLog.d("now_enter.pendant", 2, "showNowPendant, mNowPendantHolder == null");
      }
    }
    do
    {
      return;
      if ((!this.jdField_c_of_type_Boolean) && (paramBoolean1)) {}
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        long l = ((NowHongbaoPushManager)localQQAppInterface.getManager(265)).a(3);
        ReportController.b(localQQAppInterface, "dc00899", "Grp_AIO", "", "year_icon", "upicon_view", 0, 0, l + "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.i("now_enter.pendant", 2, "report Pendant show, pushId=" + l);
        }
        if (paramBoolean1)
        {
          this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder.f();
          this.jdField_c_of_type_Boolean = true;
          if ((paramBoolean2) && (!this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder.jdField_b_of_type_Boolean))
          {
            this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder.b();
            invalidate();
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.w("now_enter.pendant", 2, "report Pendant show exception:" + localException);
            continue;
            if ((!paramBoolean2) && (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder.jdField_b_of_type_Boolean)) {
              this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder.c();
            }
          }
        }
      }
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder.c();
    }
    invalidate();
  }
  
  public boolean a()
  {
    return (this.n) && (this.jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 300L);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongBao2018ListView", 2, "[enableNormalMode]");
    }
    super.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    super.setOverscrollHeader(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    super.setOverScrollHeader(this.jdField_a_of_type_AndroidViewView);
    try
    {
      super.setContentBackground(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      setOverscrollHeaderShadowEnable(true);
      this.jdField_b_of_type_Boolean = false;
      a(false, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("HongBao2018ListView", 1, "[enableNormalMode] setContentBackground exception=", localThrowable);
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongBao2018ListView", 2, "[enableNowEntranceMode] mNowEntranceEnabled=" + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      super.setOverScrollListener(null);
      super.setOverscrollHeader(null);
      super.setOverScrollHeader(null);
      setOverscrollHeaderShadowEnable(false);
      Resources localResources = super.getResources();
      this.i = ((int)localResources.getDimension(2131559473));
      this.k = localResources.getDisplayMetrics().widthPixels;
    } while (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder != null);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder = new NowPendantHolder(this);
    this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder.a();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int m = 1;
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)) {
      a(paramCanvas);
    }
    try
    {
      super.draw(paramCanvas);
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder.c = 0;
        if (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder.a(paramCanvas))
        {
          if (m != 0) {
            invalidate();
          }
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("HongBao2018ListView", 1, "draw exception=", localThrowable);
        continue;
        m = 0;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (!this.jdField_b_of_type_Boolean) {
      try
      {
        bool = super.onInterceptTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Throwable paramMotionEvent)
      {
        QLog.e("HongBao2018ListView", 1, "[onInterceptTouchEvent] exception1=", paramMotionEvent);
        return false;
      }
    }
    if (!this.q) {
      return true;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      try
      {
        bool = super.onInterceptTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        QLog.e("HongBao2018ListView", 1, "[onInterceptTouchEvent] exception=", paramMotionEvent);
        return false;
      }
      catch (Error paramMotionEvent)
      {
        QLog.e("HongBao2018ListView", 1, "[onInterceptTouchEvent] error=", paramMotionEvent);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback.a(this);
      }
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder != null) && (getScrollY() == 0))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder.a(0).contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
        {
          this.r = true;
          super.onInterceptTouchEvent(paramMotionEvent);
          return true;
        }
      }
      else {
        this.r = false;
      }
    }
    return false;
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback == null);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback.a(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool2 = true;
    boolean bool1 = false;
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      try
      {
        bool2 = super.onTouchEvent(paramMotionEvent);
        bool1 = bool2;
      }
      catch (Exception paramMotionEvent)
      {
        for (;;)
        {
          QLog.e("HongBao2018ListView", 1, "onTouchEvent exception1=", paramMotionEvent);
        }
      }
      return bool1;
      bool1 = bool2;
    } while (!this.q);
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 1)
    {
      if (!this.n) {
        break label191;
      }
      if (!a()) {
        break label538;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback.d(false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback.h();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView$NowFloatViewCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView$NowFloatViewCallBack.a();
      }
    }
    label271:
    label538:
    for (int m = 1;; m = 0)
    {
      this.n = false;
      this.jdField_a_of_type_Long = 0L;
      bool1 = bool2;
      if (m != 0) {
        break;
      }
      try
      {
        label191:
        do
        {
          bool1 = super.onTouchEvent(paramMotionEvent);
          switch (i1)
          {
          default: 
            return bool1;
          }
        } while (!this.p);
        if (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback.e();
        }
        this.p = false;
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("HongBao2018ListView", 1, "onTouchEvent exception2=", localException);
          bool1 = false;
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback != null)
          {
            paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback;
            if ((this.mTouchMode == 3) || (this.mTouchMode == 5))
            {
              bool2 = true;
              paramMotionEvent.a(this, bool2);
            }
          }
          else
          {
            m = -getScrollY();
            if (!this.jdField_a_of_type_Boolean) {
              break label387;
            }
          }
          switch (this.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
          case 2: 
            if (m >= this.i) {}
            for (bool2 = bool3;; bool2 = false)
            {
              this.n = bool2;
              if (!this.n) {
                break label379;
              }
              if (this.jdField_a_of_type_Long != 0L) {
                break;
              }
              this.jdField_a_of_type_Long = System.currentTimeMillis();
              break;
              bool2 = false;
              break label271;
            }
            label379:
            this.jdField_a_of_type_Long = 0L;
            break;
          }
          if (this.jdField_a_of_type_Int == 3)
          {
            if (m >= this.j) {}
            for (bool2 = bool4;; bool2 = false)
            {
              this.p = bool2;
              break;
            }
            if ((this.r) && (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback != null) && (getScrollY() == 0) && (this.jdField_a_of_type_ComTencentMobileqqNowEnterNowPendantHolder.a(0).contains(paramMotionEvent.getX(), paramMotionEvent.getY()))) {
              this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback.f();
            }
            this.r = false;
            if (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback != null) {
              this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback.b(this);
            }
            if ((!this.n) && (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback != null))
            {
              this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback.c(false);
              continue;
              this.r = false;
            }
          }
        }
      }
    }
  }
  
  public void setBannerMode(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setCanEnterActive(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setContentBackground(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    }
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        super.setContentBackground(paramDrawable, false);
        return;
      }
      super.setContentBackground(paramDrawable);
      return;
    }
    catch (Throwable paramDrawable)
    {
      QLog.e("HongBao2018ListView", 1, "[setContentBackground] exception=", paramDrawable);
    }
  }
  
  public void setCountdownBannerHeight(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setHongbaoEventCallback(HongbaoListViewEventCallback paramHongbaoListViewEventCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongbaoListViewEventCallback = paramHongbaoListViewEventCallback;
  }
  
  public void setNewYearOverScrollHeader(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongBao2018ListView", 2, new Object[] { "[setNewYearOverScrollHeader] view=", paramView, ", mBannerMode=", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2))
    {
      this.jdField_c_of_type_AndroidViewView = paramView;
      super.setOverScrollHeader(paramView);
    }
  }
  
  public void setNowFloatViewCallBack(HongBao2018ListView.NowFloatViewCallBack paramNowFloatViewCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView$NowFloatViewCallBack = paramNowFloatViewCallBack;
  }
  
  public void setOverScrollHeader(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongBao2018ListView", 2, new Object[] { "[setOverScrollHeader] view=", paramView, ", mForHongBao=", Boolean.valueOf(this.mForHongBao) });
    }
    if ((this.jdField_c_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HongBao2018ListView", 2, "[setOverScrollHeader] abort, check banner mode");
      }
      return;
    }
    if (paramView != null) {
      this.jdField_a_of_type_AndroidViewView = paramView;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      super.setOverScrollHeader(null);
      return;
    }
    super.setOverScrollHeader(paramView);
  }
  
  public void setOverScrollListener(OverScrollViewListener paramOverScrollViewListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HongBao2018ListView", 2, new Object[] { "[setOverScrollListener] listener=", paramOverScrollViewListener });
    }
    if (paramOverScrollViewListener != null) {
      this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = paramOverScrollViewListener;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      super.setOverScrollListener(null);
      return;
    }
    super.setOverScrollListener(paramOverScrollViewListener);
  }
  
  public void setOverscrollHeader(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      super.setOverscrollHeader(null);
      return;
    }
    super.setOverscrollHeader(paramDrawable);
  }
  
  public void setOverscrollHeaderShadowEnable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mOverScrollHeaderShadow = getResources().getDrawable(2130839293);
      return;
    }
    this.mOverScrollHeaderShadow = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.now.enter.widget.HongBao2018ListView
 * JD-Core Version:    0.7.0.1
 */