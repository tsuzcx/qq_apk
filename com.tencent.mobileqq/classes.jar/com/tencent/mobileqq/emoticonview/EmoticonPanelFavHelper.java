package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqHandlerProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmoticonPanelFavHelper
  extends AbstractEmoticonPanelHelper<EmoticonPanelController>
{
  public static final String LOG_TAG = "EmoticonPanelFavHelper";
  protected QQEmoticonMainPanelApp app;
  Runnable comicEmoticon = new EmoticonPanelFavHelper.3(this);
  FavEmoRoamingObserver favEmoRoamingObserver = new EmoticonPanelFavHelper.5(this);
  SyncListener<CustomEmotionData> sListener = new EmoticonPanelFavHelper.4(this);
  
  public EmoticonPanelFavHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  protected void applyFavEmoticonSharePref(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramSharedPreferences == null) {
      return;
    }
    paramSharedPreferences = paramSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("local_overflow");
    localStringBuilder.append(paramString);
    paramSharedPreferences.putBoolean(localStringBuilder.toString(), true).apply();
  }
  
  void doSyncFavEmotion()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = ((EmoticonPanelController)this.mPanelController).app;
    Object localObject = ((EmoticonPanelController)this.mPanelController).context;
    if (localQQEmoticonMainPanelApp == null) {
      return;
    }
    localObject = ((Context)localObject).getSharedPreferences("mobileQQ", 0);
    String str = localQQEmoticonMainPanelApp.getCurrentUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("local_overflow");
    localStringBuilder.append(str);
    boolean bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDelOverflow=");
      localStringBuilder.append(bool);
      QLog.d("EmoticonPanelFavHelper", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new EmoticonPanelFavHelper.2(this, localQQEmoticonMainPanelApp, bool, (SharedPreferences)localObject, str), 5, null, false);
  }
  
  protected void downloadSmallAndNormalEmotion(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, List<EmotionPanelInfo> paramList, int paramInt, EmojiManagerServiceProxy paramEmojiManagerServiceProxy)
  {
    paramList = new ArrayList(paramList);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("newPanelDataList.size() = ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("EmoticonPanelFavHelper", 2, ((StringBuilder)localObject).toString());
    }
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      localObject = ((EmotionPanelInfo)paramList.next()).emotionPkg;
      int j = i + 1;
      i = j;
      if (localObject != null) {
        if (((EmoticonPackage)localObject).jobType != 0)
        {
          i = j;
          if (((EmoticonPackage)localObject).jobType != 4) {}
        }
        else
        {
          i = j;
          if (((EmoticonPackage)localObject).status != 2)
          {
            paramEmojiManagerServiceProxy.setHaveInitSmallAndNormal(true);
            i = j;
            if (j <= 10)
            {
              EmoticonUtils.downloadNormalEmotion(paramQQEmoticonMainPanelApp, (EmoticonPackage)localObject, paramInt);
              i = j;
            }
          }
        }
      }
    }
  }
  
  public String getTag()
  {
    return "EmoticonPanelFavHelper";
  }
  
  public void initBefore()
  {
    this.app = ((EmoticonPanelController)this.mPanelController).app;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 9, 10, 1 };
  }
  
  public void onAttachedToWindow()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.app;
    if (localQQEmoticonMainPanelApp != null) {
      localQQEmoticonMainPanelApp.addObserver(this.favEmoRoamingObserver);
    }
  }
  
  public void onDestory()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = ((EmoticonPanelController)this.mPanelController).app;
    if (localQQEmoticonMainPanelApp != null) {
      localQQEmoticonMainPanelApp.removeObserver(this.favEmoRoamingObserver);
    }
    this.sListener = null;
  }
  
  public void onDetachedFromWindow()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.app;
    if (localQQEmoticonMainPanelApp != null) {
      localQQEmoticonMainPanelApp.removeObserver(this.favEmoRoamingObserver);
    }
  }
  
  protected void realDoSyncFavEmoticon(boolean paramBoolean, QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, SharedPreferences paramSharedPreferences, String paramString)
  {
    if (!paramBoolean)
    {
      paramQQEmoticonMainPanelApp = (FavroamingDBManagerServiceProxy)paramQQEmoticonMainPanelApp.getRuntimeService(IFavroamingDBManagerService.class);
      List localList1 = paramQQEmoticonMainPanelApp.getEmoticonDataList();
      if ((localList1 != null) && (localList1.size() > FavEmoConstant.a))
      {
        List localList2 = localList1.subList(0, localList1.size() - FavEmoConstant.a);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("delListOverflow=");
          localStringBuilder.append(localList2.toString());
          localStringBuilder.append("emolist.size=");
          localStringBuilder.append(localList1.size());
          QLog.d("EmoticonPanelFavHelper", 2, localStringBuilder.toString());
        }
        paramQQEmoticonMainPanelApp.delOverflow(localList2);
        updateFavEmoticonPanel();
      }
      applyFavEmoticonSharePref(paramSharedPreferences, paramString);
      startSyncFavEmoticon();
      return;
    }
    startSyncFavEmoticon();
  }
  
  protected void realUpdateFavEmoticonPanel()
  {
    List localList = ((EmoticonPanelController)this.mPanelController).getPanelDataList();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        localEmotionPanelInfo = (EmotionPanelInfo)localList.get(i);
        if ((localEmotionPanelInfo != null) && (localEmotionPanelInfo.type == 4)) {
          break label62;
        }
        i += 1;
      }
    }
    EmotionPanelInfo localEmotionPanelInfo = null;
    label62:
    if ((localEmotionPanelInfo != null) && (((EmoticonPanelController)this.mPanelController).getPageAdapter() != null)) {
      ((EmoticonPanelController)this.mPanelController).getPageAdapter().refreshListViewAdapter(localEmotionPanelInfo);
    }
  }
  
  public void roamTenEmoticon()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = ((EmoticonPanelController)this.mPanelController).app;
    List localList = ((EmoticonPanelController)this.mPanelController).getPanelDataList();
    int i = ((EmoticonPanelController)this.mPanelController).getBusinessType();
    if (localQQEmoticonMainPanelApp != null)
    {
      EmojiManagerServiceProxy localEmojiManagerServiceProxy = (EmojiManagerServiceProxy)localQQEmoticonMainPanelApp.getRuntimeService(IEmojiManagerService.class);
      if (!localEmojiManagerServiceProxy.haveInitFav())
      {
        localEmojiManagerServiceProxy.setHaveInitFav(true);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "doSyncFavEmotion");
        }
        doSyncFavEmotion();
      }
      if (!localEmojiManagerServiceProxy.haveInitSmallAndNormal()) {
        downloadSmallAndNormalEmotion(localQQEmoticonMainPanelApp, localList, i, localEmojiManagerServiceProxy);
      }
    }
  }
  
  void startSyncFavEmoticon()
  {
    Object localObject = ((EmoticonPanelController)this.mPanelController).context;
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = ((EmoticonPanelController)this.mPanelController).app;
    if (NetworkUtil.isNetSupport((Context)localObject))
    {
      if (localQQEmoticonMainPanelApp == null) {
        return;
      }
      localObject = (FavroamingManagerServiceProxy)localQQEmoticonMainPanelApp.getRuntimeService(IFavroamingManagerService.class);
      VipComicMqqHandlerProxy localVipComicMqqHandlerProxy = (VipComicMqqHandlerProxy)localQQEmoticonMainPanelApp.getBusinessHandler(VipComicMqqHandler.a);
      if (((FavroamingManagerServiceProxy)localObject).isInSyncing())
      {
        localVipComicMqqHandlerProxy.getMyComicFavorEmotIcons();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "comicHandler.GetMyComicFavorEmotIcons");
        }
        ((FavroamingManagerServiceProxy)localObject).addSyncListener(this.sListener);
        ((FavroamingManagerServiceProxy)localObject).syncLocalDel();
        this.comicEmoticon.run();
        ReportController.b(localQQEmoticonMainPanelApp.getQQAppInterface(), "CliOper", "", "", "0X8005CED", "0X8005CED", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void updateFavEmoticonPanel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "refresh fav emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelFavHelper.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper
 * JD-Core Version:    0.7.0.1
 */