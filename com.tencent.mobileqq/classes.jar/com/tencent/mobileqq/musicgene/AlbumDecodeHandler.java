package com.tencent.mobileqq.musicgene;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlbumDecodeHandler
  implements DownloadParams.DecodeHandler
{
  private static final HashMap<String, ArrayList<Integer>> d = new HashMap();
  WeakReference<AlbumDecodeHandler.OnDecodeCompleteCallback> a;
  Object b;
  String c;
  
  public AlbumDecodeHandler(String paramString, AlbumDecodeHandler.OnDecodeCompleteCallback paramOnDecodeCompleteCallback, Object paramObject)
  {
    if (paramOnDecodeCompleteCallback != null) {
      this.a = new WeakReference(paramOnDecodeCompleteCallback);
    }
    this.c = paramString;
    this.b = paramObject;
  }
  
  public static List<Integer> a(String paramString)
  {
    return (List)d.get(paramString);
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    paramDownloadParams = this.a;
    if (paramDownloadParams == null) {
      paramDownloadParams = null;
    } else {
      paramDownloadParams = (AlbumDecodeHandler.OnDecodeCompleteCallback)paramDownloadParams.get();
    }
    if (paramDownloadParams != null)
    {
      int[] arrayOfInt = BitmapOptionUtil.a(Bitmap.createBitmap(paramBitmap, 0, paramBitmap.getHeight() / 2, paramBitmap.getWidth(), paramBitmap.getHeight() / 2));
      if ((arrayOfInt != null) && (arrayOfInt.length >= 2))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(arrayOfInt[0]));
        localArrayList.add(Integer.valueOf(arrayOfInt[1]));
        if (!d.containsKey(this.c)) {
          d.put(this.c, localArrayList);
        }
      }
      paramDownloadParams.a(this.c, arrayOfInt[0], arrayOfInt[1], this.b);
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.AlbumDecodeHandler
 * JD-Core Version:    0.7.0.1
 */