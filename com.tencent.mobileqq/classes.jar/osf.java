import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.ac.ArticleCenter.GetUrlByVidRequest;
import com.tencent.mobileqq.ac.ArticleCenter.GetUrlByVidResponse;
import com.tencent.mobileqq.ac.ArticleCenter.GetVidByUrlRequest;
import com.tencent.mobileqq.ac.ArticleCenter.VideoInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class osf
{
  private static MQLruCache<String, osl> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(120);
  private static volatile osf jdField_a_of_type_Osf;
  public Long a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private osf()
  {
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  }
  
  private String a(ArticleCenter.GetUrlByVidResponse paramGetUrlByVidResponse)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    if (paramGetUrlByVidResponse.encode_type.get() == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramGetUrlByVidResponse = null;
      return paramGetUrlByVidResponse;
    }
    Object localObject1 = localObject3;
    label423:
    label448:
    label479:
    for (;;)
    {
      try
      {
        if (paramGetUrlByVidResponse.rate.get() == null) {
          break label482;
        }
        localObject1 = localObject3;
        if (Long.valueOf(paramGetUrlByVidResponse.rate.get().toStringUtf8()).longValue() == 0L) {
          break label482;
        }
        localObject1 = localObject3;
        long l3 = Long.valueOf(paramGetUrlByVidResponse.rate.get().toStringUtf8()).longValue();
        long l1 = 9223372036854775807L;
        localObject1 = localObject3;
        if (!paramGetUrlByVidResponse.video_info.has()) {
          break label448;
        }
        localObject1 = localObject3;
        if (paramGetUrlByVidResponse.video_info.get().size() <= 0) {
          break label448;
        }
        localObject1 = localObject3;
        Iterator localIterator = paramGetUrlByVidResponse.video_info.get().iterator();
        paramGetUrlByVidResponse = (ArticleCenter.GetUrlByVidResponse)localObject2;
        localObject1 = paramGetUrlByVidResponse;
        if (!localIterator.hasNext()) {
          break label423;
        }
        localObject1 = paramGetUrlByVidResponse;
        localObject2 = (ArticleCenter.VideoInfo)localIterator.next();
        if (localObject2 == null) {
          continue;
        }
        try
        {
          if ((((ArticleCenter.VideoInfo)localObject2).encode_type.get() != 0) || (((ArticleCenter.VideoInfo)localObject2).rate.get() == null) || (Long.valueOf(((ArticleCenter.VideoInfo)localObject2).rate.get().toStringUtf8()).longValue() == 0L) || (((ArticleCenter.VideoInfo)localObject2).url.get() == null) || (TextUtils.isEmpty(((ArticleCenter.VideoInfo)localObject2).url.get().toStringUtf8()))) {
            break label479;
          }
          l2 = Math.abs(l3 - Long.valueOf(((ArticleCenter.VideoInfo)localObject2).rate.get().toStringUtf8()).longValue());
          if (l2 >= l1) {
            break label479;
          }
        }
        catch (Exception localException2)
        {
          try
          {
            localObject1 = ((ArticleCenter.VideoInfo)localObject2).url.get().toStringUtf8();
            paramGetUrlByVidResponse = (ArticleCenter.GetUrlByVidResponse)localObject1;
            l1 = l2;
            localObject2 = paramGetUrlByVidResponse;
            paramGetUrlByVidResponse = (ArticleCenter.GetUrlByVidResponse)localObject2;
          }
          catch (Exception localException3)
          {
            long l2;
            continue;
          }
          localException2 = localException2;
          l2 = l1;
        }
        l1 = l2;
        localObject2 = paramGetUrlByVidResponse;
        localObject1 = paramGetUrlByVidResponse;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = paramGetUrlByVidResponse;
        QLog.d("Q.readinjoy.video.TAG", 2, "innerChooseHWBackupUrlForHevc error :" + localException2.getMessage());
        l1 = l2;
        localObject2 = paramGetUrlByVidResponse;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception localException1)
      {
        paramGetUrlByVidResponse = (ArticleCenter.GetUrlByVidResponse)localObject1;
      }
      QLog.d("Q.readinjoy.video.TAG", 2, "innerChooseHWBackupUrlForHevc error :" + localException1.getMessage());
      return localObject1;
      localObject1 = paramGetUrlByVidResponse;
      nrt.a(null, null, "0X8009824", "0X8009824", 0, 0, "", "", "", "", false);
      return paramGetUrlByVidResponse;
      localObject1 = localException2;
      nrt.a(null, null, "0X8009825", "0X8009825", 0, 0, "", "", "", "", false);
      return null;
    }
    label482:
    return null;
  }
  
  public static String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public static osf a()
  {
    if (jdField_a_of_type_Osf == null) {}
    try
    {
      if (jdField_a_of_type_Osf == null) {
        jdField_a_of_type_Osf = new osf();
      }
      return jdField_a_of_type_Osf;
    }
    finally {}
  }
  
  public static osl a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    osl localosl;
    do
    {
      return paramString;
      localosl = (osl)jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      if (localosl == null) {
        break;
      }
      paramString = localosl;
    } while (localosl.a(NetConnInfoCenter.getServerTime()));
    return null;
  }
  
  public static void a(osl paramosl)
  {
    if ((TextUtils.isEmpty(paramosl.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(paramosl.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.TAG", 2, "cache setCache vid : " + paramosl.jdField_b_of_type_JavaLangString + " url:" + paramosl.jdField_a_of_type_JavaLangString);
    }
    paramosl.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
    jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramosl.jdField_b_of_type_JavaLangString, paramosl);
  }
  
  public static String[] a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      String[] arrayOfString;
      int i;
      String str1;
      try
      {
        Object localObject = new URL(paramString);
        String str2 = ((URL)localObject).getHost();
        String str3 = ((URL)localObject).getProtocol();
        localObject = ((URL)localObject).getFile();
        if (!TextUtils.isEmpty(str2))
        {
          ArrayList localArrayList = bazo.a().a(str2, 1006);
          int j = localArrayList.size();
          if (j > 0)
          {
            arrayOfString = new String[j + 1];
            i = 0;
            if (i < j)
            {
              if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).indexOf('/') == 0)) {
                break label282;
              }
              localObject = "/" + (String)localObject;
              str1 = str3 + "://" + (String)localArrayList.get(i) + (String)localObject;
              if (!str1.contains("&"))
              {
                str1 = str1 + "?txhost=" + str2;
                break label285;
              }
              str1 = str1 + "&txhost=" + str2;
              break label285;
            }
            arrayOfString[j] = paramString;
            return arrayOfString;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if ((QLog.isColorLevel()) && (localMalformedURLException != null)) {
          QLog.d("Q.readinjoy.video.TAG", 2, "replaceDomain2Ip MalformedURLException:" + localMalformedURLException.getMessage());
        }
      }
      return new String[] { paramString };
      label282:
      continue;
      label285:
      arrayOfString[i] = str1;
      i += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, osi paramosi)
  {
    AppRuntime localAppRuntime = ors.a();
    if ((localAppRuntime == null) || (localAppRuntime.getApplication() == null) || (TextUtils.isEmpty(paramString2))) {
      if (paramosi != null)
      {
        paramString2 = new osl();
        paramString2.jdField_b_of_type_JavaLangString = paramString1;
        paramosi.a(paramString2);
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        if (paramosi != null) {
          paramosi.a(new osl());
        }
        paramString2 = new qnv();
        paramString2.jdField_a_of_type_Boolean = false;
        paramString2.jdField_a_of_type_JavaLangString = paramString1;
        paramString2.jdField_a_of_type_Long = 0L;
        paramString2.jdField_b_of_type_Long = -4L;
        paramString2.jdField_b_of_type_JavaLangString = "vid is null";
        paramString2.jdField_b_of_type_Boolean = false;
        ors.c(localAppRuntime.getApplication(), ors.a(), true, paramString2.a());
        return;
      }
      localObject1 = a(paramString1);
      if ((localObject1 == null) || (TextUtils.isEmpty(((osl)localObject1).jdField_a_of_type_JavaLangString))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.TAG", 2, "cache hit,  getUrlByVid vid : " + paramString1 + " url:" + ((osl)localObject1).jdField_a_of_type_JavaLangString + ((osl)localObject1).toString());
      }
    } while (paramosi == null);
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    paramosi.a((osl)localObject1);
    return;
    long l = System.currentTimeMillis();
    Object localObject1 = new NewIntent(localAppRuntime.getApplication(), nrz.class);
    ((NewIntent)localObject1).putExtra("cmd", paramString2);
    ArticleCenter.GetUrlByVidRequest localGetUrlByVidRequest = new ArticleCenter.GetUrlByVidRequest();
    Object localObject2 = ByteStringMicro.copyFromUtf8(paramString1);
    localGetUrlByVidRequest.vid.set((ByteStringMicro)localObject2);
    localGetUrlByVidRequest.mv.set(ByteStringMicro.copyFromUtf8("8.3.5,3,4555"));
    int i = bfbh.a(null);
    localGetUrlByVidRequest.net_type.set(i);
    localGetUrlByVidRequest.video_type.set(0);
    localObject2 = rae.a(false);
    localGetUrlByVidRequest.mobile_detail_info.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.TAG", 2, "sendUUIDToUrlRequest netType : " + i + ", vid : " + paramString1 + ", reqDeviceInfo : " + (String)localObject2);
    }
    ((NewIntent)localObject1).putExtra("data", localGetUrlByVidRequest.toByteArray());
    ((NewIntent)localObject1).setObserver(new osg(this, (NewIntent)localObject1, l, paramString1, paramosi, paramString2, localAppRuntime));
    localAppRuntime.startServlet((NewIntent)localObject1);
  }
  
  public void a(String paramString, osj paramosj)
  {
    AppRuntime localAppRuntime = ors.a();
    if ((localAppRuntime == null) || (localAppRuntime.getApplication() == null))
    {
      if (paramosj != null) {
        paramosj.a(paramString, "");
      }
      return;
    }
    long l = System.currentTimeMillis();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), nrz.class);
    localNewIntent.putExtra("cmd", "PubAccountArticleCenter.GetVidByUrl");
    ArticleCenter.GetVidByUrlRequest localGetVidByUrlRequest = new ArticleCenter.GetVidByUrlRequest();
    ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(paramString);
    localGetVidByUrlRequest.url.set(localByteStringMicro);
    localGetVidByUrlRequest.mv.set(ByteStringMicro.copyFromUtf8("8.3.5,3,4555"));
    localNewIntent.putExtra("data", localGetVidByUrlRequest.toByteArray());
    localNewIntent.setObserver(new osh(this, l, localNewIntent, paramosj, paramString));
    localAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     osf
 * JD-Core Version:    0.7.0.1
 */