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
  private int version;
  
  public ErrMsg()
  {
    this.version = 0;
    this.type = 0;
    this.title = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_0);
    this.message = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_1);
    this.otherinfo = "";
  }
  
  public ErrMsg(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.version = paramInt1;
    this.type = paramInt2;
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
  
  public int getVersion()
  {
    return this.version;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.version = paramParcel.readInt();
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
  
  public void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("(");
    if (this.version < 0)
    {
      localObject = Integer.valueOf(this.version);
      localStringBuilder = localStringBuilder.append(localObject).append(")(");
      if (this.type >= 0) {
        break label130;
      }
    }
    label130:
    for (Object localObject = Integer.valueOf(this.type);; localObject = Integer.toString(this.type))
    {
      localObject = localObject + ")[";
      return (String)localObject + this.title + "]" + this.message + "[" + this.otherinfo + "]";
      localObject = Integer.toString(this.version);
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.version);
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