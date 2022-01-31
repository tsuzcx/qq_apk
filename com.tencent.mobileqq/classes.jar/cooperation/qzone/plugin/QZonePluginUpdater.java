package cooperation.qzone.plugin;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import amhw;
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
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public QZonePluginUpdater.OnUpdateListner a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map jdField_a_of_type_JavaUtilMap;
  HashMap b = new HashMap();
  
  public QZonePluginUpdater(QQAppInterface paramQQAppInterface, Context paramContext, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    paramQQAppInterface = new PluginRecord();
    paramQQAppInterface.c = "0";
    this.jdField_a_of_type_JavaUtilHashMap.put("qzone_live_video_plugin_hack.apk", "com.tencent.mobileqq:qzonelive");
    paramQQAppInterface.e = "qzone_live_video_plugin_hack.apk";
    paramQQAppInterface.f = "qzone_live_video_plugin_hack.apk";
    this.b.put(paramQQAppInterface.f, paramQQAppInterface);
    paramQQAppInterface = new PluginRecord();
    paramQQAppInterface.c = "0";
    paramQQAppInterface.e = "qzone_vertical_video_plugin.apk";
    paramQQAppInterface.f = "qzone_vertical_video_plugin.apk";
    this.b.put(paramQQAppInterface.f, paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilHashMap.put("qzone_vertical_video_plugin.apk", "com.tencent.mobileqq:qzonelive");
    QZonePluginUtils.a(paramContext, this.jdField_a_of_type_JavaUtilMap);
  }
  
  public static String a(Map paramMap, Integer paramInteger)
  {
    if (paramMap != null) {
      return (String)paramMap.get(paramInteger);
    }
    return null;
  }
  
  private void a(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP)
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
        QZonePatchService.a().a(str1, str2);
      }
    }
  }
  
  private void a(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP, String[] paramArrayOfString)
  {
    if (paramSQ_CLIENT_UPDATE_RSP != null)
    {
      if ((paramSQ_CLIENT_UPDATE_RSP.vPlugin == null) || (paramSQ_CLIENT_UPDATE_RSP.vPlugin.size() <= 0)) {
        break label62;
      }
      a(paramSQ_CLIENT_UPDATE_RSP.vPlugin, paramArrayOfString);
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginUpdater", 2, "插件需要升级：" + paramSQ_CLIENT_UPDATE_RSP);
      }
    }
    label62:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QZonePluginUpdater", 2, "插件不需升级：" + paramSQ_CLIENT_UPDATE_RSP);
  }
  
  private void a(UPDATE_INFO paramUPDATE_INFO, PluginRecord paramPluginRecord)
  {
    if ((paramPluginRecord == null) || (paramUPDATE_INFO == null)) {
      return;
    }
    paramPluginRecord.jdField_b_of_type_JavaLangString = paramUPDATE_INFO.app;
    paramPluginRecord.f = paramUPDATE_INFO.id;
    paramPluginRecord.jdField_b_of_type_Int = paramUPDATE_INFO.actype;
    paramPluginRecord.g = paramUPDATE_INFO.mainVersion;
    paramPluginRecord.h = paramUPDATE_INFO.md5;
    paramPluginRecord.e = paramUPDATE_INFO.name;
    paramPluginRecord.d = paramPluginRecord.c;
    paramPluginRecord.c = paramUPDATE_INFO.ver;
    paramPluginRecord.jdField_b_of_type_Int = paramUPDATE_INFO.actype;
    paramPluginRecord.a = a(paramUPDATE_INFO.plugin_info, Integer.valueOf(0));
    paramPluginRecord.j = ((String)this.jdField_a_of_type_JavaUtilHashMap.get(paramPluginRecord.f));
    paramPluginRecord.k = QZonePluginUtils.a(BaseApplicationImpl.getContext(), paramPluginRecord.f).getAbsolutePath();
  }
  
  private void a(PluginRecord paramPluginRecord)
  {
    File localFile = QZonePluginUtils.c(BaseApplicationImpl.getContext(), paramPluginRecord.f);
    if ((localFile != null) && (localFile.exists())) {
      localFile.delete();
    }
    QZonePluginUtils.a(paramPluginRecord);
    LpReportInfo_dc01500.reportConfig(paramPluginRecord.f, paramPluginRecord.d, paramPluginRecord.c, 0);
  }
  
  private void a(String paramString)
  {
    paramString = QZonePluginUtils.c(BaseApplicationImpl.getContext(), paramString);
    if ((paramString != null) && (paramString.exists())) {
      paramString.delete();
    }
  }
  
  private void a(WeakReference paramWeakReference, String[] paramArrayOfString)
  {
    PluginIntent localPluginIntent = new PluginIntent(BaseApplicationImpl.getContext(), QzoneUpdatePatchServlet.class);
    localPluginIntent.a = a();
    localPluginIntent.b = QzoneModuleConfigManager.a().a();
    localPluginIntent.a(new amhw(this));
    localPluginIntent.putExtra("forceDownLoadPlugins", paramArrayOfString);
    paramArrayOfString = null;
    if (paramWeakReference != null) {
      paramArrayOfString = (QQAppInterface)paramWeakReference.get();
    }
    if (paramArrayOfString != null) {
      paramArrayOfString.startServlet(localPluginIntent);
    }
  }
  
  private static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, paramString);
    }
  }
  
  public PluginRecord a(String paramString)
  {
    return (PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    this.b.putAll(this.jdField_a_of_type_JavaUtilMap);
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      PluginRecord localPluginRecord = (PluginRecord)localIterator.next();
      UPDATE_INFO localUPDATE_INFO = new UPDATE_INFO();
      localUPDATE_INFO.id = localPluginRecord.f;
      localUPDATE_INFO.app = localPluginRecord.f;
      localUPDATE_INFO.ver = (localPluginRecord.c + "");
      localArrayList.add(localUPDATE_INFO);
      localStringBuilder.append("id=").append(localUPDATE_INFO.id).append(",app=").append(localUPDATE_INFO.app).append(",ver=").append(localUPDATE_INFO.ver).append("\r\n");
    }
    b("getRequestUpdateInfo:" + localStringBuilder);
    return localArrayList;
  }
  
  public Map a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_JavaLangRefWeakReference, null);
  }
  
  public void a(QZonePluginUpdater.OnUpdateListner paramOnUpdateListner)
  {
    this.jdField_a_of_type_CooperationQzonePluginQZonePluginUpdater$OnUpdateListner = paramOnUpdateListner;
  }
  
  public void a(ArrayList paramArrayList, String[] paramArrayOfString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramArrayOfString = (UPDATE_INFO)paramArrayList.next();
        if (paramArrayOfString.actype == 4)
        {
          b("delete plugin, " + paramArrayOfString.name);
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramArrayOfString.id))
          {
            this.jdField_a_of_type_JavaUtilMap.remove(paramArrayOfString.id);
            a(paramArrayOfString.id);
          }
        }
        else
        {
          PluginRecord localPluginRecord1 = new PluginRecord();
          a(paramArrayOfString, localPluginRecord1);
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramArrayOfString.id))
          {
            PluginRecord localPluginRecord2 = (PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramArrayOfString.id);
            if (!localPluginRecord1.equals(localPluginRecord2))
            {
              if (localPluginRecord2 != null) {
                a(paramArrayOfString, localPluginRecord2);
              }
              for (;;)
              {
                a((PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramArrayOfString.id));
                break;
                this.jdField_a_of_type_JavaUtilMap.put(paramArrayOfString.id, localPluginRecord1);
              }
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilMap.put(paramArrayOfString.id, localPluginRecord1);
            a((PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramArrayOfString.id));
          }
        }
      }
    }
  }
  
  public boolean a(PluginRecord paramPluginRecord)
  {
    if (paramPluginRecord == null) {
      return false;
    }
    PluginRecord localPluginRecord = b(paramPluginRecord.f);
    String str;
    if (QLog.isColorLevel())
    {
      QLog.d("QZonePluginUpdater", 2, "pre: " + paramPluginRecord.h);
      StringBuilder localStringBuilder = new StringBuilder().append("new: ");
      if (localPluginRecord != null)
      {
        str = localPluginRecord.h;
        QLog.d("QZonePluginUpdater", 2, str);
      }
    }
    else
    {
      if ((localPluginRecord == null) || (!localPluginRecord.h.equals(paramPluginRecord.h))) {
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
  
  public PluginRecord b(String paramString)
  {
    return (PluginRecord)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginUpdater
 * JD-Core Version:    0.7.0.1
 */