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
import anxm;
import anxo;
import anxq;
import anxw;
import anyi;
import anyk;
import aoai;
import aobe;
import aobj;
import aobl;
import aobm;
import aobn;
import aobo;
import aobp;
import aobq;
import aobr;
import azmj;
import bcvq;
import bcwh;
import bdfq;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class SwipePostTableLayout
  extends SwipeBackLayout
  implements aobr
{
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private anxo jdField_a_of_type_Anxo;
  private anxw jdField_a_of_type_Anxw;
  private aoai jdField_a_of_type_Aoai;
  private aobe jdField_a_of_type_Aobe = new aobl(this);
  private aobp jdField_a_of_type_Aobp;
  private aobq jdField_a_of_type_Aobq;
  private bdfq jdField_a_of_type_Bdfq;
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
    this.jdField_a_of_type_Aobp = new aobp(paramContext);
    this.jdField_a_of_type_Anxo = new anxo();
    this.jdField_a_of_type_Anxo.a(new anxq());
    this.jdField_a_of_type_Aoai = new aoai();
    this.jdField_a_of_type_Aoai.a(this.jdField_a_of_type_Anxo);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new aobo(this));
    anyk.a().a(this.jdField_a_of_type_Aobe);
    jdField_h_of_type_Int = bcwh.a(paramContext, 18.0F);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bdfq == null)
    {
      this.jdField_a_of_type_Bdfq = new bdfq(this.jdField_a_of_type_AndroidContentContext, 2131755801);
      this.jdField_a_of_type_Bdfq.setContentView(2131558943);
      this.jdField_a_of_type_Bdfq.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bdfq.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131690916));
      this.jdField_a_of_type_Bdfq.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690915), new aobm(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdfq.show();
      TextView localTextView = this.jdField_a_of_type_Bdfq.getTitleTextView();
      localTextView.setClickable(true);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      bcvq.a(localTextView, true);
      return;
      if (this.jdField_a_of_type_Bdfq.isShowing()) {
        this.jdField_a_of_type_Bdfq.dismiss();
      }
    }
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Aoai.a();
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
    this.jdField_a_of_type_Aoai.b();
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Aoai.c();
  }
  
  public void d_(boolean paramBoolean)
  {
    if (this.k)
    {
      this.k = false;
      this.jdField_a_of_type_Aobj.sendEmptyMessage(1);
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
    this.jdField_a_of_type_Aoai.a(false);
  }
  
  public void j()
  {
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_Aoai.a(true);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Anxo.b()) {
      i();
    }
    double d = this.jdField_a_of_type_Aobp.a(paramMotionEvent);
    this.jdField_a_of_type_Anxo.a();
    if (this.jdField_a_of_type_Anxw == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    ColorNote localColorNote = this.jdField_a_of_type_Anxw.getColorNote();
    if ((localColorNote == null) || (this.jdField_a_of_type_AndroidViewView.getScrollX() == 0) || (TextUtils.isEmpty(localColorNote.mSubType))) {
      return super.onTouchEvent(paramMotionEvent);
    }
    boolean bool = this.jdField_a_of_type_Anxo.a(localColorNote.getServiceType(), localColorNote.getSubType());
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
          if (this.jdField_a_of_type_Aobp.a(paramMotionEvent, getContext()))
          {
            m = n;
            if (!bool)
            {
              m = n;
              if (localColorNote != null)
              {
                m = n;
                if (anyi.a(localColorNote))
                {
                  if (!this.jdField_a_of_type_Anxo.a()) {
                    break label556;
                  }
                  anyi.a(localColorNote);
                  Bundle localBundle = localColorNote.parseBundle();
                  localBundle.putInt("color_note_curd_from_type", 1);
                  this.jdField_a_of_type_Anxo.a(localBundle);
                  this.jdField_f_of_type_Boolean = true;
                  if (this.jdField_a_of_type_Aobn != null) {
                    this.jdField_a_of_type_Aobn.a();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("SwipePostTableLayout", 1, "add colornote from swipe entrance:\n" + localColorNote.mServiceType + "\n" + localColorNote.mSubType + "\n" + localColorNote.mMainTitle + "\n" + localColorNote.mSubTitle + "\n" + localColorNote.mPicUrl);
                  }
                  azmj.b(null, "dc00898", "", "", "0X800A742", "0X800A742", anxm.a(this.jdField_a_of_type_Anxw.getColorNote().mServiceType), 0, "", "", "", "");
                  m = 1;
                }
              }
            }
          }
        }
      }
      if (anyk.a().a().x < this.jdField_f_of_type_Int / 2) {
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
        if (this.jdField_a_of_type_Aobn != null) {
          this.jdField_a_of_type_Aobn.a();
        }
      }
      if (((m != 0) || (bool)) && (paramMotionEvent.getRawX() - this.c >= this.jdField_f_of_type_Int / 2))
      {
        this.jdField_a_of_type_Aobj.sendEmptyMessage(1);
        postInvalidate();
        return true;
        label556:
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(0.0D);
        g();
        k();
        azmj.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        return true;
        if ((this.jdField_a_of_type_Boolean) && (anyi.a(localColorNote)))
        {
          if (!this.jdField_a_of_type_Aobp.a(paramMotionEvent, getContext()))
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
            if (!this.jdField_a_of_type_Anxo.a()) {
              break label908;
            }
            if (!this.jdField_a_of_type_Aobp.a(paramMotionEvent, getContext())) {
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
            azmj.b(null, "dc00898", "", "", "0X800A741", "0X800A741", anxm.a(this.jdField_a_of_type_Anxw.getColorNote().mServiceType), 0, "", "", "", "");
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
  
  public void setOnColorNoteCurdListener(anxq paramanxq)
  {
    this.jdField_a_of_type_Anxo.a(paramanxq);
  }
  
  public void setOnPageSwipeListener(aobn paramaobn)
  {
    this.jdField_a_of_type_Aobn = paramaobn;
  }
  
  public void setServiceInfo(anxw paramanxw)
  {
    if (paramanxw != null)
    {
      this.jdField_a_of_type_Anxw = paramanxw;
      this.jdField_a_of_type_Aoai.a(paramanxw);
      paramanxw = paramanxw.getColorNote();
      if ((paramanxw != null) && (paramanxw.mServiceType == 16908288)) {
        jdField_g_of_type_Int = jdField_h_of_type_Int;
      }
    }
  }
  
  public void setTranslucentConvertor(aobq paramaobq)
  {
    this.jdField_a_of_type_Aobq = paramaobq;
    paramaobq.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout
 * JD-Core Version:    0.7.0.1
 */