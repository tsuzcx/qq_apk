package com.tencent.mobileqq.troop.quickat.ui;

import android.text.SpannableString;

class AtTag
{
  public final int a;
  public final SpannableString a;
  
  public AtTag(int paramInt, SpannableString paramSpannableString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidTextSpannableString = paramSpannableString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (AtTag)paramObject;
      if (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) {
        return false;
      }
      SpannableString localSpannableString = this.jdField_a_of_type_AndroidTextSpannableString;
      if (localSpannableString != null) {
        return localSpannableString.equals(paramObject.jdField_a_of_type_AndroidTextSpannableString);
      }
      return paramObject.jdField_a_of_type_AndroidTextSpannableString == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.jdField_a_of_type_Int;
    SpannableString localSpannableString = this.jdField_a_of_type_AndroidTextSpannableString;
    int i;
    if (localSpannableString != null) {
      i = localSpannableString.hashCode();
    } else {
      i = 0;
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AtTag{");
    localStringBuilder.append("startIndex=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", atSpan=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidTextSpannableString);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtTag
 * JD-Core Version:    0.7.0.1
 */