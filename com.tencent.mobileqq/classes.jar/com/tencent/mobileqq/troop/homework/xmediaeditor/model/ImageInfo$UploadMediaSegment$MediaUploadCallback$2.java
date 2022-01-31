package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import azaf;
import azah;
import azai;
import azbg;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$2
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$2(azai paramazai, int paramInt) {}
  
  public void run()
  {
    azah.a(this.jdField_a_of_type_Azai.a).e = this.jdField_a_of_type_Int;
    Object localObject = (XMediaEditor)azah.a(this.jdField_a_of_type_Azai.a).get();
    if (localObject != null)
    {
      localObject = ((XMediaEditor)localObject).findViewHolderForLayoutPosition(azah.a(this.jdField_a_of_type_Azai.a).c);
      if ((localObject instanceof azbg))
      {
        localObject = (azbg)localObject;
        if (azah.a(this.jdField_a_of_type_Azai.a).d.equals(((azbg)localObject).a.getTag()))
        {
          ((azbg)localObject).a.setVisibility(0);
          ((azbg)localObject).a.setDrawStatus(1);
          ((azbg)localObject).a.setAnimProgress(azah.a(this.jdField_a_of_type_Azai.a).e, azah.a(this.jdField_a_of_type_Azai.a).d);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */