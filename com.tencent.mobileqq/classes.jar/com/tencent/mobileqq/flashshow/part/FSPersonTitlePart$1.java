package com.tencent.mobileqq.flashshow.part;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalInfo;
import com.tencent.qphone.base.util.QLog;

class FSPersonTitlePart$1
  implements Observer<FSPersonalInfo>
{
  FSPersonTitlePart$1(FSPersonTitlePart paramFSPersonTitlePart) {}
  
  public void a(@Nullable FSPersonalInfo paramFSPersonalInfo)
  {
    if (paramFSPersonalInfo != null) {}
    try
    {
      if (paramFSPersonalInfo.a == null) {
        break label46;
      }
      FSPersonTitlePart.a(this.a, paramFSPersonalInfo.a);
      FSPersonTitlePart.b(this.a, FSPersonTitlePart.a(this.a));
      return;
    }
    catch (Exception paramFSPersonalInfo)
    {
      label38:
      label46:
      break label38;
    }
    QLog.e("FSTitlePart", 1, "getShareInfo error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSPersonTitlePart.1
 * JD-Core Version:    0.7.0.1
 */