package com.tencent.mobileqq.emoticonview;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import asig;
import asit;
import asiu;
import awyr;
import bdla;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class EmoticonPanelMallHelper
  extends AbstractEmoticonPanelHelper
  implements asit
{
  private static final String LOG_TAG = "EmoticonPanelMallHelper";
  private static final long MARKET_OPEN_INTERVAL = 2592000000L;
  asiu downloadListener = new EmoticonPanelMallHelper.4(this);
  private boolean mAutoOpenPage;
  private int mFromType;
  private boolean mOnItemClicked;
  AdapterView.OnItemClickListener tabItemClickListener = new EmoticonPanelMallHelper.6(this);
  
  public EmoticonPanelMallHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  void asyncInitPanelDataList(boolean paramBoolean, EmoticonPanelController.PanelDataCallback paramPanelDataCallback)
  {
    QLog.d("EmoticonPanelMallHelper", 1, "asyncInitPanelDataList begin");
    ThreadManager.post(new EmoticonPanelMallHelper.1(this, paramBoolean, paramPanelDataCallback), 5, null, true);
  }
  
  int findTabIndexByEpId(QQAppInterface paramQQAppInterface, String paramString, List<EmotionPanelInfo> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {}
    label155:
    label159:
    for (;;)
    {
      return 0;
      if (paramList != null)
      {
        paramQQAppInterface = ((awyr)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramString);
        int j;
        int i;
        if ((paramQQAppInterface != null) && ((paramQQAppInterface.jobType == 3) || (paramQQAppInterface.jobType == 5)))
        {
          j = 1;
          int k = paramList.size();
          i = 0;
          label66:
          if (i >= k) {
            break label155;
          }
          paramQQAppInterface = (EmotionPanelInfo)paramList.get(i);
          if ((paramQQAppInterface == null) || (paramQQAppInterface.emotionPkg == null) || (!paramString.equals(paramQQAppInterface.emotionPkg.epId))) {
            break label125;
          }
        }
        for (;;)
        {
          if (i == -1) {
            break label159;
          }
          return i;
          j = 0;
          break;
          label125:
          if ((j == 0) || (paramQQAppInterface == null) || (paramQQAppInterface.type != 9))
          {
            i += 1;
            break label66;
            i = -1;
          }
        }
      }
    }
  }
  
  public int getEmoticonTab(String paramString, List<EmotionPanelInfo> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (EmotionPanelInfo)paramList.get(i);
      if (((EmotionPanelInfo)localObject).type == 6)
      {
        localObject = ((EmotionPanelInfo)localObject).emotionPkg;
        if ((localObject != null) && (paramString.equals(((EmoticonPackage)localObject).epId)))
        {
          if (paramBoolean) {
            return i - 3;
          }
          return i - 2;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  public int getFromType()
  {
    return this.mFromType;
  }
  
  public String getTag()
  {
    return "EmoticonPanelMallHelper";
  }
  
  public void initBefore()
  {
    asig.a().a(this);
    asig.a().a(this.downloadListener);
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 7, 8, 1, 3 };
  }
  
  public void onDestory()
  {
    asig.a().b(this);
    asig.a().b(this.downloadListener);
  }
  
  public void onPackageAdded(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId)))
    {
      QLog.e("EmoticonPanelMallHelper", 1, "onPackageAdded: ep = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPackageAdded: ep = " + paramEmoticonPackage);
    }
    this.mPanelController.mNeedUpdate = true;
    ThreadManager.getUIHandler().post(new EmoticonPanelMallHelper.7(this, paramEmoticonPackage));
  }
  
  public void onPackageDeleted(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPackageDeleted");
    }
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    List localList;
    int j;
    do
    {
      return;
      localList = this.mPanelController.panelDataList;
      int i = 0;
      int k;
      for (j = -1; i < localList.size(); j = k)
      {
        Object localObject = (EmotionPanelInfo)localList.get(i);
        k = j;
        if (localObject != null) {
          if (((EmotionPanelInfo)localObject).type != 6)
          {
            k = j;
            if (((EmotionPanelInfo)localObject).type != 10) {}
          }
          else
          {
            localObject = ((EmotionPanelInfo)localObject).emotionPkg;
            k = j;
            if (localObject != null)
            {
              k = j;
              if (paramEmoticonPackage.epId.equals(((EmoticonPackage)localObject).epId)) {
                k = i;
              }
            }
          }
        }
        i += 1;
      }
    } while (j == -1);
    if (j < EmoticonPanelController.sLastSelectedSecondTabIndex) {
      paramEmoticonPackage = this.mPanelController;
    }
    for (paramEmoticonPackage.mDeleteLeftPkgCount += 1;; this.mPanelController.mDeleteLeftPkgCount = (localList.size() - 1)) {
      do
      {
        this.mPanelController.mNeedUpdate = true;
        return;
      } while ((j != EmoticonPanelController.sLastSelectedSecondTabIndex) || (j != localList.size() - 1));
    }
  }
  
  public void onPackageMoved(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPackageMoved");
    }
    this.mPanelController.mNeedUpdate = true;
  }
  
  public void onPageSelected(int paramInt)
  {
    if ((this.mPanelController.panelDataList == null) || (paramInt >= this.mPanelController.panelDataList.size())) {}
    while (this.mPanelController.findIndexByPanelType(12) != paramInt) {
      return;
    }
    if (this.mPanelController.pageAdapter != null)
    {
      BaseEmotionAdapter localBaseEmotionAdapter = this.mPanelController.pageAdapter.getAdapterFromCache((EmotionPanelInfo)this.mPanelController.panelDataList.get(paramInt));
      if ((localBaseEmotionAdapter instanceof EmotionHotPicSearchAdapter)) {
        ((EmotionHotPicSearchAdapter)localBaseEmotionAdapter).clearReportedMD5List();
      }
    }
    if ((this.mOnItemClicked) || (this.mAutoOpenPage))
    {
      this.mOnItemClicked = false;
      this.mAutoOpenPage = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "onPageSelected position: " + paramInt);
    }
    this.mFromType = 2;
    this.mOnItemClicked = false;
    reportPageEvent((EmotionPanelInfo)this.mPanelController.panelDataList.get(paramInt), false);
  }
  
  public void onPause()
  {
    asig.a().b(this.downloadListener);
  }
  
  public void onResume()
  {
    asig.a().a(this.downloadListener);
  }
  
  public void preloadWebProcess()
  {
    ThreadManager.getSubThreadHandler().post(new EmoticonPanelMallHelper.3(this));
  }
  
  protected void reportPageEvent(EmotionPanelInfo paramEmotionPanelInfo, boolean paramBoolean)
  {
    String str;
    boolean bool;
    if (paramEmotionPanelInfo != null)
    {
      str = "";
      if (paramEmotionPanelInfo.type != 7) {
        break label108;
      }
      paramEmotionPanelInfo = "0X800AE07";
      bool = true;
    }
    for (;;)
    {
      int i = this.mPanelController.getFromType(bool);
      QQAppInterface localQQAppInterface;
      if ((!TextUtils.isEmpty(paramEmotionPanelInfo)) && (i != 0))
      {
        localQQAppInterface = this.mPanelController.app;
        if (!paramBoolean) {
          break label238;
        }
      }
      label108:
      label238:
      for (str = "3";; str = "2")
      {
        bdla.b(localQQAppInterface, "dc00898", "", "", paramEmotionPanelInfo, paramEmotionPanelInfo, i, 0, str, "", "", "");
        if (paramBoolean)
        {
          this.mAutoOpenPage = true;
          this.mFromType = 0;
        }
        return;
        if ((paramEmotionPanelInfo.type == 5) || (paramEmotionPanelInfo.type == 4))
        {
          paramEmotionPanelInfo = "0X800AE08";
          bool = true;
          break;
        }
        if (paramEmotionPanelInfo.type == 11)
        {
          paramEmotionPanelInfo = "0X800AE0A";
          bool = true;
          break;
        }
        if (paramEmotionPanelInfo.type == 8)
        {
          paramEmotionPanelInfo = "0X800AE0B";
          bool = false;
          break;
        }
        if (paramEmotionPanelInfo.type == 9)
        {
          paramEmotionPanelInfo = "0X800AE0D";
          bool = false;
          break;
        }
        if (paramEmotionPanelInfo.type == 12)
        {
          paramEmotionPanelInfo = "0X800AE09";
          bool = true;
          break;
        }
        if ((paramEmotionPanelInfo.type != 6) && (paramEmotionPanelInfo.type != 10)) {
          break label246;
        }
        paramEmotionPanelInfo = "0X800AE0C";
        bool = false;
        break;
      }
      label246:
      bool = true;
      paramEmotionPanelInfo = str;
    }
  }
  
  public void updateLastEmoticonPanel()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelMallHelper.2(this), 200L);
  }
  
  public void updateMagicPanel()
  {
    if (!this.mPanelController.getPanel().isShown()) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelMallHelper.5(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper
 * JD-Core Version:    0.7.0.1
 */