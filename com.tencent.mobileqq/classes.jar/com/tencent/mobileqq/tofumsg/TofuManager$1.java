package com.tencent.mobileqq.tofumsg;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult;

class TofuManager$1
  extends TofuObserver
{
  TofuManager$1(TofuManager paramTofuManager) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, List<oidb_0xe61.BeancurdCubeInfoResult> paramList)
  {
    if (QLog.isColorLevel())
    {
      String str = MobileQQ.getShortUinStr(paramString2);
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      QLog.i("Tofu_TofuManager", 2, String.format("onPullTofuMsgData suc=%b selfUin=%s frdUin=%s size=%d", new Object[] { Boolean.valueOf(paramBoolean), paramString1, str, Integer.valueOf(i) }));
    }
    if (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { Boolean.valueOf(paramBoolean), paramString2, paramList }).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuManager.1
 * JD-Core Version:    0.7.0.1
 */