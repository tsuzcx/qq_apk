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
    if (paramArrayOfByte != null) {}
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        ((Bitmap)localObject).copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
        if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
          continue;
        }
        paramArrayOfByte = Bitmap.createScaledBitmap((Bitmap)localObject, paramInt3, paramInt4, false);
        ((Bitmap)localObject).recycle();
      }
      catch (Throwable paramArrayOfByte)
      {
        Logger.e("CanvasRecorder", "canvasToTempFilePathSync: ", paramArrayOfByte);
        paramArrayOfByte = null;
        continue;
      }
      if (paramArrayOfByte == null) {
        break label317;
      }
      if (!paramBoolean) {
        break label171;
      }
      if (paramArrayOfByte == null) {
        break label169;
      }
      paramString = new ByteArrayOutputStream();
      if (!paramArrayOfByte.compress(Bitmap.CompressFormat.PNG, paramInt5, paramString)) {
        break;
      }
      paramArrayOfByte = Base64.encodeToString(paramString.toByteArray(), 2);
      Logger.d("CanvasRecorder", "convertBitmapToBase64String: success, base64 png format");
      return paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject;
      continue;
      Logger.e("CanvasRecorder", "canvasToTempFilePathSync: invalid parameter originalWidth = " + paramInt1 + " originalHeight = " + paramInt2);
      paramArrayOfByte = null;
    }
    Logger.e("CanvasRecorder", "convertBitmapToBase64String: fail");
    label169:
    return null;
    label171:
    if (TextUtils.isEmpty(paramString)) {
      localObject = "png";
    }
    for (;;)
    {
      localObject = this.mTritonEngine.getEngineContext().getDataFileSystem().newTempFile(null, (String)localObject);
      try
      {
        if ("jpg".equalsIgnoreCase(paramString)) {}
        for (paramString = Bitmap.CompressFormat.JPEG;; paramString = Bitmap.CompressFormat.PNG)
        {
          if (!paramArrayOfByte.compress(paramString, paramInt5, new FileOutputStream(((TemporaryFile)localObject).getFile()))) {
            break label297;
          }
          Logger.d("CanvasRecorder", "canvasToTempFilePathSync: save to file " + ((TemporaryFile)localObject).getFile());
          paramArrayOfByte = ((TemporaryFile)localObject).getPathInGame();
          return paramArrayOfByte;
          localObject = paramString.toLowerCase();
          break;
        }
        label297:
        Logger.e("CanvasRecorder", "canvasToTempFilePathSync: save to file fail");
        return null;
      }
      catch (FileNotFoundException paramArrayOfByte)
      {
        Logger.e("CanvasRecorder", "canvasToTempFilePathSync: ", paramArrayOfByte);
        return null;
      }
    }
    label317:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.CanvasRecorder
 * JD-Core Version:    0.7.0.1
 */