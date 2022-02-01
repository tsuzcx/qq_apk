package com.tencent.mobileqq.hiboom;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class RichTextPanel$2
  extends PagerAdapter
{
  RichTextPanel$2(RichTextPanel paramRichTextPanel) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return RichTextPanel.a(this.a).size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTextPanel", 2, "instantiateItem position = " + paramInt);
    }
    ViewParent localViewParent = ((RichTextPanelView)RichTextPanel.a(this.a).get(paramInt)).getParent();
    if (localViewParent != null) {
      ((ViewGroup)localViewParent).removeView((View)RichTextPanel.a(this.a).get(paramInt));
    }
    paramViewGroup.addView((View)RichTextPanel.a(this.a).get(paramInt));
    return RichTextPanel.a(this.a).get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanel.2
 * JD-Core Version:    0.7.0.1
 */