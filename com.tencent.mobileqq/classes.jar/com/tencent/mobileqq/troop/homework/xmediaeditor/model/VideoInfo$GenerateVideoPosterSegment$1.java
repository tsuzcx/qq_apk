package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import babc;
import babr;
import babt;
import bace;
import bacm;
import bacw;
import bacz;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VideoInfo$GenerateVideoPosterSegment$1
  implements Runnable
{
  public VideoInfo$GenerateVideoPosterSegment$1(babt parambabt, babr parambabr, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Babr.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Babr.e = 5;
    this.jdField_a_of_type_Babr.g = -2147483646;
    XMediaEditor localXMediaEditor = (XMediaEditor)babt.a(this.this$0).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Babr.c);
      if ((localObject instanceof bacz))
      {
        localObject = (bacz)localObject;
        if (this.jdField_a_of_type_Babr.d.equals(((bacz)localObject).a.getTag()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GeneratePoster before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
          }
          ((bacw)((babc)localXMediaEditor.getAdapter()).a.a(2)).a((bacm)localObject, this.jdField_a_of_type_Babr, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1
 * JD-Core Version:    0.7.0.1
 */