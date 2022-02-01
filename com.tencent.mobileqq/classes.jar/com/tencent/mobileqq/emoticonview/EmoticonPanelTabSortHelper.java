package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfBean;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EmoticonPanelTabSortHelper
  extends AbstractEmoticonPanelHelper<EmoticonPanelController>
{
  protected static final String LOG_TAG = "EmoticonPanelTabSortHelper";
  protected List<EmotionPanelInfo> mBehindDisSelectedDataList = new ArrayList();
  protected List<EmotionPanelInfo> mEmotionPanelInfos;
  protected List<EmotionPanelInfo> mFrontDisSelectedDataList = new ArrayList();
  protected boolean mHideSettingBtn = false;
  protected IPanelInteractionListener mInteractionListener;
  protected boolean mPanelTabSortEnable = false;
  
  public EmoticonPanelTabSortHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  public void checkAndRemoveItem(List<EmotionPanelInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    EmoticonStoreTabEntryUtils.removeSettingAndRecommendEntry(paramList);
  }
  
  protected void fillDisSelectedDataList(EmoticonTabSortConfBean paramEmoticonTabSortConfBean)
  {
    this.mBehindDisSelectedDataList.clear();
    this.mFrontDisSelectedDataList.clear();
    int i;
    int j;
    if ((paramEmoticonTabSortConfBean != null) && (!paramEmoticonTabSortConfBean.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      i = 0;
      j = 0;
    }
    while (i < paramEmoticonTabSortConfBean.jdField_a_of_type_JavaUtilList.size())
    {
      String str = (String)paramEmoticonTabSortConfBean.jdField_a_of_type_JavaUtilList.get(i);
      int k;
      if ("face".equalsIgnoreCase(str))
      {
        k = 1;
      }
      else if ("add".equalsIgnoreCase(str))
      {
        if (j != 0)
        {
          k = j;
          if (((EmoticonPanelController)this.mPanelController).getBasePanelView().hasBigEmotion)
          {
            k = j;
            if (shouldDisplayBigEmoticon(((EmoticonPanelController)this.mPanelController).getSessionType()))
            {
              this.mBehindDisSelectedDataList.add(new EmotionPanelInfo(13, 0, null));
              k = j;
            }
          }
        }
        else
        {
          k = j;
          if (((EmoticonPanelController)this.mPanelController).getBasePanelView().hasBigEmotion)
          {
            k = j;
            if (shouldDisplayBigEmoticon(((EmoticonPanelController)this.mPanelController).getSessionType()))
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
        if ("setting".equalsIgnoreCase(str)) {
          if (this.mHideSettingBtn)
          {
            k = j;
          }
          else if (j != 0)
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
      i += 1;
      j = k;
      continue;
      this.mFrontDisSelectedDataList.add(new EmotionPanelInfo(13, 0, null));
      this.mFrontDisSelectedDataList.add(new EmotionPanelInfo(14, 0, null));
    }
    EmoticonStoreTabEntryUtils.removeSettingAndRecommendEntry(this.mFrontDisSelectedDataList);
    EmoticonStoreTabEntryUtils.removeSettingAndRecommendEntry(this.mBehindDisSelectedDataList);
  }
  
  public int getBehindDisSelectedTabSize()
  {
    if (this.mPanelTabSortEnable)
    {
      List localList = this.mBehindDisSelectedDataList;
      if (localList != null) {
        return localList.size();
      }
    }
    return 0;
  }
  
  public int getFrontDisSelectedTabSize()
  {
    if (this.mPanelTabSortEnable)
    {
      List localList = this.mFrontDisSelectedDataList;
      if (localList != null) {
        return localList.size();
      }
    }
    return 0;
  }
  
  public String getGifEntranceIconUrl()
  {
    EmoticonTabSortConfBean localEmoticonTabSortConfBean = loadTabSortConObj();
    if (localEmoticonTabSortConfBean != null) {
      return localEmoticonTabSortConfBean.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public int getLastCanSelectedTabIndex()
  {
    List localList = this.mEmotionPanelInfos;
    if ((localList != null) && (!localList.isEmpty())) {
      return this.mEmotionPanelInfos.size() - getBehindDisSelectedTabSize() - 1;
    }
    return getFrontDisSelectedTabSize();
  }
  
  public int getPkgEndSwitchSelectIndex()
  {
    CameraEmoRoamingManagerServiceProxy localCameraEmoRoamingManagerServiceProxy = (CameraEmoRoamingManagerServiceProxy)((EmoticonPanelController)this.mPanelController).app.getRuntimeService(ICameraEmoRoamingManagerService.class);
    if (!localCameraEmoRoamingManagerServiceProxy.isShowCameraEmoInApp()) {
      j = 4;
    } else {
      j = 5;
    }
    List localList = ((EmoticonManagerServiceProxy)((EmoticonPanelController)this.mPanelController).app.getRuntimeService(IEmoticonManagerService.class)).getProEmoticonPkgs(false, ((EmoticonPanelController)this.mPanelController).getBusinessType(), ((EmoticonPanelController)this.mPanelController).getKanDianBiu());
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
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (((EmoticonTabSortConfBean)localObject).b.size() > 0)
      {
        i = ((EmoticonTabSortConfBean)localObject).b.size();
        localObject = ((EmoticonTabSortConfBean)localObject).b.iterator();
        j = i;
        if (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (("camera".equalsIgnoreCase(str)) && (!localCameraEmoRoamingManagerServiceProxy.isShowCameraEmoInApp())) {}
          for (;;)
          {
            i -= 1;
            break;
            if (!"recommend".equalsIgnoreCase(str)) {
              break;
            }
            if (localList != null) {
              if (localList.size() != 0) {
                break;
              }
            }
          }
        }
      }
    }
    return getFrontDisSelectedTabSize() + j;
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
    paramList = this.mInteractionListener;
    if ((paramList != null) && ((paramList.getCurType() == 0) || (this.mInteractionListener.getCurType() == 1) || (this.mInteractionListener.getCurType() == 3000)))
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
    this.mInteractionListener = ((EmoticonPanelController)this.mPanelController).getInteractionListener();
    EmoticonTabSortConfBean localEmoticonTabSortConfBean = loadTabSortConObj();
    boolean bool2 = false;
    boolean bool1;
    if (localEmoticonTabSortConfBean != null)
    {
      if ((localEmoticonTabSortConfBean.a()) && (isInAIOPanel()) && (!((EmoticonPanelController)this.mPanelController).getBasePanelView().mHideAllSettingTabs)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.mPanelTabSortEnable = bool1;
    }
    if (!this.mPanelTabSortEnable) {
      return;
    }
    if ((!((EmoticonPanelController)this.mPanelController).getParams().hideSettingBtn) && (((EmoticonPanelController)this.mPanelController).getBusinessType() != 3))
    {
      bool1 = bool2;
      if (!this.mHideSettingBtn) {}
    }
    else
    {
      bool1 = true;
    }
    this.mHideSettingBtn = bool1;
    EmoticonPanelSettingHelper localEmoticonPanelSettingHelper = (EmoticonPanelSettingHelper)((EmoticonPanelController)this.mPanelController).getHelper(6);
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
    return (this.mInteractionListener != null) && (!((EmoticonPanelController)this.mPanelController).getParams().kanDianBiu) && (this.mInteractionListener.getAIOInput() != null);
  }
  
  protected EmoticonTabSortConfBean loadTabSortConObj()
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
    if (this.mPanelTabSortEnable)
    {
      Object localObject = this.mEmotionPanelInfos;
      if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (EmotionPanelInfo)this.mEmotionPanelInfos.get(paramInt);
        return ((EmoticonPanelSettingHelper)((EmoticonPanelController)this.mPanelController).getHelper(6)).performClick(((EmotionPanelInfo)localObject).type);
      }
    }
    return false;
  }
  
  protected boolean shouldDisplayBigEmoticon(int paramInt)
  {
    return EmoticonPanelUtils.c(paramInt);
  }
  
  public void updateLastSelectedSecondTabIndex()
  {
    if (this.mPanelTabSortEnable)
    {
      if (this.mEmotionPanelInfos == null) {
        return;
      }
      if ((BasePanelModel.sLastSelectedSecondTabIndex >= 0) && (BasePanelModel.sLastSelectedSecondTabIndex < getFrontDisSelectedTabSize())) {
        BasePanelModel.sLastSelectedSecondTabIndex += getFrontDisSelectedTabSize();
      } else if ((getBehindDisSelectedTabSize() > 0) && (getLastCanSelectedTabIndex() >= 0) && (BasePanelModel.sLastSelectedSecondTabIndex > getLastCanSelectedTabIndex())) {
        BasePanelModel.sLastSelectedSecondTabIndex = getLastCanSelectedTabIndex();
      }
      int i = 0;
      while (i < this.mEmotionPanelInfos.size())
      {
        if (((EmotionPanelInfo)this.mEmotionPanelInfos.get(i)).type == 8)
        {
          BasePanelView.sRecommendEmoticonViewPoSition = i;
          return;
        }
        i += 1;
      }
    }
  }
  
  public int updateOriginalSelectIndex(int paramInt)
  {
    int i = paramInt;
    if (this.mPanelTabSortEnable)
    {
      i = paramInt;
      if (getFrontDisSelectedTabSize() != 0)
      {
        if (paramInt >= getFrontDisSelectedTabSize()) {
          return paramInt;
        }
        i = paramInt;
        if (paramInt < 0) {
          i = 0;
        }
        paramInt = i + getFrontDisSelectedTabSize();
        int j = getLastCanSelectedTabIndex();
        i = paramInt;
        if (paramInt > j) {
          i = j;
        }
      }
    }
    return i;
  }
  
  protected void updateViewPagerNoScrollItem()
  {
    if ((this.mEmotionPanelInfos != null) && (((EmoticonPanelController)this.mPanelController).getViewPager() != null)) {
      ((EmoticonPanelController)this.mPanelController).getViewPager().setNoScrollItem(getFrontDisSelectedTabSize(), getLastCanSelectedTabIndex());
    }
  }
  
  protected void updateViewPagerScrollEnable(int paramInt)
  {
    if (!this.mPanelTabSortEnable)
    {
      ((EmoticonPanelController)this.mPanelController).getViewPager().setRightScrollDisEnable(false);
      ((EmoticonPanelController)this.mPanelController).getViewPager().setLeftScrollDisEnable(false);
      return;
    }
    if ((paramInt != 0) && (paramInt <= getFrontDisSelectedTabSize()))
    {
      ((EmoticonPanelController)this.mPanelController).getViewPager().setRightScrollDisEnable(true);
      ((EmoticonPanelController)this.mPanelController).getViewPager().setLeftScrollDisEnable(false);
    }
    else if (paramInt >= getLastCanSelectedTabIndex())
    {
      ((EmoticonPanelController)this.mPanelController).getViewPager().setRightScrollDisEnable(false);
      ((EmoticonPanelController)this.mPanelController).getViewPager().setLeftScrollDisEnable(true);
    }
    else
    {
      ((EmoticonPanelController)this.mPanelController).getViewPager().setRightScrollDisEnable(false);
      ((EmoticonPanelController)this.mPanelController).getViewPager().setLeftScrollDisEnable(false);
    }
    updateViewPagerNoScrollItem();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelTabSortHelper
 * JD-Core Version:    0.7.0.1
 */