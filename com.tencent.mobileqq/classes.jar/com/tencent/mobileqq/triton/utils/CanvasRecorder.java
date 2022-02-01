package com.tencent.mobileqq.triton.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.TemporaryFile;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

@TritonKeep
public class CanvasRecorder
{
  public static final String TAG = "CanvasRecorder";
  private TTEngine mTritonEngine;
  
  public CanvasRecorder(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
  }
  
  @TritonKeep
  public String canvasToTempFilePathSync(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, boolean paramBoolean)
  {
    Object localObject;
    if (paramArrayOfByte != null)
    {
      try
      {
        localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        ((Bitmap)localObject).copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
        if ((paramInt3 > 0) && (paramInt4 > 0))
        {
          paramArrayOfByte = Bitmap.createScaledBitmap((Bitmap)localObject, paramInt3, paramInt4, false);
          ((Bitmap)localObject).recycle();
        }
        else
        {
          paramArrayOfByte = (byte[])localObject;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        Logger.e("CanvasRecorder", "canvasToTempFilePathSync: ", paramArrayOfByte);
        break label113;
      }
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("canvasToTempFilePathSync: invalid parameter originalWidth = ");
      paramArrayOfByte.append(paramInt1);
      paramArrayOfByte.append(" originalHeight = ");
      paramArrayOfByte.append(paramInt2);
      Logger.e("CanvasRecorder", paramArrayOfByte.toString());
    }
    label113:
    paramArrayOfByte = null;
    if (paramArrayOfByte != null)
    {
      if (paramBoolean)
      {
        if (paramArrayOfByte != null)
        {
          paramString = new ByteArrayOutputStream();
          if (paramArrayOfByte.compress(Bitmap.CompressFormat.PNG, paramInt5, paramString))
          {
            paramArrayOfByte = Base64.encodeToString(paramString.toByteArray(), 2);
            Logger.d("CanvasRecorder", "convertBitmapToBase64String: success, base64 png format");
            return paramArrayOfByte;
          }
          Logger.e("CanvasRecorder", "convertBitmapToBase64String: fail");
        }
        return null;
      }
      if (TextUtils.isEmpty(paramString)) {
        localObject = "png";
      } else {
        localObject = paramString.toLowerCase();
      }
      localObject = this.mTritonEngine.getEngineContext().getDataFileSystem().newTempFile(null, (String)localObject);
      try
      {
        if ("jpg".equalsIgnoreCase(paramString)) {
          paramString = Bitmap.CompressFormat.JPEG;
        } else {
          paramString = Bitmap.CompressFormat.PNG;
        }
        if (paramArrayOfByte.compress(paramString, paramInt5, new FileOutputStream(((TemporaryFile)localObject).getFile())))
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("canvasToTempFilePathSync: save to file ");
          paramArrayOfByte.append(((TemporaryFile)localObject).getFile());
          Logger.d("CanvasRecorder", paramArrayOfByte.toString());
          return ((TemporaryFile)localObject).getPathInGame();
        }
        Logger.e("CanvasRecorder", "canvasToTempFilePathSync: save to file fail");
        return null;
      }
      catch (FileNotFoundException paramArrayOfByte)
      {
        Logger.e("CanvasRecorder", "canvasToTempFilePathSync: ", paramArrayOfByte);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.CanvasRecorder
 * JD-Core Version:    0.7.0.1
 */