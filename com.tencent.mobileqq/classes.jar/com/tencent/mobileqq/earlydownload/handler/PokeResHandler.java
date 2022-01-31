package com.tencent.mobileqq.earlydownload.handler;

import abrv;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.xmldata.PokeResData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PokeResHandler
  extends EarlyHandler
{
  private boolean d;
  
  public PokeResHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.poke.res_1228", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10044;
  }
  
  public Class a()
  {
    return PokeResData.class;
  }
  
  public String a()
  {
    return "PokeResHandler_1228";
  }
  
  public void a()
  {
    BaseApplication.getContext().getSharedPreferences("vasPokeConfig", 0).edit().putBoolean("ready", true);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeResHandler_1228", 2, "doOnDownloadSuccess:" + paramString);
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeResHandler_1228", 2, "doOnDownloadSuccess sorse not exists");
      }
      return;
    }
    try
    {
      String str1 = PokeItemHelper.a();
      if (QLog.isColorLevel()) {
        QLog.d("PokeResHandler_1228", 2, "doOnDownloadSuccess imagePath=" + str1);
      }
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = str1 + "/poke";
        FileUtils.a(str2, false);
        FileUtils.a(paramString, str2, false);
      }
      PokeItemHelper.b(str1 + "/poke/");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    ThreadManager.executeOnSubThread(new abrv(this));
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean h()
  {
    if (!this.d) {
      this.d = BaseApplication.getContext().getSharedPreferences("vasPokeConfig", 0).getBoolean("ready", false);
    }
    return super.h() & this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.PokeResHandler
 * JD-Core Version:    0.7.0.1
 */