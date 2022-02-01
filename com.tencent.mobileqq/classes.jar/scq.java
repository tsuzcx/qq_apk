import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ac.ArticleCenter.GetUrlByVidRequest;
import com.tencent.mobileqq.ac.ArticleCenter.GetUrlByVidResponse;
import com.tencent.mobileqq.ac.ArticleCenter.GetVidByUrlRequest;
import com.tencent.mobileqq.ac.ArticleCenter.RetInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class scq
{
  private static MQLruCache<String, scv> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(300);
  private static volatile scq jdField_a_of_type_Scq;
  public Long a;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private scq()
  {
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  }
  
  public static String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public static scq a()
  {
    if (jdField_a_of_type_Scq == null) {}
    try
    {
      if (jdField_a_of_type_Scq == null) {
        jdField_a_of_type_Scq = new scq();
      }
      return jdField_a_of_type_Scq;
    }
    finally {}
  }
  
  public static scv a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    scv localscv;
    do
    {
      return paramString;
      localscv = (scv)jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      if ((localscv == null) || (TextUtils.isEmpty(localscv.jdField_a_of_type_JavaLangString))) {
        break;
      }
      paramString = localscv;
    } while (localscv.a(NetConnInfoCenter.getServerTime()));
    return null;
  }
  
  private void a(String paramString1, String paramString2, sct paramsct, long paramLong, boolean paramBoolean, Bundle paramBundle)
  {
    paramLong = System.currentTimeMillis() - paramLong;
    int i = 0;
    String str = "";
    scv localscv = new scv(paramString1);
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if ((paramBundle == null) || (paramBundle.length < 0)) {}
    }
    for (;;)
    {
      try
      {
        Object localObject = new ArticleCenter.GetUrlByVidResponse();
        ((ArticleCenter.GetUrlByVidResponse)localObject).mergeFrom(paramBundle);
        i = ((ArticleCenter.GetUrlByVidResponse)localObject).ret_info.ret_code.get();
        str = ((ArticleCenter.GetUrlByVidResponse)localObject).ret_info.err_info.get();
        if (i == 0)
        {
          bool1 = scv.a((ArticleCenter.GetUrlByVidResponse)localObject, localscv);
          localObject = ozs.a(((ArticleCenter.GetUrlByVidResponse)localObject).json_video_detail);
          if (localscv.jdField_a_of_type_Boolean)
          {
            HashMap localHashMap = new HashMap();
            if (bool1)
            {
              paramBundle = "1";
              localHashMap.put("param_isH265SwitchError", paramBundle);
              localHashMap.put("param_jsonVideoDetail", localObject);
              ozs.a(BaseApplication.getContext(), ozs.a(), localHashMap);
            }
          }
          else
          {
            ocd.a(null, null, "0X8009756", "0X8009756", 0, 0, rne.a(), "8.4.5", localscv.jdField_d_of_type_JavaLangString, (String)localObject, false);
            paramBundle = new JSONObject();
            paramBundle.put("vid", localscv.jdField_b_of_type_JavaLangString);
            paramBundle.put("isH265", localscv.jdField_a_of_type_Boolean);
            paramBundle.put("url", localscv.jdField_a_of_type_JavaLangString);
            paramBundle.put("hwBackupUrl", localscv.e);
            ocd.a(null, null, "0X8009822", "0X8009822", 0, 0, "", "", "", paramBundle.toString(), false);
            bool1 = paramBoolean;
            paramBundle = str;
            if (TextUtils.isEmpty(localscv.jdField_a_of_type_JavaLangString)) {
              break label576;
            }
            bool2 = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, "handleGetUrlByVidResponse(), vid:" + paramString1 + " cmd:" + paramString2 + " ssoTime : " + paramLong + ", isSuccess:" + paramBoolean + ", isValid:" + bool2 + ", videoUrlInfo=" + localscv);
            }
            if (!bool2) {
              break label582;
            }
            if (localscv.jdField_a_of_type_Int == 0) {
              a(localscv);
            }
            paramsct.a(localscv);
            this.jdField_a_of_type_JavaUtilArrayList.remove(paramString1);
            paramBoolean = false;
            paramString2 = new qzk();
            paramString2.jdField_a_of_type_Boolean = bool2;
            paramString2.jdField_a_of_type_JavaLangString = paramString1;
            this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
            paramString2.jdField_a_of_type_Long = paramLong;
            paramString2.jdField_b_of_type_Long = i;
            paramString2.jdField_b_of_type_JavaLangString = paramBundle;
            paramString2.jdField_b_of_type_Boolean = paramBoolean;
            ozs.c(BaseApplicationImpl.getContext(), ozs.a(), bool1, paramString2.a());
            return;
          }
          paramBundle = "0";
          continue;
        }
        localscv.jdField_d_of_type_Int = i;
        bool1 = false;
        continue;
        paramBundle = "";
      }
      catch (Exception paramBundle)
      {
        i = -2;
        if (paramBundle != null) {}
      }
      for (;;)
      {
        bool1 = false;
        break;
        paramBundle = paramBundle.getMessage();
      }
      boolean bool1 = false;
      paramBundle = str;
      continue;
      i = paramBundle.getInt("respones_code", -3);
      bool1 = paramBoolean;
      paramBundle = str;
      continue;
      label576:
      boolean bool2 = false;
      continue;
      label582:
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString1)) {}
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramString1);
        label602:
        paramsct.a(localscv);
        QLog.e("Q.readinjoy.video.ThirdVideoManager", 1, "handleGetUrlByVidResponse() 重试依然失败！ vidInfo : " + localscv);
        paramBoolean = false;
        continue;
        if (QLog.isColorLevel()) {
          QLog.w("Q.readinjoy.video.ThirdVideoManager", 2, "handleGetUrlByVidResponse() 获取失败, 进行重试 sendUUIDToUrlTryAgain vidInfo : " + localscv);
        }
        a(paramString1, paramString2, paramsct);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString1);
        paramBoolean = true;
      }
      catch (Exception paramString2)
      {
        break label602;
      }
    }
  }
  
  public static void a(scv paramscv)
  {
    if ((TextUtils.isEmpty(paramscv.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(paramscv.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, "cache putCache vid : " + paramscv.jdField_b_of_type_JavaLangString + " url:" + paramscv.jdField_a_of_type_JavaLangString);
    }
    paramscv.jdField_b_of_type_Long = NetConnInfoCenter.getServerTime();
    jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramscv.jdField_b_of_type_JavaLangString, paramscv);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((ozs.a() == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.ThirdVideoManager", 2, "sendUUIDToUrlRequest checkArgs failed,   vid : " + paramString1 + " cmd:" + paramString2);
      }
      return false;
    }
    return true;
  }
  
  public static String[] a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      String[] arrayOfString;
      int j;
      String str1;
      try
      {
        Object localObject = new URL(paramString);
        String str2 = ((URL)localObject).getHost();
        String str3 = ((URL)localObject).getProtocol();
        localObject = ((URL)localObject).getFile();
        if ((!TextUtils.isEmpty(str2)) && (rpt.f()) && (!rpt.a(str2)))
        {
          ArrayList localArrayList = InnerDns.getInstance().reqDnsForIpList(str2, 1006);
          if (localArrayList == null) {
            break label297;
          }
          i = localArrayList.size();
          if (i > 0)
          {
            arrayOfString = new String[i + 1];
            j = 0;
            if (j < i)
            {
              if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).indexOf('/') == 0)) {
                break label281;
              }
              localObject = "/" + (String)localObject;
              str1 = str3 + "://" + (String)localArrayList.get(j) + (String)localObject;
              if (!str1.contains("&"))
              {
                str1 = str1 + "?txhost=" + str2;
                break label284;
              }
              str1 = str1 + "&txhost=" + str2;
              break label284;
            }
            arrayOfString[i] = paramString;
            return arrayOfString;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.video.ThirdVideoManager", 2, "replaceDomain2Ip Exception:", localException);
        }
      }
      return new String[] { paramString };
      label281:
      continue;
      label284:
      arrayOfString[j] = str1;
      j += 1;
      continue;
      label297:
      int i = 0;
    }
  }
  
  public void a(String paramString1, String paramString2, sct paramsct)
  {
    if (paramsct == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.ThirdVideoManager", 2, "sendUUIDToUrlRequestL callback == null! ");
      }
      return;
    }
    if (!a(paramString1, paramString2))
    {
      paramsct.a(new scv(paramString1));
      paramString2 = new qzk();
      paramString2.jdField_a_of_type_Boolean = false;
      paramString2.jdField_a_of_type_JavaLangString = paramString1;
      paramString2.jdField_a_of_type_Long = 0L;
      paramString2.jdField_b_of_type_Long = -4L;
      paramString2.jdField_b_of_type_JavaLangString = "vid or cmd is null";
      paramString2.jdField_b_of_type_Boolean = false;
      ozs.c(BaseApplicationImpl.getContext(), ozs.a(), true, paramString2.a());
      return;
    }
    Object localObject1 = a(paramString1);
    if (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, "cache hit,  getUrlByVid vid : " + paramString1 + " url:" + ((scv)localObject1).jdField_a_of_type_JavaLangString + ", " + ((scv)localObject1).toString());
      }
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
      paramsct.a((scv)localObject1);
      return;
    }
    long l = System.currentTimeMillis();
    localObject1 = new NewIntent(ozs.a().getApplication(), ocj.class);
    ((NewIntent)localObject1).putExtra("cmd", paramString2);
    ArticleCenter.GetUrlByVidRequest localGetUrlByVidRequest = new ArticleCenter.GetUrlByVidRequest();
    Object localObject2 = ByteStringMicro.copyFromUtf8(paramString1);
    localGetUrlByVidRequest.vid.set((ByteStringMicro)localObject2);
    localGetUrlByVidRequest.mv.set(ByteStringMicro.copyFromUtf8("8.4.5,3,4745"));
    int i = bjjh.a(null);
    localGetUrlByVidRequest.net_type.set(i);
    localGetUrlByVidRequest.video_type.set(0);
    localObject2 = rne.a();
    localGetUrlByVidRequest.mobile_detail_info.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, "sendUUIDToUrlRequest netType : " + i + ", vid : " + paramString1 + ", reqDeviceInfo : " + (String)localObject2);
    }
    ((NewIntent)localObject1).putExtra("data", localGetUrlByVidRequest.toByteArray());
    ((NewIntent)localObject1).setObserver(new scr(this, (NewIntent)localObject1, paramString1, paramString2, paramsct, l));
    ozs.a().startServlet((NewIntent)localObject1);
  }
  
  public void a(String paramString, sct paramsct)
  {
    a(paramString, "PubAccountArticleCenter.GetUrlByVid", paramsct);
  }
  
  public void a(String paramString, scu paramscu)
  {
    AppRuntime localAppRuntime = ozs.a();
    if ((localAppRuntime == null) || (localAppRuntime.getApplication() == null))
    {
      if (paramscu != null) {
        paramscu.a(paramString, "");
      }
      return;
    }
    long l = System.currentTimeMillis();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), ocj.class);
    localNewIntent.putExtra("cmd", "PubAccountArticleCenter.GetVidByUrl");
    ArticleCenter.GetVidByUrlRequest localGetVidByUrlRequest = new ArticleCenter.GetVidByUrlRequest();
    ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(paramString);
    localGetVidByUrlRequest.url.set(localByteStringMicro);
    localGetVidByUrlRequest.mv.set(ByteStringMicro.copyFromUtf8("8.4.5,3,4745"));
    localNewIntent.putExtra("data", localGetVidByUrlRequest.toByteArray());
    localNewIntent.setObserver(new scs(this, l, localNewIntent, paramscu, paramString));
    localAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scq
 * JD-Core Version:    0.7.0.1
 */