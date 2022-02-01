package com.tencent.mobileqq.listentogether;

class ListenTogetherManager$RunnableShowForKey
  implements Runnable
{
  String a;
  boolean b;
  
  ListenTogetherManager$RunnableShowForKey(ListenTogetherManager paramListenTogetherManager, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    ListenTogetherManager.a(this.this$0, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.RunnableShowForKey
 * JD-Core Version:    0.7.0.1
 */