package com.tencent.mobileqq.kandian.biz.video.viewholder;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ViewHolder$VideoUIHandler
  extends Handler
{
  public List<Handler.Callback> a = new ArrayList();
  
  public void handleMessage(Message paramMessage)
  {
    Iterator localIterator = this.a.iterator();
    while ((localIterator.hasNext()) && (!((Handler.Callback)localIterator.next()).handleMessage(paramMessage))) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder.VideoUIHandler
 * JD-Core Version:    0.7.0.1
 */