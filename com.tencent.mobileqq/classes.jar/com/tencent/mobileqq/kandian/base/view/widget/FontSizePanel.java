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
  private PopupWindow a;
  private List<RangeButtonView.Title> b;
  private boolean c = false;
  private List<Float> d = new ArrayList();
  
  private void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if ((this.c) && (this.d.isEmpty()))
    {
      this.d.add(Float.valueOf(0.941F));
      this.d.add(Float.valueOf(1.0F));
      this.d.add(Float.valueOf(1.118F));
      this.d.add(Float.valueOf(1.235F));
      this.d.add(Float.valueOf(1.353F));
    }
  }
  
  private float b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.d.size())) {
      return ((Float)this.d.get(paramInt)).floatValue();
    }
    return 1.0F;
  }
  
  public float a(int paramInt)
  {
    if (this.c) {
      return b(paramInt);
    }
    List localList = this.b;
    if ((localList != null) && (paramInt < localList.size())) {
      return ((RangeButtonView.Title)this.b.get(paramInt)).getTextSize();
    }
    return 0.0F;
  }
  
  public void a()
  {
    PopupWindow localPopupWindow = this.a;
    if (localPopupWindow != null)
    {
      localPopupWindow.dismiss();
      this.a = null;
    }
  }
  
  public FontSizePanel b(View paramView)
  {
    PopupWindow localPopupWindow = this.a;
    if (localPopupWindow != null) {
      localPopupWindow.showAtLocation(paramView, 83, 0, 0);
    }
    return this;
  }
  
  public boolean b()
  {
    PopupWindow localPopupWindow = this.a;
    return (localPopupWindow != null) && (localPopupWindow.isShowing());
  }
  
  public void c()
  {
    PopupWindow localPopupWindow = this.a;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.FontSizePanel
 * JD-Core Version:    0.7.0.1
 */