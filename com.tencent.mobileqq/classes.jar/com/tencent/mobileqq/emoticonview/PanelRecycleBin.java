package com.tencent.mobileqq.emoticonview;

import android.view.View;
import java.util.ArrayList;

public class PanelRecycleBin
{
  private ArrayList a = new ArrayList();
  
  public View a()
  {
    if (this.a.size() > 0) {
      return (View)this.a.remove(0);
    }
    return null;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(View paramView)
  {
    if (this.a.size() >= 3) {
      return;
    }
    this.a.add(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PanelRecycleBin
 * JD-Core Version:    0.7.0.1
 */