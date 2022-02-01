package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class EmojiEmoticonInfo
  extends EmoticonInfo
  implements Parcelable
{
  public static final Parcelable.Creator<EmojiEmoticonInfo> CREATOR = new EmojiEmoticonInfo.1();
  public static int EMOJI_COUNT = 165;
  public int code;
  
  public EmojiEmoticonInfo() {}
  
  protected EmojiEmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.code = paramParcel.readInt();
  }
  
  public static List<EmoticonInfo> getEmoticonList()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < EMOJI_COUNT)
    {
      EmojiEmoticonInfo localEmojiEmoticonInfo = new EmojiEmoticonInfo();
      localEmojiEmoticonInfo.type = 2;
      localEmojiEmoticonInfo.code = i;
      localArrayList.add(localEmojiEmoticonInfo);
      i += 1;
    }
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    return QQEmojiUtil.getEmojiDrawable(this.code);
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    int i = paramEditText.getSelectionStart();
    int j = paramEditText.getSelectionEnd();
    paramEditText.getEditableText().replace(i, j, TextUtils.getEmojiString(this.code));
    paramEditText.requestFocus();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.code);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmojiEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */