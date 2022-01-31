package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import ayzw;
import azal;
import azan;
import azay;
import azbg;
import azbq;
import azbt;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VideoInfo$GenerateVideoPosterSegment$1
  implements Runnable
{
  public VideoInfo$GenerateVideoPosterSegment$1(azan paramazan, azal paramazal, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Azal.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Azal.e = 5;
    this.jdField_a_of_type_Azal.g = -2147483646;
    XMediaEditor localXMediaEditor = (XMediaEditor)azan.a(this.this$0).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Azal.c);
      if ((localObject instanceof azbt))
      {
        localObject = (azbt)localObject;
        if (this.jdField_a_of_type_Azal.d.equals(((azbt)localObject).a.getTag()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GeneratePoster before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
          }
          ((azbq)((ayzw)localXMediaEditor.getAdapter()).a.a(2)).a((azbg)localObject, this.jdField_a_of_type_Azal, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1
 * JD-Core Version:    0.7.0.1
 */