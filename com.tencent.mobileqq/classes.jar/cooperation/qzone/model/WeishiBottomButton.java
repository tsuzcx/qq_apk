package cooperation.qzone.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;

public class WeishiBottomButton
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiBottomButton> CREATOR = new WeishiBottomButton.1();
  public int actionType;
  public String actionUrl = "";
  public int appearTime;
  public String buttonBackgroundImg = "";
  public String buttonIcon = "";
  public String buttonImg = "";
  public String button_text = "";
  public int durationTime;
  public HashMap<Integer, Integer> stMapABTest;
  
  public WeishiBottomButton() {}
  
  protected WeishiBottomButton(Parcel paramParcel)
  {
    this.button_text = paramParcel.readString();
    this.actionType = paramParcel.readInt();
    this.actionUrl = paramParcel.readString();
    this.buttonImg = paramParcel.readString();
    this.buttonBackgroundImg = paramParcel.readString();
    this.buttonIcon = paramParcel.readString();
    this.appearTime = paramParcel.readInt();
    this.durationTime = paramParcel.readInt();
    this.stMapABTest = ((HashMap)paramParcel.readBundle().getSerializable("stMapABTest"));
  }
  
  public WeishiBottomButton(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap<Integer, Integer> paramHashMap, int paramInt2, int paramInt3)
  {
    this.button_text = paramString1;
    this.actionType = paramInt1;
    this.actionUrl = paramString2;
    this.buttonImg = paramString3;
    this.buttonBackgroundImg = paramString4;
    this.buttonIcon = paramString5;
    this.stMapABTest = paramHashMap;
    this.appearTime = paramInt2;
    this.durationTime = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.button_text);
    paramParcel.writeInt(this.actionType);
    paramParcel.writeString(this.actionUrl);
    paramParcel.writeString(this.buttonImg);
    paramParcel.writeString(this.buttonBackgroundImg);
    paramParcel.writeString(this.buttonIcon);
    paramParcel.writeInt(this.appearTime);
    paramParcel.writeInt(this.durationTime);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("stMapABTest", this.stMapABTest);
    paramParcel.writeBundle(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.WeishiBottomButton
 * JD-Core Version:    0.7.0.1
 */