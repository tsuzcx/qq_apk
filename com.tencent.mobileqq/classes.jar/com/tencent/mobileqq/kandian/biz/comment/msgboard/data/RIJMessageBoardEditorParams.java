package com.tencent.mobileqq.kandian.biz.comment.msgboard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;
import org.json.JSONObject;

public class RIJMessageBoardEditorParams
  implements Parcelable
{
  public static final Parcelable.Creator<RIJMessageBoardEditorParams> CREATOR = new RIJMessageBoardEditorParams.1();
  public RIJMessageBoardEditorParams.SourceInfo a;
  public String b;
  public int c;
  public String d;
  public long e;
  public String f;
  public String g;
  
  public RIJMessageBoardEditorParams() {}
  
  protected RIJMessageBoardEditorParams(Parcel paramParcel)
  {
    this.a = ((RIJMessageBoardEditorParams.SourceInfo)paramParcel.readParcelable(RIJMessageBoardEditorParams.SourceInfo.class.getClassLoader()));
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
  }
  
  @Nullable
  public static RIJMessageBoardEditorParams a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    JSONObject localJSONObject = paramJSONObject.optJSONObject("source");
    RIJMessageBoardEditorParams localRIJMessageBoardEditorParams = new RIJMessageBoardEditorParams();
    if (localJSONObject != null)
    {
      localRIJMessageBoardEditorParams.a = new RIJMessageBoardEditorParams.SourceInfo();
      localRIJMessageBoardEditorParams.a.a = localJSONObject.optInt("type", 0);
      localRIJMessageBoardEditorParams.a.b = localJSONObject.optString("key", "");
    }
    localRIJMessageBoardEditorParams.b = paramJSONObject.optString("business_info", "");
    localRIJMessageBoardEditorParams.c = paramJSONObject.optInt("messageType", 0);
    localRIJMessageBoardEditorParams.d = paramJSONObject.optString("source_message_id", "");
    localRIJMessageBoardEditorParams.e = paramJSONObject.optLong("replied_puin", 0L);
    localRIJMessageBoardEditorParams.f = paramJSONObject.optString("replied_message_id", "");
    localRIJMessageBoardEditorParams.g = paramJSONObject.optString("message_board_id", "");
    return localRIJMessageBoardEditorParams;
  }
  
  public JSONObject b(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    localJSONObject.put("business_info", this.b);
    localJSONObject.put("messageType", this.c);
    localJSONObject.put("source_message_id", this.d);
    localJSONObject.put("replied_puin", this.e);
    localJSONObject.put("replied_message_id", this.f);
    localJSONObject.put("message_board_id", this.g);
    if (this.a != null)
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("type", this.a.a);
      paramJSONObject.put("key", this.a.b);
      localJSONObject.put("source", paramJSONObject);
    }
    return localJSONObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.msgboard.data.RIJMessageBoardEditorParams
 * JD-Core Version:    0.7.0.1
 */