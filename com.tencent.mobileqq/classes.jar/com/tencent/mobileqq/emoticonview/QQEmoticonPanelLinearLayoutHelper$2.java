package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class QQEmoticonPanelLinearLayoutHelper$2
  implements QueryCallback<EmoticonPackage>
{
  QQEmoticonPanelLinearLayoutHelper$2(QQEmoticonPanelLinearLayoutHelper paramQQEmoticonPanelLinearLayoutHelper, Emoticon paramEmoticon, EmoticonInfo paramEmoticonInfo, PicEmoticonInfo paramPicEmoticonInfo) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null)
    {
      if (QLog.isColorLevel())
      {
        paramEmoticonPackage = new StringBuilder();
        paramEmoticonPackage.append("package is null, epId: ");
        paramEmoticonPackage.append(this.val$emoticon.epId);
        QLog.d("EmotionPanelLinearLayout", 2, paramEmoticonPackage.toString());
      }
      return;
    }
    EmoticonCallback localEmoticonCallback = QQEmoticonPanelLinearLayoutHelper.access$100(this.this$0);
    if (localEmoticonCallback != null) {
      localEmoticonCallback.send(this.val$infoFinal);
    }
    if (this.val$emoticonInfo.srcType == 2)
    {
      if ((paramEmoticonPackage.jobType == 0) && (paramEmoticonPackage.subType == 4))
      {
        ReportController.b(QQEmoticonPanelLinearLayoutHelper.access$200(this.this$0).getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "3", "");
        return;
      }
      ReportController.b(QQEmoticonPanelLinearLayoutHelper.access$200(this.this$0).getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "2", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper.2
 * JD-Core Version:    0.7.0.1
 */