package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bced;
import bcef;
import bceg;
import bcfe;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$2
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$2(bceg parambceg, int paramInt) {}
  
  public void run()
  {
    bcef.a(this.jdField_a_of_type_Bceg.a).e = this.jdField_a_of_type_Int;
    Object localObject = (XMediaEditor)bcef.a(this.jdField_a_of_type_Bceg.a).get();
    if (localObject != null)
    {
      localObject = ((XMediaEditor)localObject).findViewHolderForLayoutPosition(bcef.a(this.jdField_a_of_type_Bceg.a).c);
      if ((localObject instanceof bcfe))
      {
        localObject = (bcfe)localObject;
        if (bcef.a(this.jdField_a_of_type_Bceg.a).d.equals(((bcfe)localObject).a.getTag()))
        {
          ((bcfe)localObject).a.setVisibility(0);
          ((bcfe)localObject).a.setDrawStatus(1);
          ((bcfe)localObject).a.setAnimProgress(bcef.a(this.jdField_a_of_type_Bceg.a).e, bcef.a(this.jdField_a_of_type_Bceg.a).d);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */