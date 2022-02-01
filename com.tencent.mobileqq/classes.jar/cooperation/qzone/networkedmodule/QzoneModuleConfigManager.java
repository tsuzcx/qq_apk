package cooperation.qzone.networkedmodule;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneModuleConfigManager
{
  public static final String QZONE_MODULE_CONFIG_CUR = "NetworkedModuleConfig_cur";
  private static final String TAG = "QzoneModuleConfigManager";
  private static volatile QzoneModuleConfigManager sConfigManager;
  private Map<String, QzoneModuleConfigManager.QzoneModuleRecord> mCurModules = jsonStr2moduleRecord(LocalMultiProcConfig.getString("Qz_setting", "NetworkedModuleConfig_cur", ""));
  private Map<String, QzoneModuleConfigManager.QzoneModuleRecord> mUpdateModules = new ConcurrentHashMap();
  
  public static QzoneModuleConfigManager getInstance()
  {
    if (sConfigManager == null) {}
    try
    {
      if (sConfigManager == null) {
        sConfigManager = new QzoneModuleConfigManager();
      }
      return sConfigManager;
    }
    finally {}
  }
  
  static Map<String, QzoneModuleConfigManager.QzoneModuleRecord> jsonStr2moduleRecord(String paramString)
  {
    localConcurrentHashMap = new ConcurrentHashMap();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("qzone_networked_modules");
        if (paramString != null)
        {
          int j = paramString.length();
          int i = 0;
          while (i < j)
          {
            Object localObject2 = paramString.getJSONObject(i);
            Object localObject1 = ((JSONObject)localObject2).optString("module_id");
            String str1 = ((JSONObject)localObject2).optString("module_md5");
            String str2 = ((JSONObject)localObject2).optString("module_url");
            String str3 = ((JSONObject)localObject2).optString("module_version");
            String str4 = ((JSONObject)localObject2).optString("module_main_version");
            String str5 = ((JSONObject)localObject2).optString("module_key_class_name");
            String str6 = ((JSONObject)localObject2).optString("module_class_ids");
            int k = ((JSONObject)localObject2).optInt("module_class_ids_count");
            long l = ((JSONObject)localObject2).optLong("module_file_length");
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)))
            {
              localObject2 = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
              ((QzoneModuleConfigManager.QzoneModuleRecordBuilder)localObject2).setModuleId((String)localObject1).setVersion(str3).setMainVersion(str4).setUrl(str2).setMD5(str1).setKeyClassName(str5).setClassIds(str6).setClassIdsCount(k).setModuleFileLength(l);
              localObject1 = ((QzoneModuleConfigManager.QzoneModuleRecordBuilder)localObject2).build();
              localConcurrentHashMap.put(((QzoneModuleConfigManager.QzoneModuleRecord)localObject1).mModuleId, localObject1);
            }
            i += 1;
          }
        }
        return localConcurrentHashMap;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        QLog.e("QzoneModuleConfigManager", 1, paramString, new Object[0]);
      }
    }
  }
  
  static String moduleRecord2JsonStr(Map<String, QzoneModuleConfigManager.QzoneModuleRecord> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramMap.keySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          JSONObject localJSONObject2 = new JSONObject();
          localObject = (QzoneModuleConfigManager.QzoneModuleRecord)paramMap.get(localObject);
          try
          {
            localJSONObject2.put("module_id", ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mModuleId);
            localJSONObject2.put("module_md5", ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mMD5);
            localJSONObject2.put("module_url", ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mUrl);
            localJSONObject2.put("module_version", ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mVersion);
            localJSONObject2.put("module_main_version", ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mMainVersion);
            localJSONObject2.put("module_key_class_name", ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mKeyClassName);
            localJSONObject2.put("module_class_ids", ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mClassIds);
            localJSONObject2.put("module_class_ids_count", ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mClassIdsCount);
            localJSONObject2.put("module_file_length", ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mModuleFileLength);
            localJSONArray.put(localJSONObject2);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
      try
      {
        localJSONObject1.put("qzone_networked_modules", localJSONArray);
        paramMap = localJSONObject1.toString();
        return paramMap;
      }
      catch (JSONException paramMap)
      {
        paramMap.printStackTrace();
      }
    }
    return "";
  }
  
  private QzoneModuleConfigManager.QzoneModuleRecord parseModuleInfo(UPDATE_INFO paramUPDATE_INFO)
  {
    String str3 = paramUPDATE_INFO.id;
    String str4 = paramUPDATE_INFO.md5;
    Object localObject1 = "";
    if (QLog.isDevelopLevel()) {
      QLog.i("QzoneModuleConfigManager", 1, "id:" + str3);
    }
    String str5 = paramUPDATE_INFO.ver;
    String str6 = paramUPDATE_INFO.mainVersion;
    Object localObject3 = "";
    Object localObject4 = "";
    String str2;
    String str1;
    String[] arrayOfString;
    if (paramUPDATE_INFO.plugin_info != null)
    {
      str2 = (String)paramUPDATE_INFO.plugin_info.get(Integer.valueOf(2));
      str1 = (String)paramUPDATE_INFO.plugin_info.get(Integer.valueOf(0));
      paramUPDATE_INFO = (String)paramUPDATE_INFO.plugin_info.get(Integer.valueOf(1));
      localObject1 = str2;
      localObject3 = str1;
      localObject4 = paramUPDATE_INFO;
      if (!TextUtils.isEmpty(paramUPDATE_INFO))
      {
        arrayOfString = paramUPDATE_INFO.split("#");
        localObject1 = str2;
        localObject3 = str1;
        localObject4 = paramUPDATE_INFO;
        if (arrayOfString.length < 2) {}
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        i = Integer.parseInt(arrayOfString[0]);
        localObject4 = arrayOfString[1];
        paramUPDATE_INFO = str2;
        localObject3 = str1;
        if (QLog.isColorLevel()) {
          QLog.i("QzoneModuleConfigManager", 1, "id:" + str3 + " ,md5:" + str4 + ",url:" + (String)localObject3 + " ,keyClassName:" + paramUPDATE_INFO + ",version:" + str5 + ",mainVersion:" + str6 + ",classIds:" + (String)localObject4 + ",classIDsCount:" + i);
        }
        if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(str4))) {
          break;
        }
        localObject1 = new QzoneModuleConfigManager.QzoneModuleRecordBuilder();
        ((QzoneModuleConfigManager.QzoneModuleRecordBuilder)localObject1).setModuleId(str3).setVersion(str5).setMainVersion(str6).setUrl((String)localObject3).setMD5(str4).setKeyClassName(paramUPDATE_INFO).setClassIds((String)localObject4).setClassIdsCount(i).setModuleFileLength(0L);
        return ((QzoneModuleConfigManager.QzoneModuleRecordBuilder)localObject1).build();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("QzoneModuleConfigManager", 1, "catch an exception: ", localNumberFormatException);
        localObject4 = paramUPDATE_INFO;
        localObject3 = str1;
        localObject2 = str2;
      }
      paramUPDATE_INFO = localObject2;
      int i = 0;
    }
    return null;
  }
  
  public QzoneModuleConfigManager.QzoneModuleRecord getModuleRecord(String paramString)
  {
    boolean bool = true;
    label386:
    for (;;)
    {
      try
      {
        QzoneModuleConfigManager.QzoneModuleRecord localQzoneModuleRecord1 = (QzoneModuleConfigManager.QzoneModuleRecord)this.mCurModules.get(paramString);
        QzoneModuleConfigManager.QzoneModuleRecord localQzoneModuleRecord2 = (QzoneModuleConfigManager.QzoneModuleRecord)this.mUpdateModules.get(paramString);
        Object localObject = localQzoneModuleRecord2;
        if (localQzoneModuleRecord2 == null)
        {
          localQzoneModuleRecord2 = QzoneModuleRecordFactory.getInstance().createRecord(paramString);
          localObject = new StringBuilder().append("try to create record locally,success ? : ");
          if (localQzoneModuleRecord2 == null) {
            continue;
          }
          QLog.i("QzoneModuleConfigManager", 2, String.valueOf(bool));
          localObject = localQzoneModuleRecord2;
          if (localQzoneModuleRecord2 != null)
          {
            this.mUpdateModules.put(paramString, localQzoneModuleRecord2);
            localObject = localQzoneModuleRecord2;
          }
        }
        if (localQzoneModuleRecord1 != null)
        {
          localQzoneModuleRecord1.mNewVersion = ((QzoneModuleConfigManager.QzoneModuleRecord)localObject);
          paramString = localQzoneModuleRecord1;
          localObject = paramString;
          if (paramString != null)
          {
            if ((paramString.mNewVersion != null) && (!TextUtils.isEmpty(paramString.mNewVersion.mQua)) && (!QUA.getQUA3().equalsIgnoreCase(paramString.mNewVersion.mQua)))
            {
              QLog.i("QzoneModuleConfigManager", 1, "mNewVersion.mQua=" + paramString.mNewVersion.mQua + " is not equal QUA=" + QUA.getQUA3());
              paramString.mNewVersion = null;
            }
            localObject = paramString;
            if (!TextUtils.isEmpty(paramString.mQua))
            {
              localObject = paramString;
              if (!QUA.getQUA3().equalsIgnoreCase(paramString.mQua))
              {
                QLog.i("QzoneModuleConfigManager", 1, "curRecord.mQua=" + paramString.mQua + " is not equal QUA=" + QUA.getQUA3());
                if ((paramString.mNewVersion == null) || (!paramString.mMD5.equalsIgnoreCase(paramString.mNewVersion.mMD5))) {
                  continue;
                }
                localObject = paramString.mNewVersion;
                updateConfigAfterDownloaded((QzoneModuleConfigManager.QzoneModuleRecord)localObject);
                QLog.i("QzoneModuleConfigManager", 1, "curRecord and updateRecord has the same md5,so needn't to download again,just call updateConfigAfterDownloaded to update cur configs");
              }
            }
          }
          return localObject;
          bool = false;
        }
        else
        {
          paramString = localQzoneModuleRecord1;
          if (localObject == null) {
            continue;
          }
          ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mNewVersion = ((QzoneModuleConfigManager.QzoneModuleRecord)localObject);
          if (!TextUtils.equals(((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mMD5, ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mMD5)) {
            break label386;
          }
          ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mModuleFileLength = ((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mModuleFileLength;
          break label386;
        }
        localObject = paramString.mNewVersion;
        continue;
        paramString = (String)localObject;
      }
      finally {}
    }
  }
  
  public ArrayList<UPDATE_INFO> getUpdateInfo()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = QzoneModuleConst.QZONE_MODULES_QBOSS.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      UPDATE_INFO localUPDATE_INFO = new UPDATE_INFO();
      localUPDATE_INFO.id = str;
      QzoneModuleConfigManager.QzoneModuleRecord localQzoneModuleRecord = (QzoneModuleConfigManager.QzoneModuleRecord)this.mCurModules.get(str);
      if (localQzoneModuleRecord != null) {}
      for (localUPDATE_INFO.ver = localQzoneModuleRecord.mVersion;; localUPDATE_INFO.ver = "0")
      {
        localArrayList.add(localUPDATE_INFO);
        QLog.i("QzoneModuleConfigManager", 1, "getUpdateInfo:" + str);
        break;
      }
    }
    return localArrayList;
  }
  
  public void handleModuleRsp(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP)
  {
    for (;;)
    {
      try
      {
        QLog.i("QzoneModuleConfigManager", 1, "handleModuleRsp:");
        if ((paramSQ_CLIENT_UPDATE_RSP == null) || (paramSQ_CLIENT_UPDATE_RSP.vModule == null) || (paramSQ_CLIENT_UPDATE_RSP.vModule.size() <= 0)) {
          break label505;
        }
        QLog.i("QzoneModuleConfigManager", 1, "handleModuleRsp:" + paramSQ_CLIENT_UPDATE_RSP.vModule.size());
        paramSQ_CLIENT_UPDATE_RSP = paramSQ_CLIENT_UPDATE_RSP.vModule;
        i = 0;
        paramSQ_CLIENT_UPDATE_RSP = paramSQ_CLIENT_UPDATE_RSP.iterator();
        if (paramSQ_CLIENT_UPDATE_RSP.hasNext())
        {
          UPDATE_INFO localUPDATE_INFO = (UPDATE_INFO)paramSQ_CLIENT_UPDATE_RSP.next();
          Object localObject = parseModuleInfo(localUPDATE_INFO);
          if (localObject != null) {
            this.mUpdateModules.put(((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mModuleId, localObject);
          }
          if (localUPDATE_INFO.actype == 4)
          {
            QLog.w("QzoneModuleConfigManager", 1, "clear module config:" + localUPDATE_INFO.id);
            localObject = (QzoneModuleConfigManager.QzoneModuleRecord)this.mCurModules.get(localUPDATE_INFO.id);
            if (localObject == null) {
              break label508;
            }
            localObject = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), (QzoneModuleConfigManager.QzoneModuleRecord)localObject));
            if (((File)localObject).exists()) {
              ((File)localObject).delete();
            }
            this.mCurModules.remove(localUPDATE_INFO.id);
            i = 1;
            if (this.mUpdateModules.containsKey(localUPDATE_INFO.id)) {
              this.mUpdateModules.remove(localUPDATE_INFO.id);
            }
            QzoneModuleConst.clearLastCrashCount(localUPDATE_INFO.id);
            continue;
          }
          if (localUPDATE_INFO.actype == 0) {
            continue;
          }
          QLog.w("QzoneModuleConfigManager", 1, "force update module config:" + localUPDATE_INFO.id);
          QzoneModuleConfigManager.QzoneModuleRecord localQzoneModuleRecord = (QzoneModuleConfigManager.QzoneModuleRecord)this.mCurModules.get(localUPDATE_INFO.id);
          if (localQzoneModuleRecord == null) {
            continue;
          }
          this.mCurModules.remove(localUPDATE_INFO.id);
          if (!localQzoneModuleRecord.mMD5.equalsIgnoreCase(localUPDATE_INFO.md5))
          {
            localObject = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), localQzoneModuleRecord));
            if (((File)localObject).exists()) {
              ((File)localObject).delete();
            }
            QLog.w("QzoneModuleConfigManager", 1, "force update module md5 is not same,so just delete local file and config:" + localUPDATE_INFO.id);
          }
          else if (localObject != null)
          {
            this.mCurModules.put(localUPDATE_INFO.id, localObject);
            QLog.w("QzoneModuleConfigManager", 1, "force update module md5 is same,so just update config:" + localUPDATE_INFO.id);
            QzoneModuleConst.clearLastCrashCount(localUPDATE_INFO.id);
          }
        }
      }
      finally {}
      if (i != 0) {
        LocalMultiProcConfig.putString("Qz_setting", "NetworkedModuleConfig_cur", moduleRecord2JsonStr(this.mCurModules));
      }
      label505:
      return;
      label508:
      continue;
      int i = 1;
    }
  }
  
  public void putModuleRecord(QzoneModuleConfigManager.QzoneModuleRecord paramQzoneModuleRecord)
  {
    try
    {
      this.mUpdateModules.put(paramQzoneModuleRecord.mModuleId, paramQzoneModuleRecord);
      return;
    }
    finally
    {
      paramQzoneModuleRecord = finally;
      throw paramQzoneModuleRecord;
    }
  }
  
  public void updateConfigAfterDownloaded(QzoneModuleConfigManager.QzoneModuleRecord paramQzoneModuleRecord)
  {
    if (paramQzoneModuleRecord != null) {}
    try
    {
      this.mUpdateModules.remove(paramQzoneModuleRecord.mModuleId);
      Object localObject = (QzoneModuleConfigManager.QzoneModuleRecord)this.mCurModules.get(paramQzoneModuleRecord.mModuleId);
      if ((localObject != null) && (!((QzoneModuleConfigManager.QzoneModuleRecord)localObject).mMD5.equalsIgnoreCase(paramQzoneModuleRecord.mMD5)))
      {
        localObject = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), (QzoneModuleConfigManager.QzoneModuleRecord)localObject));
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
      localObject = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), paramQzoneModuleRecord));
      if (((File)localObject).exists()) {
        paramQzoneModuleRecord.mModuleFileLength = ((File)localObject).length();
      }
      this.mCurModules.put(paramQzoneModuleRecord.mModuleId, paramQzoneModuleRecord);
      LocalMultiProcConfig.putString("Qz_setting", "NetworkedModuleConfig_cur", moduleRecord2JsonStr(this.mCurModules));
      QzoneModuleConst.clearLastCrashCount(paramQzoneModuleRecord.mModuleId);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleConfigManager
 * JD-Core Version:    0.7.0.1
 */