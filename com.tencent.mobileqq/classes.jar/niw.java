import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.Video;

public class niw
{
  public int a;
  public VideoCoverView a;
  public String a;
  public String b;
  
  public niw() {}
  
  public niw(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public static niw a(int paramInt, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      niw localniw = new niw();
      localniw.jdField_a_of_type_Int = paramInt;
      localniw.jdField_a_of_type_JavaLangString = paramJSONObject.getString("str_cover");
      localniw.b = paramJSONObject.getString("str_src");
      return localniw;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static niw a(int paramInt, submsgtype0xf9.Video paramVideo)
  {
    if (paramVideo == null) {
      return null;
    }
    try
    {
      niw localniw = new niw();
      localniw.b = paramVideo.str_src.get();
      localniw.jdField_a_of_type_JavaLangString = paramVideo.str_cover.get();
      localniw.jdField_a_of_type_Int = paramInt;
      return localniw;
    }
    catch (Exception paramVideo)
    {
      paramVideo.printStackTrace();
    }
    return null;
  }
  
  public static niw a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      niw localniw = new niw();
      localniw.jdField_a_of_type_Int = paramJSONObject.getInt("index");
      localniw.jdField_a_of_type_JavaLangString = paramJSONObject.getString("cover");
      localniw.b = paramJSONObject.getString("src");
      return localniw;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", this.jdField_a_of_type_Int);
      localJSONObject.put("cover", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("src", this.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    return "mVideoSrc " + this.b + " mVideoCoverPic " + this.jdField_a_of_type_JavaLangString + " mVideoIndex " + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     niw
 * JD-Core Version:    0.7.0.1
 */