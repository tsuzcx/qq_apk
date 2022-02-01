package org.apache.http.impl.entity;

import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.SessionOutputBuffer;

@Deprecated
public class EntitySerializer
{
  public EntitySerializer(ContentLengthStrategy paramContentLengthStrategy)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected OutputStream doSerialize(SessionOutputBuffer paramSessionOutputBuffer, HttpMessage paramHttpMessage)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void serialize(SessionOutputBuffer paramSessionOutputBuffer, HttpMessage paramHttpMessage, HttpEntity paramHttpEntity)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.entity.EntitySerializer
 * JD-Core Version:    0.7.0.1
 */