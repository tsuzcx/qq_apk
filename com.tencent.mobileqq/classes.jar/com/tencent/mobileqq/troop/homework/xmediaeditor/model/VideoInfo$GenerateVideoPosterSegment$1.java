package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bfei;
import bfex;
import bfez;
import bffk;
import bffs;
import bfgc;
import bfgf;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VideoInfo$GenerateVideoPosterSegment$1
  implements Runnable
{
  public VideoInfo$GenerateVideoPosterSegment$1(bfez parambfez, bfex parambfex, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bfex.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bfex.e = 5;
    this.jdField_a_of_type_Bfex.g = -2147483646;
    XMediaEditor localXMediaEditor = (XMediaEditor)bfez.a(this.this$0).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bfex.c);
      if ((localObject instanceof bfgf))
      {
        localObject = (bfgf)localObject;
        if (this.jdField_a_of_type_Bfex.d.equals(((bfgf)localObject).a.getTag()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GeneratePoster before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
          }
          ((bfgc)((bfei)localXMediaEditor.getAdapter()).a.a(2)).a((bffs)localObject, this.jdField_a_of_type_Bfex, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1
 * JD-Core Version:    0.7.0.1
 */