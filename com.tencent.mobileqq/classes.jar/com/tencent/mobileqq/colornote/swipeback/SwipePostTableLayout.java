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
import android.widget.TextView;
import aobv;
import aobx;
import aobz;
import aocf;
import aocr;
import aoct;
import aoer;
import aofn;
import aofs;
import aofu;
import aofv;
import aofw;
import aofx;
import aofy;
import aofz;
import aoga;
import azqs;
import bczz;
import bdaq;
import bdjz;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class SwipePostTableLayout
  extends SwipeBackLayout
  implements aoga
{
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private aobx jdField_a_of_type_Aobx;
  private aocf jdField_a_of_type_Aocf;
  private aoer jdField_a_of_type_Aoer;
  private aofn jdField_a_of_type_Aofn = new aofu(this);
  private aofy jdField_a_of_type_Aofy;
  private aofz jdField_a_of_type_Aofz;
  private bdjz jdField_a_of_type_Bdjz;
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
    this.jdField_a_of_type_Aofy = new aofy(paramContext);
    this.jdField_a_of_type_Aobx = new aobx();
    this.jdField_a_of_type_Aobx.a(new aobz());
    this.jdField_a_of_type_Aoer = new aoer();
    this.jdField_a_of_type_Aoer.a(this.jdField_a_of_type_Aobx);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new aofx(this));
    aoct.a().a(this.jdField_a_of_type_Aofn);
    jdField_h_of_type_Int = bdaq.a(paramContext, 18.0F);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bdjz == null)
    {
      this.jdField_a_of_type_Bdjz = new bdjz(this.jdField_a_of_type_AndroidContentContext, 2131755801);
      this.jdField_a_of_type_Bdjz.setContentView(2131558942);
      this.jdField_a_of_type_Bdjz.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bdjz.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131690917));
      this.jdField_a_of_type_Bdjz.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690916), new aofv(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdjz.show();
      TextView localTextView = this.jdField_a_of_type_Bdjz.getTitleTextView();
      localTextView.setClickable(true);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      bczz.a(localTextView, true);
      return;
      if (this.jdField_a_of_type_Bdjz.isShowing()) {
        this.jdField_a_of_type_Bdjz.dismiss();
      }
    }
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Aoer.a();
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
    this.jdField_a_of_type_Aoer.b();
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Aoer.c();
  }
  
  public void d_(boolean paramBoolean)
  {
    if (this.k)
    {
      this.k = false;
      this.jdField_a_of_type_Aofs.sendEmptyMessage(1);
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
    this.jdField_a_of_type_Aoer.a(false);
  }
  
  public void j()
  {
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_Aoer.a(true);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Aobx.b()) {
      i();
    }
    double d = this.jdField_a_of_type_Aofy.a(paramMotionEvent);
    this.jdField_a_of_type_Aobx.a();
    if (this.jdField_a_of_type_Aocf == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    ColorNote localColorNote = this.jdField_a_of_type_Aocf.getColorNote();
    if ((localColorNote == null) || (this.jdField_a_of_type_AndroidViewView.getScrollX() == 0) || (TextUtils.isEmpty(localColorNote.mSubType))) {
      return super.onTouchEvent(paramMotionEvent);
    }
    boolean bool = this.jdField_a_of_type_Aobx.a(localColorNote.getServiceType(), localColorNote.getSubType());
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
          if (this.jdField_a_of_type_Aofy.a(paramMotionEvent, getContext()))
          {
            m = n;
            if (!bool)
            {
              m = n;
              if (localColorNote != null)
              {
                m = n;
                if (aocr.a(localColorNote))
                {
                  if (!this.jdField_a_of_type_Aobx.a()) {
                    break label556;
                  }
                  aocr.a(localColorNote);
                  Bundle localBundle = localColorNote.parseBundle();
                  localBundle.putInt("color_note_curd_from_type", 1);
                  this.jdField_a_of_type_Aobx.a(localBundle);
                  this.jdField_f_of_type_Boolean = true;
                  if (this.jdField_a_of_type_Aofw != null) {
                    this.jdField_a_of_type_Aofw.a();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("SwipePostTableLayout", 1, "add colornote from swipe entrance:\n" + localColorNote.mServiceType + "\n" + localColorNote.mSubType + "\n" + localColorNote.mMainTitle + "\n" + localColorNote.mSubTitle + "\n" + localColorNote.mPicUrl);
                  }
                  azqs.b(null, "dc00898", "", "", "0X800A742", "0X800A742", aobv.a(this.jdField_a_of_type_Aocf.getColorNote().mServiceType), 0, "", "", "", "");
                  m = 1;
                }
              }
            }
          }
        }
      }
      if (aoct.a().a().x < this.jdField_f_of_type_Int / 2) {
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
        if (this.jdField_a_of_type_Aofw != null) {
          this.jdField_a_of_type_Aofw.a();
        }
      }
      if (((m != 0) || (bool)) && (paramMotionEvent.getRawX() - this.c >= this.jdField_f_of_type_Int / 2))
      {
        this.jdField_a_of_type_Aofs.sendEmptyMessage(1);
        postInvalidate();
        return true;
        label556:
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(0.0D);
        g();
        k();
        azqs.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        return true;
        if ((this.jdField_a_of_type_Boolean) && (aocr.a(localColorNote)))
        {
          if (!this.jdField_a_of_type_Aofy.a(paramMotionEvent, getContext()))
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
            if (!this.jdField_a_of_type_Aobx.a()) {
              break label908;
            }
            if (!this.jdField_a_of_type_Aofy.a(paramMotionEvent, getContext())) {
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
            azqs.b(null, "dc00898", "", "", "0X800A741", "0X800A741", aobv.a(this.jdField_a_of_type_Aocf.getColorNote().mServiceType), 0, "", "", "", "");
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
  
  public void setOnColorNoteCurdListener(aobz paramaobz)
  {
    this.jdField_a_of_type_Aobx.a(paramaobz);
  }
  
  public void setOnPageSwipeListener(aofw paramaofw)
  {
    this.jdField_a_of_type_Aofw = paramaofw;
  }
  
  public void setServiceInfo(aocf paramaocf)
  {
    if (paramaocf != null)
    {
      this.jdField_a_of_type_Aocf = paramaocf;
      this.jdField_a_of_type_Aoer.a(paramaocf);
      paramaocf = paramaocf.getColorNote();
      if ((paramaocf != null) && (paramaocf.mServiceType == 16908288)) {
        jdField_g_of_type_Int = jdField_h_of_type_Int;
      }
    }
  }
  
  public void setTranslucentConvertor(aofz paramaofz)
  {
    this.jdField_a_of_type_Aofz = paramaofz;
    paramaofz.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout
 * JD-Core Version:    0.7.0.1
 */