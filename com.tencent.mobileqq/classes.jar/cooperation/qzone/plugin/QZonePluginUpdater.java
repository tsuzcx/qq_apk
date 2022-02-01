package cooperation.qzone.plugin;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
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
    if (paramPluginRecord != null)
    {
      if (paramUPDATE_INFO == null) {
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("收到补丁包信息：");
          localStringBuilder.append(paramSQ_CLIENT_UPDATE_RSP);
          QLog.d("QZonePluginUpdater", 2, localStringBuilder.toString());
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
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("plugin need update：");
        paramArrayOfString.append(paramSQ_CLIENT_UPDATE_RSP);
        paramArrayOfString.append(", size = ");
        paramArrayOfString.append(paramSQ_CLIENT_UPDATE_RSP.vPlugin.size());
        QLog.i("QZonePluginUpdater", 2, paramArrayOfString.toString());
        return;
      }
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("plugin don not need update：");
      paramArrayOfString.append(paramSQ_CLIENT_UPDATE_RSP);
      QLog.i("QZonePluginUpdater", 2, paramArrayOfString.toString());
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
    localPluginIntent.module_update_infos = ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).getUpdateInfo();
    localPluginIntent.setResultListner(new QZonePluginUpdater.1(this));
    localPluginIntent.putExtra("forceDownLoadPlugins", paramArrayOfString);
    if (paramWeakReference != null) {
      paramWeakReference = (QQAppInterface)paramWeakReference.get();
    } else {
      paramWeakReference = null;
    }
    if (paramWeakReference != null) {
      paramWeakReference.startServlet(localPluginIntent);
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
    boolean bool2 = false;
    if (paramPluginRecord == null) {
      return false;
    }
    PluginRecord localPluginRecord = getNewPluginInfo(paramPluginRecord.id);
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pre: ");
      ((StringBuilder)localObject).append(paramPluginRecord.md5);
      QLog.d("QZonePluginUpdater", 2, ((StringBuilder)localObject).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new: ");
      if (localPluginRecord != null) {
        localObject = localPluginRecord.md5;
      } else {
        localObject = null;
      }
      localStringBuilder.append((String)localObject);
      QLog.d("QZonePluginUpdater", 2, localStringBuilder.toString());
    }
    boolean bool1 = bool2;
    if (localPluginRecord != null)
    {
      bool1 = bool2;
      if (localPluginRecord.md5.equals(paramPluginRecord.md5)) {
        bool1 = true;
      }
    }
    return bool1;
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
    StringBuilder localStringBuilder1 = new StringBuilder();
    this.requestMap.putAll(this.mPluginInfos);
    Object localObject = this.requestMap.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      PluginRecord localPluginRecord = (PluginRecord)((Iterator)localObject).next();
      UPDATE_INFO localUPDATE_INFO = new UPDATE_INFO();
      localUPDATE_INFO.id = localPluginRecord.id;
      localUPDATE_INFO.app = localPluginRecord.id;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(localPluginRecord.ver);
      localStringBuilder2.append("");
      localUPDATE_INFO.ver = localStringBuilder2.toString();
      localArrayList.add(localUPDATE_INFO);
      localStringBuilder1.append("id=");
      localStringBuilder1.append(localUPDATE_INFO.id);
      localStringBuilder1.append(",app=");
      localStringBuilder1.append(localUPDATE_INFO.app);
      localStringBuilder1.append(",ver=");
      localStringBuilder1.append(localUPDATE_INFO.ver);
      localStringBuilder1.append("\r\n");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getRequestUpdateInfo:");
    ((StringBuilder)localObject).append(localStringBuilder1);
    log(((StringBuilder)localObject).toString());
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
        Object localObject;
        if (paramArrayOfString.actype == 4)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("delete plugin, ");
          ((StringBuilder)localObject).append(paramArrayOfString.name);
          log(((StringBuilder)localObject).toString());
          if (this.mPluginInfos.containsKey(paramArrayOfString.id))
          {
            this.mPluginInfos.remove(paramArrayOfString.id);
            deletePluginInfo(paramArrayOfString.id);
          }
        }
        else
        {
          localObject = new PluginRecord();
          covertToPluginRecord(paramArrayOfString, (PluginRecord)localObject);
          if (this.mPluginInfos.containsKey(paramArrayOfString.id))
          {
            PluginRecord localPluginRecord = (PluginRecord)this.mPluginInfos.get(paramArrayOfString.id);
            if (!((PluginRecord)localObject).equals(localPluginRecord))
            {
              if (localPluginRecord != null) {
                covertToPluginRecord(paramArrayOfString, localPluginRecord);
              } else {
                this.mPluginInfos.put(paramArrayOfString.id, localObject);
              }
              updatePluginInfo((PluginRecord)this.mPluginInfos.get(paramArrayOfString.id));
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onPluginResponse contain update plugin, name = ");
            ((StringBuilder)localObject).append(paramArrayOfString.name);
            ((StringBuilder)localObject).append(", ver = ");
            ((StringBuilder)localObject).append(paramArrayOfString.ver);
            log(((StringBuilder)localObject).toString());
          }
          else
          {
            this.mPluginInfos.put(paramArrayOfString.id, localObject);
            updatePluginInfo((PluginRecord)this.mPluginInfos.get(paramArrayOfString.id));
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onPluginResponse not contain update plugin, name = ");
            ((StringBuilder)localObject).append(paramArrayOfString.name);
            ((StringBuilder)localObject).append(", ver = ");
            ((StringBuilder)localObject).append(paramArrayOfString.ver);
            log(((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  public void setOnUpdateListner(QZonePluginUpdater.OnUpdateListner paramOnUpdateListner)
  {
    this.listner = paramOnUpdateListner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginUpdater
 * JD-Core Version:    0.7.0.1
 */