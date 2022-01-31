package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import ayzw;
import azaf;
import azah;
import azai;
import azal;
import azay;
import azbg;
import azbq;
import azbt;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$1
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$1(azai paramazai, azal paramazal) {}
  
  public void run()
  {
    azah.a(this.jdField_a_of_type_Azai.a).e = 95;
    azah.a(this.jdField_a_of_type_Azai.a).g = -2147483648;
    XMediaEditor localXMediaEditor = (XMediaEditor)azah.a(this.jdField_a_of_type_Azai.a).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(azah.a(this.jdField_a_of_type_Azai.a).c);
      if ((localObject instanceof azbt))
      {
        localObject = (azbt)localObject;
        if (this.jdField_a_of_type_Azal.d.equals(((azbt)localObject).a.getTag())) {
          ((azbq)((ayzw)localXMediaEditor.getAdapter()).a.a(2)).a((azbg)localObject, azah.a(this.jdField_a_of_type_Azai.a), 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */