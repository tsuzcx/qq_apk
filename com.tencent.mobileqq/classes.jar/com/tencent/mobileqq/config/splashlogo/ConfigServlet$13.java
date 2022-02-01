package com.tencent.mobileqq.config.splashlogo;

import android.text.TextUtils;
import arry;
import azet;
import bhsi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class ConfigServlet$13
  implements Runnable
{
  public ConfigServlet$13(arry paramarry, ConfigurationService.Config paramConfig, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    boolean bool2 = false;
    ScribbleResMgr localScribbleResMgr = ScribbleResMgr.a();
    int k = this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.version.get();
    int j = bhsi.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    if (this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.msg_content_list != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.msg_content_list.size();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("handleScribbleConfigSPLASH_ConfigServlet", 2, String.format("scribble回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }));
      }
      if (k != j) {
        break;
      }
      return;
    }
    boolean bool1;
    Object localObject1;
    int m;
    byte[] arrayOfByte;
    label193:
    boolean bool3;
    if (i > 0)
    {
      j = 0;
      bool1 = false;
      if (j < i)
      {
        localObject1 = (ConfigurationService.Content)this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$Config.msg_content_list.get(j);
        if (localObject1 == null) {
          break label441;
        }
        m = ((ConfigurationService.Content)localObject1).task_id.get();
        if (((ConfigurationService.Content)localObject1).compress.get() == 1)
        {
          arrayOfByte = azet.a(((ConfigurationService.Content)localObject1).content.get().toByteArray());
          if (arrayOfByte == null)
          {
            QLog.d("handleScribbleConfigSPLASH_ConfigServlet", 2, "解压错误");
            localObject1 = null;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label441;
            }
            if ((m != 2599) && (m != 4446)) {
              break label351;
            }
            bool3 = localScribbleResMgr.a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2599);
            bool2 = bool1;
            bool1 = bool3;
          }
        }
      }
    }
    label441:
    for (;;)
    {
      for (;;)
      {
        j += 1;
        bool3 = bool2;
        bool2 = bool1;
        bool1 = bool3;
        break;
        try
        {
          localObject1 = new String(arrayOfByte, "UTF-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          if (QLog.isColorLevel()) {
            localUnsupportedEncodingException.printStackTrace();
          }
          Object localObject2 = null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              localOutOfMemoryError.printStackTrace();
            }
            System.gc();
            try
            {
              String str1 = new String(arrayOfByte, "UTF-8");
            }
            catch (Throwable localThrowable)
            {
              str2 = null;
            }
          }
        }
      }
      break label193;
      String str2 = str2.content.get().toStringUtf8();
      break label193;
      label351:
      if ((m == 2598) || (m == 4448))
      {
        bool3 = localScribbleResMgr.a(str2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2598);
        bool1 = bool2;
        bool2 = bool3;
        continue;
        if ((bool2) && (bool1)) {
          bhsi.p(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), k);
        }
        for (;;)
        {
          localScribbleResMgr.a();
          return;
          if (QLog.isColorLevel()) {
            QLog.d("handleScribbleConfigSPLASH_ConfigServlet", 2, "回包为空");
          }
        }
      }
      else
      {
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.13
 * JD-Core Version:    0.7.0.1
 */