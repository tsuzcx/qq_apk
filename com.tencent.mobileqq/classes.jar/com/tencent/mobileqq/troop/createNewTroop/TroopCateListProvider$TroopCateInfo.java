package com.tencent.mobileqq.troop.createNewTroop;

import java.util.ArrayList;
import java.util.HashMap;

public class TroopCateListProvider$TroopCateInfo
{
  public int a;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public TroopCateListProvider$TroopCateInfo() {}
  
  public TroopCateListProvider$TroopCateInfo(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = ((Integer)TroopCateListProvider.a().get(paramString)).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.TroopCateListProvider.TroopCateInfo
 * JD-Core Version:    0.7.0.1
 */