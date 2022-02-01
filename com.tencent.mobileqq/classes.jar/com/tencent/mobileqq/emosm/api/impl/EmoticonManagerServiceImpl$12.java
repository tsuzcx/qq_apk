package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryTask.Query;

class EmoticonManagerServiceImpl$12
  implements QueryTask.Query<MarkFaceMessage, PicEmoticonInfo>
{
  EmoticonManagerServiceImpl$12(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, MarkFaceMessage paramMarkFaceMessage) {}
  
  public PicEmoticonInfo a(MarkFaceMessage paramMarkFaceMessage)
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplEmoticonManagerServiceImpl.syncGetEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.12
 * JD-Core Version:    0.7.0.1
 */