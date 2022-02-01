package com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.flow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GlUtil
{
  public static int a(int paramInt)
  {
    return a(paramInt, null, 9729, 9729, 33071, 33071);
  }
  
  public static int a(int paramInt, Bitmap paramBitmap)
  {
    return a(paramInt, paramBitmap, 9729, 9729, 33071, 33071);
  }
  
  public static int a(int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    a("glGenTextures");
    GLES20.glBindTexture(paramInt1, arrayOfInt[0]);
    a("glBindTexture " + arrayOfInt[0]);
    GLES20.glTexParameterf(paramInt1, 10241, paramInt2);
    GLES20.glTexParameterf(paramInt1, 10240, paramInt3);
    GLES20.glTexParameteri(paramInt1, 10242, paramInt4);
    GLES20.glTexParameteri(paramInt1, 10243, paramInt5);
    if (paramBitmap != null) {
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    a("glTexParameter");
    return arrayOfInt[0];
  }
  
  public static String a(AppContext paramAppContext, int paramInt)
  {
    InputStream localInputStream = paramAppContext.a().getResources().openRawResource(paramInt);
    InputStreamReader localInputStreamReader = new InputStreamReader(localInputStream);
    paramAppContext = new BufferedReader(localInputStreamReader);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = paramAppContext.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
        localStringBuilder.append('\n');
      }
      try
      {
        localIOException6.close();
      }
      catch (IOException localIOException3)
      {
        try
        {
          localIOException2.close();
        }
        catch (IOException localIOException3)
        {
          try
          {
            for (;;)
            {
              paramAppContext.close();
              throw localObject;
              localIOException7 = localIOException7;
              TLog.d("FlowEdit_GlUtil", localIOException7.toString());
              continue;
              localIOException3 = localIOException3;
              TLog.d("FlowEdit_GlUtil", localIOException3.toString());
            }
          }
          catch (IOException paramAppContext)
          {
            for (;;)
            {
              TLog.d("FlowEdit_GlUtil", paramAppContext.toString());
            }
          }
        }
      }
    }
    catch (IOException localIOException4)
    {
      localIOException4 = localIOException4;
      try
      {
        localInputStream.close();
      }
      catch (IOException localIOException5)
      {
        try
        {
          for (;;)
          {
            localInputStreamReader.close();
            for (;;)
            {
              try
              {
                paramAppContext.close();
                return null;
              }
              catch (IOException paramAppContext)
              {
                TLog.d("FlowEdit_GlUtil", paramAppContext.toString());
                return null;
              }
              try
              {
                localInputStream.close();
              }
              catch (IOException localIOException1)
              {
                try
                {
                  localInputStreamReader.close();
                }
                catch (IOException localIOException1)
                {
                  try
                  {
                    paramAppContext.close();
                    return localIOException4.toString();
                    localIOException6 = localIOException6;
                    TLog.d("FlowEdit_GlUtil", localIOException6.toString());
                    continue;
                    localIOException1 = localIOException1;
                    TLog.d("FlowEdit_GlUtil", localIOException1.toString());
                  }
                  catch (IOException paramAppContext)
                  {
                    TLog.d("FlowEdit_GlUtil", paramAppContext.toString());
                  }
                }
              }
            }
            localIOException5 = localIOException5;
            TLog.d("FlowEdit_GlUtil", localIOException5.toString());
          }
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            TLog.d("FlowEdit_GlUtil", localIOException2.toString());
          }
        }
      }
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    a("glDeleteTextures");
  }
  
  public static void a(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      TLog.d("FlowEdit_GlUtil", paramString + ": glError 0x" + Integer.toHexString(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.flow.GlUtil
 * JD-Core Version:    0.7.0.1
 */