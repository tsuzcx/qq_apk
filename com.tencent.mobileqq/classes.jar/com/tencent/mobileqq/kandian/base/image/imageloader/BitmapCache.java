package com.tencent.mobileqq.kandian.base.image.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.kandian.base.image.BytePool;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.Releaser;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCache;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public class BitmapCache
  implements IBitmapCache
{
  public static final int DECODE_BUFFER_SIZE = 16384;
  public static final String TAG;
  private final List<SoftReference<Bitmap>> cachedForReuseBitmap = Collections.synchronizedList(new ArrayList());
  private final BytePool mPool = new BytePool(2097152);
  private final Releaser<Bitmap> mReleaser;
  private final List<byte[]> mTempBuffers = Collections.synchronizedList(new LinkedList());
  int reuseBitmapCount;
  int totalGetBitmap;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zimage.");
    localStringBuilder.append(BitmapCache.class.getSimpleName());
    TAG = localStringBuilder.toString();
  }
  
  public BitmapCache()
  {
    int i = 0;
    this.reuseBitmapCount = 0;
    this.totalGetBitmap = 0;
    while (i < 5)
    {
      addTempBuffer(new byte[16384]);
      i += 1;
    }
    this.mReleaser = new BitmapCache.1(this);
  }
  
  public void addTempBuffer(byte[] paramArrayOfByte)
  {
    this.mTempBuffers.add(paramArrayOfByte);
  }
  
  public void cacheBitmap(ImageRequest paramImageRequest, ICloseableBitmap paramICloseableBitmap)
  {
    if (paramImageRequest == null) {
      return;
    }
    try
    {
      putImageToCache(paramImageRequest.a(), paramICloseableBitmap);
      return;
    }
    finally
    {
      paramImageRequest = finally;
      throw paramImageRequest;
    }
  }
  
  public void clean()
  {
    try
    {
      this.mPool.a();
      this.cachedForReuseBitmap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Nullable
  public ICloseableBitmap getBitmap(ImageRequest paramImageRequest)
  {
    if (paramImageRequest == null) {
      return null;
    }
    paramImageRequest = getCloseableBitmapFromCache(paramImageRequest.a());
    if (paramImageRequest != null) {
      try
      {
        if (paramImageRequest.a())
        {
          CloseableBitmap localCloseableBitmap = paramImageRequest.a();
          return localCloseableBitmap;
        }
        return null;
      }
      finally {}
    }
    return null;
  }
  
  public BytePool getBytePool()
  {
    return this.mPool;
  }
  
  @Nullable
  public CloseableBitmap getCloseableBitmapFromCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (GlobalImageCache.a != null)
    {
      paramString = GlobalImageCache.a.get(paramString);
      if ((paramString instanceof CloseableBitmap)) {
        return (CloseableBitmap)paramString;
      }
    }
    return null;
  }
  
  public Releaser<Bitmap> getReleaser()
  {
    return this.mReleaser;
  }
  
  @Nullable
  public Bitmap getReusableBitmap(BitmapFactory.Options paramOptions)
  {
    try
    {
      this.totalGetBitmap += 1;
      str = null;
      localObject3 = "notFound";
      localArrayList = new ArrayList();
      localList = this.cachedForReuseBitmap;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        String str;
        Object localObject3;
        ArrayList localArrayList;
        List localList;
        int i;
        Object localObject1;
        Object localObject2;
        for (;;)
        {
          throw paramOptions;
        }
        label312:
        i += 1;
      }
    }
    localObject1 = str;
    localObject2 = localObject3;
    try
    {
      if (i < this.cachedForReuseBitmap.size())
      {
        localObject1 = (Bitmap)((SoftReference)this.cachedForReuseBitmap.get(i)).get();
        if (localObject1 != null)
        {
          if (!Utils.a((Bitmap)localObject1, paramOptions)) {
            break label312;
          }
          localObject2 = "cache";
          localArrayList.add(this.cachedForReuseBitmap.get(i));
        }
        else
        {
          localArrayList.add(this.cachedForReuseBitmap.get(i));
          break label312;
        }
      }
      if (!localArrayList.isEmpty()) {
        this.cachedForReuseBitmap.removeAll(localArrayList);
      }
      if (localObject1 != null) {
        this.reuseBitmapCount += 1;
      }
      if (QLog.isColorLevel())
      {
        str = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getReuseableBitmap found:");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(" picSize:");
        ((StringBuilder)localObject3).append(paramOptions.outWidth);
        ((StringBuilder)localObject3).append("x");
        ((StringBuilder)localObject3).append(paramOptions.outHeight);
        ((StringBuilder)localObject3).append(" bitmap:");
        ((StringBuilder)localObject3).append(localObject1);
        ((StringBuilder)localObject3).append(" state:");
        ((StringBuilder)localObject3).append(toString());
        Utils.a(str, ((StringBuilder)localObject3).toString());
      }
      return localObject1;
    }
    finally {}
  }
  
  public int getTempBufferSize()
  {
    return this.mTempBuffers.size();
  }
  
  public void putImageToCache(String paramString, ICloseableBitmap paramICloseableBitmap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramICloseableBitmap == null) {
        return;
      }
      if (GlobalImageCache.a != null) {
        GlobalImageCache.a.put(paramString, paramICloseableBitmap);
      }
    }
  }
  
  @Nullable
  public byte[] removeTempBuffer(int paramInt)
  {
    return (byte[])this.mTempBuffers.remove(paramInt);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("total:");
    localStringBuilder.append(this.totalGetBitmap);
    localStringBuilder.append(" reuse:");
    localStringBuilder.append(this.reuseBitmapCount);
    if (this.totalGetBitmap > 0)
    {
      localStringBuilder.append(" rate:");
      localStringBuilder.append(this.reuseBitmapCount / this.totalGetBitmap);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.imageloader.BitmapCache
 * JD-Core Version:    0.7.0.1
 */