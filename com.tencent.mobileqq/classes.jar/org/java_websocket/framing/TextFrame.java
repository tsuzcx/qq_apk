package org.java_websocket.framing;

import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.util.Charsetfunctions;

public class TextFrame
  extends DataFrame
{
  public TextFrame()
  {
    super(Opcode.TEXT);
  }
  
  public void isValid()
  {
    super.isValid();
    if (!Charsetfunctions.isValidUTF8(getPayloadData())) {
      throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.java_websocket.framing.TextFrame
 * JD-Core Version:    0.7.0.1
 */