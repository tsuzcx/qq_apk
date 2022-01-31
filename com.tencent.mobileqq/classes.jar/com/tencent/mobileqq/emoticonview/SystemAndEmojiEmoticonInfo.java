package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SystemAndEmojiEmoticonInfo
  extends EmoticonInfo
{
  public static final int f;
  public static final int g;
  public int a;
  private Drawable a;
  public boolean a;
  public int b;
  public String c;
  
  static
  {
    int j = 0;
    int k = SystemEmoticonInfo.a.length / 20;
    if (SystemEmoticonInfo.a.length % 20 == 0)
    {
      i = 0;
      f = i + k;
      k = EmojiEmoticonInfo.jdField_b_of_type_Int / 20;
      if (EmojiEmoticonInfo.jdField_b_of_type_Int % 20 != 0) {
        break label58;
      }
    }
    label58:
    for (int i = j;; i = 1)
    {
      g = k + i;
      return;
      i = 1;
      break;
    }
  }
  
  public SystemAndEmojiEmoticonInfo(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static List a()
  {
    ArrayList localArrayList = new ArrayList(SystemEmoticonInfo.a.length + EmojiEmoticonInfo.jdField_b_of_type_Int);
    int j = EmojiEmoticonInfo.jdField_b_of_type_Int % 20;
    int i = EmojiEmoticonInfo.jdField_b_of_type_Int - 1;
    while (i >= EmojiEmoticonInfo.jdField_b_of_type_Int - j)
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
    i = EmojiEmoticonInfo.jdField_b_of_type_Int - j - 1;
    while (i >= 0)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i, "", false));
      i -= 1;
    }
    j = SystemEmoticonInfo.a.length;
    i = 0;
    while (i < j)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, SystemEmoticonInfo.a[i], "", false));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getEmoticonList app = null");
      return null;
    }
    ArrayList localArrayList = new ArrayList(SystemEmoticonInfo.a.length + EmojiEmoticonInfo.jdField_b_of_type_Int);
    int i = 0;
    while (i < 7)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, "常用", false));
      i += 1;
    }
    paramQQAppInterface = ((CommonUsedSystemEmojiManager)paramQQAppInterface.getManager(171)).a();
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SystemAndEmojiEmoticonInfo", 2, "getEmoticonList commonusedsize = " + paramQQAppInterface.size());
      }
      i = paramQQAppInterface.size();
      if (i <= 21) {
        break label536;
      }
      i = 21;
    }
    label536:
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
      if (i < 21)
      {
        j = i % 7;
        if (j != 0)
        {
          i = 0;
          while (i < 7 - j)
          {
            localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
            i += 1;
            continue;
            QLog.e("SystemAndEmojiEmoticonInfo", 1, "CommonlyUsedSystemEmoji IS NULL");
          }
        }
      }
      i = 0;
      while (i < 7)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, "全部", false));
        i += 1;
      }
      j = SystemEmoticonInfo.a.length;
      i = 0;
      while (i < j)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, SystemEmoticonInfo.a[i], "", false));
        i += 1;
      }
      j = SystemEmoticonInfo.a.length % 7;
      if (j > 0)
      {
        i = 0;
        while (i < j)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
          i += 1;
        }
      }
      i = 0;
      while (i < 7)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, "emoji", false));
        i += 1;
      }
      i = 0;
      while (i < EmojiEmoticonInfo.jdField_b_of_type_Int)
      {
        localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i, "", false));
        i += 1;
      }
      j = EmojiEmoticonInfo.jdField_b_of_type_Int % 7;
      if (j > 0)
      {
        i = 0;
        while (i < j)
        {
          localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
          i += 1;
        }
      }
      return localArrayList;
    }
  }
  
  public Drawable a(int paramInt, boolean paramBoolean)
  {
    int i;
    if ((1 == this.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int != -1))
    {
      if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_a_of_type_Int)) {
        throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
      }
      i = EmotcationConstants.jdField_b_of_type_ArrayOfInt[paramInt];
    }
    while (i == -1)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getSystemEmojiStaticImg index error 11; index = " + paramInt);
      return null;
      if ((2 == this.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int != -1))
      {
        if (paramInt < 0) {
          throw new IllegalArgumentException("invaid emoji index: " + paramInt);
        }
        if ((paramInt >= 0) && (paramInt < EmotcationConstants.jdField_b_of_type_Int)) {
          i = 2130839808 + paramInt;
        } else {
          QLog.e("SystemAndEmojiEmoticonInfo", 1, "getSystemEmojiStaticImg index error; index = " + paramInt);
        }
      }
      else
      {
        i = -1;
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplication.getContext().getResources().getDrawable(2130837579);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          URL localURL = new URL("protocol_vas_extension_image", "RESOURCE_IMG", i + "");
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localURLDrawableOptions.mUseThreadPool = paramBoolean;
          return URLDrawable.getDrawable(localURL, localURLDrawableOptions);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          QLog.e("SystemAndEmojiEmoticonInfo", 1, "getSystemEmojiStaticImg url exception e = " + localMalformedURLException.getMessage());
        }
        localException = localException;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        QLog.e("SystemAndEmojiEmoticonInfo", 1, "SystemAndEmojiEmoticonInfo getdrawable exception e: = " + localException.getMessage());
      }
    }
    return null;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return a(this.jdField_b_of_type_Int, true);
  }
  
  public Drawable a(boolean paramBoolean)
  {
    return a(this.jdField_b_of_type_Int, paramBoolean);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if (this.jdField_b_of_type_Int == -1) {}
    label93:
    do
    {
      return;
      i = paramEditText.getSelectionStart();
      j = paramEditText.getSelectionEnd();
      Object localObject = paramEditText.getEditableText();
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
      paramContext = com.tencent.mobileqq.text.TextUtils.c(this.jdField_b_of_type_Int);
      ((Editable)localObject).replace(i, j, paramContext);
      paramEditText.requestFocus();
      localObject = new EmosmPb.SmallYellowItem();
      ((EmosmPb.SmallYellowItem)localObject).id.set(this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Int != 1) {
        break label397;
      }
      i = 1;
      ((EmosmPb.SmallYellowItem)localObject).type.set(i);
      long l = System.currentTimeMillis();
      ((EmosmPb.SmallYellowItem)localObject).ts.set(l);
      paramEditText = "";
      paramContext = paramEditText;
      if (paramSessionInfo != null)
      {
        paramContext = paramEditText;
        if (!android.text.TextUtils.isEmpty(paramSessionInfo.b)) {
          paramContext = paramSessionInfo.b;
        }
      }
      QLog.d("SystemAndEmojiEmoticonInfo", 1, "send saveemoji type = " + i + ";id = " + this.jdField_b_of_type_Int + ";ts = " + l + ";troopUin = " + paramContext);
      if (paramQQAppInterface != null)
      {
        paramContext = (CommonUsedSystemEmojiManager)paramQQAppInterface.getManager(171);
        if (paramContext != null) {
          paramContext.a((EmosmPb.SmallYellowItem)localObject);
        }
      }
      if (this.jdField_a_of_type_Boolean) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800717F", 0, 0, this.jdField_a_of_type_Int + "", this.jdField_b_of_type_Int + "", "", "");
      }
    } while ((paramQQAppInterface == null) || (!com.tencent.mobileqq.text.TextUtils.a(this.jdField_b_of_type_Int)) || (paramSessionInfo == null));
    int i = ApolloUtil.b(paramSessionInfo.jdField_a_of_type_Int);
    int j = this.jdField_b_of_type_Int;
    if (ApolloGameUtil.a(paramQQAppInterface)) {}
    for (paramContext = "1";; paramContext = "0")
    {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "0X800812C", i, 0, new String[] { String.valueOf(j), paramContext });
      return;
      paramContext = com.tencent.mobileqq.text.TextUtils.a(this.jdField_b_of_type_Int);
      break;
      label397:
      i = 2;
      break label93;
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int != -1)) {
      localObject1 = com.tencent.mobileqq.text.TextUtils.a(this.jdField_b_of_type_Int, true);
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.jdField_a_of_type_Int != 2);
      localObject1 = localObject2;
    } while (this.jdField_b_of_type_Int == -1);
    return super.b(paramContext, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */