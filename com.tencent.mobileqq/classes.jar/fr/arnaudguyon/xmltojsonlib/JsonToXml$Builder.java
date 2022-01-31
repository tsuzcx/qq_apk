package fr.arnaudguyon.xmltojsonlib;

import android.support.annotation.NonNull;
import java.io.InputStream;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonToXml$Builder
{
  private HashSet<String> mForcedAttributes = new HashSet();
  private HashSet<String> mForcedContent = new HashSet();
  private JSONObject mJson;
  
  public JsonToXml$Builder(@NonNull InputStream paramInputStream)
  {
    this(FileReader.readFileFromInputStream(paramInputStream));
  }
  
  public JsonToXml$Builder(String paramString)
  {
    try
    {
      this.mJson = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public JsonToXml$Builder(@NonNull JSONObject paramJSONObject)
  {
    this.mJson = paramJSONObject;
  }
  
  public JsonToXml build()
  {
    return new JsonToXml(this.mJson, this.mForcedAttributes, this.mForcedContent, null);
  }
  
  public Builder forceAttribute(String paramString)
  {
    this.mForcedAttributes.add(paramString);
    return this;
  }
  
  public Builder forceContent(String paramString)
  {
    this.mForcedContent.add(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     fr.arnaudguyon.xmltojsonlib.JsonToXml.Builder
 * JD-Core Version:    0.7.0.1
 */