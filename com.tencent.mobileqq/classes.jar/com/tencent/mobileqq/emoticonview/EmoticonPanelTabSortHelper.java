package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor.EmoticonTabSortConfBean;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EmoticonPanelTabSortHelper
  extends AbstractEmoticonPanelHelper
{
  protected static final String LOG_TAG = "EmoticonPanelTabSortHelper";
  protected List<EmotionPanelInfo> mBehindDisSelectedDataList = new ArrayList();
  protected List<EmotionPanelInfo> mEmotionPanelInfos;
  protected List<EmotionPanelInfo> mFrontDisSelectedDataList = new ArrayList();
  protected boolean mHideSettingBtn = false;
  protected boolean mPanelTabSortEnable = false;
  
  public EmoticonPanelTabSortHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  public void checkAndRemoveItem(List<EmotionPanelInfo> paramList)
  {
    if (paramList == null) {}
    while (!EmoticonStoreTabEntryUtils.checkIsMergeStoryEntry()) {
      return;
    }
    EmoticonStoreTabEntryUtils.removeSettingAndRecommendEntry(paramList);
  }
  
  protected void fillDisSelectedDataList(EmoticonTabSortConfProcessor.EmoticonTabSortConfBean paramEmoticonTabSortConfBean)
  {
    this.mBehindDisSelectedDataList.clear();
    this.mFrontDisSelectedDataList.clear();
    if ((paramEmoticonTabSortConfBean != null) && (!paramEmoticonTabSortConfBean.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      int i = 0;
      int j = 0;
      if (i < paramEmoticonTabSortConfBean.jdField_a_of_type_JavaUtilList.size())
      {
        String str = (String)paramEmoticonTabSortConfBean.jdField_a_of_type_JavaUtilList.get(i);
        int k;
        if ("face".equalsIgnoreCase(str)) {
          k = 1;
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          if ("add".equalsIgnoreCase(str))
          {
            if (j != 0)
            {
              k = j;
              if (this.mPanelController.hasBigEmotion)
              {
                k = j;
                if (shouldDisplayBigEmoticon(this.mPanelController.sessionType))
                {
                  this.mBehindDisSelectedDataList.add(new EmotionPanelInfo(13, 0, null));
                  k = j;
                }
              }
            }
            else
            {
              k = j;
              if (this.mPanelController.hasBigEmotion)
              {
                k = j;
                if (shouldDisplayBigEmoticon(this.mPanelController.sessionType))
                {
                  this.mFrontDisSelectedDataList.add(new EmotionPanelInfo(13, 0, null));
                  k = j;
                }
              }
            }
          }
          else
          {
            k = j;
            if ("setting".equalsIgnoreCase(str))
            {
              k = j;
              if (!this.mHideSettingBtn) {
                if (j != 0)
                {
                  this.mBehindDisSelectedDataList.add(new EmotionPanelInfo(14, 0, null));
                  k = j;
                }
                else
                {
                  this.mFrontDisSelectedDataList.add(new EmotionPanelInfo(14, 0, null));
                  k = j;
                }
              }
            }
          }
        }
      }
    }
    else
    {
      this.mFrontDisSelectedDataList.add(new EmotionPanelInfo(13, 0, null));
      this.mFrontDisSelectedDataList.add(new EmotionPanelInfo(14, 0, null));
    }
    if (EmoticonStoreTabEntryUtils.checkIsMergeStoryEntry())
    {
      EmoticonStoreTabEntryUtils.removeSettingAndRecommendEntry(this.mFrontDisSelectedDataList);
      EmoticonStoreTabEntryUtils.removeSettingAndRecommendEntry(this.mBehindDisSelectedDataList);
    }
  }
  
  public int getBehindDisSelectedTabSize()
  {
    if ((!this.mPanelTabSortEnable) || (this.mBehindDisSelectedDataList == null)) {
      return 0;
    }
    return this.mBehindDisSelectedDataList.size();
  }
  
  public int getFrontDisSelectedTabSize()
  {
    if ((!this.mPanelTabSortEnable) || (this.mFrontDisSelectedDataList == null)) {
      return 0;
    }
    return this.mFrontDisSelectedDataList.size();
  }
  
  public String getGifEntranceIconUrl()
  {
    EmoticonTabSortConfProcessor.EmoticonTabSortConfBean localEmoticonTabSortConfBean = loadTabSortConObj();
    if (localEmoticonTabSortConfBean != null) {
      return localEmoticonTabSortConfBean.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  protected int getLastCanSelectedTabIndex()
  {
    if ((this.mEmotionPanelInfos == null) || (this.mEmotionPanelInfos.isEmpty())) {
      return getFrontDisSelectedTabSize();
    }
    return this.mEmotionPanelInfos.size() - getBehindDisSelectedTabSize() - 1;
  }
  
  public int getPkgEndSwitchSelectIndex()
  {
    CameraEmoRoamingManagerProxy localCameraEmoRoamingManagerProxy = (CameraEmoRoamingManagerProxy)this.mPanelController.app.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER);
    if (!localCameraEmoRoamingManagerProxy.isShowCameraEmoInApp()) {}
    for (int j = 4;; j = 5)
    {
      List localList = ((EmoticonManagerProxy)this.mPanelController.app.getManager(QQManagerFactory.EMOTICON_MANAGER)).getProEmoticonPkgs(false, this.mPanelController.businessType, this.mPanelController.kanDianBiu);
      int i;
      if (localList != null)
      {
        i = j;
        if (localList.size() != 0) {}
      }
      else
      {
        i = j - 1;
      }
      Object localObject = loadTabSortConObj();
      j = i;
      String str;
      if (localObject != null)
      {
        j = i;
        if (((EmoticonTabSortConfProcessor.EmoticonTabSortConfBean)localObject).b.size() > 0)
        {
          i = ((EmoticonTabSortConfProcessor.EmoticonTabSortConfBean)localObject).b.size();
          localObject = ((EmoticonTabSortConfProcessor.EmoticonTabSortConfBean)localObject).b.iterator();
          j = i;
          if (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            if (("camera".equalsIgnoreCase(str)) && (!localCameraEmoRoamingManagerProxy.isShowCameraEmoInApp())) {
              i -= 1;
            }
          }
        }
      }
      for (;;)
      {
        break;
        if (("recommend".equalsIgnoreCase(str)) && ((localList == null) || (localList.size() == 0)))
        {
          i -= 1;
          continue;
          return getFrontDisSelectedTabSize() + j;
        }
      }
    }
  }
  
  public List<EmotionPanelInfo> getSortEmotionPanelInfoList(List<EmotionPanelInfo> paramList)
  {
    if (!this.mPanelTabSortEnable) {
      return paramList;
    }
    List localList = Collections.synchronizedList(new ArrayList());
    if ((paramList != null) && (!paramList.isEmpty())) {
      localList.addAll(paramList);
    }
    paramList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)localIterator.next();
      if ((localEmotionPanelInfo.type == 13) || (localEmotionPanelInfo.type == 14)) {
        paramList.add(localEmotionPanelInfo);
      }
    }
    if (!paramList.isEmpty()) {
      localList.removeAll(paramList);
    }
    if (!this.mFrontDisSelectedDataList.isEmpty()) {
      localList.addAll(0, this.mFrontDisSelectedDataList);
    }
    if (!this.mBehindDisSelectedDataList.isEmpty()) {
      localList.addAll(this.mBehindDisSelectedDataList);
    }
    paramList = this.mPanelController.getAIOObj();
    if ((paramList != null) && ((paramList.a().a == 0) || (paramList.a().a == 1) || (paramList.a().a == 3000)))
    {
      checkAndRemoveItem(localList);
      checkAndRemoveItem(this.mFrontDisSelectedDataList);
      checkAndRemoveItem(this.mBehindDisSelectedDataList);
    }
    this.mEmotionPanelInfos = localList;
    updateLastSelectedSecondTabIndex();
    return localList;
  }
  
  public String getTag()
  {
    return "EmoticonPanelTabSortHelper";
  }
  
  public void hideEmoSetting()
  {
    this.mHideSettingBtn = true;
  }
  
  public void initBefore()
  {
    boolean bool2 = false;
    EmoticonTabSortConfProcessor.EmoticonTabSortConfBean localEmoticonTabSortConfBean = loadTabSortConObj();
    if (localEmoticonTabSortConfBean != null) {
      if ((!localEmoticonTabSortConfBean.a()) || (!isInAIOPanel()) || (this.mPanelController.mHideAllSettingTabs)) {
        break label50;
      }
    }
    label50:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mPanelTabSortEnable = bool1;
      if (this.mPanelTabSortEnable) {
        break;
      }
      return;
    }
    if ((!this.mPanelController.mParams.hideSettingBtn) && (this.mPanelController.businessType != 3))
    {
      bool1 = bool2;
      if (!this.mHideSettingBtn) {}
    }
    else
    {
      bool1 = true;
    }
    this.mHideSettingBtn = bool1;
    EmoticonPanelSettingHelper localEmoticonPanelSettingHelper = (EmoticonPanelSettingHelper)this.mPanelController.getHelper(6);
    localEmoticonPanelSettingHelper.setEmoSettingVisibility(8);
    localEmoticonPanelSettingHelper.setMoreSettingVisibility(8);
    localEmoticonPanelSettingHelper.setHideMoreAndSettingButton(true, true);
    fillDisSelectedDataList(localEmoticonTabSortConfBean);
    updateLastSelectedSecondTabIndex();
  }
  
  public int[] interestedIn()
  {
    return new int[] { 1, 3, 8 };
  }
  
  protected boolean isInAIOPanel()
  {
    return (this.mPanelController.mBaseChatPie != null) && (!this.mPanelController.mParams.kanDianBiu) && (this.mPanelController.mBaseChatPie.a != null);
  }
  
  protected EmoticonTabSortConfProcessor.EmoticonTabSortConfBean loadTabSortConObj()
  {
    return EmoticonTabSortConfProcessor.a();
  }
  
  public void onDestory()
  {
    this.mEmotionPanelInfos = null;
    this.mFrontDisSelectedDataList.clear();
    this.mBehindDisSelectedDataList.clear();
  }
  
  public void onPageSelected(int paramInt)
  {
    updateViewPagerScrollEnable(paramInt);
  }
  
  public boolean setSelection(int paramInt)
  {
    if ((!this.mPanelTabSortEnable) || (this.mEmotionPanelInfos == null) || (paramInt < 0) || (paramInt >= this.mEmotionPanelInfos.size())) {
      return false;
    }
    EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)this.mEmotionPanelInfos.get(paramInt);
    return ((EmoticonPanelSettingHelper)this.mPanelController.getHelper(6)).performClick(localEmotionPanelInfo.type);
  }
  
  protected boolean shouldDisplayBigEmoticon(int paramInt)
  {
    return EmoticonUtils.shouldDisplayBigEmoticon(paramInt);
  }
  
  public void updateLastSelectedSecondTabIndex()
  {
    if ((!this.mPanelTabSortEnable) || (this.mEmotionPanelInfos == null)) {}
    label122:
    for (;;)
    {
      return;
      int i;
      if ((EmoticonPanelController.sLastSelectedSecondTabIndex >= 0) && (EmoticonPanelController.sLastSelectedSecondTabIndex < getFrontDisSelectedTabSize()))
      {
        EmoticonPanelController.sLastSelectedSecondTabIndex += getFrontDisSelectedTabSize();
        i = 0;
      }
      for (;;)
      {
        if (i >= this.mEmotionPanelInfos.size()) {
          break label122;
        }
        if (((EmotionPanelInfo)this.mEmotionPanelInfos.get(i)).type == 8)
        {
          EmoticonPanelController.sRecommendEmoticonViewPoSition = i;
          return;
          if ((getBehindDisSelectedTabSize() <= 0) || (getLastCanSelectedTabIndex() < 0) || (EmoticonPanelController.sLastSelectedSecondTabIndex <= getLastCanSelectedTabIndex())) {
            break;
          }
          EmoticonPanelController.sLastSelectedSecondTabIndex = getLastCanSelectedTabIndex();
          break;
        }
        i += 1;
      }
    }
  }
  
  public int updateOriginalSelectIndex(int paramInt)
  {
    if ((!this.mPanelTabSortEnable) || (getFrontDisSelectedTabSize() == 0) || (paramInt >= getFrontDisSelectedTabSize())) {}
    int i;
    int j;
    do
    {
      return paramInt;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      j = i + getFrontDisSelectedTabSize();
      i = getLastCanSelectedTabIndex();
      paramInt = i;
    } while (j > i);
    return j;
  }
  
  protected void updateViewPagerNoScrollItem()
  {
    if ((this.mEmotionPanelInfos != null) && (this.mPanelController.viewPager != null)) {
      this.mPanelController.viewPager.setNoScrollItem(getFrontDisSelectedTabSize(), getLastCanSelectedTabIndex());
    }
  }
  
  protected void updateViewPagerScrollEnable(int paramInt)
  {
    if (!this.mPanelTabSortEnable)
    {
      this.mPanelController.viewPager.setRightScrollDisEnable(false);
      this.mPanelController.viewPager.setLeftScrollDisEnable(false);
      return;
    }
    if ((paramInt != 0) && (paramInt <= getFrontDisSelectedTabSize()))
    {
      this.mPanelController.viewPager.setRightScrollDisEnable(true);
      this.mPanelController.viewPager.setLeftScrollDisEnable(false);
    }
    for (;;)
    {
      updateViewPagerNoScrollItem();
      return;
      if (paramInt >= getLastCanSelectedTabIndex())
      {
        this.mPanelController.viewPager.setRightScrollDisEnable(false);
        this.mPanelController.viewPager.setLeftScrollDisEnable(true);
      }
      else
      {
        this.mPanelController.viewPager.setRightScrollDisEnable(false);
        this.mPanelController.viewPager.setLeftScrollDisEnable(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelTabSortHelper
 * JD-Core Version:    0.7.0.1
 */