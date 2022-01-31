package com.tencent.mobileqq.colornote.swipeback;

import amgn;
import amgp;
import amgr;
import amgw;
import amhi;
import amhk;
import amji;
import amkh;
import amkm;
import amko;
import amkp;
import amkq;
import amkr;
import amks;
import amkt;
import amku;
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
import axqw;
import bawi;
import bawz;
import bbgg;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class SwipePostTableLayout
  extends SwipeBackLayout
  implements amku
{
  private amgp jdField_a_of_type_Amgp;
  private amgw jdField_a_of_type_Amgw;
  private amji jdField_a_of_type_Amji;
  private amkh jdField_a_of_type_Amkh = new amko(this);
  private amks jdField_a_of_type_Amks;
  private amkt jdField_a_of_type_Amkt;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private bbgg jdField_a_of_type_Bbgg;
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
    this.jdField_a_of_type_Amks = new amks(paramContext);
    this.jdField_a_of_type_Amgp = new amgp();
    this.jdField_a_of_type_Amgp.a(new amgr());
    this.jdField_a_of_type_Amji = new amji();
    this.jdField_a_of_type_Amji.a(this.jdField_a_of_type_Amgp);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new amkr(this));
    amhk.a().a(this.jdField_a_of_type_Amkh);
    jdField_h_of_type_Int = bawz.a(paramContext, 18.0F);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bbgg == null)
    {
      this.jdField_a_of_type_Bbgg = new bbgg(this.jdField_a_of_type_AndroidContentContext, 2131755791);
      this.jdField_a_of_type_Bbgg.setContentView(2131558906);
      this.jdField_a_of_type_Bbgg.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bbgg.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131690864));
      this.jdField_a_of_type_Bbgg.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690863), new amkp(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbgg.show();
      TextView localTextView = this.jdField_a_of_type_Bbgg.getTitleTextView();
      localTextView.setClickable(true);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      bawi.a(localTextView, true);
      return;
      if (this.jdField_a_of_type_Bbgg.isShowing()) {
        this.jdField_a_of_type_Bbgg.dismiss();
      }
    }
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Amji.a();
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
    this.jdField_a_of_type_Amji.b();
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Amji.c();
  }
  
  public void d_(boolean paramBoolean)
  {
    if (this.k)
    {
      this.k = false;
      this.jdField_a_of_type_Amkm.sendEmptyMessage(1);
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
    this.jdField_a_of_type_Amji.a(false);
  }
  
  public void j()
  {
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_Amji.a(true);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Amgp.b()) {
      i();
    }
    double d = this.jdField_a_of_type_Amks.a(paramMotionEvent);
    this.jdField_a_of_type_Amgp.a();
    if (this.jdField_a_of_type_Amgw == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    ColorNote localColorNote = this.jdField_a_of_type_Amgw.getColorNote();
    if ((localColorNote == null) || (this.jdField_a_of_type_AndroidViewView.getScrollX() == 0) || (TextUtils.isEmpty(localColorNote.mSubType))) {
      return super.onTouchEvent(paramMotionEvent);
    }
    boolean bool = this.jdField_a_of_type_Amgp.a(localColorNote.getServiceType(), localColorNote.getSubType());
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
          if (this.jdField_a_of_type_Amks.a(paramMotionEvent, getContext()))
          {
            m = n;
            if (!bool)
            {
              m = n;
              if (localColorNote != null)
              {
                m = n;
                if (amhi.a(localColorNote))
                {
                  if (!this.jdField_a_of_type_Amgp.a()) {
                    break label556;
                  }
                  amhi.a(localColorNote);
                  Bundle localBundle = localColorNote.parseBundle();
                  localBundle.putInt("color_note_curd_from_type", 1);
                  this.jdField_a_of_type_Amgp.a(localBundle);
                  this.jdField_f_of_type_Boolean = true;
                  if (this.jdField_a_of_type_Amkq != null) {
                    this.jdField_a_of_type_Amkq.a();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("SwipePostTableLayout", 1, "add colornote from swipe entrance:\n" + localColorNote.mServiceType + "\n" + localColorNote.mSubType + "\n" + localColorNote.mMainTitle + "\n" + localColorNote.mSubTitle + "\n" + localColorNote.mPicUrl);
                  }
                  axqw.b(null, "dc00898", "", "", "0X800A742", "0X800A742", amgn.a(this.jdField_a_of_type_Amgw.getColorNote().mServiceType), 0, "", "", "", "");
                  m = 1;
                }
              }
            }
          }
        }
      }
      if (amhk.a().a().x < this.jdField_f_of_type_Int / 2) {
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
        if (this.jdField_a_of_type_Amkq != null) {
          this.jdField_a_of_type_Amkq.a();
        }
      }
      if (((m != 0) || (bool)) && (paramMotionEvent.getRawX() - this.c >= this.jdField_f_of_type_Int / 2))
      {
        this.jdField_a_of_type_Amkm.sendEmptyMessage(1);
        postInvalidate();
        return true;
        label556:
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(0.0D);
        g();
        k();
        axqw.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        return true;
        if ((this.jdField_a_of_type_Boolean) && (amhi.a(localColorNote)))
        {
          if (!this.jdField_a_of_type_Amks.a(paramMotionEvent, getContext()))
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
            if (!this.jdField_a_of_type_Amgp.a()) {
              break label908;
            }
            if (!this.jdField_a_of_type_Amks.a(paramMotionEvent, getContext())) {
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
            axqw.b(null, "dc00898", "", "", "0X800A741", "0X800A741", amgn.a(this.jdField_a_of_type_Amgw.getColorNote().mServiceType), 0, "", "", "", "");
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
  
  public void setOnColorNoteCurdListener(amgr paramamgr)
  {
    this.jdField_a_of_type_Amgp.a(paramamgr);
  }
  
  public void setOnPageSwipeListener(amkq paramamkq)
  {
    this.jdField_a_of_type_Amkq = paramamkq;
  }
  
  public void setServiceInfo(amgw paramamgw)
  {
    if (paramamgw != null)
    {
      this.jdField_a_of_type_Amgw = paramamgw;
      this.jdField_a_of_type_Amji.a(paramamgw);
      paramamgw = paramamgw.getColorNote();
      if ((paramamgw != null) && (paramamgw.mServiceType == 16908288)) {
        jdField_g_of_type_Int = jdField_h_of_type_Int;
      }
    }
  }
  
  public void setTranslucentConvertor(amkt paramamkt)
  {
    this.jdField_a_of_type_Amkt = paramamkt;
    paramamkt.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout
 * JD-Core Version:    0.7.0.1
 */