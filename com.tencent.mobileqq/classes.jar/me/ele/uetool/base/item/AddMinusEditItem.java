package me.ele.uetool.base.item;

import me.ele.uetool.base.Element;

public class AddMinusEditItem
  extends EditTextItem
{
  private AddMinusEditItem.CustomAddMin addMin = new AddMinusEditItem.1(this);
  
  public AddMinusEditItem(String paramString1, Element paramElement, int paramInt, String paramString2)
  {
    super(paramString1, paramElement, paramInt, paramString2);
  }
  
  public AddMinusEditItem.CustomAddMin getAddMin()
  {
    return this.addMin;
  }
  
  public void setAddMin(AddMinusEditItem.CustomAddMin paramCustomAddMin)
  {
    this.addMin = paramCustomAddMin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.base.item.AddMinusEditItem
 * JD-Core Version:    0.7.0.1
 */