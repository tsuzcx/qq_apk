package com.tencent.mobileqq.kandian.base.image.imageloader;

import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.base.image.Reference;
import com.tencent.mobileqq.kandian.base.image.Releaser;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class CloseableBitmap
  implements ICloseableBitmap
{
  private Reference<Bitmap> a;
  
  public CloseableBitmap(Bitmap paramBitmap, Releaser<Bitmap> paramReleaser)
  {
    this.a = new Reference(paramBitmap, paramReleaser);
    if (QLog.isColorLevel()) {
      Utils.a(toString(), "onCreate", true);
    }
  }
  
  public CloseableBitmap(Reference<Bitmap> paramReference)
  {
    paramReference.a();
    this.a = paramReference;
    if (QLog.isColorLevel()) {
      Utils.a(toString(), "createFromClone", true);
    }
  }
  
  public Bitmap a()
  {
    Reference localReference = this.a;
    if (localReference != null) {
      return (Bitmap)localReference.a();
    }
    ReportController.b(null, "dc01160", "", "", "0X80098F1", "0X80098F1", 0, 1, null, null, "", "");
    return null;
  }
  
  public CloseableBitmap a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        Utils.a(toString(), "clone", true);
      }
      CloseableBitmap localCloseableBitmap = new CloseableBitmap(this.a);
      return localCloseableBitmap;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      if (this.a != null)
      {
        if (QLog.isColorLevel()) {
          Utils.a(toString(), "close", true);
        }
        this.a.b();
        this.a = null;
      }
      else
      {
        Utils.a(toString(), "close twice");
      }
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zimage.closeable@");
    localStringBuilder.append(hashCode());
    localStringBuilder.append("_bitmap@");
    Object localObject = this.a;
    if ((localObject != null) && (((Reference)localObject).a() != null)) {
      localObject = Integer.valueOf(((Bitmap)this.a.a()).hashCode());
    } else {
      localObject = null;
    }
    localStringBuilder.append(localObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.imageloader.CloseableBitmap
 * JD-Core Version:    0.7.0.1
 */