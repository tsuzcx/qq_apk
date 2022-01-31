package com.tencent.plato;

import com.tencent.biz.qqstory.base.BaseEvent;

public class PlatoLoadEvent
  extends BaseEvent
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public static PlatoLoadEvent a(int paramInt)
  {
    PlatoLoadEvent localPlatoLoadEvent = new PlatoLoadEvent();
    localPlatoLoadEvent.jdField_a_of_type_Int = paramInt;
    localPlatoLoadEvent.jdField_b_of_type_Int = 0;
    return localPlatoLoadEvent;
  }
  
  public static PlatoLoadEvent a(int paramInt, String paramString1, String paramString2)
  {
    PlatoLoadEvent localPlatoLoadEvent = new PlatoLoadEvent();
    localPlatoLoadEvent.jdField_a_of_type_Int = paramInt;
    localPlatoLoadEvent.jdField_a_of_type_JavaLangString = paramString1;
    localPlatoLoadEvent.jdField_b_of_type_JavaLangString = paramString2;
    localPlatoLoadEvent.jdField_b_of_type_Int = 1;
    return localPlatoLoadEvent;
  }
  
  public String toString()
  {
    return "PlatoLoadEvent { bid=" + this.jdField_a_of_type_JavaLangString + ", code= " + this.jdField_a_of_type_Int + ", type=" + this.jdField_b_of_type_Int + ", path= " + this.jdField_b_of_type_JavaLangString + " }";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.plato.PlatoLoadEvent
 * JD-Core Version:    0.7.0.1
 */