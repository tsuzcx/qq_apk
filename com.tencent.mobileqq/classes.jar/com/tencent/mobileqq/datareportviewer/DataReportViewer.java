package com.tencent.mobileqq.datareportviewer;

import adxr;
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
import aqti;
import aqtj;
import aqtl;
import aqtm;
import aqtn;
import aqto;
import aqtp;
import aqtq;
import aqtr;
import aqts;
import aqtt;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class DataReportViewer
  extends RelativeLayout
  implements View.OnClickListener
{
  public float a;
  protected Path a;
  protected Handler a;
  protected Button a;
  protected CheckBox a;
  public LinearLayout a;
  protected ListView a;
  public RelativeLayout a;
  public TextView a;
  protected aqts a;
  public ArrayList<ReportData> a;
  public boolean a;
  protected Button b;
  protected Button c;
  
  public DataReportViewer(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = true;
    LayoutInflater.from(paramContext).inflate(2131559613, this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131373099);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370037));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373098));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371282));
    this.b = ((Button)findViewById(2131364580));
    this.c = ((Button)findViewById(2131377208));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131363083));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131370016));
    localLinearLayout.setBackgroundColor(getResources().getColor(2131165387));
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
    this.jdField_a_of_type_Aqts = new aqts(this);
    new DefaultItemAnimator().setRemoveDuration(500L);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Aqts);
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new aqti(this));
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new aqtl(this, paramContext));
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2131559611, null));
    }
    aqtt localaqtt = new aqtt(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    ReportData localReportData = (ReportData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localaqtt.jdField_a_of_type_AndroidWidgetTextView.setText(localReportData.table);
    localaqtt.b.setText(localReportData.mainAction);
    localaqtt.c.setText(localReportData.subAction);
    localaqtt.d.setText(localReportData.actionName);
    localaqtt.e.setText(String.valueOf(localReportData.opType));
    localaqtt.f.setText(String.valueOf(localReportData.result));
    localaqtt.g.setText(localReportData.r2);
    localaqtt.h.setText(localReportData.r3);
    localaqtt.i.setText(localReportData.r4);
    localaqtt.j.setText(localReportData.r5);
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365547)).setOnClickListener(new aqtm(this, localWindowManager));
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365541)).setOnClickListener(new aqtn(this, paramContext, localReportData, localWindowManager));
    if (Build.VERSION.SDK_INT >= 26) {}
    for (paramInt = 2038;; paramInt = 2003)
    {
      paramContext = new WindowManager.LayoutParams(-1, -1, paramInt, 776, -2);
      paramContext.gravity = 49;
      localWindowManager.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramContext);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aqto(this, localWindowManager));
      return;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DataReportViewer.6(this), 3000L);
    }
  }
  
  public void a(ReportData paramReportData)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramReportData);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
    this.jdField_a_of_type_Aqts.notifyDataSetChanged();
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
    Object localObject = ValueAnimator.ofFloat(new float[] { DisplayUtil.dip2px(getContext(), 25.0F), (float)DeviceInfoUtil.getWidth() });
    ((ValueAnimator)localObject).setDuration(500L);
    ((ValueAnimator)localObject).addUpdateListener(new aqtp(this));
    ((ValueAnimator)localObject).setTarget(this);
    ((ValueAnimator)localObject).start();
    localObject = new AlphaAnimation(1.0F, 0.5F);
    ((AlphaAnimation)localObject).setDuration(200L);
    ((AlphaAnimation)localObject).setAnimationListener(new aqtq(this));
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject);
  }
  
  protected void c()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { (float)DeviceInfoUtil.getWidth(), DisplayUtil.dip2px(getContext(), 25.0F) });
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new aqtr(this));
    localValueAnimator.setTarget(this);
    localValueAnimator.start();
    localValueAnimator.addListener(new aqtj(this));
  }
  
  public void d() {}
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    float f2 = DisplayUtil.dip2px(getContext(), 25.0F);
    float f3 = DisplayUtil.dip2px(getContext(), 25.0F);
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
      this.jdField_a_of_type_Aqts.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DataReportViewer.11(this), 3000L);
      continue;
      adxr.a(getContext(), PublicFragmentActivity.class, DataReportSettingFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer
 * JD-Core Version:    0.7.0.1
 */