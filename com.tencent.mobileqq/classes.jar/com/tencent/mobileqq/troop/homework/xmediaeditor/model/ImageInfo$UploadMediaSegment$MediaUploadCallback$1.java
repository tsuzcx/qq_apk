package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bcdu;
import bced;
import bcef;
import bceg;
import bcej;
import bcew;
import bcfe;
import bcfo;
import bcfr;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$1
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$1(bceg parambceg, bcej parambcej) {}
  
  public void run()
  {
    bcef.a(this.jdField_a_of_type_Bceg.a).e = 95;
    bcef.a(this.jdField_a_of_type_Bceg.a).g = -2147483648;
    XMediaEditor localXMediaEditor = (XMediaEditor)bcef.a(this.jdField_a_of_type_Bceg.a).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(bcef.a(this.jdField_a_of_type_Bceg.a).c);
      if ((localObject instanceof bcfr))
      {
        localObject = (bcfr)localObject;
        if (this.jdField_a_of_type_Bcej.d.equals(((bcfr)localObject).a.getTag())) {
          ((bcfo)((bcdu)localXMediaEditor.getAdapter()).a.a(2)).a((bcfe)localObject, bcef.a(this.jdField_a_of_type_Bceg.a), 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */