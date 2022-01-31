package me.ele.uetool.base.item;

public class TitleItem
  extends Item
{
  private String name;
  
  public TitleItem(String paramString)
  {
    this.name = paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return getName().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.base.item.TitleItem
 * JD-Core Version:    0.7.0.1
 */