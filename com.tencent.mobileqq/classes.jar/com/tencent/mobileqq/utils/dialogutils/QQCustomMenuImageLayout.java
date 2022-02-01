package com.tencent.mobileqq.utils.dialogutils;

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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

public class QQCustomMenuImageLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static float a = 1.0F;
  public static int a = 0;
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
  private int h = 0;
  
  public QQCustomMenuImageLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = 0;
    setOrientation(0);
    this.jdField_b_of_type_Int = (jdField_a_of_type_Int - (int)(jdField_a_of_type_Float * 10.0F));
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("screenWidth:");
      paramContext.append(jdField_a_of_type_Int);
      paramContext.append(" mDensity: ");
      paramContext.append(jdField_a_of_type_Float);
      paramContext.append(" layoutMaxWidth A:");
      paramContext.append(this.jdField_b_of_type_Int);
      QLog.d("QQCustomMenuImageLayout", 4, paramContext.toString());
    }
    this.h = 12;
    if (jdField_a_of_type_Float >= 2.0F) {
      this.h = 20;
    }
  }
  
  private int a()
  {
    int m = getChildCount();
    int j = 0;
    Object localObject;
    for (int k = 0; j < m; k = i)
    {
      localObject = getChildAt(j);
      i = k;
      if (localObject != null)
      {
        i = k;
        if (((View)localObject).getVisibility() != 8)
        {
          TextView localTextView = (TextView)localObject;
          int n = (int)Layout.getDesiredWidth(localTextView.getText(), localTextView.getPaint());
          k += ((View)localObject).getPaddingLeft() + n + ((View)localObject).getPaddingRight();
          i = k;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("child  TextView text ");
            localStringBuilder.append(localTextView.getText());
            localStringBuilder.append(" measureWidth = ");
            localStringBuilder.append(n);
            localStringBuilder.append(" paddingL = ");
            localStringBuilder.append(((View)localObject).getPaddingLeft());
            localStringBuilder.append(" paddingR = ");
            localStringBuilder.append(((View)localObject).getPaddingRight());
            QLog.d("QQCustomMenuImageLayout", 4, localStringBuilder.toString());
            i = k;
          }
        }
      }
      j += 1;
    }
    int i = c * 2 + k;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("totalWidth   ");
      ((StringBuilder)localObject).append(i);
      QLog.d("QQCustomMenuImageLayout", 4, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  private ImageView a()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageResource(2130838921);
    localImageView.setContentDescription(HardCodeUtil.a(2131710157));
    localImageView.setBackgroundDrawable(null);
    localImageView.setOnClickListener(this);
    int i = this.h;
    float f1 = i;
    float f2 = jdField_a_of_type_Float;
    localImageView.setPadding((int)(f1 * f2), (int)(f2 * 10.0F), (int)(i * f2), (int)(f2 * 10.0F));
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
    QQCustomMenuImageLayout.1 local1 = new QQCustomMenuImageLayout.1(this, getContext());
    local1.setText(paramQQCustomMenuItem.a());
    local1.setTextSize(10.0F);
    Resources localResources = getContext().getResources();
    local1.setMinimumWidth(90);
    local1.setMaxLines(1);
    Drawable localDrawable2;
    try
    {
      Drawable localDrawable1 = getContext().getResources().getDrawable(paramQQCustomMenuItem.b());
    }
    catch (RuntimeException localRuntimeException)
    {
      AIOUtils.a("QQCustomMenuImageLayout", "creatTextViewWithTopIcon ERR", localRuntimeException);
      localDrawable2 = null;
    }
    local1.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable2, null, null);
    local1.setCompoundDrawablePadding(0);
    int i = AIOUtils.b(9.0F, localResources);
    local1.setPadding(0, i, 0, i);
    local1.setContentDescription(paramQQCustomMenuItem.a());
    local1.setId(paramQQCustomMenuItem.a());
    local1.setTextColor(-855638017);
    local1.setBackgroundDrawable(null);
    local1.setIncludeFontPadding(true);
    local1.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    local1.setGravity(17);
    return local1;
  }
  
  public void a()
  {
    removeAllViews();
    int m = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a();
    int i = 0;
    while (i < m)
    {
      Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(i));
      j = f;
      int k = d;
      if (j < k)
      {
        j = k;
      }
      else
      {
        k = e;
        if (j > k) {
          j = k;
        }
      }
      if (a(j))
      {
        if (i == 6)
        {
          j = i - 1;
          removeViewAt(j);
          this.jdField_b_of_type_AndroidWidgetImageView = a();
          localObject = new LinearLayout.LayoutParams(this.jdField_b_of_type_AndroidWidgetImageView.getPaddingLeft() + 22 + this.jdField_b_of_type_AndroidWidgetImageView.getPaddingRight(), -2);
          this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          addView(this.jdField_b_of_type_AndroidWidgetImageView);
          break label293;
        }
        addView((View)localObject, new LinearLayout.LayoutParams(j, -2, 0.0F));
        if (i == m - 1) {
          addView(a(c), new LinearLayout.LayoutParams(c, -2, 0.0F));
        }
        i += 1;
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetImageView = a();
        j = this.jdField_b_of_type_AndroidWidgetImageView.getPaddingLeft() + 22 + this.jdField_b_of_type_AndroidWidgetImageView.getPaddingRight();
        localObject = new LinearLayout.LayoutParams(j, -2);
        this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (a(j))
        {
          j = i;
        }
        else
        {
          j = i;
          if (i > 1)
          {
            j = i - 1;
            removeViewAt(j);
          }
        }
        addView(this.jdField_b_of_type_AndroidWidgetImageView);
        break label293;
      }
    }
    int j = -1;
    label293:
    this.g = j;
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838914);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131710150));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      int i = this.h;
      float f1 = i;
      float f2 = jdField_a_of_type_Float;
      ((ImageView)localObject).setPadding((int)(f1 * f2), (int)(f2 * 10.0F), (int)(i * f2), (int)(f2 * 10.0F));
      i = this.jdField_a_of_type_AndroidWidgetImageView.getPaddingLeft() + 22 + this.jdField_a_of_type_AndroidWidgetImageView.getPaddingRight();
      localObject = new LinearLayout.LayoutParams(i, -2);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      addView(this.jdField_a_of_type_AndroidWidgetImageView);
      int j = i + 0;
      int k = this.g;
      while (k < this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a())
      {
        localObject = a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(k));
        i = f;
        int m = d;
        if (i < m)
        {
          i = m;
        }
        else
        {
          m = e;
          if (i > m) {
            i = m;
          }
        }
        addView((View)localObject, new LinearLayout.LayoutParams(i, -2, 0.0F));
        j += i;
        k += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("secondScreenWidth: ");
        ((StringBuilder)localObject).append(j);
        QLog.d("QQCustomMenuImageLayout", 4, ((StringBuilder)localObject).toString());
      }
      i = jdField_a_of_type_Int;
      if (j < i / 2)
      {
        i = i / 2 - j;
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
    } else if (paramView == this.jdField_b_of_type_AndroidWidgetImageView) {
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setMenu(QQCustomMenu paramQQCustomMenu)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = paramQQCustomMenu;
    if (QLog.isColorLevel())
    {
      paramQQCustomMenu = new StringBuilder();
      paramQQCustomMenu.append("MENU:");
      paramQQCustomMenu.append(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.toString());
      QLog.d("QQCustomMenuImageLayout", 4, paramQQCustomMenu.toString());
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