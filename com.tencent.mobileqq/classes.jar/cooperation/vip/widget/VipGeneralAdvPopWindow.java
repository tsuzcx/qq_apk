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
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(2130851222);
  private static final SpringConfig jdField_a_of_type_ComTencentComponentAnimationReboundSpringConfig = SpringConfig.fromOrigamiTensionAndFriction(60.0D, 8.0D);
  private static final Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = a(2130851223);
  private static final Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(2130706432);
  private float jdField_a_of_type_Float = 0.1F;
  private int jdField_a_of_type_Int = 0;
  public Activity a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  private View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new VipGeneralAdvPopWindow.3(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new VipGeneralAdvPopWindow.4(this);
  private ListView jdField_a_of_type_AndroidWidgetListView = null;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private Spring jdField_a_of_type_ComTencentComponentAnimationReboundSpring = null;
  private VipGeneralAdvPopWindow.DropDownMenuAdapter jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow$DropDownMenuAdapter;
  public ArrayList<VipGeneralAdvPopWindow.MenuData> a;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  private int d = 0;
  private int e = 0;
  
  public VipGeneralAdvPopWindow(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    f();
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
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewLayoutInflater == null)
    {
      Activity localActivity = a();
      if (localActivity == null) {
        return;
      }
      this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(localActivity);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt, null));
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        return;
      }
    }
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    ViewUtils.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, jdField_c_of_type_AndroidGraphicsDrawableDrawable);
    super.setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
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
  
  private int c()
  {
    if (a() == null) {
      return 0;
    }
    Rect localRect = new Rect();
    a().getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    if (localRect.top > 0) {
      return localRect.top;
    }
    return ViewUtils.b() - localRect.height();
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    a(2131562658);
    setFocusable(true);
    setBackgroundDrawable(null);
    setWidth(-1);
    setHeight(-1);
    this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring = SpringSystem.create().createSpring().setSpringConfig(jdField_a_of_type_ComTencentComponentAnimationReboundSpringConfig).addListener(new VipGeneralAdvPopWindow.1(this));
    this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow$DropDownMenuAdapter = new VipGeneralAdvPopWindow.DropDownMenuAdapter(this, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365988));
    this.jdField_a_of_type_AndroidWidgetListView.setFooterDividersEnabled(false);
    this.jdField_a_of_type_AndroidWidgetListView.setHeaderDividersEnabled(false);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow$DropDownMenuAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setOnTouchListener(new VipGeneralAdvPopWindow.2(this));
  }
  
  private void g()
  {
    super.dismiss();
  }
  
  private void h()
  {
    Spring localSpring = this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring;
    if (localSpring == null) {
      return;
    }
    float f2 = (float)localSpring.getCurrentValue();
    float f1 = (float)a(f2, 0.0D, 1.0D, 0.0D, 1.0D);
    if (f2 < 0.0F) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      f2 = (float)this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.getEndValue();
      f1 = (float)this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.getEndValue();
    }
    else if (this.jdField_b_of_type_Boolean)
    {
      f2 = this.jdField_b_of_type_Float;
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float + f2);
      if (this.jdField_b_of_type_Float > 1.0F) {
        this.jdField_b_of_type_Float = 1.0F;
      }
    }
    else
    {
      float f3 = f1;
      f2 = f1;
      f1 = f3;
    }
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, f2);
    a(this.jdField_a_of_type_AndroidWidgetListView, 1.0F);
    ViewUtils.b(this.jdField_a_of_type_AndroidWidgetListView, f1);
    ViewUtils.c(this.jdField_a_of_type_AndroidWidgetListView, f1);
    if (this.jdField_c_of_type_Boolean)
    {
      ViewUtils.e(this.jdField_a_of_type_AndroidWidgetListView, 0.0F);
      ViewUtils.d(this.jdField_a_of_type_AndroidWidgetListView, this.d);
    }
    else
    {
      ViewUtils.e(this.jdField_a_of_type_AndroidWidgetListView, this.e);
      ViewUtils.d(this.jdField_a_of_type_AndroidWidgetListView, this.d);
    }
    if ((!this.jdField_b_of_type_Boolean) && (f1 == 0.0F)) {
      g();
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public View a()
  {
    return a().findViewById(16908290).getRootView();
  }
  
  public void a()
  {
    if (isShowing()) {
      return;
    }
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0.0F);
    ViewUtils.a(this.jdField_a_of_type_AndroidWidgetListView, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    super.showAtLocation(a(), 17, 0, 0);
    c();
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ListView localListView = this.jdField_a_of_type_AndroidWidgetListView;
    if ((localListView != null) && (paramOnItemClickListener != null)) {
      localListView.setOnItemClickListener(paramOnItemClickListener);
    }
  }
  
  public void a(VipGeneralAdvPopWindow.MenuData paramMenuData)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (paramMenuData != null)) {
      localArrayList.add(paramMenuData);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetListView != null))
    {
      paramInt1 = ViewUtils.a() - this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight() * 2;
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetListView.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new RelativeLayout.LayoutParams(paramInt1, this.jdField_c_of_type_Int);
      }
      int i = b();
      localLayoutParams1.width = paramInt1;
      localLayoutParams1.height = this.jdField_c_of_type_Int;
      localLayoutParams1.topMargin = (paramInt2 - i - ViewUtils.b(5.0F));
      this.jdField_a_of_type_AndroidWidgetListView.setLayoutParams(localLayoutParams1);
      this.e = this.jdField_c_of_type_Int;
      this.d = (paramInt1 - (this.jdField_a_of_type_Int / 2 - this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight()));
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() > 0)
    {
      i = ViewUtils.b() - this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      if (i <= ViewUtils.b(25.0F)) {
        return i;
      }
    }
    int j = c();
    int i = j;
    if (j <= 0) {
      i = ViewUtils.b(25.0F);
    }
    return i;
  }
  
  public void b()
  {
    if (isShowing()) {
      return;
    }
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0.0F);
    ViewUtils.a(this.jdField_a_of_type_AndroidWidgetListView, jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    ListView localListView = this.jdField_a_of_type_AndroidWidgetListView;
    if (localListView != null) {
      localListView.setPadding(localListView.getPaddingLeft(), this.jdField_a_of_type_AndroidWidgetListView.getPaddingTop() + ViewUtils.b(9.0F), this.jdField_a_of_type_AndroidWidgetListView.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetListView.getPaddingBottom());
    }
    super.showAtLocation(a(), 17, 0, 0);
    c();
  }
  
  public void c()
  {
    Spring localSpring = this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring;
    if (localSpring == null) {
      return;
    }
    if (localSpring.getCurrentValue() != this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.getEndValue()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.getEndValue() == 0.0D)
    {
      this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.setEndValue(1.0D);
      return;
    }
    this.jdField_a_of_type_ComTencentComponentAnimationReboundSpring.setEndValue(0.0D);
  }
  
  public void d()
  {
    dismiss();
  }
  
  public void dismiss()
  {
    this.jdField_b_of_type_Boolean = false;
    c();
  }
  
  public void e()
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow$DropDownMenuAdapter.getCount())
    {
      View localView = this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow$DropDownMenuAdapter.getView(i, null, this.jdField_a_of_type_AndroidWidgetListView);
      localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      j += localView.getMeasuredHeight();
      i += 1;
    }
    this.jdField_c_of_type_Int = (j + ViewUtils.b(9.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralAdvPopWindow
 * JD-Core Version:    0.7.0.1
 */