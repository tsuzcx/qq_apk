package org.java_websocket.framing;

import org.java_websocket.enums.Opcode;

public class ContinuousFrame
  extends DataFrame
{
  public ContinuousFrame()
  {
    super(Opcode.CONTINUOUS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.java_websocket.framing.ContinuousFrame
 * JD-Core Version:    0.7.0.1
 */