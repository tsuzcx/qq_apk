package com.tencent.mobileqq.utils.dialogutils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.QQMenuNoIconEmptyInterface;
import org.jetbrains.annotations.NotNull;

public class QQCustomMenuNoIconLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQCustomMenu jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
  private QQCustomMenuNoIconLayout.IMenuCreateOrClickCallback jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$IMenuCreateOrClickCallback;
  private QQCustomMenuNoIconLayout.MenuLine jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private Integer jdField_a_of_type_JavaLangInteger = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private QQCustomMenuNoIconLayout.MenuLine jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine;
  private int c;
  private int d = QQCustomMenuItemPriorityHelper.jdField_a_of_type_Int;
  private int e = ViewUtils.b(8.0F);
  
  public QQCustomMenuNoIconLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setOrientation(1);
    this.jdField_b_of_type_Int = ViewUtils.b(62.0F);
    this.c = ViewUtils.b(40.0F);
  }
  
  @NotNull
  private StateListDrawable a(boolean paramBoolean, float[] paramArrayOfFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i;
    if (paramBoolean) {
      i = 2131165814;
    } else {
      i = 2131165816;
    }
    localGradientDrawable.setColor(((Resources)localObject).getColor(i));
    localGradientDrawable.setCornerRadii(paramArrayOfFloat);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setShape(0);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramBoolean) {
      i = 2131165815;
    } else {
      i = 2131165817;
    }
    ((GradientDrawable)localObject).setColor(localResources.getColor(i));
    ((GradientDrawable)localObject).setCornerRadii(paramArrayOfFloat);
    paramArrayOfFloat = new StateListDrawable();
    paramArrayOfFloat.setExitFadeDuration(400);
    paramArrayOfFloat.addState(new int[] { 16842919 }, (Drawable)localObject);
    paramArrayOfFloat.addState(new int[0], localGradientDrawable);
    return paramArrayOfFloat;
  }
  
  @NotNull
  private TextView a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, QQCustomMenuItem paramQQCustomMenuItem)
  {
    float[] arrayOfFloat;
    if (paramInt5 == 0)
    {
      if ((paramInt1 == 0) && (paramInt2 == 1)) {
        arrayOfFloat = h();
      } else if (paramInt2 <= paramInt3) {
        arrayOfFloat = f();
      } else {
        arrayOfFloat = b();
      }
      return a(paramQQCustomMenuItem, paramBoolean, arrayOfFloat);
    }
    if (((paramInt1 == 0) && (paramInt5 == paramInt3 - 1)) || ((paramInt1 == 0) && (paramInt2 < paramInt3) && (paramInt5 == paramInt2 - 1)))
    {
      if (paramInt2 <= paramInt3) {
        arrayOfFloat = g();
      } else {
        arrayOfFloat = c();
      }
      return a(paramQQCustomMenuItem, paramBoolean, arrayOfFloat);
    }
    if (paramInt5 == paramInt3) {
      return a(paramQQCustomMenuItem, paramBoolean, e());
    }
    if (paramInt5 == paramInt4 - 1) {
      return a(paramQQCustomMenuItem, paramBoolean, d());
    }
    return a(paramQQCustomMenuItem, paramBoolean, a());
  }
  
  private TextView a(int paramInt, boolean paramBoolean, float[] paramArrayOfFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i;
    if (paramBoolean) {
      i = 2131165814;
    } else {
      i = 2131165816;
    }
    localGradientDrawable.setColor(localResources.getColor(i));
    localGradientDrawable.setCornerRadii(paramArrayOfFloat);
    paramArrayOfFloat = new TextView(getContext());
    paramArrayOfFloat.setText("");
    paramArrayOfFloat.setTextSize(1.0F);
    paramArrayOfFloat.setWidth(paramInt);
    paramArrayOfFloat.setMaxLines(1);
    paramArrayOfFloat.setPadding(0, 0, 0, 0);
    paramArrayOfFloat.setTextColor(-1);
    paramArrayOfFloat.setBackgroundDrawable(localGradientDrawable);
    paramArrayOfFloat.setGravity(17);
    return paramArrayOfFloat;
  }
  
  private TextView a(QQCustomMenuItem paramQQCustomMenuItem, boolean paramBoolean, float[] paramArrayOfFloat)
  {
    StateListDrawable localStateListDrawable = a(paramBoolean, paramArrayOfFloat);
    Object localObject = paramQQCustomMenuItem.a();
    paramArrayOfFloat = (float[])localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      paramArrayOfFloat = (float[])localObject;
      if (((String)localObject).length() > 4)
      {
        paramArrayOfFloat = new StringBuilder();
        paramArrayOfFloat.append(((String)localObject).substring(0, 3));
        paramArrayOfFloat.append("…");
        paramArrayOfFloat = paramArrayOfFloat.toString();
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$IMenuCreateOrClickCallback;
    if (localObject != null) {
      ((QQCustomMenuNoIconLayout.IMenuCreateOrClickCallback)localObject).b(paramQQCustomMenuItem);
    }
    localObject = new TextView(getContext());
    ((TextView)localObject).setText(paramArrayOfFloat);
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setTextSize(12.0F);
    ((TextView)localObject).setMaxLines(1);
    ((TextView)localObject).setContentDescription(paramQQCustomMenuItem.a());
    ((TextView)localObject).setId(paramQQCustomMenuItem.a());
    ((TextView)localObject).setTextColor(-855638017);
    ((TextView)localObject).setBackgroundDrawable(localStateListDrawable);
    ((TextView)localObject).setIncludeFontPadding(true);
    ((TextView)localObject).setOnClickListener(new QQCustomMenuNoIconLayout.2(this, paramQQCustomMenuItem));
    ((TextView)localObject).setGravity(17);
    return localObject;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int k = getWidth();
    removeAllViews();
    boolean bool2 = QQTheme.a();
    int m = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a() - paramInt;
    int i;
    if (paramInt == 0) {
      i = this.d;
    } else {
      i = this.d - 1;
    }
    int j;
    if (paramInt == 0) {
      j = this.d * 2;
    } else {
      j = this.d * 2 - 1;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[menu] showMenu offset: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" count: ");
      ((StringBuilder)localObject).append(m);
      QLog.d("QQCustomMenuNoIconLayout", 2, ((StringBuilder)localObject).toString());
    }
    a(paramInt, bool2, m, i, j);
    boolean bool1 = false;
    if ((m > i) && (m < j) && (this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine != null))
    {
      int n = j - m;
      j = 0;
      while (j < n)
      {
        int i1 = n - 1;
        if (j == i1) {
          localObject = a(this.jdField_b_of_type_Int, bool2, d());
        } else {
          localObject = a(this.jdField_b_of_type_Int, bool2, a());
        }
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1);
        localLayoutParams.gravity = 16;
        this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine.addView((View)localObject, localLayoutParams);
        if (j < i1) {
          QQCustomMenuNoIconLayout.MenuLine.a(this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine, bool2);
        }
        j += 1;
      }
    }
    if ((paramInt > 0) && (m < i))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine;
      if (localObject != null)
      {
        QQCustomMenuNoIconLayout.MenuLine.a((QQCustomMenuNoIconLayout.MenuLine)localObject, bool2);
        this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine.addView(a(false, bool2, g()), new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
      }
    }
    addView(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine, new LinearLayout.LayoutParams(-2, this.c));
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine != null)
    {
      a(bool2);
      addView(this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine, new LinearLayout.LayoutParams(-2, this.c));
    }
    if (paramBoolean)
    {
      paramInt = this.jdField_b_of_type_Int;
      j = Math.min(m + 1, this.d);
      localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
      paramBoolean = bool1;
      if (m >= i) {
        paramBoolean = true;
      }
      ((BubblePopupWindow)localObject).updateLocationX((paramInt + 1) * j - 1, paramBoolean, k);
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    while (i < paramInt2)
    {
      Object localObject = a(paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, i, this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(i + paramInt1));
      if (i < paramInt3)
      {
        a(paramInt1, paramBoolean, paramInt2, paramInt3, i, (TextView)localObject);
      }
      else
      {
        if (i >= paramInt4) {
          break label85;
        }
        a(paramBoolean, paramInt4, i, (TextView)localObject);
      }
      i += 1;
      continue;
      label85:
      localObject = this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine;
      if (localObject != null)
      {
        ((QQCustomMenuNoIconLayout.MenuLine)localObject).removeViewAt(((QQCustomMenuNoIconLayout.MenuLine)localObject).getChildCount() - 1);
        this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine.addView(a(true, paramBoolean, d()), new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
      }
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, TextView paramTextView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine = new QQCustomMenuNoIconLayout.MenuLine(this, this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine.addView(paramTextView, new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
    if (paramInt4 < paramInt3 - 1)
    {
      if (paramInt4 != paramInt2 - 1) {
        QQCustomMenuNoIconLayout.MenuLine.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine, paramBoolean);
      }
    }
    else if (paramInt1 > 0)
    {
      QQCustomMenuNoIconLayout.MenuLine.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine, paramBoolean);
      QQCustomMenuNoIconLayout.MenuLine localMenuLine = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine;
      if (paramInt2 <= paramInt3) {
        paramTextView = g();
      } else {
        paramTextView = c();
      }
      localMenuLine.addView(a(false, paramBoolean, paramTextView), new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i;
    if (paramBoolean) {
      i = 2131165819;
    } else {
      i = 2131165821;
    }
    localView.setBackgroundColor(localResources.getColor(i));
    addView(localView, new LinearLayout.LayoutParams(-1, 1));
    localView = new View(this.jdField_a_of_type_AndroidContentContext);
    localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramBoolean) {
      i = 2131165818;
    } else {
      i = 2131165820;
    }
    localView.setBackgroundColor(localResources.getColor(i));
    addView(localView, new LinearLayout.LayoutParams(-1, 1));
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, TextView paramTextView)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine = new QQCustomMenuNoIconLayout.MenuLine(this, this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine.addView(paramTextView, new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
    if (paramInt2 < paramInt1 - 1) {
      QQCustomMenuNoIconLayout.MenuLine.a(this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine, paramBoolean);
    }
  }
  
  private float[] a()
  {
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  private float[] b()
  {
    int i = this.e;
    return new float[] { i, i, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  private float[] c()
  {
    int i = this.e;
    return new float[] { 0.0F, 0.0F, i, i, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  private float[] d()
  {
    int i = this.e;
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, i, i, 0.0F, 0.0F };
  }
  
  private float[] e()
  {
    int i = this.e;
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, i, i };
  }
  
  private float[] f()
  {
    int i = this.e;
    return new float[] { i, i, 0.0F, 0.0F, 0.0F, 0.0F, i, i };
  }
  
  private float[] g()
  {
    int i = this.e;
    return new float[] { 0.0F, 0.0F, i, i, i, i, 0.0F, 0.0F };
  }
  
  private float[] h()
  {
    int i = this.e;
    return new float[] { i, i, i, i, i, i, i, i };
  }
  
  int a(int paramInt)
  {
    int i = 0;
    if (paramInt > 0)
    {
      i = this.d;
      i = i * 2 - 1 + 0 + (paramInt - 1) * (i * 2 - 2);
    }
    return i;
  }
  
  protected ImageView a(boolean paramBoolean1, boolean paramBoolean2, float[] paramArrayOfFloat)
  {
    Object localObject = a(paramBoolean2, paramArrayOfFloat);
    paramArrayOfFloat = new ImageView(getContext());
    int i;
    if (paramBoolean1) {
      i = 2130838915;
    } else {
      i = 2130838917;
    }
    paramArrayOfFloat.setImageResource(i);
    if (paramBoolean1) {
      i = 2131710145;
    } else {
      i = 2131710146;
    }
    paramArrayOfFloat.setContentDescription(HardCodeUtil.a(i));
    paramArrayOfFloat.setBackgroundDrawable((Drawable)localObject);
    paramArrayOfFloat.setScaleType(ImageView.ScaleType.CENTER);
    paramArrayOfFloat.setOnClickListener(new QQCustomMenuNoIconLayout.1(this, paramBoolean1));
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$IMenuCreateOrClickCallback;
    if (localObject != null) {
      ((QQCustomMenuNoIconLayout.IMenuCreateOrClickCallback)localObject).a(paramBoolean1);
    }
    return paramArrayOfFloat;
  }
  
  public Integer a()
  {
    return this.jdField_a_of_type_JavaLangInteger;
  }
  
  public void a()
  {
    a(0, false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a() >= this.d;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void removeAllViews()
  {
    super.removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine = null;
    this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine = null;
  }
  
  public void setContainerBottom(Integer paramInteger)
  {
    this.jdField_a_of_type_JavaLangInteger = paramInteger;
  }
  
  public void setIgnoreTouchLocation(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setMenu(QQCustomMenu paramQQCustomMenu)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = paramQQCustomMenu.a();
    if (QLog.isColorLevel())
    {
      paramQQCustomMenu = new StringBuilder();
      paramQQCustomMenu.append("[menu] setMenu MENU:");
      paramQQCustomMenu.append(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.toString());
      QLog.d("QQCustomMenuNoIconLayout", 4, paramQQCustomMenu.toString());
    }
  }
  
  public void setMenuCreateOrClickCallback(QQCustomMenuNoIconLayout.IMenuCreateOrClickCallback paramIMenuCreateOrClickCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$IMenuCreateOrClickCallback = paramIMenuCreateOrClickCallback;
  }
  
  public void setMenuIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setPopupWindow(BubblePopupWindow paramBubblePopupWindow, BubblePopupWindow.QQMenuNoIconEmptyInterface paramQQMenuNoIconEmptyInterface)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = paramBubblePopupWindow;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setQQMenuNoIconEmptyInterface(paramQQMenuNoIconEmptyInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout
 * JD-Core Version:    0.7.0.1
 */