package com.tencent.mobileqq.soload.config;

import android.text.TextUtils;
import aoko;
import aznb;
import azng;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class SoConfig
  implements Serializable
{
  private static final byte[] a = new byte[0];
  public int mLastAppId;
  public Map<String, SoConfig.SoInfo> mSoInfos = new HashMap();
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(BaseApplicationImpl.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/QWallet/").append("/.config/");
    localStringBuilder.append("sl.config");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static SoConfig readConfig()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: invokestatic 65	com/tencent/mobileqq/soload/config/SoConfig:a	()Ljava/lang/String;
    //   7: astore 4
    //   9: aload 4
    //   11: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +92 -> 106
    //   17: aload_2
    //   18: astore_0
    //   19: getstatic 17	com/tencent/mobileqq/soload/config/SoConfig:a	[B
    //   22: astore_3
    //   23: aload_2
    //   24: astore_0
    //   25: aload_3
    //   26: monitorenter
    //   27: aload 4
    //   29: invokestatic 80	ajeu:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   32: checkcast 2	com/tencent/mobileqq/soload/config/SoConfig
    //   35: astore_0
    //   36: aload_3
    //   37: monitorexit
    //   38: aload_0
    //   39: astore_1
    //   40: aload_0
    //   41: ifnonnull +11 -> 52
    //   44: new 2	com/tencent/mobileqq/soload/config/SoConfig
    //   47: dup
    //   48: invokespecial 81	com/tencent/mobileqq/soload/config/SoConfig:<init>	()V
    //   51: astore_1
    //   52: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +28 -> 83
    //   58: ldc 89
    //   60: iconst_2
    //   61: new 29	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   68: ldc 92
    //   70: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_1
    //   84: areturn
    //   85: astore_2
    //   86: aload_1
    //   87: astore_0
    //   88: aload_0
    //   89: astore_1
    //   90: aload_3
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 102	java/lang/Exception:printStackTrace	()V
    //   99: goto -61 -> 38
    //   102: astore_2
    //   103: goto -15 -> 88
    //   106: aconst_null
    //   107: astore_0
    //   108: goto -70 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	90	0	localObject1	Object
    //   3	87	1	localObject2	Object
    //   94	2	1	localException	java.lang.Exception
    //   1	23	2	localObject3	Object
    //   85	8	2	localObject4	Object
    //   102	1	2	localObject5	Object
    //   22	69	3	arrayOfByte	byte[]
    //   7	21	4	str	String
    // Exception table:
    //   from	to	target	type
    //   27	36	85	finally
    //   90	92	85	finally
    //   19	23	94	java/lang/Exception
    //   25	27	94	java/lang/Exception
    //   92	94	94	java/lang/Exception
    //   36	38	102	finally
  }
  
  public boolean isValid(String paramString)
  {
    return (this.mLastAppId == AppSetting.a()) && (this.mSoInfos != null) && (this.mSoInfos.size() > 0) && (this.mSoInfos.get(paramString) != null);
  }
  
  public void saveConfig()
  {
    ThreadManager.getFileThreadHandler().post(new SoConfig.2(this));
  }
  
  public String toString()
  {
    return "SoConfig{mSoInfos=" + this.mSoInfos + '}';
  }
  
  public void update(azng paramazng)
  {
    HashMap localHashMap = new HashMap();
    if ((paramazng != null) && (paramazng.a != null))
    {
      try
      {
        localObject = new LinkedList(Arrays.asList(paramazng.a));
        Collections.sort((List)localObject, new aznb(this));
        paramazng = (azng)localObject;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          SoConfig.SoInfo localSoInfo1;
          try
          {
            Object localObject;
            JSONArray localJSONArray = new JSONObject(((aoko)localObject).jdField_a_of_type_JavaLangString).optJSONArray("so_info_list");
            if (localJSONArray == null) {
              continue;
            }
            int i = 0;
            if (i >= localJSONArray.length()) {
              continue;
            }
            localSoInfo1 = SoConfig.SoInfo.create(localJSONArray.optJSONObject(i));
            if (localSoInfo1 != null)
            {
              if (!localHashMap.containsKey(localSoInfo1.name)) {
                break label295;
              }
              localSoInfo2 = (SoConfig.SoInfo)localHashMap.get(localSoInfo1.name);
              if (localSoInfo2 == null) {
                localHashMap.put(localSoInfo1.name, localSoInfo1);
              }
            }
            else
            {
              i += 1;
              continue;
              localThrowable1 = localThrowable1;
              paramazng = new LinkedList(Arrays.asList(paramazng.a));
              continue;
            }
            SoConfig.SoInfo localSoInfo2 = localSoInfo2.merge(localSoInfo1);
            localHashMap.put(localSoInfo1.name, localSoInfo2);
            continue;
          }
          catch (Throwable localThrowable2)
          {
            QLog.e("SoLoadWidget.SoConfig", 1, localThrowable2, new Object[0]);
            VACDReportUtil.a(null, "SoLoadModule", "SoLoadSingle", "Exception", localThrowable1.jdField_a_of_type_Int + "", 1, localThrowable2.getMessage());
          }
          localHashMap.put(localSoInfo1.name, localSoInfo1);
        }
      }
      paramazng = paramazng.iterator();
      do
      {
        if (!paramazng.hasNext()) {
          break;
        }
        localObject = (aoko)paramazng.next();
      } while (TextUtils.isEmpty(((aoko)localObject).jdField_a_of_type_JavaLangString));
    }
    label295:
    this.mSoInfos = localHashMap;
    this.mLastAppId = AppSetting.a();
    saveConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.soload.config.SoConfig
 * JD-Core Version:    0.7.0.1
 */