import UserGrowth.stFeed;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.1;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.2;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.3;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.4;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.5;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.6;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.8;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.9;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class tcq
{
  private stSimpleGetFeedListRsp a(int paramInt)
  {
    return (stSimpleGetFeedListRsp)a(new stSimpleGetFeedListRsp(), paramInt);
  }
  
  private <T extends JceStruct> T a(T paramT, int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = a();
    }
    while (TextUtils.isEmpty(str))
    {
      return null;
      if (paramInt == 2) {
        str = b();
      } else if (paramInt == 3) {
        str = c();
      }
    }
    return a(paramT, bdcs.a(str));
  }
  
  private String a()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_recommend_data";
  }
  
  public static tcq a()
  {
    return tcr.a();
  }
  
  private boolean a(JceStruct paramJceStruct, String paramString, int paramInt)
  {
    if (paramInt <= 0) {}
    byte[] arrayOfByte;
    do
    {
      return false;
      arrayOfByte = a(paramJceStruct);
    } while ((arrayOfByte == null) || (arrayOfByte.length <= 0));
    boolean bool = bdcs.a(arrayOfByte, paramString, false);
    paramString = new StringBuilder().append("write cache to ").append(paramString);
    if (bool) {}
    for (paramJceStruct = " succeed";; paramJceStruct = " failed")
    {
      tlo.d("WeiShiCacheManager", paramJceStruct + ", cache list size = " + paramInt + ", bytes length = " + arrayOfByte.length);
      return bool;
    }
  }
  
  private int b()
  {
    return tee.a().f();
  }
  
  private String b()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_reddot_data";
  }
  
  private int c()
  {
    return tel.a().a;
  }
  
  private String c()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_follow_data";
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
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.9(this));
  }
  
  public void a(List<stFeed> paramList)
  {
    if (c() == 0) {
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.3(this));
    }
    while (tlf.a(paramList)) {
      return;
    }
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.4(this, paramList));
  }
  
  public void a(List<stSimpleMetaFeed> paramList, int paramInt)
  {
    if (b() == 0) {
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.5(this));
    }
    while ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.6(this, new ArrayList(paramList), paramInt));
  }
  
  public void a(List<stSimpleMetaFeed> paramList, long paramLong)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(paramList);
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
      localstSimpleGetFeedListRsp.feeds = localArrayList;
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.8(this, localstSimpleGetFeedListRsp, localArrayList, paramLong, paramList));
      return;
    }
    a();
  }
  
  public void a(tcm paramtcm)
  {
    ThreadManager.post(new WeiShiCacheManager.1(this, paramtcm), 8, null, true);
  }
  
  public boolean a()
  {
    long l1 = LocalMultiProcConfig.getLong("weishi_usergrowth", "key_red_msg_valid_timestamp", 0L);
    long l2 = System.currentTimeMillis();
    long l3 = l1 - l2;
    tlo.d("WeiShiCacheManager", "validTimestamp-currentTimestamp = " + l1 + "-" + l2 + " = " + l3);
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
  
  public void b(tcm paramtcm)
  {
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.2(this, new WeakReference(paramtcm)));
  }
  
  public boolean b()
  {
    String str1 = tlv.c();
    String str2 = LocalMultiProcConfig.getString("weishi_usergrowth", "key_ws_cache_v", "");
    tlo.b("CacheResponseLog", "getCachedTrendsWSData versionName = " + str1 + ", cachedVersionName = " + str2);
    return (!TextUtils.isEmpty(str1)) && (TextUtils.equals(str1, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tcq
 * JD-Core Version:    0.7.0.1
 */