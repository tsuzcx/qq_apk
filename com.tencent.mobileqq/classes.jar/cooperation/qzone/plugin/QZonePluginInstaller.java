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
    Object localObject5 = paramInstallRecord.record;
    if (localObject1 != null) {
      ((QZonePluginInstaller.OnPluginInstallListner)localObject1).onInstallBegin(paramInstallRecord.record);
    }
    localObject1 = QZonePluginUtils.getPluginDownLoadedPath(this.mContext, ((PluginRecord)localObject5).id);
    Object localObject6 = QZonePluginUtils.getPluginInstallFile(this.mContext, ((PluginRecord)localObject5).id);
    Object localObject7 = QZonePluginUtils.getPluginLib(this.mContext, ((PluginRecord)localObject5).id);
    long l1 = System.currentTimeMillis();
    if (!isValidPluginFile((PluginRecord)localObject5, (File)localObject1, true))
    {
      QLog.w("QZonePluginManger", 1, "文件校验失败");
      Message.obtain(this.handler, 2, paramInstallRecord).sendToTarget();
      return;
    }
    Object localObject3 = ((File)localObject6).getParentFile();
    int i = LzmaUtils.a(this.mContext, ((File)localObject1).getAbsolutePath(), ((File)localObject3).getAbsolutePath());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("LZMA uncompress ret=");
    ((StringBuilder)localObject1).append(i);
    QLog.d("QZonePluginManger", 1, ((StringBuilder)localObject1).toString());
    long l2 = System.currentTimeMillis() - l1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("解压缩LZMA的时间, cost=");
      ((StringBuilder)localObject1).append(l2);
      QLog.i("QZonePluginManger", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = ((PluginRecord)localObject5).id;
    localObject3 = ((PluginRecord)localObject5).old_ver;
    Object localObject8 = ((PluginRecord)localObject5).ver;
    double d = l2;
    Double.isNaN(d);
    d /= 1000.0D;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    LpReportInfo_dc01500.reportInstall((String)localObject1, (String)localObject3, (String)localObject8, d, 100, localStringBuilder.toString());
    if (i != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("解压缩LZMA失败, ret=");
      ((StringBuilder)localObject1).append(i);
      QLog.w("QZonePluginManger", 1, ((StringBuilder)localObject1).toString());
      LpReportInfo_dc01500.reportInstall(((PluginRecord)localObject5).id, ((PluginRecord)localObject5).old_ver, ((PluginRecord)localObject5).ver, d, 5);
      Message.obtain(this.handler, 2, paramInstallRecord).sendToTarget();
      return;
    }
    ((PluginRecord)localObject5).md5_2 = PluginStatic.encodeFile(((File)localObject6).getAbsolutePath());
    boolean bool;
    if (((File)localObject7).exists())
    {
      localObject1 = ((File)localObject7).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("delete avsdk so libPath:");
        ((StringBuilder)localObject3).append(((File)localObject7).getAbsolutePath());
        QLog.i("QZonePluginManger", 2, ((StringBuilder)localObject3).toString());
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject3 = localObject1[i];
          if (((File)localObject3).exists()) {
            try
            {
              bool = ((File)localObject3).delete();
              localObject8 = new StringBuilder();
              try
              {
                ((StringBuilder)localObject8).append("delete file:");
                ((StringBuilder)localObject8).append(((File)localObject3).getName());
                ((StringBuilder)localObject8).append(" success:");
                ((StringBuilder)localObject8).append(bool);
                QLog.i("QZonePluginManger", 2, ((StringBuilder)localObject8).toString());
              }
              catch (Exception localException2) {}
              QLog.e("QZonePluginManger", 2, Log.getStackTraceString(localException3));
            }
            catch (Exception localException3) {}
          }
          i += 1;
        }
      }
    }
    try
    {
      bool = ((File)localObject6).canRead();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("installFile canRead=");
      ((StringBuilder)localObject1).append(bool);
      QLog.i("QZonePluginManger", 1, ((StringBuilder)localObject1).toString());
      if (!bool)
      {
        bool = ((File)localObject6).setReadable(true);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("installFile can read=");
        ((StringBuilder)localObject1).append(bool);
        QLog.i("QZonePluginManger", 1, ((StringBuilder)localObject1).toString());
      }
    }
    catch (Exception localException1)
    {
      QLog.e("QZonePluginManger", 1, localException1, new Object[0]);
    }
    Object localObject2 = PluginUtils.extractLibs(((File)localObject6).getAbsolutePath(), ((File)localObject7).getAbsolutePath());
    l2 = System.currentTimeMillis() - l1 - l2;
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("释放so的时间, cost=");
      ((StringBuilder)localObject4).append(l2);
      QLog.i("QZonePluginManger", 2, ((StringBuilder)localObject4).toString());
    }
    Object localObject4 = ((PluginRecord)localObject5).id;
    localObject6 = ((PluginRecord)localObject5).old_ver;
    localObject7 = ((PluginRecord)localObject5).ver;
    d = l2;
    Double.isNaN(d);
    d /= 1000.0D;
    LpReportInfo_dc01500.reportInstall((String)localObject4, (String)localObject6, (String)localObject7, d, 101);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("释放so失败:");
      ((StringBuilder)localObject4).append((String)localObject2);
      QLog.w("QZonePluginManger", 1, ((StringBuilder)localObject4).toString());
      LpReportInfo_dc01500.reportInstall(((PluginRecord)localObject5).id, ((PluginRecord)localObject5).old_ver, ((PluginRecord)localObject5).ver, d, 3, (String)localObject2);
      Message.obtain(this.handler, 2, paramInstallRecord).sendToTarget();
      return;
    }
    l1 = System.currentTimeMillis() - l1;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("插件安装成功, cost=");
    ((StringBuilder)localObject2).append(l1);
    QLog.i("QZonePluginManger", 1, ((StringBuilder)localObject2).toString());
    localObject2 = ((PluginRecord)localObject5).id;
    localObject4 = ((PluginRecord)localObject5).old_ver;
    localObject5 = ((PluginRecord)localObject5).ver;
    d = l1;
    Double.isNaN(d);
    LpReportInfo_dc01500.reportInstall((String)localObject2, (String)localObject4, (String)localObject5, d / 1000.0D, 0);
    Message.obtain(this.handler, 3, paramInstallRecord).sendToTarget();
  }
  
  static boolean isValidPluginFile(@NonNull PluginRecord paramPluginRecord, @Nullable File paramFile, boolean paramBoolean)
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()))
    {
      str = PluginStatic.encodeFile(paramFile.getPath());
      if (paramBoolean) {
        paramFile = paramPluginRecord.md5;
      } else {
        paramFile = paramPluginRecord.md5_2;
      }
      if ((paramFile != null) && (paramFile.equalsIgnoreCase(str))) {
        return true;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isValidPluginFile invalid:");
      ((StringBuilder)localObject).append(paramFile);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.e("plugin_tag", 1, ((StringBuilder)localObject).toString());
      paramFile = paramPluginRecord.id;
      str = paramPluginRecord.old_ver;
      localObject = paramPluginRecord.ver;
      if (paramBoolean) {
        paramPluginRecord = "0";
      } else {
        paramPluginRecord = "1";
      }
      LpReportInfo_dc01500.reportInstall(paramFile, str, (String)localObject, -1.0D, 4, paramPluginRecord);
      return false;
    }
    QLog.e("plugin_tag", 1, "isValidPluginFile4LZMA file not exist");
    paramFile = paramPluginRecord.id;
    String str = paramPluginRecord.old_ver;
    Object localObject = paramPluginRecord.ver;
    if (paramBoolean) {
      paramPluginRecord = "0";
    } else {
      paramPluginRecord = "1";
    }
    LpReportInfo_dc01500.reportInstall(paramFile, str, (String)localObject, -1.0D, 1, paramPluginRecord);
    return false;
  }
  
  private boolean verifyInstalledPlugin(PluginRecord paramPluginRecord)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramPluginRecord != null)
    {
      if (isValidPluginFile(paramPluginRecord, QZonePluginUtils.getPluginInstallFile(BaseApplicationImpl.getContext(), paramPluginRecord.id), false))
      {
        paramPluginRecord.state = 4;
        bool1 = true;
      }
      else
      {
        unInstallPlugin(paramPluginRecord, null);
        paramPluginRecord.state = 0;
        bool1 = bool2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("verifyInstalledPlugin :");
      localStringBuilder.append(paramPluginRecord);
      localStringBuilder.append(",");
      localStringBuilder.append(bool1);
      QLog.i("plugin_tag", 1, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public PluginRecord getInstalledPlugininfo(String paramString)
  {
    return (PluginRecord)this.installedPluginfos.get(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject1;
    Object localObject2;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
          localObject1 = (QZonePluginInstaller.InstallRecord)paramMessage.obj;
          if (this.installRecordMap.containsKey(((QZonePluginInstaller.InstallRecord)localObject1).id))
          {
            paramMessage = ((QZonePluginInstaller.InstallRecord)localObject1).record;
            this.installRecordMap.remove(((QZonePluginInstaller.InstallRecord)localObject1).id);
            paramMessage.state = 4;
            this.installedPluginfos.put(paramMessage.id, paramMessage);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("QZonePluginInstaller 安装成功 record:");
            ((StringBuilder)localObject2).append(paramMessage);
            QLog.i("QZonePluginManger", 1, ((StringBuilder)localObject2).toString());
            QZonePluginUtils.saveInstalledPluginInfo(paramMessage);
            localObject1 = ((QZonePluginInstaller.InstallRecord)localObject1).listner;
            if (localObject1 != null)
            {
              ((QZonePluginInstaller.OnPluginInstallListner)localObject1).onInstallFinish(true, paramMessage);
              return false;
            }
          }
        }
        else
        {
          paramMessage = (QZonePluginInstaller.InstallRecord)paramMessage.obj;
          if (this.installRecordMap.containsKey(paramMessage.id))
          {
            localObject1 = paramMessage.record;
            localObject2 = paramMessage.listner;
            if (localObject2 != null) {
              ((QZonePluginInstaller.OnPluginInstallListner)localObject2).onInstallFinish(false, (PluginRecord)localObject1);
            }
            this.installRecordMap.remove(paramMessage.id);
            return false;
          }
        }
      }
      else
      {
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
        if (localObject2 != null)
        {
          ((QZonePluginInstaller.OnPluginUninstallListner)localObject2).onUnInstallFinish(false, (PluginRecord)localObject1);
          return false;
        }
      }
    }
    else
    {
      localObject2 = (QZonePluginInstaller.InstallRecord)paramMessage.obj;
      if (!this.installRecordMap.containsKey(((QZonePluginInstaller.InstallRecord)localObject2).id))
      {
        this.installRecordMap.put(((QZonePluginInstaller.InstallRecord)localObject2).id, localObject2);
        localObject1 = ((QZonePluginInstaller.InstallRecord)localObject2).record;
        localObject2 = ((QZonePluginInstaller.InstallRecord)localObject2).listner;
        if (localObject2 != null) {
          ((QZonePluginInstaller.OnPluginInstallListner)localObject2).onInstallBegin((PluginRecord)localObject1);
        }
        installPluginInner((QZonePluginInstaller.InstallRecord)paramMessage.obj);
      }
    }
    return false;
  }
  
  public void installPlugin(PluginRecord paramPluginRecord, QZonePluginInstaller.OnPluginInstallListner paramOnPluginInstallListner)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("installPlugin: ");
    ((StringBuilder)localObject).append(paramPluginRecord);
    QLog.i("plugin_tag", 1, ((StringBuilder)localObject).toString());
    localObject = new QZonePluginInstaller.InstallRecord(this);
    ((QZonePluginInstaller.InstallRecord)localObject).record = paramPluginRecord;
    ((QZonePluginInstaller.InstallRecord)localObject).listner = paramOnPluginInstallListner;
    ((QZonePluginInstaller.InstallRecord)localObject).id = paramPluginRecord.id;
    Message.obtain(this.handler, 0, localObject).sendToTarget();
  }
  
  public void unInstallPlugin(PluginRecord paramPluginRecord, QZonePluginInstaller.OnPluginUninstallListner paramOnPluginUninstallListner)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unInstallPlugin: ");
    ((StringBuilder)localObject).append(paramPluginRecord);
    QLog.i("plugin_tag", 1, ((StringBuilder)localObject).toString());
    localObject = new QZonePluginInstaller.InstallRecord(this);
    ((QZonePluginInstaller.InstallRecord)localObject).record = paramPluginRecord;
    ((QZonePluginInstaller.InstallRecord)localObject).uninstallListner = paramOnPluginUninstallListner;
    Message.obtain(this.handler, 1, localObject).sendToTarget();
  }
  
  public void unInstallPluginInner(QZonePluginInstaller.InstallRecord paramInstallRecord)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unInstallPluginInner : ");
    ((StringBuilder)localObject).append(paramInstallRecord.record);
    QLog.i("plugin_tag", 1, ((StringBuilder)localObject).toString());
    paramInstallRecord = paramInstallRecord.record;
    localObject = QZonePluginUtils.getPluginInstallFile(this.mContext, paramInstallRecord.id);
    File localFile = QZonePluginUtils.getPluginLib(this.mContext, paramInstallRecord.id);
    ((File)localObject).delete();
    localFile.delete();
    QZonePluginUtils.deleteInstalledPluginInfo(paramInstallRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginInstaller
 * JD-Core Version:    0.7.0.1
 */