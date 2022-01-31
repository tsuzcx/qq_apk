package com.tencent.qqmini.sdk.minigame.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bgho;
import bgws;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.LiuHaiUtils;

public class GameNavigationBar
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = -16777216;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private CapsuleButton jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int b = -1;
  
  public GameNavigationBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GameNavigationBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GameNavigationBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton.a(this.b);
    }
  }
  
  private void c()
  {
    if ("custom".equals(this.jdField_a_of_type_JavaLangString)) {
      a(0);
    }
  }
  
  private void d()
  {
    int i = 0;
    if ((getContext() != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
      localObject = new ViewGroup.LayoutParams(-1, -2);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClipChildren(false);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton = new CapsuleButton(getContext());
      this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton.setId(2131364766);
      localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 80.0F), DisplayUtil.dip2px(getContext(), 30.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      j = DisplayUtil.dip2px(getContext(), 9.0F);
      if (LiuHaiUtils.isLiuHaiUseValid()) {
        i = DisplayUtil.getStatusBarHeight(getContext());
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (i + j);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(getContext(), 12.5F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton, (ViewGroup.LayoutParams)localObject);
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_Int);
      b();
      this.jdField_a_of_type_Boolean = true;
    }
    while (!QMLog.isColorLevel())
    {
      Object localObject;
      int j;
      return;
    }
    QMLog.d("GameNavigationBar", "[init] context null");
  }
  
  public CapsuleButton a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton;
  }
  
  public GameNavigationBar a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_Int);
    }
    return this;
  }
  
  public GameNavigationBar a(WindowInfo paramWindowInfo)
  {
    if (paramWindowInfo != null)
    {
      paramWindowInfo = paramWindowInfo.navigationBarInfo;
      if (paramWindowInfo != null)
      {
        if (!TextUtils.isEmpty(paramWindowInfo.textStyle)) {
          a(paramWindowInfo.textStyle);
        }
        a(paramWindowInfo.backgoundColor);
        if (!TextUtils.isEmpty(paramWindowInfo.style)) {
          b(paramWindowInfo.style);
        }
      }
    }
    return this;
  }
  
  public GameNavigationBar a(String paramString)
  {
    if ("black".equals(paramString)) {
      this.b = -16777216;
    }
    for (;;)
    {
      b();
      return this;
      if ("white".equals(paramString)) {
        this.b = -1;
      }
    }
  }
  
  public void a()
  {
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton.getLayoutParams()).topMargin = DisplayUtil.dip2px(getContext(), 9.0F);
  }
  
  public void a(bgho parambgho)
  {
    parambgho = new bgws(parambgho);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetCapsuleButton.a(parambgho);
  }
  
  public GameNavigationBar b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    c();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.widget.GameNavigationBar
 * JD-Core Version:    0.7.0.1
 */