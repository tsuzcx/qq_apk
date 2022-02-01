package cooperation.qzone.plugin;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.QzoneModuleConfigManager;
import cooperation.qzone.patch.QZonePatchService;
import cooperation.qzone.patch.QzoneUpdatePatchServlet;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class QZonePluginUpdater
{
  public static final String KEY_FORCE_DOWNLOADE_PLUGINS = "forceDownLoadPlugins";
  private static final String TAG = "QZonePluginUpdater";
  private WeakReference<QQAppInterface> appInterfaceRef;
  private Handler handler;
  QZonePluginUpdater.OnUpdateListner listner;
  private Context mContext;
  private Map<String, PluginRecord> mPluginInfos;
  HashMap<String, String> processMap = new HashMap();
  HashMap<String, PluginRecord> requestMap = new HashMap();
  
  public QZonePluginUpdater(QQAppInterface paramQQAppInterface, Context paramContext, Handler paramHandler)
  {
    this.appInterfaceRef = new WeakReference(paramQQAppInterface);
    this.mContext = paramContext;
    this.handler = paramHandler;
    this.mPluginInfos = new HashMap();
    paramQQAppInterface = new PluginRecord();
    paramQQAppInterface.ver = "0";
    this.processMap.put("qzone_live_video_plugin_hack.apk", "com.tencent.mobileqq:qzonelive");
    paramQQAppInterface.name = "qzone_live_video_plugin_hack.apk";
    paramQQAppInterface.id = "qzone_live_video_plugin_hack.apk";
    this.requestMap.put(paramQQAppInterface.id, paramQQAppInterface);
    paramQQAppInterface = new PluginRecord();
    paramQQAppInterface.ver = "0";
    paramQQAppInterface.name = "qzone_vertical_video_plugin.apk";
    paramQQAppInterface.id = "qzone_vertical_video_plugin.apk";
    this.requestMap.put(paramQQAppInterface.id, paramQQAppInterface);
    this.processMap.put("qzone_vertical_video_plugin.apk", "com.tencent.mobileqq:qzone");
    paramQQAppInterface = new PluginRecord();
    paramQQAppInterface.ver = "0";
    paramQQAppInterface.name = "QZoneWeishiFeedsVideo";
    paramQQAppInterface.id = "qzone_weishi_feeds_plugin.apk";
    this.requestMap.put(paramQQAppInterface.id, paramQQAppInterface);
    this.processMap.put("qzone_weishi_feeds_plugin.apk", "com.tencent.mobileqq:qzonelive");
    QZonePluginUtils.listPluginInfos(paramContext, this.mPluginInfos);
  }
  
  private void covertToPluginRecord(UPDATE_INFO paramUPDATE_INFO, PluginRecord paramPluginRecord)
  {
    if ((paramPluginRecord == null) || (paramUPDATE_INFO == null)) {
      return;
    }
    paramPluginRecord.app = paramUPDATE_INFO.app;
    paramPluginRecord.id = paramUPDATE_INFO.id;
    paramPluginRecord.actype = paramUPDATE_INFO.actype;
    paramPluginRecord.mainVersion = paramUPDATE_INFO.mainVersion;
    paramPluginRecord.md5 = paramUPDATE_INFO.md5;
    paramPluginRecord.name = paramUPDATE_INFO.name;
    paramPluginRecord.old_ver = paramPluginRecord.ver;
    paramPluginRecord.ver = paramUPDATE_INFO.ver;
    paramPluginRecord.actype = paramUPDATE_INFO.actype;
    paramPluginRecord.url = getPluginExtraInfo(paramUPDATE_INFO.plugin_info, Integer.valueOf(0));
    paramPluginRecord.mProcesses = ((String)this.processMap.get(paramPluginRecord.id));
    paramPluginRecord.mInstalledPath = QZonePluginUtils.getPluginInstallFile(BaseApplicationImpl.getContext(), paramPluginRecord.id).getAbsolutePath();
  }
  
  private void deletePluginInfo(String paramString)
  {
    paramString = QZonePluginUtils.getPluginCfgFile(BaseApplicationImpl.getContext(), paramString);
    if ((paramString != null) && (paramString.exists())) {
      paramString.delete();
    }
  }
  
  public static String getPluginExtraInfo(Map<Integer, String> paramMap, Integer paramInteger)
  {
    if (paramMap != null) {
      return (String)paramMap.get(paramInteger);
    }
    return null;
  }
  
  private void handlePatchResp(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP)
  {
    if (paramSQ_CLIENT_UPDATE_RSP != null)
    {
      String str1 = paramSQ_CLIENT_UPDATE_RSP.md5;
      String str2 = paramSQ_CLIENT_UPDATE_RSP.upUrl;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZonePluginUpdater", 2, "收到补丁包信息：" + paramSQ_CLIENT_UPDATE_RSP);
        }
        QZonePatchService.getInstance().onPatchResponse(str1, str2);
      }
    }
  }
  
  private void handlePluginResp(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP, String[] paramArrayOfString)
  {
    if (paramSQ_CLIENT_UPDATE_RSP != null)
    {
      if ((paramSQ_CLIENT_UPDATE_RSP.vPlugin != null) && (paramSQ_CLIENT_UPDATE_RSP.vPlugin.size() > 0))
      {
        onPluginResponse(paramSQ_CLIENT_UPDATE_RSP.vPlugin, paramArrayOfString);
        QLog.i("QZonePluginUpdater", 2, "plugin need update：" + paramSQ_CLIENT_UPDATE_RSP + ", size = " + paramSQ_CLIENT_UPDATE_RSP.vPlugin.size());
        return;
      }
      QLog.i("QZonePluginUpdater", 2, "plugin don not need update：" + paramSQ_CLIENT_UPDATE_RSP);
      return;
    }
    QLog.i("QZonePluginUpdater", 2, "response == null");
  }
  
  private static void log(String paramString)
  {
    QLog.i("QZonePluginManger", 2, paramString);
  }
  
  private void sendPatchRequest(WeakReference<QQAppInterface> paramWeakReference, String[] paramArrayOfString)
  {
    PluginIntent localPluginIntent = new PluginIntent(BaseApplicationImpl.getContext(), QzoneUpdatePatchServlet.class);
    localPluginIntent.update_infos = getRequestUpdateInfo();
    localPluginIntent.module_update_infos = QzoneModuleConfigManager.getInstance().getUpdateInfo();
    localPluginIntent.setResultListner(new QZonePluginUpdater.1(this));
    localPluginIntent.putExtra("forceDownLoadPlugins", paramArrayOfString);
    paramArrayOfString = null;
    if (paramWeakReference != null) {
      paramArrayOfString = (QQAppInterface)paramWeakReference.get();
    }
    if (paramArrayOfString != null) {
      paramArrayOfString.startServlet(localPluginIntent);
    }
  }
  
  private void updatePluginInfo(PluginRecord paramPluginRecord)
  {
    File localFile = QZonePluginUtils.getPluginCfgFile(BaseApplicationImpl.getContext(), paramPluginRecord.id);
    if ((localFile != null) && (localFile.exists())) {
      localFile.delete();
    }
    QZonePluginUtils.savePluginInfo(paramPluginRecord);
    LpReportInfo_dc01500.reportConfig(paramPluginRecord.id, paramPluginRecord.old_ver, paramPluginRecord.ver, 0);
  }
  
  public boolean checkUpToDate(PluginRecord paramPluginRecord)
  {
    if (paramPluginRecord == null) {
      return false;
    }
    PluginRecord localPluginRecord = getNewPluginInfo(paramPluginRecord.id);
    String str;
    if (QLog.isColorLevel())
    {
      QLog.d("QZonePluginUpdater", 2, "pre: " + paramPluginRecord.md5);
      StringBuilder localStringBuilder = new StringBuilder().append("new: ");
      if (localPluginRecord != null)
      {
        str = localPluginRecord.md5;
        QLog.d("QZonePluginUpdater", 2, str);
      }
    }
    else
    {
      if ((localPluginRecord == null) || (!localPluginRecord.md5.equals(paramPluginRecord.md5))) {
        break label121;
      }
    }
    label121:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      str = null;
      break;
    }
  }
  
  Map<String, PluginRecord> getAllPlugins()
  {
    return this.mPluginInfos;
  }
  
  public PluginRecord getNewPluginInfo(String paramString)
  {
    return (PluginRecord)this.mPluginInfos.get(paramString);
  }
  
  public PluginRecord getNewPluginRecord(String paramString)
  {
    return (PluginRecord)this.mPluginInfos.get(paramString);
  }
  
  public void getPluginList()
  {
    sendPatchRequest(this.appInterfaceRef, null);
  }
  
  public ArrayList<UPDATE_INFO> getRequestUpdateInfo()
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    this.requestMap.putAll(this.mPluginInfos);
    Iterator localIterator = this.requestMap.values().iterator();
    while (localIterator.hasNext())
    {
      PluginRecord localPluginRecord = (PluginRecord)localIterator.next();
      UPDATE_INFO localUPDATE_INFO = new UPDATE_INFO();
      localUPDATE_INFO.id = localPluginRecord.id;
      localUPDATE_INFO.app = localPluginRecord.id;
      localUPDATE_INFO.ver = (localPluginRecord.ver + "");
      localArrayList.add(localUPDATE_INFO);
      localStringBuilder.append("id=").append(localUPDATE_INFO.id).append(",app=").append(localUPDATE_INFO.app).append(",ver=").append(localUPDATE_INFO.ver).append("\r\n");
    }
    log("getRequestUpdateInfo:" + localStringBuilder);
    return localArrayList;
  }
  
  public void onPluginResponse(ArrayList<UPDATE_INFO> paramArrayList, String[] paramArrayOfString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramArrayOfString = (UPDATE_INFO)paramArrayList.next();
        if (paramArrayOfString.actype == 4)
        {
          log("delete plugin, " + paramArrayOfString.name);
          if (this.mPluginInfos.containsKey(paramArrayOfString.id))
          {
            this.mPluginInfos.remove(paramArrayOfString.id);
            deletePluginInfo(paramArrayOfString.id);
          }
        }
        else
        {
          PluginRecord localPluginRecord1 = new PluginRecord();
          covertToPluginRecord(paramArrayOfString, localPluginRecord1);
          if (this.mPluginInfos.containsKey(paramArrayOfString.id))
          {
            PluginRecord localPluginRecord2 = (PluginRecord)this.mPluginInfos.get(paramArrayOfString.id);
            if (!localPluginRecord1.equals(localPluginRecord2))
            {
              if (localPluginRecord2 == null) {
                break label241;
              }
              covertToPluginRecord(paramArrayOfString, localPluginRecord2);
            }
            for (;;)
            {
              updatePluginInfo((PluginRecord)this.mPluginInfos.get(paramArrayOfString.id));
              log("onPluginResponse contain update plugin, name = " + paramArrayOfString.name + ", ver = " + paramArrayOfString.ver);
              break;
              label241:
              this.mPluginInfos.put(paramArrayOfString.id, localPluginRecord1);
            }
          }
          this.mPluginInfos.put(paramArrayOfString.id, localPluginRecord1);
          updatePluginInfo((PluginRecord)this.mPluginInfos.get(paramArrayOfString.id));
          log("onPluginResponse not contain update plugin, name = " + paramArrayOfString.name + ", ver = " + paramArrayOfString.ver);
        }
      }
    }
  }
  
  public void setOnUpdateListner(QZonePluginUpdater.OnUpdateListner paramOnUpdateListner)
  {
    this.listner = paramOnUpdateListner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginUpdater
 * JD-Core Version:    0.7.0.1
 */