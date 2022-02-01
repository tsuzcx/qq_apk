package com.tencent.mobileqq.datareportviewer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class DataReportViewer
  extends RelativeLayout
  implements View.OnClickListener
{
  protected float a;
  protected Path a;
  protected Handler a;
  protected Button a;
  protected CheckBox a;
  protected LinearLayout a;
  protected ListView a;
  protected RelativeLayout a;
  protected TextView a;
  protected DataReportViewer.DataAdapter a;
  protected ArrayList<ReportData> a;
  protected boolean a;
  protected Button b;
  protected Button c;
  
  public DataReportViewer(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = true;
    LayoutInflater.from(paramContext).inflate(2131559724, this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131373634);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370481));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373633));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371780));
    this.b = ((Button)findViewById(2131364777));
    this.c = ((Button)findViewById(2131377899));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131363145));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131370459));
    localLinearLayout.setBackgroundColor(getResources().getColor(2131165393));
    int i = 0;
    while (i < localLinearLayout.getChildCount())
    {
      View localView = localLinearLayout.getChildAt(i);
      if ((localView instanceof TextView))
      {
        ((TextView)localView).setTextColor(-1);
        ((TextView)localView).setTypeface(Typeface.defaultFromStyle(1));
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer$DataAdapter = new DataReportViewer.DataAdapter(this);
    new DefaultItemAnimator().setRemoveDuration(500L);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer$DataAdapter);
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new DataReportViewer.1(this));
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new DataReportViewer.2(this, paramContext));
  }
  
  private void a(Context paramContext, int paramInt)
  {
    if (ContextCompat.checkSelfPermission(paramContext, "android.permission.SYSTEM_ALERT_WINDOW") != 0)
    {
      QQToast.a(paramContext, "没有权限，请开启浮窗权限！", 0).a();
      return;
    }
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2131559722, null));
    }
    DataReportViewer.ViewHolder localViewHolder = new DataReportViewer.ViewHolder(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    ReportData localReportData = (ReportData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localReportData.table);
    localViewHolder.b.setText(localReportData.mainAction);
    localViewHolder.c.setText(localReportData.subAction);
    localViewHolder.d.setText(localReportData.actionName);
    localViewHolder.e.setText(String.valueOf(localReportData.opType));
    localViewHolder.f.setText(String.valueOf(localReportData.result));
    localViewHolder.g.setText(localReportData.r2);
    localViewHolder.h.setText(localReportData.r3);
    localViewHolder.i.setText(localReportData.r4);
    localViewHolder.j.setText(localReportData.r5);
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365802)).setOnClickListener(new DataReportViewer.3(this, localWindowManager));
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365796)).setOnClickListener(new DataReportViewer.4(this, paramContext, localReportData, localWindowManager));
    if (Build.VERSION.SDK_INT >= 26) {}
    for (paramInt = 2038;; paramInt = 2003)
    {
      paramContext = new WindowManager.LayoutParams(-1, -1, paramInt, 776, -2);
      paramContext.gravity = 49;
      localWindowManager.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramContext);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new DataReportViewer.5(this, localWindowManager));
      return;
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DataReportViewer.6(this), 3000L);
    }
  }
  
  public void a(ReportData paramReportData)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramReportData);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
    this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer$DataAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      a();
    }
    while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
      return;
    }
    if (!((ReportData)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 2)).isLightBlueBg) {}
    for (boolean bool = true;; bool = false)
    {
      paramReportData.isLightBlueBg = bool;
      return;
    }
  }
  
  protected void b()
  {
    Object localObject = ValueAnimator.ofFloat(new float[] { DisplayUtil.a(getContext(), 25.0F), (float)DeviceInfoUtil.k() });
    ((ValueAnimator)localObject).setDuration(500L);
    ((ValueAnimator)localObject).addUpdateListener(new DataReportViewer.7(this));
    ((ValueAnimator)localObject).setTarget(this);
    ((ValueAnimator)localObject).start();
    localObject = new AlphaAnimation(1.0F, 0.5F);
    ((AlphaAnimation)localObject).setDuration(200L);
    ((AlphaAnimation)localObject).setAnimationListener(new DataReportViewer.8(this));
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject);
  }
  
  protected void c()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { (float)DeviceInfoUtil.k(), DisplayUtil.a(getContext(), 25.0F) });
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new DataReportViewer.9(this));
    localValueAnimator.setTarget(this);
    localValueAnimator.start();
    localValueAnimator.addListener(new DataReportViewer.10(this));
  }
  
  public void d() {}
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    float f2 = DisplayUtil.a(getContext(), 25.0F);
    float f3 = DisplayUtil.a(getContext(), 25.0F);
    if (this.jdField_a_of_type_Float == 0.0F) {}
    for (float f1 = getWidth();; f1 = this.jdField_a_of_type_Float)
    {
      localPath.addCircle(f2, f3, f1, Path.Direction.CW);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      super.draw(paramCanvas);
      return;
    }
  }
  
  public void e() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c();
      continue;
      b();
      continue;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
      this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer$DataAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DataReportViewer.11(this), 3000L);
      continue;
      PublicFragmentActivity.Launcher.a(getContext(), PublicFragmentActivity.class, DataReportSettingFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer
 * JD-Core Version:    0.7.0.1
 */