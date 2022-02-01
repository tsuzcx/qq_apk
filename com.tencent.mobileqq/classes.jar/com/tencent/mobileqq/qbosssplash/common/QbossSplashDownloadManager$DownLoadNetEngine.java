package com.tencent.mobileqq.qbosssplash.common;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qbosssplash.model.SplashItem;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QbossSplashDownloadManager$DownLoadNetEngine
  implements INetEngineListener
{
  int jdField_a_of_type_Int;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public QbossSplashDownloadManager$DownLoadNetEngine(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString4;
    this.d = paramString2;
    this.c = paramString3;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    try
    {
      if (paramNetResp.mResult == 0)
      {
        QLog.i("QSplash@QbossSplashDownloadManager", 1, "ResFile has download!");
        if (!TextUtils.isEmpty(this.d))
        {
          if (SplashItem.a(this.d, false))
          {
            paramNetResp = new File(this.d);
            paramNetResp.renameTo(new File(this.d.substring(0, this.d.lastIndexOf("."))));
            long l = paramNetResp.length();
            paramNetResp = (PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
            if (paramNetResp.isEnable())
            {
              QLog.i("QSplash@QbossSplashUtil", 1, "preDownloadSuccess");
              paramNetResp.preDownloadSuccess(this.b, l);
            }
            QbossSplashDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_JavaLangString);
            return;
          }
          QbossSplashDownloadManager.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          QLog.i("QSplash@QbossSplashUtil", 1, "ResFile check not exist");
        }
      }
      else if (paramNetResp.mResult == 1)
      {
        QbossSplashDownloadManager.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        QLog.i("QSplash@QbossSplashUtil", 1, "ResFile dowload faield");
      }
      return;
    }
    catch (Exception paramNetResp) {}
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qbosssplash.common.QbossSplashDownloadManager.DownLoadNetEngine
 * JD-Core Version:    0.7.0.1
 */