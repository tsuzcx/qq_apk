package com.tencent.mobileqq.profilecard.vas;

import android.text.TextUtils;
import aymg;
import aymh;
import aymn;
import aynt;
import ayxr;
import ayxs;
import ayyq;
import bfrj;
import bgga;
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
  private aymg jdField_a_of_type_Aymg;
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
    this.jdField_a_of_type_Aymg = paramFriendProfileCardActivity.jdField_a_of_type_Aymg;
  }
  
  private void a(Card paramCard)
  {
    if (paramCard.lCurrentStyleId != aymn.g) {}
    while (VipProfileCardDiyActivity.a(this.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId)) {
      return;
    }
    paramCard = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184);
    paramCard.addCallBacker(new ayxr(this));
    paramCard.downloadItem(5L, "font.diycard.android." + this.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId, "ProfileTemplateCheckController");
  }
  
  private void a(Card paramCard, aymn paramaymn)
  {
    String str = paramCard.backgroundUrl;
    long l = paramCard.lCurrentBgId;
    boolean bool;
    if (paramCard.lCurrentStyleId == aymn.j)
    {
      bool = aymh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramCard.lCurrentBgId, "wzMainImage.png");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate heroFileExist=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if ((!bool) && (a())) {
        a(str, l, paramaymn);
      }
    }
    if ((paramCard.lCurrentStyleId == aymn.j) || (paramCard.lCurrentStyleId == aymn.i))
    {
      bool = aynt.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, "cardWZ.zip");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate heroTemplateExist=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if ((!this.e) && (!bool))
      {
        aynt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ayxs(this, paramaymn, paramCard));
        this.e = true;
      }
    }
  }
  
  private void a(String paramString, long paramLong, aymn paramaymn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckController", 2, String.format("downloadProfileCardRes bgUrl=%s bgId=%s mIsDownloadTemplateRunning=%s", new Object[] { paramString, Long.valueOf(paramLong), this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean }));
    }
    if ((paramLong != 160L) && (paramLong != 1600L)) {
      ((bgga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "card." + paramLong);
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      ThreadManagerV2.excute(new VasProfileTemplateController.DownloadTemplateRunnable(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramaymn, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, paramString, paramLong), 128, null, true);
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
    boolean bool3 = bfrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool1;
    if ((l2 == 160L) || (l2 == 1600L)) {
      bool1 = bfrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), str);
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
        boolean bool2 = aymh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), l2, "dynamicBottom.jpg");
        bool1 = bool2;
        if (!bool2) {
          bool1 = new File(aymh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), l1, l2)).exists();
        }
      }
      else
      {
        bool1 = new File(aymh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), l1, l2)).exists();
      }
    }
    return false;
  }
  
  private void b(Card paramCard, aymn paramaymn)
  {
    String str = paramCard.backgroundUrl;
    int i = paramCard.dynamicCardFlag;
    long l = paramCard.lCurrentBgId;
    if (i == 1)
    {
      boolean bool = aymh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), l, ".dynamic");
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate dynamicBackgroundExist=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      if ((!bool) && (a())) {
        a(str, l, paramaymn);
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
      if (this.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl)) {
          break label305;
        }
        if (!TextUtils.isEmpty(paramCard.backgroundUrl)) {
          this.jdField_a_of_type_Boolean = true;
        }
        if ((this.jdField_a_of_type_Aymg.jdField_a_of_type_Long != paramCard.lCurrentStyleId) || (this.jdField_a_of_type_Aymg.b != aymn.a(paramCard))) {
          this.b = true;
        }
        if ((this.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == aymn.g) && (!TextUtils.isEmpty(paramCard.diyText))) {
          this.c = true;
        }
      }
      label129:
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate updateBG=%s updateStyle=%s updateDiyText=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.b), Boolean.valueOf(this.c) }));
      }
      this.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
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
        localaymn = bfrj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, true);
        if ((l1 > 0L) && (localaymn != null) && (!TextUtils.isEmpty(str)) && (paramInt == 0)) {
          continue;
        }
        this.jdField_a_of_type_Aymg.jdField_a_of_type_Aymn = null;
      }
      catch (Throwable localThrowable)
      {
        long l1;
        long l2;
        long l3;
        aymn localaymn;
        label305:
        QLog.e("ProfileTemplateCheckController", 1, "onCardUpdate fail.", localThrowable);
        this.jdField_a_of_type_Aymg.jdField_a_of_type_Aymn = null;
        continue;
        this.jdField_a_of_type_Aymg.jdField_a_of_type_Aymn = null;
        continue;
        if (!a()) {
          continue;
        }
        a(localThrowable, l3, localaymn);
        continue;
        this.jdField_a_of_type_Aymg.jdField_a_of_type_Aymn = null;
        continue;
      }
      if (this.c) {
        a(paramCard);
      }
      ayyq.a(this.jdField_a_of_type_Aymg);
      return;
      if (this.jdField_a_of_type_Aymg.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl.equals(paramCard.backgroundUrl)) {
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
      if (!localaymn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2, l1)) {
        continue;
      }
      this.jdField_a_of_type_Aymg.jdField_a_of_type_Aymn = localaymn;
      b(paramCard, localaymn);
      a(paramCard, localaymn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController
 * JD-Core Version:    0.7.0.1
 */