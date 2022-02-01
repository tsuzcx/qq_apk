package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IScribbleDownloader
  extends IRuntimeService
{
  public abstract void DownloadFromAio(MessageForScribble paramMessageForScribble);
  
  public abstract void PreDownloadFromMsg(MessageForScribble paramMessageForScribble);
  
  public abstract void checkBDHsessionkey();
  
  public abstract void off();
  
  public abstract void on();
  
  public abstract int removeDownloadedMsg(MessageForScribble paramMessageForScribble);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.IScribbleDownloader
 * JD-Core Version:    0.7.0.1
 */