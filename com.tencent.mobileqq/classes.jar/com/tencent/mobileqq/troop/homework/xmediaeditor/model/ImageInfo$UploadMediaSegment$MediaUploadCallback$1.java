package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bbzl;
import bbzu;
import bbzw;
import bbzx;
import bcaa;
import bcan;
import bcav;
import bcbf;
import bcbi;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$1
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$1(bbzx parambbzx, bcaa parambcaa) {}
  
  public void run()
  {
    bbzw.a(this.jdField_a_of_type_Bbzx.a).e = 95;
    bbzw.a(this.jdField_a_of_type_Bbzx.a).g = -2147483648;
    XMediaEditor localXMediaEditor = (XMediaEditor)bbzw.a(this.jdField_a_of_type_Bbzx.a).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(bbzw.a(this.jdField_a_of_type_Bbzx.a).c);
      if ((localObject instanceof bcbi))
      {
        localObject = (bcbi)localObject;
        if (this.jdField_a_of_type_Bcaa.d.equals(((bcbi)localObject).a.getTag())) {
          ((bcbf)((bbzl)localXMediaEditor.getAdapter()).a.a(2)).a((bcav)localObject, bbzw.a(this.jdField_a_of_type_Bbzx.a), 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */