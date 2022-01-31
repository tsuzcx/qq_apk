package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bbzl;
import bcaa;
import bcac;
import bcan;
import bcav;
import bcbf;
import bcbi;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VideoInfo$GenerateVideoPosterSegment$1
  implements Runnable
{
  public VideoInfo$GenerateVideoPosterSegment$1(bcac parambcac, bcaa parambcaa, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bcaa.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bcaa.e = 5;
    this.jdField_a_of_type_Bcaa.g = -2147483646;
    XMediaEditor localXMediaEditor = (XMediaEditor)bcac.a(this.this$0).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bcaa.c);
      if ((localObject instanceof bcbi))
      {
        localObject = (bcbi)localObject;
        if (this.jdField_a_of_type_Bcaa.d.equals(((bcbi)localObject).a.getTag()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GeneratePoster before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
          }
          ((bcbf)((bbzl)localXMediaEditor.getAdapter()).a.a(2)).a((bcav)localObject, this.jdField_a_of_type_Bcaa, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1
 * JD-Core Version:    0.7.0.1
 */