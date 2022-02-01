package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bfun;
import bfuw;
import bfuy;
import bfuz;
import bfvc;
import bfvp;
import bfvx;
import bfwh;
import bfwk;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$1
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$1(bfuz parambfuz, bfvc parambfvc) {}
  
  public void run()
  {
    bfuy.a(this.jdField_a_of_type_Bfuz.a).e = 95;
    bfuy.a(this.jdField_a_of_type_Bfuz.a).g = -2147483648;
    XMediaEditor localXMediaEditor = (XMediaEditor)bfuy.a(this.jdField_a_of_type_Bfuz.a).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(bfuy.a(this.jdField_a_of_type_Bfuz.a).c);
      if ((localObject instanceof bfwk))
      {
        localObject = (bfwk)localObject;
        if (this.jdField_a_of_type_Bfvc.d.equals(((bfwk)localObject).a.getTag())) {
          ((bfwh)((bfun)localXMediaEditor.getAdapter()).a.a(2)).a((bfvx)localObject, bfuy.a(this.jdField_a_of_type_Bfuz.a), 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */