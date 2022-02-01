package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import anub;
import asfl;
import asft;
import asgn;
import asih;
import bdla;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class EmoticonPanelFavHelper
  extends AbstractEmoticonPanelHelper
{
  private static final String LOG_TAG = "EmoticonPanelFavHelper";
  protected QQAppInterface app;
  Runnable comicEmoticon = new EmoticonPanelFavHelper.3(this);
  anub favEmoRoamingObserver = new EmoticonPanelFavHelper.5(this);
  asft<CustomEmotionData> sListener = new EmoticonPanelFavHelper.4(this);
  
  public EmoticonPanelFavHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  void RoamTenEmoticon()
  {
    QQAppInterface localQQAppInterface = this.mPanelController.app;
    Object localObject = this.mPanelController.panelDataList;
    int j = this.mPanelController.businessType;
    if (localQQAppInterface != null)
    {
      asih localasih = (asih)localQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
      if (!localasih.e)
      {
        localasih.e = true;
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "doSyncFavEmotion");
        }
        doSyncFavEmotion();
      }
      if (!localasih.d)
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
            localasih.d = true;
            if (i <= 10) {
              EmoticonUtils.downloadNormalEmotion(localQQAppInterface, localEmoticonPackage, j);
            }
          }
        }
      }
    }
  }
  
  void doSyncFavEmotion()
  {
    QQAppInterface localQQAppInterface = this.mPanelController.app;
    Object localObject = this.mPanelController.context;
    if (localQQAppInterface == null) {
      return;
    }
    localObject = ((Context)localObject).getSharedPreferences("mobileQQ", 0);
    String str = localQQAppInterface.getCurrentUin();
    boolean bool = ((SharedPreferences)localObject).getBoolean("local_overflow" + str, false);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "isDelOverflow=" + bool);
    }
    ThreadManager.post(new EmoticonPanelFavHelper.2(this, localQQAppInterface, bool, (SharedPreferences)localObject, str), 5, null, false);
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
    QQAppInterface localQQAppInterface = this.mPanelController.app;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.favEmoRoamingObserver);
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
    QQAppInterface localQQAppInterface = this.mPanelController.app;
    if ((!NetworkUtil.isNetSupport((Context)localObject)) || (localQQAppInterface == null)) {}
    asgn localasgn;
    do
    {
      return;
      localObject = (asfl)localQQAppInterface.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
      localasgn = (asgn)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MQQ_COMIC_HANDLER);
    } while (!((asfl)localObject).a());
    localasgn.a();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "comicHandler.GetMyComicFavorEmotIcons");
    }
    ((asfl)localObject).a(this.sListener);
    ((asfl)localObject).c();
    this.comicEmoticon.run();
    bdla.b(localQQAppInterface, "CliOper", "", "", "0X8005CED", "0X8005CED", 0, 0, "", "", "", "");
  }
  
  public void updateFavEmoticonPanel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "refresh fav emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelFavHelper.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper
 * JD-Core Version:    0.7.0.1
 */