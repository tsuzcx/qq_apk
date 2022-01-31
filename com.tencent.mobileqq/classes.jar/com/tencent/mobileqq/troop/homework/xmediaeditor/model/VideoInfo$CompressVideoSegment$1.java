package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import bbzl;
import bcaa;
import bcab;
import bcan;
import bcav;
import bcbf;
import bcbi;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class VideoInfo$CompressVideoSegment$1
  implements Runnable
{
  public VideoInfo$CompressVideoSegment$1(bcab parambcab, bcaa parambcaa, XMediaEditor paramXMediaEditor) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bcaa.e = 10;
    this.jdField_a_of_type_Bcaa.g = -2147483647;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bcaa.c);
    if ((localObject instanceof bcbi))
    {
      localObject = (bcbi)localObject;
      if (this.jdField_a_of_type_Bcaa.d.equals(((bcbi)localObject).a.getTag()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideo before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        ((bcbf)((bbzl)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bcav)localObject, this.jdField_a_of_type_Bcaa, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment.1
 * JD-Core Version:    0.7.0.1
 */