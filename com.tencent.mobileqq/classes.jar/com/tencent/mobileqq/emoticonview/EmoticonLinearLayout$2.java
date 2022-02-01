package com.tencent.mobileqq.emoticonview;

class EmoticonLinearLayout$2
  implements Runnable
{
  EmoticonLinearLayout$2(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
  public void run()
  {
    if (this.this$0.callback != null)
    {
      this.this$0.callback.delete();
      this.this$0.postDelayed(this, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.2
 * JD-Core Version:    0.7.0.1
 */