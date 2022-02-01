package org.java_websocket.extensions;

import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.framing.ControlFrame;
import org.java_websocket.framing.DataFrame;
import org.java_websocket.framing.Framedata;

public abstract class CompressionExtension
  extends DefaultExtension
{
  public void isFrameValid(Framedata paramFramedata)
  {
    StringBuilder localStringBuilder;
    if (((paramFramedata instanceof DataFrame)) && ((paramFramedata.isRSV2()) || (paramFramedata.isRSV3())))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bad rsv RSV1: ");
      localStringBuilder.append(paramFramedata.isRSV1());
      localStringBuilder.append(" RSV2: ");
      localStringBuilder.append(paramFramedata.isRSV2());
      localStringBuilder.append(" RSV3: ");
      localStringBuilder.append(paramFramedata.isRSV3());
      throw new InvalidFrameException(localStringBuilder.toString());
    }
    if ((paramFramedata instanceof ControlFrame))
    {
      if ((!paramFramedata.isRSV1()) && (!paramFramedata.isRSV2()) && (!paramFramedata.isRSV3())) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bad rsv RSV1: ");
      localStringBuilder.append(paramFramedata.isRSV1());
      localStringBuilder.append(" RSV2: ");
      localStringBuilder.append(paramFramedata.isRSV2());
      localStringBuilder.append(" RSV3: ");
      localStringBuilder.append(paramFramedata.isRSV3());
      throw new InvalidFrameException(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.extensions.CompressionExtension
 * JD-Core Version:    0.7.0.1
 */