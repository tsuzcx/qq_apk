package org.java_websocket.framing;

import org.java_websocket.enums.Opcode;

public class PingFrame
  extends ControlFrame
{
  public PingFrame()
  {
    super(Opcode.PING);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.framing.PingFrame
 * JD-Core Version:    0.7.0.1
 */