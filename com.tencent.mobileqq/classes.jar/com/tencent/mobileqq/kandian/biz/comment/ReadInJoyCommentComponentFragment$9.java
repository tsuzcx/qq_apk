package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.PublicAccountGifListener;
import mqq.os.MqqHandler;

class ReadInJoyCommentComponentFragment$9
  implements PublicAccountGifListener
{
  ReadInJoyCommentComponentFragment$9(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void a(HotPicData paramHotPicData)
  {
    ReadInJoyCommentComponentFragment localReadInJoyCommentComponentFragment = this.a;
    localReadInJoyCommentComponentFragment.L = paramHotPicData;
    ReadInJoyCommentComponentFragment.a(localReadInJoyCommentComponentFragment, null);
    ThreadManager.getUIHandler().post(new ReadInJoyCommentComponentFragment.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.9
 * JD-Core Version:    0.7.0.1
 */