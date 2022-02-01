package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bfun;
import bfvc;
import bfvd;
import bfvp;
import bfvx;
import bfwh;
import bfwk;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class VideoInfo$CompressVideoSegment$1
  implements Runnable
{
  public VideoInfo$CompressVideoSegment$1(bfvd parambfvd, bfvc parambfvc, XMediaEditor paramXMediaEditor) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bfvc.e = 10;
    this.jdField_a_of_type_Bfvc.g = -2147483647;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bfvc.c);
    if ((localObject instanceof bfwk))
    {
      localObject = (bfwk)localObject;
      if (this.jdField_a_of_type_Bfvc.d.equals(((bfwk)localObject).a.getTag()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideo before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        ((bfwh)((bfun)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bfvx)localObject, this.jdField_a_of_type_Bfvc, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment.1
 * JD-Core Version:    0.7.0.1
 */