package com.tencent.mobileqq.config;

final class QConfigJourney$Entry
{
  public int a;
  public long a;
  public String a;
  public String b;
  private final String c;
  
  public QConfigJourney$Entry(int paramInt, String paramString1, long paramLong, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Long = paramLong;
    this.b = paramString2;
    paramString1 = new StringBuilder();
    paramString1.append(this.jdField_a_of_type_Int);
    paramString1.append("-");
    paramString1.append(this.jdField_a_of_type_JavaLangString);
    paramString1.append("-");
    paramString1.append(this.jdField_a_of_type_Long);
    this.c = paramString1.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Entry;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (Entry)paramObject;
    bool1 = bool2;
    if (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Entry{type=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", key='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", path='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigJourney.Entry
 * JD-Core Version:    0.7.0.1
 */