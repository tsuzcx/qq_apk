package dov.com.tencent.biz.qqstory.takevideo.vote;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import anpa;
import anpb;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem;

public class VoteDashItem
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public void a(VoteLayer.VoteItem paramVoteItem, View paramView, boolean paramBoolean, int paramInt1, int paramInt2, Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    int i;
    for (;;)
    {
      i = 0;
      while (i < paramInt1 - paramInt2)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new anpa(this, paramVoteItem, paramView), i);
        i += paramInt2;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new anpb(this, paramVoteItem, paramBoolean, paramView, paramRunnable), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem
 * JD-Core Version:    0.7.0.1
 */