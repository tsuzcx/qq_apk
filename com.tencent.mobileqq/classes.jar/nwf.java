import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.AdInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.AdInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.MsgCommonData;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.Video;

public class nwf
{
  public int a;
  public long a;
  public String a;
  public ArrayList<nwg> a;
  public nwh a;
  public short a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public long d;
  public String d;
  public String e = "";
  public String f = "";
  
  public nwf()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  public nwf(String paramString1, String paramString2, ArrayList<nwg> paramArrayList, String paramString3)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Nwh = new nwh(paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "AdvertisementItem json:" + paramString3);
    }
  }
  
  public static nwf a(String paramString)
  {
    try
    {
      paramString = b(new JSONObject(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static nwf a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        nwf localnwf = new nwf();
        localnwf.jdField_a_of_type_JavaLangString = paramJSONObject.getString("uint64_from_uin");
        localnwf.jdField_d_of_type_JavaLangString = paramJSONObject.optString("str_nick");
        localnwf.e = paramJSONObject.optString("str_head_url");
        localnwf.f = paramJSONObject.optString("str_brief");
        localnwf.jdField_b_of_type_JavaLangString = paramJSONObject.getString("str_url");
        localnwf.jdField_a_of_type_Long = (paramJSONObject.optLong("uint32_pushTime") * 1000L);
        localnwf.jdField_b_of_type_Long = (paramJSONObject.optLong("uint32_invalidTime") * 1000L);
        localnwf.jdField_b_of_type_Int = paramJSONObject.optInt("uint32_maxExposureTime");
        JSONArray localJSONArray = paramJSONObject.getJSONArray("rpt_msg_video");
        localnwf.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        i = 0;
        if (i < localJSONArray.length())
        {
          nwg localnwg = nwg.a(i, localJSONArray.getJSONObject(i));
          if (localnwg != null) {
            localnwf.jdField_a_of_type_JavaUtilArrayList.add(localnwg);
          }
        }
        else
        {
          localnwf.jdField_a_of_type_Nwh = nwh.a(paramJSONObject.optString("msg_msgCommonData"), localnwf.jdField_a_of_type_JavaLangString, localnwf.jdField_d_of_type_JavaLangString);
          paramJSONObject = localnwf.jdField_a_of_type_Nwh;
          if (paramJSONObject == null) {
            break;
          }
          return localnwf;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      i += 1;
    }
  }
  
  public static nwf a(submsgtype0xf9.AdInfo paramAdInfo, MsgInfo paramMsgInfo)
  {
    int i = 0;
    nwf localnwf = new nwf();
    label408:
    for (;;)
    {
      try
      {
        if (paramAdInfo.uint64_from_uin.has()) {
          localnwf.jdField_a_of_type_JavaLangString = String.valueOf(paramAdInfo.uint64_from_uin.get());
        }
        if (paramAdInfo.str_nick.has()) {
          localnwf.jdField_d_of_type_JavaLangString = paramAdInfo.str_nick.get();
        }
        if (paramAdInfo.str_head_url.has()) {
          localnwf.e = paramAdInfo.str_head_url.get();
        }
        if (paramAdInfo.str_brief.has()) {
          localnwf.f = paramAdInfo.str_brief.get();
        }
        if (paramAdInfo.str_url.has()) {
          localnwf.jdField_b_of_type_JavaLangString = paramAdInfo.str_url.get();
        }
        if (paramAdInfo.rpt_msg_video.has())
        {
          localnwf.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          Iterator localIterator = paramAdInfo.rpt_msg_video.get().iterator();
          if (localIterator.hasNext())
          {
            nwg localnwg = nwg.a(i, (submsgtype0xf9.Video)localIterator.next());
            if (localnwg == null) {
              break label408;
            }
            localnwf.jdField_a_of_type_JavaUtilArrayList.add(localnwg);
            i += 1;
            break label408;
          }
        }
        if (paramAdInfo.msg_msgCommonData.has()) {
          localnwf.jdField_a_of_type_Nwh = nwh.a(paramAdInfo.msg_msgCommonData, localnwf.jdField_a_of_type_JavaLangString, localnwf.jdField_d_of_type_JavaLangString);
        }
        if (paramAdInfo.uint32_pushTime.has()) {
          localnwf.jdField_a_of_type_Long = (paramAdInfo.uint32_pushTime.get() * 1000L);
        }
        if (paramAdInfo.uint32_invalidTime.has()) {
          localnwf.jdField_b_of_type_Long = (paramAdInfo.uint32_invalidTime.get() * 1000L);
        }
        localnwf.jdField_b_of_type_Int = paramAdInfo.uint32_maxExposureTime.get();
        localnwf.jdField_c_of_type_JavaLangString = String.valueOf(paramMsgInfo.lMsgUid);
        localnwf.jdField_a_of_type_Short = paramMsgInfo.shMsgSeq;
        localnwf.jdField_d_of_type_Long = paramMsgInfo.lMsgUid;
        if (QLog.isColorLevel()) {
          QLog.w("ImaxAdvertisement", 2, "PbData:" + localnwf.toString());
        }
        bdll.a(null, "dc00898", "", localnwf.jdField_a_of_type_Nwh.jdField_a_of_type_JavaLangString, "0X8008F5C", "0X8008F5C", 0, 0, localnwf.jdField_a_of_type_Nwh.jdField_c_of_type_JavaLangString, "", nwy.a(), localnwf.jdField_a_of_type_Nwh.jdField_b_of_type_JavaLangString);
        return localnwf;
      }
      catch (Exception paramAdInfo)
      {
        paramAdInfo.printStackTrace();
        return localnwf;
      }
    }
  }
  
  private static nwf b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        nwf localnwf = new nwf();
        localnwf.jdField_a_of_type_JavaLangString = paramJSONObject.getString("senderUin");
        localnwf.jdField_b_of_type_JavaLangString = paramJSONObject.getString("pageUrl");
        localnwf.jdField_c_of_type_JavaLangString = paramJSONObject.optString("adMsgId");
        localnwf.jdField_a_of_type_Long = paramJSONObject.optLong("pushTime");
        localnwf.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("hasReport");
        localnwf.jdField_d_of_type_JavaLangString = paramJSONObject.optString("str_nick");
        localnwf.e = paramJSONObject.optString("str_head_url");
        localnwf.f = paramJSONObject.optString("str_brief");
        localnwf.jdField_a_of_type_Int = paramJSONObject.optInt("video_preload_state");
        localnwf.jdField_b_of_type_Long = paramJSONObject.optLong("invalidTime");
        localnwf.jdField_c_of_type_Long = paramJSONObject.optLong("msgTime");
        localnwf.jdField_a_of_type_Short = ((short)paramJSONObject.optInt("shMsgSeq"));
        localnwf.jdField_d_of_type_Long = paramJSONObject.optLong("msgUid");
        localnwf.jdField_b_of_type_Int = ((short)paramJSONObject.optInt("maxExposureTime"));
        localnwf.jdField_c_of_type_Int = ((short)paramJSONObject.optInt("realExposureTime"));
        localnwf.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        JSONArray localJSONArray = paramJSONObject.getJSONArray("videoList");
        i = 0;
        if (i < localJSONArray.length())
        {
          nwg localnwg = nwg.a(localJSONArray.getJSONObject(i));
          if (localnwg != null) {
            localnwf.jdField_a_of_type_JavaUtilArrayList.add(localnwg);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.w("AdvertisementRecentUserManager", 2, "convertFromJson msgCommonData" + paramJSONObject.optString("msgCommonData"));
          }
          localnwf.jdField_a_of_type_Nwh = new nwh(paramJSONObject.optString("msgCommonData"));
          return localnwf;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      i += 1;
    }
  }
  
  public String a()
  {
    Object localObject;
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        JSONObject localJSONObject = ((nwg)((Iterator)localObject).next()).a();
        if (localJSONObject != null) {
          localJSONArray.put(localJSONObject);
        }
      }
      localObject = new JSONObject();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    ((JSONObject)localObject).put("senderUin", this.jdField_a_of_type_JavaLangString);
    ((JSONObject)localObject).put("pageUrl", this.jdField_b_of_type_JavaLangString);
    ((JSONObject)localObject).put("adMsgId", this.jdField_c_of_type_JavaLangString);
    ((JSONObject)localObject).put("pushTime", this.jdField_a_of_type_Long);
    ((JSONObject)localObject).put("hasReport", this.jdField_a_of_type_Boolean);
    ((JSONObject)localObject).put("videoList", localException);
    ((JSONObject)localObject).put("str_nick", this.jdField_d_of_type_JavaLangString);
    ((JSONObject)localObject).put("str_head_url", this.e);
    ((JSONObject)localObject).put("str_brief", this.f);
    ((JSONObject)localObject).put("video_preload_state", this.jdField_a_of_type_Int);
    ((JSONObject)localObject).put("invalidTime", this.jdField_b_of_type_Long);
    ((JSONObject)localObject).put("msgTime", this.jdField_c_of_type_Long);
    ((JSONObject)localObject).put("shMsgSeq", this.jdField_a_of_type_Short);
    ((JSONObject)localObject).put("msgUid", this.jdField_d_of_type_Long);
    ((JSONObject)localObject).put("maxExposureTime", this.jdField_b_of_type_Int);
    ((JSONObject)localObject).put("realExposureTime", this.jdField_c_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.w("AdvertisementRecentUserManager", 2, "convertToJson msgCommonData" + this.jdField_a_of_type_Nwh.a().toString());
    }
    ((JSONObject)localObject).put("msgCommonData", this.jdField_a_of_type_Nwh.a().toString());
    String str = ((JSONObject)localObject).toString();
    return str;
  }
  
  public oidb_cmd0x886.AdInfo a(int paramInt)
  {
    long l2 = 0L;
    oidb_cmd0x886.AdInfo localAdInfo = new oidb_cmd0x886.AdInfo();
    localAdInfo.bytes_trace_id.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    localAdInfo.uint64_pull_time.set(this.jdField_a_of_type_Long);
    localAdInfo.enum_report_type.set(paramInt);
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_Nwh.jdField_d_of_type_JavaLangString);
      try
      {
        long l3 = Long.parseLong(this.jdField_a_of_type_Nwh.jdField_c_of_type_JavaLangString);
        l2 = l3;
      }
      catch (Exception localException2)
      {
        label75:
        break label75;
      }
      localAdInfo.uint64_pos_id.set(l1);
      localAdInfo.uint64_aid.set(l2);
      return localAdInfo;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        long l1 = 0L;
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_Int == 0) {
      return true;
    }
    if (this.jdField_c_of_type_Int >= this.jdField_b_of_type_Int) {
      return false;
    }
    this.jdField_c_of_type_Int += 1;
    return true;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Nwh != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Nwh.jdField_a_of_type_JavaLangString));
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Long < NetConnInfoCenter.getServerTimeMillis();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (nwf)paramObject;
    return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("====mSenderUin " + this.jdField_a_of_type_JavaLangString + "\n").append("====mContentPageUrl " + this.jdField_b_of_type_JavaLangString + "\n").append("====invalidTime " + this.jdField_b_of_type_Long).append("====shMsgSeq " + this.jdField_a_of_type_Short).append("====maxExposureTime " + this.jdField_b_of_type_Int);
    Iterator localIterator;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    while (localIterator.hasNext())
    {
      nwg localnwg = (nwg)localIterator.next();
      localStringBuilder.append("====VideoCoverItem " + localnwg.toString() + "\n");
      continue;
      localStringBuilder.append("====VideoCoverItem NULL ~ \n");
    }
    if (this.jdField_a_of_type_Nwh != null) {
      localStringBuilder.append("====VideoDownloadItem " + this.jdField_a_of_type_Nwh.toString() + "\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     nwf
 * JD-Core Version:    0.7.0.1
 */