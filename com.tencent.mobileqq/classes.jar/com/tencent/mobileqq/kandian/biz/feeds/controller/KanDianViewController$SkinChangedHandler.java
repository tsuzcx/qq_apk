package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyRainAnimationController;
import java.lang.ref.WeakReference;

class KanDianViewController$SkinChangedHandler
  extends Handler
{
  private WeakReference<KanDianViewController> a;
  
  public KanDianViewController$SkinChangedHandler(KanDianViewController paramKanDianViewController)
  {
    this.a = new WeakReference(paramKanDianViewController);
  }
  
  public void handleMessage(Message paramMessage)
  {
    KanDianViewController localKanDianViewController = (KanDianViewController)this.a.get();
    if (localKanDianViewController == null) {
      return;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        if (KanDianViewController.f(localKanDianViewController) != null) {
          KanDianViewController.f(localKanDianViewController).b();
        }
      }
      else if (KanDianViewController.f(localKanDianViewController) != null)
      {
        KanDianViewController.f(localKanDianViewController).a(KanDianViewController.h(localKanDianViewController));
      }
    }
    else {
      KanDianViewController.g(localKanDianViewController);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.KanDianViewController.SkinChangedHandler
 * JD-Core Version:    0.7.0.1
 */