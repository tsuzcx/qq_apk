package com.tencent.mobileqq.utils.dialogutils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.QQMenuNoIconEmptyInterface;
import com.tencent.widget.ThemeImageWrapper;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class QQCustomMenuNoIconLayout
  extends LinearLayout
{
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new QQCustomMenuNoIconLayout.4();
  private static int g = 100;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQCustomMenu jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
  private QQCustomMenuNoIconLayout.MenuLine jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine;
  private BubblePopupWindow.QQMenuNoIconEmptyInterface jdField_a_of_type_ComTencentWidgetBubblePopupWindow$QQMenuNoIconEmptyInterface = new QQCustomMenuNoIconLayout.1(this);
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private Integer jdField_a_of_type_JavaLangInteger = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private QQCustomMenuNoIconLayout.MenuLine jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine;
  private int c;
  private int d = QQCustomMenuItemPriorityHelper.jdField_a_of_type_Int;
  private int e = ViewUtils.b(8.0F);
  private int f = -1;
  
  public QQCustomMenuNoIconLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setOrientation(1);
    this.jdField_b_of_type_Int = AIOUtils.a(62.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.c = AIOUtils.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  @NotNull
  private StateListDrawable a(boolean paramBoolean, float[] paramArrayOfFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    Resources localResources;
    if (paramBoolean)
    {
      i = 2131165811;
      localGradientDrawable.setColor(((Resources)localObject).getColor(i));
      localGradientDrawable.setCornerRadii(paramArrayOfFloat);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setShape(0);
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (!paramBoolean) {
        break label142;
      }
    }
    label142:
    for (int i = 2131165812;; i = 2131165814)
    {
      ((GradientDrawable)localObject).setColor(localResources.getColor(i));
      ((GradientDrawable)localObject).setCornerRadii(paramArrayOfFloat);
      paramArrayOfFloat = new StateListDrawable();
      paramArrayOfFloat.setExitFadeDuration(400);
      paramArrayOfFloat.addState(new int[] { 16842919 }, (Drawable)localObject);
      paramArrayOfFloat.addState(new int[0], localGradientDrawable);
      return paramArrayOfFloat;
      i = 2131165813;
      break;
    }
  }
  
  private TextView a(int paramInt, boolean paramBoolean, float[] paramArrayOfFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramBoolean) {}
    for (int i = 2131165811;; i = 2131165813)
    {
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
  }
  
  private TextView a(QQCustomMenuItem paramQQCustomMenuItem, boolean paramBoolean, float[] paramArrayOfFloat)
  {
    StateListDrawable localStateListDrawable = a(paramBoolean, paramArrayOfFloat);
    Object localObject = paramQQCustomMenuItem.a();
    paramArrayOfFloat = (float[])localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      paramArrayOfFloat = (float[])localObject;
      if (((String)localObject).length() > 4) {
        paramArrayOfFloat = ((String)localObject).substring(0, 3) + "…";
      }
    }
    a("0X800B3BE", paramQQCustomMenuItem.a());
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
    ((TextView)localObject).setOnClickListener(new QQCustomMenuNoIconLayout.3(this, paramQQCustomMenuItem));
    ((TextView)localObject).setGravity(17);
    return localObject;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int m = getWidth();
    removeAllViews();
    boolean bool = ThemeImageWrapper.isNightMode();
    int n = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a() - paramInt;
    int i;
    int j;
    label47:
    int k;
    label94:
    Object localObject2;
    Object localObject1;
    if (paramInt == 0)
    {
      i = this.d;
      if (paramInt != 0) {
        break label242;
      }
      j = this.d * 2;
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomMenuNoIconLayout", 2, "[menu] showMenu offset: " + paramInt + " count: " + n);
      }
      k = 0;
      if (k >= n) {
        break label606;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(k + paramInt);
      if (k != 0) {
        break label279;
      }
      if ((paramInt != 0) || (n != 1)) {
        break label255;
      }
      localObject1 = h();
      label135:
      localObject1 = a((QQCustomMenuItem)localObject2, bool, (float[])localObject1);
      label147:
      if (k >= i) {
        break label481;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine = new QQCustomMenuNoIconLayout.MenuLine(this, this.jdField_a_of_type_AndroidContentContext);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine.addView((View)localObject1, new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
      if (k >= i - 1) {
        break label412;
      }
      if (k != n - 1) {
        QQCustomMenuNoIconLayout.MenuLine.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine, bool);
      }
    }
    for (;;)
    {
      k += 1;
      break label94;
      i = this.d - 1;
      break;
      label242:
      j = this.d * 2 - 1;
      break label47;
      label255:
      if (n <= i)
      {
        localObject1 = f();
        break label135;
      }
      localObject1 = b();
      break label135;
      label279:
      if (((paramInt == 0) && (k == i - 1)) || ((paramInt == 0) && (n < i) && (k == n - 1)))
      {
        if (n <= i) {}
        for (localObject1 = g();; localObject1 = c())
        {
          localObject1 = a((QQCustomMenuItem)localObject2, bool, (float[])localObject1);
          break;
        }
      }
      if (k == i)
      {
        localObject1 = a((QQCustomMenuItem)localObject2, bool, e());
        break label147;
      }
      if (k == j - 1)
      {
        localObject1 = a((QQCustomMenuItem)localObject2, bool, d());
        break label147;
      }
      localObject1 = a((QQCustomMenuItem)localObject2, bool, a());
      break label147;
      label412:
      if (paramInt > 0)
      {
        QQCustomMenuNoIconLayout.MenuLine.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine, bool);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine;
        if (n <= i) {}
        for (localObject1 = g();; localObject1 = c())
        {
          ((QQCustomMenuNoIconLayout.MenuLine)localObject2).addView(a(false, bool, (float[])localObject1), new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
          break;
        }
        label481:
        if (k >= j) {
          break label553;
        }
        if (this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine == null) {
          this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine = new QQCustomMenuNoIconLayout.MenuLine(this, this.jdField_a_of_type_AndroidContentContext);
        }
        this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine.addView((View)localObject1, new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
        if (k < j - 1) {
          QQCustomMenuNoIconLayout.MenuLine.a(this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine, bool);
        }
      }
    }
    label553:
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine.removeViewAt(this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine.getChildCount() - 1);
      this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine.addView(a(true, bool, d()), new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
    }
    label606:
    if ((n > i) && (n < j) && (this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine != null))
    {
      k = j - n;
      j = 0;
      if (j < k)
      {
        if (j == k - 1) {}
        for (localObject1 = a(this.jdField_b_of_type_Int, bool, d());; localObject1 = a(this.jdField_b_of_type_Int, bool, a()))
        {
          localObject2 = new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1);
          ((LinearLayout.LayoutParams)localObject2).gravity = 16;
          this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          if (j < k - 1) {
            QQCustomMenuNoIconLayout.MenuLine.a(this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine, bool);
          }
          j += 1;
          break;
        }
      }
    }
    if ((paramInt > 0) && (n < i) && (this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine != null))
    {
      QQCustomMenuNoIconLayout.MenuLine.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine, bool);
      this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine.addView(a(false, bool, g()), new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
    }
    addView(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine, new LinearLayout.LayoutParams(-2, this.c));
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine != null)
    {
      a(bool);
      addView(this.jdField_b_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout$MenuLine, new LinearLayout.LayoutParams(-2, this.c));
    }
    if (paramBoolean)
    {
      paramInt = this.jdField_b_of_type_Int;
      j = Math.min(n + 1, this.d);
      localObject1 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
      if (n < i) {
        break label910;
      }
    }
    label910:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((BubblePopupWindow)localObject1).a((paramInt + 1) * j - 1, paramBoolean, m);
      return;
    }
  }
  
  private void a(String paramString)
  {
    if (this.f < 0) {
      b();
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, this.f, 0, "", "", "", "");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.f < 0) {
      b();
    }
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString2);
    if (localInteger == null) {
      localInteger = Integer.valueOf(g);
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", paramString1, paramString1, localInteger.intValue(), 0, String.valueOf(this.f), "", "", "");
      if ((paramString2 != null) && (paramString2.equals(getContext().getResources().getString(2131699561))))
      {
        paramString2 = MobileReportManager.getInstance();
        if (!paramString1.equals("0X800B3BE")) {
          break label135;
        }
      }
      label135:
      for (int i = 101;; i = 102)
      {
        paramString2.reportAction("similar_emoji", "4", "platform898", "6", "2", i, 1, System.currentTimeMillis());
        return;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramBoolean)
    {
      i = 2131165816;
      localView.setBackgroundColor(localResources.getColor(i));
      addView(localView, new LinearLayout.LayoutParams(-1, 1));
      localView = new View(this.jdField_a_of_type_AndroidContentContext);
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (!paramBoolean) {
        break label114;
      }
    }
    label114:
    for (int i = 2131165815;; i = 2131165817)
    {
      localView.setBackgroundColor(localResources.getColor(i));
      addView(localView, new LinearLayout.LayoutParams(-1, 1));
      return;
      i = 2131165818;
      break;
    }
  }
  
  private float[] a()
  {
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  private void b()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof FragmentActivity))
    {
      localObject = (FragmentActivity)localObject;
      if (((FragmentActivity)localObject).getChatFragment() == null) {}
    }
    for (int i = ((FragmentActivity)localObject).getChatFragment().a().a.jdField_a_of_type_Int;; i = -1)
    {
      switch (Integer.parseInt(ChatActivityUtils.b(i)))
      {
      case 2: 
      default: 
        this.f = 4;
        return;
      case 0: 
        this.f = 1;
        return;
      case 3: 
        this.f = 2;
        return;
      }
      this.f = 3;
      return;
    }
  }
  
  private float[] b()
  {
    return new float[] { this.e, this.e, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  private float[] c()
  {
    return new float[] { 0.0F, 0.0F, this.e, this.e, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  private float[] d()
  {
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, this.e, this.e, 0.0F, 0.0F };
  }
  
  private float[] e()
  {
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, this.e, this.e };
  }
  
  private float[] f()
  {
    return new float[] { this.e, this.e, 0.0F, 0.0F, 0.0F, 0.0F, this.e, this.e };
  }
  
  private float[] g()
  {
    return new float[] { 0.0F, 0.0F, this.e, this.e, this.e, this.e, 0.0F, 0.0F };
  }
  
  private float[] h()
  {
    return new float[] { this.e, this.e, this.e, this.e, this.e, this.e, this.e, this.e };
  }
  
  int a(int paramInt)
  {
    int i = 0;
    if (paramInt > 0) {
      i = 0 + (this.d * 2 - 1) + (paramInt - 1) * (this.d * 2 - 2);
    }
    return i;
  }
  
  protected ImageView a(boolean paramBoolean1, boolean paramBoolean2, float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = a(paramBoolean2, paramArrayOfFloat);
    ImageView localImageView = new ImageView(getContext());
    int i;
    if (paramBoolean1)
    {
      i = 2130839062;
      localImageView.setImageResource(i);
      if (!paramBoolean1) {
        break label107;
      }
      i = 2131710164;
      label45:
      localImageView.setContentDescription(HardCodeUtil.a(i));
      localImageView.setBackgroundDrawable(paramArrayOfFloat);
      localImageView.setScaleType(ImageView.ScaleType.CENTER);
      localImageView.setOnClickListener(new QQCustomMenuNoIconLayout.2(this, paramBoolean1));
      if (!paramBoolean1) {
        break label115;
      }
    }
    label107:
    label115:
    for (paramArrayOfFloat = "0X800B3C0";; paramArrayOfFloat = "0X800B3C2")
    {
      a(paramArrayOfFloat);
      return localImageView;
      i = 2130839064;
      break;
      i = 2131710165;
      break label45;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomMenuNoIconLayout", 4, "[menu] setMenu MENU:" + this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.toString());
    }
  }
  
  public void setMenuIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setPopupWindow(BubblePopupWindow paramBubblePopupWindow)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = paramBubblePopupWindow;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$QQMenuNoIconEmptyInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout
 * JD-Core Version:    0.7.0.1
 */