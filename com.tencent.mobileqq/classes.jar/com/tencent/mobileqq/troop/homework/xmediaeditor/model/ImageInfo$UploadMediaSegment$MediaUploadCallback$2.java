package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import baax;
import baaz;
import baba;
import baby;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$2
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$2(baba parambaba, int paramInt) {}
  
  public void run()
  {
    baaz.a(this.jdField_a_of_type_Baba.a).e = this.jdField_a_of_type_Int;
    Object localObject = (XMediaEditor)baaz.a(this.jdField_a_of_type_Baba.a).get();
    if (localObject != null)
    {
      localObject = ((XMediaEditor)localObject).findViewHolderForLayoutPosition(baaz.a(this.jdField_a_of_type_Baba.a).c);
      if ((localObject instanceof baby))
      {
        localObject = (baby)localObject;
        if (baaz.a(this.jdField_a_of_type_Baba.a).d.equals(((baby)localObject).a.getTag()))
        {
          ((baby)localObject).a.setVisibility(0);
          ((baby)localObject).a.setDrawStatus(1);
          ((baby)localObject).a.setAnimProgress(baaz.a(this.jdField_a_of_type_Baba.a).e, baaz.a(this.jdField_a_of_type_Baba.a).d);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */