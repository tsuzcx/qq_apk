package com.tencent.mobileqq.earlydownload.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.xmldata.PokeResData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PokeResHandler
  extends EarlyHandler
{
  private boolean d = false;
  
  public PokeResHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.poke.res_0625", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10044;
  }
  
  public Class<? extends XmlData> a()
  {
    return PokeResData.class;
  }
  
  public String a()
  {
    return "PokeResHandler_0625";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnDownloadSuccess:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PokeResHandler_0625", 2, ((StringBuilder)localObject).toString());
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PokeResHandler_0625", 2, "doOnDownloadSuccess sorse not exists");
      }
      return;
    }
    Object localObject = VFSAssistantUtils.getSDKPrivatePath(PokeItemHelper.a());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnDownloadSuccess imagePath=");
      localStringBuilder.append((String)localObject);
      QLog.d("PokeResHandler_0625", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new PokeResHandler.1(this, (String)localObject, paramString), 8, null, true);
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    ThreadManager.executeOnSubThread(new PokeResHandler.2(this));
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public void f()
  {
    BaseApplication.getContext().getSharedPreferences("vasPokeConfig", 0).edit().putBoolean("ready", true);
  }
  
  public boolean g()
  {
    if (!this.d) {
      this.d = BaseApplication.getContext().getSharedPreferences("vasPokeConfig", 0).getBoolean("ready", false);
    }
    return super.g() & this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.PokeResHandler
 * JD-Core Version:    0.7.0.1
 */