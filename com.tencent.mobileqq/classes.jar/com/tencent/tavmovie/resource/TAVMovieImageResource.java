package com.tencent.tavmovie.resource;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;

public class TAVMovieImageResource
  extends TAVMovieResource
{
  @NonNull
  private final String filePath;
  @Nullable
  private CIImage image;
  
  public TAVMovieImageResource(@NonNull String paramString)
  {
    this(paramString, null);
  }
  
  public TAVMovieImageResource(@NonNull String paramString, CGSize paramCGSize)
  {
    this(paramString, paramCGSize, true);
  }
  
  public TAVMovieImageResource(@NonNull String paramString, CGSize paramCGSize, boolean paramBoolean)
  {
    this.filePath = paramString;
    if (!paramBoolean) {
      this.image = new CIImage(paramString, paramCGSize);
    }
    for (this.naturalSize = new CGSize(this.image.getSize().width, this.image.getSize().height);; this.naturalSize = new CGSize(paramCGSize.outWidth, paramCGSize.outHeight))
    {
      this.duration = new CMTime(1L, 30);
      return;
      paramCGSize = new BitmapFactory.Options();
      paramCGSize.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, paramCGSize);
    }
  }
  
  public TAVMovieImageResource clone()
  {
    TAVMovieImageResource localTAVMovieImageResource = new TAVMovieImageResource(this.filePath);
    localTAVMovieImageResource.setImage(this.image);
    localTAVMovieImageResource.cloneFrom(this);
    return localTAVMovieImageResource;
  }
  
  public TAVResource convertToResource()
  {
    if (this.image != null) {}
    for (Object localObject = new TAVImageResource(this.image, this.duration);; localObject = new TAVImageTrackResource(this.filePath, this.duration))
    {
      if ((this.timeRange != null) && (this.timeRange.getDurationUs() > 0L)) {
        ((TAVResource)localObject).setSourceTimeRange(this.timeRange);
      }
      return localObject;
    }
  }
  
  public TAVMovieResource dataClone()
  {
    return clone();
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public CIImage getImage()
  {
    return this.image;
  }
  
  public void release()
  {
    if (this.image != null) {
      this.image.release();
    }
  }
  
  public void setImage(CIImage paramCIImage)
  {
    this.image = paramCIImage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavmovie.resource.TAVMovieImageResource
 * JD-Core Version:    0.7.0.1
 */