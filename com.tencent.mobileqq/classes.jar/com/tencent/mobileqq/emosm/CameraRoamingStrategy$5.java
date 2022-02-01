package com.tencent.mobileqq.emosm;

import arox;
import arqk;
import bgnt;
import com.tencent.mobileqq.app.QQAppInterface;

public class CameraRoamingStrategy$5
  implements Runnable
{
  public CameraRoamingStrategy$5(arox paramarox) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!bgnt.d(this.this$0.a.getApp()))) {
      return;
    }
    ((arqk)this.this$0.a.getManager(334)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.5
 * JD-Core Version:    0.7.0.1
 */