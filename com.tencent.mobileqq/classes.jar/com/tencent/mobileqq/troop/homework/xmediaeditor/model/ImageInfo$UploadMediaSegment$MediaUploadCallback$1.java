package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bgec;
import bgel;
import bgen;
import bgeo;
import bger;
import bgfe;
import bgfm;
import bgfw;
import bgfz;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$1
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$1(bgeo parambgeo, bger parambger) {}
  
  public void run()
  {
    bgen.a(this.jdField_a_of_type_Bgeo.a).e = 95;
    bgen.a(this.jdField_a_of_type_Bgeo.a).g = -2147483648;
    XMediaEditor localXMediaEditor = (XMediaEditor)bgen.a(this.jdField_a_of_type_Bgeo.a).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(bgen.a(this.jdField_a_of_type_Bgeo.a).c);
      if ((localObject instanceof bgfz))
      {
        localObject = (bgfz)localObject;
        if (this.jdField_a_of_type_Bger.d.equals(((bgfz)localObject).a.getTag())) {
          ((bgfw)((bgec)localXMediaEditor.getAdapter()).a.a(2)).a((bgfm)localObject, bgen.a(this.jdField_a_of_type_Bgeo.a), 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */