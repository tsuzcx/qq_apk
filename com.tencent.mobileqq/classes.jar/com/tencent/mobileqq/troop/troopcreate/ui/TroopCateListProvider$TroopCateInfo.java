package com.tencent.mobileqq.troop.troopcreate.ui;

import java.util.ArrayList;
import java.util.HashMap;

public class TroopCateListProvider$TroopCateInfo
{
  public int a;
  public String a;
  public ArrayList<TroopCateInfo> a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public TroopCateListProvider$TroopCateInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  public TroopCateListProvider$TroopCateInfo(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = ((Integer)TroopCateListProvider.a().get(paramString)).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.TroopCateListProvider.TroopCateInfo
 * JD-Core Version:    0.7.0.1
 */