import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.1;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.2;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.3;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.5;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.6;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class sjy
{
  private stSimpleGetFeedListRsp a(int paramInt)
  {
    Object localObject = "";
    if (paramInt == 1) {
      localObject = a();
    }
    while (TextUtils.isEmpty((CharSequence)localObject))
    {
      return null;
      if (paramInt == 2) {
        localObject = b();
      }
    }
    localObject = bbdj.a((String)localObject);
    return (stSimpleGetFeedListRsp)a(new stSimpleGetFeedListRsp(), (byte[])localObject);
  }
  
  private String a()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_recommend_data";
  }
  
  public static sjy a()
  {
    return sjz.a();
  }
  
  private boolean a(List<stSimpleMetaFeed> paramList, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList.size() > 0)
    {
      Object localObject = new stSimpleGetFeedListRsp();
      ((stSimpleGetFeedListRsp)localObject).feeds = new ArrayList(paramList);
      localObject = a((JceStruct)localObject);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (localObject.length > 0)
        {
          bool1 = bbdj.a((byte[])localObject, paramString, false);
          sne.d("WeiShiCacheManager", "cacheRecommendData writeSuccess = " + bool1 + ", cache list size = " + paramList.size() + ", bytes length = " + localObject.length);
        }
      }
    }
    return bool1;
  }
  
  private int b()
  {
    return skb.a().f();
  }
  
  private String b()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_reddot_data";
  }
  
  public int a()
  {
    return LocalMultiProcConfig.getInt("weishi_usergrowth", "key_red_msg_valid_count", 0);
  }
  
  public <T extends JceStruct> T a(T paramT, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf8");
      paramT.readFrom(paramArrayOfByte);
      return paramT;
    }
    catch (Exception paramT)
    {
      paramT.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.6(this));
  }
  
  public void a(List<stSimpleMetaFeed> paramList, int paramInt)
  {
    if (b() == 0) {
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.2(this));
    }
    while ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.3(this, new ArrayList(paramList), paramInt));
  }
  
  public void a(List<stSimpleMetaFeed> paramList, long paramLong)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.5(this, new ArrayList(paramList), paramLong, paramList));
      return;
    }
    a();
  }
  
  public void a(sju paramsju)
  {
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.1(this, paramsju));
  }
  
  public boolean a()
  {
    long l1 = LocalMultiProcConfig.getLong("weishi_usergrowth", "key_red_msg_valid_timestamp", 0L);
    long l2 = System.currentTimeMillis();
    long l3 = l1 - l2;
    sne.d("WeiShiCacheManager", "validTimestamp-currentTimestamp = " + l1 + "-" + l2 + " = " + l3);
    return l3 > 0L;
  }
  
  public byte[] a(JceStruct paramJceStruct)
  {
    if (paramJceStruct != null) {
      try
      {
        JceOutputStream localJceOutputStream = new JceOutputStream();
        localJceOutputStream.setServerEncoding("utf8");
        paramJceStruct.writeTo(localJceOutputStream);
        paramJceStruct = localJceOutputStream.toByteArray();
        return paramJceStruct;
      }
      catch (Exception paramJceStruct)
      {
        paramJceStruct.printStackTrace();
      }
    }
    return null;
  }
  
  public boolean b()
  {
    String str1 = sni.c();
    String str2 = LocalMultiProcConfig.getString("weishi_usergrowth", "key_ws_cache_v", "");
    sne.b("CacheResponseLog", "getCachedTrendsWSData versionName = " + str1 + ", cachedVersionName = " + str2);
    return (!TextUtils.isEmpty(str1)) && (TextUtils.equals(str1, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjy
 * JD-Core Version:    0.7.0.1
 */