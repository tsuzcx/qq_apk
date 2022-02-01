package org.java_websocket.framing;

import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidFrameException;

public abstract class ControlFrame
  extends FramedataImpl1
{
  public ControlFrame(Opcode paramOpcode)
  {
    super(paramOpcode);
  }
  
  public void isValid()
  {
    if (isFin())
    {
      if (!isRSV1())
      {
        if (!isRSV2())
        {
          if (!isRSV3()) {
            return;
          }
          throw new InvalidFrameException("Control frame cant have rsv3==true set");
        }
        throw new InvalidFrameException("Control frame cant have rsv2==true set");
      }
      throw new InvalidFrameException("Control frame cant have rsv1==true set");
    }
    throw new InvalidFrameException("Control frame cant have fin==false set");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.framing.ControlFrame
 * JD-Core Version:    0.7.0.1
 */