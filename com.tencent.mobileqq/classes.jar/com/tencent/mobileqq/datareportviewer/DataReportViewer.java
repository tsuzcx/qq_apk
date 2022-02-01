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
  protected LinearLayout a;
  protected ListView b;
  protected Button c;
  protected Button d;
  protected Button e;
  protected CheckBox f;
  protected TextView g;
  protected ArrayList<ReportData> h = new ArrayList(10);
  protected DataReportViewer.DataAdapter i;
  protected Path j;
  protected float k = 0.0F;
  protected Handler l = new Handler(Looper.getMainLooper());
  protected RelativeLayout m;
  protected boolean n = true;
  
  public DataReportViewer(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131625629, this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131440816);
    this.a = ((LinearLayout)findViewById(2131437304));
    this.g = ((TextView)findViewById(2131440815));
    this.c = ((Button)findViewById(2131438750));
    this.d = ((Button)findViewById(2131430754));
    this.e = ((Button)findViewById(2131445713));
    this.f = ((CheckBox)findViewById(2131428932));
    this.b = ((ListView)findViewById(2131437280));
    localLinearLayout.setBackgroundColor(getResources().getColor(2131165626));
    int i1 = 0;
    while (i1 < localLinearLayout.getChildCount())
    {
      Object localObject = localLinearLayout.getChildAt(i1);
      if ((localObject instanceof TextView))
      {
        localObject = (TextView)localObject;
        ((TextView)localObject).setTextColor(-1);
        ((TextView)localObject).setTypeface(Typeface.defaultFromStyle(1));
      }
      i1 += 1;
    }
    this.i = new DataReportViewer.DataAdapter(this);
    new DefaultItemAnimator().setRemoveDuration(500L);
    this.b.setAdapter(this.i);
    setWillNotDraw(false);
    this.j = new Path();
    this.g.setVisibility(8);
    this.g.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnCheckedChangeListener(new DataReportViewer.1(this));
    this.b.setOnItemClickListener(new DataReportViewer.2(this, paramContext));
  }
  
  private void a(Context paramContext, int paramInt)
  {
    if (ContextCompat.checkSelfPermission(paramContext, "android.permission.SYSTEM_ALERT_WINDOW") != 0)
    {
      QQToast.makeText(paramContext, "没有权限，请开启浮窗权限！", 0).show();
      return;
    }
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.m == null) {
      this.m = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2131625627, null));
    }
    DataReportViewer.ViewHolder localViewHolder = new DataReportViewer.ViewHolder(this, this.m);
    ReportData localReportData = (ReportData)this.h.get(paramInt);
    localViewHolder.a.setText(localReportData.table);
    localViewHolder.b.setText(localReportData.mainAction);
    localViewHolder.c.setText(localReportData.subAction);
    localViewHolder.d.setText(localReportData.actionName);
    localViewHolder.e.setText(String.valueOf(localReportData.opType));
    localViewHolder.f.setText(String.valueOf(localReportData.result));
    localViewHolder.g.setText(localReportData.r2);
    localViewHolder.h.setText(localReportData.r3);
    localViewHolder.i.setText(localReportData.r4);
    localViewHolder.j.setText(localReportData.r5);
    ((TextView)this.m.findViewById(2131431870)).setOnClickListener(new DataReportViewer.3(this, localWindowManager));
    ((TextView)this.m.findViewById(2131431864)).setOnClickListener(new DataReportViewer.4(this, paramContext, localReportData, localWindowManager));
    if (Build.VERSION.SDK_INT >= 26) {
      paramInt = 2038;
    } else {
      paramInt = 2003;
    }
    paramContext = new WindowManager.LayoutParams(-1, -1, paramInt, 776, -2);
    paramContext.gravity = 49;
    localWindowManager.addView(this.m, paramContext);
    this.m.setOnClickListener(new DataReportViewer.5(this, localWindowManager));
  }
  
  protected void a()
  {
    if (this.n) {
      this.l.postDelayed(new DataReportViewer.6(this), 3000L);
    }
  }
  
  public void a(ReportData paramReportData)
  {
    this.h.add(paramReportData);
    this.g.setText(String.valueOf(this.h.size()));
    this.i.notifyDataSetChanged();
    if (this.h.size() == 1)
    {
      this.l.removeCallbacksAndMessages(null);
      a();
      return;
    }
    if (this.h.size() > 1)
    {
      ArrayList localArrayList = this.h;
      paramReportData.isLightBlueBg = (((ReportData)localArrayList.get(localArrayList.size() - 2)).isLightBlueBg ^ true);
    }
  }
  
  protected void b()
  {
    Object localObject = ValueAnimator.ofFloat(new float[] { DisplayUtil.a(getContext(), 25.0F), (float)DeviceInfoUtil.F() });
    ((ValueAnimator)localObject).setDuration(500L);
    ((ValueAnimator)localObject).addUpdateListener(new DataReportViewer.7(this));
    ((ValueAnimator)localObject).setTarget(this);
    ((ValueAnimator)localObject).start();
    localObject = new AlphaAnimation(1.0F, 0.5F);
    ((AlphaAnimation)localObject).setDuration(200L);
    ((AlphaAnimation)localObject).setAnimationListener(new DataReportViewer.8(this));
    this.g.startAnimation((Animation)localObject);
  }
  
  protected void c()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { (float)DeviceInfoUtil.F(), DisplayUtil.a(getContext(), 25.0F) });
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
    this.j.reset();
    Path localPath = this.j;
    float f3 = DisplayUtil.a(getContext(), 25.0F);
    float f4 = DisplayUtil.a(getContext(), 25.0F);
    float f2 = this.k;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = getWidth();
    }
    localPath.addCircle(f3, f4, f1, Path.Direction.CW);
    paramCanvas.clipPath(this.j);
    super.draw(paramCanvas);
  }
  
  public void e() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131445713: 
      PublicFragmentActivity.Launcher.a(getContext(), PublicFragmentActivity.class, DataReportSettingFragment.class);
      break;
    case 2131440815: 
      b();
      break;
    case 2131438750: 
      c();
      break;
    case 2131430754: 
      this.l.removeCallbacksAndMessages(null);
      this.h.clear();
      this.g.setText(String.valueOf(this.h.size()));
      this.i.notifyDataSetChanged();
      this.l.postDelayed(new DataReportViewer.11(this), 3000L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer
 * JD-Core Version:    0.7.0.1
 */