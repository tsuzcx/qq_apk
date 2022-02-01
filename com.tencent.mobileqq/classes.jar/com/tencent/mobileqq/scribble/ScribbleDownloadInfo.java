package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.qphone.base.util.QLog;

public class ScribbleDownloadInfo
  implements Comparable<ScribbleDownloadInfo>
{
  public MessageForScribble a;
  public int b = 200;
  
  public ScribbleDownloadInfo(MessageForScribble paramMessageForScribble, int paramInt)
  {
    this.a = paramMessageForScribble;
    if (paramInt >= 200)
    {
      this.b = paramInt;
      return;
    }
    QLog.e("ScribbleDownloadInfo", 1, "err priority");
  }
  
  public int a(ScribbleDownloadInfo paramScribbleDownloadInfo)
  {
    int i = this.b;
    int j = paramScribbleDownloadInfo.b;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleDownloadInfo
 * JD-Core Version:    0.7.0.1
 */