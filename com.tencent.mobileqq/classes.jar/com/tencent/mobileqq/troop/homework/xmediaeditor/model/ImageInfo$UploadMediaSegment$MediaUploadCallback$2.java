package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bfuw;
import bfuy;
import bfuz;
import bfvx;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$2
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$2(bfuz parambfuz, int paramInt) {}
  
  public void run()
  {
    bfuy.a(this.jdField_a_of_type_Bfuz.a).e = this.jdField_a_of_type_Int;
    Object localObject = (XMediaEditor)bfuy.a(this.jdField_a_of_type_Bfuz.a).get();
    if (localObject != null)
    {
      localObject = ((XMediaEditor)localObject).findViewHolderForLayoutPosition(bfuy.a(this.jdField_a_of_type_Bfuz.a).c);
      if ((localObject instanceof bfvx))
      {
        localObject = (bfvx)localObject;
        if (bfuy.a(this.jdField_a_of_type_Bfuz.a).d.equals(((bfvx)localObject).a.getTag()))
        {
          ((bfvx)localObject).a.setVisibility(0);
          ((bfvx)localObject).a.setDrawStatus(1);
          ((bfvx)localObject).a.setAnimProgress(bfuy.a(this.jdField_a_of_type_Bfuz.a).e, bfuy.a(this.jdField_a_of_type_Bfuz.a).d);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */