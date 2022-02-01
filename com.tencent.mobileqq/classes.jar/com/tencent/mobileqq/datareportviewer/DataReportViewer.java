package com.tencent.mobileqq.datareportviewer;

import afez;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import arzl;
import arzm;
import arzq;
import arzr;
import arzs;
import arzt;
import arzv;
import bhgr;
import bhlo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
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
  protected arzv a;
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
    LayoutInflater.from(paramContext).inflate(2131559611, this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131373129);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370040));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373128));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371313));
    this.b = ((Button)findViewById(2131364559));
    this.c = ((Button)findViewById(2131377445));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131363066));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131370019));
    localLinearLayout.setBackgroundColor(getResources().getColor(2131165379));
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
    this.jdField_a_of_type_Arzv = new arzv(this);
    new DefaultItemAnimator().setRemoveDuration(500L);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Arzv);
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new arzl(this));
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new arzm(this, paramContext));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DataReportViewer.3(this), 3000L);
    }
  }
  
  public void a(ReportData paramReportData)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramReportData);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
    this.jdField_a_of_type_Arzv.notifyDataSetChanged();
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
    Object localObject = ValueAnimator.ofFloat(new float[] { bhgr.a(getContext(), 25.0F), (float)bhlo.k() });
    ((ValueAnimator)localObject).setDuration(500L);
    ((ValueAnimator)localObject).addUpdateListener(new arzq(this));
    ((ValueAnimator)localObject).setTarget(this);
    ((ValueAnimator)localObject).start();
    localObject = new AlphaAnimation(1.0F, 0.5F);
    ((AlphaAnimation)localObject).setDuration(200L);
    ((AlphaAnimation)localObject).setAnimationListener(new arzr(this));
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject);
  }
  
  protected void c()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { (float)bhlo.k(), bhgr.a(getContext(), 25.0F) });
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new arzs(this));
    localValueAnimator.setTarget(this);
    localValueAnimator.start();
    localValueAnimator.addListener(new arzt(this));
  }
  
  public void d() {}
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    float f2 = bhgr.a(getContext(), 25.0F);
    float f3 = bhgr.a(getContext(), 25.0F);
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
      this.jdField_a_of_type_Arzv.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DataReportViewer.8(this), 3000L);
      continue;
      afez.a(getContext(), PublicFragmentActivity.class, DataReportSettingFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer
 * JD-Core Version:    0.7.0.1
 */