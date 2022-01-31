package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import ayzw;
import azal;
import azam;
import azay;
import azbg;
import azbq;
import azbt;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class VideoInfo$CompressVideoSegment$1
  implements Runnable
{
  public VideoInfo$CompressVideoSegment$1(azam paramazam, azal paramazal, XMediaEditor paramXMediaEditor) {}
  
  public void run()
  {
    this.jdField_a_of_type_Azal.e = 10;
    this.jdField_a_of_type_Azal.g = -2147483647;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Azal.c);
    if ((localObject instanceof azbt))
    {
      localObject = (azbt)localObject;
      if (this.jdField_a_of_type_Azal.d.equals(((azbt)localObject).a.getTag()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideo before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        ((azbq)((ayzw)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((azbg)localObject, this.jdField_a_of_type_Azal, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment.1
 * JD-Core Version:    0.7.0.1
 */