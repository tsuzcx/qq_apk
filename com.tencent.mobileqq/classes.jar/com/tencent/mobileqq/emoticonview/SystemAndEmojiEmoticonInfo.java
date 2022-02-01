package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.EditText;
import com.tencent.mobileqq.core.SystemEmotionPanelManager;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SystemAndEmojiEmoticonInfo
  extends EmoticonInfo
  implements Parcelable
{
  public static final int BLANK_FILLING_EMOTION_CODE = -1;
  public static final int COLUMNNUM_SYSTEM_AND_EMOJI = 7;
  public static final Parcelable.Creator<SystemAndEmojiEmoticonInfo> CREATOR;
  public static final int EMOTICON_EMOJI_PAGE_COUNT;
  public static final String TAG = "SystemAndEmojiEmoticonInfo";
  public static final String TITLE_EMOJI;
  public static final String TITLE_OFTEN = MobileQQ.sMobileQQ.getString(2131719709);
  public static final String TITLE_SYSTEM = MobileQQ.sMobileQQ.getString(2131719699);
  public static final int TYPE_EMOJI = 2;
  public static final int TYPE_SYSTEM = 1;
  public static final int TYPE_TITLE = 3;
  public int code;
  public int emotionType;
  public boolean isCommonUsed;
  private Drawable mDefault = null;
  public String title;
  
  static
  {
    TITLE_EMOJI = MobileQQ.sMobileQQ.getString(2131719705);
    int j = EmojiEmoticonInfo.EMOJI_COUNT / 20;
    if (EmojiEmoticonInfo.EMOJI_COUNT % 20 == 0) {}
    for (int i = 0;; i = 1)
    {
      EMOTICON_EMOJI_PAGE_COUNT = i + j;
      CREATOR = new SystemAndEmojiEmoticonInfo.1();
      return;
    }
  }
  
  public SystemAndEmojiEmoticonInfo(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.emotionType = paramInt2;
    this.code = paramInt3;
    this.title = paramString;
    this.isCommonUsed = paramBoolean;
  }
  
  protected SystemAndEmojiEmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.emotionType = paramParcel.readInt();
    this.code = paramParcel.readInt();
    this.title = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isCommonUsed = bool;
      return;
    }
  }
  
  public static List<EmotionPanelData> getCommonUsedSystemEmojiPanelData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt)
  {
    return getCommonUsedSystemEmojiPanelData(paramIEmoticonMainPanelApp, paramInt, false);
  }
  
  public static List<EmotionPanelData> getCommonUsedSystemEmojiPanelData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt, boolean paramBoolean)
  {
    return ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).getCommonUsedSystemEmojiPanelData(paramIEmoticonMainPanelApp, paramInt, paramBoolean);
  }
  
  public static List<EmotionPanelData> getEmojiEmoticonPanelData(int paramInt, ArrayList<Integer> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, TITLE_EMOJI, false));
      i += 1;
    }
    i = 0;
    while (i < paramArrayList.size())
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, ((Integer)paramArrayList.get(i)).intValue(), "", false));
      i += 1;
    }
    int j = paramArrayList.size() % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List<EmotionPanelData> getEmoticonList(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt)
  {
    return getEmoticonListFromConfig(paramIEmoticonMainPanelApp, false, 7, paramInt);
  }
  
  public static List<EmotionPanelData> getEmoticonList(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, int paramInt2)
  {
    return ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).getEmoticonList(paramIEmoticonMainPanelApp, paramInt1, paramInt2);
  }
  
  public static List<EmotionPanelData> getEmoticonListFromConfig(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).getEmoticonListFromConfig(paramIEmoticonMainPanelApp, paramBoolean, paramInt1, paramInt2);
  }
  
  public static List<EmoticonInfo> getOldEmoticonList(int[] paramArrayOfInt)
  {
    return ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).getOldEmoticonList(paramArrayOfInt);
  }
  
  public static List<EmotionPanelData> getOnlySysEmoticonListFromConfig(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt, int[] paramArrayOfInt)
  {
    return ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).getOnlySysEmoticonListFromConfig(paramIEmoticonMainPanelApp, paramInt, paramArrayOfInt);
  }
  
  public static final int getPageCount(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt.length + 19) / 20;
  }
  
  public static List<EmotionPanelData> getSystemEmoticonPanelData(int paramInt, ArrayList<Integer> paramArrayList)
  {
    return getSystemEmoticonPanelData(paramInt, false, paramArrayList);
  }
  
  public static List<EmotionPanelData> getSystemEmoticonPanelData(int paramInt, boolean paramBoolean, ArrayList<Integer> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, TITLE_SYSTEM, false));
      i += 1;
    }
    i = 0;
    int k = paramArrayList.size();
    int j = 0;
    if (j < k)
    {
      if ((paramBoolean) && (((Integer)paramArrayList.get(j)).intValue() > 255)) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (((Integer)paramArrayList.get(j)).intValue() == -1) {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, 0, "", false));
        } else {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, ((Integer)paramArrayList.get(j)).intValue(), "", false));
        }
      }
    }
    j = (paramArrayList.size() - i) % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List<EmotionPanelData> getUniversalEmoticonListFromConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).getUniversalEmoticonListFromConfig(paramInt, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public static void preload(AppRuntime paramAppRuntime)
  {
    ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).preload(paramAppRuntime);
  }
  
  public void addToCommonUsed(AppRuntime paramAppRuntime, Parcelable paramParcelable)
  {
    ((IEmoticonInfoService)QRoute.api(IEmoticonInfoService.class)).addToCommonUsed(paramAppRuntime, paramParcelable, this.code, this.emotionType);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.emotionType == 1) && (this.code != -1)) {
      localObject1 = TextUtils.getSysEmotcationDrawable(this.code, true);
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.emotionType != 2);
      localObject1 = localObject2;
    } while (this.code == -1);
    return super.getBigDrawable(paramContext, paramFloat);
  }
  
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    return getSystemEmojiStaticImg(this.code, true);
  }
  
  public Drawable getDrawable(boolean paramBoolean)
  {
    return getSystemEmojiStaticImg(this.code, paramBoolean);
  }
  
  public Drawable getSystemEmojiStaticImg(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((1 == this.emotionType) && (this.code != -1)) {
      localObject1 = QQSysFaceUtil.getFaceDrawable(paramInt);
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (2 != this.emotionType);
      localObject1 = localObject2;
    } while (this.code == -1);
    return QQEmojiUtil.getEmojiDrawable(paramInt);
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    IEmoticonInfoSender localIEmoticonInfoSender = SystemEmotionPanelManager.a().a(7);
    if (localIEmoticonInfoSender == null)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "emotionInfoSender is null.");
      return;
    }
    localIEmoticonInfoSender.send(this, paramAppRuntime, paramContext, paramEditText, paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.emotionType);
    paramParcel.writeInt(this.code);
    paramParcel.writeString(this.title);
    if (this.isCommonUsed) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */