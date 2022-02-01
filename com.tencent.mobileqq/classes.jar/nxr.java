import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.mobileqq.pb.PBStringField;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.Video;

public class nxr
{
  public int a;
  public VideoCoverView a;
  public String a;
  public String b;
  
  public nxr() {}
  
  public nxr(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public static nxr a(int paramInt, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      nxr localnxr = new nxr();
      localnxr.jdField_a_of_type_Int = paramInt;
      localnxr.jdField_a_of_type_JavaLangString = paramJSONObject.getString("str_cover");
      localnxr.b = paramJSONObject.getString("str_src");
      return localnxr;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static nxr a(int paramInt, submsgtype0xf9.Video paramVideo)
  {
    if (paramVideo == null) {
      return null;
    }
    try
    {
      nxr localnxr = new nxr();
      localnxr.b = paramVideo.str_src.get();
      localnxr.jdField_a_of_type_JavaLangString = paramVideo.str_cover.get();
      localnxr.jdField_a_of_type_Int = paramInt;
      return localnxr;
    }
    catch (Exception paramVideo)
    {
      paramVideo.printStackTrace();
    }
    return null;
  }
  
  public static nxr a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      nxr localnxr = new nxr();
      localnxr.jdField_a_of_type_Int = paramJSONObject.getInt("index");
      localnxr.jdField_a_of_type_JavaLangString = paramJSONObject.getString("cover");
      localnxr.b = paramJSONObject.getString("src");
      return localnxr;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nxr
 * JD-Core Version:    0.7.0.1
 */