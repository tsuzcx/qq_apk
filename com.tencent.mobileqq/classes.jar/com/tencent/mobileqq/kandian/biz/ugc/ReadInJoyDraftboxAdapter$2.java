package com.tencent.mobileqq.kandian.biz.ugc;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem;
import mqq.os.MqqHandler;

class ReadInJoyDraftboxAdapter$2
  implements View.OnClickListener
{
  ReadInJoyDraftboxAdapter$2(ReadInJoyDraftboxAdapter paramReadInJoyDraftboxAdapter, ReadInJoyDraftboxItem paramReadInJoyDraftboxItem, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ThreadManager.getSubThreadHandler().post(new ReadInJoyDraftboxAdapter.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxAdapter.2
 * JD-Core Version:    0.7.0.1
 */