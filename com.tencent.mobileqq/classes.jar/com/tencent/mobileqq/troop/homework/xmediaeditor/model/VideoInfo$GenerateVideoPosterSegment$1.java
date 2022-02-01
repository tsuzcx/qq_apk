package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bgec;
import bger;
import bget;
import bgfe;
import bgfm;
import bgfw;
import bgfz;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VideoInfo$GenerateVideoPosterSegment$1
  implements Runnable
{
  public VideoInfo$GenerateVideoPosterSegment$1(bget parambget, bger parambger, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bger.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bger.e = 5;
    this.jdField_a_of_type_Bger.g = -2147483646;
    XMediaEditor localXMediaEditor = (XMediaEditor)bget.a(this.this$0).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bger.c);
      if ((localObject instanceof bgfz))
      {
        localObject = (bgfz)localObject;
        if (this.jdField_a_of_type_Bger.d.equals(((bgfz)localObject).a.getTag()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GeneratePoster before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
          }
          ((bgfw)((bgec)localXMediaEditor.getAdapter()).a.a(2)).a((bgfm)localObject, this.jdField_a_of_type_Bger, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1
 * JD-Core Version:    0.7.0.1
 */