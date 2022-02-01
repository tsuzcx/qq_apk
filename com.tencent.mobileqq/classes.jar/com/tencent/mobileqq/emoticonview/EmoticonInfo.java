package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.EditText;
import com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.Serializable;
import mqq.app.AppRuntime;

public class EmoticonInfo
  extends EmotionPanelData
  implements Parcelable
{
  public static final String ADD_ACTION = "add";
  public static final int ADD_LOCAL = 1;
  public static final String CAMERA_EDIT_ACTION = "cameraEdit";
  public static final String CAMERA_JUMP_ACTION = "cameraJump";
  public static final Parcelable.Creator<EmoticonInfo> CREATOR = new EmoticonInfo.1();
  public static final int DEFAULT = 0;
  public static final String DELETE_ACTION = "delete";
  public static final int FAVORITE = 2;
  public static final String FAV_EDIT_ACTION = "favEdit";
  public static final String FUNNY_PIC_ACTION = "funny_pic";
  public static final String PUSH_ACTION = "push";
  public static final int RENCENT = 1;
  public static final String SETTING_ACTION = "setting";
  public static final String SHOW_FAV_MENU_ACTION = "show_fav_menu";
  public String action;
  EmoticonCallback callback;
  public int drawableId;
  public int emoId;
  public boolean isChecked;
  public String longClickAction;
  public int operateType;
  public int srcType;
  public Serializable stickerInfo;
  public int type = -1;
  
  public EmoticonInfo()
  {
    this.srcType = 0;
    this.operateType = 0;
  }
  
  protected EmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    boolean bool = false;
    this.srcType = 0;
    this.operateType = 0;
    this.type = paramParcel.readInt();
    this.action = paramParcel.readString();
    this.longClickAction = paramParcel.readString();
    this.srcType = paramParcel.readInt();
    this.drawableId = paramParcel.readInt();
    this.operateType = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.isChecked = bool;
    this.emoId = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    return getDrawable(paramContext, paramFloat);
  }
  
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    return ((ITextUtilsApi)QRoute.api(ITextUtilsApi.class)).getResourceDrawableThroughImageCache(paramContext.getResources(), this.drawableId);
  }
  
  public Drawable getZoomDrawable(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    return ((ITextUtilsApi)QRoute.api(ITextUtilsApi.class)).getResourceDrawableThroughImageCache(paramContext.getResources(), this.drawableId);
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable) {}
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.callback = paramEmoticonCallback;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EmoticonInfo[type: ");
    localStringBuilder.append(this.type);
    localStringBuilder.append("  action: ");
    localStringBuilder.append(this.action);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.action);
    paramParcel.writeString(this.longClickAction);
    paramParcel.writeInt(this.srcType);
    paramParcel.writeInt(this.drawableId);
    paramParcel.writeInt(this.operateType);
    paramParcel.writeByte((byte)this.isChecked);
    paramParcel.writeInt(this.emoId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonInfo
 * JD-Core Version:    0.7.0.1
 */