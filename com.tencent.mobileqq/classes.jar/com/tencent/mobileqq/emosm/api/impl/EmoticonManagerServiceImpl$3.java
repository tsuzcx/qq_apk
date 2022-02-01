package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;

class EmoticonManagerServiceImpl$3
  implements QueryCallback<PicEmoticonInfo>
{
  EmoticonManagerServiceImpl$3(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, boolean paramBoolean, BaseSessionInfo paramBaseSessionInfo) {}
  
  public void a(PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.emoticon != null))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        EmoticonOperateReport.reportNewSoundEvent(this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplEmoticonManagerServiceImpl.app, "0X800A937", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a, paramPicEmoticonInfo.emoticon.epId);
        return;
      }
      EmoticonOperateReport.reportNewSoundEvent(this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplEmoticonManagerServiceImpl.app, "0X800A936", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.a, paramPicEmoticonInfo.emoticon.epId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */