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
    if (((paramFramedata instanceof DataFrame)) && ((paramFramedata.isRSV2()) || (paramFramedata.isRSV3()))) {
      throw new InvalidFrameException("bad rsv RSV1: " + paramFramedata.isRSV1() + " RSV2: " + paramFramedata.isRSV2() + " RSV3: " + paramFramedata.isRSV3());
    }
    if (((paramFramedata instanceof ControlFrame)) && ((paramFramedata.isRSV1()) || (paramFramedata.isRSV2()) || (paramFramedata.isRSV3()))) {
      throw new InvalidFrameException("bad rsv RSV1: " + paramFramedata.isRSV1() + " RSV2: " + paramFramedata.isRSV2() + " RSV3: " + paramFramedata.isRSV3());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.extensions.CompressionExtension
 * JD-Core Version:    0.7.0.1
 */