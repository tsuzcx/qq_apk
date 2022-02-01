package com.tencent.mobileqq.profilecard.vas;

import android.text.TextUtils;
import azxr;
import azxs;
import azxy;
import azze;
import baia;
import baib;
import baiz;
import bhhz;
import bhzq;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class VasProfileTemplateController
{
  private int jdField_a_of_type_Int;
  private azxr jdField_a_of_type_Azxr;
  private FriendProfileCardActivity jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public boolean b;
  public boolean c;
  private boolean d = true;
  private boolean e;
  
  public VasProfileTemplateController(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity = paramFriendProfileCardActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramFriendProfileCardActivity.app;
    this.jdField_a_of_type_Azxr = paramFriendProfileCardActivity.jdField_a_of_type_Azxr;
  }
  
  private void a(Card paramCard)
  {
    if (paramCard.lCurrentStyleId != azxy.g) {}
    while (VipProfileCardDiyActivity.a(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId)) {
      return;
    }
    paramCard = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184);
    paramCard.addCallBacker(new baia(this));
    paramCard.downloadItem(5L, "font.diycard.android." + this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId, "ProfileTemplateCheckController");
  }
  
  private void a(Card paramCard, azxy paramazxy)
  {
    String str = paramCard.backgroundUrl;
    long l = paramCard.lCurrentBgId;
    boolean bool;
    if (paramCard.lCurrentStyleId == azxy.j)
    {
      bool = azxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramCard.lCurrentBgId, "wzMainImage.png");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate heroFileExist=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if ((!bool) && (a())) {
        a(str, l, paramazxy);
      }
    }
    if ((paramCard.lCurrentStyleId == azxy.j) || (paramCard.lCurrentStyleId == azxy.i))
    {
      bool = azze.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, "cardWZ.zip");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate heroTemplateExist=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if ((!this.e) && (!bool))
      {
        azze.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new baib(this, paramazxy, paramCard));
        this.e = true;
      }
    }
  }
  
  private void a(String paramString, long paramLong, azxy paramazxy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckController", 2, String.format("downloadProfileCardRes bgUrl=%s bgId=%s mIsDownloadTemplateRunning=%s", new Object[] { paramString, Long.valueOf(paramLong), this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean }));
    }
    if ((paramLong != 160L) && (paramLong != 1600L)) {
      ((bhzq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "card." + paramLong);
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      ThreadManagerV2.excute(new VasProfileTemplateController.DownloadTemplateRunnable(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramazxy, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, paramString, paramLong), 128, null, true);
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Int > 3) {
      return false;
    }
    this.jdField_a_of_type_Int += 1;
    return true;
  }
  
  private boolean a(Card paramCard)
  {
    long l1 = paramCard.lCurrentStyleId;
    String str = paramCard.backgroundUrl;
    int i = paramCard.dynamicCardFlag;
    long l2 = paramCard.lCurrentBgId;
    boolean bool3 = bhhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool1;
    if ((l2 == 160L) || (l2 == 1600L)) {
      bool1 = bhhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), str);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate commonDirExist=%s backgroundImageExist=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
      }
      if ((!bool3) || (!bool1)) {
        break;
      }
      return true;
      if (i == 1)
      {
        boolean bool2 = azxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), l2, "dynamicBottom.jpg");
        bool1 = bool2;
        if (!bool2) {
          bool1 = new File(azxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), l1, l2)).exists();
        }
      }
      else
      {
        bool1 = new File(azxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), l1, l2)).exists();
      }
    }
    return false;
  }
  
  private void b(Card paramCard, azxy paramazxy)
  {
    String str = paramCard.backgroundUrl;
    int i = paramCard.dynamicCardFlag;
    long l = paramCard.lCurrentBgId;
    if (i == 1)
    {
      boolean bool = azxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), l, ".dynamic");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate dynamicBackgroundExist=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if ((!bool) && (a())) {
        a(str, l, paramazxy);
      }
    }
  }
  
  public void a(Card paramCard, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    if (paramInt == 8)
    {
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl)) {
          break label305;
        }
        if (!TextUtils.isEmpty(paramCard.backgroundUrl)) {
          this.jdField_a_of_type_Boolean = true;
        }
        if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_Long != paramCard.lCurrentStyleId) || (this.jdField_a_of_type_Azxr.b != azxy.a(paramCard))) {
          this.b = true;
        }
        if ((this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == azxy.g) && (!TextUtils.isEmpty(paramCard.diyText))) {
          this.c = true;
        }
      }
      label129:
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate updateBG=%s updateStyle=%s updateDiyText=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.b), Boolean.valueOf(this.c) }));
      }
      this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      if ((this.d) || (this.jdField_a_of_type_Boolean) || (this.b)) {
        this.d = false;
      }
    }
    for (;;)
    {
      try
      {
        l1 = paramCard.lCurrentStyleId;
        paramInt = paramCard.templateRet;
        String str = paramCard.backgroundUrl;
        l2 = paramCard.backgroundColor;
        l3 = paramCard.lCurrentBgId;
        localazxy = bhhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, true);
        if ((l1 > 0L) && (localazxy != null) && (!TextUtils.isEmpty(str)) && (paramInt == 0)) {
          continue;
        }
        this.jdField_a_of_type_Azxr.jdField_a_of_type_Azxy = null;
      }
      catch (Throwable localThrowable)
      {
        long l1;
        long l2;
        long l3;
        azxy localazxy;
        label305:
        QLog.e("ProfileTemplateCheckController", 1, "onCardUpdate fail.", localThrowable);
        this.jdField_a_of_type_Azxr.jdField_a_of_type_Azxy = null;
        continue;
        this.jdField_a_of_type_Azxr.jdField_a_of_type_Azxy = null;
        continue;
        if (!a()) {
          continue;
        }
        a(localThrowable, l3, localazxy);
        continue;
        this.jdField_a_of_type_Azxr.jdField_a_of_type_Azxy = null;
        continue;
      }
      if (this.c) {
        a(paramCard);
      }
      baiz.a(this.jdField_a_of_type_Azxr);
      return;
      if (this.jdField_a_of_type_Azxr.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl.equals(paramCard.backgroundUrl)) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      break;
      if (paramInt != 13) {
        break label129;
      }
      this.jdField_a_of_type_Boolean = true;
      break label129;
      if (!a(paramCard)) {
        continue;
      }
      if (!localazxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2, l1)) {
        continue;
      }
      this.jdField_a_of_type_Azxr.jdField_a_of_type_Azxy = localazxy;
      b(paramCard, localazxy);
      a(paramCard, localazxy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController
 * JD-Core Version:    0.7.0.1
 */