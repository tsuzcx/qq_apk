package com.tencent.widget;

class AdapterView$SelectionNotifier
  implements Runnable
{
  private AdapterView$SelectionNotifier(AdapterView paramAdapterView) {}
  
  public void run()
  {
    if (this.this$0.mDataChanged)
    {
      if (this.this$0.getAdapter() != null) {
        this.this$0.post(this);
      }
      return;
    }
    AdapterView.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AdapterView.SelectionNotifier
 * JD-Core Version:    0.7.0.1
 */