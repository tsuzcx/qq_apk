import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;

public class owx
{
  public static void a(String paramString)
  {
    Object localObject = TVK_SDKMgr.getProxyFactory();
    if (localObject != null)
    {
      localObject = ((TVK_IProxyFactory)localObject).getCacheMgr(BaseApplicationImpl.getContext());
      if (localObject != null)
      {
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, nmc.a(paramString), "");
        localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "2");
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", qtx.a);
        ((TVK_ICacheMgr)localObject).preLoadVideoByUrl(BaseApplicationImpl.getContext(), paramString, null, localTVK_PlayerVideoInfo);
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    Object localObject1 = TVK_SDKMgr.getProxyFactory();
    if (localObject1 == null) {
      return false;
    }
    localObject1 = ((TVK_IProxyFactory)localObject1).getCacheMgr(BaseApplicationImpl.getContext());
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = nmc.a(paramString);
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo("", "");
    localObject2 = new TVK_PlayerVideoInfo(2, (String)localObject2, "");
    ((TVK_PlayerVideoInfo)localObject2).setConfigMap("cache_duration", "2");
    ((TVK_PlayerVideoInfo)localObject2).setConfigMap("cache_servers_type", qtx.a);
    ((TVK_PlayerVideoInfo)localObject2).addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "msd";
    arrayOfString[1] = "hd";
    arrayOfString[2] = "fhd";
    arrayOfString[3] = "mp4";
    arrayOfString[4] = "shd";
    arrayOfString[5] = "sd";
    int m = arrayOfString.length;
    int j = 0;
    int i = 0;
    while (j < m)
    {
      String str = arrayOfString[j];
      try
      {
        int k = ((TVK_ICacheMgr)localObject1).isVideoCached(BaseApplicationImpl.getContext(), paramString, localTVK_UserInfo, (TVK_PlayerVideoInfo)localObject2, str);
        i = k;
      }
      catch (Exception localException)
      {
        label176:
        break label176;
        j += 1;
      }
      if ((i == 2) || (i == 1)) {
        return true;
      }
    }
    if (QLog.isColorLevel()) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owx
 * JD-Core Version:    0.7.0.1
 */