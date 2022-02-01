package com.tencent.mobileqq.winkpublish.task;

import cooperation.qqcircle.beans.QCircleFakeFeed;

class FSUploadShuoShuoTask$RetryRequestFeed
  implements Runnable
{
  QCircleFakeFeed a;
  int b = 0;
  FSUploadShuoShuoTask.ResultParmas c;
  
  public FSUploadShuoShuoTask$RetryRequestFeed(FSUploadShuoShuoTask paramFSUploadShuoShuoTask, QCircleFakeFeed paramQCircleFakeFeed, int paramInt, FSUploadShuoShuoTask.ResultParmas paramResultParmas)
  {
    this.a = paramQCircleFakeFeed;
    this.b = paramInt;
    this.c = paramResultParmas;
  }
  
  public void run()
  {
    FSUploadShuoShuoTask.a(this.this$0, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.FSUploadShuoShuoTask.RetryRequestFeed
 * JD-Core Version:    0.7.0.1
 */