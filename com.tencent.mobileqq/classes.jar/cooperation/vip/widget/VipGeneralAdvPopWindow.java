package cooperation.vip.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.animation.rebound.Spring;
import com.tencent.component.animation.rebound.SpringConfig;
import com.tencent.component.animation.rebound.SpringSystem;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;

public class VipGeneralAdvPopWindow
  extends PopupWindow
{
  private static final SpringConfig g = SpringConfig.fromOrigamiTensionAndFriction(60.0D, 8.0D);
  private static final Drawable r = a(2130853478);
  private static final Drawable s = a(2130853479);
  private static final Drawable t = new ColorDrawable(2130706432);
  public Activity a;
  public ArrayList<VipGeneralAdvPopWindow.MenuData> b;
  private Spring c = null;
  private ListView d = null;
  private RelativeLayout e = null;
  private LayoutInflater f = null;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private float k = 0.1F;
  private float l = 0.0F;
  private boolean m = false;
  private boolean n = true;
  private boolean o = true;
  private int p = 0;
  private int q = 0;
  private VipGeneralAdvPopWindow.DropDownMenuAdapter u;
  private View.OnKeyListener v = new VipGeneralAdvPopWindow.3(this);
  private View.OnTouchListener w = new VipGeneralAdvPopWindow.4(this);
  
  public VipGeneralAdvPopWindow(Activity paramActivity)
  {
    super(paramActivity);
    this.a = paramActivity;
    j();
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    return paramDouble4 + (paramDouble1 - paramDouble2) / (paramDouble3 - paramDouble2) * (paramDouble5 - paramDouble4);
  }
  
  public static Drawable a(int paramInt)
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt);
      return localDrawable;
    }
    catch (Exception localException)
    {
      label13:
      break label13;
    }
    return null;
  }
  
  private void a(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(paramFloat);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.f == null)
    {
      Activity localActivity = d();
      if (localActivity == null) {
        return;
      }
      this.f = LayoutInflater.from(localActivity);
    }
    if (this.e == null)
    {
      this.e = ((RelativeLayout)this.f.inflate(paramInt, null));
      if (this.e == null) {
        return;
      }
    }
    a(this.e, 0.0F);
    this.e.setFocusable(true);
    this.e.setFocusableInTouchMode(true);
    this.e.setOnKeyListener(this.v);
    this.e.setOnTouchListener(this.w);
    ViewUtils.setViewBackground(this.e, t);
    super.setContentView(this.e);
  }
  
  private void j()
  {
    this.b = new ArrayList();
    b(2131629089);
    setFocusable(true);
    setBackgroundDrawable(null);
    setWidth(-1);
    setHeight(-1);
    this.c = SpringSystem.create().createSpring().setSpringConfig(g).addListener(new VipGeneralAdvPopWindow.1(this));
    this.u = new VipGeneralAdvPopWindow.DropDownMenuAdapter(this, this.a);
    this.d = ((ListView)this.e.findViewById(2131432258));
    this.d.setFooterDividersEnabled(false);
    this.d.setHeaderDividersEnabled(false);
    this.d.setAdapter(this.u);
    this.d.setOnTouchListener(new VipGeneralAdvPopWindow.2(this));
  }
  
  private void k()
  {
    super.dismiss();
  }
  
  private void l()
  {
    Spring localSpring = this.c;
    if (localSpring == null) {
      return;
    }
    float f2 = (float)localSpring.getCurrentValue();
    float f1 = (float)a(f2, 0.0D, 1.0D, 0.0D, 1.0D);
    if (f2 < 0.0F) {
      this.m = true;
    }
    if (this.m)
    {
      f2 = (float)this.c.getEndValue();
      f1 = (float)this.c.getEndValue();
    }
    else if (this.n)
    {
      f2 = this.l;
      this.l = (this.k + f2);
      if (this.l > 1.0F) {
        this.l = 1.0F;
      }
    }
    else
    {
      float f3 = f1;
      f2 = f1;
      f1 = f3;
    }
    a(this.e, f2);
    a(this.d, 1.0F);
    ViewUtils.setScaleX(this.d, f1);
    ViewUtils.setScaleY(this.d, f1);
    if (this.o)
    {
      ViewUtils.setPivotY(this.d, 0.0F);
      ViewUtils.setPivotX(this.d, this.p);
    }
    else
    {
      ViewUtils.setPivotY(this.d, this.q);
      ViewUtils.setPivotX(this.d, this.p);
    }
    if ((!this.n) && (f1 == 0.0F)) {
      k();
    }
  }
  
  private int m()
  {
    if (d() == null) {
      return 0;
    }
    Rect localRect = new Rect();
    d().getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    if (localRect.top > 0) {
      return localRect.top;
    }
    return ViewUtils.getScreenHeight() - localRect.height();
  }
  
  public View a()
  {
    return d().findViewById(16908290).getRootView();
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ListView localListView = this.d;
    if ((localListView != null) && (paramOnItemClickListener != null)) {
      localListView.setOnItemClickListener(paramOnItemClickListener);
    }
  }
  
  public void a(VipGeneralAdvPopWindow.MenuData paramMenuData)
  {
    ArrayList localArrayList = this.b;
    if ((localArrayList != null) && (paramMenuData != null)) {
      localArrayList.add(paramMenuData);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((this.e != null) && (this.d != null))
    {
      paramInt1 = ViewUtils.getScreenWidth() - this.e.getPaddingRight() * 2;
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new RelativeLayout.LayoutParams(paramInt1, this.j);
      }
      int i1 = i();
      localLayoutParams1.width = paramInt1;
      localLayoutParams1.height = this.j;
      localLayoutParams1.topMargin = (paramInt2 - i1 - ViewUtils.dpToPx(5.0F));
      this.d.setLayoutParams(localLayoutParams1);
      this.q = this.j;
      this.p = (paramInt1 - (this.h / 2 - this.e.getPaddingRight()));
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (isShowing()) {
      return;
    }
    this.l = 0.0F;
    this.m = false;
    this.n = true;
    this.o = false;
    a(this.e, 0.0F);
    ViewUtils.setViewBackground(this.d, r);
    super.showAtLocation(a(), 17, 0, 0);
    e();
  }
  
  public void c()
  {
    if (isShowing()) {
      return;
    }
    this.l = 0.0F;
    this.m = false;
    this.n = true;
    this.o = true;
    a(this.e, 0.0F);
    ViewUtils.setViewBackground(this.d, s);
    ListView localListView = this.d;
    if (localListView != null) {
      localListView.setPadding(localListView.getPaddingLeft(), this.d.getPaddingTop() + ViewUtils.dpToPx(9.0F), this.d.getPaddingRight(), this.d.getPaddingBottom());
    }
    super.showAtLocation(a(), 17, 0, 0);
    e();
  }
  
  public Activity d()
  {
    return this.a;
  }
  
  public void dismiss()
  {
    this.n = false;
    e();
  }
  
  public void e()
  {
    Spring localSpring = this.c;
    if (localSpring == null) {
      return;
    }
    if (localSpring.getCurrentValue() != this.c.getEndValue()) {
      return;
    }
    if (this.c.getEndValue() == 0.0D)
    {
      this.c.setEndValue(1.0D);
      return;
    }
    this.c.setEndValue(0.0D);
  }
  
  public void f()
  {
    dismiss();
  }
  
  public void g()
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 < this.u.getCount())
    {
      View localView = this.u.getView(i1, null, this.d);
      localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      i2 += localView.getMeasuredHeight();
      i1 += 1;
    }
    this.j = (i2 + ViewUtils.dpToPx(9.0F));
  }
  
  public int h()
  {
    return this.j;
  }
  
  public int i()
  {
    if (this.e.getHeight() > 0)
    {
      i1 = ViewUtils.getScreenHeight() - this.e.getHeight();
      if (i1 <= ViewUtils.dpToPx(25.0F)) {
        return i1;
      }
    }
    int i2 = m();
    int i1 = i2;
    if (i2 <= 0) {
      i1 = ViewUtils.dpToPx(25.0F);
    }
    return i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralAdvPopWindow
 * JD-Core Version:    0.7.0.1
 */