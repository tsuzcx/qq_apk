package com.tencent.qqmini.sdk.monitor.ui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import beiw;
import bexl;
import bext;
import bexv;
import bexw;

public class MiniAppMonitorInfoView
  extends FrameLayout
{
  public static long a;
  public static long b;
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = beiw.c();
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bexw jdField_a_of_type_Bexw;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MiniAppMonitorInfoView.1(this);
  private volatile boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  
  public MiniAppMonitorInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MiniAppMonitorInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559309, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370379));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370378));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370367));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370376));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370375));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370369));
    this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370368));
    this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370364));
    this.i = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370365));
    this.j = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370366));
    setMiniAppType(paramInt);
    c();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        if (this.jdField_a_of_type_Bexw == null) {
          this.jdField_a_of_type_Bexw = new bexw(this, null);
        }
        bexl.a().a(this.jdField_a_of_type_Bexw);
      }
    }
  }
  
  public void a(double paramDouble)
  {
    if (this.f != null)
    {
      String str = "帧率: " + String.format("%.0f", new Object[] { Double.valueOf(paramDouble) }) + "fps";
      this.f.setText(str);
      bext.a().a(paramDouble);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_Bexw != null) {
        bexl.a().b(this.jdField_a_of_type_Bexw);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void c()
  {
    if (this.c != null)
    {
      this.c.setText("启动耗时：" + jdField_a_of_type_Long + "ms");
      this.c.setVisibility(0);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("包下载耗时：" + jdField_b_of_type_Long + "ms");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  protected void d()
  {
    String str = "";
    bexv localbexv = bext.a().a();
    if (localbexv != null) {
      str = "" + "切换页面耗时: " + localbexv.d + "ms";
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (localbexv != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    else if (this.g != null)
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label231;
      }
      this.g.setVisibility(0);
    }
    for (;;)
    {
      str = bext.a().a();
      if (this.h != null)
      {
        this.h.setText(str);
        this.h.setVisibility(0);
      }
      str = bext.a().b();
      if (this.i != null)
      {
        this.i.setText(str);
        this.i.setVisibility(0);
      }
      str = "内存 使用率: " + bext.a().a() + "%";
      if (this.j != null)
      {
        this.j.setText(str);
        this.j.setVisibility(0);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("切换页面耗时: 无页面切换");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label231:
      this.g.setVisibility(8);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    bringToFront();
  }
  
  public void setMiniAppType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView
 * JD-Core Version:    0.7.0.1
 */