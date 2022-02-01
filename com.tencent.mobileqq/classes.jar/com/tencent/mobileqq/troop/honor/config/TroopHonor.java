package com.tencent.mobileqq.troop.honor.config;

public class TroopHonor
  implements Comparable<TroopHonor>
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public TroopHonor(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public int a(TroopHonor paramTroopHonor)
  {
    int i = this.jdField_b_of_type_Int;
    int j = paramTroopHonor.jdField_b_of_type_Int;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopHonor{id=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", priority='");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.config.TroopHonor
 * JD-Core Version:    0.7.0.1
 */