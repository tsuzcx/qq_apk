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
import apkm;
import apko;
import apkq;
import apkw;
import aplm;
import aplo;
import apno;
import apoj;
import apop;
import apor;
import apos;
import apot;
import apou;
import apov;
import apow;
import bcef;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.util.DisplayUtil;

public class SwipePostTableLayout
  extends SwipeBackLayout
  implements apow
{
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private apko jdField_a_of_type_Apko;
  private apkw jdField_a_of_type_Apkw;
  private apno jdField_a_of_type_Apno;
  private apoj jdField_a_of_type_Apoj = new apor(this);
  private apou jdField_a_of_type_Apou;
  private apov jdField_a_of_type_Apov;
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
    this.jdField_a_of_type_Apou = new apou(paramContext);
    this.jdField_a_of_type_Apko = new apko();
    this.jdField_a_of_type_Apko.a(new apkq());
    this.jdField_a_of_type_Apno = new apno();
    this.jdField_a_of_type_Apno.a(this.jdField_a_of_type_Apko);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new apot(this));
    aplo.a().a(this.jdField_a_of_type_Apoj);
    jdField_h_of_type_Int = DisplayUtil.dip2px(paramContext, 18.0F);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Apno.a();
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
    this.jdField_a_of_type_Apno.b();
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
    this.jdField_a_of_type_Apno.c();
  }
  
  public void c_(boolean paramBoolean)
  {
    if (this.k)
    {
      this.k = false;
      this.jdField_a_of_type_Apop.sendEmptyMessage(1);
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
    this.jdField_a_of_type_Apno.a(false);
  }
  
  public void j()
  {
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_Apno.a(true);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Apko.b()) {
      i();
    }
    double d = this.jdField_a_of_type_Apou.a(paramMotionEvent);
    this.jdField_a_of_type_Apko.a();
    if (this.jdField_a_of_type_Apkw == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    ColorNote localColorNote = this.jdField_a_of_type_Apkw.getColorNote();
    if ((localColorNote == null) || (this.jdField_a_of_type_AndroidViewView.getScrollX() == 0) || (TextUtils.isEmpty(localColorNote.mSubType))) {
      return super.onTouchEvent(paramMotionEvent);
    }
    boolean bool = this.jdField_a_of_type_Apko.a(localColorNote.getServiceType(), localColorNote.getSubType());
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
          if (this.jdField_a_of_type_Apou.a(paramMotionEvent, getContext()))
          {
            m = n;
            if (!bool)
            {
              m = n;
              if (localColorNote != null)
              {
                m = n;
                if (aplm.a(localColorNote))
                {
                  if (!this.jdField_a_of_type_Apko.a()) {
                    break label556;
                  }
                  aplm.a(localColorNote);
                  Bundle localBundle = localColorNote.parseBundle();
                  localBundle.putInt("color_note_curd_from_type", 1);
                  this.jdField_a_of_type_Apko.a(localBundle);
                  this.jdField_f_of_type_Boolean = true;
                  if (this.jdField_a_of_type_Apos != null) {
                    this.jdField_a_of_type_Apos.a();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("SwipePostTableLayout", 1, "add colornote from swipe entrance:\n" + localColorNote.mServiceType + "\n" + localColorNote.mSubType + "\n" + localColorNote.mMainTitle + "\n" + localColorNote.mSubTitle + "\n" + localColorNote.mPicUrl);
                  }
                  bcef.b(null, "dc00898", "", "", "0X800A742", "0X800A742", apkm.a(this.jdField_a_of_type_Apkw.getColorNote().mServiceType), 0, "", "", "", "");
                  m = 1;
                }
              }
            }
          }
        }
      }
      if (aplo.a().a().x < this.jdField_f_of_type_Int / 2) {
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
        if (this.jdField_a_of_type_Apos != null) {
          this.jdField_a_of_type_Apos.a();
        }
      }
      if (((m != 0) || (bool)) && (paramMotionEvent.getRawX() - this.c >= this.jdField_f_of_type_Int / 2))
      {
        this.jdField_a_of_type_Apop.sendEmptyMessage(1);
        postInvalidate();
        return true;
        label556:
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(0.0D);
        g();
        aplm.a(getContext());
        bcef.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        return true;
        if ((this.jdField_a_of_type_Boolean) && (aplm.a(localColorNote)))
        {
          if (!this.jdField_a_of_type_Apou.a(paramMotionEvent, getContext()))
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
            if (!this.jdField_a_of_type_Apko.a()) {
              break label911;
            }
            if (!this.jdField_a_of_type_Apou.a(paramMotionEvent, getContext())) {
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
            bcef.b(null, "dc00898", "", "", "0X800A741", "0X800A741", apkm.a(this.jdField_a_of_type_Apkw.getColorNote().mServiceType), 0, "", "", "", "");
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
  
  public void setOnColorNoteCurdListener(apkq paramapkq)
  {
    this.jdField_a_of_type_Apko.a(paramapkq);
  }
  
  public void setOnPageSwipeListener(apos paramapos)
  {
    this.jdField_a_of_type_Apos = paramapos;
  }
  
  public void setServiceInfo(apkw paramapkw)
  {
    if (paramapkw != null)
    {
      this.jdField_a_of_type_Apkw = paramapkw;
      this.jdField_a_of_type_Apno.a(paramapkw);
      paramapkw = paramapkw.getColorNote();
      if ((paramapkw != null) && (paramapkw.mServiceType == 16908288)) {
        jdField_g_of_type_Int = jdField_h_of_type_Int;
      }
    }
  }
  
  public void setTranslucentConvertor(apov paramapov)
  {
    this.jdField_a_of_type_Apov = paramapov;
    paramapov.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout
 * JD-Core Version:    0.7.0.1
 */