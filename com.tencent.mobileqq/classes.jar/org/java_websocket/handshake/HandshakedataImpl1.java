package org.java_websocket.handshake;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class HandshakedataImpl1
  implements HandshakeBuilder
{
  private byte[] content;
  private TreeMap<String, String> map = new TreeMap(String.CASE_INSENSITIVE_ORDER);
  
  public byte[] getContent()
  {
    return this.content;
  }
  
  public String getFieldValue(String paramString)
  {
    String str = (String)this.map.get(paramString);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
  
  public boolean hasFieldValue(String paramString)
  {
    return this.map.containsKey(paramString);
  }
  
  public Iterator<String> iterateHttpFields()
  {
    return Collections.unmodifiableSet(this.map.keySet()).iterator();
  }
  
  public void put(String paramString1, String paramString2)
  {
    this.map.put(paramString1, paramString2);
  }
  
  public void setContent(byte[] paramArrayOfByte)
  {
    this.content = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.handshake.HandshakedataImpl1
 * JD-Core Version:    0.7.0.1
 */