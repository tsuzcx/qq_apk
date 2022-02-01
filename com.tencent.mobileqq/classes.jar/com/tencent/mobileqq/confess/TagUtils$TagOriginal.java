package com.tencent.mobileqq.confess;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TagUtils$TagOriginal
{
  public float a;
  public int a;
  public String a;
  public ArrayList<Pair<String, Float>> a;
  Set<Integer> a;
  public boolean a;
  public int b = 0;
  public int c = 36;
  
  public TagUtils$TagOriginal(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = TagUtils.a(paramString, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Float = TagUtils.a(paramString);
    this.b = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.c = a(this.b);
    this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(this.b));
      if (this.b % 2 != 0) {
        break label192;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(2));
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(this.b / 2));
      }
      return;
      label192:
      i = 0;
    }
  }
  
  private int a(int paramInt)
  {
    if (paramInt <= 2) {
      paramInt = TagUtils.a.nextInt(8) - 4 + 74;
    }
    for (;;)
    {
      return paramInt / 4 * 4;
      if (paramInt <= 4) {
        paramInt = TagUtils.a.nextInt(8) - 4 + 70;
      } else if (paramInt <= 6) {
        paramInt = TagUtils.a.nextInt(8) - 4 + 66;
      } else if (paramInt <= 8) {
        paramInt = TagUtils.a.nextInt(8) - 4 + 62;
      } else {
        paramInt = TagUtils.a.nextInt(8) - 4 + 60;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (this.b % 3 != 0) {
        break label56;
      }
    }
    label56:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(3));
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(this.b / 3));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TagUtils.TagOriginal
 * JD-Core Version:    0.7.0.1
 */