package com.tencent.mobileqq.utils.dialogutils;

import aepi;
import alsf;
import alud;
import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bdpi;
import bdpk;
import bdpl;
import bdpm;
import bhvp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.Iterator;
import java.util.List;

public class QQCustomMenuNoIconLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static float a;
  public static int a;
  public static int c;
  public static int f = 14;
  public static int g;
  private Context jdField_a_of_type_AndroidContentContext;
  protected View.OnClickListener a;
  protected ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bdpi a;
  private bdpk jdField_a_of_type_Bdpk;
  private bhvp jdField_a_of_type_Bhvp = new bdpl(this);
  public BubblePopupWindow a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  protected ImageView b;
  private boolean b;
  protected ImageView c;
  private boolean c;
  protected int d;
  protected ImageView d;
  protected int e;
  private int h;
  private int i = 8;
  private int j;
  private int k = -1;
  
  static
  {
    jdField_a_of_type_Float = 1.0F;
    jdField_c_of_type_Int = 5;
  }
  
  public QQCustomMenuNoIconLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setOrientation(0);
    g = (int)(10.0F * jdField_a_of_type_Float + 0.5D);
    this.e = 8;
    if (jdField_a_of_type_Float >= 2.0F) {
      this.e = 10;
    }
    if (jdField_a_of_type_Float < alsf.a.density) {}
    for (this.jdField_b_of_type_Int = ((int)((jdField_a_of_type_Int - g) * (jdField_a_of_type_Float / alsf.a.density)));; this.jdField_b_of_type_Int = (jdField_a_of_type_Int - g))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomMenuNoIconLayout", 4, "screenWidth:" + jdField_a_of_type_Int + " mDensity: " + jdField_a_of_type_Float + " layoutMaxWidth A:" + this.jdField_b_of_type_Int);
      }
      return;
    }
  }
  
  private int a()
  {
    int i2 = getChildCount();
    int i1 = 0;
    int m = 0;
    View localView;
    int n;
    if (i1 < i2)
    {
      localView = getChildAt(i1);
      if ((localView == null) || (localView.getVisibility() == 8)) {
        break label149;
      }
      if ((localView instanceof TextView))
      {
        n = (int)Layout.getDesiredWidth(((TextView)localView).getText(), ((TextView)localView).getPaint()) + localView.getPaddingLeft() + localView.getPaddingRight();
        label79:
        m = n + m;
      }
    }
    label149:
    for (;;)
    {
      i1 += 1;
      break;
      if ((localView instanceof ImageView))
      {
        n = 1;
        break label79;
        m = jdField_c_of_type_Int * 2 + m;
        if (QLog.isColorLevel()) {
          QLog.d("QQCustomMenuNoIconLayout", 4, "totalWidth   " + m);
        }
        return m;
      }
      n = 0;
      break label79;
    }
  }
  
  private TextView a(int paramInt)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText("");
    localTextView.setTextSize(1.0F);
    localTextView.setWidth(paramInt);
    localTextView.setMaxLines(1);
    localTextView.setPadding(0, 0, 0, 0);
    localTextView.setTextColor(-1);
    localTextView.setBackgroundDrawable(null);
    localTextView.setGravity(17);
    return localTextView;
  }
  
  private TextView a(bdpk parambdpk)
  {
    bdpm localbdpm = new bdpm(this, getContext());
    localbdpm.setText(parambdpk.a());
    localbdpm.setTextSize(13.0F);
    localbdpm.setMinimumWidth(90);
    Resources localResources = getContext().getResources();
    localbdpm.setMaxLines(1);
    int m = aepi.a(9.0F, localResources);
    localbdpm.setPadding(f, m, f, m);
    localbdpm.setContentDescription(parambdpk.a());
    localbdpm.setId(parambdpk.a());
    localbdpm.setTextColor(-855638017);
    localbdpm.setBackgroundDrawable(null);
    localbdpm.setIncludeFontPadding(true);
    localbdpm.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localbdpm.setGravity(17);
    return localbdpm;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = a(this.jdField_a_of_type_Bdpk);
    this.j = ((int)Layout.getDesiredWidth(this.jdField_a_of_type_AndroidWidgetTextView.getText(), this.jdField_a_of_type_AndroidWidgetTextView.getPaint()));
    this.j = (this.j + this.jdField_a_of_type_AndroidWidgetTextView.getPaddingLeft() + this.jdField_a_of_type_AndroidWidgetTextView.getPaddingRight());
  }
  
  private void e()
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setBackgroundResource(2130838664);
    addView(localImageView, new LinearLayout.LayoutParams(-2, -2));
  }
  
  protected ImageView a()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageResource(2130838685);
    localImageView.setContentDescription(alud.a(2131710584));
    localImageView.setBackgroundDrawable(null);
    localImageView.setOnClickListener(this);
    localImageView.setPadding((int)(this.e * jdField_a_of_type_Float), (int)(jdField_a_of_type_Float * 10.0F), (int)(this.e * jdField_a_of_type_Float), (int)(jdField_a_of_type_Float * 10.0F));
    return localImageView;
  }
  
  public void a()
  {
    removeAllViews();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      this.jdField_a_of_type_Boolean = false;
    }
    int i2 = this.jdField_a_of_type_Bdpi.a();
    int m = 0;
    Object localObject;
    int n;
    int i3;
    if (m < i2)
    {
      localObject = a(this.jdField_a_of_type_Bdpi.a(m));
      n = (int)Layout.getDesiredWidth(((TextView)localObject).getText(), ((TextView)localObject).getPaint());
      int i1 = ((TextView)localObject).getPaddingLeft();
      i3 = ((TextView)localObject).getPaddingRight() + (n + i1);
      if (a(i3))
      {
        i1 = this.i;
        n = i1;
        if (this.jdField_a_of_type_Bdpk != null) {
          n = i1 - 1;
        }
        if (m == n)
        {
          n = getChildCount();
          removeViewAt(n - 1);
          removeViewAt(n - 2);
          m -= 1;
          if (this.jdField_a_of_type_Bdpk != null) {
            addView(a(this.jdField_a_of_type_Bdpk), new LinearLayout.LayoutParams(this.j, -2, 0.0F));
          }
          e();
          this.jdField_a_of_type_AndroidWidgetImageView = a();
          localObject = new LinearLayout.LayoutParams(this.jdField_a_of_type_AndroidWidgetImageView.getPaddingLeft() + 22 + this.jdField_a_of_type_AndroidWidgetImageView.getPaddingRight(), -2);
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          addView(this.jdField_a_of_type_AndroidWidgetImageView);
        }
      }
    }
    for (;;)
    {
      ImageView localImageView;
      LinearLayout.LayoutParams localLayoutParams;
      if (this.jdField_a_of_type_Bdpk != null)
      {
        localObject = a(this.jdField_a_of_type_Bdpk);
        localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        localImageView.setBackgroundResource(2130838664);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (i2 == 0) {
          addView((View)localObject, this.k * 2, new LinearLayout.LayoutParams(this.j, -2, 0.0F));
        }
        if (this.jdField_c_of_type_Boolean)
        {
          if (i2 != 1) {
            break label756;
          }
          if (this.k != 0) {
            break label711;
          }
          addView((View)localObject, this.k * 2, new LinearLayout.LayoutParams(this.j, -2, 0.0F));
          addView(localImageView, this.k * 2 + 1, localLayoutParams);
        }
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Int = m;
        return;
        addView((View)localObject, new LinearLayout.LayoutParams(i3, -2, 0.0F));
        if (m != i2 - 1) {
          e();
        }
        for (;;)
        {
          m += 1;
          break;
          this.jdField_c_of_type_Boolean = true;
        }
        this.jdField_a_of_type_AndroidWidgetImageView = a();
        n = this.jdField_a_of_type_AndroidWidgetImageView.getPaddingLeft() + 22 + this.jdField_a_of_type_AndroidWidgetImageView.getPaddingRight();
        localObject = new LinearLayout.LayoutParams(n, -2);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (a(n))
        {
          if (this.jdField_a_of_type_Bdpk != null) {
            addView(a(this.jdField_a_of_type_Bdpk), new LinearLayout.LayoutParams(this.j, -2, 0.0F));
          }
          e();
        }
        for (;;)
        {
          addView(this.jdField_a_of_type_AndroidWidgetImageView);
          break;
          if (m > 1)
          {
            n = getChildCount();
            if ((getChildAt(n - 1) instanceof ImageView)) {
              removeViewAt(n - 1);
            }
            removeViewAt(n - 2);
            m -= 1;
            if (this.jdField_a_of_type_Bdpk != null) {
              addView(a(this.jdField_a_of_type_Bdpk), new LinearLayout.LayoutParams(this.j, -2, 0.0F));
            }
            e();
          }
          else
          {
            if (m > 0)
            {
              n = getChildCount();
              if ((getChildAt(n - 1) instanceof ImageView)) {
                removeViewAt(n - 1);
              }
              removeViewAt(n - 2);
            }
            n = m - 1;
            if (this.jdField_a_of_type_Bdpk != null) {
              addView(a(this.jdField_a_of_type_Bdpk), new LinearLayout.LayoutParams(this.j, -2, 0.0F));
            }
            m = n;
            if (QLog.isColorLevel())
            {
              QLog.d("QQCustomMenuNoIconLayout", 4, "showFirstScreenMenu: only arrow menu is wrong!");
              m = n;
            }
          }
        }
        label711:
        addView(localImageView, this.k * 2 - 1, localLayoutParams);
        addView((View)localObject, this.k * 2, new LinearLayout.LayoutParams(this.j, -2, 0.0F));
        continue;
        label756:
        if (this.k < i2)
        {
          addView((View)localObject, this.k * 2, new LinearLayout.LayoutParams(this.j, -2, 0.0F));
          addView(localImageView, this.k * 2 + 1, localLayoutParams);
        }
        else
        {
          addView(localImageView, this.k * 2 - 1, localLayoutParams);
          addView((View)localObject, this.k * 2, new LinearLayout.LayoutParams(this.j, -2, 0.0F));
        }
      }
      m = -1;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Bdpk != null) {
      if (a() + paramInt > this.jdField_b_of_type_Int - this.j) {}
    }
    while (a() + paramInt <= this.jdField_b_of_type_Int)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    addView(paramView);
  }
  
  public void b()
  {
    int i1 = 0;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      this.jdField_b_of_type_Boolean = false;
    }
    int m;
    Object localObject1;
    int i2;
    int n;
    if (this.jdField_d_of_type_Int >= 0)
    {
      removeAllViews();
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838680);
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131710593));
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setPadding((int)(this.e * jdField_a_of_type_Float), (int)(jdField_a_of_type_Float * 10.0F), (int)(this.e * jdField_a_of_type_Float), (int)(jdField_a_of_type_Float * 10.0F));
      m = this.jdField_c_of_type_AndroidWidgetImageView.getPaddingLeft() + 22 + this.jdField_c_of_type_AndroidWidgetImageView.getPaddingRight();
      localObject1 = new LinearLayout.LayoutParams(m, -2);
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      addView(this.jdField_c_of_type_AndroidWidgetImageView);
      e();
      m = 0 + (m + 1);
      i2 = this.jdField_a_of_type_Bdpi.a();
      n = this.jdField_d_of_type_Int;
      i1 = m;
      if (n < i2)
      {
        localObject1 = a(this.jdField_a_of_type_Bdpi.a(n));
        i1 = (int)Layout.getDesiredWidth(((TextView)localObject1).getText(), ((TextView)localObject1).getPaint()) + ((TextView)localObject1).getPaddingLeft() + ((TextView)localObject1).getPaddingRight();
        if (b(i1)) {
          if (n - this.jdField_d_of_type_Int == this.i)
          {
            i1 = getChildCount();
            removeViewAt(i1 - 1);
            removeViewAt(i1 - 2);
            this.jdField_b_of_type_AndroidWidgetImageView = a();
            localObject1 = new LinearLayout.LayoutParams(this.jdField_b_of_type_AndroidWidgetImageView.getPaddingLeft() + 22 + this.jdField_b_of_type_AndroidWidgetImageView.getPaddingRight(), -2);
            this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            addView(this.jdField_b_of_type_AndroidWidgetImageView);
            i1 = n - 1;
            n = m;
            m = i1;
          }
        }
      }
    }
    for (;;)
    {
      this.h = m;
      if ((m == -1) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.f(n);
        this.jdField_a_of_type_Boolean = true;
      }
      return;
      addView((View)localObject1, new LinearLayout.LayoutParams(i1, -2, 0.0F));
      i1 = m + i1;
      m = i1;
      if (n != i2 - 1)
      {
        e();
        m = i1 + 1;
      }
      n += 1;
      break;
      this.jdField_b_of_type_AndroidWidgetImageView = a();
      i1 = this.jdField_b_of_type_AndroidWidgetImageView.getPaddingLeft();
      i2 = this.jdField_b_of_type_AndroidWidgetImageView.getPaddingRight() + (i1 + 22);
      Object localObject2 = new LinearLayout.LayoutParams(i2, -2);
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (b(i2))
      {
        i1 = m + i2;
        m = n;
        addView(this.jdField_b_of_type_AndroidWidgetImageView);
        n = i1 + i2;
      }
      else
      {
        int i3;
        if (n > 1)
        {
          i3 = getChildCount();
          if (!(getChildAt(i3 - 1) instanceof ImageView)) {
            break label741;
          }
          removeViewAt(i3 - 1);
          m -= 1;
        }
        label738:
        label741:
        for (;;)
        {
          localObject2 = getChildAt(i3 - 2);
          i1 = m;
          if ((localObject2 instanceof TextView))
          {
            localObject2 = (TextView)localObject2;
            i1 = m - ((int)Layout.getDesiredWidth(((TextView)localObject2).getText(), ((TextView)localObject2).getPaint()) + ((TextView)localObject1).getPaddingLeft() + ((TextView)localObject1).getPaddingRight());
          }
          removeViewAt(i3 - 2);
          m = n - 1;
          break;
          i1 = m;
          if (n > 0)
          {
            i1 = getChildCount();
            if ((getChildAt(i1 - 1) instanceof ImageView)) {
              removeViewAt(i1 - 1);
            }
            m -= 1;
            localObject2 = getChildAt(i1 - 2);
            if (!(localObject2 instanceof TextView)) {
              break label738;
            }
            localObject2 = (TextView)localObject2;
            m -= (int)Layout.getDesiredWidth(((TextView)localObject2).getText(), ((TextView)localObject2).getPaint()) + ((TextView)localObject1).getPaddingLeft() + ((TextView)localObject1).getPaddingRight();
          }
          for (;;)
          {
            removeViewAt(i1 - 2);
            i1 = m;
            if (QLog.isColorLevel()) {
              QLog.d("QQCustomMenuNoIconLayout", 4, "showSecondScreenMenu: only arrow menu is wrong!");
            }
            m = n - 1;
            break;
          }
        }
        n = i1;
        m = -1;
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    return a() + paramInt <= this.jdField_b_of_type_Int;
  }
  
  public void c()
  {
    if (this.h >= 0)
    {
      removeAllViews();
      this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838680);
      this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131710585));
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageView.setPadding((int)(this.e * jdField_a_of_type_Float), (int)(jdField_a_of_type_Float * 10.0F), (int)(this.e * jdField_a_of_type_Float), (int)(jdField_a_of_type_Float * 10.0F));
      int m = this.jdField_d_of_type_AndroidWidgetImageView.getPaddingLeft() + 22 + this.jdField_d_of_type_AndroidWidgetImageView.getPaddingRight();
      Object localObject = new LinearLayout.LayoutParams(m, -2);
      this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      addView(this.jdField_d_of_type_AndroidWidgetImageView);
      e();
      int i2 = this.jdField_a_of_type_Bdpi.a();
      int n = this.h;
      int i1;
      int i3;
      int i4;
      for (m = 0 + (m + 1); n < i2; m = i4 + (m + i3) + i1)
      {
        localObject = a(this.jdField_a_of_type_Bdpi.a(n));
        addView((View)localObject, new LinearLayout.LayoutParams(-2, -2, 0.0F));
        i1 = m;
        if (n != i2 - 1)
        {
          e();
          i1 = m + 1;
        }
        m = (int)Layout.getDesiredWidth(((TextView)localObject).getText(), ((TextView)localObject).getPaint());
        i3 = ((TextView)localObject).getPaddingLeft();
        i4 = ((TextView)localObject).getPaddingRight();
        n += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomMenuNoIconLayout", 4, "secondScreenWidth: " + m);
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.f(m);
        this.jdField_b_of_type_Boolean = true;
      }
      addView(a(jdField_c_of_type_Int), new LinearLayout.LayoutParams(jdField_c_of_type_Int, -2, 0.0F));
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_c_of_type_AndroidWidgetImageView) {
      a();
    }
    do
    {
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
      {
        b();
        return;
      }
      if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
      {
        c();
        return;
      }
    } while (paramView != this.jdField_d_of_type_AndroidWidgetImageView);
    b();
  }
  
  public void setMenu(bdpi parambdpi)
  {
    this.jdField_a_of_type_Bdpi = parambdpi.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomMenuNoIconLayout", 4, "MENU:" + this.jdField_a_of_type_Bdpi.toString());
    }
    parambdpi = this.jdField_a_of_type_Bdpi.a.iterator();
    int m = 0;
    for (;;)
    {
      if (parambdpi.hasNext())
      {
        bdpk localbdpk = (bdpk)parambdpi.next();
        if (TextUtils.equals(localbdpk.a, this.jdField_a_of_type_AndroidContentContext.getString(2131694627)))
        {
          this.jdField_a_of_type_Bdpk = localbdpk;
          this.k = m;
          d();
          parambdpi.remove();
        }
      }
      else
      {
        return;
      }
      m += 1;
    }
  }
  
  public void setMenuIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setPopup(BubblePopupWindow paramBubblePopupWindow)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = paramBubblePopupWindow;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_Bhvp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout
 * JD-Core Version:    0.7.0.1
 */