package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.emoticonview.api.ISystemAndEmojiSenderService;
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
  public static final Parcelable.Creator<SystemAndEmojiEmoticonInfo> CREATOR = new SystemAndEmojiEmoticonInfo.1();
  public static final int EMOTICON_EMOJI_PAGE_COUNT;
  public static final String TAG = "SystemAndEmojiEmoticonInfo";
  public static final String TITLE_EMOJI;
  public static final String TITLE_OFTEN = MobileQQ.sMobileQQ.getString(2131719430);
  public static final String TITLE_SYSTEM = MobileQQ.sMobileQQ.getString(2131719420);
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
    TITLE_EMOJI = MobileQQ.sMobileQQ.getString(2131719426);
    int j = EmojiEmoticonInfo.EMOJI_COUNT / 20;
    int i;
    if (EmojiEmoticonInfo.EMOJI_COUNT % 20 == 0) {
      i = 0;
    } else {
      i = 1;
    }
    EMOTICON_EMOJI_PAGE_COUNT = j + i;
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
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.isCommonUsed = bool;
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
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return localArrayList;
      }
      int j = 0;
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
      int k = paramArrayList.size() % paramInt;
      if (k > 0)
      {
        i = j;
        while (i < paramInt - k)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
          i += 1;
        }
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
    if (paramIEmoticonMainPanelApp == null)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getEmoticonList app = null");
      return null;
    }
    ArrayList localArrayList1 = QQSysFaceUtil.getOrderList();
    ArrayList localArrayList2 = QQEmojiUtil.getOrderList();
    ArrayList localArrayList3 = new ArrayList(localArrayList1.size() + localArrayList2.size());
    if ((paramInt2 != 2) && (paramInt2 != 3)) {
      localArrayList3.addAll(getCommonUsedSystemEmojiPanelData(paramIEmoticonMainPanelApp, paramInt1, paramBoolean));
    }
    localArrayList3.addAll(getSystemEmoticonPanelData(paramInt1, paramBoolean, localArrayList1));
    if (paramInt2 != 2) {
      localArrayList3.addAll(getEmojiEmoticonPanelData(paramInt1, localArrayList2));
    }
    return localArrayList3;
  }
  
  public static List<EmoticonInfo> getOldEmoticonList(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length + EmojiEmoticonInfo.EMOJI_COUNT);
    int j = EmojiEmoticonInfo.EMOJI_COUNT % 20;
    int i = EmojiEmoticonInfo.EMOJI_COUNT - 1;
    while (i >= EmojiEmoticonInfo.EMOJI_COUNT - j)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i, "", false));
      i -= 1;
    }
    i = 0;
    while (i < 20 - j)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
      i += 1;
    }
    i = EmojiEmoticonInfo.EMOJI_COUNT - j - 1;
    while (i >= 0)
    {
      if (QQSysAndEmojiResMgr.getInstance().getResImpl(2).checkEmoticonShouldHide(i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SystemAndEmojiEmoticonInfo", 2, new Object[] { "getOldEmoticonList hided:", Integer.valueOf(i), " ,type:", Integer.valueOf(2) });
        }
      }
      else {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i, "", false));
      }
      i -= 1;
    }
    j = paramArrayOfInt.length;
    i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (QQSysAndEmojiResMgr.getInstance().getResImpl(1).checkEmoticonShouldHide(k))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SystemAndEmojiEmoticonInfo", 2, new Object[] { "getOldEmoticonList hided:", Integer.valueOf(k), " ,type:", Integer.valueOf(1) });
        }
      }
      else {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, k, "", false));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<EmotionPanelData> getOnlySysEmoticonListFromConfig(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt, int[] paramArrayOfInt)
  {
    if (paramIEmoticonMainPanelApp == null)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getEmoticonList app = null");
      return null;
    }
    if (paramArrayOfInt != null)
    {
      paramIEmoticonMainPanelApp = paramArrayOfInt;
      if (paramArrayOfInt.length != 0) {}
    }
    else
    {
      paramIEmoticonMainPanelApp = SystemEmoticonInfo.getSysEmotionOrder();
    }
    paramArrayOfInt = new ArrayList(paramIEmoticonMainPanelApp.length);
    int j = 0;
    int i = 0;
    while (i < paramIEmoticonMainPanelApp.length)
    {
      paramArrayOfInt.add(Integer.valueOf(paramIEmoticonMainPanelApp[i]));
      i += 1;
    }
    paramIEmoticonMainPanelApp = new ArrayList(paramArrayOfInt.size());
    int k = paramArrayOfInt.size();
    i = 0;
    while (i < k)
    {
      Integer localInteger = (Integer)paramArrayOfInt.get(i);
      if (!TextUtils.isApolloEmoticon(localInteger.intValue())) {
        if (localInteger.intValue() == -1) {
          paramIEmoticonMainPanelApp.add(new SystemAndEmojiEmoticonInfo(7, 1, 0, "", false));
        } else {
          paramIEmoticonMainPanelApp.add(new SystemAndEmojiEmoticonInfo(7, 1, localInteger.intValue(), "", false));
        }
      }
      i += 1;
    }
    k = paramIEmoticonMainPanelApp.size() % paramInt;
    if (k > 0)
    {
      i = j;
      while (i < paramInt - k)
      {
        paramIEmoticonMainPanelApp.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
        i += 1;
      }
    }
    return paramIEmoticonMainPanelApp;
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
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return localArrayList;
      }
      int k = 0;
      int i = 0;
      while (i < paramInt)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, TITLE_SYSTEM, false));
        i += 1;
      }
      int m = paramArrayList.size();
      i = 0;
      int j = 0;
      while (i < m)
      {
        if ((paramBoolean) && (((Integer)paramArrayList.get(i)).intValue() > 255)) {
          j += 1;
        } else if (((Integer)paramArrayList.get(i)).intValue() == -1) {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, 0, "", false));
        } else {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, ((Integer)paramArrayList.get(i)).intValue(), "", false));
        }
        i += 1;
      }
      j = (paramArrayList.size() - j) % paramInt;
      if (j > 0)
      {
        i = k;
        while (i < paramInt - j)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public static List<EmotionPanelData> getUniversalEmoticonListFromConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = QQSysFaceUtil.getOrderList();
    ArrayList localArrayList2 = QQEmojiUtil.getOrderList();
    ArrayList localArrayList3 = new ArrayList(localArrayList1.size() + localArrayList2.size());
    if (paramBoolean1)
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((localAppRuntime instanceof BaseQQAppInterface)) {
        localArrayList3.addAll(getCommonUsedSystemEmojiPanelData(((IEmoticonMainPanelAppService)QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(localAppRuntime), paramInt, paramBoolean3));
      }
    }
    localArrayList3.addAll(getSystemEmoticonPanelData(paramInt, paramBoolean3, localArrayList1));
    if (paramBoolean2) {
      localArrayList3.addAll(getEmojiEmoticonPanelData(paramInt, localArrayList2));
    }
    return localArrayList3;
  }
  
  public static void preload(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = getEmoticonList(((IEmoticonMainPanelAppService)QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(paramAppRuntime), 0);
    if ((paramAppRuntime != null) && (paramAppRuntime.size() > 0))
    {
      int i = 0;
      while ((i < 84) && (i < paramAppRuntime.size()))
      {
        Object localObject = (EmotionPanelData)paramAppRuntime.get(i);
        if ((localObject instanceof SystemAndEmojiEmoticonInfo))
        {
          localObject = (SystemAndEmojiEmoticonInfo)localObject;
          if ((((SystemAndEmojiEmoticonInfo)localObject).type != 3) && (((SystemAndEmojiEmoticonInfo)localObject).code != -1))
          {
            localObject = (URLDrawable)((SystemAndEmojiEmoticonInfo)localObject).getDrawable(false);
            if ((localObject != null) && (((URLDrawable)localObject).getStatus() != 1)) {
              ((URLDrawable)localObject).startDownload();
            }
          }
        }
        i += 1;
      }
    }
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
    if (this.emotionType == 1)
    {
      int i = this.code;
      if (i != -1) {
        return TextUtils.getSysEmotcationDrawable(i, true);
      }
    }
    if ((this.emotionType == 2) && (this.code != -1)) {
      return super.getBigDrawable(paramContext, paramFloat);
    }
    return null;
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
    if ((1 == this.emotionType) && (this.code != -1)) {
      return QQSysFaceUtil.getFaceDrawable(paramInt);
    }
    if ((2 == this.emotionType) && (this.code != -1)) {
      return QQEmojiUtil.getEmojiDrawable(paramInt);
    }
    return null;
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    ((ISystemAndEmojiSenderService)QRoute.api(ISystemAndEmojiSenderService.class)).send(this, paramAppRuntime, paramContext, paramEditText, paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.emotionType);
    paramParcel.writeInt(this.code);
    paramParcel.writeString(this.title);
    paramParcel.writeByte((byte)this.isCommonUsed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */