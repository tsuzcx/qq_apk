package com.tencent.mobileqq.lyric.widget;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.lyric.common.TimerTaskManager.TimerTaskRunnable;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import com.tencent.mobileqq.lyric.util.LyricContext;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class LyricViewController
{
  protected int a;
  protected long a;
  protected TimerTaskManager.TimerTaskRunnable a;
  protected TimerTaskManager a;
  protected Lyric a;
  protected LyricScrollHelper a;
  protected LyricViewInternal a;
  private LyricViewScroll.LyricViewScrollListener jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener;
  private LyricViewScroll jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll;
  protected final String a;
  protected volatile boolean a;
  protected int b;
  protected volatile boolean b;
  private volatile int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public LyricViewController(LyricView paramLyricView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("task_name_lyric_draw_");
    localStringBuilder.append(System.currentTimeMillis());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager = LyricContext.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricScrollHelper = new LyricScrollHelper();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener = new LyricViewController.1(this);
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable = new LyricViewController.2(this);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.setScrollListener(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.a();
    Lyric localLyric = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
    if ((localLyric != null) && (!localLyric.a()) && (!this.jdField_a_of_type_Boolean))
    {
      int i = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
      if (this.jdField_b_of_type_Boolean)
      {
        int j = this.jdField_b_of_type_Int;
        if (i >= j) {
          i = j;
        }
      }
      this.jdField_c_of_type_Int = i;
      a(localLyric.a(i), i);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      Log.d("ModuleController", "onRefresh -> is scrolling");
    }
  }
  
  public void a()
  {
    Log.d("ModuleController", "start");
    LyricContext.a().post(new LyricViewController.4(this));
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager.a(this.jdField_a_of_type_JavaLangString, 100L, 100L, this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seek ");
    localStringBuilder.append(paramInt);
    Log.d("ModuleController", localStringBuilder.toString());
    LyricContext.a().post(new LyricViewController.5(this, paramInt));
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal;
    if ((localObject != null) && (((LyricViewInternal)localObject).getWindowToken() != null)) {
      ThreadManager.getUIHandler().post(new LyricViewController.9(this, paramInt1, paramInt2));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll;
    if ((localObject != null) && (((LyricViewScroll)localObject).getWindowToken() != null)) {
      ThreadManager.getUIHandler().post(new LyricViewController.10(this));
    }
  }
  
  public void a(Lyric paramLyric1, Lyric paramLyric2, Lyric paramLyric3)
  {
    Log.v("ModuleController", "setLyric begin");
    LyricContext.a().post(new LyricViewController.3(this, paramLyric3, paramLyric1, paramLyric2));
  }
  
  public void a(LyricView paramLyricView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.setScrollListener(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener);
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    Log.d("ModuleController", "stop");
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected void b(int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric != null) || (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null))
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.b(paramInt);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
      if ((localObject == null) || (((Lyric)localObject).a())) {
        break label373;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScrollStop -> scroll to lineNo：");
      ((StringBuilder)localObject).append(paramInt);
      Log.d("ModuleController", ((StringBuilder)localObject).toString());
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.size()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.get(paramInt) == null)
        {
          Log.w("ModuleController", "onScrollStop -> current sentence is null");
          return;
        }
        long l2 = ((Sentence)this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.get(paramInt)).jdField_a_of_type_Long;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onScrollStop -> start time of current sentence：");
        ((StringBuilder)localObject).append(l2);
        Log.d("ModuleController", ((StringBuilder)localObject).toString());
        long l1 = l2;
        if (this.jdField_b_of_type_Boolean)
        {
          paramInt = this.jdField_a_of_type_Int;
          if ((paramInt >= 0) && (l2 < paramInt)) {}
          do
          {
            l1 = paramInt;
            break;
            paramInt = this.jdField_b_of_type_Int;
            l1 = l2;
            if (paramInt < 0) {
              break;
            }
            l1 = l2;
          } while (l2 > paramInt);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onScrollStop -> correct start time：");
        ((StringBuilder)localObject).append(l1);
        Log.d("ModuleController", ((StringBuilder)localObject).toString());
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        l1 = (l2 / 10L + 1L) * 10L;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onScrollStop -> output time：");
        ((StringBuilder)localObject).append(l1);
        Log.d("ModuleController", ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricScrollHelper.a(l1);
        if ((!this.jdField_c_of_type_Boolean) && (this.d)) {
          a((int)l1);
        }
      }
      else
      {
        Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
      }
    }
    return;
    label373:
    Log.w("ModuleController", "onScrollStop -> scroll without measured lyric");
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric != null) || (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null))
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.a(paramInt);
      Lyric localLyric = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
      if ((localLyric != null) && (!localLyric.a()))
      {
        if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.size()))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.get(paramInt) == null)
          {
            Log.w("ModuleController", "onScrollStop -> current sentence is null");
            return;
          }
          long l2 = ((Sentence)this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.get(paramInt)).jdField_a_of_type_Long;
          long l1 = l2;
          if (this.jdField_b_of_type_Boolean)
          {
            paramInt = this.jdField_a_of_type_Int;
            if ((paramInt >= 0) && (l2 < paramInt)) {}
            do
            {
              l1 = paramInt;
              break;
              paramInt = this.jdField_b_of_type_Int;
              l1 = l2;
              if (paramInt < 0) {
                break;
              }
              l1 = l2;
            } while (l2 > paramInt);
          }
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          l1 = l2 / 10L;
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricScrollHelper.b((l1 + 1L) * 10L);
          return;
        }
        Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
      }
    }
    else
    {
      return;
    }
    Log.w("ModuleController", "onScrolling -> scroll without measured lyric");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewController
 * JD-Core Version:    0.7.0.1
 */