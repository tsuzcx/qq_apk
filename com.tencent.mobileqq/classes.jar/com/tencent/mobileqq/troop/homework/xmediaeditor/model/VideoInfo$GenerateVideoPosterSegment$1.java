package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import baao;
import babd;
import babf;
import babq;
import baby;
import baci;
import bacl;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VideoInfo$GenerateVideoPosterSegment$1
  implements Runnable
{
  public VideoInfo$GenerateVideoPosterSegment$1(babf parambabf, babd parambabd, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Babd.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Babd.e = 5;
    this.jdField_a_of_type_Babd.g = -2147483646;
    XMediaEditor localXMediaEditor = (XMediaEditor)babf.a(this.this$0).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Babd.c);
      if ((localObject instanceof bacl))
      {
        localObject = (bacl)localObject;
        if (this.jdField_a_of_type_Babd.d.equals(((bacl)localObject).a.getTag()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GeneratePoster before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
          }
          ((baci)((baao)localXMediaEditor.getAdapter()).a.a(2)).a((baby)localObject, this.jdField_a_of_type_Babd, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1
 * JD-Core Version:    0.7.0.1
 */