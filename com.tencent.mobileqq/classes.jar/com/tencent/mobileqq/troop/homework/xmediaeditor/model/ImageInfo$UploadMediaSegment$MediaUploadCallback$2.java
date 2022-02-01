package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bfer;
import bfet;
import bfeu;
import bffs;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$2
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$2(bfeu parambfeu, int paramInt) {}
  
  public void run()
  {
    bfet.a(this.jdField_a_of_type_Bfeu.a).e = this.jdField_a_of_type_Int;
    Object localObject = (XMediaEditor)bfet.a(this.jdField_a_of_type_Bfeu.a).get();
    if (localObject != null)
    {
      localObject = ((XMediaEditor)localObject).findViewHolderForLayoutPosition(bfet.a(this.jdField_a_of_type_Bfeu.a).c);
      if ((localObject instanceof bffs))
      {
        localObject = (bffs)localObject;
        if (bfet.a(this.jdField_a_of_type_Bfeu.a).d.equals(((bffs)localObject).a.getTag()))
        {
          ((bffs)localObject).a.setVisibility(0);
          ((bffs)localObject).a.setDrawStatus(1);
          ((bffs)localObject).a.setAnimProgress(bfet.a(this.jdField_a_of_type_Bfeu.a).e, bfet.a(this.jdField_a_of_type_Bfeu.a).d);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */