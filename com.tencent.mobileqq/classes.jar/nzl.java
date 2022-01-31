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

public class nzl
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
  private nwk jdField_a_of_type_Nwk;
  private nzo jdField_a_of_type_Nzo;
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
  
  public nzl(nwk paramnwk, Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Float = 0.8F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Nwk = paramnwk;
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
    this.jdField_b_of_type_AndroidViewView.setOnKeyListener(new nzn(this));
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131494277, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131298647));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131298649));
    return paramLayoutInflater;
  }
  
  protected void a()
  {
    this.e = ((int)babp.i());
    this.f = ((int)babp.j());
    Object localObject = (LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater");
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131494269, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299132));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311871));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311870));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = bajq.a(21.0F);
    localLayoutParams.height = bajq.a(10.5F);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = bajq.a(21.0F);
    localLayoutParams.height = bajq.a(10.5F);
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localObject = a((LayoutInflater)localObject);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
    }
    setBackgroundDrawable(new ColorDrawable(0));
    if (this.c > 0) {}
    for (int i = this.c;; i = (int)(this.e - this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131167498) * 2.0F))
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
      bajq.a(21.0F);
      n = bajq.a(21.0F);
      i = this.e - bajq.a(12.0F) - this.c;
      if (this.f - (localObject[1] + n) <= this.d) {
        break label277;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.setMargins(0, 0, bajq.a(10.5F), 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramInt = localObject[1] + n + bajq.a(4.0F);
      setAnimationStyle(2131689496);
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
      this.jdField_a_of_type_Nwk.b();
      break label37;
      label277:
      paramInt = localObject[1];
      int j = this.d;
      int k = this.jdField_b_of_type_AndroidWidgetImageView.getHeight();
      int m = bajq.a(4.0F);
      n /= 2;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, bajq.a(10.5F), 0);
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      setAnimationStyle(2131689499);
      paramInt = n + (paramInt - j - k - m);
    }
  }
  
  public void a(nzo paramnzo)
  {
    this.jdField_a_of_type_Nzo = paramnzo;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    setOnDismissListener(new nzm(this));
  }
  
  public final void b(View paramView, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(aciy.a(125.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), aciy.a(88.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
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
    case 2131298648: 
    default: 
      i = 3;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Nzo != null) {
        this.jdField_a_of_type_Nzo.a(i);
      }
      if (this.jdField_a_of_type_Nwk != null)
      {
        this.jdField_a_of_type_Nwk.c();
        if ((i == 3) && ((this.jdField_a_of_type_Nwk instanceof nvf))) {
          ((nvf)this.jdField_a_of_type_Nwk).g();
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
 * Qualified Name:     nzl
 * JD-Core Version:    0.7.0.1
 */