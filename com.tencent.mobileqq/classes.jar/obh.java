import org.json.JSONObject;

public class obh
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public obh(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.a = paramJSONObject.optString("dest_url");
      this.b = paramJSONObject.optString("rl");
      this.c = paramJSONObject.optString("button_txt");
      this.d = paramJSONObject.optString("button_bg");
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AdPKImageData{");
    localStringBuilder.append("destUrl=").append(this.a);
    localStringBuilder.append(",rl=").append(this.b);
    localStringBuilder.append(",buttonTxt=").append(this.c);
    localStringBuilder.append(",buttonBg=").append(this.d);
    localStringBuilder.append("}");
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     obh
 * JD-Core Version:    0.7.0.1
 */