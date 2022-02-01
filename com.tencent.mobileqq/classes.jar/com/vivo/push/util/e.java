package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.b.x;
import java.util.HashMap;

public final class e
{
  public static boolean a(long paramLong, HashMap<String, String> paramHashMap)
  {
    x localx = new x(paramLong);
    localx.a(paramHashMap);
    localx.d();
    com.vivo.push.e.a().a(localx);
    return true;
  }
  
  public static boolean a(Context paramContext, long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder("report message: ");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(", reportType: ");
    ((StringBuilder)localObject).append(paramLong2);
    o.d("ClientReportUtil", ((StringBuilder)localObject).toString());
    localObject = new x(paramLong2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("messageID", String.valueOf(paramLong1));
    paramContext = z.b(paramContext, paramContext.getPackageName());
    if (!TextUtils.isEmpty(paramContext)) {
      localHashMap.put("remoteAppId", paramContext);
    }
    ((x)localObject).a(localHashMap);
    com.vivo.push.e.a().a((com.vivo.push.o)localObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.e
 * JD-Core Version:    0.7.0.1
 */