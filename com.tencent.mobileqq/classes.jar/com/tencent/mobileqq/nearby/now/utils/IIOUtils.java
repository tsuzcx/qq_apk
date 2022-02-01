package com.tencent.mobileqq.nearby.now.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

@QAPI(process={"all"})
public abstract interface IIOUtils
  extends QRouteApi
{
  public abstract ReadableByteChannel getChannel(InputStream paramInputStream);
  
  public abstract WritableByteChannel getChannel(OutputStream paramOutputStream);
  
  public abstract byte[] getFileMD5(File paramFile);
  
  public abstract int indexOf(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2);
  
  public abstract byte[] numberToBytes(long paramLong, int paramInt, boolean paramBoolean);
  
  public abstract byte[] readBytes(InputStream paramInputStream, int paramInt);
  
  public abstract float readFloat(InputStream paramInputStream);
  
  public abstract float readFloat(InputStream paramInputStream, boolean paramBoolean);
  
  public abstract long readInt(InputStream paramInputStream);
  
  public abstract long readInt(InputStream paramInputStream, boolean paramBoolean);
  
  public abstract long readNumber(InputStream paramInputStream, int paramInt, boolean paramBoolean);
  
  public abstract String readString(InputStream paramInputStream, int paramInt);
  
  public abstract String readString(InputStream paramInputStream, int paramInt, String paramString);
  
  public abstract void skip(InputStream paramInputStream, int paramInt);
  
  public abstract void writeFloat(OutputStream paramOutputStream, float paramFloat);
  
  public abstract void writeFloat(OutputStream paramOutputStream, float paramFloat, boolean paramBoolean);
  
  public abstract void writeInt(OutputStream paramOutputStream, long paramLong);
  
  public abstract void writeInt(OutputStream paramOutputStream, long paramLong, boolean paramBoolean);
  
  public abstract void writeNumber(OutputStream paramOutputStream, long paramLong, int paramInt, boolean paramBoolean);
  
  public abstract void writeShort(OutputStream paramOutputStream, int paramInt);
  
  public abstract void writeShort(OutputStream paramOutputStream, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.IIOUtils
 * JD-Core Version:    0.7.0.1
 */