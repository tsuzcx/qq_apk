import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class sww
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "2909288299" };
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  private final String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<String, String> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  public sww(BaseApplicationImpl paramBaseApplicationImpl, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.jdField_a_of_type_Int = ors.c();
    this.jdField_a_of_type_JavaLangString = ("PubAccountHttpDownloader." + this.jdField_a_of_type_Int);
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int k;
    int j;
    if (paramString != null)
    {
      arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      k = arrayOfString.length;
      j = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (j < k)
      {
        if (paramString.equals(arrayOfString[j])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      j += 1;
    }
  }
  
  public URLDrawableHandler a(URLDrawableHandler paramURLDrawableHandler)
  {
    return new swx(paramURLDrawableHandler, this);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = 0;
    this.d = null;
  }
  
  public void a(int paramInt, DownloadParams paramDownloadParams)
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey("puin"))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilMap.get("puin");
      paramDownloadParams = (String)this.jdField_a_of_type_JavaUtilMap.get("msgid");
    }
    for (;;)
    {
      if (a((String)localObject1)) {}
      Object localObject2;
      do
      {
        return;
        if ((paramDownloadParams.mExtraInfo == null) || (!(paramDownloadParams.mExtraInfo instanceof MessageRecord))) {
          break label898;
        }
        paramDownloadParams = (MessageRecord)paramDownloadParams.mExtraInfo;
        localObject1 = paramDownloadParams.frienduin;
        if (((paramDownloadParams instanceof MessageForStructing)) && (((MessageForStructing)paramDownloadParams).structingMsg != null))
        {
          paramDownloadParams = "" + ((MessageForStructing)paramDownloadParams).structingMsg.msgId;
          break;
        }
        if ((!(paramDownloadParams instanceof MessageForPubAccount)) || (((MessageForPubAccount)paramDownloadParams).mPAMessage == null)) {
          break label893;
        }
        paramDownloadParams = "" + ((MessageForPubAccount)paramDownloadParams).mPAMessage.mMsgId;
        break;
        localObject2 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
        if ((localObject2 == null) || (!(localObject2 instanceof QQAppInterface))) {
          break label334;
        }
        localObject2 = (QQAppInterface)localObject2;
        if (localObject1 == null) {
          break label310;
        }
        switch (syb.a((QQAppInterface)localObject2, (String)localObject1))
        {
        }
      } while (this.jdField_b_of_type_Int == 0);
      int j = 0;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_acc_type", "" + j);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_puin", localObject1);
      label310:
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
      if (localObject1 != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uin", localObject1);
      }
      label334:
      if (paramDownloadParams != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_msgid", paramDownloadParams);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("AttemptCount", "" + paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.put("picFormat", this.e);
      this.jdField_a_of_type_JavaUtilHashMap.put("netType", this.h);
      this.jdField_a_of_type_JavaUtilHashMap.put("plateform", this.g);
      this.jdField_a_of_type_JavaUtilHashMap.put("pixDensity", this.i);
      paramDownloadParams = bazo.a().a(this.jdField_c_of_type_JavaLangString, 1009);
      if (paramDownloadParams != null)
      {
        paramDownloadParams = TextUtils.join(",", paramDownloadParams);
        label459:
        this.jdField_a_of_type_JavaUtilHashMap.put("IPs", paramDownloadParams);
        this.jdField_a_of_type_JavaUtilHashMap.put("ServerIP", "");
        this.jdField_a_of_type_JavaUtilHashMap.put("OriginURL", this.jdField_b_of_type_JavaLangString);
        localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
        if (!this.jdField_a_of_type_Boolean) {
          break label850;
        }
        paramDownloadParams = String.valueOf(1);
        label514:
        ((HashMap)localObject1).put("Success", paramDownloadParams);
        this.jdField_a_of_type_JavaUtilHashMap.put("TotalTime", Long.toString(this.jdField_b_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("picType", this.f);
        this.jdField_a_of_type_JavaUtilHashMap.put("ReceivedBytes", String.valueOf(this.jdField_c_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("ErrorReason", this.d);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", this.jdField_c_of_type_Int + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("Speed", Float.toString((float)this.jdField_c_of_type_Long / ((float)this.jdField_b_of_type_Long / 1000.0F)));
        paramDownloadParams = "actSubscriptionUnkonw";
        switch (this.jdField_b_of_type_Int)
        {
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("reportTag:").append(paramDownloadParams).append(", success:").append(this.jdField_a_of_type_Boolean).append(", time:").append(this.jdField_b_of_type_Long).append(", size:").append(this.jdField_c_of_type_Long).append(", url:").append(this.jdField_b_of_type_JavaLangString).append(", exInfo:").append(this.jdField_a_of_type_JavaUtilHashMap.toString());
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject1).toString());
        }
        azri.a(BaseApplication.getContext()).a(null, paramDownloadParams, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "", true);
        return;
        j = 1;
        break;
        j = 2;
        break;
        j = 3;
        break;
        j = 4;
        break;
        paramDownloadParams = "";
        break label459;
        label850:
        paramDownloadParams = String.valueOf(0);
        break label514;
        paramDownloadParams = "actSubscriptionAIO";
        continue;
        paramDownloadParams = "actSubscriptionDetail";
        continue;
        paramDownloadParams = "actSubscriptionFolder";
        continue;
        paramDownloadParams = "actKandianImage";
        continue;
        paramDownloadParams = "actNativeWebImage";
      }
      label893:
      paramDownloadParams = null;
      continue;
      label898:
      paramDownloadParams = null;
      localObject1 = null;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_c_of_type_Int = paramInt;
    }
    this.d = paramString;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void a(DownloadParams paramDownloadParams, Map<String, String> paramMap)
  {
    long l = bavg.a().a();
    this.h = "None";
    if ((l > 0L) && (l < alof.c.length)) {
      this.h = alof.c[((int)l)];
    }
    this.g = ("ANDROID.MOBILE-" + Build.MODEL + ".SDK-" + Build.VERSION.SDK);
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDisplayMetrics();
    this.i = (localDisplayMetrics.widthPixels + "*" + localDisplayMetrics.heightPixels);
    this.jdField_b_of_type_JavaLangString = paramDownloadParams.urlStr;
    this.jdField_c_of_type_JavaLangString = paramDownloadParams.url.getHost();
    this.e = "none";
    int j = this.jdField_b_of_type_JavaLangString.lastIndexOf("/");
    if ((j != -1) && (j + 1 <= this.jdField_b_of_type_JavaLangString.length()) && (j + 1 < this.jdField_b_of_type_JavaLangString.length()))
    {
      this.e = this.jdField_b_of_type_JavaLangString.substring(j + 1);
      j = this.e.indexOf("?");
      if (j != -1) {
        this.e = this.e.substring(0, j);
      }
    }
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public void a(HttpResponse paramHttpResponse, String paramString)
  {
    if (paramHttpResponse != null)
    {
      paramString = paramHttpResponse.getFirstHeader("Content-Type");
      this.f = "none";
      if ((paramString != null) && (paramString.getValue().startsWith("image/"))) {
        this.f = paramString.getValue().replace("image/", "");
      }
      paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Length");
      if (paramHttpResponse != null) {}
      try
      {
        this.jdField_c_of_type_Long = Long.valueOf(paramHttpResponse.getValue()).longValue();
        return;
      }
      catch (NumberFormatException paramHttpResponse)
      {
        paramHttpResponse.printStackTrace();
        return;
      }
    }
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "download task finish, ret : " + paramBoolean + ", errCode : " + paramInt);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_b_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "start download pic , url : " + this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sww
 * JD-Core Version:    0.7.0.1
 */