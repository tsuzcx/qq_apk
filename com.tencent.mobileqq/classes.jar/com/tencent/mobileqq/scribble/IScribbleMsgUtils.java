package com.tencent.mobileqq.scribble;

import android.graphics.Bitmap;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IScribbleMsgUtils
  extends QRouteApi
{
  public abstract boolean ReSendScribbleMsgRecord(AppRuntime paramAppRuntime, MessageForScribble paramMessageForScribble);
  
  public abstract void SendScribbleMsg(AppRuntime paramAppRuntime, String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, IScribbleMsgUtils.CombineCallback paramCombineCallback);
  
  public abstract boolean downloadScribble(MessageForScribble paramMessageForScribble);
  
  public abstract String getScribbleCombineFile(MessageForScribble paramMessageForScribble);
  
  public abstract byte[] getScribbleDataByte(MessageForScribble paramMessageForScribble);
  
  public abstract String getScribbleDataFilePath(MessageForScribble paramMessageForScribble);
  
  public abstract int getScribbleDataReadyState(MessageForScribble paramMessageForScribble);
  
  public abstract int splitPureDataFromCombineFile(MessageForScribble paramMessageForScribble);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.IScribbleMsgUtils
 * JD-Core Version:    0.7.0.1
 */