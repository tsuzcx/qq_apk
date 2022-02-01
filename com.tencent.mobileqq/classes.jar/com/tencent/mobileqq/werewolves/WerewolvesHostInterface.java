package com.tencent.mobileqq.werewolves;

import aikq;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import anyw;
import anzj;
import aodb;
import aoip;
import aoof;
import axxr;
import bdll;
import bhlq;
import bhmq;
import bhnv;
import bhpc;
import bitz;
import biui;
import biuj;
import biuk;
import biul;
import bium;
import biup;
import blir;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import nkl;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class WerewolvesHostInterface
{
  public static final String TAG = "Q.werewolf.WerewolvesHostInterface";
  public axxr mGameRoomAVController;
  public biup manager;
  
  public WerewolvesHostInterface(biup parambiup)
  {
    this.manager = parambiup;
    this.mGameRoomAVController = axxr.a();
  }
  
  public void disableMic()
  {
    if (this.manager.jdField_a_of_type_Aikq != null) {
      this.manager.jdField_a_of_type_Aikq.v(false);
    }
    while (this.mGameRoomAVController == null) {
      return;
    }
    if (this.mGameRoomAVController.a())
    {
      this.mGameRoomAVController.c();
      return;
    }
    this.mGameRoomAVController.a(new biui(this));
  }
  
  public void enableMic()
  {
    if (this.manager.jdField_a_of_type_Aikq != null) {
      this.manager.jdField_a_of_type_Aikq.v(true);
    }
  }
  
  public void enterProfile(String paramString)
  {
    Object localObject1;
    if (this.manager.jdField_a_of_type_Aikq != null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      boolean bool1 = ((anyw)localQQAppInterface.getManager(51)).b(paramString);
      String str = getCurrentRoomUin();
      Object localObject2 = localQQAppInterface.a(false);
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
      localObject1 = new Intent(this.manager.jdField_a_of_type_Aikq.a(), NearbyPeopleProfileActivity.class);
      ((Intent)localObject1).putExtra("is_from_werewolves", true);
      ((Intent)localObject1).putExtra("AllInOne", localAllInOne);
      boolean bool2 = localQQAppInterface.getCurrentAccountUin().equals(paramString);
      HotChatManager.a = false;
      if ((bool1) || (bool2)) {
        ProfileActivity.b(this.manager.jdField_a_of_type_Aikq.a(), localAllInOne);
      }
    }
    else
    {
      return;
    }
    ((Intent)localObject1).putExtra("param_mode", 3);
    this.manager.jdField_a_of_type_Aikq.a().startActivity((Intent)localObject1);
  }
  
  public void existRoom()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    HotChatInfo localHotChatInfo = localQQAppInterface.a(true).a(getCurrentRoomUin());
    if (QLog.isColorLevel()) {
      QLog.d("Q.werewolf.WerewolvesHostInterface", 2, "onExist uin = " + localQQAppInterface.getCurrentAccountUin());
    }
    if (localHotChatInfo != null) {
      ((bitz)localQQAppInterface.a(107)).a(localHotChatInfo);
    }
    axxr.a().d();
  }
  
  public void exitChatPie()
  {
    if (this.manager.jdField_a_of_type_Aikq != null) {
      this.manager.jdField_a_of_type_Aikq.b(1);
    }
  }
  
  public String getCurrentAccountUin()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c();
  }
  
  public String getCurrentRoomUin()
  {
    return this.manager.jdField_a_of_type_JavaLangString;
  }
  
  public Bitmap getFaceBitmap(String paramString, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2;
    if (this.manager.jdField_a_of_type_Aoof != null)
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject2 = (anyw)((QQAppInterface)localObject1).getManager(51);
      boolean bool = ((QQAppInterface)localObject1).getCurrentAccountUin().equals(paramString);
      if ((!((anyw)localObject2).b(paramString)) && (!bool)) {
        break label125;
      }
      localObject2 = this.manager.jdField_a_of_type_Aoof.a(1, paramString, 200);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramBoolean)
        {
          this.manager.jdField_a_of_type_Aoof.a(paramString, 1, true);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = bhmq.c();
      }
      return paramString;
      label125:
      localObject2 = this.manager.jdField_a_of_type_Aoof.a(32, paramString, 200);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramBoolean)
        {
          this.manager.jdField_a_of_type_Aoof.a(paramString, 200, true, false);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public void getFollowStatus(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    aoip localaoip = (aoip)localQQAppInterface.a(20);
    localQQAppInterface.addObserver(new bium(this, localQQAppInterface));
    localaoip.s(paramString);
  }
  
  public String getQQVersion()
  {
    return "8.4.5";
  }
  
  public String getSKey()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return ((TicketManager)localQQAppInterface.getManager(2)).getSkey(localQQAppInterface.getCurrentAccountUin());
  }
  
  public void hideAllPanels()
  {
    if (this.manager.jdField_a_of_type_Aikq != null) {
      this.manager.jdField_a_of_type_Aikq.aJ();
    }
  }
  
  public boolean isFriend(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return ((anyw)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(51)).b(paramString);
  }
  
  public boolean isNetworkAvailable()
  {
    return bhnv.g(BaseApplicationImpl.getApplication());
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
    if ((this.manager.jdField_a_of_type_Aikq != null) && (this.manager.jdField_a_of_type_Aikq != null)) {
      this.manager.jdField_a_of_type_Aikq.g(anzj.a(2131715710));
    }
    existRoom();
  }
  
  public void onKickOut()
  {
    if (this.manager.jdField_a_of_type_Aikq != null) {
      this.manager.jdField_a_of_type_Aikq.g(anzj.a(2131715711));
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
    axxr.a().d = true;
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
    bdll.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void sendPb(String paramString, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), nkl.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramOIDBSSOPkg.toByteArray());
    localNewIntent.setObserver(paramBusinessObserver);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public void setDarkTheme(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.manager.jdField_a_of_type_Aikq != null) {
      this.manager.jdField_a_of_type_Aikq.e(paramBoolean1, paramBoolean2);
    }
  }
  
  public void setFollowed(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      aodb.a(localQQAppInterface, paramString, "6", str, 1, new biul(this, localQQAppInterface, paramString, str, paramBoolean));
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
    this.mGameRoomAVController.a(new biuj(this, paramBoolean));
  }
  
  public void showActionSheet(String paramString, String[] paramArrayOfString, int[] paramArrayOfInt, Object paramObject)
  {
    if (this.manager.jdField_a_of_type_Aikq == null) {
      return;
    }
    blir localblir = blir.a(this.manager.jdField_a_of_type_Aikq.a());
    if (!TextUtils.isEmpty(paramString)) {
      localblir.a(paramString);
    }
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localblir.a(paramArrayOfString[i], paramArrayOfInt[i]);
      i += 1;
    }
    localblir.c(2131690580);
    localblir.a(new biuk(this, paramObject, localblir));
    localblir.show();
  }
  
  public Dialog showCustomDialog(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = bhlq.a(paramContext, 230);
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
    int i = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299011);
    QQToast.a(BaseApplicationImpl.getApplication(), paramInt1, paramString, paramInt2).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHostInterface
 * JD-Core Version:    0.7.0.1
 */