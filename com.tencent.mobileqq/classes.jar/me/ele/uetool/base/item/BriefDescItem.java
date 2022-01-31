package me.ele.uetool.base.item;

import me.ele.uetool.base.Element;

public class BriefDescItem
  extends ElementItem
{
  private boolean isSelected;
  
  public BriefDescItem(Element paramElement)
  {
    this(paramElement, false);
  }
  
  public BriefDescItem(Element paramElement, boolean paramBoolean)
  {
    super("", paramElement);
    this.isSelected = paramBoolean;
  }
  
  public boolean isSelected()
  {
    return this.isSelected;
  }
  
  public boolean isValid()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.base.item.BriefDescItem
 * JD-Core Version:    0.7.0.1
 */