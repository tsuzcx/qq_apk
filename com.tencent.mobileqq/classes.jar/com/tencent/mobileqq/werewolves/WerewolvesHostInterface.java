package com.tencent.mobileqq.werewolves;

import aiav;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import anvk;
import anvx;
import anzr;
import aoep;
import axrb;
import bdla;
import bhdj;
import bheg;
import bikt;
import bilc;
import bild;
import bile;
import bilf;
import bilg;
import bilj;
import bkzi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import nta;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class WerewolvesHostInterface
{
  public static final String TAG = "Q.werewolf.WerewolvesHostInterface";
  public axrb mGameRoomAVController;
  public bilj manager;
  
  public WerewolvesHostInterface(bilj parambilj)
  {
    this.manager = parambilj;
    this.mGameRoomAVController = axrb.a();
  }
  
  public void disableMic()
  {
    if (this.manager.jdField_a_of_type_Aiav != null) {
      this.manager.jdField_a_of_type_Aiav.a(false);
    }
    while (this.mGameRoomAVController == null) {
      return;
    }
    if (this.mGameRoomAVController.a())
    {
      this.mGameRoomAVController.c();
      return;
    }
    this.mGameRoomAVController.a(new bilc(this));
  }
  
  public void enableMic()
  {
    if (this.manager.jdField_a_of_type_Aiav != null) {
      this.manager.jdField_a_of_type_Aiav.a(true);
    }
  }
  
  public void enterProfile(String paramString)
  {
    Object localObject1;
    if (this.manager.jdField_a_of_type_Aiav != null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      boolean bool1 = ((anvk)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
      String str = getCurrentRoomUin();
      Object localObject2 = localQQAppInterface.getHotChatMng(false);
      ProfileActivity.AllInOne localAllInOne = null;
      localObject1 = localAllInOne;
      if (localObject2 != null)
      {
        localObject2 = ((HotChatManager)localObject2).a(str);
        localObject1 = localAllInOne;
        if (localObject2 != null) {
          localObject1 = ((HotChatInfo)localObject2).troopCode;
        }
      }
      localAllInOne = new ProfileActivity.AllInOne(paramString, 42);
      localAllInOne.h = 113;
      localAllInOne.d = str;
      localAllInOne.c = ((String)localObject1);
      localObject1 = new Intent(this.manager.jdField_a_of_type_Aiav.getActivity(), NearbyPeopleProfileActivity.class);
      ((Intent)localObject1).putExtra("is_from_werewolves", true);
      ((Intent)localObject1).putExtra("AllInOne", localAllInOne);
      boolean bool2 = localQQAppInterface.getCurrentAccountUin().equals(paramString);
      HotChatManager.a = false;
      if ((bool1) || (bool2)) {
        ProfileActivity.b(this.manager.jdField_a_of_type_Aiav.getActivity(), localAllInOne);
      }
    }
    else
    {
      return;
    }
    ((Intent)localObject1).putExtra("param_mode", 3);
    this.manager.jdField_a_of_type_Aiav.getActivity().startActivity((Intent)localObject1);
  }
  
  public void existRoom()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    HotChatInfo localHotChatInfo = localQQAppInterface.getHotChatMng(true).a(getCurrentRoomUin());
    if (QLog.isColorLevel()) {
      QLog.d("Q.werewolf.WerewolvesHostInterface", 2, "onExist uin = " + localQQAppInterface.getCurrentAccountUin());
    }
    if (localHotChatInfo != null) {
      ((bikt)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(localHotChatInfo);
    }
    axrb.a().d();
  }
  
  public void exitChatPie()
  {
    if (this.manager.jdField_a_of_type_Aiav != null) {
      this.manager.jdField_a_of_type_Aiav.finish(1);
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
    Object localObject1 = null;
    Object localObject2;
    if (this.manager.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject2 = (anvk)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
      boolean bool = ((QQAppInterface)localObject1).getCurrentAccountUin().equals(paramString);
      if ((!((anvk)localObject2).b(paramString)) && (!bool)) {
        break label126;
      }
      localObject2 = this.manager.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramString, 200);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramBoolean)
        {
          this.manager.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, 1, true);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = bheg.c();
      }
      return paramString;
      label126:
      localObject2 = this.manager.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(32, paramString, 200);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramBoolean)
        {
          this.manager.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeStrangeFace(paramString, 200, true, false);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public void getFollowStatus(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aoep localaoep = (aoep)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    localQQAppInterface.addObserver(new bilg(this, localQQAppInterface));
    localaoep.s(paramString);
  }
  
  public String getQQVersion()
  {
    return "8.4.10";
  }
  
  public String getSKey()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return ((TicketManager)localQQAppInterface.getManager(2)).getSkey(localQQAppInterface.getCurrentAccountUin());
  }
  
  public void hideAllPanels()
  {
    if (this.manager.jdField_a_of_type_Aiav != null) {
      this.manager.jdField_a_of_type_Aiav.hideAllPanels();
    }
  }
  
  public boolean isFriend(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return ((anvk)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
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
    if ((this.manager.jdField_a_of_type_Aiav != null) && (this.manager.jdField_a_of_type_Aiav != null)) {
      this.manager.jdField_a_of_type_Aiav.a(anvx.a(2131716292));
    }
    existRoom();
  }
  
  public void onKickOut()
  {
    if (this.manager.jdField_a_of_type_Aiav != null) {
      this.manager.jdField_a_of_type_Aiav.a(anvx.a(2131716293));
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
    axrb.a().d = true;
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
    bdla.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void sendPb(String paramString, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), nta.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramOIDBSSOPkg.toByteArray());
    localNewIntent.setObserver(paramBusinessObserver);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public void setDarkTheme(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.manager.jdField_a_of_type_Aiav != null) {
      this.manager.jdField_a_of_type_Aiav.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void setFollowed(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      anzr.a(localQQAppInterface, paramString, "6", str, 1, new bilf(this, localQQAppInterface, paramString, str, paramBoolean));
      return;
    }
  }
  
  public void setSoundEnable(boolean paramBoolean)
  {
    if (this.mGameRoomAVController != null)
    {
      if (this.mGameRoomAVController.a()) {
        this.mGameRoomAVController.a(paramBoolean);
      }
    }
    else {
      return;
    }
    this.mGameRoomAVController.a(new bild(this, paramBoolean));
  }
  
  public void showActionSheet(String paramString, String[] paramArrayOfString, int[] paramArrayOfInt, Object paramObject)
  {
    if (this.manager.jdField_a_of_type_Aiav == null) {
      return;
    }
    bkzi localbkzi = bkzi.a(this.manager.jdField_a_of_type_Aiav.getActivity());
    if (!TextUtils.isEmpty(paramString)) {
      localbkzi.a(paramString);
    }
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localbkzi.a(paramArrayOfString[i], paramArrayOfInt[i]);
      i += 1;
    }
    localbkzi.c(2131690697);
    localbkzi.a(new bile(this, paramObject, localbkzi));
    localbkzi.show();
  }
  
  public Dialog showCustomDialog(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = bhdj.a(paramContext, 230);
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
    int i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299080);
    QQToast.a(BaseApplicationImpl.getApplication(), paramInt1, paramString, paramInt2).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHostInterface
 * JD-Core Version:    0.7.0.1
 */