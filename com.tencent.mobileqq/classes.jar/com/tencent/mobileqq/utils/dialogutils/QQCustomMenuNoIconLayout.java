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
  private BubblePopupWindow a;
  private QQCustomMenu b;
  private View.OnClickListener c;
  private Context d;
  private int e = 0;
  private int f;
  private int g;
  private int h = QQCustomMenuItemPriorityHelper.a;
  private QQCustomMenuNoIconLayout.MenuLine i;
  private QQCustomMenuNoIconLayout.MenuLine j;
  private int k = ViewUtils.dpToPx(8.0F);
  private boolean l = false;
  private Integer m = null;
  private QQCustomMenuNoIconLayout.IMenuCreateOrClickCallback n;
  
  public QQCustomMenuNoIconLayout(Context paramContext)
  {
    super(paramContext);
    this.d = paramContext;
    setOrientation(1);
    this.f = ViewUtils.dpToPx(62.0F);
    this.g = ViewUtils.dpToPx(40.0F);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.e;
    int i2 = this.h * i1 * 2;
    if ((paramInt4 >= paramInt1) && ((i1 != 0) || (paramInt4 >= paramInt2 - 1)) && ((this.e != 0) || (paramInt4 != paramInt2 - 1) || (paramInt3 != paramInt2))) {
      return i2 + paramInt4 + 2;
    }
    return i2 + paramInt4 + 1;
  }
  
  @NotNull
  private StateListDrawable a(boolean paramBoolean, float[] paramArrayOfFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    Object localObject = this.d.getResources();
    int i1;
    if (paramBoolean) {
      i1 = 2131166456;
    } else {
      i1 = 2131166458;
    }
    localGradientDrawable.setColor(((Resources)localObject).getColor(i1));
    localGradientDrawable.setCornerRadii(paramArrayOfFloat);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setShape(0);
    Resources localResources = this.d.getResources();
    if (paramBoolean) {
      i1 = 2131166457;
    } else {
      i1 = 2131166459;
    }
    ((GradientDrawable)localObject).setColor(localResources.getColor(i1));
    ((GradientDrawable)localObject).setCornerRadii(paramArrayOfFloat);
    paramArrayOfFloat = new StateListDrawable();
    paramArrayOfFloat.setExitFadeDuration(400);
    paramArrayOfFloat.addState(new int[] { 16842919 }, (Drawable)localObject);
    paramArrayOfFloat.addState(new int[0], localGradientDrawable);
    return paramArrayOfFloat;
  }
  
  private TextView a(int paramInt, QQCustomMenuItem paramQQCustomMenuItem, boolean paramBoolean, float[] paramArrayOfFloat)
  {
    StateListDrawable localStateListDrawable = a(paramBoolean, paramArrayOfFloat);
    Object localObject = paramQQCustomMenuItem.a();
    paramArrayOfFloat = (float[])localObject;
    if (this.l)
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
    localObject = this.n;
    if (localObject != null) {
      ((QQCustomMenuNoIconLayout.IMenuCreateOrClickCallback)localObject).b(paramInt, paramQQCustomMenuItem);
    }
    localObject = new TextView(getContext());
    ((TextView)localObject).setText(paramArrayOfFloat);
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setTextSize(12.0F);
    ((TextView)localObject).setMaxLines(1);
    ((TextView)localObject).setContentDescription(paramQQCustomMenuItem.a());
    ((TextView)localObject).setId(paramQQCustomMenuItem.b());
    ((TextView)localObject).setTextColor(-855638017);
    ((TextView)localObject).setBackgroundDrawable(localStateListDrawable);
    ((TextView)localObject).setIncludeFontPadding(true);
    ((TextView)localObject).setOnClickListener(new QQCustomMenuNoIconLayout.3(this, paramInt, paramQQCustomMenuItem));
    ((TextView)localObject).setGravity(17);
    return localObject;
  }
  
  @NotNull
  private TextView a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5, QQCustomMenuItem paramQQCustomMenuItem)
  {
    int i1 = a(paramInt3, paramInt4, paramInt2, paramInt5);
    float[] arrayOfFloat;
    if (paramInt5 == 0)
    {
      if ((paramInt1 == 0) && (paramInt2 == 1)) {
        arrayOfFloat = getFullRadii();
      } else if (paramInt2 <= paramInt3) {
        arrayOfFloat = getLeftRadii();
      } else {
        arrayOfFloat = getTopLeftRadii();
      }
      return a(i1, paramQQCustomMenuItem, paramBoolean, arrayOfFloat);
    }
    if (((paramInt1 == 0) && (paramInt5 == paramInt3 - 1)) || ((paramInt1 == 0) && (paramInt2 < paramInt3) && (paramInt5 == paramInt2 - 1)))
    {
      if (paramInt2 <= paramInt3) {
        arrayOfFloat = getRightRadii();
      } else {
        arrayOfFloat = getTopRightRadii();
      }
      return a(i1, paramQQCustomMenuItem, paramBoolean, arrayOfFloat);
    }
    if (paramInt5 == paramInt3) {
      return a(i1, paramQQCustomMenuItem, paramBoolean, getBottomLeftRadii());
    }
    if (paramInt5 == paramInt4 - 1) {
      return a(i1, paramQQCustomMenuItem, paramBoolean, getBottomRightRadii());
    }
    return a(i1, paramQQCustomMenuItem, paramBoolean, getNonRadii());
  }
  
  private TextView a(int paramInt, boolean paramBoolean, float[] paramArrayOfFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    Resources localResources = this.d.getResources();
    int i1;
    if (paramBoolean) {
      i1 = 2131166456;
    } else {
      i1 = 2131166458;
    }
    localGradientDrawable.setColor(localResources.getColor(i1));
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
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i3 = getWidth();
    removeAllViews();
    boolean bool2 = QQTheme.isNowThemeIsNight();
    int i4 = this.b.b() - paramInt;
    int i1;
    if (paramInt == 0) {
      i1 = this.h;
    } else {
      i1 = this.h - 1;
    }
    int i2;
    if (paramInt == 0) {
      i2 = this.h * 2;
    } else {
      i2 = this.h * 2 - 1;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[menu] showMenu offset: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" count: ");
      ((StringBuilder)localObject).append(i4);
      QLog.d("QQCustomMenuNoIconLayout", 2, ((StringBuilder)localObject).toString());
    }
    a(paramInt, bool2, i4, i1, i2);
    boolean bool1 = false;
    if ((i4 > i1) && (i4 < i2) && (this.j != null))
    {
      int i5 = i2 - i4;
      i2 = 0;
      while (i2 < i5)
      {
        int i6 = i5 - 1;
        if (i2 == i6) {
          localObject = a(this.f, bool2, getBottomRightRadii());
        } else {
          localObject = a(this.f, bool2, getNonRadii());
        }
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.f, -1);
        localLayoutParams.gravity = 16;
        this.j.addView((View)localObject, localLayoutParams);
        if (i2 < i6) {
          QQCustomMenuNoIconLayout.MenuLine.a(this.j, bool2);
        }
        i2 += 1;
      }
    }
    if ((paramInt > 0) && (i4 < i1))
    {
      localObject = this.i;
      if (localObject != null)
      {
        QQCustomMenuNoIconLayout.MenuLine.a((QQCustomMenuNoIconLayout.MenuLine)localObject, bool2);
        paramInt = this.e;
        i2 = this.h;
        this.i.addView(a(paramInt * i2 * 2 + i4 + 1, false, bool2, getRightRadii()), new LinearLayout.LayoutParams(this.f, -1));
      }
    }
    addView(this.i, new LinearLayout.LayoutParams(-2, this.g));
    if (this.j != null)
    {
      a(bool2);
      addView(this.j, new LinearLayout.LayoutParams(-2, this.g));
    }
    if (paramBoolean)
    {
      paramInt = this.f;
      i2 = Math.min(i4 + 1, this.h);
      localObject = this.a;
      paramBoolean = bool1;
      if (i4 >= i1) {
        paramBoolean = true;
      }
      ((BubblePopupWindow)localObject).updateLocationX((paramInt + 1) * i2 - 1, paramBoolean, i3);
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0;
    while (i1 < paramInt2)
    {
      Object localObject = a(paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, i1, this.b.a(i1 + paramInt1));
      if (i1 < paramInt3)
      {
        a(paramInt1, paramBoolean, paramInt2, paramInt3, i1, (TextView)localObject);
      }
      else
      {
        if (i1 >= paramInt4) {
          break label85;
        }
        a(paramBoolean, paramInt4, i1, (TextView)localObject);
      }
      i1 += 1;
      continue;
      label85:
      localObject = this.j;
      if (localObject != null)
      {
        ((QQCustomMenuNoIconLayout.MenuLine)localObject).removeViewAt(((QQCustomMenuNoIconLayout.MenuLine)localObject).getChildCount() - 1);
        paramInt1 = this.e;
        paramInt2 = this.h;
        this.j.addView(a((paramInt1 + 1) * paramInt2 * 2, true, paramBoolean, getBottomRightRadii()), new LinearLayout.LayoutParams(this.f, -1));
      }
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, TextView paramTextView)
  {
    if (this.i == null) {
      this.i = new QQCustomMenuNoIconLayout.MenuLine(this, this.d);
    }
    this.i.addView(paramTextView, new LinearLayout.LayoutParams(this.f, -1));
    if (paramInt4 < paramInt3 - 1)
    {
      if (paramInt4 != paramInt2 - 1) {
        QQCustomMenuNoIconLayout.MenuLine.a(this.i, paramBoolean);
      }
    }
    else if (paramInt1 > 0)
    {
      QQCustomMenuNoIconLayout.MenuLine.a(this.i, paramBoolean);
      paramInt1 = this.e;
      paramInt4 = this.h;
      QQCustomMenuNoIconLayout.MenuLine localMenuLine = this.i;
      if (paramInt2 <= paramInt3) {
        paramTextView = getRightRadii();
      } else {
        paramTextView = getTopRightRadii();
      }
      localMenuLine.addView(a(paramInt1 * paramInt4 * 2 + paramInt4, false, paramBoolean, paramTextView), new LinearLayout.LayoutParams(this.f, -1));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = new View(this.d);
    Resources localResources = this.d.getResources();
    int i1;
    if (paramBoolean) {
      i1 = 2131166461;
    } else {
      i1 = 2131166463;
    }
    localView.setBackgroundColor(localResources.getColor(i1));
    addView(localView, new LinearLayout.LayoutParams(-1, 1));
    localView = new View(this.d);
    localResources = this.d.getResources();
    if (paramBoolean) {
      i1 = 2131166460;
    } else {
      i1 = 2131166462;
    }
    localView.setBackgroundColor(localResources.getColor(i1));
    addView(localView, new LinearLayout.LayoutParams(-1, 1));
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, TextView paramTextView)
  {
    if (this.j == null) {
      this.j = new QQCustomMenuNoIconLayout.MenuLine(this, this.d);
    }
    this.j.addView(paramTextView, new LinearLayout.LayoutParams(this.f, -1));
    if (paramInt2 < paramInt1 - 1) {
      QQCustomMenuNoIconLayout.MenuLine.a(this.j, paramBoolean);
    }
  }
  
  private float[] getBottomLeftRadii()
  {
    int i1 = this.k;
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, i1, i1 };
  }
  
  private float[] getBottomRightRadii()
  {
    int i1 = this.k;
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, i1, i1, 0.0F, 0.0F };
  }
  
  private float[] getFullRadii()
  {
    int i1 = this.k;
    return new float[] { i1, i1, i1, i1, i1, i1, i1, i1 };
  }
  
  private float[] getLeftRadii()
  {
    int i1 = this.k;
    return new float[] { i1, i1, 0.0F, 0.0F, 0.0F, 0.0F, i1, i1 };
  }
  
  private float[] getNonRadii()
  {
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  private float[] getRightRadii()
  {
    int i1 = this.k;
    return new float[] { 0.0F, 0.0F, i1, i1, i1, i1, 0.0F, 0.0F };
  }
  
  private float[] getTopLeftRadii()
  {
    int i1 = this.k;
    return new float[] { i1, i1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  private float[] getTopRightRadii()
  {
    int i1 = this.k;
    return new float[] { 0.0F, 0.0F, i1, i1, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  int a(int paramInt)
  {
    int i1 = 0;
    if (paramInt > 0)
    {
      i1 = this.h;
      i1 = i1 * 2 - 1 + 0 + (paramInt - 1) * (i1 * 2 - 2);
    }
    return i1;
  }
  
  protected ImageView a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, float[] paramArrayOfFloat)
  {
    Object localObject = a(paramBoolean2, paramArrayOfFloat);
    paramArrayOfFloat = new ImageView(getContext());
    int i1;
    if (paramBoolean1) {
      i1 = 2130839069;
    } else {
      i1 = 2130839071;
    }
    paramArrayOfFloat.setImageResource(i1);
    if (paramBoolean1) {
      i1 = 2131907850;
    } else {
      i1 = 2131907851;
    }
    paramArrayOfFloat.setContentDescription(HardCodeUtil.a(i1));
    paramArrayOfFloat.setBackgroundDrawable((Drawable)localObject);
    paramArrayOfFloat.setScaleType(ImageView.ScaleType.CENTER);
    paramArrayOfFloat.setOnClickListener(new QQCustomMenuNoIconLayout.2(this, paramBoolean1, paramInt));
    localObject = this.n;
    if (localObject != null) {
      ((QQCustomMenuNoIconLayout.IMenuCreateOrClickCallback)localObject).a(paramInt, paramBoolean1);
    }
    return paramArrayOfFloat;
  }
  
  public boolean a()
  {
    return this.b.b() >= this.h;
  }
  
  public boolean b()
  {
    return this.l;
  }
  
  public void c()
  {
    a(0, false);
  }
  
  public Integer getContainerBottom()
  {
    return this.m;
  }
  
  public void removeAllViews()
  {
    super.removeAllViews();
    this.i = null;
    this.j = null;
  }
  
  public void setContainerBottom(Integer paramInteger)
  {
    this.m = paramInteger;
  }
  
  public void setIgnoreTouchLocation(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setMenu(QQCustomMenu paramQQCustomMenu)
  {
    this.b = paramQQCustomMenu.e();
    if (QLog.isColorLevel())
    {
      paramQQCustomMenu = new StringBuilder();
      paramQQCustomMenu.append("[menu] setMenu MENU:");
      paramQQCustomMenu.append(this.b.toString());
      QLog.d("QQCustomMenuNoIconLayout", 4, paramQQCustomMenu.toString());
    }
  }
  
  public void setMenuCreateOrClickCallback(QQCustomMenuNoIconLayout.IMenuCreateOrClickCallback paramIMenuCreateOrClickCallback)
  {
    this.n = paramIMenuCreateOrClickCallback;
  }
  
  public void setMenuIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
  }
  
  public void setPopupWindow(BubblePopupWindow paramBubblePopupWindow, BubblePopupWindow.QQMenuNoIconEmptyInterface paramQQMenuNoIconEmptyInterface)
  {
    this.a = paramBubblePopupWindow;
    this.a.addOnDismissListener(new QQCustomMenuNoIconLayout.1(this));
    this.a.setQQMenuNoIconEmptyInterface(paramQQMenuNoIconEmptyInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout
 * JD-Core Version:    0.7.0.1
 */