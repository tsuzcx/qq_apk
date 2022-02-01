package com.tencent.mobileqq.emoticonview;

import alnr;
import amtj;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import arev;
import bcef;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class SystemAndEmojiEmoticonInfo
  extends EmoticonInfo
{
  public static final int BLANK_FILLING_EMOTION_CODE = -1;
  public static final int EMOTICON_EMOJI_PAGE_COUNT;
  public static final String TAG = "SystemAndEmojiEmoticonInfo";
  public static final String TITLE_EMOJI;
  public static final String TITLE_OFTEN = amtj.a(2131713734);
  public static final String TITLE_SYSTEM = amtj.a(2131713737);
  public static final int TYPE_EMOJI = 2;
  public static final int TYPE_SYSTEM = 1;
  public static final int TYPE_TITLE = 3;
  public int code;
  public int emotionType;
  public boolean isCommonUsed;
  private Drawable mDefault;
  public String title;
  
  static
  {
    TITLE_EMOJI = amtj.a(2131713736);
    int j = EmojiEmoticonInfo.EMOJI_COUNT / 20;
    if (EmojiEmoticonInfo.EMOJI_COUNT % 20 == 0) {}
    for (int i = 0;; i = 1)
    {
      EMOTICON_EMOJI_PAGE_COUNT = i + j;
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
  
  public static List<EmotionPanelData> getCommonUsedSystemEmojiPanelData(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return getCommonUsedSystemEmojiPanelData(paramQQAppInterface, paramInt, false);
  }
  
  public static List<EmotionPanelData> getCommonUsedSystemEmojiPanelData(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramQQAppInterface == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, TITLE_OFTEN, false));
      i += 1;
    }
    paramQQAppInterface = ((CommonUsedSystemEmojiManager)paramQQAppInterface.getManager(172)).getCommonUsedSystemEmojiInfo();
    int j;
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 1))
    {
      j = 0;
      i = 0;
      if ((j >= paramQQAppInterface.size()) || (i >= paramInt * 3))
      {
        if (i >= paramInt * 3) {
          break label269;
        }
        j = i % paramInt;
        if (j == 0) {
          break label269;
        }
        i = 0;
      }
    }
    while (i < paramInt - j)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
      i += 1;
      continue;
      EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramQQAppInterface.get(j);
      int k = 1;
      if (localSmallYellowItem.type.get() == 2) {
        k = 2;
      }
      if ((paramBoolean) && (k == 1) && (localSmallYellowItem.id.get() > 255)) {}
      for (;;)
      {
        j += 1;
        break;
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, k, localSmallYellowItem.id.get(), "", true));
        i += 1;
      }
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "CommonlyUsedSystemEmoji IS NULL");
    }
    label269:
    return localArrayList;
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
  
  public static List<EmotionPanelData> getEmoticonList(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return getEmoticonListFromConfig(paramQQAppInterface, false, 7, paramInt);
  }
  
  public static List<EmotionPanelData> getEmoticonList(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getEmoticonList app = null");
      return null;
    }
    SystemEmoticonInfo.parseWhiteList(paramQQAppInterface, false);
    int[] arrayOfInt = SystemEmoticonInfo.getSysEmotionOrder();
    ArrayList localArrayList = new ArrayList(arrayOfInt.length + EmojiEmoticonInfo.EMOJI_COUNT);
    int i;
    if ((paramInt2 != 2) && (paramInt2 != 3))
    {
      i = 0;
      while (i < paramInt1)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, TITLE_OFTEN, false));
        i += 1;
      }
      paramQQAppInterface = ((CommonUsedSystemEmojiManager)paramQQAppInterface.getManager(172)).getCommonUsedSystemEmojiInfo();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SystemAndEmojiEmoticonInfo", 2, "getEmoticonList commonusedsize = " + paramQQAppInterface.size());
        }
        i = paramQQAppInterface.size();
        if (i <= paramInt1 * 3) {
          break label573;
        }
        i = paramInt1 * 3;
      }
    }
    label573:
    for (;;)
    {
      int j = 0;
      while (j < i)
      {
        EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramQQAppInterface.get(j);
        int k = 1;
        if (localSmallYellowItem.type.get() == 2) {
          k = 2;
        }
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, k, localSmallYellowItem.id.get(), "", true));
        j += 1;
      }
      if (i < paramInt1 * 3)
      {
        j = i % paramInt1;
        if (j != 0)
        {
          i = 0;
          while (i < paramInt1 - j)
          {
            localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
            i += 1;
            continue;
            QLog.e("SystemAndEmojiEmoticonInfo", 1, "CommonlyUsedSystemEmoji IS NULL");
          }
        }
      }
      i = 0;
      while (i < paramInt1)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, TITLE_SYSTEM, false));
        i += 1;
      }
      j = arrayOfInt.length;
      i = 0;
      while (i < j)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, arrayOfInt[i], "", false));
        i += 1;
      }
      j = arrayOfInt.length % paramInt1;
      if (j > 0)
      {
        i = 0;
        while (i < j)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
          i += 1;
        }
      }
      if (paramInt2 != 2)
      {
        paramInt2 = 0;
        while (paramInt2 < paramInt1)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, TITLE_EMOJI, false));
          paramInt2 += 1;
        }
        paramInt2 = 0;
        while (paramInt2 < EmojiEmoticonInfo.EMOJI_COUNT)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, paramInt2, "", false));
          paramInt2 += 1;
        }
        paramInt2 = EmojiEmoticonInfo.EMOJI_COUNT % paramInt1;
        if (paramInt2 > 0)
        {
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
            paramInt1 += 1;
          }
        }
      }
      return localArrayList;
    }
  }
  
  public static List<EmotionPanelData> getEmoticonListFromConfig(QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getEmoticonList app = null");
      paramQQAppInterface = null;
    }
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    do
    {
      return paramQQAppInterface;
      ArrayList localArrayList3 = QQSysFaceUtil.getOrderList();
      localArrayList2 = QQEmojiUtil.getOrderList();
      localArrayList1 = new ArrayList(localArrayList3.size() + localArrayList2.size());
      if ((paramInt2 != 2) && (paramInt2 != 3)) {
        localArrayList1.addAll(getCommonUsedSystemEmojiPanelData(paramQQAppInterface, paramInt1, paramBoolean));
      }
      localArrayList1.addAll(getSystemEmoticonPanelData(paramInt1, paramBoolean, localArrayList3));
      paramQQAppInterface = localArrayList1;
    } while (paramInt2 == 2);
    localArrayList1.addAll(getEmojiEmoticonPanelData(paramInt1, localArrayList2));
    return localArrayList1;
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
    if (i >= 0)
    {
      if (arev.a().a(2).b(i)) {
        if (QLog.isColorLevel()) {
          QLog.d("SystemAndEmojiEmoticonInfo", 2, new Object[] { "getOldEmoticonList hided:", Integer.valueOf(i), " ,type:", Integer.valueOf(2) });
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i, "", false));
      }
    }
    j = paramArrayOfInt.length;
    i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      if (arev.a().a(1).b(k)) {
        if (QLog.isColorLevel()) {
          QLog.d("SystemAndEmojiEmoticonInfo", 2, new Object[] { "getOldEmoticonList hided:", Integer.valueOf(k), " ,type:", Integer.valueOf(1) });
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, k, "", false));
      }
    }
    return localArrayList;
  }
  
  public static List<EmotionPanelData> getOnlySysEmoticonListFromConfig(QQAppInterface paramQQAppInterface, int paramInt, int[] paramArrayOfInt)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getEmoticonList app = null");
      return null;
    }
    if (paramArrayOfInt != null)
    {
      paramQQAppInterface = paramArrayOfInt;
      if (paramArrayOfInt.length != 0) {}
    }
    else
    {
      paramQQAppInterface = SystemEmoticonInfo.getSysEmotionOrder();
    }
    paramArrayOfInt = new ArrayList(paramQQAppInterface.length);
    int i = 0;
    while (i < paramQQAppInterface.length)
    {
      paramArrayOfInt.add(Integer.valueOf(paramQQAppInterface[i]));
      i += 1;
    }
    paramQQAppInterface = new ArrayList(paramArrayOfInt.size());
    int j = paramArrayOfInt.size();
    i = 0;
    if (i < j)
    {
      Integer localInteger = (Integer)paramArrayOfInt.get(i);
      if (com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(localInteger.intValue())) {}
      for (;;)
      {
        i += 1;
        break;
        if (localInteger.intValue() == -1) {
          paramQQAppInterface.add(new SystemAndEmojiEmoticonInfo(7, 1, 0, "", false));
        } else {
          paramQQAppInterface.add(new SystemAndEmojiEmoticonInfo(7, 1, localInteger.intValue(), "", false));
        }
      }
    }
    j = paramQQAppInterface.size() % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        paramQQAppInterface.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
        i += 1;
      }
    }
    return paramQQAppInterface;
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
    ArrayList localArrayList1 = QQSysFaceUtil.getOrderList();
    ArrayList localArrayList2 = QQEmojiUtil.getOrderList();
    ArrayList localArrayList3 = new ArrayList(localArrayList1.size() + localArrayList2.size());
    if (paramBoolean1)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        localArrayList3.addAll(getCommonUsedSystemEmojiPanelData((QQAppInterface)localAppRuntime, paramInt, paramBoolean3));
      }
    }
    localArrayList3.addAll(getSystemEmoticonPanelData(paramInt, paramBoolean3, localArrayList1));
    if (paramBoolean2) {
      localArrayList3.addAll(getEmojiEmoticonPanelData(paramInt, localArrayList2));
    }
    return localArrayList3;
  }
  
  public static void preload(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = getEmoticonList(paramQQAppInterface, 0);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      int i = 0;
      while ((i < 84) && (i < paramQQAppInterface.size()))
      {
        Object localObject = (EmotionPanelData)paramQQAppInterface.get(i);
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
  
  public void addToCommonUsed(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    EmosmPb.SmallYellowItem localSmallYellowItem = new EmosmPb.SmallYellowItem();
    localSmallYellowItem.id.set(this.code);
    if (this.emotionType == 1) {}
    for (int i = 1;; i = 2)
    {
      localSmallYellowItem.type.set(i);
      long l = System.currentTimeMillis();
      localSmallYellowItem.ts.set(l);
      String str2 = "";
      String str1 = str2;
      if (paramSessionInfo != null)
      {
        str1 = str2;
        if (!android.text.TextUtils.isEmpty(paramSessionInfo.troopUin)) {
          str1 = paramSessionInfo.troopUin;
        }
      }
      QLog.d("SystemAndEmojiEmoticonInfo", 1, "send saveemoji type = " + i + ";id = " + this.code + ";ts = " + l + ";troopUin = " + str1);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (CommonUsedSystemEmojiManager)paramQQAppInterface.getManager(172);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.saveSystemEmojiInfoToCahce(localSmallYellowItem);
        }
      }
      return;
    }
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.emotionType == 1) && (this.code != -1)) {
      localObject1 = com.tencent.mobileqq.text.TextUtils.getSysEmotcationDrawable(this.code, true);
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
  
  public void send(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if (this.code == -1) {
      return;
    }
    int i = paramEditText.getSelectionStart();
    int j = paramEditText.getSelectionEnd();
    Editable localEditable = paramEditText.getEditableText();
    if (this.emotionType == 1) {}
    for (paramContext = com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(this.code);; paramContext = com.tencent.mobileqq.text.TextUtils.getEmojiString(this.code))
    {
      localEditable.replace(i, j, paramContext);
      paramEditText.requestFocus();
      addToCommonUsed(paramQQAppInterface, paramSessionInfo);
      if (this.isCommonUsed) {
        bcef.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800717F", 0, 0, this.emotionType + "", this.code + "", "", "");
      }
      if ((paramQQAppInterface != null) && (com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(this.code)) && (paramSessionInfo != null)) {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "0X800812C", ApolloUtil.b(paramSessionInfo.curType), 0, new String[] { String.valueOf(this.code), String.valueOf(alnr.a(paramQQAppInterface)) });
      }
      arev.a().a(this.emotionType).a(this.code, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */