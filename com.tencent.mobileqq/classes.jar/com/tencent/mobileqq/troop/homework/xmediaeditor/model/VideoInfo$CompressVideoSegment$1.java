package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bgec;
import bger;
import bges;
import bgfe;
import bgfm;
import bgfw;
import bgfz;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class VideoInfo$CompressVideoSegment$1
  implements Runnable
{
  public VideoInfo$CompressVideoSegment$1(bges parambges, bger parambger, XMediaEditor paramXMediaEditor) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bger.e = 10;
    this.jdField_a_of_type_Bger.g = -2147483647;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bger.c);
    if ((localObject instanceof bgfz))
    {
      localObject = (bgfz)localObject;
      if (this.jdField_a_of_type_Bger.d.equals(((bgfz)localObject).a.getTag()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideo before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        ((bgfw)((bgec)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bgfm)localObject, this.jdField_a_of_type_Bger, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment.1
 * JD-Core Version:    0.7.0.1
 */