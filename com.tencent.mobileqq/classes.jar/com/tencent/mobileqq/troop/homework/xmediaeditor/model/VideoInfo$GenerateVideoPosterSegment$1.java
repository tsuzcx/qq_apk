package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bfun;
import bfvc;
import bfve;
import bfvp;
import bfvx;
import bfwh;
import bfwk;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VideoInfo$GenerateVideoPosterSegment$1
  implements Runnable
{
  public VideoInfo$GenerateVideoPosterSegment$1(bfve parambfve, bfvc parambfvc, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bfvc.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bfvc.e = 5;
    this.jdField_a_of_type_Bfvc.g = -2147483646;
    XMediaEditor localXMediaEditor = (XMediaEditor)bfve.a(this.this$0).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bfvc.c);
      if ((localObject instanceof bfwk))
      {
        localObject = (bfwk)localObject;
        if (this.jdField_a_of_type_Bfvc.d.equals(((bfwk)localObject).a.getTag()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GeneratePoster before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
          }
          ((bfwh)((bfun)localXMediaEditor.getAdapter()).a.a(2)).a((bfvx)localObject, this.jdField_a_of_type_Bfvc, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1
 * JD-Core Version:    0.7.0.1
 */