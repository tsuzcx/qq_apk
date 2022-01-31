package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bcdu;
import bcej;
import bcel;
import bcew;
import bcfe;
import bcfo;
import bcfr;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VideoInfo$GenerateVideoPosterSegment$1
  implements Runnable
{
  public VideoInfo$GenerateVideoPosterSegment$1(bcel parambcel, bcej parambcej, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bcej.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bcej.e = 5;
    this.jdField_a_of_type_Bcej.g = -2147483646;
    XMediaEditor localXMediaEditor = (XMediaEditor)bcel.a(this.this$0).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bcej.c);
      if ((localObject instanceof bcfr))
      {
        localObject = (bcfr)localObject;
        if (this.jdField_a_of_type_Bcej.d.equals(((bcfr)localObject).a.getTag()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GeneratePoster before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
          }
          ((bcfo)((bcdu)localXMediaEditor.getAdapter()).a.a(2)).a((bcfe)localObject, this.jdField_a_of_type_Bcej, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1
 * JD-Core Version:    0.7.0.1
 */