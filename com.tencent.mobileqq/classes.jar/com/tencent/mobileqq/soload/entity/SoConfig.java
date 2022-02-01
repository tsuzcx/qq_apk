package com.tencent.mobileqq.soload.entity;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadConfBean;
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
    localStringBuilder.append("/QWallet/");
    localStringBuilder.append("/.config/");
    localStringBuilder.append("sl.config");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static SoConfig readConfig()
  {
    // Byte code:
    //   0: invokestatic 65	com/tencent/mobileqq/soload/entity/SoConfig:a	()Ljava/lang/String;
    //   3: astore 5
    //   5: aload 5
    //   7: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: istore_0
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore_1
    //   15: aconst_null
    //   16: astore_2
    //   17: iload_0
    //   18: ifne +49 -> 67
    //   21: aload_3
    //   22: astore_1
    //   23: getstatic 17	com/tencent/mobileqq/soload/entity/SoConfig:a	[B
    //   26: astore 4
    //   28: aload_3
    //   29: astore_1
    //   30: aload 4
    //   32: monitorenter
    //   33: aload 5
    //   35: invokestatic 80	com/tencent/mobileqq/soload/util/SoDataUtil:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   38: checkcast 2	com/tencent/mobileqq/soload/entity/SoConfig
    //   41: astore_1
    //   42: aload 4
    //   44: monitorexit
    //   45: goto +22 -> 67
    //   48: astore_3
    //   49: goto +6 -> 55
    //   52: astore_3
    //   53: aload_2
    //   54: astore_1
    //   55: aload_1
    //   56: astore_2
    //   57: aload 4
    //   59: monitorexit
    //   60: aload_3
    //   61: athrow
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 83	java/lang/Exception:printStackTrace	()V
    //   67: aload_1
    //   68: astore_2
    //   69: aload_1
    //   70: ifnonnull +11 -> 81
    //   73: new 2	com/tencent/mobileqq/soload/entity/SoConfig
    //   76: dup
    //   77: invokespecial 84	com/tencent/mobileqq/soload/entity/SoConfig:<init>	()V
    //   80: astore_2
    //   81: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +34 -> 118
    //   87: new 29	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   94: astore_1
    //   95: aload_1
    //   96: ldc 93
    //   98: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_1
    //   103: aload_2
    //   104: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: ldc 98
    //   110: iconst_2
    //   111: aload_1
    //   112: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_2
    //   119: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	8	0	bool	boolean
    //   14	98	1	localObject1	Object
    //   16	41	2	localObject2	Object
    //   62	2	2	localException	java.lang.Exception
    //   68	51	2	localObject3	Object
    //   12	17	3	localObject4	Object
    //   48	1	3	localObject5	Object
    //   52	9	3	localObject6	Object
    //   26	32	4	arrayOfByte	byte[]
    //   3	31	5	str	String
    // Exception table:
    //   from	to	target	type
    //   42	45	48	finally
    //   33	42	52	finally
    //   57	60	52	finally
    //   23	28	62	java/lang/Exception
    //   30	33	62	java/lang/Exception
    //   60	62	62	java/lang/Exception
  }
  
  public boolean isValid(String paramString)
  {
    if (this.mLastAppId == AppSetting.a())
    {
      Map localMap = this.mSoInfos;
      if ((localMap != null) && (localMap.size() > 0) && (this.mSoInfos.get(paramString) != null)) {
        return true;
      }
    }
    return false;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SoConfig{mSoInfos=");
    localStringBuilder.append(this.mSoInfos);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void update(SoLoadConfBean paramSoLoadConfBean)
  {
    HashMap localHashMap = new HashMap();
    if ((paramSoLoadConfBean != null) && (paramSoLoadConfBean.confFiles != null)) {}
    try
    {
      localObject1 = new LinkedList(Arrays.asList(paramSoLoadConfBean.confFiles));
      Collections.sort((List)localObject1, new SoConfig.1(this));
      paramSoLoadConfBean = (SoLoadConfBean)localObject1;
    }
    catch (Throwable localThrowable1)
    {
      Object localObject1;
      label52:
      break label52;
    }
    paramSoLoadConfBean = new LinkedList(Arrays.asList(paramSoLoadConfBean.confFiles));
    paramSoLoadConfBean = paramSoLoadConfBean.iterator();
    for (;;)
    {
      if (paramSoLoadConfBean.hasNext())
      {
        localObject1 = (QConfItem)paramSoLoadConfBean.next();
        if (TextUtils.isEmpty(((QConfItem)localObject1).jdField_a_of_type_JavaLangString)) {
          continue;
        }
        try
        {
          JSONArray localJSONArray = new JSONObject(((QConfItem)localObject1).jdField_a_of_type_JavaLangString).optJSONArray("so_info_list");
          if (localJSONArray != null)
          {
            int i = 0;
            while (i < localJSONArray.length())
            {
              localObject2 = SoInfo.create(localJSONArray.optJSONObject(i));
              if (localObject2 != null) {
                if (localHashMap.containsKey(((SoInfo)localObject2).name))
                {
                  SoInfo localSoInfo = (SoInfo)localHashMap.get(((SoInfo)localObject2).name);
                  if (localSoInfo == null)
                  {
                    localHashMap.put(((SoInfo)localObject2).name, localObject2);
                  }
                  else
                  {
                    localSoInfo = localSoInfo.merge((SoInfo)localObject2);
                    localHashMap.put(((SoInfo)localObject2).name, localSoInfo);
                  }
                }
                else
                {
                  localHashMap.put(((SoInfo)localObject2).name, localObject2);
                }
              }
              i += 1;
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("SoLoadWidget.SoConfig", 1, localThrowable2, new Object[0]);
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((QConfItem)localObject1).jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append("");
          SoReportUtil.a(((StringBuilder)localObject2).toString(), localThrowable2.getMessage());
        }
      }
    }
    this.mSoInfos = localHashMap;
    this.mLastAppId = AppSetting.a();
    saveConfig(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.entity.SoConfig
 * JD-Core Version:    0.7.0.1
 */