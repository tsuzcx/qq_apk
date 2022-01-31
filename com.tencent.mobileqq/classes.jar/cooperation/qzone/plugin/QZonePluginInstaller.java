package cooperation.qzone.plugin;

import amxq;
import amxr;
import amxs;
import amxt;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class QZonePluginInstaller
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  Map jdField_a_of_type_JavaUtilMap;
  Map b;
  
  QZonePluginInstaller(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new HashMap();
    amxq localamxq = new amxq(this);
    QZonePluginUtils.a(paramContext, this.b, localamxq);
  }
  
  private boolean a(PluginRecord paramPluginRecord)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramPluginRecord != null)
    {
      if (!a(paramPluginRecord, QZonePluginUtils.a(BaseApplicationImpl.getContext(), paramPluginRecord.f), false)) {
        break label79;
      }
      bool1 = true;
    }
    for (paramPluginRecord.a = 4;; paramPluginRecord.a = 0)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("plugin_tag", 2, "verifyInstalledPlugin :" + paramPluginRecord + "," + bool1);
        bool2 = bool1;
      }
      return bool2;
      label79:
      a(paramPluginRecord, null);
    }
  }
  
  static boolean a(@NonNull PluginRecord paramPluginRecord, @Nullable File paramFile, boolean paramBoolean)
  {
    boolean bool = true;
    String str2;
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isFile()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("plugin_tag", 2, "isValidPluginFile4LZMA file not exist");
      }
      paramFile = paramPluginRecord.f;
      str1 = paramPluginRecord.d;
      str2 = paramPluginRecord.c;
      if (paramBoolean) {}
      for (paramPluginRecord = "0";; paramPluginRecord = "1")
      {
        LpReportInfo_dc01500.reportInstall(paramFile, str1, str2, -1.0D, 1, paramPluginRecord);
        bool = false;
        return bool;
      }
    }
    String str1 = PluginStatic.encodeFile(paramFile.getPath());
    if (paramBoolean)
    {
      paramFile = paramPluginRecord.h;
      label99:
      if ((paramFile != null) && (paramFile.equalsIgnoreCase(str1))) {
        break label207;
      }
      if (QLog.isColorLevel()) {
        QLog.e("plugin_tag", 2, "isValidPluginFile invalid:" + paramFile + ", " + str1 + ", " + paramBoolean);
      }
      paramFile = paramPluginRecord.f;
      str1 = paramPluginRecord.d;
      str2 = paramPluginRecord.c;
      if (!paramBoolean) {
        break label209;
      }
    }
    label207:
    label209:
    for (paramPluginRecord = "0";; paramPluginRecord = "1")
    {
      LpReportInfo_dc01500.reportInstall(paramFile, str1, str2, -1.0D, 4, paramPluginRecord);
      return false;
      paramFile = paramPluginRecord.i;
      break label99;
      break;
    }
  }
  
  private void b(amxr paramamxr)
  {
    Object localObject1 = paramamxr.jdField_a_of_type_Amxs;
    PluginRecord localPluginRecord = paramamxr.jdField_a_of_type_CooperationQzonePluginPluginRecord;
    if (localObject1 != null) {
      ((amxs)localObject1).d(paramamxr.jdField_a_of_type_CooperationQzonePluginPluginRecord);
    }
    Object localObject2 = QZonePluginUtils.e(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.f);
    localObject1 = QZonePluginUtils.a(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.f);
    File localFile1 = QZonePluginUtils.b(this.jdField_a_of_type_AndroidContentContext, localPluginRecord.f);
    long l1 = System.currentTimeMillis();
    if (!a(localPluginRecord, (File)localObject2, true))
    {
      QLog.w("QZonePluginManger", 1, "文件校验失败");
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, paramamxr).sendToTarget();
      return;
    }
    File localFile2 = ((File)localObject1).getParentFile();
    int i = LzmaUtils.a(this.jdField_a_of_type_AndroidContentContext, ((File)localObject2).getAbsolutePath(), localFile2.getAbsolutePath());
    QLog.d("QZonePluginManger", 1, "LZMA uncompress ret=" + i);
    long l2 = System.currentTimeMillis() - l1;
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "解压缩LZMA的时间, cost=" + l2);
    }
    LpReportInfo_dc01500.reportInstall(localPluginRecord.f, localPluginRecord.d, localPluginRecord.c, l2 / 1000.0D, 100, i + "");
    if (i != 0)
    {
      QLog.w("QZonePluginManger", 1, "解压缩LZMA失败, ret=" + i);
      LpReportInfo_dc01500.reportInstall(localPluginRecord.f, localPluginRecord.d, localPluginRecord.c, l2 / 1000.0D, 5);
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, paramamxr).sendToTarget();
      return;
    }
    localPluginRecord.i = PluginStatic.encodeFile(((File)localObject1).getAbsolutePath());
    if (localFile1.exists())
    {
      localObject2 = localFile1.listFiles();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        QLog.i("QZonePluginManger", 2, "delete avsdk so libPath:" + localFile1.getAbsolutePath());
        int j = localObject2.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localFile2 = localObject2[i];
            if (localFile2.exists()) {}
            try
            {
              boolean bool = localFile2.delete();
              QLog.i("QZonePluginManger", 2, "delete file:" + localFile2.getName() + " success:" + bool);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.e("QZonePluginManger", 2, Log.getStackTraceString(localException));
              }
            }
          }
        }
      }
    }
    localObject1 = PluginUtils.extractLibs(((File)localObject1).getAbsolutePath(), localFile1.getAbsolutePath());
    l2 = System.currentTimeMillis() - l1 - l2;
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "释放so的时间, cost=" + l2);
    }
    LpReportInfo_dc01500.reportInstall(localPluginRecord.f, localPluginRecord.d, localPluginRecord.c, l2 / 1000.0D, 101);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.w("QZonePluginManger", 1, "释放so失败:" + (String)localObject1);
      LpReportInfo_dc01500.reportInstall(localPluginRecord.f, localPluginRecord.d, localPluginRecord.c, l2 / 1000.0D, 3, (String)localObject1);
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2, paramamxr).sendToTarget();
      return;
    }
    l1 = System.currentTimeMillis() - l1;
    QLog.i("QZonePluginManger", 1, "插件安装成功, cost=" + l1);
    LpReportInfo_dc01500.reportInstall(localPluginRecord.f, localPluginRecord.d, localPluginRecord.c, l1 / 1000.0D, 0);
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3, paramamxr).sendToTarget();
  }
  
  public PluginRecord a(String paramString)
  {
    return (PluginRecord)this.b.get(paramString);
  }
  
  public void a(amxr paramamxr)
  {
    paramamxr = paramamxr.jdField_a_of_type_CooperationQzonePluginPluginRecord;
    File localFile1 = QZonePluginUtils.a(this.jdField_a_of_type_AndroidContentContext, paramamxr.f);
    File localFile2 = QZonePluginUtils.b(this.jdField_a_of_type_AndroidContentContext, paramamxr.f);
    localFile1.delete();
    localFile2.delete();
    QZonePluginUtils.c(paramamxr);
  }
  
  public void a(PluginRecord paramPluginRecord, amxs paramamxs)
  {
    amxr localamxr = new amxr(this);
    localamxr.jdField_a_of_type_CooperationQzonePluginPluginRecord = paramPluginRecord;
    localamxr.jdField_a_of_type_Amxs = paramamxs;
    localamxr.jdField_a_of_type_JavaLangString = paramPluginRecord.f;
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 0, localamxr).sendToTarget();
  }
  
  public void a(PluginRecord paramPluginRecord, amxt paramamxt)
  {
    amxr localamxr = new amxr(this);
    localamxr.jdField_a_of_type_CooperationQzonePluginPluginRecord = paramPluginRecord;
    localamxr.jdField_a_of_type_Amxt = paramamxt;
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, localamxr).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject1;
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            do
            {
              return false;
              localObject2 = (amxr)paramMessage.obj;
            } while (this.jdField_a_of_type_JavaUtilMap.containsKey(((amxr)localObject2).jdField_a_of_type_JavaLangString));
            this.jdField_a_of_type_JavaUtilMap.put(((amxr)localObject2).jdField_a_of_type_JavaLangString, localObject2);
            localObject1 = ((amxr)localObject2).jdField_a_of_type_CooperationQzonePluginPluginRecord;
            localObject2 = ((amxr)localObject2).jdField_a_of_type_Amxs;
            if (localObject2 != null) {
              ((amxs)localObject2).d((PluginRecord)localObject1);
            }
            b((amxr)paramMessage.obj);
            return false;
            paramMessage = (amxr)paramMessage.obj;
          } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage.jdField_a_of_type_JavaLangString));
          localObject1 = paramMessage.jdField_a_of_type_CooperationQzonePluginPluginRecord;
          localObject2 = paramMessage.jdField_a_of_type_Amxs;
          if (localObject2 != null) {
            ((amxs)localObject2).a(false, (PluginRecord)localObject1);
          }
          this.jdField_a_of_type_JavaUtilMap.remove(paramMessage.jdField_a_of_type_JavaLangString);
          return false;
          paramMessage = (amxr)paramMessage.obj;
          localObject1 = paramMessage.jdField_a_of_type_CooperationQzonePluginPluginRecord;
          localObject2 = paramMessage.jdField_a_of_type_Amxt;
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramMessage.jdField_a_of_type_JavaLangString))
          {
            if (localObject2 != null) {
              ((amxt)localObject2).e((PluginRecord)localObject1);
            }
            this.jdField_a_of_type_JavaUtilMap.put(paramMessage.jdField_a_of_type_JavaLangString, paramMessage);
            a(paramMessage);
            this.jdField_a_of_type_JavaUtilMap.remove(paramMessage.jdField_a_of_type_JavaLangString);
            this.b.remove(((PluginRecord)localObject1).f);
            QZonePluginUtils.c((PluginRecord)localObject1);
            if (localObject2 != null) {
              ((amxt)localObject2).b(true, (PluginRecord)localObject1);
            }
          }
        } while (localObject2 == null);
        ((amxt)localObject2).b(false, (PluginRecord)localObject1);
        return false;
        localObject1 = (amxr)paramMessage.obj;
      } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(((amxr)localObject1).jdField_a_of_type_JavaLangString));
      paramMessage = ((amxr)localObject1).jdField_a_of_type_CooperationQzonePluginPluginRecord;
      this.jdField_a_of_type_JavaUtilMap.remove(((amxr)localObject1).jdField_a_of_type_JavaLangString);
      paramMessage.a = 4;
      this.b.put(paramMessage.f, paramMessage);
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "QZonePluginInstaller 安装成功 record:" + paramMessage);
      }
      QZonePluginUtils.b(paramMessage);
      localObject1 = ((amxr)localObject1).jdField_a_of_type_Amxs;
    } while (localObject1 == null);
    ((amxs)localObject1).a(true, paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginInstaller
 * JD-Core Version:    0.7.0.1
 */