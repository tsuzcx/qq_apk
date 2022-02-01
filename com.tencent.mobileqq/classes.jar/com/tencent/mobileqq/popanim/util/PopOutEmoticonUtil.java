package com.tencent.mobileqq.popanim.util;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PopOutEmoticonUtil
{
  public static SparseArray<String> a = new SparseArray();
  
  public static int a(int paramInt, View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return (paramInt - arrayOfInt[1] - paramView.getHeight()) / 2;
  }
  
  public static int a(View paramView, int paramInt)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1] - paramInt - 10;
  }
  
  public static String a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = (String)a.get(paramInt);
    if (localObject1 != null) {
      return localObject1;
    }
    int i = QQSysFaceUtil.convertToServer(paramInt);
    if (QQSysFaceUtil.isStaticFace(paramInt))
    {
      localObject1 = QQSysAndEmojiResMgr.getFullResPath(2, String.format("/s%d.png", new Object[] { Integer.valueOf(i) }));
    }
    else
    {
      if (paramBoolean) {
        localObject1 = QQSysAndEmojiResMgr.getFullResPath(4, String.format("/s%d.png", new Object[] { Integer.valueOf(i) }));
      } else {
        localObject1 = "";
      }
      if (!new File((String)localObject1).exists()) {
        localObject1 = QQSysAndEmojiResMgr.getFullResPath(1, String.format("/s%d.gif", new Object[] { Integer.valueOf(i) }));
      }
    }
    Object localObject2 = localObject1;
    if (!new File((String)localObject1).exists()) {
      if (EmotcationConstants.STATIC_SYS_EMOTCATION_RESOURCE.length > paramInt)
      {
        i = EmotcationConstants.STATIC_SYS_EMOTCATION_RESOURCE[paramInt];
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("id_");
        ((StringBuilder)localObject1).append(i);
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getEmoGifPath can not find any emoticonPath |localId=");
          ((StringBuilder)localObject2).append(paramInt);
          QLog.e("PopOutEmoticonUtil", 1, ((StringBuilder)localObject2).toString());
          localObject2 = localObject1;
        }
      }
    }
    if (paramBoolean) {
      a.put(paramInt, localObject2);
    }
    return localObject2;
  }
  
  public static void a(View paramView)
  {
    if (paramView.getParent() == null) {
      return;
    }
    ((ViewGroup)paramView.getParent()).removeView(paramView);
  }
  
  public static void a(ViewGroup paramViewGroup, View paramView)
  {
    if (paramView.getParent() != null)
    {
      if (paramView.getParent() != paramViewGroup)
      {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
        paramViewGroup.addView(paramView);
      }
    }
    else {
      paramViewGroup.addView(paramView);
    }
    paramView.bringToFront();
  }
  
  public static boolean a(int paramInt1, EmoticonInfo paramEmoticonInfo, int paramInt2)
  {
    if (paramEmoticonInfo == null) {
      return false;
    }
    boolean bool;
    if (paramInt2 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramInt1 == 0) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if (QLog.isColorLevel())
    {
      paramEmoticonInfo = new StringBuilder();
      paramEmoticonInfo.append("supportPopOutEmoticon isC2C=");
      paramEmoticonInfo.append(bool);
      paramEmoticonInfo.append(" emoPanelType=");
      paramEmoticonInfo.append(paramInt1);
      QLog.d("PopOutEmoticonUtil", 4, paramEmoticonInfo.toString());
    }
    return (bool) && (paramInt2 != 0);
  }
  
  public static boolean a(int paramInt, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(EmoticonInfo paramEmoticonInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEmoticonInfo != null)
    {
      bool1 = bool2;
      if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
      {
        bool1 = bool2;
        if (((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).emotionType == 2) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.util.PopOutEmoticonUtil
 * JD-Core Version:    0.7.0.1
 */