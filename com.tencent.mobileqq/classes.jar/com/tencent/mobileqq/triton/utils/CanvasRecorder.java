package com.tencent.mobileqq.triton.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.util.Base64;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

public class CanvasRecorder
{
  private TTEngine a;
  
  public CanvasRecorder(TTEngine paramTTEngine)
  {
    this.a = paramTTEngine;
  }
  
  private static String a(Bitmap paramBitmap, String paramString, int paramInt)
  {
    if (paramBitmap != null)
    {
      paramString = new ByteArrayOutputStream();
      if (paramBitmap.compress(Bitmap.CompressFormat.PNG, paramInt, paramString))
      {
        paramBitmap = Base64.encodeToString(paramString.toByteArray(), 2);
        TTLog.a("CanvasRecorder", "convertBitmapToBase64String: success, base64 png format");
        return paramBitmap;
      }
      TTLog.b("CanvasRecorder", "convertBitmapToBase64String: fail");
    }
    return null;
  }
  
  @TTNativeCall
  public String canvasToTempFilePathSync(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, boolean paramBoolean)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        ((Bitmap)localObject).copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
        paramArrayOfByte = (byte[])localObject;
        if (paramInt3 > 0)
        {
          paramArrayOfByte = (byte[])localObject;
          if (paramInt4 > 0)
          {
            paramArrayOfByte = Bitmap.createScaledBitmap((Bitmap)localObject, paramInt3, paramInt4, false);
            ((Bitmap)localObject).recycle();
          }
        }
      }
      finally
      {
        TTLog.b("CanvasRecorder", "canvasToTempFilePathSync: ", paramArrayOfByte);
        paramArrayOfByte = null;
        continue;
      }
      if (paramArrayOfByte == null) {
        break label260;
      }
      if (!paramBoolean) {
        break;
      }
      return a(paramArrayOfByte, paramString, paramInt5);
      TTLog.b("CanvasRecorder", "canvasToTempFilePathSync: invalid parameter originalWidth = " + paramInt1 + " originalHeight = " + paramInt2);
      paramArrayOfByte = null;
    }
    Object localObject = this.a.l().getTmpFilePath(this.a.j(), paramString);
    try
    {
      if ("jpg".equalsIgnoreCase(paramString)) {}
      for (paramString = Bitmap.CompressFormat.JPEG;; paramString = Bitmap.CompressFormat.PNG)
      {
        paramBoolean = paramArrayOfByte.compress(paramString, paramInt5, new FileOutputStream((String)localObject));
        if (!paramBoolean) {
          break;
        }
        TTLog.a("CanvasRecorder", "canvasToTempFilePathSync: save to file " + (String)localObject);
        return this.a.l().getWxFilePath((String)localObject);
      }
      TTLog.b("CanvasRecorder", "canvasToTempFilePathSync: save to file fail");
      return null;
    }
    catch (FileNotFoundException paramArrayOfByte)
    {
      TTLog.b("CanvasRecorder", "canvasToTempFilePathSync: ", paramArrayOfByte);
      return null;
    }
    label260:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.CanvasRecorder
 * JD-Core Version:    0.7.0.1
 */