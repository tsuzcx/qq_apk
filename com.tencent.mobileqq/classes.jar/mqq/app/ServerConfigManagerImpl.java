package mqq.app;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import java.util.ArrayList;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.GetResourceReqV2;
import protocol.KQQConfig.ReqUserInfo;

class ServerConfigManagerImpl
  implements ServerConfigManager
{
  private AppRuntime app;
  
  public ServerConfigManagerImpl(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void getPluginConfig(int paramInt1, ReqUserInfo paramReqUserInfo, ArrayList<GetResourceReqInfoV2> paramArrayList, ServerConfigObserver paramServerConfigObserver, int paramInt2)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.setRequestId(0);
    localUniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
    localUniPacket.setFuncName("ClientReq");
    localUniPacket.put("iCmdType", Integer.valueOf(64));
    localUniPacket.put("ReqUserInfo", paramReqUserInfo);
    paramReqUserInfo = new GetResourceReqV2();
    paramReqUserInfo.iPluginType = paramInt1;
    paramReqUserInfo.vecResReqInfo = paramArrayList;
    paramReqUserInfo.iAppid = paramInt2;
    paramReqUserInfo.cReqVer = 1;
    localUniPacket.put("GetResourceReqV2", paramReqUserInfo);
    paramReqUserInfo = localUniPacket.encode();
    paramArrayList = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    paramArrayList.putExtra("action", 1018);
    paramArrayList.putExtra("buffer", paramReqUserInfo);
    paramArrayList.putExtra("iPluginType", paramInt1);
    paramArrayList.setObserver(paramServerConfigObserver);
    this.app.startServlet(paramArrayList);
  }
  
  public void getRichMediaServerList(int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1011);
    localNewIntent.putExtra("timestamp", paramInt);
    this.app.startServlet(localNewIntent);
  }
  
  public String getServerConfig(String paramString, ServerConfigManager.ConfigType paramConfigType)
  {
    switch (ServerConfigManagerImpl.1.$SwitchMap$mqq$manager$ServerConfigManager$ConfigType[paramConfigType.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return this.app.getRuntimeService().msfSub.syncGetServerAppConfig();
    case 2: 
      return this.app.getRuntimeService().msfSub.syncGetServerCommonConfig();
    }
    return this.app.getRuntimeService().msfSub.syncGetServerUserConfig(paramString);
  }
  
  public void onDestroy() {}
  
  public void report(byte paramByte, String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1012);
    localNewIntent.putExtra("type", paramByte);
    localNewIntent.putExtra("tag", paramString1);
    localNewIntent.putExtra("content", paramString2);
    localNewIntent.withouLogin = true;
    this.app.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.ServerConfigManagerImpl
 * JD-Core Version:    0.7.0.1
 */