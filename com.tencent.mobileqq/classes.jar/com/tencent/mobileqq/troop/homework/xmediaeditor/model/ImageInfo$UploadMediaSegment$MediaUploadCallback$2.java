package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bgel;
import bgen;
import bgeo;
import bgfm;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$2
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$2(bgeo parambgeo, int paramInt) {}
  
  public void run()
  {
    bgen.a(this.jdField_a_of_type_Bgeo.a).e = this.jdField_a_of_type_Int;
    Object localObject = (XMediaEditor)bgen.a(this.jdField_a_of_type_Bgeo.a).get();
    if (localObject != null)
    {
      localObject = ((XMediaEditor)localObject).findViewHolderForLayoutPosition(bgen.a(this.jdField_a_of_type_Bgeo.a).c);
      if ((localObject instanceof bgfm))
      {
        localObject = (bgfm)localObject;
        if (bgen.a(this.jdField_a_of_type_Bgeo.a).d.equals(((bgfm)localObject).a.getTag()))
        {
          ((bgfm)localObject).a.setVisibility(0);
          ((bgfm)localObject).a.setDrawStatus(1);
          ((bgfm)localObject).a.setAnimProgress(bgen.a(this.jdField_a_of_type_Bgeo.a).e, bgen.a(this.jdField_a_of_type_Bgeo.a).d);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */