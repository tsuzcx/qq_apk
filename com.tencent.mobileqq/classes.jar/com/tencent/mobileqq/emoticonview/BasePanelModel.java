package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.EmotionPanelInjectionInfoManager;
import com.tencent.mobileqq.apollo.utils.api.ICMShowWnsHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfMapping;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonReportUtil;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListenerManager;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.model.IBasePanelModel;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BasePanelModel
  implements IBasePanelModel
{
  private static final String LOG_TAG = "BasePanelModel";
  static boolean sIsRecommendExist = true;
  public static int sLastSelectedSecondTabIndex = -1;
  List<EmoticonPackage> addEmoPkgList = new ArrayList();
  private QQEmoticonMainPanelApp app;
  public int businessType = 0;
  private final EmoticonPanelController mController;
  private EmoticonListProvider mEmoticonListProvider;
  EmotionPanelInjectionInfoManager mEmotionPanelInjectionInfoManager;
  EmoticonPanelParams mParams;
  PreloadProcHitSession mWebPreloadHitSession = new PreloadProcHitSession("emoticon_panel", "com.tencent.mobileqq:tool");
  public List<EmotionPanelInfo> panelDataList;
  int sessionType = 0;
  
  public BasePanelModel(IEmoticonPanelController paramIEmoticonPanelController)
  {
    this.mController = ((EmoticonPanelController)paramIEmoticonPanelController);
    this.app = this.mController.app;
  }
  
  public int findIndexByPanelType(int paramInt)
  {
    Object localObject = this.panelDataList;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return -1;
      }
      int i = 0;
      localObject = this.panelDataList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)((Iterator)localObject).next();
        if ((localEmotionPanelInfo != null) && (localEmotionPanelInfo.type == paramInt)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  protected void getCommonUsedSmallYellowEmoitonRequest(SharedPreferences paramSharedPreferences)
  {
    ThreadManagerV2.excute(new BasePanelModel.1(this, paramSharedPreferences), 64, null, true);
  }
  
  public EmoticonListProvider getEmoticonListProvider()
  {
    return this.mEmoticonListProvider;
  }
  
  public EmotionInjectionInfo getEmotionInjectionInfo(int paramInt)
  {
    if (this.mEmotionPanelInjectionInfoManager == null) {
      return null;
    }
    String str = EmoticonTabSortConfMapping.a(paramInt);
    return this.mEmotionPanelInjectionInfoManager.a(str);
  }
  
  protected int getFromType(boolean paramBoolean)
  {
    int j = this.sessionType;
    int i = 1;
    if (j != -1)
    {
      j = Integer.valueOf(EmoticonReportUtil.getAioMoreFlag(j)).intValue();
      if (j != 0)
      {
        if (j != 1) {
          if (j != 3)
          {
            if (paramBoolean) {
              return 4;
            }
          }
          else {
            return 2;
          }
        }
        return 3;
      }
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public void hideCmShowItemIfNeed(List<EmotionPanelInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.app;
    int j = 0;
    int i = 1;
    if (((localQQEmoticonMainPanelApp == null) || (localQQEmoticonMainPanelApp.getQQAppInterface() != null)) && (((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).isCmShowMemeTabInFaceEnabled())) {
      i = 0;
    }
    if (i != 0)
    {
      int k = paramList.size();
      i = j;
      while (i < k)
      {
        if (((EmotionPanelInfo)paramList.get(i)).type == 15) {
          break label102;
        }
        i += 1;
      }
      i = -1;
      label102:
      if (i != -1) {
        paramList.remove(i);
      }
    }
  }
  
  public void init()
  {
    initPanelInjectInfo();
  }
  
  protected void initPanelInjectInfo()
  {
    Object localObject = this.mEmotionPanelInjectionInfoManager;
    if (localObject != null)
    {
      localObject = ((EmotionPanelInjectionInfoManager)localObject).a();
      if (localObject != null)
      {
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          EmotionInjectionInfo localEmotionInjectionInfo = (EmotionInjectionInfo)((Map.Entry)((Iterator)localObject).next()).getValue();
          if ((localEmotionInjectionInfo != null) && (localEmotionInjectionInfo.lifecycleObserver != null) && (localEmotionInjectionInfo.lifecycleObserver.providerID > 0))
          {
            localEmotionInjectionInfo.lifecycleObserver.setPanelController(this.mController);
            this.mController.getHelperProvider().register(localEmotionInjectionInfo.lifecycleObserver.providerID, localEmotionInjectionInfo.lifecycleObserver);
          }
        }
      }
    }
  }
  
  public void initParams()
  {
    this.mParams = new EmoticonPanelParams(this.mController);
  }
  
  public boolean isEmoticonOnShow(int paramInt)
  {
    Object localObject = this.panelDataList;
    if (localObject != null)
    {
      int i = sLastSelectedSecondTabIndex;
      if ((i >= 0) && (i < ((List)localObject).size()))
      {
        localObject = (EmotionPanelInfo)this.panelDataList.get(sLastSelectedSecondTabIndex);
        if ((localObject != null) && (((EmotionPanelInfo)localObject).type == paramInt)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void onDestory()
  {
    Object localObject = this.panelDataList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    EmotionPanelPayBackListenerManager.a().a();
    localObject = this.app;
    if (localObject != null)
    {
      localObject = ((QQEmoticonMainPanelApp)localObject).getApplication().getSharedPreferences("commonUsedSystemEmoji_sp", 0);
      long l = ((SharedPreferences)localObject).getLong("lastRequestTime", 0L);
      if ((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() - l < 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BasePanelModel", 2, "onDestroy commonused send");
        }
        getCommonUsedSmallYellowEmoitonRequest((SharedPreferences)localObject);
      }
      localObject = (EmoticonManagerServiceProxy)this.app.getRuntimeService(IEmoticonManagerService.class);
      if (localObject != null) {
        ((EmoticonManagerServiceProxy)localObject).pushRecommendExposeInfoToSP();
      }
    }
    this.mWebPreloadHitSession.d();
    this.mEmotionPanelInjectionInfoManager = null;
  }
  
  public void reportDeleteEmoticonClick()
  {
    Object localObject = this.panelDataList;
    if (localObject != null)
    {
      int i = sLastSelectedSecondTabIndex;
      if ((i >= 0) && (i < ((List)localObject).size()))
      {
        localObject = (EmotionPanelInfo)this.panelDataList.get(sLastSelectedSecondTabIndex);
        if (((EmotionPanelInfo)localObject).type == 7)
        {
          ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", "0X800A845", "0X800A845", 1, 0, "", "", "", "");
          return;
        }
        if (((EmotionPanelInfo)localObject).type == 10) {
          ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", "0X800A845", "0X800A845", 2, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void setCurType(int paramInt)
  {
    this.sessionType = paramInt;
    switch (paramInt)
    {
    case 100000: 
    default: 
      this.businessType = 0;
      return;
    case 100003: 
      this.businessType = 4;
      return;
    case 100002: 
      this.businessType = 3;
      return;
    case 100001: 
      this.businessType = 2;
      return;
    }
    this.businessType = 1;
  }
  
  public void setEmoticonApp(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp)
  {
    this.app = paramQQEmoticonMainPanelApp;
  }
  
  public void setEmoticonListProvider(EmoticonListProvider paramEmoticonListProvider)
  {
    this.mEmoticonListProvider = paramEmoticonListProvider;
  }
  
  public void syncInitPanelDataList(boolean paramBoolean)
  {
    if (this.mController.isSecondTabInited()) {
      return;
    }
    Object localObject = this.mEmoticonListProvider;
    if (localObject != null)
    {
      localObject = ((EmoticonListProvider)localObject).getEmotionPanelInfo(paramBoolean, this.mController.getParams().onlySysAndEmoji);
      this.panelDataList = this.mController.mPanelTabSortHelper.getSortEmotionPanelInfoList((List)localObject);
    }
  }
  
  public void updateLastSelectedSecondTabIndex()
  {
    if (sLastSelectedSecondTabIndex != findIndexByPanelType(12))
    {
      sLastSelectedSecondTabIndex -= this.mController.getDeleteLeftPkgCount();
      if (sLastSelectedSecondTabIndex < 0) {
        sLastSelectedSecondTabIndex = this.mController.mPanelTabSortHelper.getFrontDisSelectedTabSize();
      }
    }
  }
  
  public void webPreloadHitSessionBegin()
  {
    this.mWebPreloadHitSession.a();
  }
  
  public void webPreloadHitSessionHit()
  {
    this.mWebPreloadHitSession.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BasePanelModel
 * JD-Core Version:    0.7.0.1
 */