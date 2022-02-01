package com.tencent.mobileqq.location.ui;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.model.FaceItem;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class LocationAvatarHelper
{
  private static volatile LocationAvatarHelper a;
  private final HashMap<String, FaceItem> b = new HashMap(10);
  private final IFaceDecoder c;
  
  private LocationAvatarHelper()
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.c = ((IQQAvatarService)localAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(localAppInterface);
  }
  
  public static LocationAvatarHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new LocationAvatarHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (FaceItem)this.b.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((FaceItem)localObject2).a < 4000L) && (((FaceItem)localObject2).c != null)) {
        return ((FaceItem)localObject2).c;
      }
      localObject1 = localObject2;
      if (l - ((FaceItem)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new FaceItem();
      this.b.put(paramString, localObject1);
    }
    ((FaceItem)localObject1).b = l;
    localObject2 = this.c.getBitmapFromCache(1, paramString);
    if (localObject2 == null)
    {
      this.c.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
      return localObject2;
    }
    ((FaceItem)localObject1).a = l;
    ((FaceItem)localObject1).c = ((Bitmap)localObject2);
    return localObject2;
  }
  
  public void a(DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this.c.setDecodeTaskCompletionListener(paramDecodeTaskCompletionListener);
  }
  
  public void a(String paramString, FaceItem paramFaceItem)
  {
    this.b.put(paramString, paramFaceItem);
  }
  
  public FaceItem b(String paramString)
  {
    return (FaceItem)this.b.get(paramString);
  }
  
  public void b()
  {
    IFaceDecoder localIFaceDecoder = this.c;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationAvatarHelper
 * JD-Core Version:    0.7.0.1
 */