package cooperation.qzone.plugin;

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
  private static final int MSG_INSTALL_PLUGIN = 0;
  private static final int MSG_INSTALL_PLUGIN_FAIL = 2;
  private static final int MSG_INSTALL_PLUGIN_SUCEESS = 3;
  private static final int MSG_UNINSTALL_PLUGIN = 1;
  private Handler handler;
  Map<String, QZonePluginInstaller.InstallRecord> installRecordMap;
  Map<String, PluginRecord> installedPluginfos;
  QZonePluginInstaller.OnValidatePluginListner listner;
  private Context mContext;
  
  QZonePluginInstaller(Context paramContext)
  {
    this.mContext = paramContext;
    this.installRecordMap = new HashMap();
    this.handler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.installedPluginfos = new HashMap();
    QZonePluginInstaller.1 local1 = new QZonePluginInstaller.1(this);
    QZonePluginUtils.listInstalledPlugininfos(paramContext, this.installedPluginfos, local1);
  }
  
  private void installPluginInner(QZonePluginInstaller.InstallRecord paramInstallRecord)
  {
    Object localObject1 = paramInstallRecord.listner;
    PluginRecord localPluginRecord = paramInstallRecord.record;
    if (localObject1 != null) {
      ((QZonePluginInstaller.OnPluginInstallListner)localObject1).onInstallBegin(paramInstallRecord.record);
    }
    Object localObject2 = QZonePluginUtils.getPluginDownLoadedPath(this.mContext, localPluginRecord.id);
    localObject1 = QZonePluginUtils.getPluginInstallFile(this.mContext, localPluginRecord.id);
    File localFile1 = QZonePluginUtils.getPluginLib(this.mContext, localPluginRecord.id);
    long l1 = System.currentTimeMillis();
    if (!isValidPluginFile(localPluginRecord, (File)localObject2, true))
    {
      QLog.w("QZonePluginManger", 1, "文件校验失败");
      Message.obtain(this.handler, 2, paramInstallRecord).sendToTarget();
      return;
    }
    File localFile2 = ((File)localObject1).getParentFile();
    int i = LzmaUtils.a(this.mContext, ((File)localObject2).getAbsolutePath(), localFile2.getAbsolutePath());
    QLog.d("QZonePluginManger", 1, "LZMA uncompress ret=" + i);
    long l2 = System.currentTimeMillis() - l1;
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "解压缩LZMA的时间, cost=" + l2);
    }
    LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l2 / 1000.0D, 100, i + "");
    if (i != 0)
    {
      QLog.w("QZonePluginManger", 1, "解压缩LZMA失败, ret=" + i);
      LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l2 / 1000.0D, 5);
      Message.obtain(this.handler, 2, paramInstallRecord).sendToTarget();
      return;
    }
    localPluginRecord.md5_2 = PluginStatic.encodeFile(((File)localObject1).getAbsolutePath());
    boolean bool;
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
              bool = localFile2.delete();
              QLog.i("QZonePluginManger", 2, "delete file:" + localFile2.getName() + " success:" + bool);
              i += 1;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                QLog.e("QZonePluginManger", 2, Log.getStackTraceString(localException2));
              }
            }
          }
        }
      }
    }
    try
    {
      bool = ((File)localObject1).canRead();
      QLog.i("QZonePluginManger", 1, "installFile canRead=" + bool);
      if (!bool)
      {
        bool = ((File)localObject1).setReadable(true);
        QLog.i("QZonePluginManger", 1, "installFile can read=" + bool);
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        QLog.e("QZonePluginManger", 1, localException1, new Object[0]);
      }
      l1 = System.currentTimeMillis() - l1;
      QLog.i("QZonePluginManger", 1, "插件安装成功, cost=" + l1);
      LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l1 / 1000.0D, 0);
      Message.obtain(this.handler, 3, paramInstallRecord).sendToTarget();
    }
    localObject1 = PluginUtils.extractLibs(((File)localObject1).getAbsolutePath(), localFile1.getAbsolutePath());
    l2 = System.currentTimeMillis() - l1 - l2;
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginManger", 2, "释放so的时间, cost=" + l2);
    }
    LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l2 / 1000.0D, 101);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.w("QZonePluginManger", 1, "释放so失败:" + (String)localObject1);
      LpReportInfo_dc01500.reportInstall(localPluginRecord.id, localPluginRecord.old_ver, localPluginRecord.ver, l2 / 1000.0D, 3, (String)localObject1);
      Message.obtain(this.handler, 2, paramInstallRecord).sendToTarget();
      return;
    }
  }
  
  static boolean isValidPluginFile(@NonNull PluginRecord paramPluginRecord, @Nullable File paramFile, boolean paramBoolean)
  {
    boolean bool = true;
    String str2;
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isFile()))
    {
      QLog.e("plugin_tag", 1, "isValidPluginFile4LZMA file not exist");
      paramFile = paramPluginRecord.id;
      str1 = paramPluginRecord.old_ver;
      str2 = paramPluginRecord.ver;
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
      paramFile = paramPluginRecord.md5;
      label97:
      if ((paramFile != null) && (paramFile.equalsIgnoreCase(str1))) {
        break label204;
      }
      QLog.e("plugin_tag", 1, "isValidPluginFile invalid:" + paramFile + ", " + str1 + ", " + paramBoolean);
      paramFile = paramPluginRecord.id;
      str1 = paramPluginRecord.old_ver;
      str2 = paramPluginRecord.ver;
      if (!paramBoolean) {
        break label206;
      }
    }
    label204:
    label206:
    for (paramPluginRecord = "0";; paramPluginRecord = "1")
    {
      LpReportInfo_dc01500.reportInstall(paramFile, str1, str2, -1.0D, 4, paramPluginRecord);
      return false;
      paramFile = paramPluginRecord.md5_2;
      break label97;
      break;
    }
  }
  
  private boolean verifyInstalledPlugin(PluginRecord paramPluginRecord)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramPluginRecord != null)
    {
      if (!isValidPluginFile(paramPluginRecord, QZonePluginUtils.getPluginInstallFile(BaseApplicationImpl.getContext(), paramPluginRecord.id), false)) {
        break label72;
      }
      paramPluginRecord.state = 4;
    }
    for (bool1 = true;; bool1 = bool2)
    {
      QLog.i("plugin_tag", 1, "verifyInstalledPlugin :" + paramPluginRecord + "," + bool1);
      return bool1;
      label72:
      unInstallPlugin(paramPluginRecord, null);
      paramPluginRecord.state = 0;
    }
  }
  
  public PluginRecord getInstalledPlugininfo(String paramString)
  {
    return (PluginRecord)this.installedPluginfos.get(paramString);
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
              localObject2 = (QZonePluginInstaller.InstallRecord)paramMessage.obj;
            } while (this.installRecordMap.containsKey(((QZonePluginInstaller.InstallRecord)localObject2).id));
            this.installRecordMap.put(((QZonePluginInstaller.InstallRecord)localObject2).id, localObject2);
            localObject1 = ((QZonePluginInstaller.InstallRecord)localObject2).record;
            localObject2 = ((QZonePluginInstaller.InstallRecord)localObject2).listner;
            if (localObject2 != null) {
              ((QZonePluginInstaller.OnPluginInstallListner)localObject2).onInstallBegin((PluginRecord)localObject1);
            }
            installPluginInner((QZonePluginInstaller.InstallRecord)paramMessage.obj);
            return false;
            paramMessage = (QZonePluginInstaller.InstallRecord)paramMessage.obj;
          } while (!this.installRecordMap.containsKey(paramMessage.id));
          localObject1 = paramMessage.record;
          localObject2 = paramMessage.listner;
          if (localObject2 != null) {
            ((QZonePluginInstaller.OnPluginInstallListner)localObject2).onInstallFinish(false, (PluginRecord)localObject1);
          }
          this.installRecordMap.remove(paramMessage.id);
          return false;
          paramMessage = (QZonePluginInstaller.InstallRecord)paramMessage.obj;
          localObject1 = paramMessage.record;
          localObject2 = paramMessage.uninstallListner;
          if (!this.installRecordMap.containsKey(paramMessage.id))
          {
            if (localObject2 != null) {
              ((QZonePluginInstaller.OnPluginUninstallListner)localObject2).onUnInstallBegin((PluginRecord)localObject1);
            }
            this.installRecordMap.put(paramMessage.id, paramMessage);
            unInstallPluginInner(paramMessage);
            this.installRecordMap.remove(paramMessage.id);
            this.installedPluginfos.remove(((PluginRecord)localObject1).id);
            QZonePluginUtils.deleteInstalledPluginInfo((PluginRecord)localObject1);
            if (localObject2 != null) {
              ((QZonePluginInstaller.OnPluginUninstallListner)localObject2).onUnInstallFinish(true, (PluginRecord)localObject1);
            }
          }
        } while (localObject2 == null);
        ((QZonePluginInstaller.OnPluginUninstallListner)localObject2).onUnInstallFinish(false, (PluginRecord)localObject1);
        return false;
        localObject1 = (QZonePluginInstaller.InstallRecord)paramMessage.obj;
      } while (!this.installRecordMap.containsKey(((QZonePluginInstaller.InstallRecord)localObject1).id));
      paramMessage = ((QZonePluginInstaller.InstallRecord)localObject1).record;
      this.installRecordMap.remove(((QZonePluginInstaller.InstallRecord)localObject1).id);
      paramMessage.state = 4;
      this.installedPluginfos.put(paramMessage.id, paramMessage);
      QLog.i("QZonePluginManger", 1, "QZonePluginInstaller 安装成功 record:" + paramMessage);
      QZonePluginUtils.saveInstalledPluginInfo(paramMessage);
      localObject1 = ((QZonePluginInstaller.InstallRecord)localObject1).listner;
    } while (localObject1 == null);
    ((QZonePluginInstaller.OnPluginInstallListner)localObject1).onInstallFinish(true, paramMessage);
    return false;
  }
  
  public void installPlugin(PluginRecord paramPluginRecord, QZonePluginInstaller.OnPluginInstallListner paramOnPluginInstallListner)
  {
    QLog.i("plugin_tag", 1, "installPlugin: " + paramPluginRecord);
    QZonePluginInstaller.InstallRecord localInstallRecord = new QZonePluginInstaller.InstallRecord(this);
    localInstallRecord.record = paramPluginRecord;
    localInstallRecord.listner = paramOnPluginInstallListner;
    localInstallRecord.id = paramPluginRecord.id;
    Message.obtain(this.handler, 0, localInstallRecord).sendToTarget();
  }
  
  public void unInstallPlugin(PluginRecord paramPluginRecord, QZonePluginInstaller.OnPluginUninstallListner paramOnPluginUninstallListner)
  {
    QLog.i("plugin_tag", 1, "unInstallPlugin: " + paramPluginRecord);
    QZonePluginInstaller.InstallRecord localInstallRecord = new QZonePluginInstaller.InstallRecord(this);
    localInstallRecord.record = paramPluginRecord;
    localInstallRecord.uninstallListner = paramOnPluginUninstallListner;
    Message.obtain(this.handler, 1, localInstallRecord).sendToTarget();
  }
  
  public void unInstallPluginInner(QZonePluginInstaller.InstallRecord paramInstallRecord)
  {
    QLog.i("plugin_tag", 1, "unInstallPluginInner : " + paramInstallRecord.record);
    paramInstallRecord = paramInstallRecord.record;
    File localFile1 = QZonePluginUtils.getPluginInstallFile(this.mContext, paramInstallRecord.id);
    File localFile2 = QZonePluginUtils.getPluginLib(this.mContext, paramInstallRecord.id);
    localFile1.delete();
    localFile2.delete();
    QZonePluginUtils.deleteInstalledPluginInfo(paramInstallRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginInstaller
 * JD-Core Version:    0.7.0.1
 */