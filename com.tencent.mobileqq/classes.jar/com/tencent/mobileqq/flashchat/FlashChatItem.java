package com.tencent.mobileqq.flashchat;

public class FlashChatItem
{
  public static FlashChatItem a;
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f = "#02A7E3";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem = new FlashChatItem(-100000, "随机");
  }
  
  public FlashChatItem() {}
  
  public FlashChatItem(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "FlashChatItem{id=" + this.jdField_a_of_type_Int + ", appName='" + this.jdField_a_of_type_JavaLangString + '\'' + ", feedType=" + this.jdField_b_of_type_Int + ", name='" + this.jdField_b_of_type_JavaLangString + '\'' + ", iconUrl='" + this.c + '\'' + ", mainView='" + this.d + '\'' + ", ver='" + this.e + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatItem
 * JD-Core Version:    0.7.0.1
 */