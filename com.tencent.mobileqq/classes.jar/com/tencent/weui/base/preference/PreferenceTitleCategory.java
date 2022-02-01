package com.tencent.weui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class PreferenceTitleCategory
  extends a
{
  public PreferenceTitleCategory(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PreferenceTitleCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreferenceTitleCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (getLayoutResource() != 2131625455) {
      setLayoutResource(2131625453);
    }
  }
  
  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
    paramView = (TextView)paramView.findViewById(16908310);
    if (paramView == null) {
      return;
    }
    if ((getTitle() != null) && (getTitle().length() > 0))
    {
      paramView.setVisibility(0);
      paramView.setText(getTitle());
      return;
    }
    paramView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weui.base.preference.PreferenceTitleCategory
 * JD-Core Version:    0.7.0.1
 */