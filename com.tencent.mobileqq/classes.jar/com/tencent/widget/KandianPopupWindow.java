package com.tencent.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class KandianPopupWindow
  extends PopupWindow
  implements View.OnClickListener
{
  private int A;
  private int B;
  protected boolean a = true;
  protected Button b;
  protected ImageView c;
  protected ArrayList<DislikeInfo> d;
  protected int e;
  protected ArrayList<DislikeInfo> f;
  protected KandianPopupWindow.OnUninterestConfirmListener g;
  protected KandianPopupWindow.OnComplainListener h;
  protected int[] i = { 2131449102, 2131449103, 2131449104, 2131449105 };
  protected int[] j = { 2131449107, 2131449108, 2131449109, 2131449110, 2131449111, 2131449112, 2131449113, 2131449114 };
  private Activity k;
  private View l;
  private boolean m;
  private RelativeLayout n;
  private Button o;
  private boolean p;
  private TextView q;
  private View r;
  private ImageView s;
  private ImageView t;
  private View[] u;
  private Button[] v;
  private RelativeLayout w;
  private View x;
  private int y;
  private int z;
  
  public KandianPopupWindow(Activity paramActivity)
  {
    super(paramActivity);
    this.k = paramActivity;
  }
  
  private void f()
  {
    this.q.setText(this.k.getString(2131897936));
    this.b.setEnabled(false);
  }
  
  private void g()
  {
    f();
    int i2 = this.d.size();
    Button[] arrayOfButton = this.v;
    int i1 = i2;
    if (i2 >= arrayOfButton.length) {
      i1 = arrayOfButton.length;
    }
    i2 = 0;
    while (i2 < i1)
    {
      if (TextUtils.isEmpty(((DislikeInfo)this.d.get(i2)).c))
      {
        this.v[i2].setVisibility(8);
      }
      else
      {
        this.v[i2].setVisibility(0);
        this.v[i2].setText(((DislikeInfo)this.d.get(i2)).c);
      }
      this.v[i2].setSelected(false);
      i2 += 1;
    }
    i2 = i1;
    int i3;
    for (;;)
    {
      arrayOfButton = this.v;
      int i4 = arrayOfButton.length;
      i3 = 1;
      if (i2 >= i4) {
        break;
      }
      if ((i2 == i1) && (i1 % 2 == 1)) {
        arrayOfButton[i2].setVisibility(4);
      } else {
        this.v[i2].setVisibility(8);
      }
      this.v[i2].setSelected(false);
      i2 += 1;
    }
    for (;;)
    {
      arrayOfButton = this.v;
      if (i3 >= arrayOfButton.length) {
        break;
      }
      if (arrayOfButton[i3].getVisibility() == 8) {
        this.u[(i3 / 2)].setVisibility(8);
      } else {
        this.u[(i3 / 2)].setVisibility(0);
      }
      i3 += 2;
    }
  }
  
  private void h()
  {
    this.l.measure(0, 0);
    this.z = this.l.getMeasuredHeight();
  }
  
  protected void a(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.format = -3;
    localLayoutParams.type = 1000;
    localLayoutParams.token = paramIBinder;
    localLayoutParams.windowAnimations = 16973828;
    this.x = new View(this.k.getApplicationContext());
    this.x.setBackgroundColor(-1895825408);
    this.x.setFitsSystemWindows(false);
    this.x.setOnKeyListener(new KandianPopupWindow.2(this));
    this.k.getWindowManager().addView(this.x, localLayoutParams);
  }
  
  public void a(View paramView, KandianPopupWindow.OnUninterestConfirmListener paramOnUninterestConfirmListener)
  {
    this.g = paramOnUninterestConfirmListener;
    a(paramView.getWindowToken());
    paramOnUninterestConfirmListener = new int[2];
    paramView.getLocationOnScreen(paramOnUninterestConfirmListener);
    if (!this.p)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DeviceInfoUtil.getWidth() = ");
        localStringBuilder.append(this.A);
        localStringBuilder.append(", DeviceInfoUtil.getHeight() = ");
        localStringBuilder.append(this.B);
        QLog.d("KandianPopupWindow", 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("popupWidth = ");
        localStringBuilder.append(this.y);
        localStringBuilder.append(", popupHeight = ");
        localStringBuilder.append(this.z);
        QLog.d("KandianPopupWindow", 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("x = ");
        localStringBuilder.append(paramOnUninterestConfirmListener[0]);
        localStringBuilder.append(", y = ");
        localStringBuilder.append(paramOnUninterestConfirmListener[1]);
        QLog.d("KandianPopupWindow", 2, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parent.getWidth() = ");
        localStringBuilder.append(paramView.getWidth());
        localStringBuilder.append(", parent.getHeight() = ");
        localStringBuilder.append(paramView.getHeight());
        QLog.d("KandianPopupWindow", 2, localStringBuilder.toString());
      }
      int i2 = this.B;
      int i3 = paramOnUninterestConfirmListener[1];
      int i4 = paramView.getHeight();
      int i1 = paramOnUninterestConfirmListener[1];
      i1 = (int)this.k.getResources().getDimension(2131299584);
      int i5 = this.y - paramOnUninterestConfirmListener[0] - paramView.getWidth() / 2 + i1;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("marginRight = ");
        localStringBuilder.append(i5);
        QLog.d("KandianPopupWindow", 2, localStringBuilder.toString());
      }
      double d1;
      double d2;
      if (i2 - (i3 + i4) > this.z)
      {
        d1 = i5;
        d2 = this.y;
        Double.isNaN(d2);
        if (d1 > d2 * 0.1D) {
          setAnimationStyle(2131951657);
        } else {
          setAnimationStyle(2131951656);
        }
        this.s.setPadding(0, 0, i5, 0);
        this.s.setVisibility(0);
        this.t.setVisibility(8);
        i2 = paramOnUninterestConfirmListener[1] + paramView.getHeight() / 2 + AIOUtils.b(9.5F, this.k.getResources());
        showAtLocation(paramView, 0, i1, i2);
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("show x = ");
          paramView.append(i1);
          paramView.append(", show y = ");
          paramView.append(i2);
          QLog.d("KandianPopupWindow", 2, paramView.toString());
        }
      }
      else
      {
        d1 = i5;
        d2 = this.y;
        Double.isNaN(d2);
        if (d1 > d2 * 0.1D) {
          setAnimationStyle(2131951660);
        } else {
          setAnimationStyle(2131951659);
        }
        this.t.setPadding(0, 0, i5, 0);
        this.s.setVisibility(8);
        this.t.setVisibility(0);
        i2 = paramOnUninterestConfirmListener[1] + paramView.getHeight() / 2 - AIOUtils.b(9.5F, this.k.getResources()) - this.z;
        showAtLocation(paramView, 0, i1, i2);
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("show x = ");
          paramView.append(i1);
          paramView.append(", show y = ");
          paramView.append(i2);
          QLog.d("KandianPopupWindow", 2, paramView.toString());
        }
      }
    }
    else
    {
      setAnimationStyle(2131951658);
      showAtLocation(paramView, 0, paramOnUninterestConfirmListener[0] + paramView.getWidth() / 2 - AIOUtils.b(10.5F, this.k.getResources()) - (int)this.k.getResources().getDimension(2131299585), paramOnUninterestConfirmListener[1] + paramView.getHeight() / 2 - this.z / 2);
    }
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).setIsShowPopup(true);
  }
  
  public void a(KandianPopupWindow.OnComplainListener paramOnComplainListener)
  {
    this.h = paramOnComplainListener;
  }
  
  public boolean a()
  {
    return this.m;
  }
  
  public boolean a(int paramInt, ArrayList<DislikeInfo> paramArrayList)
  {
    if (paramInt == -1) {
      return false;
    }
    this.e = paramInt;
    ArrayList localArrayList = this.f;
    if (localArrayList == null) {
      this.f = new ArrayList();
    } else {
      localArrayList.clear();
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      this.p = false;
      this.n.setVisibility(0);
      this.o.setVisibility(8);
      this.y = ((int)(this.A - this.k.getResources().getDimension(2131299584) * 2.0F));
      setWidth(this.y);
      localArrayList = this.d;
      if (localArrayList == null) {
        this.d = new ArrayList();
      } else {
        localArrayList.clear();
      }
      this.d.addAll(paramArrayList);
      g();
    }
    else
    {
      this.p = true;
      this.n.setVisibility(8);
      this.o.setVisibility(0);
      this.y = ((int)this.k.getResources().getDimension(2131299585));
      setWidth(this.y);
    }
    h();
    return true;
  }
  
  public void b()
  {
    this.A = ((int)DeviceInfoUtil.D());
    this.B = ((int)DeviceInfoUtil.E());
    this.l = ((LayoutInflater)this.k.getSystemService("layout_inflater")).inflate(2131626142, null);
    setContentView(this.l);
    this.n = ((RelativeLayout)this.l.findViewById(2131449106));
    this.o = ((Button)this.l.findViewById(2131449098));
    this.o.setOnClickListener(this);
    this.r = this.l.findViewById(2131449100);
    this.q = ((TextView)this.l.findViewById(2131449115));
    this.b = ((Button)this.l.findViewById(2131449097));
    this.b.setOnClickListener(this);
    this.b.setEnabled(false);
    this.c = ((ImageView)this.l.findViewById(2131449101));
    this.w = ((RelativeLayout)this.l.findViewById(2131449099));
    this.w.setOnClickListener(this);
    this.s = ((ImageView)this.l.findViewById(2131449118));
    this.t = ((ImageView)this.l.findViewById(2131449117));
    this.u = new View[this.i.length];
    int i1 = 0;
    int[] arrayOfInt;
    for (;;)
    {
      arrayOfInt = this.i;
      if (i1 >= arrayOfInt.length) {
        break;
      }
      this.u[i1] = this.l.findViewById(arrayOfInt[i1]);
      i1 += 1;
    }
    this.v = new Button[this.j.length];
    i1 = 0;
    for (;;)
    {
      arrayOfInt = this.j;
      if (i1 >= arrayOfInt.length) {
        break;
      }
      this.v[i1] = ((Button)this.l.findViewById(arrayOfInt[i1]));
      this.v[i1].setOnClickListener(this);
      i1 += 1;
    }
    setHeight(-2);
    setBackgroundDrawable(new ColorDrawable(0));
    setOnDismissListener(new KandianPopupWindow.1(this));
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    this.m = true;
  }
  
  public void c()
  {
    RelativeLayout localRelativeLayout = this.w;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
  }
  
  public void d()
  {
    Object localObject = this.w;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(0);
    }
    localObject = this.r;
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130844112);
    }
    localObject = this.t;
    if (localObject != null)
    {
      ((ImageView)localObject).setImageResource(2130844122);
      if (RelativeLayout.LayoutParams.class.isInstance(this.t.getLayoutParams()))
      {
        localObject = (RelativeLayout.LayoutParams)this.t.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131449099);
        this.t.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  protected void e()
  {
    if (this.x != null)
    {
      this.k.getWindowManager().removeView(this.x);
      this.x = null;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      i1 = 0;
      break;
    case 2131449099: 
      localObject = this.h;
      if (localObject != null) {
        ((KandianPopupWindow.OnComplainListener)localObject).a();
      }
      dismiss();
      break;
    case 2131449097: 
    case 2131449098: 
      localObject = this.g;
      if (localObject != null) {
        ((KandianPopupWindow.OnUninterestConfirmListener)localObject).a(paramView, this.e, this.f, null);
      }
      dismiss();
      break;
    }
    while (i1 < this.j.length)
    {
      if (paramView.getId() == this.j[i1]) {
        break label131;
      }
      i1 += 1;
    }
    int i1 = -1;
    label131:
    if (i1 != -1)
    {
      if (this.v[i1].isSelected())
      {
        this.v[i1].setSelected(false);
        this.f.remove(this.d.get(i1));
      }
      else
      {
        if (!this.a)
        {
          localObject = this.v;
          int i3 = localObject.length;
          int i2 = 0;
          while (i2 < i3)
          {
            localObject[i2].setSelected(false);
            i2 += 1;
          }
          this.f.clear();
        }
        this.v[i1].setSelected(true);
        this.f.add(this.d.get(i1));
      }
      if (this.f.size() == 0)
      {
        this.q.setText(this.k.getString(2131897936));
        this.b.setEnabled(false);
      }
      else
      {
        if (this.a) {
          this.q.setText(String.format(this.k.getString(2131897937), new Object[] { Integer.valueOf(this.f.size()) }));
        }
        this.b.setEnabled(true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.KandianPopupWindow
 * JD-Core Version:    0.7.0.1
 */