package com.tencent.mobileqq.colornote.swipeback;

import amgm;
import amgo;
import amgq;
import amgv;
import amhh;
import amhj;
import amjh;
import amkg;
import amkl;
import amkn;
import amko;
import amkp;
import amkq;
import amkr;
import amks;
import amkt;
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
import android.widget.TextView;
import axqy;
import baww;
import baxn;
import bbgu;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class SwipePostTableLayout
  extends SwipeBackLayout
  implements amkt
{
  private amgo jdField_a_of_type_Amgo;
  private amgv jdField_a_of_type_Amgv;
  private amjh jdField_a_of_type_Amjh;
  private amkg jdField_a_of_type_Amkg = new amkn(this);
  private amkr jdField_a_of_type_Amkr;
  private amks jdField_a_of_type_Amks;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private bbgu jdField_a_of_type_Bbgu;
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
    this.jdField_a_of_type_Amkr = new amkr(paramContext);
    this.jdField_a_of_type_Amgo = new amgo();
    this.jdField_a_of_type_Amgo.a(new amgq());
    this.jdField_a_of_type_Amjh = new amjh();
    this.jdField_a_of_type_Amjh.a(this.jdField_a_of_type_Amgo);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new amkq(this));
    amhj.a().a(this.jdField_a_of_type_Amkg);
    jdField_h_of_type_Int = baxn.a(paramContext, 18.0F);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bbgu == null)
    {
      this.jdField_a_of_type_Bbgu = new bbgu(this.jdField_a_of_type_AndroidContentContext, 2131755791);
      this.jdField_a_of_type_Bbgu.setContentView(2131558906);
      this.jdField_a_of_type_Bbgu.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bbgu.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131690864));
      this.jdField_a_of_type_Bbgu.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690863), new amko(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbgu.show();
      TextView localTextView = this.jdField_a_of_type_Bbgu.getTitleTextView();
      localTextView.setClickable(true);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      baww.a(localTextView, true);
      return;
      if (this.jdField_a_of_type_Bbgu.isShowing()) {
        this.jdField_a_of_type_Bbgu.dismiss();
      }
    }
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Amjh.a();
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
    this.jdField_a_of_type_Amjh.b();
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Amjh.c();
  }
  
  public void d_(boolean paramBoolean)
  {
    if (this.k)
    {
      this.k = false;
      this.jdField_a_of_type_Amkl.sendEmptyMessage(1);
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
    this.jdField_a_of_type_Amjh.a(false);
  }
  
  public void j()
  {
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_Amjh.a(true);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Amgo.b()) {
      i();
    }
    double d = this.jdField_a_of_type_Amkr.a(paramMotionEvent);
    this.jdField_a_of_type_Amgo.a();
    if (this.jdField_a_of_type_Amgv == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    ColorNote localColorNote = this.jdField_a_of_type_Amgv.getColorNote();
    if ((localColorNote == null) || (this.jdField_a_of_type_AndroidViewView.getScrollX() == 0) || (TextUtils.isEmpty(localColorNote.mSubType))) {
      return super.onTouchEvent(paramMotionEvent);
    }
    boolean bool = this.jdField_a_of_type_Amgo.a(localColorNote.getServiceType(), localColorNote.getSubType());
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
          if (this.jdField_a_of_type_Amkr.a(paramMotionEvent, getContext()))
          {
            m = n;
            if (!bool)
            {
              m = n;
              if (localColorNote != null)
              {
                m = n;
                if (amhh.a(localColorNote))
                {
                  if (!this.jdField_a_of_type_Amgo.a()) {
                    break label556;
                  }
                  amhh.a(localColorNote);
                  Bundle localBundle = localColorNote.parseBundle();
                  localBundle.putInt("color_note_curd_from_type", 1);
                  this.jdField_a_of_type_Amgo.a(localBundle);
                  this.jdField_f_of_type_Boolean = true;
                  if (this.jdField_a_of_type_Amkp != null) {
                    this.jdField_a_of_type_Amkp.a();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("SwipePostTableLayout", 1, "add colornote from swipe entrance:\n" + localColorNote.mServiceType + "\n" + localColorNote.mSubType + "\n" + localColorNote.mMainTitle + "\n" + localColorNote.mSubTitle + "\n" + localColorNote.mPicUrl);
                  }
                  axqy.b(null, "dc00898", "", "", "0X800A742", "0X800A742", amgm.a(this.jdField_a_of_type_Amgv.getColorNote().mServiceType), 0, "", "", "", "");
                  m = 1;
                }
              }
            }
          }
        }
      }
      if (amhj.a().a().x < this.jdField_f_of_type_Int / 2) {
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
        if (this.jdField_a_of_type_Amkp != null) {
          this.jdField_a_of_type_Amkp.a();
        }
      }
      if (((m != 0) || (bool)) && (paramMotionEvent.getRawX() - this.c >= this.jdField_f_of_type_Int / 2))
      {
        this.jdField_a_of_type_Amkl.sendEmptyMessage(1);
        postInvalidate();
        return true;
        label556:
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(0.0D);
        g();
        k();
        axqy.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        return true;
        if ((this.jdField_a_of_type_Boolean) && (amhh.a(localColorNote)))
        {
          if (!this.jdField_a_of_type_Amkr.a(paramMotionEvent, getContext()))
          {
            this.j = true;
            label642:
            if ((!this.jdField_h_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
              break label896;
            }
            if (d <= 1.0E-008D) {
              break label918;
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
            if (!this.jdField_a_of_type_Amgo.a()) {
              break label908;
            }
            if (!this.jdField_a_of_type_Amkr.a(paramMotionEvent, getContext())) {
              break label898;
            }
            this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.b();
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(d);
            if (!this.i) {
              break;
            }
            axqy.b(null, "dc00898", "", "", "0X800A741", "0X800A741", amgm.a(this.jdField_a_of_type_Amgv.getColorNote().mServiceType), 0, "", "", "", "");
            this.i = false;
            break;
            if ((!this.jdField_h_of_type_Boolean) || (!this.jdField_a_of_type_Boolean) || (!this.j) || (bool)) {
              break label642;
            }
            this.jdField_a_of_type_AndroidOsVibrator.vibrate(50L);
            this.j = false;
            break label642;
            label896:
            break;
            label898:
            this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a();
            continue;
            label908:
            this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.c();
          }
          label918:
          this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.setVisibility(4);
          this.jdField_g_of_type_Boolean = false;
        }
      }
    }
  }
  
  public void setOnColorNoteCurdListener(amgq paramamgq)
  {
    this.jdField_a_of_type_Amgo.a(paramamgq);
  }
  
  public void setOnPageSwipeListener(amkp paramamkp)
  {
    this.jdField_a_of_type_Amkp = paramamkp;
  }
  
  public void setServiceInfo(amgv paramamgv)
  {
    if (paramamgv != null)
    {
      this.jdField_a_of_type_Amgv = paramamgv;
      this.jdField_a_of_type_Amjh.a(paramamgv);
      paramamgv = paramamgv.getColorNote();
      if ((paramamgv != null) && (paramamgv.mServiceType == 16908288)) {
        jdField_g_of_type_Int = jdField_h_of_type_Int;
      }
    }
  }
  
  public void setTranslucentConvertor(amks paramamks)
  {
    this.jdField_a_of_type_Amks = paramamks;
    paramamks.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout
 * JD-Core Version:    0.7.0.1
 */