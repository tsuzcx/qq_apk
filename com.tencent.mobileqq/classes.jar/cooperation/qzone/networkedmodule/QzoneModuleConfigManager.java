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
  private Map<String, QzoneModuleRecord> mCurModules = jsonStr2moduleRecord(LocalMultiProcConfig.getString("Qz_setting", "NetworkedModuleConfig_cur", ""));
  private Map<String, QzoneModuleRecord> mUpdateModules = new ConcurrentHashMap();
  
  public static QzoneModuleConfigManager getInstance()
  {
    if (sConfigManager == null) {
      try
      {
        if (sConfigManager == null) {
          sConfigManager = new QzoneModuleConfigManager();
        }
      }
      finally {}
    }
    return sConfigManager;
  }
  
  static Map<String, QzoneModuleRecord> jsonStr2moduleRecord(String paramString)
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
              localObject2 = new QzoneModuleRecordBuilder();
              ((QzoneModuleRecordBuilder)localObject2).setModuleId((String)localObject1).setVersion(str3).setMainVersion(str4).setUrl(str2).setMD5(str1).setKeyClassName(str5).setClassIds(str6).setClassIdsCount(k).setModuleFileLength(l);
              localObject1 = ((QzoneModuleRecordBuilder)localObject2).build();
              localConcurrentHashMap.put(((QzoneModuleRecord)localObject1).mModuleId, localObject1);
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
  
  static String moduleRecord2JsonStr(Map<String, QzoneModuleRecord> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localObject = (QzoneModuleRecord)paramMap.get(localObject);
        try
        {
          localJSONObject2.put("module_id", ((QzoneModuleRecord)localObject).mModuleId);
          localJSONObject2.put("module_md5", ((QzoneModuleRecord)localObject).mMD5);
          localJSONObject2.put("module_url", ((QzoneModuleRecord)localObject).mUrl);
          localJSONObject2.put("module_version", ((QzoneModuleRecord)localObject).mVersion);
          localJSONObject2.put("module_main_version", ((QzoneModuleRecord)localObject).mMainVersion);
          localJSONObject2.put("module_key_class_name", ((QzoneModuleRecord)localObject).mKeyClassName);
          localJSONObject2.put("module_class_ids", ((QzoneModuleRecord)localObject).mClassIds);
          localJSONObject2.put("module_class_ids_count", ((QzoneModuleRecord)localObject).mClassIdsCount);
          localJSONObject2.put("module_file_length", ((QzoneModuleRecord)localObject).mModuleFileLength);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        localJSONArray.put(localJSONObject2);
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
  
  private QzoneModuleRecord parseModuleInfo(UPDATE_INFO paramUPDATE_INFO)
  {
    String str3 = paramUPDATE_INFO.id;
    String str4 = paramUPDATE_INFO.md5;
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("id:");
      ((StringBuilder)localObject1).append(str3);
      QLog.i("QzoneModuleConfigManager", 1, ((StringBuilder)localObject1).toString());
    }
    String str5 = paramUPDATE_INFO.ver;
    String str6 = paramUPDATE_INFO.mainVersion;
    Object localObject1 = paramUPDATE_INFO.plugin_info;
    int j = 0;
    Object localObject3;
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject3 = (String)paramUPDATE_INFO.plugin_info.get(Integer.valueOf(2));
      String str1 = (String)paramUPDATE_INFO.plugin_info.get(Integer.valueOf(0));
      String str2 = (String)paramUPDATE_INFO.plugin_info.get(Integer.valueOf(1));
      localObject1 = localObject3;
      i = j;
      localObject2 = str1;
      paramUPDATE_INFO = str2;
      if (!TextUtils.isEmpty(str2))
      {
        String[] arrayOfString = str2.split("#");
        localObject1 = localObject3;
        i = j;
        localObject2 = str1;
        paramUPDATE_INFO = str2;
        if (arrayOfString.length >= 2) {
          try
          {
            i = Integer.parseInt(arrayOfString[0]);
            paramUPDATE_INFO = arrayOfString[1];
            localObject1 = localObject3;
            localObject2 = str1;
          }
          catch (NumberFormatException paramUPDATE_INFO)
          {
            QLog.e("QzoneModuleConfigManager", 1, "catch an exception: ", paramUPDATE_INFO);
            localObject1 = localObject3;
            i = j;
            localObject2 = str1;
            paramUPDATE_INFO = str2;
          }
        }
      }
    }
    else
    {
      paramUPDATE_INFO = "";
      localObject1 = paramUPDATE_INFO;
      localObject2 = localObject1;
      i = j;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("id:");
      ((StringBuilder)localObject3).append(str3);
      ((StringBuilder)localObject3).append(" ,md5:");
      ((StringBuilder)localObject3).append(str4);
      ((StringBuilder)localObject3).append(",url:");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(" ,keyClassName:");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(",version:");
      ((StringBuilder)localObject3).append(str5);
      ((StringBuilder)localObject3).append(",mainVersion:");
      ((StringBuilder)localObject3).append(str6);
      ((StringBuilder)localObject3).append(",classIds:");
      ((StringBuilder)localObject3).append(paramUPDATE_INFO);
      ((StringBuilder)localObject3).append(",classIDsCount:");
      ((StringBuilder)localObject3).append(i);
      QLog.i("QzoneModuleConfigManager", 1, ((StringBuilder)localObject3).toString());
    }
    if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str4)))
    {
      localObject3 = new QzoneModuleRecordBuilder();
      ((QzoneModuleRecordBuilder)localObject3).setModuleId(str3).setVersion(str5).setMainVersion(str6).setUrl((String)localObject2).setMD5(str4).setKeyClassName((String)localObject1).setClassIds(paramUPDATE_INFO).setClassIdsCount(i).setModuleFileLength(0L);
      return ((QzoneModuleRecordBuilder)localObject3).build();
    }
    return null;
  }
  
  public QzoneModuleRecord getModuleRecord(String paramString)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        QzoneModuleRecord localQzoneModuleRecord1 = (QzoneModuleRecord)this.mCurModules.get(paramString);
        QzoneModuleRecord localQzoneModuleRecord2 = (QzoneModuleRecord)this.mUpdateModules.get(paramString);
        localObject = localQzoneModuleRecord2;
        if (localQzoneModuleRecord2 == null)
        {
          localQzoneModuleRecord2 = QzoneModuleRecordFactory.getInstance().createRecord(paramString);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("try to create record locally,success ? : ");
          if (localQzoneModuleRecord2 == null) {
            break label411;
          }
          bool = true;
          ((StringBuilder)localObject).append(String.valueOf(bool));
          QLog.i("QzoneModuleConfigManager", 2, ((StringBuilder)localObject).toString());
          localObject = localQzoneModuleRecord2;
          if (localQzoneModuleRecord2 != null)
          {
            this.mUpdateModules.put(paramString, localQzoneModuleRecord2);
            localObject = localQzoneModuleRecord2;
          }
        }
        if (localQzoneModuleRecord1 != null)
        {
          localQzoneModuleRecord1.mNewVersion = ((QzoneModuleRecord)localObject);
          paramString = localQzoneModuleRecord1;
        }
        else
        {
          paramString = localQzoneModuleRecord1;
          if (localObject != null)
          {
            ((QzoneModuleRecord)localObject).mNewVersion = ((QzoneModuleRecord)localObject);
            if (!TextUtils.equals(((QzoneModuleRecord)localObject).mMD5, ((QzoneModuleRecord)localObject).mMD5)) {
              break label416;
            }
            ((QzoneModuleRecord)localObject).mModuleFileLength = ((QzoneModuleRecord)localObject).mModuleFileLength;
            break label416;
          }
        }
        localObject = paramString;
        if (paramString != null)
        {
          if ((paramString.mNewVersion != null) && (!TextUtils.isEmpty(paramString.mNewVersion.mQua)) && (!QUA.getQUA3().equalsIgnoreCase(paramString.mNewVersion.mQua)))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("mNewVersion.mQua=");
            ((StringBuilder)localObject).append(paramString.mNewVersion.mQua);
            ((StringBuilder)localObject).append(" is not equal QUA=");
            ((StringBuilder)localObject).append(QUA.getQUA3());
            QLog.i("QzoneModuleConfigManager", 1, ((StringBuilder)localObject).toString());
            paramString.mNewVersion = null;
          }
          localObject = paramString;
          if (!TextUtils.isEmpty(paramString.mQua))
          {
            localObject = paramString;
            if (!QUA.getQUA3().equalsIgnoreCase(paramString.mQua))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("curRecord.mQua=");
              ((StringBuilder)localObject).append(paramString.mQua);
              ((StringBuilder)localObject).append(" is not equal QUA=");
              ((StringBuilder)localObject).append(QUA.getQUA3());
              QLog.i("QzoneModuleConfigManager", 1, ((StringBuilder)localObject).toString());
              if ((paramString.mNewVersion != null) && (paramString.mMD5.equalsIgnoreCase(paramString.mNewVersion.mMD5)))
              {
                localObject = paramString.mNewVersion;
                updateConfigAfterDownloaded((QzoneModuleRecord)localObject);
                QLog.i("QzoneModuleConfigManager", 1, "curRecord and updateRecord has the same md5,so needn't to download again,just call updateConfigAfterDownloaded to update cur configs");
              }
              else
              {
                localObject = paramString.mNewVersion;
              }
            }
          }
        }
        return localObject;
      }
      finally {}
      label411:
      boolean bool = false;
      continue;
      label416:
      paramString = (String)localObject;
    }
  }
  
  public ArrayList<UPDATE_INFO> getUpdateInfo()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = QzoneModuleConst.QZONE_MODULES_QBOSS.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = new UPDATE_INFO();
      ((UPDATE_INFO)localObject).id = str;
      QzoneModuleRecord localQzoneModuleRecord = (QzoneModuleRecord)this.mCurModules.get(str);
      if (localQzoneModuleRecord != null) {
        ((UPDATE_INFO)localObject).ver = localQzoneModuleRecord.mVersion;
      } else {
        ((UPDATE_INFO)localObject).ver = "0";
      }
      localArrayList.add(localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getUpdateInfo:");
      ((StringBuilder)localObject).append(str);
      QLog.i("QzoneModuleConfigManager", 1, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public void handleModuleRsp(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP)
  {
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            QLog.i("QzoneModuleConfigManager", 1, "handleModuleRsp:");
            if ((paramSQ_CLIENT_UPDATE_RSP == null) || (paramSQ_CLIENT_UPDATE_RSP.vModule == null) || (paramSQ_CLIENT_UPDATE_RSP.vModule.size() <= 0)) {
              continue;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("handleModuleRsp:");
            ((StringBuilder)localObject1).append(paramSQ_CLIENT_UPDATE_RSP.vModule.size());
            QLog.i("QzoneModuleConfigManager", 1, ((StringBuilder)localObject1).toString());
            paramSQ_CLIENT_UPDATE_RSP = paramSQ_CLIENT_UPDATE_RSP.vModule;
            i = 0;
            paramSQ_CLIENT_UPDATE_RSP = paramSQ_CLIENT_UPDATE_RSP.iterator();
          }
          finally
          {
            Object localObject1;
            Object localObject2;
            Object localObject3;
            continue;
            throw paramSQ_CLIENT_UPDATE_RSP;
            continue;
            int i = 1;
            continue;
          }
          if (!paramSQ_CLIENT_UPDATE_RSP.hasNext()) {
            continue;
          }
          localObject1 = (UPDATE_INFO)paramSQ_CLIENT_UPDATE_RSP.next();
          localObject2 = parseModuleInfo((UPDATE_INFO)localObject1);
          if (localObject2 != null) {
            this.mUpdateModules.put(((QzoneModuleRecord)localObject2).mModuleId, localObject2);
          }
          if (((UPDATE_INFO)localObject1).actype != 4) {
            continue;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("clear module config:");
          ((StringBuilder)localObject2).append(((UPDATE_INFO)localObject1).id);
          QLog.w("QzoneModuleConfigManager", 1, ((StringBuilder)localObject2).toString());
          localObject2 = (QzoneModuleRecord)this.mCurModules.get(((UPDATE_INFO)localObject1).id);
          if (localObject2 != null)
          {
            localObject2 = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), (QzoneModuleRecord)localObject2));
            if (((File)localObject2).exists()) {
              ((File)localObject2).delete();
            }
            this.mCurModules.remove(((UPDATE_INFO)localObject1).id);
            i = 1;
          }
          if (this.mUpdateModules.containsKey(((UPDATE_INFO)localObject1).id)) {
            this.mUpdateModules.remove(((UPDATE_INFO)localObject1).id);
          }
          QzoneModuleConst.clearLastCrashCount(((UPDATE_INFO)localObject1).id);
        }
      } while (((UPDATE_INFO)localObject1).actype == 0);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("force update module config:");
      ((StringBuilder)localObject3).append(((UPDATE_INFO)localObject1).id);
      QLog.w("QzoneModuleConfigManager", 1, ((StringBuilder)localObject3).toString());
      localObject3 = (QzoneModuleRecord)this.mCurModules.get(((UPDATE_INFO)localObject1).id);
    } while (localObject3 == null);
    this.mCurModules.remove(((UPDATE_INFO)localObject1).id);
    if (!((QzoneModuleRecord)localObject3).mMD5.equalsIgnoreCase(((UPDATE_INFO)localObject1).md5))
    {
      localObject2 = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), (QzoneModuleRecord)localObject3));
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("force update module md5 is not same,so just delete local file and config:");
      ((StringBuilder)localObject2).append(((UPDATE_INFO)localObject1).id);
      QLog.w("QzoneModuleConfigManager", 1, ((StringBuilder)localObject2).toString());
    }
    else if (localObject2 != null)
    {
      this.mCurModules.put(((UPDATE_INFO)localObject1).id, localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("force update module md5 is same,so just update config:");
      ((StringBuilder)localObject2).append(((UPDATE_INFO)localObject1).id);
      QLog.w("QzoneModuleConfigManager", 1, ((StringBuilder)localObject2).toString());
      QzoneModuleConst.clearLastCrashCount(((UPDATE_INFO)localObject1).id);
      break label560;
      if (i != 0) {
        LocalMultiProcConfig.putString("Qz_setting", "NetworkedModuleConfig_cur", moduleRecord2JsonStr(this.mCurModules));
      }
      return;
    }
  }
  
  public void putModuleRecord(QzoneModuleRecord paramQzoneModuleRecord)
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
  
  public void updateConfigAfterDownloaded(QzoneModuleRecord paramQzoneModuleRecord)
  {
    if (paramQzoneModuleRecord != null) {
      try
      {
        this.mUpdateModules.remove(paramQzoneModuleRecord.mModuleId);
        Object localObject = (QzoneModuleRecord)this.mCurModules.get(paramQzoneModuleRecord.mModuleId);
        if ((localObject != null) && (!((QzoneModuleRecord)localObject).mMD5.equalsIgnoreCase(paramQzoneModuleRecord.mMD5)))
        {
          localObject = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), (QzoneModuleRecord)localObject));
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
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleConfigManager
 * JD-Core Version:    0.7.0.1
 */