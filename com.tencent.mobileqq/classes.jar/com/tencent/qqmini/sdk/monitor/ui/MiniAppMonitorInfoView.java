package com.tencent.qqmini.sdk.monitor.ui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import bgls;
import bgun;
import bhbe;
import bhbm;
import bhbo;
import bhbp;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;

public class MiniAppMonitorInfoView
  extends FrameLayout
{
  public static long a;
  public static long b;
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = ThreadManager.c();
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhbp jdField_a_of_type_Bhbp;
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
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559358, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370702));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370701));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370690));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370699));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370698));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370692));
    this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370691));
    this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370687));
    this.i = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370688));
    this.j = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370689));
    setMiniAppType(paramInt);
    c();
  }
  
  private bgls a()
  {
    bgun localbgun = AppRuntimeLoaderManager.g().getCurrentRunTimeLoader();
    if (localbgun == null) {
      return null;
    }
    return localbgun.getRuntime();
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
        if (this.jdField_a_of_type_Bhbp == null) {
          this.jdField_a_of_type_Bhbp = new bhbp(this, null);
        }
        bhbe.a().a(this.jdField_a_of_type_Bhbp);
      }
    }
  }
  
  public void a(double paramDouble)
  {
    if (this.f != null)
    {
      String str = "帧率: " + String.format("%.0f", new Object[] { Double.valueOf(paramDouble) }) + "fps";
      this.f.setText(str);
      bhbm.a().a(paramDouble);
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
      if (this.jdField_a_of_type_Bhbp != null) {
        bhbe.a().b(this.jdField_a_of_type_Bhbp);
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
    Object localObject = "";
    bhbo localbhbo = bhbm.a().a();
    if (localbhbo != null) {
      localObject = "" + "切换页面耗时: " + localbhbo.d + "ms";
    }
    long l;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (localbhbo != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    else if (this.g != null)
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label280;
      }
      localObject = a();
      if (localObject == null) {
        break label275;
      }
      l = ((bgls)localObject).a();
      label107:
      this.g.setText("drawCall: " + l);
      this.g.setVisibility(0);
    }
    for (;;)
    {
      localObject = bhbm.a().a();
      if (this.h != null)
      {
        this.h.setText((CharSequence)localObject);
        this.h.setVisibility(0);
      }
      localObject = bhbm.a().b();
      if (this.i != null)
      {
        this.i.setText((CharSequence)localObject);
        this.i.setVisibility(0);
      }
      localObject = "内存 使用率: " + bhbm.a().a() + "%";
      if (this.j != null)
      {
        this.j.setText((CharSequence)localObject);
        this.j.setVisibility(0);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("切换页面耗时: 无页面切换");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label275:
      l = 0L;
      break label107;
      label280:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView
 * JD-Core Version:    0.7.0.1
 */