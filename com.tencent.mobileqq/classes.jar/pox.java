import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.channel_button.channel_button.Section;

public class pox
{
  public long a;
  public String a;
  public List<TabChannelCoverInfo> a;
  public String b;
  
  public pox(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public pox(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = paramJSONObject.optLong("id");
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name");
    this.b = paramJSONObject.optString("text");
  }
  
  public pox(channel_button.Section paramSection)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = paramSection.uint64_section_id.get();
    this.jdField_a_of_type_JavaLangString = paramSection.str_section_name.get();
    this.b = paramSection.str_note_text.get();
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.jdField_a_of_type_Long);
      localJSONObject.put("name", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("text", this.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pox
 * JD-Core Version:    0.7.0.1
 */