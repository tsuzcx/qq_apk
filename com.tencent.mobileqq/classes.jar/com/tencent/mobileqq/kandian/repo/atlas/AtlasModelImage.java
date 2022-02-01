package com.tencent.mobileqq.kandian.repo.atlas;

import com.tencent.image.URLDrawable;
import tencent.im.oidb.gallery.gallery.PictureInfo;

public class AtlasModelImage
  extends AtlasModel
{
  public static URLDrawable sAttachDrawable;
  public gallery.PictureInfo pictureInfo;
  public String rowKey;
  
  public AtlasModelImage(String paramString, gallery.PictureInfo paramPictureInfo)
  {
    this.type = 1;
    this.rowKey = paramString;
    this.pictureInfo = paramPictureInfo;
  }
  
  public static void clear()
  {
    sAttachDrawable = null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof AtlasModel;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (AtlasModel)paramObject;
      if ((paramObject.type != this.type) || (paramObject.position != this.position) || (this.jumpUrl != paramObject.jumpUrl))
      {
        bool1 = bool2;
        if (this.jumpUrl != null)
        {
          bool1 = bool2;
          if (!this.jumpUrl.equals(paramObject.jumpUrl)) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.atlas.AtlasModelImage
 * JD-Core Version:    0.7.0.1
 */