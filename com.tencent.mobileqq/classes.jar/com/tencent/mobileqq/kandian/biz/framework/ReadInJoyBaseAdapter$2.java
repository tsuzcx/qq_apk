package com.tencent.mobileqq.kandian.biz.framework;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;

class ReadInJoyBaseAdapter$2
  extends ReadInJoyObserver
{
  ReadInJoyBaseAdapter$2(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void a(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    if (paramInt == 101) {
      ReadInJoyBaseAdapter.a(this.a, paramBoolean, paramVarArgs);
    }
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter.2
 * JD-Core Version:    0.7.0.1
 */