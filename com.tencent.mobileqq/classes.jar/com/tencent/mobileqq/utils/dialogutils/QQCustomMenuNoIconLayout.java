package com.tencent.mobileqq.utils.dialogutils;

import amtj;
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
import bcef;
import bgaz;
import bgbb;
import bgbc;
import bgbe;
import bgbf;
import bgbg;
import bgbh;
import bjpb;
import bjuk;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class QQCustomMenuNoIconLayout
  extends LinearLayout
{
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new QQCustomMenuNoIconLayout.4();
  private static int g = 100;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private bgaz jdField_a_of_type_Bgaz;
  private bgbh jdField_a_of_type_Bgbh;
  private bjpb jdField_a_of_type_Bjpb = new bgbe(this);
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private Integer jdField_a_of_type_JavaLangInteger;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private bgbh jdField_b_of_type_Bgbh;
  private int c;
  private int d = bgbc.jdField_a_of_type_Int;
  private int e = ViewUtils.dpToPx(8.0F);
  private int f = -1;
  
  public QQCustomMenuNoIconLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setOrientation(1);
    this.jdField_b_of_type_Int = AIOUtils.dp2px(62.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.c = AIOUtils.dp2px(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
      i = 2131165800;
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
    for (int i = 2131165801;; i = 2131165803)
    {
      ((GradientDrawable)localObject).setColor(localResources.getColor(i));
      ((GradientDrawable)localObject).setCornerRadii(paramArrayOfFloat);
      paramArrayOfFloat = new StateListDrawable();
      paramArrayOfFloat.setExitFadeDuration(400);
      paramArrayOfFloat.addState(new int[] { 16842919 }, (Drawable)localObject);
      paramArrayOfFloat.addState(new int[0], localGradientDrawable);
      return paramArrayOfFloat;
      i = 2131165802;
      break;
    }
  }
  
  private TextView a(int paramInt, boolean paramBoolean, float[] paramArrayOfFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramBoolean) {}
    for (int i = 2131165800;; i = 2131165802)
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
  
  private TextView a(bgbb parambgbb, boolean paramBoolean, float[] paramArrayOfFloat)
  {
    StateListDrawable localStateListDrawable = a(paramBoolean, paramArrayOfFloat);
    Object localObject = parambgbb.a();
    paramArrayOfFloat = (float[])localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      paramArrayOfFloat = (float[])localObject;
      if (((String)localObject).length() > 4) {
        paramArrayOfFloat = ((String)localObject).substring(0, 3) + "…";
      }
    }
    a("0X800B3BE", parambgbb.a());
    localObject = new TextView(getContext());
    ((TextView)localObject).setText(paramArrayOfFloat);
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setTextSize(12.0F);
    ((TextView)localObject).setMaxLines(1);
    ((TextView)localObject).setContentDescription(parambgbb.a());
    ((TextView)localObject).setId(parambgbb.a());
    ((TextView)localObject).setTextColor(-855638017);
    ((TextView)localObject).setBackgroundDrawable(localStateListDrawable);
    ((TextView)localObject).setIncludeFontPadding(true);
    ((TextView)localObject).setOnClickListener(new bgbg(this, parambgbb));
    ((TextView)localObject).setGravity(17);
    return localObject;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int m = getWidth();
    removeAllViews();
    boolean bool = bjuk.a();
    int n = this.jdField_a_of_type_Bgaz.a() - paramInt;
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
      localObject2 = this.jdField_a_of_type_Bgaz.a(k + paramInt);
      if (k != 0) {
        break label279;
      }
      if ((paramInt != 0) || (n != 1)) {
        break label255;
      }
      localObject1 = h();
      label135:
      localObject1 = a((bgbb)localObject2, bool, (float[])localObject1);
      label147:
      if (k >= i) {
        break label481;
      }
      if (this.jdField_a_of_type_Bgbh == null) {
        this.jdField_a_of_type_Bgbh = new bgbh(this, this.jdField_a_of_type_AndroidContentContext);
      }
      this.jdField_a_of_type_Bgbh.addView((View)localObject1, new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
      if (k >= i - 1) {
        break label412;
      }
      if (k != n - 1) {
        bgbh.a(this.jdField_a_of_type_Bgbh, bool);
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
          localObject1 = a((bgbb)localObject2, bool, (float[])localObject1);
          break;
        }
      }
      if (k == i)
      {
        localObject1 = a((bgbb)localObject2, bool, e());
        break label147;
      }
      if (k == j - 1)
      {
        localObject1 = a((bgbb)localObject2, bool, d());
        break label147;
      }
      localObject1 = a((bgbb)localObject2, bool, a());
      break label147;
      label412:
      if (paramInt > 0)
      {
        bgbh.a(this.jdField_a_of_type_Bgbh, bool);
        localObject2 = this.jdField_a_of_type_Bgbh;
        if (n <= i) {}
        for (localObject1 = g();; localObject1 = c())
        {
          ((bgbh)localObject2).addView(a(false, bool, (float[])localObject1), new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
          break;
        }
        label481:
        if (k >= j) {
          break label553;
        }
        if (this.jdField_b_of_type_Bgbh == null) {
          this.jdField_b_of_type_Bgbh = new bgbh(this, this.jdField_a_of_type_AndroidContentContext);
        }
        this.jdField_b_of_type_Bgbh.addView((View)localObject1, new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
        if (k < j - 1) {
          bgbh.a(this.jdField_b_of_type_Bgbh, bool);
        }
      }
    }
    label553:
    if (this.jdField_b_of_type_Bgbh != null)
    {
      this.jdField_b_of_type_Bgbh.removeViewAt(this.jdField_b_of_type_Bgbh.getChildCount() - 1);
      this.jdField_b_of_type_Bgbh.addView(a(true, bool, d()), new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
    }
    label606:
    if ((n > i) && (n < j) && (this.jdField_b_of_type_Bgbh != null))
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
          this.jdField_b_of_type_Bgbh.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          if (j < k - 1) {
            bgbh.a(this.jdField_b_of_type_Bgbh, bool);
          }
          j += 1;
          break;
        }
      }
    }
    if ((paramInt > 0) && (n < i))
    {
      bgbh.a(this.jdField_a_of_type_Bgbh, bool);
      this.jdField_a_of_type_Bgbh.addView(a(false, bool, g()), new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, -1));
    }
    addView(this.jdField_a_of_type_Bgbh, new LinearLayout.LayoutParams(-2, this.c));
    if (this.jdField_b_of_type_Bgbh != null)
    {
      a(bool);
      addView(this.jdField_b_of_type_Bgbh, new LinearLayout.LayoutParams(-2, this.c));
    }
    if (paramBoolean)
    {
      paramInt = this.jdField_b_of_type_Int;
      j = Math.min(n + 1, this.d);
      localObject1 = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
      if (n < i) {
        break label903;
      }
    }
    label903:
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
    bcef.b(null, "dc00898", "", "", paramString, paramString, this.f, 0, "", "", "", "");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.f < 0) {
      b();
    }
    paramString2 = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString2);
    if (paramString2 == null) {
      paramString2 = Integer.valueOf(g);
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", paramString1, paramString1, paramString2.intValue(), 0, String.valueOf(this.f), "", "", "");
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramBoolean)
    {
      i = 2131165805;
      localView.setBackgroundColor(localResources.getColor(i));
      addView(localView, new LinearLayout.LayoutParams(-1, 1));
      localView = new View(this.jdField_a_of_type_AndroidContentContext);
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (!paramBoolean) {
        break label114;
      }
    }
    label114:
    for (int i = 2131165804;; i = 2131165806)
    {
      localView.setBackgroundColor(localResources.getColor(i));
      addView(localView, new LinearLayout.LayoutParams(-1, 1));
      return;
      i = 2131165807;
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
    for (int i = ((FragmentActivity)localObject).getChatFragment().a().sessionInfo.curType;; i = -1)
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
  
  public int a(int paramInt)
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
      i = 2130838974;
      localImageView.setImageResource(i);
      if (!paramBoolean1) {
        break label107;
      }
      i = 2131709301;
      label45:
      localImageView.setContentDescription(amtj.a(i));
      localImageView.setBackgroundDrawable(paramArrayOfFloat);
      localImageView.setScaleType(ImageView.ScaleType.CENTER);
      localImageView.setOnClickListener(new bgbf(this, paramBoolean1));
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
      i = 2130838976;
      break;
      i = 2131709302;
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
    return this.jdField_a_of_type_Bgaz.a() >= this.d;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void removeAllViews()
  {
    super.removeAllViews();
    this.jdField_a_of_type_Bgbh = null;
    this.jdField_b_of_type_Bgbh = null;
  }
  
  public void setContainerBottom(Integer paramInteger)
  {
    this.jdField_a_of_type_JavaLangInteger = paramInteger;
  }
  
  public void setIgnoreTouchLocation(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setMenu(bgaz parambgaz)
  {
    this.jdField_a_of_type_Bgaz = parambgaz.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomMenuNoIconLayout", 4, "[menu] setMenu MENU:" + this.jdField_a_of_type_Bgaz.toString());
    }
  }
  
  public void setMenuIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setPopupWindow(BubblePopupWindow paramBubblePopupWindow)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = paramBubblePopupWindow;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_Bjpb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout
 * JD-Core Version:    0.7.0.1
 */