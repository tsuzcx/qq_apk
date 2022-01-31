package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import baao;
import baax;
import baaz;
import baba;
import babd;
import babq;
import baby;
import baci;
import bacl;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$1
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$1(baba parambaba, babd parambabd) {}
  
  public void run()
  {
    baaz.a(this.jdField_a_of_type_Baba.a).e = 95;
    baaz.a(this.jdField_a_of_type_Baba.a).g = -2147483648;
    XMediaEditor localXMediaEditor = (XMediaEditor)baaz.a(this.jdField_a_of_type_Baba.a).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(baaz.a(this.jdField_a_of_type_Baba.a).c);
      if ((localObject instanceof bacl))
      {
        localObject = (bacl)localObject;
        if (this.jdField_a_of_type_Babd.d.equals(((bacl)localObject).a.getTag())) {
          ((baci)((baao)localXMediaEditor.getAdapter()).a.a(2)).a((baby)localObject, baaz.a(this.jdField_a_of_type_Baba.a), 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */