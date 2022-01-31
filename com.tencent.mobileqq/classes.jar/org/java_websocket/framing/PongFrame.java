package org.java_websocket.framing;

import org.java_websocket.enums.Opcode;

public class PongFrame
  extends ControlFrame
{
  public PongFrame()
  {
    super(Opcode.PONG);
  }
  
  public PongFrame(PingFrame paramPingFrame)
  {
    super(Opcode.PONG);
    setPayload(paramPingFrame.getPayloadData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.java_websocket.framing.PongFrame
 * JD-Core Version:    0.7.0.1
 */