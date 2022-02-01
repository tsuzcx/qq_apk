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
    case 11: 
      return "olstatus";
    case 10: 
      return "item";
    case 9: 
      return "btn";
    case 8: 
      return "alter";
    case 7: 
      return "title";
    case 6: 
      return "dialog";
    case 5: 
      return "img";
    case 4: 
      return "qq";
    case 3: 
      return "url";
    case 2: 
      return "nor_text";
    }
    return "graytip";
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 12: 
      return "ex_status";
    case 11: 
      return "status";
    case 10: 
      return "alt";
    case 9: 
      return "type";
    case 8: 
      return "src";
    case 7: 
      return "name";
    case 6: 
      return "uin";
    case 5: 
      return "color";
    case 4: 
      return "jump";
    case 3: 
      return "size";
    case 2: 
      return "text";
    }
    return "align";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteEntity
 * JD-Core Version:    0.7.0.1
 */