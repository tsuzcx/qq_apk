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
    Object localObject = ((EmoticonPanelController)this.this$1.this$0.mPanelController).getPageAdapter();
    if (localObject != null) {
      ((EmotionPanelViewPagerAdapter)localObject).onDownload(this.val$ep.epId);
    }
    if (((this.val$ep.extraFlags & 0x2) > 0) && (this.val$resultCode == 0))
    {
      ((EmoticonPanelController)this.this$1.this$0.mPanelController).getPanel().mSecondTabInited = false;
      localObject = this.val$ep;
      ((EmoticonPackage)localObject).extraFlags &= 0xFFFFFFFD;
      ((EmoticonPanelController)this.this$1.this$0.mPanelController).switchTabMode(BasePanelModel.sLastSelectedSecondTabIndex);
      return;
    }
    if (this.val$ep.jobType != 3)
    {
      if (this.val$ep.jobType == 5) {
        return;
      }
      int i = this.val$resultCode;
      if (i == 0)
      {
        if (((EmoticonPanelController)this.this$1.this$0.mPanelController).getBasePanelModel().addEmoPkgList.contains(this.val$ep))
        {
          ((EmoticonPanelController)this.this$1.this$0.mPanelController).getBasePanelModel().addEmoPkgList.remove(this.val$ep);
          return;
        }
        ((EmoticonPanelController)this.this$1.this$0.mPanelController).getBasePanelView().mMarketPgkDownloaded = false;
        ((EmoticonPanelController)this.this$1.this$0.mPanelController).getPanel().mSecondTabInited = false;
        ((EmoticonPanelController)this.this$1.this$0.mPanelController).getBasePanelView().isNeedResetX = false;
        if ((((EmoticonPanelController)this.this$1.this$0.mPanelController).getPanel().getVisibility() == 0) && (((EmoticonPanelController)this.this$1.this$0.mPanelController).app != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPanelMallHelper", 2, "Emoticon pkg downloaded in panel, refresh");
          }
          localObject = ((EmoticonPanelController)this.this$1.this$0.mPanelController).getPanelDataList();
          if (localObject == null) {
            return;
          }
          int j = 0;
          while (j < ((List)localObject).size())
          {
            EmoticonPackage localEmoticonPackage = ((EmotionPanelInfo)((List)localObject).get(j)).emotionPkg;
            if ((localEmoticonPackage != null) && (this.val$ep.epId.equals(localEmoticonPackage.epId))) {
              break label399;
            }
            j += 1;
          }
          j = 0;
          label399:
          i = j;
          if (this.this$1.this$0.isClickNoChangeTab)
          {
            i = j;
            if (BasePanelModel.sLastSelectedSecondTabIndex >= 0) {
              i = BasePanelModel.sLastSelectedSecondTabIndex;
            }
          }
          j = ((EmoticonPanelController)this.this$1.this$0.mPanelController).findIndexByPanelType(12);
          if (BasePanelModel.sLastSelectedSecondTabIndex == j) {
            i = j;
          }
          ((EmoticonPanelController)this.this$1.this$0.mPanelController).switchTabMode(i);
          ((EmoticonPanelController)this.this$1.this$0.mPanelController).getBasePanelView().mNeedUpdate = false;
        }
      }
      else
      {
        if (i == 11000)
        {
          QQToast.a(((EmoticonPanelController)this.this$1.this$0.mPanelController).context, ((EmoticonPanelController)this.this$1.this$0.mPanelController).context.getString(2131689895), 1).b(((EmoticonPanelController)this.this$1.this$0.mPanelController).getToastOffset());
          return;
        }
        if (i == 11001) {
          QQToast.a(((EmoticonPanelController)this.this$1.this$0.mPanelController).context, ((EmoticonPanelController)this.this$1.this$0.mPanelController).context.getString(2131689896), 1).b(((EmoticonPanelController)this.this$1.this$0.mPanelController).getToastOffset());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.4.1
 * JD-Core Version:    0.7.0.1
 */