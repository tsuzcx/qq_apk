package com.tencent.mobileqq.winkpublish.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.widget.Switch;

public class FSSwitch
  extends Switch
{
  View.OnClickListener a;
  boolean b = true;
  
  public FSSwitch(Context paramContext)
  {
    super(paramContext);
  }
  
  public FSSwitch(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FSSwitch(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.b)
    {
      super.setChecked(paramBoolean);
      return;
    }
    View.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this);
    }
  }
  
  public void setCityRecommendationCheck(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setCityRecommendationCheckClick(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
  
  public void setSwitchChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.view.FSSwitch
 * JD-Core Version:    0.7.0.1
 */