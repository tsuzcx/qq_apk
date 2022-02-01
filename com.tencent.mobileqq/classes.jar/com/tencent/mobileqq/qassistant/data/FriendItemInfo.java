package com.tencent.mobileqq.qassistant.data;

public class FriendItemInfo
{
  public String a;
  public String b;
  public int c;
  public boolean d;
  public int e;
  public String f;
  public long g;
  public float h;
  public float i;
  public float j;
  public float k;
  public float l;
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return "";
            }
            return "\"第五个\"";
          }
          return "\"第四个\"";
        }
        return "\"第三个\"";
      }
      return "\"第二个\"";
    }
    return "\"第一个\"";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.data.FriendItemInfo
 * JD-Core Version:    0.7.0.1
 */