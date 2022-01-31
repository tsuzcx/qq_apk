package com.tencent.mobileqq.shortvideo.gesture;

import ahnl;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class GestureMgrAppDownload
{
  ahnl jdField_a_of_type_Ahnl = null;
  DownloadInfo jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = null;
  boolean jdField_a_of_type_Boolean = false;
  
  GestureMgrAppDownload()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, "GestureMgrAppDownload in QQAppInterface");
    }
    this.jdField_a_of_type_Ahnl = new ahnl();
  }
  
  public static void a(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.video.gesturemgr.notify");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("Event_Progress", paramInt);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public static void a(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    GestureMgr.a().a.b(paramIntent, paramConfig);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, "onEnterBackground");
    }
    a();
  }
  
  public static void a(ConfigurationService.ConfigSeq paramConfigSeq)
  {
    SharedPreferences localSharedPreferences = GestureUtil.a();
    if (!TextUtils.isEmpty(localSharedPreferences.getString("config", null))) {}
    for (int i = localSharedPreferences.getInt("ver", 0);; i = 0)
    {
      paramConfigSeq.version.set(i);
      paramConfigSeq.compress.set(1);
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGesture", 4, String.format("fillVersion[%s]", new Object[] { Integer.valueOf(i) }));
      }
      return;
    }
  }
  
  public static void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    SharedPreferences localSharedPreferences = GestureUtil.a();
    String str;
    if ((paramInt & 0x1) == 1)
    {
      str = paramDownloadInfo.b;
      localSharedPreferences.edit().putString("so_zip_md5", str).commit();
      a(paramDownloadInfo.g);
    }
    if ((paramInt & 0x2) == 2)
    {
      str = paramDownloadInfo.d;
      localSharedPreferences.edit().putString("model_zip_md5", str).commit();
    }
    if ((paramInt & 0x3) == 3)
    {
      paramDownloadInfo = paramDownloadInfo.j;
      localSharedPreferences.edit().putString("gamemodel_zip_md5", paramDownloadInfo).commit();
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      i = Integer.valueOf("345599").intValue();
      BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 4).edit().putInt("key_so_version_" + paramString, i);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public static boolean a()
  {
    return GestureMgr.a().a.b();
  }
  
  void b(Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    if (paramConfig == null)
    {
      QLog.d("QavGesture", 1, "handle_QAG_Gesture_Config, config is null");
      return;
    }
    SharedPreferences localSharedPreferences = GestureUtil.a();
    if (!TextUtils.isEmpty(localSharedPreferences.getString("config", null))) {}
    for (int i = localSharedPreferences.getInt("ver", 0);; i = 0)
    {
      if (paramConfig.msg_content_list != null) {}
      int m;
      for (int j = paramConfig.msg_content_list.size();; j = -1)
      {
        m = paramConfig.version.get();
        if (QLog.isColorLevel()) {
          QLog.d("QavGesture", 2, String.format("handle_QAG_Gesture_Config, serverVersion[%s], localVersion[%s], size[%s], autoDwonload[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
        }
        if (m == i) {
          break;
        }
        if ((j > 0) || (m == 0)) {
          break label198;
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = null;
        localSharedPreferences.edit().putString("config", null);
        localSharedPreferences.edit().putInt("ver", m);
        localSharedPreferences.edit().commit();
        return;
      }
      label198:
      Intent localIntent = null;
      Object localObject3 = null;
      int k = 0;
      int n;
      Object localObject4;
      label409:
      Object localObject2;
      if (k < j)
      {
        paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(k);
        if (paramIntent != null)
        {
          n = paramIntent.task_id.get();
          localObject4 = paramIntent.content.get();
          if (localObject4 != null)
          {
            Object localObject1 = "";
            if (paramIntent.compress.get() == 1)
            {
              localObject4 = OlympicUtil.a(((ByteStringMicro)localObject4).toByteArray());
              if (localObject4 == null) {}
            }
            for (;;)
            {
              try
              {
                paramIntent = new String((byte[])localObject4, "UTF-8");
                if (TextUtils.isEmpty(paramIntent)) {
                  break label679;
                }
                localObject1 = DownloadInfo.a(paramIntent);
                if (QLog.isColorLevel())
                {
                  if (localObject1 == null) {
                    break label644;
                  }
                  bool = true;
                  QLog.d("QavGesture", 2, String.format("handle_QAG_Gesture_Config, index[%s], task_id[%s], serverVersion[%s], localVersion[%s], size[%s], parseJson[%s], \n%s", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool), paramIntent }));
                }
                if (localObject1 == null) {
                  break label650;
                }
                if (n != ((DownloadInfo)localObject1).a) {
                  break label902;
                }
                if (TextUtils.isEmpty(paramIntent)) {
                  break;
                }
                this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = ((DownloadInfo)localObject1);
                localSharedPreferences.edit().putString("config", paramIntent);
                localSharedPreferences.edit().putInt("ver", m);
                localSharedPreferences.edit().commit();
                if (!this.jdField_a_of_type_Boolean) {
                  break;
                }
                this.jdField_a_of_type_Boolean = false;
                a();
                return;
              }
              catch (UnsupportedEncodingException paramIntent)
              {
                if (!QLog.isColorLevel()) {
                  break label885;
                }
                paramIntent.printStackTrace();
                paramIntent = "编码失败" + paramIntent.getMessage();
                localObject4 = null;
                localObject1 = paramIntent;
                paramIntent = (Intent)localObject4;
                continue;
              }
              catch (OutOfMemoryError paramIntent)
              {
                label520:
                if (QLog.isColorLevel())
                {
                  paramIntent.printStackTrace();
                  localObject1 = "内存不足" + paramIntent.getMessage();
                }
                System.gc();
                try
                {
                  paramIntent = new String((byte[])localObject4, "UTF-8");
                }
                catch (Throwable localThrowable)
                {
                  paramIntent = null;
                  localObject2 = "异常" + localThrowable.getMessage();
                }
                continue;
              }
              localObject2 = "解压失败";
              paramIntent = null;
              continue;
              paramIntent = ((ByteStringMicro)localObject4).toStringUtf8();
              localObject2 = "无压缩";
              continue;
              label644:
              boolean bool = false;
            }
            label650:
            paramIntent = localObject3;
            localObject2 = localIntent;
          }
        }
      }
      label902:
      for (;;)
      {
        localObject4 = paramIntent;
        paramIntent = (Intent)localObject2;
        for (;;)
        {
          k += 1;
          localObject3 = localObject4;
          localIntent = paramIntent;
          break;
          label679:
          localObject4 = localObject3;
          paramIntent = localIntent;
          if (QLog.isColorLevel())
          {
            QLog.d("QavGesture", 2, String.format("handle_QAG_Gesture_Config, err, index[%s], task_id[%s], serverVersion[%s], localVersion[%s], size[%s], %s", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), localObject2 }));
            localObject4 = localObject3;
            paramIntent = localIntent;
            continue;
            QLog.d("QavGesture", 1, String.format("handle_QAG_Gesture_Config, sub_content为空, index[%s], task_id[%s], serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) }));
            localObject4 = localObject3;
            paramIntent = localIntent;
            continue;
            QLog.d("QavGesture", 1, String.format("handle_QAG_Gesture_Config, content为空, index[%s], serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) }));
            localObject4 = localObject3;
            paramIntent = localIntent;
          }
        }
        label885:
        paramIntent = "";
        break label520;
        paramIntent = localObject3;
        localObject2 = localIntent;
        break label409;
      }
    }
  }
  
  boolean b()
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    boolean bool2;
    if ((localObject instanceof QQAppInterface))
    {
      if (((QQAppInterface)localObject).getManager(20) == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QavGesture", 4, "innerDownload, getNetEngine 为空");
        }
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QavGesture", 4, "appRuntime 不是 QQAppInterface");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo;
    if (localObject == null)
    {
      this.jdField_a_of_type_Boolean = true;
      return false;
    }
    if (11 == GestureUtil.a((DownloadInfo)localObject)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      return this.jdField_a_of_type_Ahnl.a((DownloadInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload
 * JD-Core Version:    0.7.0.1
 */