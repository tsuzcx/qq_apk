package com.tencent.qqlive.module.videoreport.traversal;

import com.tencent.qqlive.module.videoreport.Log;

final class ViewGroupDrawingCompat$1
  implements Runnable
{
  public void run()
  {
    boolean bool = ViewGroupDrawingCompat.access$000();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload success:");
    localStringBuilder.append(bool);
    Log.v("ViewGroupDrawingCompat", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.traversal.ViewGroupDrawingCompat.1
 * JD-Core Version:    0.7.0.1
 */