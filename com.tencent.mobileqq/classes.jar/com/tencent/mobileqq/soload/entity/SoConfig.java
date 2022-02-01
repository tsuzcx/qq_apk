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
  
  private List<QConfItem> a(SoLoadConfBean paramSoLoadConfBean)
  {
    try
    {
      LinkedList localLinkedList = new LinkedList(Arrays.asList(paramSoLoadConfBean.confFiles));
      Collections.sort(localLinkedList, new SoConfig.1(this));
      return localLinkedList;
    }
    catch (Throwable localThrowable)
    {
      label29:
      break label29;
    }
    return new LinkedList(Arrays.asList(paramSoLoadConfBean.confFiles));
  }
  
  private void a(Map<String, SoInfo> paramMap, QConfItem paramQConfItem)
  {
    if (!TextUtils.isEmpty(paramQConfItem.b)) {
      try
      {
        Object localObject = new JSONObject(paramQConfItem.b).optJSONArray("so_info_list");
        if (localObject != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            SoInfo localSoInfo1 = SoInfo.create(((JSONArray)localObject).optJSONObject(i));
            if (localSoInfo1 != null) {
              if (paramMap.containsKey(localSoInfo1.name))
              {
                SoInfo localSoInfo2 = (SoInfo)paramMap.get(localSoInfo1.name);
                if (localSoInfo2 == null)
                {
                  paramMap.put(localSoInfo1.name, localSoInfo1);
                }
                else
                {
                  localSoInfo2 = localSoInfo2.merge(localSoInfo1);
                  paramMap.put(localSoInfo1.name, localSoInfo2);
                }
              }
              else
              {
                paramMap.put(localSoInfo1.name, localSoInfo1);
              }
            }
            i += 1;
          }
        }
        return;
      }
      catch (Throwable paramMap)
      {
        QLog.e("SoLoadWidget.SoConfig", 1, paramMap, new Object[0]);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramQConfItem.a);
        ((StringBuilder)localObject).append("");
        SoReportUtil.a(((StringBuilder)localObject).toString(), paramMap.getMessage());
      }
    }
  }
  
  private Map<String, SoInfo> b(SoLoadConfBean paramSoLoadConfBean)
  {
    HashMap localHashMap = new HashMap();
    paramSoLoadConfBean = a(paramSoLoadConfBean).iterator();
    while (paramSoLoadConfBean.hasNext()) {
      a(localHashMap, (QConfItem)paramSoLoadConfBean.next());
    }
    return localHashMap;
  }
  
  private Map<String, SoInfo> c(SoLoadConfBean paramSoLoadConfBean)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = localHashMap;
    if (paramSoLoadConfBean != null)
    {
      localObject = localHashMap;
      if (paramSoLoadConfBean.confFiles != null) {
        localObject = b(paramSoLoadConfBean);
      }
    }
    return localObject;
  }
  
  /* Error */
  public static SoConfig readConfig()
  {
    // Byte code:
    //   0: invokestatic 182	com/tencent/mobileqq/soload/entity/SoConfig:a	()Ljava/lang/String;
    //   3: astore 5
    //   5: aload 5
    //   7: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   35: invokestatic 216	com/tencent/mobileqq/soload/util/SoDataUtil:c	(Ljava/lang/String;)Ljava/lang/Object;
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
    //   64: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   67: aload_1
    //   68: astore_2
    //   69: aload_1
    //   70: ifnonnull +11 -> 81
    //   73: new 2	com/tencent/mobileqq/soload/entity/SoConfig
    //   76: dup
    //   77: invokespecial 220	com/tencent/mobileqq/soload/entity/SoConfig:<init>	()V
    //   80: astore_2
    //   81: invokestatic 223	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +34 -> 118
    //   87: new 29	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   94: astore_1
    //   95: aload_1
    //   96: ldc 225
    //   98: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_1
    //   103: aload_2
    //   104: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: ldc 154
    //   110: iconst_2
    //   111: aload_1
    //   112: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    if (this.mLastAppId == AppSetting.d())
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
    this.mSoInfos = c(paramSoLoadConfBean);
    this.mLastAppId = AppSetting.d();
    saveConfig(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.entity.SoConfig
 * JD-Core Version:    0.7.0.1
 */