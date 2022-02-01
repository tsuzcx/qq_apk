package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.model.QueryTask.Query;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class ReadInJoyBaseDeliverActivity$7
  implements QueryTask.Query<ISmallEmoticonInfo, char[]>
{
  public char[] a(ISmallEmoticonInfo paramISmallEmoticonInfo)
  {
    try
    {
      int i = Integer.parseInt(paramISmallEmoticonInfo.getEmoticon().eId);
      int j = Integer.parseInt(paramISmallEmoticonInfo.getEmoticon().epId);
      Object localObject = EmosmUtils.b(j, i);
      paramISmallEmoticonInfo = new char[5];
      paramISmallEmoticonInfo[0] = 20;
      paramISmallEmoticonInfo[1] = localObject[3];
      paramISmallEmoticonInfo[2] = localObject[2];
      paramISmallEmoticonInfo[3] = localObject[1];
      paramISmallEmoticonInfo[4] = localObject[0];
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((IEmoticonManagerService)((AppRuntime)localObject).getRuntimeService(IEmoticonManagerService.class, "")).syncFindEmoticonPackageById(String.valueOf(j));
        if ((localObject != null) && (((EmoticonPackage)localObject).isAPNG == 2)) {
          paramISmallEmoticonInfo[1] = 511;
        }
      }
      return paramISmallEmoticonInfo;
    }
    catch (NumberFormatException paramISmallEmoticonInfo)
    {
      label131:
      break label131;
    }
    QLog.e("ReadInJoyBaseDeliverActivity", 1, "kandian fail to send small_emotion. id is not Int.");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity.7
 * JD-Core Version:    0.7.0.1
 */