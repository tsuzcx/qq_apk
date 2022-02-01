package dov.com.qq.im.ptv;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import ayym;
import bdfk;
import bgzr;
import boqx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import llq;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LightVideoConfigMgr
{
  private static AtomicReference<LightVideoConfigMgr> jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
  private boqx jdField_a_of_type_Boqx = new boqx();
  
  public static int a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("video_light_filter_cfg", 4).getInt("video_light_version_key", 0);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int k = a();
    int m = paramConfig.version.get();
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoConfigMgr", 2, "handleLightFilterConfig|received remote version: " + m + " | localVersion: " + k);
    }
    if (m != k) {
      if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
      {
        paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramConfig.msg_content_list.size() - 1);
        if (paramQQAppInterface != null) {
          if (paramQQAppInterface.compress.get() == 1)
          {
            paramQQAppInterface = ayym.a(paramQQAppInterface.content.get().toByteArray());
            if (paramQQAppInterface == null) {}
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = new String(paramQQAppInterface, "UTF-8");
        i = a(paramQQAppInterface, m);
        j = i;
        if (i != 0)
        {
          if (paramConfig.content_list.size() <= 0) {
            break label375;
          }
          i = a((String)paramConfig.content_list.get(0), m);
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.d("LightVideoConfigMgr", 2, "receiveAllConfigs[handleLightFilterConfig]| content_list has data,version: " + m + ",localVersion:" + k);
            j = i;
          }
        }
        return j;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoConfigMgr", 2, "receiveAllConfigs[handleLightFilterConfig]|Throwable:" + paramQQAppInterface.getMessage());
        }
        paramQQAppInterface = "";
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoConfigMgr", 2, "receiveAllConfigs[handleLightFilterConfig]|inflateConfigString error!");
      }
      paramQQAppInterface = "";
      continue;
      paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoConfigMgr", 2, "receiveAllConfigs[handleLightFilterConfig]| content==null");
      }
      int i = -125;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoConfigMgr", 2, "receiveAllConfigs[handleLightFilterConfig]| msg_content_list is empty ,version: " + m + ",localVersion:" + k);
      }
      i = -125;
      continue;
      label375:
      int j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("LightVideoConfigMgr", 2, "receiveAllConfigs[handleLightFilterConfig]| content_list has no data,version: " + m + ",localVersion:" + k);
        return i;
        i = 0;
      }
    }
  }
  
  private static int a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoConfigMgr", 2, "updateLightVideoConfigContent|received save version: " + paramInt + ",config_content=" + paramString);
    }
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      int j = -101;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("LightVideoConfigMgr", 2, "updateLightVideoConfigContent| version=" + paramInt + ",config_content=" + paramString);
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        a(paramString);
      }
      return i;
      boolean bool = a(paramString, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoConfigMgr", 2, "updateLightVideoConfigContent| saveContentOK=" + bool);
      }
      if (bool) {
        i = 0;
      } else {
        i = -128;
      }
    }
  }
  
  private static int a(JSONObject paramJSONObject, List<LightVideoConfigMgr.StrategyItem> paramList)
  {
    try
    {
      paramJSONObject = paramJSONObject.optJSONArray("lightStrategy");
      if (paramJSONObject == null) {
        return 0;
      }
      j = paramJSONObject.length();
      if (j <= 0)
      {
        VideoEnvironment.LogDownLoad("LightVideoConfigMgr", "parseConfigData: arrayLength=" + j, null);
        return 0;
      }
    }
    catch (JSONException paramJSONObject)
    {
      int j;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoConfigMgr", 2, "parseConfigData[JSONException]", paramJSONObject);
      }
      paramList.clear();
      for (i = -100;; i = 0)
      {
        VideoEnvironment.LogDownLoad("LightVideoConfigMgr", "parseConfigData:errCode=" + i, null);
        return i;
        i = 0;
        while (i < j)
        {
          LightVideoConfigMgr.StrategyItem localStrategyItem = (LightVideoConfigMgr.StrategyItem)bgzr.a(paramJSONObject.getJSONObject(i), LightVideoConfigMgr.StrategyItem.class);
          if (localStrategyItem == null)
          {
            VideoEnvironment.LogDownLoad("LightVideoConfigMgr", "parseConfigData:item=null i=" + i, null);
            paramList.clear();
            return -100;
          }
          paramList.add(localStrategyItem);
          i += 1;
        }
      }
    }
    catch (OutOfMemoryError paramJSONObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoConfigMgr", 2, "parseConfigData[OutOfMemoryError]", paramJSONObject);
        }
        paramList.clear();
        int i = -100;
      }
    }
  }
  
  public static LightVideoConfigMgr a()
  {
    Object localObject;
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() == null)
    {
      localObject = a();
      if ((localObject != null) && (!"".equals(localObject))) {
        break label52;
      }
      localObject = new LightVideoConfigMgr();
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.getAndSet(localObject);
    }
    for (;;)
    {
      return (LightVideoConfigMgr)jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
      label52:
      b((String)localObject);
    }
  }
  
  private static String a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("video_light_filter_cfg", 4).getString("video_light_content_key", "");
  }
  
  private static void a(String paramString)
  {
    ThreadManager.post(new LightVideoConfigMgr.1(paramString), 5, null, true);
  }
  
  private static boolean a(LightVideoConfigMgr.StrategyItem paramStrategyItem)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = b(paramStrategyItem);
    String str = "" + paramStrategyItem.strategy;
    if (str.equalsIgnoreCase("<="))
    {
      if ((i > paramStrategyItem.sdk_int) || (!bool)) {}
    }
    else {
      while ((str.equalsIgnoreCase("=")) && (i == paramStrategyItem.sdk_int) && (bool)) {
        return false;
      }
    }
    return true;
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("video_light_filter_cfg", 4).edit();
    localEditor.putString("video_light_content_key", paramString);
    localEditor.putInt("video_light_version_key", paramInt);
    return localEditor.commit();
  }
  
  private static boolean a(List<LightVideoConfigMgr.StrategyItem> paramList)
  {
    if (paramList.size() <= 0) {
      return true;
    }
    String str = Build.MODEL;
    boolean bool2 = false;
    Object localObject = paramList.iterator();
    LightVideoConfigMgr.StrategyItem localStrategyItem;
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localStrategyItem = (LightVideoConfigMgr.StrategyItem)((Iterator)localObject).next();
    } while ((localStrategyItem == null) || (!("" + localStrategyItem.model).equalsIgnoreCase("All")));
    boolean bool1 = a(localStrategyItem);
    if (bool1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (LightVideoConfigMgr.StrategyItem)paramList.next();
        if ((localObject != null) && (("" + ((LightVideoConfigMgr.StrategyItem)localObject).model).equalsIgnoreCase(str))) {
          return a((LightVideoConfigMgr.StrategyItem)localObject);
        }
      }
    }
    return bool1;
  }
  
  private static boolean a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("lightBlackList");
    if (TextUtils.isEmpty(paramJSONObject)) {}
    for (;;)
    {
      return false;
      paramJSONObject = paramJSONObject.split("\\|");
      if (paramJSONObject.length > 0)
      {
        String str = Build.MODEL + ";" + Build.VERSION.SDK_INT;
        int j = paramJSONObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramJSONObject[i].equalsIgnoreCase(str)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private static LightVideoConfigMgr b(String paramString)
  {
    int j = 450;
    int k = 20;
    LightVideoConfigMgr localLightVideoConfigMgr = new LightVideoConfigMgr();
    try
    {
      paramString = new JSONObject(paramString);
      localLightVideoConfigMgr.jdField_a_of_type_Boqx.jdField_a_of_type_Boolean = paramString.optBoolean("showLightEntry", false);
      localLightVideoConfigMgr.jdField_a_of_type_Boqx.jdField_a_of_type_Int = paramString.optInt("longClickEntry", 0);
      int m = paramString.optInt("lightDuration", 20);
      i = m;
      if (m > 5) {
        break label216;
      }
      i = 20;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("LightVideoConfigMgr", 2, "loadGeneralConfigMgr[JSONException]", paramString);
      return localLightVideoConfigMgr;
    }
    localLightVideoConfigMgr.jdField_a_of_type_Boqx.jdField_b_of_type_Int = i;
    k = paramString.optInt("lightBitrate", 450);
    int i = k;
    if (k >= 2000) {
      i = 450;
    }
    for (;;)
    {
      label119:
      localLightVideoConfigMgr.jdField_a_of_type_Boqx.c = i;
      localLightVideoConfigMgr.jdField_a_of_type_Boqx.jdField_b_of_type_Boolean = false;
      if ((localLightVideoConfigMgr.jdField_a_of_type_Boqx.jdField_a_of_type_Boolean) && (!a(paramString)))
      {
        ArrayList localArrayList = new ArrayList(3);
        if (a(paramString, localArrayList) == 0) {
          localLightVideoConfigMgr.jdField_a_of_type_Boqx.jdField_b_of_type_Boolean = a(localArrayList);
        }
      }
      return localLightVideoConfigMgr;
      label216:
      do
      {
        break label119;
        do
        {
          break;
        } while (i < 200);
        i = k;
        break;
      } while (i > 100);
      i = j;
    }
  }
  
  private static void b(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.getAndSet(paramString);
    }
  }
  
  private static boolean b(LightVideoConfigMgr.StrategyItem paramStrategyItem)
  {
    if (paramStrategyItem.cpuKernel <= 0) {}
    while (llq.e() <= paramStrategyItem.cpuKernel) {
      return true;
    }
    return false;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boqx.jdField_a_of_type_Boolean) && (!bdfk.b());
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boqx.jdField_a_of_type_Int == 1;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boqx.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightVideoConfigMgr
 * JD-Core Version:    0.7.0.1
 */