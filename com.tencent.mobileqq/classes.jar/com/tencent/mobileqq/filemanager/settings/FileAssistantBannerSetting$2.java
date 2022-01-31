package com.tencent.mobileqq.filemanager.settings;

import amlc;
import android.text.TextUtils;
import apbv;
import apbw;
import apck;
import axro;
import axrr;
import axsp;
import axsr;
import badq;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FileAssistantBannerSetting$2
  implements Runnable
{
  public FileAssistantBannerSetting$2(apbv paramapbv, amlc paramamlc) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.a.e())) || (TextUtils.isEmpty(this.a.b()))) {
      QLog.w("FileAssistantBannerSetting", 1, "localPath or picUrl is null!");
    }
    do
    {
      do
      {
        return;
        localObject = HexUtil.bytes2HexStr(apck.d(this.a.e()));
        if ((localObject == null) || (!((String)localObject).equalsIgnoreCase(this.a.a()))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileAssistantBannerSetting", 1, "server pic md5 == localMd5 return!");
      return;
      new File(this.a.e()).delete();
      Object localObject = new axro();
      ((axro)localObject).jdField_a_of_type_Axrt = new apbw(this);
      ((axro)localObject).jdField_a_of_type_JavaLangString = this.a.b();
      ((axro)localObject).jdField_a_of_type_Int = 0;
      ((axro)localObject).jdField_c_of_type_JavaLangString = this.a.e();
      ((axro)localObject).jdField_c_of_type_Int = badq.a(axsr.a().a());
      apbv.a(this.this$0).getNetEngine(0).a((axsp)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("FileAssistantBannerSetting", 1, "preLoadBannerResources, url: " + this.a.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FileAssistantBannerSetting.2
 * JD-Core Version:    0.7.0.1
 */