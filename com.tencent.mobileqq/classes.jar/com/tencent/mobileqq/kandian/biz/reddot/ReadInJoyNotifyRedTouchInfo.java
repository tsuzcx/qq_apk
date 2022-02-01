package com.tencent.mobileqq.kandian.biz.reddot;

public class ReadInJoyNotifyRedTouchInfo
{
  public static final String a = Long.toString(1130L);
  public int b = 0;
  public String c = "";
  public int d = 0;
  public int e = 0;
  public int f = 0;
  
  public int a()
  {
    if (this.b != 1) {
      return 0;
    }
    return this.d;
  }
  
  public int a(ReadInJoyNotifyRedTouchInfo paramReadInJoyNotifyRedTouchInfo)
  {
    ReadInJoyNotifyRedTouchInfo localReadInJoyNotifyRedTouchInfo1;
    ReadInJoyNotifyRedTouchInfo localReadInJoyNotifyRedTouchInfo2;
    if (this.b > paramReadInJoyNotifyRedTouchInfo.b)
    {
      localReadInJoyNotifyRedTouchInfo1 = this;
      localReadInJoyNotifyRedTouchInfo2 = paramReadInJoyNotifyRedTouchInfo;
    }
    else
    {
      localReadInJoyNotifyRedTouchInfo2 = this;
      localReadInJoyNotifyRedTouchInfo1 = paramReadInJoyNotifyRedTouchInfo;
    }
    int i = localReadInJoyNotifyRedTouchInfo2.b;
    int m = 0;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2 ? i != 3 ? (i == 4) || ((localReadInJoyNotifyRedTouchInfo1.b != 4) && (!localReadInJoyNotifyRedTouchInfo2.c.equals(localReadInJoyNotifyRedTouchInfo1.c))) : (localReadInJoyNotifyRedTouchInfo1.b != 3) && (localReadInJoyNotifyRedTouchInfo2.e != localReadInJoyNotifyRedTouchInfo1.e) : (localReadInJoyNotifyRedTouchInfo1.b == 2) && (localReadInJoyNotifyRedTouchInfo2.c.equals(localReadInJoyNotifyRedTouchInfo1.c))) {
          break label186;
        }
        i = 1;
        break label188;
      }
      if (localReadInJoyNotifyRedTouchInfo1.b == 1) {
        if (localReadInJoyNotifyRedTouchInfo2.d == localReadInJoyNotifyRedTouchInfo1.d) {
          break label186;
        }
      }
    }
    else
    {
      if (localReadInJoyNotifyRedTouchInfo1.b == 0) {
        break label186;
      }
    }
    int k = 1;
    int j = 1;
    break label193;
    label186:
    i = 0;
    label188:
    j = 0;
    k = i;
    label193:
    i = m;
    if (k != 0) {
      i = 1;
    }
    k = i;
    if (j != 0) {
      k = i | 0x2;
    }
    return k;
  }
  
  public boolean b()
  {
    int i = this.b;
    if (i != 0)
    {
      if (i != 1) {}
      while (this.d > 0) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyNotifyRedTouchInfo
 * JD-Core Version:    0.7.0.1
 */