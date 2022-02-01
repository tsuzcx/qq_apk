package com.tencent.mobileqq.servlet;

public class GameCenterManagerImp$UnreadData
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public boolean c = false;
  
  public GameCenterManagerImp$UnreadData(GameCenterManagerImp paramGameCenterManagerImp)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(1024);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mUnread=");
    localStringBuilder2.append(this.jdField_a_of_type_Long);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mNewMsg=");
    localStringBuilder2.append(this.jdField_a_of_type_Boolean);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mText=");
    localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mIconPath=");
    localStringBuilder2.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mRedPoint=");
    localStringBuilder2.append(this.jdField_b_of_type_Boolean);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mTab=");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mType=");
    localStringBuilder2.append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.GameCenterManagerImp.UnreadData
 * JD-Core Version:    0.7.0.1
 */