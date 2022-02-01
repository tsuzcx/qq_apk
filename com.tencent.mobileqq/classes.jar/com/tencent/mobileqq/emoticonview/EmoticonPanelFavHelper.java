package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqHandlerProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class EmoticonPanelFavHelper
  extends AbstractEmoticonPanelHelper
{
  private static final String LOG_TAG = "EmoticonPanelFavHelper";
  protected QQEmoticonMainPanelApp app;
  Runnable comicEmoticon = new EmoticonPanelFavHelper.3(this);
  FavEmoRoamingObserver favEmoRoamingObserver = new EmoticonPanelFavHelper.5(this);
  SyncListener<CustomEmotionData> sListener = new EmoticonPanelFavHelper.4(this);
  
  public EmoticonPanelFavHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  void RoamTenEmoticon()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.mPanelController.app;
    Object localObject = this.mPanelController.panelDataList;
    int j = this.mPanelController.businessType;
    if (localQQEmoticonMainPanelApp != null)
    {
      EmojiManagerProxy localEmojiManagerProxy = (EmojiManagerProxy)localQQEmoticonMainPanelApp.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
      if (!localEmojiManagerProxy.haveInitFav())
      {
        localEmojiManagerProxy.setHaveInitFav(true);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "doSyncFavEmotion");
        }
        doSyncFavEmotion();
      }
      if (!localEmojiManagerProxy.haveInitSmallAndNormal())
      {
        localObject = new ArrayList((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "newPanelDataList.size() = " + ((ArrayList)localObject).size());
        }
        localObject = ((ArrayList)localObject).iterator();
        int i = 0;
        while (((Iterator)localObject).hasNext())
        {
          EmoticonPackage localEmoticonPackage = ((EmotionPanelInfo)((Iterator)localObject).next()).emotionPkg;
          i += 1;
          if ((localEmoticonPackage != null) && ((localEmoticonPackage.jobType == 0) || (localEmoticonPackage.jobType == 4)) && (localEmoticonPackage.status != 2))
          {
            localEmojiManagerProxy.setHaveInitSmallAndNormal(true);
            if (i <= 10) {
              EmoticonUtils.downloadNormalEmotion(localQQEmoticonMainPanelApp, localEmoticonPackage, j);
            }
          }
        }
      }
    }
  }
  
  void doSyncFavEmotion()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.mPanelController.app;
    Object localObject = this.mPanelController.context;
    if (localQQEmoticonMainPanelApp == null) {
      return;
    }
    localObject = ((Context)localObject).getSharedPreferences("mobileQQ", 0);
    String str = localQQEmoticonMainPanelApp.getCurrentUin();
    boolean bool = ((SharedPreferences)localObject).getBoolean("local_overflow" + str, false);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "isDelOverflow=" + bool);
    }
    ThreadManager.post(new EmoticonPanelFavHelper.2(this, localQQEmoticonMainPanelApp, bool, (SharedPreferences)localObject, str), 5, null, false);
  }
  
  public String getTag()
  {
    return "EmoticonPanelFavHelper";
  }
  
  public void initBefore()
  {
    this.app = this.mPanelController.app;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 9, 10, 1 };
  }
  
  public void onAttachedToWindow()
  {
    if (this.app != null) {
      this.app.addObserver(this.favEmoRoamingObserver);
    }
  }
  
  public void onDestory()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.mPanelController.app;
    if (localQQEmoticonMainPanelApp != null) {
      localQQEmoticonMainPanelApp.removeObserver(this.favEmoRoamingObserver);
    }
    this.sListener = null;
  }
  
  public void onDetachedFromWindow()
  {
    if (this.app != null) {
      this.app.removeObserver(this.favEmoRoamingObserver);
    }
  }
  
  void startSyncFavEmoticon()
  {
    Object localObject = this.mPanelController.context;
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.mPanelController.app;
    if ((!NetworkUtil.d((Context)localObject)) || (localQQEmoticonMainPanelApp == null)) {}
    VipComicMqqHandlerProxy localVipComicMqqHandlerProxy;
    do
    {
      return;
      localObject = (FavroamingManagerProxy)localQQEmoticonMainPanelApp.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
      localVipComicMqqHandlerProxy = (VipComicMqqHandlerProxy)localQQEmoticonMainPanelApp.getBusinessHandler(BusinessHandlerFactory.MQQ_COMIC_HANDLER);
    } while (!((FavroamingManagerProxy)localObject).isInSyncing());
    localVipComicMqqHandlerProxy.getMyComicFavorEmotIcons();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "comicHandler.GetMyComicFavorEmotIcons");
    }
    ((FavroamingManagerProxy)localObject).addSyncListener(this.sListener);
    ((FavroamingManagerProxy)localObject).syncLocalDel();
    this.comicEmoticon.run();
    ReportController.b(localQQEmoticonMainPanelApp.getQQAppInterface(), "CliOper", "", "", "0X8005CED", "0X8005CED", 0, 0, "", "", "", "");
  }
  
  public void updateFavEmoticonPanel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "refresh fav emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelFavHelper.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper
 * JD-Core Version:    0.7.0.1
 */