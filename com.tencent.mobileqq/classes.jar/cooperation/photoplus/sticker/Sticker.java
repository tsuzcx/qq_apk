package cooperation.photoplus.sticker;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import cooperation.photoplus.PhotoPlusManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="id")
public class Sticker
  extends Entity
{
  public static final String JSON_SUFFIX = ".json";
  public static final String PNG_SUFFIX = ".png";
  public static final String TAG = "Sticker";
  public static final String THUMB_SUFFIX = "_thumb";
  public static final int TYPE_BASIC = 0;
  public static final int TYPE_NORMAL = 1;
  @unique
  public String id;
  public String md5;
  public int priority;
  public int type;
  public String url;
  public int version;
  
  public Sticker() {}
  
  public Sticker(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, String paramString3)
  {
    this.id = paramString1;
    this.version = paramInt1;
    this.priority = paramInt2;
    this.url = paramString2;
    this.type = paramInt3;
    this.md5 = paramString3;
  }
  
  public static List<Sticker> parse(String paramString)
  {
    paramString = ((JSONObject)new JSONTokener(paramString).nextValue()).getJSONArray("sticker_templates");
    ArrayList localArrayList = new ArrayList(paramString.length());
    int i = 0;
    for (;;)
    {
      if (i < paramString.length()) {}
      try
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        localArrayList.add(new Sticker(localJSONObject.getString("id"), localJSONObject.getInt("version"), localJSONObject.getInt("priority"), localJSONObject.getString("url"), localJSONObject.getInt("type"), localJSONObject.optString("md5")));
        label98:
        i += 1;
        continue;
        return localArrayList;
      }
      catch (JSONException localJSONException)
      {
        break label98;
      }
    }
  }
  
  public String getImageFileName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.id);
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public String getJsonFileName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.id);
    localStringBuilder.append(".json");
    return localStringBuilder.toString();
  }
  
  public String getThumbImageFileName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.id);
    localStringBuilder.append("_thumb");
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public String getUnzippedDir()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.id);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.version);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public String getZipFilePath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.id);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.version);
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
  }
  
  public JSONObject toJsonObject()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", this.id);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PhotoPlusManager.a);
      localStringBuilder.append(getUnzippedDir());
      localStringBuilder.append(getThumbImageFileName());
      localJSONObject.put("thumbPath", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PhotoPlusManager.a);
      localStringBuilder.append(getUnzippedDir());
      localStringBuilder.append(getImageFileName());
      localJSONObject.put("path", localStringBuilder.toString());
      localJSONObject.put("version", this.version);
      localJSONObject.put("priority", this.priority);
      localJSONObject.put("type", this.type);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PhotoPlusManager.a);
      localStringBuilder.append(getUnzippedDir());
      localStringBuilder.append(getJsonFileName());
      localJSONObject.put("jsonPath", localStringBuilder.toString());
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
    return String.format(Locale.CHINA, "sticker: id=%s, version=%d, priority=%d, url=%s, type=%d, md5=%s", new Object[] { this.id, Integer.valueOf(this.version), Integer.valueOf(this.priority), this.url, Integer.valueOf(this.type), this.md5 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.photoplus.sticker.Sticker
 * JD-Core Version:    0.7.0.1
 */