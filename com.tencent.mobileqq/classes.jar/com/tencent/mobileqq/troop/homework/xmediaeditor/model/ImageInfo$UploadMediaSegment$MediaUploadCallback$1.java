package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bfei;
import bfer;
import bfet;
import bfeu;
import bfex;
import bffk;
import bffs;
import bfgc;
import bfgf;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$1
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$1(bfeu parambfeu, bfex parambfex) {}
  
  public void run()
  {
    bfet.a(this.jdField_a_of_type_Bfeu.a).e = 95;
    bfet.a(this.jdField_a_of_type_Bfeu.a).g = -2147483648;
    XMediaEditor localXMediaEditor = (XMediaEditor)bfet.a(this.jdField_a_of_type_Bfeu.a).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(bfet.a(this.jdField_a_of_type_Bfeu.a).c);
      if ((localObject instanceof bfgf))
      {
        localObject = (bfgf)localObject;
        if (this.jdField_a_of_type_Bfex.d.equals(((bfgf)localObject).a.getTag())) {
          ((bfgc)((bfei)localXMediaEditor.getAdapter()).a.a(2)).a((bffs)localObject, bfet.a(this.jdField_a_of_type_Bfeu.a), 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */