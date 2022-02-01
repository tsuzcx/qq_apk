import android.text.TextUtils;
import com.tencent.mobileqq.ac.ArticleCenter.GetUrlByVidResponse;
import com.tencent.mobileqq.ac.ArticleCenter.RetInfo;
import com.tencent.mobileqq.ac.ArticleCenter.VideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class sjt
{
  public int a;
  public long a;
  public String a;
  public ArrayList<sjt> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e = "";
  
  public sjt()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public sjt(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private static String a(ArticleCenter.GetUrlByVidResponse paramGetUrlByVidResponse)
  {
    if (paramGetUrlByVidResponse.encode_type.get() == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramGetUrlByVidResponse = null;
      return paramGetUrlByVidResponse;
    }
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    label388:
    label419:
    for (;;)
    {
      try
      {
        if (paramGetUrlByVidResponse.rate.get() == null) {
          break label422;
        }
        localObject1 = localObject3;
        if (Long.valueOf(paramGetUrlByVidResponse.rate.get().toStringUtf8()).longValue() == 0L) {
          break label422;
        }
        localObject1 = localObject3;
        long l3 = Long.valueOf(paramGetUrlByVidResponse.rate.get().toStringUtf8()).longValue();
        long l1 = 9223372036854775807L;
        localObject1 = localObject3;
        if (!paramGetUrlByVidResponse.video_info.has()) {
          break label388;
        }
        localObject1 = localObject3;
        if (paramGetUrlByVidResponse.video_info.get().size() <= 0) {
          break label388;
        }
        localObject1 = localObject3;
        Iterator localIterator = paramGetUrlByVidResponse.video_info.get().iterator();
        paramGetUrlByVidResponse = (ArticleCenter.GetUrlByVidResponse)localObject2;
        localObject1 = paramGetUrlByVidResponse;
        if (!localIterator.hasNext()) {
          break label363;
        }
        localObject1 = paramGetUrlByVidResponse;
        localObject2 = (ArticleCenter.VideoInfo)localIterator.next();
        if (localObject2 == null) {
          continue;
        }
        try
        {
          if ((((ArticleCenter.VideoInfo)localObject2).encode_type.get() != 0) || (Long.valueOf(((ArticleCenter.VideoInfo)localObject2).rate.get().toStringUtf8()).longValue() == 0L) || (TextUtils.isEmpty(((ArticleCenter.VideoInfo)localObject2).url.get().toStringUtf8()))) {
            break label419;
          }
          l2 = Math.abs(l3 - Long.valueOf(((ArticleCenter.VideoInfo)localObject2).rate.get().toStringUtf8()).longValue());
          if (l2 >= l1) {
            break label419;
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
        QLog.e("Q.readinjoy.video.VideoUrlInfo", 2, "innerChooseHWBackupUrlForHevc error 1:", localException2);
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
      QLog.e("Q.readinjoy.video.VideoUrlInfo", 2, "innerChooseHWBackupUrlForHevc error 2:", localException1);
      return localObject1;
      label363:
      localObject1 = paramGetUrlByVidResponse;
      odq.a(null, null, "0X8009824", "0X8009824", 0, 0, "", "", "", "", false);
      return paramGetUrlByVidResponse;
      localObject1 = localException2;
      odq.a(null, null, "0X8009825", "0X8009825", 0, 0, "", "", "", "", false);
      return null;
    }
    label422:
    return null;
  }
  
  public static sjt a(String paramString, ArticleCenter.VideoInfo paramVideoInfo)
  {
    sjt localsjt = new sjt();
    boolean bool;
    if (paramVideoInfo != null)
    {
      localsjt.jdField_b_of_type_JavaLangString = paramString;
      if (paramVideoInfo.url.get() == null) {
        break label111;
      }
      paramString = paramVideoInfo.url.get().toStringUtf8();
      localsjt.jdField_a_of_type_JavaLangString = paramString;
      if (paramVideoInfo.encode_type.get() != 1) {
        break label117;
      }
      bool = true;
      label56:
      localsjt.jdField_a_of_type_Boolean = bool;
      if (paramVideoInfo.rate.get() == null) {
        break label122;
      }
    }
    label111:
    label117:
    label122:
    for (paramString = paramVideoInfo.rate.get().toStringUtf8();; paramString = "")
    {
      localsjt.jdField_c_of_type_JavaLangString = paramString;
      localsjt.jdField_b_of_type_Int = paramVideoInfo.width.get();
      localsjt.jdField_c_of_type_Int = paramVideoInfo.height.get();
      return localsjt;
      paramString = "";
      break;
      bool = false;
      break label56;
    }
  }
  
  static boolean a(ArticleCenter.GetUrlByVidResponse paramGetUrlByVidResponse, sjt paramsjt)
  {
    boolean bool2 = false;
    paramsjt.jdField_a_of_type_JavaLangString = pay.a(paramGetUrlByVidResponse.url);
    paramsjt.jdField_d_of_type_Int = paramGetUrlByVidResponse.ret_info.ret_code.get();
    paramsjt.jdField_a_of_type_Int = paramGetUrlByVidResponse.video_type.get();
    if (paramGetUrlByVidResponse.encode_type.get() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramsjt.jdField_a_of_type_Boolean = bool1;
      paramsjt.jdField_b_of_type_Int = paramGetUrlByVidResponse.width.get();
      paramsjt.jdField_c_of_type_Int = paramGetUrlByVidResponse.height.get();
      paramsjt.jdField_c_of_type_JavaLangString = pay.a(paramGetUrlByVidResponse.rate);
      paramsjt.jdField_a_of_type_Long = paramGetUrlByVidResponse.file_size.get();
      if (paramsjt.jdField_a_of_type_Boolean) {
        paramsjt.e = a(paramGetUrlByVidResponse);
      }
      Object localObject = pay.a(paramGetUrlByVidResponse.json_video_detail);
      bool1 = bool2;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        if (paramsjt.jdField_a_of_type_Boolean) {
          paramsjt.jdField_b_of_type_Boolean = localJSONObject.optBoolean("isH265HWCodec", true);
        }
        paramsjt.jdField_d_of_type_JavaLangString = localJSONObject.optString("reportInfo", "");
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.video.VideoUrlInfo", 2, "onReceive CMD_VIDEO_UUIDFORURL jsonVideoDetail = " + (String)localObject);
          bool1 = bool2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bool1 = true;
        }
      }
      paramGetUrlByVidResponse = paramGetUrlByVidResponse.video_info.get();
      if ((paramGetUrlByVidResponse == null) || (paramGetUrlByVidResponse.size() <= 0)) {
        return bool1;
      }
      paramGetUrlByVidResponse = paramGetUrlByVidResponse.iterator();
      while (paramGetUrlByVidResponse.hasNext())
      {
        localObject = (ArticleCenter.VideoInfo)paramGetUrlByVidResponse.next();
        localObject = a(paramsjt.jdField_b_of_type_JavaLangString, (ArticleCenter.VideoInfo)localObject);
        paramsjt.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
    }
    return bool1;
  }
  
  public boolean a(long paramLong)
  {
    return (paramLong - this.jdField_b_of_type_Long > 0L) && (paramLong - this.jdField_b_of_type_Long < 7200L);
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    return (paramLong1 - this.jdField_b_of_type_Long > 0L) && (paramLong1 - this.jdField_b_of_type_Long < paramLong2);
  }
  
  public String toString()
  {
    return "VidUrl {\n vid: " + this.jdField_b_of_type_JavaLangString + "\n url: " + this.jdField_a_of_type_JavaLangString + "\n width: " + this.jdField_b_of_type_Int + "\n height: " + this.jdField_c_of_type_Int + "\n isH265: " + this.jdField_a_of_type_Boolean + "\n fileBitRate: " + this.jdField_c_of_type_JavaLangString + "\n isHWCodec: " + this.jdField_b_of_type_Boolean + "\n videoReportInfo:" + this.jdField_d_of_type_JavaLangString + "\n hwBackupURL:" + this.e + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjt
 * JD-Core Version:    0.7.0.1
 */