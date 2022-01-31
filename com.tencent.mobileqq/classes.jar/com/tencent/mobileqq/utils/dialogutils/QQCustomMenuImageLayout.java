package com.tencent.mobileqq.utils.dialogutils;

import ajsp;
import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
  private QQCustomMenu jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
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
    localImageView.setImageResource(2130838315);
    localImageView.setContentDescription("向右翻页");
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
  
  private TextView a(QQCustomMenuItem paramQQCustomMenuItem)
  {
    ajsp localajsp = new ajsp(this, getContext());
    localajsp.setText(paramQQCustomMenuItem.a());
    localajsp.setTextSize(10.0F);
    Resources localResources = getContext().getResources();
    localajsp.setMinimumWidth(90);
    localajsp.setMaxLines(1);
    localajsp.setCompoundDrawablesWithIntrinsicBounds(null, getContext().getResources().getDrawable(paramQQCustomMenuItem.b()), null, null);
    localajsp.setCompoundDrawablePadding(0);
    int i = AIOUtils.a(9.0F, localResources);
    localajsp.setPadding(0, i, 0, i);
    localajsp.setContentDescription(paramQQCustomMenuItem.a());
    localajsp.setId(paramQQCustomMenuItem.a());
    localajsp.setTextColor(-855638017);
    localajsp.setBackgroundDrawable(null);
    localajsp.setIncludeFontPadding(true);
    localajsp.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localajsp.setGravity(17);
    return localajsp;
  }
  
  public void a()
  {
    removeAllViews();
    int m = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a();
    int i = 0;
    Object localObject;
    int k;
    int j;
    if (i < m)
    {
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(i));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838310);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("向左翻页");
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding((int)(this.h * jdField_a_of_type_Float), (int)(jdField_a_of_type_Float * 10.0F), (int)(this.h * jdField_a_of_type_Float), (int)(jdField_a_of_type_Float * 10.0F));
      int i = this.jdField_a_of_type_AndroidWidgetImageView.getPaddingLeft() + 22 + this.jdField_a_of_type_AndroidWidgetImageView.getPaddingRight();
      Object localObject = new LinearLayout.LayoutParams(i, -2);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      addView(this.jdField_a_of_type_AndroidWidgetImageView);
      int k = 0 + i;
      int j = this.g;
      if (j < this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a())
      {
        localObject = a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(j));
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
  
  public void setMenu(QQCustomMenu paramQQCustomMenu)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = paramQQCustomMenu;
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomMenuImageLayout", 4, "MENU:" + this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuImageLayout
 * JD-Core Version:    0.7.0.1
 */