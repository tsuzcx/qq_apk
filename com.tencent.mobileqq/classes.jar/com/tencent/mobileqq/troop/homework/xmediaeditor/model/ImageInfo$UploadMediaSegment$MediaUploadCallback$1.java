package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import babc;
import babl;
import babn;
import babo;
import babr;
import bace;
import bacm;
import bacw;
import bacz;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$1
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$1(babo parambabo, babr parambabr) {}
  
  public void run()
  {
    babn.a(this.jdField_a_of_type_Babo.a).e = 95;
    babn.a(this.jdField_a_of_type_Babo.a).g = -2147483648;
    XMediaEditor localXMediaEditor = (XMediaEditor)babn.a(this.jdField_a_of_type_Babo.a).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(babn.a(this.jdField_a_of_type_Babo.a).c);
      if ((localObject instanceof bacz))
      {
        localObject = (bacz)localObject;
        if (this.jdField_a_of_type_Babr.d.equals(((bacz)localObject).a.getTag())) {
          ((bacw)((babc)localXMediaEditor.getAdapter()).a.a(2)).a((bacm)localObject, babn.a(this.jdField_a_of_type_Babo.a), 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */