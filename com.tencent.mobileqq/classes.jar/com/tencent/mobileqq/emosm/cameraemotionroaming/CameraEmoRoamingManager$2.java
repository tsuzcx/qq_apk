package com.tencent.mobileqq.emosm.cameraemotionroaming;

import ajff;
import anbh;
import anbo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class CameraEmoRoamingManager$2
  implements Runnable
{
  public CameraEmoRoamingManager$2(anbh paramanbh, ajff paramajff) {}
  
  public void run()
  {
    List localList = ((anbo)anbh.a(this.this$0).getManager(333)).a("needDel");
    if (localList.size() > 0) {
      this.a.a(localList, true);
    }
    while (localList.size() != 0) {
      return;
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager.2
 * JD-Core Version:    0.7.0.1
 */