package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;

public abstract interface Framedata
{
  public abstract void append(Framedata paramFramedata);
  
  public abstract Opcode getOpcode();
  
  public abstract ByteBuffer getPayloadData();
  
  public abstract boolean getTransfereMasked();
  
  public abstract boolean isFin();
  
  public abstract boolean isRSV1();
  
  public abstract boolean isRSV2();
  
  public abstract boolean isRSV3();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.framing.Framedata
 * JD-Core Version:    0.7.0.1
 */