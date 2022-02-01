package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import com.tencent.mobileqq.kandian.biz.ugc.AlbumUtils.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class SelectVideoPresenter$3
  implements ConditionChecker.ConditionCallback<AlbumUtils.LocalMediaInfo>
{
  SelectVideoPresenter$3(SelectVideoPresenter paramSelectVideoPresenter) {}
  
  public boolean a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    boolean bool2 = false;
    try
    {
      paramLocalMediaInfo = new File(paramLocalMediaInfo.b);
      boolean bool1 = bool2;
      if (paramLocalMediaInfo.isFile())
      {
        boolean bool3 = paramLocalMediaInfo.exists();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable paramLocalMediaInfo)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "SelectVideoPresenter check error, file not found", paramLocalMediaInfo);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoPresenter.3
 * JD-Core Version:    0.7.0.1
 */