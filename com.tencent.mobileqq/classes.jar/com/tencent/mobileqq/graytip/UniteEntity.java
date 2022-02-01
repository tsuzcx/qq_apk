package com.tencent.mobileqq.graytip;

public class UniteEntity
{
  UniteEntity.Note a;
  
  public UniteEntity(int paramInt)
  {
    this.a = new UniteEntity.Note(paramInt);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "graytip";
    case 2: 
      return "nor_text";
    case 3: 
      return "url";
    case 4: 
      return "qq";
    case 5: 
      return "img";
    case 6: 
      return "dialog";
    case 7: 
      return "title";
    case 8: 
      return "alter";
    case 9: 
      return "btn";
    }
    return "item";
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "align";
    case 2: 
      return "text";
    case 3: 
      return "size";
    case 4: 
      return "jump";
    case 5: 
      return "color";
    case 6: 
      return "uin";
    case 7: 
      return "name";
    case 8: 
      return "src";
    case 9: 
      return "type";
    }
    return "alt";
  }
  
  public UniteEntity.Note a()
  {
    return this.a;
  }
  
  public String toString()
  {
    return UniteEntity.Note.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteEntity
 * JD-Core Version:    0.7.0.1
 */