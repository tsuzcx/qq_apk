package com.tencent.mobileqq.werewolves;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.GVideoHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class WerewolvesHostInterface
{
  public static final String TAG = "Q.werewolf.WerewolvesHostInterface";
  protected IGameRoomAVControllerDelegate gameRoomAVControllerDelegate;
  WerewolvesPluginManager manager;
  
  public WerewolvesHostInterface(WerewolvesPluginManager paramWerewolvesPluginManager)
  {
    this.manager = paramWerewolvesPluginManager;
    this.gameRoomAVControllerDelegate = ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class));
  }
  
  public void disableMic()
  {
    if (this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie != null)
    {
      this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.m(false);
      return;
    }
    IGameRoomAVControllerDelegate localIGameRoomAVControllerDelegate = this.gameRoomAVControllerDelegate;
    if (localIGameRoomAVControllerDelegate != null)
    {
      if (localIGameRoomAVControllerDelegate.isBinded())
      {
        this.gameRoomAVControllerDelegate.stopSpeak();
        return;
      }
      this.gameRoomAVControllerDelegate.bindService(new WerewolvesHostInterface.1(this));
    }
  }
  
  public void enableMic()
  {
    if (this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie != null) {
      this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.m(true);
    }
  }
  
  public void enterProfile(String paramString)
  {
    if (this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie != null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      boolean bool1 = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
      String str = getCurrentRoomUin();
      Object localObject2 = localQQAppInterface.getHotChatMng(false);
      AllInOne localAllInOne = null;
      Object localObject1 = localAllInOne;
      if (localObject2 != null)
      {
        localObject2 = ((HotChatManager)localObject2).a(str);
        localObject1 = localAllInOne;
        if (localObject2 != null) {
          localObject1 = ((HotChatInfo)localObject2).troopCode;
        }
      }
      localAllInOne = new AllInOne(paramString, 42);
      localAllInOne.profileEntryType = 113;
      localAllInOne.troopUin = str;
      localAllInOne.troopCode = ((String)localObject1);
      boolean bool2 = localQQAppInterface.getCurrentAccountUin().equals(paramString);
      HotChatManager.a = false;
      if ((!bool1) && (!bool2))
      {
        paramString = new Intent();
        paramString.putExtra("is_from_werewolves", true);
        paramString.putExtra("AllInOne", localAllInOne);
        paramString.putExtra("param_mode", 3);
        RouteUtils.a(this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a(), paramString, "/nearby/people/profile");
        return;
      }
      ProfileUtils.openProfileCard(this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a(), localAllInOne);
    }
  }
  
  public void existRoom()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    HotChatInfo localHotChatInfo = localQQAppInterface.getHotChatMng(true).a(getCurrentRoomUin());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onExist uin = ");
      localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
      QLog.d("Q.werewolf.WerewolvesHostInterface", 2, localStringBuilder.toString());
    }
    if (localHotChatInfo != null) {
      ((WerewolvesHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(localHotChatInfo);
    }
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).hideFloatView();
  }
  
  public void exitChatPie()
  {
    if (this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie != null) {
      this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.b(1);
    }
  }
  
  public String getCurrentAccountUin()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
  }
  
  public String getCurrentRoomUin()
  {
    return this.manager.jdField_a_of_type_JavaLangString;
  }
  
  public Bitmap getFaceBitmap(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    if (this.manager.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
      boolean bool = ((QQAppInterface)localObject1).getCurrentAccountUin().equals(paramString);
      if ((!((FriendsManager)localObject2).b(paramString)) && (!bool))
      {
        localObject2 = this.manager.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(32, paramString, 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (paramBoolean)
          {
            this.manager.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeStrangeFace(paramString, 200, true, false);
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        localObject2 = this.manager.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString, 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (paramBoolean)
          {
            this.manager.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 1, true);
            localObject1 = localObject2;
          }
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return ImageUtil.h();
    }
    return localObject1;
  }
  
  public void getFollowStatus(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    GVideoHandler localGVideoHandler = (GVideoHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
    localQQAppInterface.addObserver(new WerewolvesHostInterface.5(this, localQQAppInterface));
    localGVideoHandler.a(paramString);
  }
  
  public String getQQVersion()
  {
    return "8.7.0";
  }
  
  public String getSKey()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return ((TicketManager)localQQAppInterface.getManager(2)).getSkey(localQQAppInterface.getCurrentAccountUin());
  }
  
  public void hideAllPanels()
  {
    if (this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie != null) {
      this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.ad();
    }
  }
  
  public boolean isFriend(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return ((FriendsManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
  }
  
  public boolean isNetworkAvailable()
  {
    return NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication());
  }
  
  public void logD(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public void logE(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e(paramString1, 2, paramString2);
    }
  }
  
  public void logE(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e(paramString1, 2, paramString2, paramThrowable);
    }
  }
  
  public void logI(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public void logW(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(paramString1, 2, paramString2);
    }
  }
  
  public void onExist()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.werewolf.WerewolvesHostInterface", 2, "onExist");
    }
    if ((this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie != null) && (this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie != null)) {
      this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.d(HardCodeUtil.a(2131716408));
    }
    existRoom();
  }
  
  public void onKickOut()
  {
    if (this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie != null) {
      this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.d(HardCodeUtil.a(2131716409));
    }
    existRoom();
  }
  
  public void openHalfWebVew(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, HalfScreenBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).setInGameGift(true);
  }
  
  public void openUrl(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void sendPb(String paramString, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramOIDBSSOPkg.toByteArray());
    localNewIntent.setObserver(paramBusinessObserver);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public void setDarkTheme(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie != null) {
      this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.b(paramBoolean1, paramBoolean2);
    }
  }
  
  public void setFollowed(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "2";
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    NearbyHandler.a(localQQAppInterface, paramString, "6", str, 1, new WerewolvesHostInterface.4(this, localQQAppInterface, paramString, str, paramBoolean));
  }
  
  public void setSoundEnable(boolean paramBoolean)
  {
    IGameRoomAVControllerDelegate localIGameRoomAVControllerDelegate = this.gameRoomAVControllerDelegate;
    if (localIGameRoomAVControllerDelegate != null)
    {
      if (localIGameRoomAVControllerDelegate.isBinded())
      {
        this.gameRoomAVControllerDelegate.setSoundEnable(paramBoolean);
        return;
      }
      this.gameRoomAVControllerDelegate.bindService(new WerewolvesHostInterface.2(this, paramBoolean));
    }
  }
  
  public void showActionSheet(String paramString, String[] paramArrayOfString, int[] paramArrayOfInt, Object paramObject)
  {
    if (this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie == null) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(this.manager.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a());
    if (!TextUtils.isEmpty(paramString)) {
      localActionSheet.setMainTitle(paramString);
    }
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localActionSheet.addButton(paramArrayOfString[i], paramArrayOfInt[i]);
      i += 1;
    }
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new WerewolvesHostInterface.3(this, paramObject, localActionSheet));
    localActionSheet.show();
  }
  
  public Dialog showCustomDialog(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = DialogUtil.a(paramContext, 230);
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.setTitle(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.setMessage(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      paramContext.setPositiveButton(paramString3, paramOnClickListener1);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramContext.setNegativeButton(paramString4, paramOnClickListener2);
    }
    paramContext.show();
    return paramContext;
  }
  
  public void showQQToast(int paramInt1, String paramString, int paramInt2)
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299168);
    QQToast.a(BaseApplicationImpl.getApplication(), paramInt1, paramString, paramInt2).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHostInterface
 * JD-Core Version:    0.7.0.1
 */