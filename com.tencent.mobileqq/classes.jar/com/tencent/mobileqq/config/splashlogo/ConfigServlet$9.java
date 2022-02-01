package com.tencent.mobileqq.config.splashlogo;

import com.tencent.mobileqq.app.DynamicSplashManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

class ConfigServlet$9
  implements Runnable
{
  ConfigServlet$9(ConfigServlet paramConfigServlet, ConfigurationService.Config paramConfig, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject;
    if ((this.a.content_list != null) && (this.a.content_list.size() > 0) && (this.a.version != null))
    {
      localObject = (String)this.a.content_list.get(0);
      int i = this.a.version.get();
      int j = SharedPreUtils.F(this.b.getApp());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("receiveAllConfigs|type: 63,content: ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",version: ");
        localStringBuilder.append(this.a.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
      }
      if (i > j) {
        DynamicSplashManager.a(this.b, (String)localObject, i);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receiveAllConfigs|type: 63,content_list is empty ,version: ");
      ((StringBuilder)localObject).append(this.a.version.get());
      QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.9
 * JD-Core Version:    0.7.0.1
 */