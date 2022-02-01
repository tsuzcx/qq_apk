package com.tencent.mobileqq.model;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;

class EmoticonManager$4
  implements QueryCallback<PicEmoticonInfo>
{
  EmoticonManager$4(EmoticonManager paramEmoticonManager, boolean paramBoolean, SessionInfo paramSessionInfo) {}
  
  public void a(PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.emoticon != null))
    {
      if (this.jdField_a_of_type_Boolean) {
        EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a, "0X800A937", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramPicEmoticonInfo.emoticon.epId);
      }
    }
    else {
      return;
    }
    EmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a, "0X800A936", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramPicEmoticonInfo.emoticon.epId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.4
 * JD-Core Version:    0.7.0.1
 */