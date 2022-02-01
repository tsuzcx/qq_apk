package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Iterator;

class FaceItemAnimation$3
  implements Runnable
{
  FaceItemAnimation$3(FaceItemAnimation paramFaceItemAnimation, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      FaceItemAnimation.a(this.this$0, localViewHolder);
    }
    this.a.clear();
    FaceItemAnimation.c(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceItemAnimation.3
 * JD-Core Version:    0.7.0.1
 */