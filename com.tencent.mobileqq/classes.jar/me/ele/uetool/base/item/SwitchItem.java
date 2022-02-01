package me.ele.uetool.base.item;

import me.ele.uetool.base.Element;

public class SwitchItem
  extends ElementItem
{
  private boolean isChecked;
  private int type;
  
  public SwitchItem(String paramString, Element paramElement, int paramInt)
  {
    super(paramString, paramElement);
    this.type = paramInt;
  }
  
  public SwitchItem(String paramString, Element paramElement, int paramInt, boolean paramBoolean)
  {
    super(paramString, paramElement);
    this.type = paramInt;
    this.isChecked = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof SwitchItem)) {
      return (this.isChecked == ((SwitchItem)paramObject).isChecked) && (getName().equals(((SwitchItem)paramObject).getName()));
    }
    return false;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    int j = getName().hashCode();
    if (this.isChecked) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.base.item.SwitchItem
 * JD-Core Version:    0.7.0.1
 */