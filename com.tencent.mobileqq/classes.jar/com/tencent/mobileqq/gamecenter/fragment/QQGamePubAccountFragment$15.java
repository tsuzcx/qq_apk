package com.tencent.mobileqq.gamecenter.fragment;

import alud;
import com.tencent.mobileqq.gamecenter.view.QQGameStatusView;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;

class QQGamePubAccountFragment$15
  implements Runnable
{
  QQGamePubAccountFragment$15(QQGamePubAccountFragment paramQQGamePubAccountFragment, WadlResult paramWadlResult) {}
  
  public void run()
  {
    if (this.a.b == 12)
    {
      QQGamePubAccountFragment.a(this.this$0).a(this.a.a.a, 2);
      return;
    }
    if (this.a.b == 6)
    {
      QQGamePubAccountFragment.a(this.this$0).a(this.a.a.a, 6);
      return;
    }
    if (this.a.b == 4)
    {
      QQGamePubAccountFragment.a(this.this$0).a(this.a.a.a, 5);
      QQGamePubAccountFragment.a(this.this$0).a(this.a.a.a, this.a.d + "");
      return;
    }
    if (this.a.b == 7)
    {
      if (this.this$0.getActivity() != null) {
        QQToast.a(this.this$0.getActivity(), alud.a(2131710710), 0).a();
      }
      QQGamePubAccountFragment.a(this.this$0).a(this.a.a.a, 2);
      return;
    }
    QQGamePubAccountFragment.a(this.this$0).a(this.a.a.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment.15
 * JD-Core Version:    0.7.0.1
 */