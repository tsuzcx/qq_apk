package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

public class ComponentWhiteSpace
  extends ComponentDivider
{
  public ComponentWhiteSpace(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentWhiteSpace(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentWhiteSpace(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ComponentWhiteSpace(Context paramContext, Object paramObject)
  {
    super(paramContext, paramObject);
  }
  
  public void a(Context paramContext)
  {
    setBackgroundResource(2131167849);
  }
  
  public void b()
  {
    Object localObject = this.a.a;
    localObject = new ViewGroup.LayoutParams(-1, -2);
    ((ViewGroup.LayoutParams)localObject).height = Utils.dp2px(10.0D);
    setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentWhiteSpace
 * JD-Core Version:    0.7.0.1
 */