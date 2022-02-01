package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import java.util.ArrayList;
import java.util.Iterator;

class FaceItemAnimation$2
  implements Runnable
{
  FaceItemAnimation$2(FaceItemAnimation paramFaceItemAnimation, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      FaceItemAnimation.ChangeInfo localChangeInfo = (FaceItemAnimation.ChangeInfo)localIterator.next();
      FaceItemAnimation.a(this.this$0, localChangeInfo);
    }
    this.a.clear();
    FaceItemAnimation.b(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceItemAnimation.2
 * JD-Core Version:    0.7.0.1
 */