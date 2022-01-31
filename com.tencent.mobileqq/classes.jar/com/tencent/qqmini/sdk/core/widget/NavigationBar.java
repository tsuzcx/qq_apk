package com.tencent.qqmini.sdk.core.widget;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bemm;
import beri;
import besa;
import bffu;

public class NavigationBar
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -16777216;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bemm jdField_a_of_type_Bemm;
  private beri jdField_a_of_type_Beri;
  private CapsuleButton jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton;
  private WebViewProgressBar jdField_a_of_type_ComTencentQqminiSdkCoreWidgetWebViewProgressBar;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
  public NavigationBar(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public static int a(Context paramContext)
  {
    return bffu.a(paramContext, 44.0F) + bffu.d(paramContext);
  }
  
  private void c()
  {
    if (getContext() != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClipChildren(false);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton = new CapsuleButton(getContext());
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton.setId(2131370284);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(bffu.a(getContext(), 80.0F), bffu.a(getContext(), 30.0F));
      localLayoutParams.addRule(11, -1);
      localLayoutParams.topMargin = bffu.a(getContext(), 9.0F);
      localLayoutParams.rightMargin = bffu.a(getContext(), 12.5F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton, localLayoutParams);
      this.jdField_a_of_type_AndroidViewView = new View(getContext());
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165745);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, bffu.d(getContext()));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      addView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370297));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370296));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370288));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370283));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131370287));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      }
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetWebViewProgressBar = ((WebViewProgressBar)findViewById(2131370285));
      this.jdField_b_of_type_AndroidViewView = findViewById(2131370286);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840745);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(15);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 18.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_Int);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetWebViewProgressBar.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if (!this.jdField_a_of_type_Boolean) {
        break label532;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 18.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.c);
      if (!this.jdField_b_of_type_Boolean) {
        break label544;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      e();
      return;
      label532:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label544:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  private void d()
  {
    if ("custom".equals(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      a(0);
    }
    do
    {
      return;
      setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    } while (this.jdField_a_of_type_Beri == null);
    a(this.jdField_a_of_type_Beri.jdField_a_of_type_Int);
    b(this.jdField_a_of_type_Beri.jdField_a_of_type_JavaLangString);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Int == -1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840815);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton != null) {
        this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton.a(this.jdField_b_of_type_Int);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840814);
    }
  }
  
  public RelativeLayout a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = new ViewGroup.LayoutParams(-1, -2);
    localRelativeLayout.setPadding(0, bffu.d(getContext()), 0, 0);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(getContext());
    ((RelativeLayout)localObject1).setId(2131370282);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, bffu.a(getContext(), 30.0F));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = bffu.a(getContext(), 9.0F);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = bffu.a(getContext(), 7.0F);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new RelativeLayout(getContext());
    ((RelativeLayout)localObject2).setId(2131370297);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-2, -1));
    Object localObject3 = new ImageView(getContext());
    ((ImageView)localObject3).setId(2131370296);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(bffu.a(getContext(), 12.0F), bffu.a(getContext(), 21.5F));
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = bffu.a(getContext(), 16.0F);
    localLayoutParams.rightMargin = bffu.a(getContext(), 8.0F);
    ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((RelativeLayout)localObject2).addView((View)localObject3, localLayoutParams);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setId(2131370283);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131370297);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((TextView)localObject2).setGravity(15);
    ((TextView)localObject2).setMaxEms(5);
    ((TextView)localObject2).setTextSize(1, 17.0F);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new TextView(getContext());
    ((TextView)localObject2).setId(2131370288);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine(true);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setMaxEms(8);
    ((TextView)localObject2).setTextSize(1, 17.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new ProgressBar(getContext());
    ((ProgressBar)localObject2).setId(2131370287);
    localObject3 = new RelativeLayout.LayoutParams(bffu.a(getContext(), 19.0F), bffu.a(getContext(), 19.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131370288);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = bffu.a(getContext(), 2.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(2131370286);
    localObject2 = new RelativeLayout.LayoutParams(-1, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131370282);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = bffu.a(getContext(), 5.0F);
    ((View)localObject1).setBackgroundColor(0);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new WebViewProgressBar(getContext());
    ((WebViewProgressBar)localObject1).setId(2131370285);
    localObject2 = new RelativeLayout.LayoutParams(-1, bffu.a(getContext(), 2.0F));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = bffu.a(getContext(), -2.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131370282);
    ((WebViewProgressBar)localObject1).setBackgroundColor(getContext().getResources().getColor(2131165744));
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public CapsuleButton a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton;
  }
  
  public NavigationBar a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if ("custom".equals(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      }
    }
    else {
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_Int);
    return this;
  }
  
  public NavigationBar a(int paramInt, long paramLong, String paramString)
  {
    ObjectAnimator localObjectAnimator;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "backgroundColor", new int[] { this.jdField_a_of_type_Int, paramInt });
      localObjectAnimator.setDuration(paramLong);
      localObjectAnimator.setEvaluator(new ArgbEvaluator());
      if (!"linear".equals(paramString)) {
        break label87;
      }
      localObjectAnimator.setInterpolator(new LinearInterpolator());
    }
    for (;;)
    {
      localObjectAnimator.start();
      this.jdField_a_of_type_Int = paramInt;
      return this;
      label87:
      if ("easeIn".equals(paramString))
      {
        if (Build.VERSION.SDK_INT >= 21) {
          localObjectAnimator.setInterpolator(new PathInterpolator(0.42F, 0.0F, 1.0F, 1.0F));
        }
      }
      else if ("easeOut".equals(paramString))
      {
        if (Build.VERSION.SDK_INT >= 21) {
          localObjectAnimator.setInterpolator(new PathInterpolator(0.0F, 0.0F, 0.58F, 1.0F));
        }
      }
      else if (("easeInOut".equals(paramString)) && (Build.VERSION.SDK_INT >= 21)) {
        localObjectAnimator.setInterpolator(new PathInterpolator(0.42F, 0.0F, 0.58F, 1.0F));
      }
    }
  }
  
  public NavigationBar a(bemm parambemm)
  {
    this.jdField_a_of_type_Bemm = parambemm;
    return this;
  }
  
  public NavigationBar a(besa parambesa, Activity paramActivity)
  {
    boolean bool2 = false;
    if (parambesa != null)
    {
      this.jdField_a_of_type_Beri = parambesa.jdField_a_of_type_Beri;
      if (this.jdField_a_of_type_Beri == null) {
        break label147;
      }
      c(this.jdField_a_of_type_Beri.jdField_b_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Beri.jdField_a_of_type_JavaLangString)) {
        b(this.jdField_a_of_type_Beri.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Beri.jdField_a_of_type_Int;
      a(this.jdField_a_of_type_Beri.jdField_a_of_type_Int);
      b();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Beri.c)) {
        a(this.jdField_a_of_type_Beri.c);
      }
    }
    label147:
    for (boolean bool1 = "black".equals(this.jdField_a_of_type_Beri.jdField_a_of_type_JavaLangString);; bool1 = false)
    {
      if (paramActivity != null) {
        bool2 = bffu.a(bool1, paramActivity.getWindow());
      }
      setUseCustomStatusBarStyle(bool2);
      return this;
    }
  }
  
  public NavigationBar a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
    return this;
  }
  
  public NavigationBar a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if ((paramBoolean) && ("default".equals(this.jdField_a_of_type_JavaLangString)))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        localLayoutParams.leftMargin = 0;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    else {
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    return this;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  public NavigationBar b(String paramString)
  {
    if ("black".equals(paramString)) {
      this.jdField_b_of_type_Int = -16777216;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
      }
      e();
      return this;
      if ("white".equals(paramString)) {
        this.jdField_b_of_type_Int = -1;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    }
  }
  
  public NavigationBar c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    }
    return this;
  }
  
  public void onClick(View paramView)
  {
    if (((paramView.getId() == 2131370296) || (paramView.getId() == 2131370297)) && (this.jdField_a_of_type_Bemm != null)) {
      this.jdField_a_of_type_Bemm.a(this);
    }
  }
  
  public void setUseCustomStatusBarStyle(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (!paramBoolean) {
        break label69;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, bffu.d(getContext()), 0, 0);
    }
    for (localLayoutParams.topMargin = 0;; localLayoutParams.topMargin = bffu.d(getContext()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      return;
      label69:
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.NavigationBar
 * JD-Core Version:    0.7.0.1
 */