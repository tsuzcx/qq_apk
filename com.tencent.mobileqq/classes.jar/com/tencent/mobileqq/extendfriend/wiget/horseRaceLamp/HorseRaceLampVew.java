package com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class HorseRaceLampVew
  extends RelativeLayout
  implements Runnable
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 3;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private HorseRaceLampVew.onTagClickListner jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew$onTagClickListner;
  private TagInfosAdapter jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampTagInfosAdapter;
  private ArrayList<RaceLine> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 15;
  boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int = 4;
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int = 20;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 4;
  private int f = 21;
  private int g = 16;
  
  public HorseRaceLampVew(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    a(paramContext, null);
  }
  
  public HorseRaceLampVew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    a(paramContext, paramAttributeSet);
  }
  
  public HorseRaceLampVew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    a(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((RaceLine)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramInt);
        i += 1;
      }
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    setFocusableInTouchMode(true);
    paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Int = (-AIOUtils.a(0.02F * this.jdField_b_of_type_Int, paramContext.getApp().getResources()));
    if (this.jdField_a_of_type_Int == 0)
    {
      QLog.e("HorseRaceLampVew + horserace", 2, "mMovespeed is 0");
      this.jdField_a_of_type_Int = -1;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    return (Math.abs(paramFloat1) > i) || (Math.abs(paramFloat2) > i);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    removeAllViews();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private void d()
  {
    postDelayed(new HorseRaceLampVew.1(this), 50L);
  }
  
  private void e()
  {
    int i1 = 0;
    int j;
    int k;
    View localView;
    int i;
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      if (this.jdField_a_of_type_Boolean) {
        break label199;
      }
      j = 0;
      k = 0;
      for (int m = 0; j < getChildCount(); m = i)
      {
        localView = getChildAt(j);
        int n = k;
        i = m;
        if (localView != null)
        {
          n = k;
          i = m;
          if (localView.getVisibility() != 8)
          {
            localObject = localView.getTag();
            n = k;
            i = m;
            if ((localObject instanceof Tag))
            {
              m += 1;
              localObject = (Tag)localObject;
              n = k;
              i = m;
              if (localView.getWidth() != 0)
              {
                ((Tag)localObject).d(localView.getMeasuredWidth());
                n = k + 1;
                i = m;
              }
            }
          }
        }
        j += 1;
        k = n;
      }
      if (k == m)
      {
        i = i1;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          ((RaceLine)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b();
          i += 1;
        }
        this.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      label199:
      i = 0;
      while (i < getChildCount())
      {
        localView = getChildAt(i);
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          if (localView.getVisibility() == 4) {
            localView.setVisibility(0);
          }
          localObject = localView.getTag();
          if ((localObject instanceof Tag))
          {
            localObject = (Tag)localObject;
            j = ((Tag)localObject).a();
            k = ((Tag)localObject).b();
            localView.setX(j);
            localView.setY(k);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    QLog.d("HorseRaceLampVew + horserace", 2, "stopAnimation");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.jdField_b_of_type_Int);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_c_of_type_Float = 0.0F;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_d_of_type_Float = paramMotionEvent.getX();
      this.jdField_e_of_type_Float = paramMotionEvent.getY();
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
      getParent().requestDisallowInterceptTouchEvent(true);
      QLog.d("HorseRaceLampVew + horserace", 2, "ON touch ACTION_DOWN downX " + this.jdField_d_of_type_Float);
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.jdField_b_of_type_Float += Math.abs(f1 - this.jdField_d_of_type_Float);
      this.jdField_c_of_type_Float += Math.abs(f2 - this.jdField_e_of_type_Float);
      this.jdField_a_of_type_Float = (f1 - this.jdField_d_of_type_Float);
      this.jdField_d_of_type_Float = f1;
      this.jdField_e_of_type_Float = f2;
      if (this.jdField_b_of_type_Float <= this.jdField_c_of_type_Float) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
      for (;;)
      {
        a((int)this.jdField_a_of_type_Float);
        e();
        if (!a(this.jdField_b_of_type_Float, this.jdField_c_of_type_Float)) {
          break;
        }
        this.jdField_b_of_type_Boolean = false;
        break;
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      this.jdField_c_of_type_Boolean = false;
      QLog.d("HorseRaceLampVew + horserace", 2, "ON touch ACTION_UP ");
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void run()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      a(this.jdField_a_of_type_Int);
      e();
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.jdField_b_of_type_Int);
  }
  
  public void setAdapter(TagInfosAdapter paramTagInfosAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampTagInfosAdapter = paramTagInfosAdapter;
    d();
  }
  
  public void setItemHorMarginDp(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setLineCount(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void setLineMarginDp(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setTagClickListner(HorseRaceLampVew.onTagClickListner paramonTagClickListner)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampHorseRaceLampVew$onTagClickListner = paramonTagClickListner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.HorseRaceLampVew
 * JD-Core Version:    0.7.0.1
 */