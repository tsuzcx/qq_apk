package com.tencent.mobileqq.kandian.biz.common.widget;

class ReadInJoyListViewGroup$7
  implements Runnable
{
  ReadInJoyListViewGroup$7(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    if (this.this$0.d != null)
    {
      int i = this.this$0.d.getFirstVisiblePosition();
      this.this$0.d.setAdapter(ReadInJoyListViewGroup.a(this.this$0));
      this.this$0.d.post(new ReadInJoyListViewGroup.7.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup.7
 * JD-Core Version:    0.7.0.1
 */