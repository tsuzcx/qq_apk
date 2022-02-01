package com.tencent.mobileqq.confess;

import android.graphics.Rect;
import java.util.ArrayList;

public class TagUtils$Tag
{
  public int a;
  public Rect a;
  public TagUtils.TagOriginal a;
  public ArrayList<TagUtils.Tag.Child> a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public int d;
  public int e;
  
  public TagUtils$Tag(TagUtils.TagOriginal paramTagOriginal, int paramInt1, Rect paramRect, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfessTagUtils$TagOriginal = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_b_of_type_Int = 24;
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.c = 0;
    this.d = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.e = 1;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqConfessTagUtils$TagOriginal = paramTagOriginal;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    this.e = paramInt3;
    paramBoolean = bool;
    if (paramTagOriginal.jdField_a_of_type_Int > 0) {
      paramBoolean = true;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    paramTagOriginal.jdField_a_of_type_Int += 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("text: ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqConfessTagUtils$TagOriginal.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("; size: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("; line_count: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("; container: ");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsRect);
    localStringBuilder.append("; algin: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("; v_algin: ");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TagUtils.Tag
 * JD-Core Version:    0.7.0.1
 */