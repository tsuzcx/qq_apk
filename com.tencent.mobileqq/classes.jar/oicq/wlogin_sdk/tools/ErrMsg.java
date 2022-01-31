package oicq.wlogin_sdk.tools;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ErrMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<ErrMsg> CREATOR = new ErrMsg.1();
  private String message;
  private String otherinfo;
  private String title;
  private int type;
  
  public ErrMsg()
  {
    this.type = 0;
    this.title = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_0);
    this.message = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_1);
    this.otherinfo = "";
  }
  
  public ErrMsg(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.type = paramInt;
    this.title = paramString1;
    this.message = paramString2;
    this.otherinfo = paramString3;
  }
  
  private ErrMsg(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getOtherinfo()
  {
    return this.otherinfo;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.type = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.message = paramParcel.readString();
    this.otherinfo = paramParcel.readString();
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setOtherinfo(String paramString)
  {
    this.otherinfo = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("(");
    if (this.type < 0) {}
    for (Object localObject = Integer.valueOf(this.type);; localObject = Integer.toString(this.type))
    {
      localObject = localObject + ")[";
      return (String)localObject + this.title + "]" + this.message + "[" + this.otherinfo + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.message);
    paramParcel.writeString(this.otherinfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.ErrMsg
 * JD-Core Version:    0.7.0.1
 */