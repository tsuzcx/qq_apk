package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bbzu;
import bbzw;
import bbzx;
import bcav;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$2
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$2(bbzx parambbzx, int paramInt) {}
  
  public void run()
  {
    bbzw.a(this.jdField_a_of_type_Bbzx.a).e = this.jdField_a_of_type_Int;
    Object localObject = (XMediaEditor)bbzw.a(this.jdField_a_of_type_Bbzx.a).get();
    if (localObject != null)
    {
      localObject = ((XMediaEditor)localObject).findViewHolderForLayoutPosition(bbzw.a(this.jdField_a_of_type_Bbzx.a).c);
      if ((localObject instanceof bcav))
      {
        localObject = (bcav)localObject;
        if (bbzw.a(this.jdField_a_of_type_Bbzx.a).d.equals(((bcav)localObject).a.getTag()))
        {
          ((bcav)localObject).a.setVisibility(0);
          ((bcav)localObject).a.setDrawStatus(1);
          ((bcav)localObject).a.setAnimProgress(bbzw.a(this.jdField_a_of_type_Bbzx.a).e, bbzw.a(this.jdField_a_of_type_Bbzx.a).d);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */