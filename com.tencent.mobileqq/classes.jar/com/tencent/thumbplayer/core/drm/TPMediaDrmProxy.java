package com.tencent.thumbplayer.core.drm;

import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrm.KeyRequest;
import android.media.MediaDrm.OnEventListener;
import android.media.MediaDrm.ProvisionRequest;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import java.util.UUID;

@TargetApi(19)
public class TPMediaDrmProxy
{
  private MediaDrm.OnEventListener mEventListener;
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
    //   4: invokespecial 22	java/lang/Object:<init>	()V
    //   7: aload_0
    //   8: new 24	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy$1
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 27	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy$1:<init>	(Lcom/tencent/thumbplayer/core/drm/TPMediaDrmProxy;)V
    //   16: putfield 29	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy:mEventListener	Landroid/media/MediaDrm$OnEventListener;
    //   19: aload_1
    //   20: iconst_0
    //   21: iconst_0
    //   22: invokestatic 33	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy:longFromBytes	([BIZ)J
    //   25: lstore_2
    //   26: aload_1
    //   27: bipush 8
    //   29: iconst_0
    //   30: invokestatic 33	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy:longFromBytes	([BIZ)J
    //   33: lstore 6
    //   35: lload 6
    //   37: lstore 4
    //   39: new 35	java/util/UUID
    //   42: dup
    //   43: lload_2
    //   44: lload 4
    //   46: invokespecial 38	java/util/UUID:<init>	(JJ)V
    //   49: astore_1
    //   50: new 40	android/media/MediaDrm
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 43	android/media/MediaDrm:<init>	(Ljava/util/UUID;)V
    //   58: astore 8
    //   60: aload 8
    //   62: aload_0
    //   63: getfield 29	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy:mEventListener	Landroid/media/MediaDrm$OnEventListener;
    //   66: invokevirtual 47	android/media/MediaDrm:setOnEventListener	(Landroid/media/MediaDrm$OnEventListener;)V
    //   69: aload_0
    //   70: aload 8
    //   72: putfield 49	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy:mMediaDrm	Landroid/media/MediaDrm;
    //   75: aload_0
    //   76: aload_1
    //   77: putfield 51	com/tencent/thumbplayer/core/drm/TPMediaDrmProxy:mUUID	Ljava/util/UUID;
    //   80: return
    //   81: astore_1
    //   82: lconst_0
    //   83: lstore_2
    //   84: aload_1
    //   85: invokevirtual 54	java/lang/Exception:printStackTrace	()V
    //   88: goto -49 -> 39
    //   91: astore_1
    //   92: goto -8 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	TPMediaDrmProxy
    //   0	95	1	paramArrayOfByte	byte[]
    //   25	59	2	l1	long
    //   1	44	4	l2	long
    //   33	3	6	l3	long
    //   58	13	8	localMediaDrm	MediaDrm
    // Exception table:
    //   from	to	target	type
    //   19	26	81	java/lang/Exception
    //   26	35	91	java/lang/Exception
  }
  
  public static TPMediaDrmProxy createMediaDrmProxyByUUID(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new TPMediaDrmProxy(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (UnsupportedSchemeException paramArrayOfByte) {}
    return null;
  }
  
  private static boolean isCryptoSchemeSupported(byte[] paramArrayOfByte)
  {
    return isCryptoSchemeSupportedWithMimeType(paramArrayOfByte, null);
  }
  
  private static boolean isCryptoSchemeSupportedWithMimeType(byte[] paramArrayOfByte, String paramString)
  {
    long l2 = 0L;
    label41:
    for (;;)
    {
      try
      {
        long l1 = longFromBytes(paramArrayOfByte, 0, false);
        long l3;
        paramArrayOfByte.printStackTrace();
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          l3 = longFromBytes(paramArrayOfByte, 8, false);
          l2 = l3;
          return MediaDrm.isCryptoSchemeSupported(new UUID(l1, l2), paramString);
        }
        catch (Exception paramArrayOfByte)
        {
          break label41;
        }
        paramArrayOfByte = paramArrayOfByte;
        l1 = 0L;
      }
    }
  }
  
  public static long longFromBytes(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
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
    catch (ResourceBusyException localResourceBusyException)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.TPMediaDrmProxy
 * JD-Core Version:    0.7.0.1
 */