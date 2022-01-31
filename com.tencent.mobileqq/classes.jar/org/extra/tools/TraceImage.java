package org.extra.tools;

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
    Log.i(paramString, "Image(width = " + localBitmap.getWidth() + ", height = " + localBitmap.getHeight() + ")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.extra.tools.TraceImage
 * JD-Core Version:    0.7.0.1
 */