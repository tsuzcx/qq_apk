package org.libpag;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import java.nio.ByteBuffer;

public class TraceImage
{
  public static void Trace(String paramString, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localBitmap.copyPixelsFromBuffer(paramByteBuffer);
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("Image(width = ");
    paramByteBuffer.append(localBitmap.getWidth());
    paramByteBuffer.append(", height = ");
    paramByteBuffer.append(localBitmap.getHeight());
    paramByteBuffer.append(")");
    Log.i(paramString, paramByteBuffer.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.TraceImage
 * JD-Core Version:    0.7.0.1
 */