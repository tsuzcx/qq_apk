package com.tencent.mobileqq.colornote.swipeback;

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
import aqnq;
import aqns;
import aqnu;
import aqoa;
import aqoq;
import aqos;
import aqqs;
import aqrn;
import aqrt;
import aqrv;
import aqrw;
import aqrx;
import aqry;
import aqrz;
import aqsa;
import bdla;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.util.DisplayUtil;

public class SwipePostTableLayout
  extends SwipeBackLayout
  implements aqsa
{
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private aqns jdField_a_of_type_Aqns;
  private aqoa jdField_a_of_type_Aqoa;
  private aqqs jdField_a_of_type_Aqqs;
  private aqrn jdField_a_of_type_Aqrn = new aqrv(this);
  private aqry jdField_a_of_type_Aqry;
  private aqrz jdField_a_of_type_Aqrz;
  private PostTable jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable;
  public boolean e;
  public boolean f;
  private boolean g;
  private boolean h;
  private boolean i = true;
  private boolean j = true;
  private boolean k;
  private boolean l;
  
  public SwipePostTableLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable = new PostTable(paramContext);
    this.jdField_a_of_type_Aqry = new aqry(paramContext);
    this.jdField_a_of_type_Aqns = new aqns();
    this.jdField_a_of_type_Aqns.a(new aqnu());
    this.jdField_a_of_type_Aqqs = new aqqs();
    this.jdField_a_of_type_Aqqs.a(this.jdField_a_of_type_Aqns);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new aqrx(this));
    aqos.a().a(this.jdField_a_of_type_Aqrn);
    jdField_h_of_type_Int = DisplayUtil.dip2px(paramContext, 18.0F);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Aqqs.a();
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
    ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(0.0D);
    this.jdField_g_of_type_Boolean = false;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Aqqs.b();
  }
  
  public void b(Activity paramActivity)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
      if ((paramActivity != null) && (paramActivity.getChildCount() > 1) && (!(paramActivity.getChildAt(paramActivity.getChildCount() - 1) instanceof PostTable)))
      {
        int m = 0;
        while (m < paramActivity.getChildCount())
        {
          if ((paramActivity.getChildAt(m) instanceof PostTable))
          {
            paramActivity.getChildAt(m).bringToFront();
            return;
          }
          m += 1;
        }
      }
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Aqqs.c();
  }
  
  public void c_(boolean paramBoolean)
  {
    if (this.k)
    {
      this.k = false;
      this.jdField_a_of_type_Aqrt.sendEmptyMessage(1);
    }
    if (this.l)
    {
      this.l = false;
      d();
    }
  }
  
  public void i()
  {
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_Aqqs.a(false);
  }
  
  public void j()
  {
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_Aqqs.a(true);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Aqns.b()) {
      i();
    }
    double d = this.jdField_a_of_type_Aqry.a(paramMotionEvent);
    this.jdField_a_of_type_Aqns.a();
    if (this.jdField_a_of_type_Aqoa == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    ColorNote localColorNote = this.jdField_a_of_type_Aqoa.getColorNote();
    if ((localColorNote == null) || (this.jdField_a_of_type_AndroidViewView.getScrollX() == 0) || (TextUtils.isEmpty(localColorNote.mSubType))) {
      return super.onTouchEvent(paramMotionEvent);
    }
    boolean bool = this.jdField_a_of_type_Aqns.a(localColorNote.getServiceType(), localColorNote.getSubType());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.i = true;
      this.j = true;
      int n = 0;
      int m = n;
      if (this.jdField_h_of_type_Boolean)
      {
        m = n;
        if (this.jdField_a_of_type_Boolean)
        {
          m = n;
          if (this.jdField_a_of_type_Aqry.a(paramMotionEvent, getContext()))
          {
            m = n;
            if (!bool)
            {
              m = n;
              if (localColorNote != null)
              {
                m = n;
                if (aqoq.a(localColorNote))
                {
                  if (!this.jdField_a_of_type_Aqns.a()) {
                    break label556;
                  }
                  aqoq.a(localColorNote);
                  Bundle localBundle = localColorNote.parseBundle();
                  localBundle.putInt("color_note_curd_from_type", 1);
                  this.jdField_a_of_type_Aqns.a(localBundle);
                  this.jdField_f_of_type_Boolean = true;
                  if (this.jdField_a_of_type_Aqrw != null) {
                    this.jdField_a_of_type_Aqrw.a();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("SwipePostTableLayout", 1, "add colornote from swipe entrance:\n" + localColorNote.mServiceType + "\n" + localColorNote.mSubType + "\n" + localColorNote.mMainTitle + "\n" + localColorNote.mSubTitle + "\n" + localColorNote.mPicUrl);
                  }
                  bdla.b(null, "dc00898", "", "", "0X800A742", "0X800A742", aqnq.a(this.jdField_a_of_type_Aqoa.getColorNote().mServiceType), 0, "", "", "", "");
                  m = 1;
                }
              }
            }
          }
        }
      }
      if (aqos.a().a().x < this.jdField_f_of_type_Int / 2) {
        h();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(4);
        this.jdField_g_of_type_Boolean = false;
      }
      if (paramMotionEvent.getRawX() - this.c >= this.jdField_f_of_type_Int / 2)
      {
        this.e = true;
        if (this.jdField_a_of_type_Aqrw != null) {
          this.jdField_a_of_type_Aqrw.a();
        }
      }
      if (((m != 0) || (bool)) && (paramMotionEvent.getRawX() - this.c >= this.jdField_f_of_type_Int / 2))
      {
        this.jdField_a_of_type_Aqrt.sendEmptyMessage(1);
        postInvalidate();
        return true;
        label556:
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(0.0D);
        g();
        aqoq.a(getContext());
        bdla.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        return true;
        if ((this.jdField_a_of_type_Boolean) && (aqoq.a(localColorNote)))
        {
          if (!this.jdField_a_of_type_Aqry.a(paramMotionEvent, getContext()))
          {
            this.j = true;
            label645:
            if ((!this.jdField_h_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
              break label899;
            }
            if (d <= 1.0E-008D) {
              break label921;
            }
            if (bool) {
              continue;
            }
            m = (int)paramMotionEvent.getRawX();
            if ((m - this.c > this.jdField_b_of_type_Int) && (Math.abs((int)paramMotionEvent.getRawY() - this.d) < this.jdField_b_of_type_Int)) {
              this.jdField_b_of_type_Boolean = true;
            }
            if ((m - this.c <= 0) || (!this.jdField_b_of_type_Boolean)) {
              continue;
            }
            if (!this.jdField_g_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(0);
              this.jdField_g_of_type_Boolean = true;
            }
            if (!this.jdField_a_of_type_Aqns.a()) {
              break label911;
            }
            if (!this.jdField_a_of_type_Aqry.a(paramMotionEvent, getContext())) {
              break label901;
            }
            this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.b();
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(d);
            if (!this.i) {
              break;
            }
            bdla.b(null, "dc00898", "", "", "0X800A741", "0X800A741", aqnq.a(this.jdField_a_of_type_Aqoa.getColorNote().mServiceType), 0, "", "", "", "");
            this.i = false;
            break;
            if ((!this.jdField_h_of_type_Boolean) || (!this.jdField_a_of_type_Boolean) || (!this.j) || (bool)) {
              break label645;
            }
            this.jdField_a_of_type_AndroidOsVibrator.vibrate(50L);
            this.j = false;
            break label645;
            label899:
            break;
            label901:
            this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a();
            continue;
            label911:
            this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.c();
          }
          label921:
          this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(4);
          this.jdField_g_of_type_Boolean = false;
        }
      }
    }
  }
  
  public void setOnColorNoteCurdListener(aqnu paramaqnu)
  {
    this.jdField_a_of_type_Aqns.a(paramaqnu);
  }
  
  public void setOnPageSwipeListener(aqrw paramaqrw)
  {
    this.jdField_a_of_type_Aqrw = paramaqrw;
  }
  
  public void setServiceInfo(aqoa paramaqoa)
  {
    if (paramaqoa != null)
    {
      this.jdField_a_of_type_Aqoa = paramaqoa;
      this.jdField_a_of_type_Aqqs.a(paramaqoa);
      paramaqoa = paramaqoa.getColorNote();
      if ((paramaqoa != null) && (paramaqoa.mServiceType == 16908288)) {
        jdField_g_of_type_Int = jdField_h_of_type_Int;
      }
    }
  }
  
  public void setTranslucentConvertor(aqrz paramaqrz)
  {
    this.jdField_a_of_type_Aqrz = paramaqrz;
    paramaqrz.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout
 * JD-Core Version:    0.7.0.1
 */