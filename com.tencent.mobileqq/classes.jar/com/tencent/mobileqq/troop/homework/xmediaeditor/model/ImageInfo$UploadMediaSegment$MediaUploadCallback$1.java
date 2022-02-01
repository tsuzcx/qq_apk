package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import benk;
import bent;
import benv;
import benw;
import benz;
import beom;
import beou;
import bepe;
import beph;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$1
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$1(benw parambenw, benz parambenz) {}
  
  public void run()
  {
    benv.a(this.jdField_a_of_type_Benw.a).e = 95;
    benv.a(this.jdField_a_of_type_Benw.a).g = -2147483648;
    XMediaEditor localXMediaEditor = (XMediaEditor)benv.a(this.jdField_a_of_type_Benw.a).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(benv.a(this.jdField_a_of_type_Benw.a).c);
      if ((localObject instanceof beph))
      {
        localObject = (beph)localObject;
        if (this.jdField_a_of_type_Benz.d.equals(((beph)localObject).a.getTag())) {
          ((bepe)((benk)localXMediaEditor.getAdapter()).a.a(2)).a((beou)localObject, benv.a(this.jdField_a_of_type_Benw.a), 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */