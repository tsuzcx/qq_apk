package com.tencent.mobileqq.utils;

public class VipUtils$VipIconUtils$NamePlateVipTpye
{
  static final NamePlateVipTpye jdField_a_of_type_ComTencentMobileqqUtilsVipUtils$VipIconUtils$NamePlateVipTpye = new NamePlateVipTpye(0);
  static final NamePlateVipTpye b = new NamePlateVipTpye(1);
  static final NamePlateVipTpye c = new NamePlateVipTpye(257);
  static final NamePlateVipTpye d = new NamePlateVipTpye(2);
  static final NamePlateVipTpye e = new NamePlateVipTpye(258);
  static final NamePlateVipTpye f = new NamePlateVipTpye(3);
  static final NamePlateVipTpye g = new NamePlateVipTpye(259);
  final int jdField_a_of_type_Int;
  
  public VipUtils$VipIconUtils$NamePlateVipTpye(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static NamePlateVipTpye a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return jdField_a_of_type_ComTencentMobileqqUtilsVipUtils$VipIconUtils$NamePlateVipTpye;
    case 1: 
      return b;
    case 2: 
      return d;
    case 3: 
      return f;
    case 257: 
      return c;
    case 258: 
      return e;
    }
    return g;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int & 0xF) == 1;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int & 0xF) == 3;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int > 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.VipIconUtils.NamePlateVipTpye
 * JD-Core Version:    0.7.0.1
 */