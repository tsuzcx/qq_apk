package com.tencent.mobileqq.confess;

import java.util.ArrayList;
import java.util.Comparator;

class TagUtils$TagArrangementEngine$4
  implements Comparator<TagUtils.TagOriginal>
{
  TagUtils$TagArrangementEngine$4(TagUtils.TagArrangementEngine paramTagArrangementEngine, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public int a(TagUtils.TagOriginal paramTagOriginal1, TagUtils.TagOriginal paramTagOriginal2)
  {
    int j = paramTagOriginal1.jdField_a_of_type_Int;
    int k = paramTagOriginal2.jdField_a_of_type_Int;
    int i = 1;
    if (j > k) {
      return 1;
    }
    if (paramTagOriginal1.jdField_a_of_type_Int < paramTagOriginal2.jdField_a_of_type_Int) {
      return -1;
    }
    if ((paramTagOriginal1.jdField_a_of_type_Boolean) && (!paramTagOriginal2.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Boolean) {
        i = -1;
      }
      return i;
    }
    if ((!paramTagOriginal1.jdField_a_of_type_Boolean) && (paramTagOriginal2.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Boolean) {
        return 1;
      }
      return -1;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 3) && (Math.abs(paramTagOriginal1.jdField_a_of_type_Float - paramTagOriginal2.jdField_a_of_type_Float) > 3.0F)) {
      return Float.compare(paramTagOriginal1.jdField_a_of_type_Float, paramTagOriginal2.jdField_a_of_type_Float);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TagUtils.TagArrangementEngine.4
 * JD-Core Version:    0.7.0.1
 */