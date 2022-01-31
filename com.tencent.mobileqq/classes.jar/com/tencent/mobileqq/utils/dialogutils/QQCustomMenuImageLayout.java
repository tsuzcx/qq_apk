package com.tencent.mobileqq.utils.dialogutils;

import aepi;
import alud;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bdpi;
import bdpj;
import bdpk;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;

public class QQCustomMenuImageLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static float a;
  public static int a;
  public static int c = 5;
  public static int d = 45;
  public static int e = 53;
  public static int f = 90;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bdpi jdField_a_of_type_Bdpi;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public int b;
  private ImageView b;
  private int g = -1;
  private int h;
  
  static
  {
    jdField_a_of_type_Float = 1.0F;
  }
  
  public QQCustomMenuImageLayout(Context paramContext)
  {
    super(paramContext);
    setOrientation(0);
    this.jdField_b_of_type_Int = (jdField_a_of_type_Int - (int)(10.0F * jdField_a_of_type_Float));
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomMenuImageLayout", 4, "screenWidth:" + jdField_a_of_type_Int + " mDensity: " + jdField_a_of_type_Float + " layoutMaxWidth A:" + this.jdField_b_of_type_Int);
    }
    this.h = 12;
    if (jdField_a_of_type_Float >= 2.0F) {
      this.h = 20;
    }
  }
  
  private int a()
  {
    int m = getChildCount();
    int k = 0;
    for (int j = 0; k < m; j = i)
    {
      View localView = getChildAt(k);
      i = j;
      if (localView != null)
      {
        i = j;
        if (localView.getVisibility() != 8)
        {
          int n = (int)Layout.getDesiredWidth(((TextView)localView).getText(), ((TextView)localView).getPaint());
          j += localView.getPaddingLeft() + n + localView.getPaddingRight();
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("QQCustomMenuImageLayout", 4, "child  TextView text " + ((TextView)localView).getText() + " measureWidth = " + n + " paddingL = " + localView.getPaddingLeft() + " paddingR = " + localView.getPaddingRight());
            i = j;
          }
        }
      }
      k += 1;
    }
    int i = c * 2 + j;
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomMenuImageLayout", 4, "totalWidth   " + i);
    }
    return i;
  }
  
  private ImageView a()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageResource(2130838685);
    localImageView.setContentDescription(alud.a(2131710596));
    localImageView.setBackgroundDrawable(null);
    localImageView.setOnClickListener(this);
    localImageView.setPadding((int)(this.h * jdField_a_of_type_Float), (int)(jdField_a_of_type_Float * 10.0F), (int)(this.h * jdField_a_of_type_Float), (int)(jdField_a_of_type_Float * 10.0F));
    return localImageView;
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
    bdpj localbdpj = new bdpj(this, getContext());
    localbdpj.setText(parambdpk.a());
    localbdpj.setTextSize(10.0F);
    Resources localResources = getContext().getResources();
    localbdpj.setMinimumWidth(90);
    localbdpj.setMaxLines(1);
    try
    {
      Drawable localDrawable = getContext().getResources().getDrawable(parambdpk.b());
      localbdpj.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable, null, null);
      localbdpj.setCompoundDrawablePadding(0);
      int i = aepi.a(9.0F, localResources);
      localbdpj.setPadding(0, i, 0, i);
      localbdpj.setContentDescription(parambdpk.a());
      localbdpj.setId(parambdpk.a());
      localbdpj.setTextColor(-855638017);
      localbdpj.setBackgroundDrawable(null);
      localbdpj.setIncludeFontPadding(true);
      localbdpj.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localbdpj.setGravity(17);
      return localbdpj;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        aepi.a("QQCustomMenuImageLayout", "creatTextViewWithTopIcon ERR", localRuntimeException);
        Object localObject = null;
      }
    }
  }
  
  public void a()
  {
    removeAllViews();
    int m = this.jdField_a_of_type_Bdpi.a();
    int i = 0;
    Object localObject;
    int k;
    int j;
    if (i < m)
    {
      localObject = a(this.jdField_a_of_type_Bdpi.a(i));
      k = f;
      if (k < d)
      {
        j = d;
        label50:
        if (!a(j)) {
          break label207;
        }
        if (i != 6) {
          break label151;
        }
        removeViewAt(i - 1);
        i -= 1;
        this.jdField_b_of_type_AndroidWidgetImageView = a();
        localObject = new LinearLayout.LayoutParams(this.jdField_b_of_type_AndroidWidgetImageView.getPaddingLeft() + 22 + this.jdField_b_of_type_AndroidWidgetImageView.getPaddingRight(), -2);
        this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        addView(this.jdField_b_of_type_AndroidWidgetImageView);
      }
    }
    for (;;)
    {
      this.g = i;
      return;
      j = k;
      if (k <= e) {
        break label50;
      }
      j = e;
      break label50;
      label151:
      addView((View)localObject, new LinearLayout.LayoutParams(j, -2, 0.0F));
      if (i == m - 1) {
        addView(a(c), new LinearLayout.LayoutParams(c, -2, 0.0F));
      }
      i += 1;
      break;
      label207:
      this.jdField_b_of_type_AndroidWidgetImageView = a();
      j = this.jdField_b_of_type_AndroidWidgetImageView.getPaddingLeft() + 22 + this.jdField_b_of_type_AndroidWidgetImageView.getPaddingRight();
      localObject = new LinearLayout.LayoutParams(j, -2);
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (a(j)) {}
      for (;;)
      {
        addView(this.jdField_b_of_type_AndroidWidgetImageView);
        break;
        if (i > 1)
        {
          removeViewAt(i - 1);
          i -= 1;
        }
      }
      i = -1;
    }
  }
  
  public boolean a(int paramInt)
  {
    return a() + paramInt <= this.jdField_b_of_type_Int;
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    addView(paramView);
  }
  
  public void b()
  {
    if (this.g >= 0)
    {
      removeAllViews();
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838680);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131710589));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding((int)(this.h * jdField_a_of_type_Float), (int)(jdField_a_of_type_Float * 10.0F), (int)(this.h * jdField_a_of_type_Float), (int)(jdField_a_of_type_Float * 10.0F));
      int i = this.jdField_a_of_type_AndroidWidgetImageView.getPaddingLeft() + 22 + this.jdField_a_of_type_AndroidWidgetImageView.getPaddingRight();
      Object localObject = new LinearLayout.LayoutParams(i, -2);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      addView(this.jdField_a_of_type_AndroidWidgetImageView);
      int k = 0 + i;
      int j = this.g;
      if (j < this.jdField_a_of_type_Bdpi.a())
      {
        localObject = a(this.jdField_a_of_type_Bdpi.a(j));
        int m = f;
        if (m < d) {
          i = d;
        }
        for (;;)
        {
          addView((View)localObject, new LinearLayout.LayoutParams(i, -2, 0.0F));
          k += i;
          j += 1;
          break;
          i = m;
          if (m > e) {
            i = e;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomMenuImageLayout", 4, "secondScreenWidth: " + k);
      }
      if (k < jdField_a_of_type_Int / 2)
      {
        i = jdField_a_of_type_Int / 2 - k;
        localObject = a(i);
        ((TextView)localObject).setVisibility(4);
        addView((View)localObject, new LinearLayout.LayoutParams(i, -2, 0.0F));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView) {
      a();
    }
    while (paramView != this.jdField_b_of_type_AndroidWidgetImageView) {
      return;
    }
    b();
  }
  
  public void setMenu(bdpi parambdpi)
  {
    this.jdField_a_of_type_Bdpi = parambdpi;
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomMenuImageLayout", 4, "MENU:" + this.jdField_a_of_type_Bdpi.toString());
    }
  }
  
  public void setMenuIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setPopup(BubblePopupWindow paramBubblePopupWindow)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = paramBubblePopupWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuImageLayout
 * JD-Core Version:    0.7.0.1
 */