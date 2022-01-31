import android.os.Parcel;
import org.json.JSONObject;

public class sme
{
  public String mAbTest;
  public int mType;
  
  protected sme(Parcel paramParcel)
  {
    this.mType = paramParcel.readInt();
    this.mAbTest = paramParcel.readString();
  }
  
  protected sme(JSONObject paramJSONObject)
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
 * Qualified Name:     sme
 * JD-Core Version:    0.7.0.1
 */