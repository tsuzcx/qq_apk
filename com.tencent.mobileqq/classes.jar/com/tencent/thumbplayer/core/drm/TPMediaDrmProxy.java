package com.tencent.thumbplayer.core.drm;

import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrm.KeyRequest;
import android.media.MediaDrm.ProvisionRequest;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import java.util.UUID;

@TargetApi(18)
public class TPMediaDrmProxy
{
  private MediaDrm mMediaDrm;
  private long mNativeContext;
  private UUID mUUID;
  
  /* Error */
  private TPMediaDrmProxy(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: aload_0
    //   4: invokespecial 20	java/lang/Object:<init>	()V
    //   7: aload_1
    //   8: iconst_0
    //   9: iconst_0
    //   10: invokestatic 24	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy:longFromBytes	([BIZ)J
    //   13: lstore_2
    //   14: aload_1
    //   15: bipush 8
    //   17: iconst_0
    //   18: invokestatic 24	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy:longFromBytes	([BIZ)J
    //   21: lstore 6
    //   23: lload 6
    //   25: lstore 4
    //   27: new 26	java/util/UUID
    //   30: dup
    //   31: lload_2
    //   32: lload 4
    //   34: invokespecial 29	java/util/UUID:<init>	(JJ)V
    //   37: astore_1
    //   38: new 31	android/media/MediaDrm
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 34	android/media/MediaDrm:<init>	(Ljava/util/UUID;)V
    //   46: astore 8
    //   48: aload 8
    //   50: new 36	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy$1
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 39	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy$1:<init>	(Lcom/tencent/thumbplayer/core/drm/TPMediaDrmProxy;)V
    //   58: invokevirtual 43	android/media/MediaDrm:setOnEventListener	(Landroid/media/MediaDrm$OnEventListener;)V
    //   61: aload_0
    //   62: aload 8
    //   64: putfield 45	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy:mMediaDrm	Landroid/media/MediaDrm;
    //   67: aload_0
    //   68: aload_1
    //   69: putfield 47	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy:mUUID	Ljava/util/UUID;
    //   72: return
    //   73: astore_1
    //   74: lconst_0
    //   75: lstore_2
    //   76: aload_1
    //   77: invokevirtual 50	java/lang/Exception:printStackTrace	()V
    //   80: goto -53 -> 27
    //   83: astore_1
    //   84: goto -8 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	TPMediaDrmProxy
    //   0	87	1	paramArrayOfByte	byte[]
    //   13	63	2	l1	long
    //   1	32	4	l2	long
    //   21	3	6	l3	long
    //   46	17	8	localMediaDrm	MediaDrm
    // Exception table:
    //   from	to	target	type
    //   7	14	73	java/lang/Exception
    //   14	23	83	java/lang/Exception
  }
  
  public static TPMediaDrmProxy createMediaDrmProxyByUUID(byte[] paramArrayOfByte)
  {
    if (Build.VERSION.SDK_INT < 18) {
      return null;
    }
    try
    {
      paramArrayOfByte = new TPMediaDrmProxy(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (UnsupportedSchemeException paramArrayOfByte) {}
    return null;
  }
  
  private static boolean isCryptoSchemeSupportedWithMimeType(byte[] paramArrayOfByte, String paramString)
  {
    boolean bool = false;
    long l1;
    long l2;
    do
    {
      try
      {
        l1 = longFromBytes(paramArrayOfByte, 0, false);
        l2 = longFromBytes(paramArrayOfByte, 8, false);
        if (Build.VERSION.SDK_INT >= 19)
        {
          bool = MediaDrm.isCryptoSchemeSupported(new UUID(l1, l2), paramString);
          return bool;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return false;
      }
    } while (Build.VERSION.SDK_INT != 18);
    return MediaDrm.isCryptoSchemeSupported(new UUID(l1, l2));
  }
  
  private static long longFromBytes(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    long l = 0L;
    int i = 0;
    if (i < 8)
    {
      if (paramBoolean) {}
      for (int j = i;; j = 7 - i)
      {
        j <<= 3;
        l |= 255L << j & paramArrayOfByte[(paramInt + i)] << j;
        i += 1;
        break;
      }
    }
    return l;
  }
  
  private native void native_mediaDrmOnEvent(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, @NonNull byte[] paramArrayOfByte2);
  
  public void closeSession(byte[] paramArrayOfByte)
  {
    this.mMediaDrm.closeSession(paramArrayOfByte);
  }
  
  public TPMediaDrmProxy.KeyRequest getKeyRequest(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = this.mMediaDrm.getKeyRequest(paramArrayOfByte1, paramArrayOfByte2, paramString, paramInt, null);
        if (Build.VERSION.SDK_INT >= 23)
        {
          paramInt = paramArrayOfByte1.getRequestType();
          return new TPMediaDrmProxy.KeyRequest(paramInt, paramArrayOfByte1.getData(), 0);
        }
      }
      catch (NotProvisionedException paramArrayOfByte1)
      {
        return new TPMediaDrmProxy.KeyRequest(-1, null, -1);
      }
      paramInt = 0;
    }
  }
  
  public MediaCrypto getMediaCrypto(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new MediaCrypto(this.mUUID, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (MediaCryptoException paramArrayOfByte) {}
    return null;
  }
  
  public String getPropertyString(String paramString)
  {
    return this.mMediaDrm.getPropertyString(paramString);
  }
  
  public TPMediaDrmProxy.ProvisionRequest getProvisionRequest()
  {
    MediaDrm.ProvisionRequest localProvisionRequest = this.mMediaDrm.getProvisionRequest();
    return new TPMediaDrmProxy.ProvisionRequest(localProvisionRequest.getDefaultUrl(), localProvisionRequest.getData());
  }
  
  public TPMediaDrmProxy.DrmSessionId openSession()
  {
    Object localObject = null;
    i = 0;
    try
    {
      byte[] arrayOfByte = this.mMediaDrm.openSession();
      localObject = arrayOfByte;
    }
    catch (NotProvisionedException localNotProvisionedException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = -2;
      }
    }
    return new TPMediaDrmProxy.DrmSessionId(i, localObject);
  }
  
  public int provideKeyResponse(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      this.mMediaDrm.provideKeyResponse(paramArrayOfByte1, paramArrayOfByte2);
      return 0;
    }
    catch (NotProvisionedException paramArrayOfByte1)
    {
      return -1;
    }
    catch (DeniedByServerException paramArrayOfByte1) {}
    return -2;
  }
  
  public int provideProvisionResponse(byte[] paramArrayOfByte)
  {
    try
    {
      this.mMediaDrm.provideProvisionResponse(paramArrayOfByte);
      return 0;
    }
    catch (DeniedByServerException paramArrayOfByte) {}
    return -1;
  }
  
  public void release()
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.mMediaDrm.close();
      return;
    }
    this.mMediaDrm.release();
  }
  
  public void setPropertyString(String paramString1, String paramString2)
  {
    this.mMediaDrm.setPropertyString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.TPMediaDrmProxy
 * JD-Core Version:    0.7.0.1
 */