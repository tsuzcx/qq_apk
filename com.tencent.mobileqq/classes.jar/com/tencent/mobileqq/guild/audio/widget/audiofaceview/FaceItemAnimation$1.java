package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import java.util.ArrayList;
import java.util.Iterator;

class FaceItemAnimation$1
  implements Runnable
{
  FaceItemAnimation$1(FaceItemAnimation paramFaceItemAnimation, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      FaceItemAnimation.MoveInfo localMoveInfo = (FaceItemAnimation.MoveInfo)localIterator.next();
      FaceItemAnimation.a(this.this$0, localMoveInfo.a, localMoveInfo.b, localMoveInfo.c, localMoveInfo.d, localMoveInfo.e);
    }
    this.a.clear();
    FaceItemAnimation.a(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceItemAnimation.1
 * JD-Core Version:    0.7.0.1
 */