package com.tencent.mobileqq.soload.entity;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadConfBean;
import com.tencent.mobileqq.soload.temp.api.ISoloadOtherService;
import com.tencent.mobileqq.soload.util.SoReportUtil;
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
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class SoConfig
  implements Serializable
{
  private static final byte[] a = new byte[0];
  public int mLastAppId;
  public Map<String, SoInfo> mSoInfos = new HashMap();
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(MobileQQ.sMobileQQ.getFilesDir().getPath());
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
    //   4: invokestatic 65	com/tencent/mobileqq/soload/entity/SoConfig:a	()Ljava/lang/String;
    //   7: astore 4
    //   9: aload 4
    //   11: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +92 -> 106
    //   17: aload_2
    //   18: astore_0
    //   19: getstatic 17	com/tencent/mobileqq/soload/entity/SoConfig:a	[B
    //   22: astore_3
    //   23: aload_2
    //   24: astore_0
    //   25: aload_3
    //   26: monitorenter
    //   27: aload 4
    //   29: invokestatic 80	com/tencent/mobileqq/soload/util/SoDataUtil:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   32: checkcast 2	com/tencent/mobileqq/soload/entity/SoConfig
    //   35: astore_0
    //   36: aload_3
    //   37: monitorexit
    //   38: aload_0
    //   39: astore_1
    //   40: aload_0
    //   41: ifnonnull +11 -> 52
    //   44: new 2	com/tencent/mobileqq/soload/entity/SoConfig
    //   47: dup
    //   48: invokespecial 81	com/tencent/mobileqq/soload/entity/SoConfig:<init>	()V
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
  
  public void saveConfig(boolean paramBoolean)
  {
    SoConfig.2 local2 = new SoConfig.2(this);
    if (paramBoolean)
    {
      local2.run();
      return;
    }
    ThreadManager.getFileThreadHandler().post(local2);
  }
  
  public String toString()
  {
    return "SoConfig{mSoInfos=" + this.mSoInfos + '}';
  }
  
  public void update(SoLoadConfBean paramSoLoadConfBean)
  {
    HashMap localHashMap = new HashMap();
    if ((paramSoLoadConfBean != null) && (paramSoLoadConfBean.a != null))
    {
      try
      {
        localObject1 = new LinkedList(Arrays.asList(paramSoLoadConfBean.a));
        Collections.sort((List)localObject1, new SoConfig.1(this));
        paramSoLoadConfBean = (SoLoadConfBean)localObject1;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          Object localObject2;
          try
          {
            Object localObject1;
            JSONArray localJSONArray = new JSONObject(((QConfItem)localObject1).jdField_a_of_type_JavaLangString).optJSONArray("so_info_list");
            if (localJSONArray == null) {
              continue;
            }
            int i = 0;
            if (i >= localJSONArray.length()) {
              continue;
            }
            localObject2 = SoInfo.create(localJSONArray.optJSONObject(i));
            if (localObject2 != null)
            {
              if (!localHashMap.containsKey(((SoInfo)localObject2).name)) {
                break label298;
              }
              localSoInfo = (SoInfo)localHashMap.get(((SoInfo)localObject2).name);
              if (localSoInfo == null) {
                localHashMap.put(((SoInfo)localObject2).name, localObject2);
              }
            }
            else
            {
              i += 1;
              continue;
              localThrowable1 = localThrowable1;
              paramSoLoadConfBean = new LinkedList(Arrays.asList(paramSoLoadConfBean.a));
              continue;
            }
            SoInfo localSoInfo = localSoInfo.merge((SoInfo)localObject2);
            localHashMap.put(((SoInfo)localObject2).name, localSoInfo);
            continue;
          }
          catch (Throwable localThrowable2)
          {
            QLog.e("SoLoadWidget.SoConfig", 1, localThrowable2, new Object[0]);
            localObject2 = (ISoloadOtherService)QRoute.api(ISoloadOtherService.class);
            SoReportUtil.a(localThrowable1.jdField_a_of_type_Int + "", localThrowable2.getMessage());
          }
          localHashMap.put(((SoInfo)localObject2).name, localObject2);
        }
      }
      paramSoLoadConfBean = paramSoLoadConfBean.iterator();
      do
      {
        if (!paramSoLoadConfBean.hasNext()) {
          break;
        }
        localObject1 = (QConfItem)paramSoLoadConfBean.next();
      } while (TextUtils.isEmpty(((QConfItem)localObject1).jdField_a_of_type_JavaLangString));
    }
    label298:
    this.mSoInfos = localHashMap;
    this.mLastAppId = AppSetting.a();
    saveConfig(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.entity.SoConfig
 * JD-Core Version:    0.7.0.1
 */