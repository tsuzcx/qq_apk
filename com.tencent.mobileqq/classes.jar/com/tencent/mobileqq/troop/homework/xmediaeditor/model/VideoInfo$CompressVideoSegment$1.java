package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import babc;
import babr;
import babs;
import bace;
import bacm;
import bacw;
import bacz;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class VideoInfo$CompressVideoSegment$1
  implements Runnable
{
  public VideoInfo$CompressVideoSegment$1(babs parambabs, babr parambabr, XMediaEditor paramXMediaEditor) {}
  
  public void run()
  {
    this.jdField_a_of_type_Babr.e = 10;
    this.jdField_a_of_type_Babr.g = -2147483647;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Babr.c);
    if ((localObject instanceof bacz))
    {
      localObject = (bacz)localObject;
      if (this.jdField_a_of_type_Babr.d.equals(((bacz)localObject).a.getTag()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideo before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        ((bacw)((babc)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bacm)localObject, this.jdField_a_of_type_Babr, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment.1
 * JD-Core Version:    0.7.0.1
 */