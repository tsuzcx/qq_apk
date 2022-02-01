package com.tencent.mobileqq.emoticonview;

import android.text.TextUtils;
import asiu;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class EmoticonPanelMallHelper$4
  extends asiu
{
  EmoticonPanelMallHelper$4(EmoticonPanelMallHelper paramEmoticonPanelMallHelper) {}
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelMallHelper", 2, "onPackageEnd resultCode = " + paramInt + ",ep = " + paramEmoticonPackage);
      }
    } while (this.this$0.mPanelController.detached);
    ThreadManager.getUIHandler().post(new EmoticonPanelMallHelper.4.1(this, paramEmoticonPackage, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.4
 * JD-Core Version:    0.7.0.1
 */