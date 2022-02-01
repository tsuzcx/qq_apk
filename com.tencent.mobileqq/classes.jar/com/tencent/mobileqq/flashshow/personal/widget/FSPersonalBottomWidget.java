package com.tencent.mobileqq.flashshow.personal.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.flashshow.activity.FSComponentActivity;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.fragment.FSPersonalFeedFragment;
import com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalFeedVpAdapter;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalTab;
import com.tencent.mobileqq.flashshow.personal.widget.viewindicator.ViewIndicator;
import com.tencent.mobileqq.flashshow.personal.widget.viewindicator.ViewIndicator.TextItemClickListener;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class FSPersonalBottomWidget
  extends FSBaseWidgetView<ArrayList<FSPersonalTab>>
  implements ViewIndicator.TextItemClickListener
{
  private FSComponentActivity a;
  private LinearLayout b;
  private ViewIndicator c;
  private ViewPager2 d;
  private FSPersonalFeedVpAdapter e;
  private List<String> f = new ArrayList();
  private List<FSPersonalTab> g;
  private final String h;
  private final int i;
  private final float j;
  private final double k;
  private boolean l = true;
  private float m;
  private float n;
  
  public FSPersonalBottomWidget(@NonNull Context paramContext, String paramString)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.h = paramString;
    this.i = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.j = ImmersiveUtils.getScreenWidth();
    this.k = Math.tan(0.5235987755982988D);
  }
  
  private void a()
  {
    FSComponentActivity localFSComponentActivity = this.a;
    if (localFSComponentActivity == null)
    {
      QLog.i("FSPersonalBottomWidget", 1, "mFragmentActivity is null");
      return;
    }
    this.e = new FSPersonalFeedVpAdapter(localFSComponentActivity.g());
    this.d.setAdapter(this.e);
  }
  
  private void a(FSPersonalFeedFragment paramFSPersonalFeedFragment)
  {
    this.b.setOnClickListener(new FSPersonalBottomWidget.4(this, paramFSPersonalFeedFragment));
    paramFSPersonalFeedFragment.a(new FSPersonalBottomWidget.5(this));
  }
  
  private void a(ArrayList<FSPersonalTab> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      this.f.set(i1, ((FSPersonalTab)paramArrayList.get(i1)).a());
      i1 += 1;
    }
    this.c.a(this.f);
  }
  
  private void b()
  {
    FSThreadUtils.b(new FSPersonalBottomWidget.2(this));
  }
  
  private void c()
  {
    FSThreadUtils.b(new FSPersonalBottomWidget.3(this));
  }
  
  private void d()
  {
    FSLpReportDc11001.a(new DataBuilder(getReportBean()).setActionType(11).setSubActionType(21).setThrActionType(2));
  }
  
  private void e()
  {
    FSLpReportDc11001.a(new DataBuilder(getReportBean()).setActionType(11).setSubActionType(19).setThrActionType(2));
  }
  
  private void f()
  {
    FSLpReportDc11001.a(new DataBuilder(getReportBean()).setActionType(11).setSubActionType(60).setThrActionType(1).setToUin(this.h));
  }
  
  public void a(int paramInt)
  {
    List localList = this.g;
    if ((localList != null) && (paramInt < localList.size()))
    {
      if (TextUtils.equals(((FSPersonalTab)this.g.get(paramInt)).b(), "fs_feed_type_personal_production"))
      {
        e();
        return;
      }
      d();
    }
  }
  
  protected void a(ArrayList<FSPersonalTab> paramArrayList, int paramInt)
  {
    this.g = paramArrayList;
    if (paramArrayList.size() == this.f.size())
    {
      a(paramArrayList);
      return;
    }
    this.f = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    while (paramInt < paramArrayList.size())
    {
      FSPersonalTab localFSPersonalTab = (FSPersonalTab)paramArrayList.get(paramInt);
      FSPersonalFeedFragment localFSPersonalFeedFragment = FSPersonalFeedFragment.a(localFSPersonalTab.b());
      if (TextUtils.equals(localFSPersonalTab.b(), "fs_feed_type_personal_production"))
      {
        a(localFSPersonalFeedFragment);
        c();
      }
      else
      {
        b();
      }
      localArrayList.add(localFSPersonalFeedFragment);
      this.f.add(localFSPersonalTab.a());
      paramInt += 1;
    }
    this.c.a(this.d);
    this.e.a(localArrayList);
    this.c.a(this.f);
    this.c.a(this);
  }
  
  public int getLayoutId()
  {
    return 2131624835;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    if ((paramContext instanceof FSComponentActivity))
    {
      this.a = ((FSComponentActivity)paramContext);
      this.c = ((ViewIndicator)paramView.findViewById(2131437873));
      this.d = ((ViewPager2)paramView.findViewById(2131450001));
      this.d.registerOnPageChangeCallback(new FSPersonalBottomWidget.1(this));
      this.b = ((LinearLayout)paramView.findViewById(2131437480));
      a();
      return;
    }
    QLog.i("FSPersonalBottomWidget", 1, "context is not FragmentActivity");
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.l)
    {
      int i1 = paramMotionEvent.getAction();
      if (i1 != 0)
      {
        if (i1 == 2)
        {
          float f1 = paramMotionEvent.getX();
          float f3 = paramMotionEvent.getY();
          float f2 = Math.abs(this.m - f1);
          f3 = Math.abs(this.n - f3);
          if (f1 - this.m > this.i)
          {
            double d1 = f2;
            double d2 = this.k;
            Double.isNaN(d1);
            if (d1 * d2 > f3) {
              return true;
            }
          }
        }
      }
      else
      {
        this.m = paramMotionEvent.getX();
        this.n = paramMotionEvent.getY();
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.l) && (paramMotionEvent.getAction() == 1))
    {
      float f1 = paramMotionEvent.getX();
      float f2 = this.m;
      if ((f1 - f2 > 0.0F) && (f1 - f2 >= this.j / 4.0F) && ((getContext() instanceof Activity))) {
        ((Activity)getContext()).finish();
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.FSPersonalBottomWidget
 * JD-Core Version:    0.7.0.1
 */