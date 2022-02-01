package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class SogouEmoji$5
  implements QueryCallback<EmoticonPackage>
{
  SogouEmoji$5(SogouEmoji paramSogouEmoji, PicEmoticonInfo paramPicEmoticonInfo) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.imageType = paramEmoticonPackage.type;
      PicEmoticonInfo localPicEmoticonInfo = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
      boolean bool;
      if (paramEmoticonPackage.isAPNG == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localPicEmoticonInfo.isAPNG = bool;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.imageType = 3;
    }
    ((IEmosmService)QRoute.api(IEmosmService.class)).sendInfoFromPanelHelper(SogouEmoji.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji), this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo);
    if (QLog.isColorLevel())
    {
      paramEmoticonPackage = new StringBuilder();
      paramEmoticonPackage.append("func sendEmoji ends, type:");
      paramEmoticonPackage.append(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.imageType);
      QLog.d("SogouEmoji", 2, paramEmoticonPackage.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.SogouEmoji.5
 * JD-Core Version:    0.7.0.1
 */