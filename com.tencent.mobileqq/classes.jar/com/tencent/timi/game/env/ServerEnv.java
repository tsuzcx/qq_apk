package com.tencent.timi.game.env;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.util.HashMap;

public class ServerEnv
{
  private static int a = -1;
  private static HashMap<Integer, ServerEnvInfo> b = new HashMap();
  
  public static int a()
  {
    if (a <= 0) {
      if (!TextUtils.isEmpty(com.tencent.mobileqq.util.SSODebugUtil.a()[0])) {
        a = 1;
      } else if (MsfSdkUtils.isBuildTestEnvValid()) {
        a = 1;
      } else {
        a = 2;
      }
    }
    return a;
  }
  
  public static boolean b()
  {
    return a() == 2;
  }
  
  public static String c()
  {
    if (a() != 1) {
      return "Online";
    }
    return "Test";
  }
  
  public static ServerEnvInfo d()
  {
    int i = a();
    if (b.containsKey(Integer.valueOf(i))) {
      return (ServerEnvInfo)b.get(Integer.valueOf(i));
    }
    ServerEnvInfo localServerEnvInfo = ServerEnvInfo.a(i);
    b.put(Integer.valueOf(i), localServerEnvInfo);
    return localServerEnvInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.env.ServerEnv
 * JD-Core Version:    0.7.0.1
 */