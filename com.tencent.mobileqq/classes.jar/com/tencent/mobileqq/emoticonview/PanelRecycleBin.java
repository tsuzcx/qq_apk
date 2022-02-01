package com.tencent.mobileqq.emoticonview;

import android.view.View;
import java.util.ArrayList;

public class PanelRecycleBin
{
  private static final int DEFAULT_CAPACITY = 3;
  private ArrayList<View> mScrapViews = new ArrayList();
  
  public void addScrapView(View paramView)
  {
    if (this.mScrapViews.size() >= 3) {
      return;
    }
    this.mScrapViews.add(paramView);
  }
  
  public void clearScrapViews()
  {
    this.mScrapViews.clear();
  }
  
  public View getScrapView()
  {
    if (this.mScrapViews.size() > 0) {
      return (View)this.mScrapViews.remove(0);
    }
    return null;
  }
  
  public int getSize()
  {
    return this.mScrapViews.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PanelRecycleBin
 * JD-Core Version:    0.7.0.1
 */