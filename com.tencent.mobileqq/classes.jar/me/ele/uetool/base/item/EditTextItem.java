package me.ele.uetool.base.item;

import me.ele.uetool.base.Element;

public class EditTextItem
  extends ElementItem
{
  private String detail;
  private int type;
  
  public EditTextItem(String paramString1, Element paramElement, int paramInt, String paramString2)
  {
    super(paramString1, paramElement);
    this.type = paramInt;
    this.detail = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof EditTextItem))
    {
      paramObject = (EditTextItem)paramObject;
      bool1 = bool2;
      if (getName().equals(paramObject.getName()))
      {
        bool1 = bool2;
        if (paramObject.getDetail().equals(getDetail())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String getDetail()
  {
    return this.detail;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return this.detail.hashCode() | getName().hashCode();
  }
  
  public void setDetail(String paramString)
  {
    this.detail = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.base.item.EditTextItem
 * JD-Core Version:    0.7.0.1
 */