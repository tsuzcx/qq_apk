import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

public class okw
  extends PopupWindow
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#376099");
  public final float a;
  protected Activity a;
  protected View a;
  protected FrameLayout a;
  protected ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ohv jdField_a_of_type_Ohv;
  private okz jdField_a_of_type_Okz;
  protected boolean a;
  public final float b;
  private final int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  protected ImageView b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public okw(ohv paramohv, Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Float = 0.8F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Ohv = paramohv;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void a(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.format = -3;
    localLayoutParams.type = 1000;
    localLayoutParams.token = paramIBinder;
    localLayoutParams.windowAnimations = 16973828;
    this.jdField_b_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1895825408);
    this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(false);
    this.jdField_b_of_type_AndroidViewView.setOnKeyListener(new oky(this));
    this.jdField_a_of_type_AndroidAppActivity.getWindowManager().addView(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView.measure(0, 0);
    if (this.d > 0) {}
    for (int i = this.c;; i = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight())
    {
      this.d = i;
      setHeight(this.d);
      QLog.d("ReadInJoyCommentPopUpWindow", 2, new Object[] { "calculatePopupWindow, popupHeight = ", Integer.valueOf(this.d) });
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559848, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131364205));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131364207));
    return paramLayoutInflater;
  }
  
  protected void a()
  {
    this.e = ((int)bbct.i());
    this.f = ((int)bbct.j());
    Object localObject = (LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater");
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131559840, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364692));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377692));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377691));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = bbkx.a(21.0F);
    localLayoutParams.height = bbkx.a(10.5F);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = bbkx.a(21.0F);
    localLayoutParams.height = bbkx.a(10.5F);
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localObject = a((LayoutInflater)localObject);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
    }
    setBackgroundDrawable(new ColorDrawable(0));
    if (this.c > 0) {}
    for (int i = this.c;; i = (int)(this.e - this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298591) * 2.0F))
    {
      this.c = i;
      setWidth(this.c);
      setTouchable(true);
      setFocusable(true);
      setContentView(this.jdField_a_of_type_AndroidViewView);
      b();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  protected final void a(View paramView, int paramInt)
  {
    label37:
    Object localObject;
    int n;
    int i;
    if (paramInt == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(jdField_a_of_type_Int);
      c();
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof FastWebActivity)) {
        break label267;
      }
      a(paramView.getWindowToken());
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      bbkx.a(21.0F);
      n = bbkx.a(21.0F);
      i = this.e - bbkx.a(12.0F) - this.c;
      if (this.f - (localObject[1] + n) <= this.d) {
        break label277;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.setMargins(0, 0, bbkx.a(10.5F), 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramInt = localObject[1] + n + bbkx.a(4.0F);
      setAnimationStyle(2131755032);
    }
    for (;;)
    {
      showAtLocation(paramView, 0, i, paramInt);
      QLog.d("ReadInJoyCommentPopUpWindow", 2, new Object[] { "x = ", Integer.valueOf(i), ", y = ", Integer.valueOf(paramInt), ", width = ", Integer.valueOf(this.c), ", height = ", Integer.valueOf(this.d) });
      return;
      if (paramInt != 2) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(jdField_a_of_type_Int);
      break;
      label267:
      this.jdField_a_of_type_Ohv.b();
      break label37;
      label277:
      paramInt = localObject[1];
      int j = this.d;
      int k = this.jdField_b_of_type_AndroidWidgetImageView.getHeight();
      int m = bbkx.a(4.0F);
      n /= 2;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, bbkx.a(10.5F), 0);
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      setAnimationStyle(2131755035);
      paramInt = n + (paramInt - j - k - m);
    }
  }
  
  public void a(okz paramokz)
  {
    this.jdField_a_of_type_Okz = paramokz;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    setOnDismissListener(new okx(this));
  }
  
  public final void b(View paramView, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(actn.a(125.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), actn.a(88.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      a();
      this.jdField_a_of_type_Boolean = true;
    }
    a(paramView, paramInt);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_b_of_type_Boolean = false;
    dismiss();
    int i;
    switch (paramView.getId())
    {
    case 2131364206: 
    default: 
      i = 3;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Okz != null) {
        this.jdField_a_of_type_Okz.a(i);
      }
      if (this.jdField_a_of_type_Ohv != null)
      {
        this.jdField_a_of_type_Ohv.c();
        if ((i == 3) && ((this.jdField_a_of_type_Ohv instanceof ogq))) {
          ((ogq)this.jdField_a_of_type_Ohv).g();
        }
      }
      return;
      i = 3;
      continue;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     okw
 * JD-Core Version:    0.7.0.1
 */