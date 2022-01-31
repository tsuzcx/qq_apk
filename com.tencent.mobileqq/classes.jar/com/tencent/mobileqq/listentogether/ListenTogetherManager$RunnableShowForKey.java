package com.tencent.mobileqq.listentogether;

public class ListenTogetherManager$RunnableShowForKey
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  ListenTogetherManager$RunnableShowForKey(ListenTogetherManager paramListenTogetherManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    ListenTogetherManager.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.RunnableShowForKey
 * JD-Core Version:    0.7.0.1
 */