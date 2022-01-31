package com.tencent.mobileqq.colornote.swipeback;

import alru;
import alrw;
import alry;
import alsd;
import alsr;
import alss;
import altx;
import alur;
import aluw;
import aluy;
import aluz;
import alva;
import alvb;
import alvc;
import alvd;
import alve;
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
import awqx;
import azve;
import azvv;
import bafb;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class SwipePostTableLayout
  extends SwipeBackLayout
  implements alve
{
  private alrw jdField_a_of_type_Alrw;
  private alsd jdField_a_of_type_Alsd;
  private altx jdField_a_of_type_Altx;
  private alur jdField_a_of_type_Alur = new aluy(this);
  private alvc jdField_a_of_type_Alvc;
  private alvd jdField_a_of_type_Alvd;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  private bafb jdField_a_of_type_Bafb;
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
    this.jdField_a_of_type_Alvc = new alvc(paramContext);
    this.jdField_a_of_type_Alrw = new alrw();
    this.jdField_a_of_type_Alrw.a(new alry());
    this.jdField_a_of_type_Altx = new altx();
    this.jdField_a_of_type_Altx.a(this.jdField_a_of_type_Alrw);
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)paramContext.getSystemService("vibrator"));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new alvb(this));
    alss.a().a(this.jdField_a_of_type_Alur);
    jdField_h_of_type_Int = azvv.a(paramContext, 18.0F);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bafb == null)
    {
      this.jdField_a_of_type_Bafb = new bafb(this.jdField_a_of_type_AndroidContentContext, 2131690181);
      this.jdField_a_of_type_Bafb.setContentView(2131493345);
      this.jdField_a_of_type_Bafb.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bafb.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131625297));
      this.jdField_a_of_type_Bafb.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131625296), new aluz(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bafb.show();
      TextView localTextView = this.jdField_a_of_type_Bafb.getTitleTextView();
      localTextView.setClickable(true);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      azve.a(localTextView, true);
      return;
      if (this.jdField_a_of_type_Bafb.isShowing()) {
        this.jdField_a_of_type_Bafb.dismiss();
      }
    }
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Altx.a();
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
    this.jdField_a_of_type_Altx.b();
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Altx.c();
  }
  
  public void e_(boolean paramBoolean)
  {
    if (this.k)
    {
      this.k = false;
      this.jdField_a_of_type_Aluw.sendEmptyMessage(1);
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
    this.jdField_a_of_type_Altx.a(false);
  }
  
  public void j()
  {
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_Altx.a(true);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Alrw.b()) {
      i();
    }
    double d = this.jdField_a_of_type_Alvc.a(paramMotionEvent);
    this.jdField_a_of_type_Alrw.a();
    if (this.jdField_a_of_type_Alsd == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    ColorNote localColorNote = this.jdField_a_of_type_Alsd.getColorNote();
    if ((localColorNote == null) || (this.jdField_a_of_type_AndroidViewView.getScrollX() == 0) || (TextUtils.isEmpty(localColorNote.mSubType))) {
      return super.onTouchEvent(paramMotionEvent);
    }
    boolean bool = this.jdField_a_of_type_Alrw.a(localColorNote.getServiceType(), localColorNote.getSubType());
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
          if (this.jdField_a_of_type_Alvc.a(paramMotionEvent, getContext()))
          {
            m = n;
            if (!bool)
            {
              m = n;
              if (localColorNote != null)
              {
                m = n;
                if (alsr.a(localColorNote))
                {
                  if (!this.jdField_a_of_type_Alrw.a()) {
                    break label556;
                  }
                  alsr.a(localColorNote);
                  Bundle localBundle = localColorNote.parseBundle();
                  localBundle.putInt("color_note_curd_from_type", 1);
                  this.jdField_a_of_type_Alrw.a(localBundle);
                  this.jdField_f_of_type_Boolean = true;
                  if (this.jdField_a_of_type_Alva != null) {
                    this.jdField_a_of_type_Alva.a();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("SwipePostTableLayout", 1, "add colornote from swipe entrance:\n" + localColorNote.mServiceType + "\n" + localColorNote.mSubType + "\n" + localColorNote.mMainTitle + "\n" + localColorNote.mSubTitle + "\n" + localColorNote.mPicUrl);
                  }
                  awqx.b(null, "dc00898", "", "", "0X800A742", "0X800A742", alru.a(this.jdField_a_of_type_Alsd.getColorNote().mServiceType), 0, "", "", "", "");
                  m = 1;
                }
              }
            }
          }
        }
      }
      if (alss.a().a().x < this.jdField_f_of_type_Int / 2) {
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
        if (this.jdField_a_of_type_Alva != null) {
          this.jdField_a_of_type_Alva.a();
        }
      }
      if (((m != 0) || (bool)) && (paramMotionEvent.getRawX() - this.c >= this.jdField_f_of_type_Int / 2))
      {
        this.jdField_a_of_type_Aluw.sendEmptyMessage(1);
        postInvalidate();
        return true;
        label556:
        this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackPostTable.a(0.0D);
        g();
        k();
        awqx.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 1, 0, "", "", "", "");
        return true;
        if ((this.jdField_a_of_type_Boolean) && (alsr.a(localColorNote)))
        {
          if (!this.jdField_a_of_type_Alvc.a(paramMotionEvent, getContext()))
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
            if (!this.jdField_a_of_type_Alrw.a()) {
              break label908;
            }
            if (!this.jdField_a_of_type_Alvc.a(paramMotionEvent, getContext())) {
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
            awqx.b(null, "dc00898", "", "", "0X800A741", "0X800A741", alru.a(this.jdField_a_of_type_Alsd.getColorNote().mServiceType), 0, "", "", "", "");
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
  
  public void setOnColorNoteCurdListener(alry paramalry)
  {
    this.jdField_a_of_type_Alrw.a(paramalry);
  }
  
  public void setOnPageSwipeListener(alva paramalva)
  {
    this.jdField_a_of_type_Alva = paramalva;
  }
  
  public void setServiceInfo(alsd paramalsd)
  {
    if (paramalsd != null)
    {
      this.jdField_a_of_type_Alsd = paramalsd;
      this.jdField_a_of_type_Altx.a(paramalsd);
      paramalsd = paramalsd.getColorNote();
      if ((paramalsd != null) && (paramalsd.mServiceType == 16908288)) {
        jdField_g_of_type_Int = jdField_h_of_type_Int;
      }
    }
  }
  
  public void setTranslucentConvertor(alvd paramalvd)
  {
    this.jdField_a_of_type_Alvd = paramalvd;
    paramalvd.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout
 * JD-Core Version:    0.7.0.1
 */