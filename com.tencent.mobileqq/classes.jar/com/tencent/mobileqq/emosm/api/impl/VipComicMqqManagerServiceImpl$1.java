package com.tencent.mobileqq.emosm.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class VipComicMqqManagerServiceImpl$1
  extends DownloadListener
{
  VipComicMqqManagerServiceImpl$1(VipComicMqqManagerServiceImpl paramVipComicMqqManagerServiceImpl, File paramFile, CustomEmotionData paramCustomEmotionData, IFavroamingDBManagerService paramIFavroamingDBManagerService, List paramList1, IPicDownloadListener paramIPicDownloadListener, List paramList2, EntityManager paramEntityManager, VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.a == 0) && (this.jdField_a_of_type_JavaIoFile.exists()))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath = this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      if ("needDownload".equals(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.RomaingType)) {
        this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.RomaingType = "isUpdate";
      }
      if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath)))
      {
        paramDownloadTask = SecUtil.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath);
        if (!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5.equals(paramDownloadTask))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("init = ");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
          localStringBuilder.append(" , compute = ");
          localStringBuilder.append(paramDownloadTask);
          QLog.i("VipComicMqqManager", 2, localStringBuilder.toString());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService.updateCustomEmotion(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      VipComicMqqManagerServiceImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplVipComicMqqManagerServiceImpl, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData, true);
    }
    else
    {
      this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService.deleteCustomEmotion(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(this.jdField_a_of_type_ComTencentMobileqqDataVipComicFavorEmoStructMsgInfo);
      VipComicMqqManagerServiceImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqEmosmApiImplVipComicMqqManagerServiceImpl, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData, false);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
      paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener;
      if (paramDownloadTask != null) {
        paramDownloadTask.onDone(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.VipComicMqqManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */