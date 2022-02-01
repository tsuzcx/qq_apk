package com.tencent.mobileqq.emoticonview;

import awzc;
import bdla;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class EmoticonPanelLinearLayout$2
  implements awzc<EmoticonPackage>
{
  EmoticonPanelLinearLayout$2(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout, Emoticon paramEmoticon, EmoticonInfo paramEmoticonInfo, PicEmoticonInfo paramPicEmoticonInfo) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelLinearLayout", 2, "package is null, epId: " + this.val$emoticon.epId);
      }
    }
    do
    {
      return;
      EmoticonCallback localEmoticonCallback = this.this$0.callback;
      if (localEmoticonCallback != null) {
        localEmoticonCallback.send(this.val$infoFinal);
      }
    } while (this.val$emoticonInfo.src_type != 2);
    if ((paramEmoticonPackage.jobType == 0) && (paramEmoticonPackage.subType == 4))
    {
      bdla.b(((BaseActivity)this.this$0.context).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "3", "");
      return;
    }
    bdla.b(((BaseActivity)this.this$0.context).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "2", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout.2
 * JD-Core Version:    0.7.0.1
 */