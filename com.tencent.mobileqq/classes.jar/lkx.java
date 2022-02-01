import android.text.TextUtils;
import com.tencent.av.HardWareCodecSSO.ConfigRsp;
import com.tencent.av.HardWareCodecSSO.PowerInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class lkx
{
  public static final long[] a;
  public final ArrayList<lky> a;
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[] { 2L, 1L, 8L, 4L };
  }
  
  public lkx()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private static long a(String paramString)
  {
    if ("h264_encode".equalsIgnoreCase(paramString)) {
      return 1L;
    }
    if ("h265_encode".equalsIgnoreCase(paramString)) {
      return 4L;
    }
    if ("h264_decode".equalsIgnoreCase(paramString)) {
      return 2L;
    }
    if ("h265_decode".equalsIgnoreCase(paramString)) {
      return 8L;
    }
    return 0L;
  }
  
  public static lkx a(HardWareCodecSSO.ConfigRsp paramConfigRsp)
  {
    lkx locallkx = new lkx();
    paramConfigRsp = paramConfigRsp.codec_info.get().iterator();
    while (paramConfigRsp.hasNext())
    {
      HardWareCodecSSO.PowerInfo localPowerInfo = (HardWareCodecSSO.PowerInfo)paramConfigRsp.next();
      lky locallky = new lky();
      locallky.jdField_a_of_type_Boolean = localPowerInfo.support.get();
      locallky.jdField_a_of_type_Long = localPowerInfo.mark.get();
      locallky.b = ((int)localPowerInfo.max_height.get());
      locallky.jdField_a_of_type_Int = ((int)localPowerInfo.max_width.get());
      locallkx.a(locallky);
    }
    if (locallkx.a().isEmpty()) {
      locallkx.a(lky.jdField_a_of_type_Lky);
    }
    return locallkx;
  }
  
  public static lkx a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = new lkx();
      JSONArray localJSONArray = localJSONObject.getJSONArray("cpuConfig");
      if (localJSONObject.has("cpuConfig"))
      {
        int j = localJSONArray.length();
        if (j > 0)
        {
          int i = 0;
          while (i < j)
          {
            localJSONObject = localJSONArray.getJSONObject(i);
            lky locallky = new lky();
            if (localJSONObject.has("descriptionName")) {
              locallky.jdField_a_of_type_Long = a(localJSONObject.optString("descriptionName"));
            }
            if (localJSONObject.has("support")) {
              locallky.jdField_a_of_type_Boolean = localJSONObject.optBoolean("support");
            }
            if (localJSONObject.has("max_width")) {
              locallky.jdField_a_of_type_Int = localJSONObject.optInt("max_width");
            }
            if (localJSONObject.has("max_height")) {
              locallky.b = localJSONObject.optInt("max_height");
            }
            paramString.a(locallky);
            if (QLog.isColorLevel()) {
              QLog.d("MediaCodecChipConfigInfo", 2, "MediaCodecChipConfigInfo parseJson index: " + i + "," + locallky.toString());
            }
            i += 1;
          }
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.d("MediaCodecChipConfigInfo", 1, String.format("parseJson, Exception\n%s", new Object[] { paramString }));
    }
    return null;
  }
  
  private static JSONObject a(lky paramlky)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("descriptionName", b(paramlky.jdField_a_of_type_Long));
      localJSONObject.put("support", paramlky.jdField_a_of_type_Boolean);
      localJSONObject.put("max_width", paramlky.jdField_a_of_type_Int);
      localJSONObject.put("max_height", paramlky.b);
      return localJSONObject;
    }
    catch (JSONException paramlky)
    {
      paramlky.printStackTrace();
    }
    return null;
  }
  
  private void a(lky paramlky)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      lky locallky = (lky)localIterator.next();
      if (locallky.jdField_a_of_type_Long == paramlky.jdField_a_of_type_Long)
      {
        locallky.jdField_a_of_type_Boolean = paramlky.jdField_a_of_type_Boolean;
        locallky.b = paramlky.b;
        locallky.jdField_a_of_type_Int = paramlky.jdField_a_of_type_Int;
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramlky);
  }
  
  private static String b(long paramLong)
  {
    if (1L == paramLong) {
      return "h264_encode";
    }
    if (4L == paramLong) {
      return "h265_encode";
    }
    if (2L == paramLong) {
      return "h264_decode";
    }
    if (8L == paramLong) {
      return "h265_decode";
    }
    return "";
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(a((lky)localIterator.next()));
    }
    try
    {
      localJSONObject.put("cpuConfig", localJSONArray);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public ArrayList<lky> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("MediaCodecChipConfigInfo{");
    localStringBuffer.append("content = '").append(Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray())).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lkx
 * JD-Core Version:    0.7.0.1
 */