package com.tencent.mobileqq.gamecenter.fragment;

import abuf;
import amwn;
import android.os.Handler;
import android.widget.RelativeLayout;
import avda;
import aver;
import avfh;
import avft;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.view.QQGameIndicator;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import java.util.ArrayList;
import java.util.List;

class QQGamePubAccountFragment$10
  implements Runnable
{
  QQGamePubAccountFragment$10(QQGamePubAccountFragment paramQQGamePubAccountFragment, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    synchronized (QQGamePubAccountFragment.a)
    {
      QQGamePubAccountFragment.a(this.this$0).add(0, this.a);
      avfh localavfh = avft.a(this.a, this.this$0.getActivity());
      QQGamePubAccountFragment.a(this.this$0).add(0, localavfh);
      if (QQGamePubAccountFragment.a(this.this$0) != null) {
        QQGamePubAccountFragment.a(this.this$0).notifyDataSetChanged();
      }
      if (QQGamePubAccountFragment.a(this.this$0) != null)
      {
        QQGamePubAccountFragment.a(this.this$0).a();
        int i = QQGamePubAccountFragment.a(this.this$0).getCurrentItem();
        QQGamePubAccountFragment.a(this.this$0).setCurrentItem(i + 1);
        QQGamePubAccountFragment.a(this.this$0).setCurrentIndex(i + 1);
      }
      this.this$0.c();
      QQGamePubAccountFragment.a(this.this$0).setVisibility(0);
      QQGamePubAccountFragment.a(this.this$0).sendEmptyMessageDelayed(0, 3000L);
      QQGamePubAccountFragment.a(this.this$0).setTag(aver.a(this.a));
      ??? = aver.a(this.a, 0);
      abuf.a(amwn.a(), "769", "205030", (String)???, "76901", "1", "160", new String[] { aver.a(this.a), "", "8" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.10
 * JD-Core Version:    0.7.0.1
 */