package com.tencent.mobileqq.kandian.biz.common.widget;

import com.tencent.qphone.base.util.QLog;

class ReadInJoyXListView$3
  implements Runnable
{
  ReadInJoyXListView$3(ReadInJoyXListView paramReadInJoyXListView, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[setIsTopRefreshIng], isTopRefreshIng = ");
    ((StringBuilder)localObject).append(this.a);
    QLog.i("ReadInJoyXListView", 1, ((StringBuilder)localObject).toString());
    if (this.a)
    {
      this.this$0.setLayerType(1, null);
      return;
    }
    localObject = this.this$0;
    ((ReadInJoyXListView)localObject).setLayerType(ReadInJoyXListView.a((ReadInJoyXListView)localObject), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView.3
 * JD-Core Version:    0.7.0.1
 */