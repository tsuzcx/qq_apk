package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.kandian.base.view.api.IFontSizePanel;
import com.tencent.widget.RangeButtonView.Title;
import java.util.ArrayList;
import java.util.List;

public class FontSizePanel
  implements IFontSizePanel
{
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private List<RangeButtonView.Title> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private List<Float> b = new ArrayList();
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_Boolean) && (this.b.isEmpty()))
    {
      this.b.add(Float.valueOf(0.941F));
      this.b.add(Float.valueOf(1.0F));
      this.b.add(Float.valueOf(1.118F));
      this.b.add(Float.valueOf(1.235F));
      this.b.add(Float.valueOf(1.353F));
    }
  }
  
  private float b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return ((Float)this.b.get(paramInt)).floatValue();
    }
    return 1.0F;
  }
  
  public float a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return b(paramInt);
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt < localList.size())) {
      return ((RangeButtonView.Title)this.jdField_a_of_type_JavaUtilList.get(paramInt)).getTextSize();
    }
    return 0.0F;
  }
  
  public FontSizePanel a(View paramView)
  {
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.showAtLocation(paramView, 83, 0, 0);
    }
    return this;
  }
  
  public void a()
  {
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null)
    {
      localPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
  }
  
  public boolean a()
  {
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    return (localPopupWindow != null) && (localPopupWindow.isShowing());
  }
  
  public void b()
  {
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.FontSizePanel
 * JD-Core Version:    0.7.0.1
 */