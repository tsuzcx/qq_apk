package com.tencent.mobileqq.troop.utils;

public class SchoolTroopKeywordManager$KeywordResult
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  private String c;
  public int d;
  
  public SchoolTroopKeywordManager$KeywordResult()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public String a()
  {
    int i = this.jdField_a_of_type_Int;
    if ((i & 0x4) == 4) {
      return "classteacher";
    }
    if ((i & 0x8) == 8) {
      return "teacher";
    }
    if ((i & 0x1) == 1) {
      return "owner";
    }
    if ((i & 0x2) == 2) {
      return "admin";
    }
    return "other";
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = SchoolTroopKeywordManager.a(paramString, "").trim().replaceAll("\\s+", " ");
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeywordResult{msgId=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", troopUin='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", userRole=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", action=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", keyword='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", startPos=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", endPos=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", content=");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.KeywordResult
 * JD-Core Version:    0.7.0.1
 */