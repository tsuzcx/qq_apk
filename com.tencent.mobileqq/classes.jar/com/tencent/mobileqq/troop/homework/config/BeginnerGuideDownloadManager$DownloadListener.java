package com.tencent.mobileqq.troop.homework.config;

import android.os.Handler;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class BeginnerGuideDownloadManager$DownloadListener
  implements INetEngineListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  
  BeginnerGuideDownloadManager$DownloadListener(BeginnerGuideDownloadManager paramBeginnerGuideDownloadManager, Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener onResp: " + paramNetResp.mResult + ", desc: " + paramNetResp.mErrDesc);
    }
    if (paramNetResp.mResult == 3) {
      return;
    }
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = BeginnerGuideDownloadManager.a(paramNetResp.mReq.mOutPath);
      if (BeginnerGuideDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkConfigBeginnerGuideDownloadManager).equalsIgnoreCase(paramNetResp))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener download success");
        }
        BeginnerGuideDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkConfigBeginnerGuideDownloadManager, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener download success, md5 check failed");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1112);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener onResp error");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1113);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideDownloadManager", 2, "BeginnerGuideDownloadManager$DownloadListener Dowloading " + paramLong1 + "/" + paramLong2 + " " + 100L * paramLong1 / paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.config.BeginnerGuideDownloadManager.DownloadListener
 * JD-Core Version:    0.7.0.1
 */