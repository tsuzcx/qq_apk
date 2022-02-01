package com.tencent.timi.game.env;

import com.tencent.timi.game.utils.Logger;

public class ServerEnvInfo
{
  public ServerEnvInfo.NetworkEnvInfo a;
  public ServerEnvInfo.ImageEnvInfo b;
  public ServerEnvInfo.TimEnvInfo c;
  public ServerEnvInfo.WuJiConfigInfo d;
  
  public ServerEnvInfo(ServerEnvInfo.NetworkEnvInfo paramNetworkEnvInfo, ServerEnvInfo.ImageEnvInfo paramImageEnvInfo, ServerEnvInfo.TimEnvInfo paramTimEnvInfo, ServerEnvInfo.WuJiConfigInfo paramWuJiConfigInfo)
  {
    this.a = paramNetworkEnvInfo;
    this.b = paramImageEnvInfo;
    this.c = paramTimEnvInfo;
    this.d = paramWuJiConfigInfo;
  }
  
  public static ServerEnvInfo a(int paramInt)
  {
    if (paramInt != 1) {
      localObject1 = "server/yes_online.xml";
    } else {
      localObject1 = "server/yes_test.xml";
    }
    Object localObject2 = new ServerEnvInfo.NetworkEnvInfo((String)localObject1);
    if (paramInt != 1) {
      localObject1 = "https://picupload.yes.qq.com/online";
    } else {
      localObject1 = "https://test-pic-upload.yes.qq.com/test";
    }
    Object localObject1 = new ServerEnvInfo.ImageEnvInfo((String)localObject1, "");
    ServerEnvInfo.WuJiConfigInfo localWuJiConfigInfo = new ServerEnvInfo.WuJiConfigInfo(b(paramInt));
    int i;
    if (paramInt != 1) {
      i = 1400527057;
    } else {
      i = 1400525290;
    }
    localObject1 = new ServerEnvInfo((ServerEnvInfo.NetworkEnvInfo)localObject2, (ServerEnvInfo.ImageEnvInfo)localObject1, new ServerEnvInfo.TimEnvInfo(i), localWuJiConfigInfo);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("createServerEnvInfo - ");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(" - ");
    ((StringBuilder)localObject2).append(localObject1);
    Logger.a("ServerEnvInfo", ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  private static String b(int paramInt)
  {
    if (paramInt != 1) {
      return "https://onlinecgi.yes.qq.com/onlinen/getinitconfig";
    }
    return "https://testcgi.yes.qq.com/testn/getinitconfig";
  }
  
  public int a()
  {
    return this.c.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.env.ServerEnvInfo
 * JD-Core Version:    0.7.0.1
 */