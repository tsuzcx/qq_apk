package me.ele.uetool.base.item;

import me.ele.uetool.base.Element;

public class ElementItem
  extends TitleItem
{
  private ElementItem.ChangeCallBack callBack;
  private Element element;
  
  public ElementItem(String paramString, Element paramElement)
  {
    super(paramString);
    this.element = paramElement;
  }
  
  public ElementItem.ChangeCallBack getCallBack()
  {
    return this.callBack;
  }
  
  public Element getElement()
  {
    return this.element;
  }
  
  public void setCallBack(ElementItem.ChangeCallBack paramChangeCallBack)
  {
    this.callBack = paramChangeCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.base.item.ElementItem
 * JD-Core Version:    0.7.0.1
 */