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
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import java.util.UUID;

@TargetApi(18)
public class TPMediaDrmProxy
{
  private MediaDrm mMediaDrm;
  private long mNativeContext;
  private UUID mUUID;
  
  private TPMediaDrmProxy(byte[] paramArrayOfByte)
  {
    long l2 = 0L;
    long l1;
    try
    {
      l1 = longFromBytes(paramArrayOfByte, 0, false);
      try
      {
        long l3 = longFromBytes(paramArrayOfByte, 8, false);
        l2 = l3;
      }
      catch (Exception paramArrayOfByte) {}
      paramArrayOfByte.printStackTrace();
    }
    catch (Exception paramArrayOfByte)
    {
      l1 = 0L;
    }
    paramArrayOfByte = new UUID(l1, l2);
    MediaDrm localMediaDrm = new MediaDrm(paramArrayOfByte);
    localMediaDrm.setOnEventListener(new TPMediaDrmProxy.1(this));
    this.mMediaDrm = localMediaDrm;
    this.mUUID = paramArrayOfByte;
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
    try
    {
      long l1 = longFromBytes(paramArrayOfByte, 0, false);
      long l2 = longFromBytes(paramArrayOfByte, 8, false);
      TPNativeLog.printLog(2, "isCryptoSchemeSupportedWithMimeType, MediaDrm create start.");
      try
      {
        paramArrayOfByte = new MediaDrm(new UUID(l1, l2));
        if (Build.VERSION.SDK_INT >= 28) {
          paramArrayOfByte.close();
        } else {
          paramArrayOfByte.release();
        }
        TPNativeLog.printLog(2, "isCryptoSchemeSupportedWithMimeType, MediaDrm release finished.");
        if (Build.VERSION.SDK_INT >= 19) {
          return MediaDrm.isCryptoSchemeSupported(new UUID(l1, l2), paramString);
        }
        if (Build.VERSION.SDK_INT == 18) {
          return MediaDrm.isCryptoSchemeSupported(new UUID(l1, l2));
        }
        return false;
      }
      catch (UnsupportedSchemeException paramArrayOfByte)
      {
        TPNativeLog.printLog(3, paramArrayOfByte.getMessage());
        return false;
      }
      return false;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  private static long longFromBytes(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      int j;
      if (paramBoolean) {
        j = i;
      } else {
        j = 7 - i;
      }
      j <<= 3;
      l |= 255L << j & paramArrayOfByte[(paramInt + i)] << j;
      i += 1;
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
    try
    {
      paramArrayOfByte1 = this.mMediaDrm.getKeyRequest(paramArrayOfByte1, paramArrayOfByte2, paramString, paramInt, null);
      if (Build.VERSION.SDK_INT >= 23) {
        paramInt = paramArrayOfByte1.getRequestType();
      } else {
        paramInt = 0;
      }
      return new TPMediaDrmProxy.KeyRequest(paramInt, paramArrayOfByte1.getData(), 0);
    }
    catch (NotProvisionedException paramArrayOfByte1)
    {
      label49:
      break label49;
    }
    return new TPMediaDrmProxy.KeyRequest(-1, null, -1);
  }
  
  public MediaCrypto getMediaCrypto(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new MediaCrypto(this.mUUID, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (MediaCryptoException paramArrayOfByte)
    {
      label15:
      break label15;
    }
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
    try
    {
      byte[] arrayOfByte = this.mMediaDrm.openSession();
      i = 0;
      localObject = arrayOfByte;
    }
    catch (NotProvisionedException localNotProvisionedException)
    {
      int i;
      break label23;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    i = -2;
    break label25;
    label23:
    i = -1;
    label25:
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
      break label15;
    }
    catch (DeniedByServerException paramArrayOfByte1)
    {
      label12:
      label15:
      break label12;
    }
    return -2;
    return -1;
  }
  
  public int provideProvisionResponse(byte[] paramArrayOfByte)
  {
    try
    {
      this.mMediaDrm.provideProvisionResponse(paramArrayOfByte);
      return 0;
    }
    catch (DeniedByServerException paramArrayOfByte)
    {
      label10:
      break label10;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.TPMediaDrmProxy
 * JD-Core Version:    0.7.0.1
 */