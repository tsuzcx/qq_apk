package com.tencent.mobileqq.utils;

public class VipUtils$VipIconUtils$NamePlateVipTpye
{
  static final NamePlateVipTpye b = new NamePlateVipTpye(0);
  static final NamePlateVipTpye c = new NamePlateVipTpye(1);
  static final NamePlateVipTpye d = new NamePlateVipTpye(257);
  static final NamePlateVipTpye e = new NamePlateVipTpye(2);
  static final NamePlateVipTpye f = new NamePlateVipTpye(258);
  static final NamePlateVipTpye g = new NamePlateVipTpye(3);
  static final NamePlateVipTpye h = new NamePlateVipTpye(259);
  final int a;
  
  public VipUtils$VipIconUtils$NamePlateVipTpye(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static NamePlateVipTpye a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          switch (paramInt)
          {
          default: 
            return b;
          case 259: 
            return h;
          case 258: 
            return f;
          }
          return d;
        }
        return g;
      }
      return e;
    }
    return c;
  }
  
  public boolean a()
  {
    return (this.a & 0xF) == 1;
  }
  
  public boolean b()
  {
    return (this.a & 0xF) == 3;
  }
  
  public boolean c()
  {
    return this.a > 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.VipIconUtils.NamePlateVipTpye
 * JD-Core Version:    0.7.0.1
 */