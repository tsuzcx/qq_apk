import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;

public abstract class rrm
  extends PopupWindow
{
  public final float a;
  private final int a;
  public Activity a;
  protected View a;
  protected FrameLayout a;
  protected ImageView a;
  public final String a;
  protected boolean a;
  public final float b;
  private int b;
  protected ImageView b;
  private int c;
  private int d;
  private int e;
  
  public rrm(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaLangString = "ReadInJoyBasePopupWindow";
    this.jdField_a_of_type_Float = 0.8F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView.measure(0, 0);
    this.c = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    setHeight(this.c);
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "calculatePopupWindow, popupHeight = ", Integer.valueOf(this.c) });
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater);
  
  protected void a()
  {
    this.d = ((int)bbdh.i());
    this.e = ((int)bbdh.j());
    Object localObject = (LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater");
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131559815, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364691));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377692));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377691));
    localObject = a((LayoutInflater)localObject);
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
    }
    setBackgroundDrawable(new ColorDrawable(0));
    this.jdField_b_of_type_Int = ((int)(this.d - this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298591) * 2.0F));
    setWidth(this.jdField_b_of_type_Int);
    setTouchable(true);
    setFocusable(true);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    b();
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppActivity.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  protected final void a(View paramView)
  {
    c();
    a(0.8F);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = this.e;
    int m = arrayOfInt[1];
    int n = paramView.getHeight();
    int j = (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131298591);
    int k = this.jdField_b_of_type_Int - (arrayOfInt[0] - j) - paramView.getWidth() / 2;
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "marginRight = ", Integer.valueOf(k) });
    if (i - (m + n) > this.c)
    {
      if (k > this.jdField_b_of_type_Int * 0.1D) {
        setAnimationStyle(2131755033);
      }
      for (;;)
      {
        i = arrayOfInt[1] + paramView.getHeight() + bbll.a(4.0F);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
        showAtLocation(paramView, 0, j, i);
        QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "x = ", Integer.valueOf(j), ", y = ", Integer.valueOf(i), ", width = ", Integer.valueOf(this.jdField_b_of_type_Int), ", height = ", Integer.valueOf(this.c) });
        return;
        setAnimationStyle(2131755032);
      }
    }
    if (k > this.jdField_b_of_type_Int * 0.1D) {
      setAnimationStyle(2131755036);
    }
    for (;;)
    {
      i = arrayOfInt[1] - this.c - bbll.a(4.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
      break;
      setAnimationStyle(2131755035);
    }
  }
  
  public void b()
  {
    setOnDismissListener(new rrn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrm
 * JD-Core Version:    0.7.0.1
 */