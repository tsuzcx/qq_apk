package com.tencent.mobileqq.filemanager.settings;

import anbg;
import android.text.TextUtils;
import aptp;
import aptq;
import apue;
import ayrv;
import ayry;
import aysw;
import aysy;
import bbev;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FileAssistantBannerSetting$2
  implements Runnable
{
  public FileAssistantBannerSetting$2(aptp paramaptp, anbg paramanbg) {}
  
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
        localObject = HexUtil.bytes2HexStr(apue.d(this.a.e()));
        if ((localObject == null) || (!((String)localObject).equalsIgnoreCase(this.a.a()))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileAssistantBannerSetting", 1, "server pic md5 == localMd5 return!");
      return;
      new File(this.a.e()).delete();
      Object localObject = new ayrv();
      ((ayrv)localObject).jdField_a_of_type_Aysa = new aptq(this);
      ((ayrv)localObject).jdField_a_of_type_JavaLangString = this.a.b();
      ((ayrv)localObject).jdField_a_of_type_Int = 0;
      ((ayrv)localObject).jdField_c_of_type_JavaLangString = this.a.e();
      ((ayrv)localObject).jdField_c_of_type_Int = bbev.a(aysy.a().a());
      aptp.a(this.this$0).getNetEngine(0).a((aysw)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("FileAssistantBannerSetting", 1, "preLoadBannerResources, url: " + this.a.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FileAssistantBannerSetting.2
 * JD-Core Version:    0.7.0.1
 */