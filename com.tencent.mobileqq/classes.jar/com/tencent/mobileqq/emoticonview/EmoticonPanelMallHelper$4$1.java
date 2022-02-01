package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EmoticonPanelMallHelper$4$1
  implements Runnable
{
  EmoticonPanelMallHelper$4$1(EmoticonPanelMallHelper.4 param4, EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$1.this$0.mPanelController.pageAdapter;
    if (localObject != null) {
      ((EmotionPanelViewPagerAdapter)localObject).onDownload(this.val$ep.epId);
    }
    if (((this.val$ep.extraFlags & 0x2) > 0) && (this.val$resultCode == 0))
    {
      this.this$1.this$0.mPanelController.getPanel().mSecondTabInited = false;
      this.val$ep.extraFlags &= 0xFFFFFFFD;
      this.this$1.this$0.mPanelController.switchTabMode(EmoticonPanelController.sLastSelectedSecondTabIndex);
    }
    label98:
    do
    {
      do
      {
        break label98;
        do
        {
          return;
        } while ((this.val$ep.jobType == 3) || (this.val$ep.jobType == 5));
        if (this.val$resultCode != 0) {
          break;
        }
        if (this.this$1.this$0.mPanelController.addEmoPkgList.contains(this.val$ep))
        {
          this.this$1.this$0.mPanelController.addEmoPkgList.remove(this.val$ep);
          return;
        }
        this.this$1.this$0.mPanelController.mMarketPgkDownloaded = false;
        this.this$1.this$0.mPanelController.getPanel().mSecondTabInited = false;
        this.this$1.this$0.mPanelController.isNeedResetX = false;
      } while ((this.this$1.this$0.mPanelController.getPanel().getVisibility() != 0) || (this.this$1.this$0.mPanelController.app == null));
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelMallHelper", 2, "Emoticon pkg downloaded in panel, refresh");
      }
      localObject = this.this$1.this$0.mPanelController.panelDataList;
    } while (localObject == null);
    int j = 0;
    label291:
    if (j < ((List)localObject).size())
    {
      EmoticonPackage localEmoticonPackage = ((EmotionPanelInfo)((List)localObject).get(j)).emotionPkg;
      if ((localEmoticonPackage == null) || (!this.val$ep.epId.equals(localEmoticonPackage.epId))) {}
    }
    for (;;)
    {
      int i = j;
      if (this.this$1.this$0.mPanelController.isClickNoChangeTab)
      {
        i = j;
        if (EmoticonPanelController.sLastSelectedSecondTabIndex >= 0) {
          i = EmoticonPanelController.sLastSelectedSecondTabIndex;
        }
      }
      j = this.this$1.this$0.mPanelController.findIndexByPanelType(12);
      if (EmoticonPanelController.sLastSelectedSecondTabIndex == j) {
        i = j;
      }
      this.this$1.this$0.mPanelController.switchTabMode(i);
      this.this$1.this$0.mPanelController.mNeedUpdate = false;
      return;
      j += 1;
      break label291;
      if (this.val$resultCode == 11000)
      {
        QQToast.a(this.this$1.this$0.mPanelController.context, this.this$1.this$0.mPanelController.context.getString(2131689938), 1).b(this.this$1.this$0.mPanelController.toastOffset);
        return;
      }
      if (this.val$resultCode != 11001) {
        break;
      }
      QQToast.a(this.this$1.this$0.mPanelController.context, this.this$1.this$0.mPanelController.context.getString(2131689939), 1).b(this.this$1.this$0.mPanelController.toastOffset);
      return;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.4.1
 * JD-Core Version:    0.7.0.1
 */