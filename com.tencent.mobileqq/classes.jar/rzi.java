import android.os.Parcel;
import org.json.JSONObject;

public class rzi
{
  public String mAbTest;
  public int mType;
  
  protected rzi(Parcel paramParcel)
  {
    this.mType = paramParcel.readInt();
    this.mAbTest = paramParcel.readString();
  }
  
  protected rzi(JSONObject paramJSONObject)
  {
    this.mType = paramJSONObject.optInt("type");
    this.mAbTest = paramJSONObject.optString("qq_abtest");
    parseJson(paramJSONObject);
  }
  
  protected void parseJson(JSONObject paramJSONObject) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mType);
    paramParcel.writeString(this.mAbTest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rzi
 * JD-Core Version:    0.7.0.1
 */