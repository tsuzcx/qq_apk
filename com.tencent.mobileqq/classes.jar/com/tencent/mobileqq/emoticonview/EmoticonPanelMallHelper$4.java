package com.tencent.mobileqq.emoticonview;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class EmoticonPanelMallHelper$4
  extends EmoticonPackageDownloadListener
{
  EmoticonPanelMallHelper$4(EmoticonPanelMallHelper paramEmoticonPanelMallHelper) {}
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramEmoticonPackage != null)
    {
      if (TextUtils.isEmpty(paramEmoticonPackage.epId)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPackageEnd resultCode = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(",ep = ");
        localStringBuilder.append(paramEmoticonPackage);
        QLog.d("EmoticonPanelMallHelper", 2, localStringBuilder.toString());
      }
      if (!((EmoticonPanelController)this.this$0.mPanelController).getBasePanelView().detached) {
        ThreadManager.getUIHandler().post(new EmoticonPanelMallHelper.4.1(this, paramEmoticonPackage, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.4
 * JD-Core Version:    0.7.0.1
 */