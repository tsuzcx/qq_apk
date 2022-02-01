package com.tencent.mobileqq.triton.bridge;

import android.text.TextUtils;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.LogConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  private static int i = 11;
  private static int j = 1048576;
  private static int k = 1024;
  private static Pattern l = Pattern.compile("(?<=state\":\")\\w+");
  private static Pattern m = Pattern.compile("\"(errMsg|state)\":\".*(fail|error|exception).*\"");
  private int a = 0;
  private int b = 0;
  private HashMap<Integer, String> c = new HashMap();
  private HashMap<Integer, Long> d = new HashMap();
  private List<String> e = Collections.synchronizedList(new ArrayList());
  private Map<String, Set<String>> f;
  private Map<String, Set<String>> g;
  private boolean h;
  
  private String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() < 256)) {
      return paramString;
    }
    return paramString.substring(0, 256);
  }
  
  private String b(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = l.matcher(paramString);
      localObject1 = localObject2;
      if (paramString.find()) {
        localObject1 = paramString.group();
      }
    }
    return localObject1;
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (this.h) {
      return true;
    }
    Map localMap = this.f;
    if ((localMap != null) && (localMap.containsKey(paramString1)))
    {
      paramString2 = b(paramString2);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = (Set)this.f.get(paramString1);
        if (paramString1 != null) {
          return paramString1.contains(paramString2);
        }
      }
      return true;
    }
    localMap = this.g;
    if ((localMap != null) && (localMap.containsKey(paramString1)))
    {
      paramString2 = b(paramString2);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = (Set)this.g.get(paramString1);
        if (paramString1 != null) {
          return paramString1.contains(paramString2) ^ true;
        }
      }
      return false;
    }
    return true;
  }
  
  private void c(String paramString1, String paramString2)
  {
    if (c(paramString1)) {
      this.e.add(paramString2);
    }
  }
  
  private boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return m.matcher(paramString).find();
  }
  
  public int a(int paramInt)
  {
    if (paramInt < j)
    {
      int n = i;
      int i1 = this.b;
      this.b = (i1 + 1);
      if (this.b > k) {
        this.b = 0;
      }
      return (paramInt << n) + i1;
    }
    TTLog.b("<API>", "callbackId is toooo large, start vs end might not match");
    return paramInt;
  }
  
  public int a(int paramInt, String paramString)
  {
    String str;
    StringBuffer localStringBuffer;
    if (this.c.containsKey(Integer.valueOf(paramInt)))
    {
      str = (String)this.c.remove(Integer.valueOf(paramInt));
      localObject = (Long)this.d.remove(Integer.valueOf(paramInt));
      localStringBuffer = new StringBuffer("end ");
      if ((localObject == null) || (((Long)localObject).longValue() <= 0L)) {
        break label153;
      }
    }
    label153:
    for (Object localObject = "cost:" + (System.currentTimeMillis() - ((Long)localObject).longValue()) + "ms ";; localObject = "")
    {
      localObject = (String)localObject + str + " R=[" + a(paramString) + "]";
      TTLog.c("<API>", (String)localObject);
      c(paramString, (String)localObject);
      return paramInt >> i;
    }
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 1) {
      localStringBuilder.append("api(");
    }
    for (;;)
    {
      paramInt = this.a;
      this.a = (paramInt + 1);
      localStringBuilder.append(paramInt).append(") : eventName=[").append(paramString1).append("] Params=[").append(a(paramString2)).append("]");
      return localStringBuilder.toString();
      if (paramInt == 2) {
        localStringBuilder.append("OPENCONTEXT api(");
      } else if (paramInt == 3) {
        localStringBuilder.append("WORKER api(");
      } else {
        localStringBuilder.append("UNKNOWN api(");
      }
    }
  }
  
  public void a()
  {
    Object localObject = new ArrayList(this.e);
    this.e.clear();
    TTLog.b("<API>", "==================== printFailLog start, total:" + ((ArrayList)localObject).size() + " ====================");
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      TTLog.b("<API>", (String)((Iterator)localObject).next());
    }
    TTLog.b("<API>", "==================== printFailLog end ====================");
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    if (!b(paramString1, null)) {
      return;
    }
    paramString2 = a(paramInt1, paramString1, paramString2);
    StringBuilder localStringBuilder = new StringBuilder("start ").append(paramString2);
    if ("{}".equals(paramString3)) {}
    for (paramString1 = " ###NEED CALLBACK###";; paramString1 = " R=[" + a(paramString3) + "]")
    {
      paramString1 = paramString1;
      TTLog.c("<API>", paramString1);
      this.c.put(Integer.valueOf(paramInt2), paramString2);
      this.d.put(Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()));
      c(paramString3, paramString1);
      return;
    }
  }
  
  public void a(LogConfig paramLogConfig)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramLogConfig != null)
    {
      localObject1 = paramLogConfig.whiteList;
      this.f = ((Map)localObject1);
      localObject1 = localObject2;
      if (paramLogConfig != null) {
        localObject1 = paramLogConfig.blackList;
      }
      this.g = ((Map)localObject1);
      paramLogConfig = this.f;
      if ((paramLogConfig == null) || (!paramLogConfig.containsKey("__jsBridge_all_log__"))) {
        break label68;
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      this.h = bool;
      return;
      localObject1 = null;
      break;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!b(paramString1, paramString2)) {
      return;
    }
    paramString1 = a("eventName:" + paramString1 + ", Params:" + paramString2);
    if (!TextUtils.isEmpty(paramString1)) {
      TTLog.c("<API>", "end subscribeJS():" + paramString1);
    }
    c(paramString2, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.a
 * JD-Core Version:    0.7.0.1
 */