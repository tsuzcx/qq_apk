package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import babl;
import babn;
import babo;
import bacm;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$2
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$2(babo parambabo, int paramInt) {}
  
  public void run()
  {
    babn.a(this.jdField_a_of_type_Babo.a).e = this.jdField_a_of_type_Int;
    Object localObject = (XMediaEditor)babn.a(this.jdField_a_of_type_Babo.a).get();
    if (localObject != null)
    {
      localObject = ((XMediaEditor)localObject).findViewHolderForLayoutPosition(babn.a(this.jdField_a_of_type_Babo.a).c);
      if ((localObject instanceof bacm))
      {
        localObject = (bacm)localObject;
        if (babn.a(this.jdField_a_of_type_Babo.a).d.equals(((bacm)localObject).a.getTag()))
        {
          ((bacm)localObject).a.setVisibility(0);
          ((bacm)localObject).a.setDrawStatus(1);
          ((bacm)localObject).a.setAnimProgress(babn.a(this.jdField_a_of_type_Babo.a).e, babn.a(this.jdField_a_of_type_Babo.a).d);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */