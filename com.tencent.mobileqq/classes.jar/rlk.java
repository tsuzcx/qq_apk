import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.5;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.util.HashMap;

public class rlk
  implements rjr
{
  private static final String jdField_a_of_type_JavaLangString = rlk.class.getSimpleName();
  private Context jdField_a_of_type_AndroidContentContext;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private rjp jdField_a_of_type_Rjp;
  private rln jdField_a_of_type_Rln;
  
  public rlk()
  {
    c();
  }
  
  private void a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (paramInt1 == 2) {
      osf.a().a(paramString1, "PubAccountArticleCenter.GetUrlByVid", new rll(this, paramString1, paramInt2, paramLong));
    }
    do
    {
      do
      {
        return;
        if (!a(paramString2, paramString1, paramInt2))
        {
          a(paramString2, paramString1, paramLong, paramInt2);
          return;
        }
      } while (this.jdField_a_of_type_Rln == null);
      paramString2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    } while (TextUtils.isEmpty(paramString2));
    this.jdField_a_of_type_Rln.a(paramString1, 1, paramString2);
  }
  
  private void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() start preload ERROR cacheMgr == null!");
      }
      return;
    }
    Object localObject = paramString2;
    if (paramString1 != null) {
      if (paramString2 != null)
      {
        localObject = paramString2;
        if (!paramString1.equals(paramString2)) {}
      }
      else
      {
        localObject = noy.a(paramString1);
      }
    }
    paramString2 = new TVK_UserInfo("", "");
    localObject = new TVK_PlayerVideoInfo(2, (String)localObject, "");
    ((TVK_PlayerVideoInfo)localObject).setConfigMap("cache_duration", String.valueOf(paramInt));
    ((TVK_PlayerVideoInfo)localObject).setConfigMap("cache_servers_type", rjm.jdField_a_of_type_JavaLangString);
    if (paramLong > 0L) {
      ((TVK_PlayerVideoInfo)localObject).setConfigMap("duration", String.valueOf(paramLong));
    }
    ((TVK_PlayerVideoInfo)localObject).addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    String str = rjm.a();
    if (TextUtils.isEmpty(paramString1))
    {
      localTVK_ICacheMgr.preLoadVideoById(this.jdField_a_of_type_AndroidContentContext, paramString2, (TVK_PlayerVideoInfo)localObject, str);
      return;
    }
    localTVK_ICacheMgr.preLoadVideoByUrl(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, (TVK_PlayerVideoInfo)localObject);
  }
  
  private boolean a(String paramString1, String paramString2, int paramInt)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null) {
      return false;
    }
    String str1 = paramString2;
    if (paramString1 != null) {
      if (paramString2 != null)
      {
        str1 = paramString2;
        if (!paramString1.equals(paramString2)) {}
      }
      else
      {
        str1 = noy.a(paramString1);
      }
    }
    paramString2 = new TVK_UserInfo("", "");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, str1, "");
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", String.valueOf(paramInt));
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", rjm.jdField_a_of_type_JavaLangString);
    localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "msd";
    arrayOfString[1] = "hd";
    arrayOfString[2] = "fhd";
    arrayOfString[3] = "mp4";
    arrayOfString[4] = "shd";
    arrayOfString[5] = "sd";
    paramInt = 0;
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str2 = arrayOfString[i];
      try
      {
        int j = localTVK_ICacheMgr.isVideoCached(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, localTVK_PlayerVideoInfo, str2);
        paramInt = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, str1 + " checkIsVideoCached() cacheMgr.isVideoCached Exception = " + localException.getMessage());
          }
        }
        i += 1;
      }
      if ((paramInt == 2) || (paramInt == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, str1 + " checkIsVideoCached(), definition = " + str2 + ", cacheStatus = " + paramInt + ", return TRUE");
        }
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, str1 + " checkIsVideoCached() return FALSE");
    }
    return false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_Rjp = new rjp(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Rjp.a(this);
    if (!this.jdField_a_of_type_Rjp.a())
    {
      this.jdField_a_of_type_Rjp.a();
      return;
    }
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.getCacheMgr(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(new rlm(this));
  }
  
  public void a()
  {
    ThreadManager.post(new VideoWebPreDownload.2(this), 5, null, true);
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString3);
    ThreadManager.post(new VideoWebPreDownload.1(this, paramString1, paramInt1, paramLong, paramInt2, paramString2), 5, null, true);
  }
  
  public void a(rln paramrln)
  {
    this.jdField_a_of_type_Rln = paramrln;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rln = null;
    ThreadManager.post(new VideoWebPreDownload.5(this), 5, null, true);
  }
  
  public void c(boolean paramBoolean)
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rlk
 * JD-Core Version:    0.7.0.1
 */