package com.tencent.rtmp.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class b
  implements a
{
  private final BitmapFactory.Options a = new BitmapFactory.Options();
  private HandlerThread b;
  private Handler c;
  private List<c> d = new ArrayList();
  private Map<String, BitmapRegionDecoder> e = new HashMap();
  
  private c a(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = (paramInt2 - paramInt1) / 2 + paramInt1;
    if ((((c)this.d.get(i)).a <= paramFloat) && (((c)this.d.get(i)).b > paramFloat)) {
      return (c)this.d.get(i);
    }
    if (paramInt1 >= paramInt2) {
      return (c)this.d.get(paramInt1);
    }
    if (paramFloat >= ((c)this.d.get(i)).b) {
      return a(i + 1, paramInt2, paramFloat);
    }
    if (paramFloat < ((c)this.d.get(i)).a) {
      return a(paramInt1, i - 1, paramFloat);
    }
    return null;
  }
  
  private InputStream a(String paramString)
  {
    paramString = new URL(paramString).openConnection();
    paramString.connect();
    paramString.getInputStream();
    paramString.setConnectTimeout(15000);
    paramString.setReadTimeout(15000);
    return paramString.getInputStream();
  }
  
  private void a()
  {
    if (this.b == null)
    {
      this.b = new HandlerThread("SuperVodThumbnailsWorkThread");
      this.b.start();
      this.c = new Handler(this.b.getLooper());
    }
  }
  
  private void b()
  {
    if (this.c != null)
    {
      TXCLog.i("TXImageSprite", " remove all tasks!");
      this.c.removeCallbacksAndMessages(null);
      this.c.post(new b.1(this));
    }
  }
  
  public Bitmap getThumbnail(float paramFloat)
  {
    if (this.d.size() == 0) {
      return null;
    }
    c localc = a(0, this.d.size() - 1, paramFloat);
    if (localc == null) {
      return null;
    }
    Object localObject = localc.d;
    localObject = (BitmapRegionDecoder)this.e.get(localObject);
    if (localObject == null) {
      return null;
    }
    Rect localRect = new Rect();
    localRect.left = localc.e;
    localRect.top = localc.f;
    localRect.right = (localc.e + localc.g);
    localRect.bottom = (localc.f + localc.h);
    return ((BitmapRegionDecoder)localObject).decodeRegion(localRect, this.a);
  }
  
  public void release()
  {
    b();
    if ((this.b != null) && (this.c != null))
    {
      if (Build.VERSION.SDK_INT >= 18) {
        this.b.quitSafely();
      } else {
        this.b.quit();
      }
      this.c = null;
      this.b = null;
    }
  }
  
  public void setVTTUrlAndImageUrls(String paramString, List<String> paramList)
  {
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("TXImageSprite", "setVTTUrlAndImageUrls: vttUrl can't be null!");
      return;
    }
    b();
    a();
    this.c.post(new b.a(this, paramString));
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        this.c.post(new b.b(this, paramString, str));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.a.b
 * JD-Core Version:    0.7.0.1
 */