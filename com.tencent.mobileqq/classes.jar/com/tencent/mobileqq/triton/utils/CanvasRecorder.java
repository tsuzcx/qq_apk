package com.tencent.mobileqq.triton.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.util.Base64;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.jni.TTNativeModule;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

@TTNativeModule(name="CanvasRecorder")
public class CanvasRecorder
{
  public static final String TAG = "CanvasRecorder";
  private TTEngine mTritonEngine;
  
  public CanvasRecorder(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
  }
  
  private static String convertBitmapToBase64String(Bitmap paramBitmap, String paramString, int paramInt)
  {
    if (paramBitmap != null)
    {
      paramString = new ByteArrayOutputStream();
      if (paramBitmap.compress(Bitmap.CompressFormat.PNG, paramInt, paramString))
      {
        paramBitmap = Base64.encodeToString(paramString.toByteArray(), 2);
        TTLog.d("CanvasRecorder", "convertBitmapToBase64String: success, base64 png format");
        return paramBitmap;
      }
      TTLog.e("CanvasRecorder", "convertBitmapToBase64String: fail");
    }
    return null;
  }
  
  @TTNativeCall
  public String canvasToTempFilePathSync(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, boolean paramBoolean)
  {
    if (paramArrayOfByte != null)
    {
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject).copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
      if ((paramInt3 <= 0) || (paramInt4 <= 0)) {}
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = Bitmap.createScaledBitmap((Bitmap)localObject, paramInt3, paramInt4, false);
        ((Bitmap)localObject).recycle();
        if (paramArrayOfByte == null) {
          break label257;
        }
        if (!paramBoolean) {
          break;
        }
        return convertBitmapToBase64String(paramArrayOfByte, paramString, paramInt5);
        paramArrayOfByte = (byte[])localObject;
        continue;
      }
      catch (IllegalArgumentException paramArrayOfByte)
      {
        TTLog.e("CanvasRecorder", "canvasToTempFilePathSync: ", paramArrayOfByte);
        paramArrayOfByte = (byte[])localObject;
        continue;
      }
      TTLog.e("CanvasRecorder", "canvasToTempFilePathSync: invalid parameter originalWidth = " + paramInt1 + " originalHeight = " + paramInt2);
      paramArrayOfByte = null;
    }
    Object localObject = this.mTritonEngine.getQQEnv().getTmpFilePath(this.mTritonEngine.getMiniGameInfo(), paramString);
    try
    {
      if ("jpg".equalsIgnoreCase(paramString)) {}
      for (paramString = Bitmap.CompressFormat.JPEG; paramArrayOfByte.compress(paramString, paramInt5, new FileOutputStream((String)localObject)); paramString = Bitmap.CompressFormat.PNG)
      {
        TTLog.d("CanvasRecorder", "canvasToTempFilePathSync: save to file " + (String)localObject);
        return this.mTritonEngine.getQQEnv().getWxFilePath((String)localObject);
      }
      TTLog.e("CanvasRecorder", "canvasToTempFilePathSync: save to file fail");
      return null;
    }
    catch (FileNotFoundException paramArrayOfByte)
    {
      TTLog.e("CanvasRecorder", "canvasToTempFilePathSync: ", paramArrayOfByte);
      return null;
    }
    label257:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.CanvasRecorder
 * JD-Core Version:    0.7.0.1
 */