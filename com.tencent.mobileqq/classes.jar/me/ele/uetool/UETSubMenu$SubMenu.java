package me.ele.uetool;

import android.view.View.OnClickListener;

public class UETSubMenu$SubMenu
{
  private int chosenImageRes;
  private int imageRes;
  private View.OnClickListener onClickListener;
  private String title;
  
  public UETSubMenu$SubMenu(String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    this.title = paramString;
    this.imageRes = paramInt1;
    this.chosenImageRes = paramInt2;
    this.onClickListener = paramOnClickListener;
  }
  
  public int getChosenImageRes()
  {
    return this.chosenImageRes;
  }
  
  public int getImageRes()
  {
    return this.imageRes;
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return this.onClickListener;
  }
  
  public String getTitle()
  {
    return this.title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.UETSubMenu.SubMenu
 * JD-Core Version:    0.7.0.1
 */