package com.tencent.mobileqq.vassplash.common;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.vassplash.model.SplashItem;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class VasSplashDownloadManager$DownLoadNetEngine
  implements INetEngineListener
{
  int jdField_a_of_type_Int;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public VasSplashDownloadManager$DownLoadNetEngine(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
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
      int i = paramNetResp.mResult;
      if (i == 0)
      {
        QLog.i("QSplash@VasSplashDownloadManager", 1, "ResFile has download!");
        if (!TextUtils.isEmpty(this.d))
        {
          if (SplashItem.a(this.d, false))
          {
            paramNetResp = new File(this.d);
            paramNetResp.renameTo(new File(this.d.substring(0, this.d.lastIndexOf("."))));
            long l = paramNetResp.length();
            paramNetResp = (IPreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPreDownloadController.class);
            if (paramNetResp.isEnable())
            {
              QLog.i("QSplash@VasSplashUtil", 1, "preDownloadSuccess");
              paramNetResp.preDownloadSuccess(this.b, l);
            }
            VasSplashDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_JavaLangString);
            return;
          }
          VasSplashDownloadManager.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          QLog.i("QSplash@VasSplashUtil", 1, "ResFile check not exist");
        }
      }
      else if (paramNetResp.mResult == 1)
      {
        VasSplashDownloadManager.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        QLog.i("QSplash@VasSplashUtil", 1, "ResFile dowload faield");
      }
      return;
    }
    catch (Exception paramNetResp) {}
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vassplash.common.VasSplashDownloadManager.DownLoadNetEngine
 * JD-Core Version:    0.7.0.1
 */