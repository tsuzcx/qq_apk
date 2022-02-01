package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import benk;
import benz;
import beob;
import beom;
import beou;
import bepe;
import beph;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VideoInfo$GenerateVideoPosterSegment$1
  implements Runnable
{
  public VideoInfo$GenerateVideoPosterSegment$1(beob parambeob, benz parambenz, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Benz.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Benz.e = 5;
    this.jdField_a_of_type_Benz.g = -2147483646;
    XMediaEditor localXMediaEditor = (XMediaEditor)beob.a(this.this$0).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Benz.c);
      if ((localObject instanceof beph))
      {
        localObject = (beph)localObject;
        if (this.jdField_a_of_type_Benz.d.equals(((beph)localObject).a.getTag()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GeneratePoster before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
          }
          ((bepe)((benk)localXMediaEditor.getAdapter()).a.a(2)).a((beou)localObject, this.jdField_a_of_type_Benz, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1
 * JD-Core Version:    0.7.0.1
 */