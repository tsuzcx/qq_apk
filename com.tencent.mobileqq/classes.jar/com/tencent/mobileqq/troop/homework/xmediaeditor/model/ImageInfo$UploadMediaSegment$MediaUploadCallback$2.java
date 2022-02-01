package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bent;
import benv;
import benw;
import beou;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$2
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$2(benw parambenw, int paramInt) {}
  
  public void run()
  {
    benv.a(this.jdField_a_of_type_Benw.a).e = this.jdField_a_of_type_Int;
    Object localObject = (XMediaEditor)benv.a(this.jdField_a_of_type_Benw.a).get();
    if (localObject != null)
    {
      localObject = ((XMediaEditor)localObject).findViewHolderForLayoutPosition(benv.a(this.jdField_a_of_type_Benw.a).c);
      if ((localObject instanceof beou))
      {
        localObject = (beou)localObject;
        if (benv.a(this.jdField_a_of_type_Benw.a).d.equals(((beou)localObject).a.getTag()))
        {
          ((beou)localObject).a.setVisibility(0);
          ((beou)localObject).a.setDrawStatus(1);
          ((beou)localObject).a.setAnimProgress(benv.a(this.jdField_a_of_type_Benw.a).e, benv.a(this.jdField_a_of_type_Benw.a).d);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */