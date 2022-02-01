package com.tencent.mobileqq.troop.troopgame;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class TroopGameCardResDownloadManager
  implements ResDownloadManager.IResDownloadListener
{
  public static String a;
  private ResDownloadManager jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager;
  private TroopGameCardResDownloadManager.IStatusListener jdField_a_of_type_ComTencentMobileqqTroopTroopgameTroopGameCardResDownloadManager$IStatusListener;
  
  public TroopGameCardResDownloadManager(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager = ((ResDownloadManager)paramAppInterface.getManager(QQManagerFactory.ARMAP_RES_DOWNLOAD));; this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager = new ResDownloadManager(paramAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(this);
      return;
    }
  }
  
  public static String a()
  {
    String str = null;
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("troop_game_card_sp", 4).getString("resPath", jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      if (!jdField_a_of_type_JavaLangString.endsWith(File.separator)) {
        break label86;
      }
    }
    label86:
    for (str = jdField_a_of_type_JavaLangString;; str = jdField_a_of_type_JavaLangString + File.separator)
    {
      str = str + "Gameicon" + File.separator;
      return str;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameTroopGameCardResDownloadManager$IStatusListener != null)
    {
      if (paramInt == 0) {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameTroopGameCardResDownloadManager$IStatusListener.a(paramString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameTroopGameCardResDownloadManager$IStatusListener.b(paramInt);
  }
  
  public void a(TroopGameCardResDownloadManager.ResInfo paramResInfo)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardResDownloadManager", 2, "startDownload res...");
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(paramResInfo.jdField_a_of_type_JavaLangString, paramResInfo.b, ".zip", true, 7);
      return;
    }
    finally {}
  }
  
  public void a(TroopGameCardResDownloadManager.ResInfo paramResInfo, TroopGameCardResDownloadManager.IStatusListener paramIStatusListener)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("checkResDownloadReady resUrl is ");
      if (paramResInfo != null) {
        break label129;
      }
      str = "emptyUrl";
      localStringBuilder = localStringBuilder.append(str).append(" resMd5 is ");
      if (paramResInfo != null) {
        break label137;
      }
    }
    label129:
    label137:
    for (String str = "emptyMd5";; str = paramResInfo.b)
    {
      QLog.d("TroopGameCardResDownloadManager", 2, str);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameTroopGameCardResDownloadManager$IStatusListener = paramIStatusListener;
      if ((paramResInfo != null) && (!TextUtils.isEmpty(paramResInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramResInfo.b))) {
        break label145;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopGameCardResDownloadManager", 2, "need pull config");
      }
      ((TroopGameCardConfigProcessor)QConfigManager.a().a(695)).a(new TroopGameCardResDownloadManager.1(this));
      return;
      str = paramResInfo.jdField_a_of_type_JavaLangString;
      break;
    }
    label145:
    a(paramResInfo);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardResDownloadManager", 2, "onDownloadUpdate,url =   " + paramString1 + ",md5 = " + paramString2 + ",percent = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameTroopGameCardResDownloadManager$IStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameTroopGameCardResDownloadManager$IStatusListener.a(paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardResDownloadManager", 2, "onDownloadFinish,url =   " + paramString1 + ",md5 = " + paramString2 + ",errCode = " + paramInt + ",path = " + paramString3 + ",userData = " + paramObject);
    }
    if (paramString3.endsWith("/")) {}
    for (;;)
    {
      a(paramInt, paramString3);
      return;
      paramString3 = paramString3 + File.separator;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardResDownloadManager", 2, "onDownloadStart()");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameTroopGameCardResDownloadManager$IStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameTroopGameCardResDownloadManager$IStatusListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardResDownloadManager
 * JD-Core Version:    0.7.0.1
 */