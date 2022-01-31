package com.tencent.mobileqq.leba.header;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.leba.view.LebaGridMenuView;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LebaGridUtils
{
  public static int a(int paramInt)
  {
    return paramInt / 100;
  }
  
  public static int a(int paramInt, List paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if ((((LebaGridItemInfo)paramList.get(i)).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null) && (paramInt == ((LebaGridItemInfo)paramList.get(i)).jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    int i = AIOUtils.a(85.0F, paramContext.getResources());
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext != null) {
      return paramContext.getDefaultDisplay().getWidth() / paramInt;
    }
    return i;
  }
  
  public static Bitmap a(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    if ((i > 150) && (j > 150))
    {
      int k = i / 150;
      j /= 150;
      if (k <= j) {
        break label92;
      }
      i = j;
    }
    label92:
    for (;;)
    {
      localOptions.inSampleSize = i;
      localOptions.inJustDecodeBounds = false;
      return BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
    }
  }
  
  public static LebaGridItemInfo a(int paramInt, List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LebaGridItemInfo localLebaGridItemInfo = (LebaGridItemInfo)paramList.next();
      if ((localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null) && (localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pluginId == paramInt)) {
        return localLebaGridItemInfo;
      }
    }
    return null;
  }
  
  public static File a(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString2;
      if (paramString2.startsWith("http://"))
      {
        paramString1 = paramString2;
        if (paramString2.length() > 7) {
          paramString1 = paramString2.substring(7);
        }
      }
      paramString1 = StringUtil.e(paramString1);
    }
    return paramContext.getFileStreamPath(paramString1);
  }
  
  public static void a(LebaGridMenuView paramLebaGridMenuView, List paramList)
  {
    int[] arrayOfInt = paramLebaGridMenuView.a();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      if ((arrayOfInt[i] == 1) && (!a(paramList, i))) {
        paramLebaGridMenuView.a(i);
      }
      i += 1;
    }
  }
  
  public static void a(List paramList1, List paramList2)
  {
    Collections.sort(paramList2, new LebaGridUtils.LebaItemComparator());
    paramList2 = paramList2.iterator();
    int i = 0;
    int j = -1;
    if (paramList2.hasNext())
    {
      LebaGridItemInfo localLebaGridItemInfo = (LebaGridItemInfo)paramList2.next();
      if (a(localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.weight) != j)
      {
        new LebaGridItemInfo();
        if (paramList1.size() > 0)
        {
          if (i < 2) {
            ((LebaGridItemInfo)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;
          }
        }
        else
        {
          label100:
          j = a(localLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.weight);
          localLebaGridItemInfo.jdField_a_of_type_Int = 1;
          i = 1;
        }
      }
      for (;;)
      {
        paramList1.add(localLebaGridItemInfo);
        break;
        ((LebaGridItemInfo)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2;
        break label100;
        i += 1;
        localLebaGridItemInfo.jdField_a_of_type_Int = 3;
      }
    }
    if (paramList1.size() > 0)
    {
      if (i < 2) {
        ((LebaGridItemInfo)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    ((LebaGridItemInfo)paramList1.get(paramList1.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  public static boolean a(LebaGridItemInfo paramLebaGridItemInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName)) {
      if (!"com.android.qzone".equals(paramLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName))
      {
        bool1 = bool2;
        if (!"qzone_feedlist".equals(paramLebaGridItemInfo.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    return paramString.startsWith("http");
  }
  
  public static boolean a(List paramList, int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramList.size())
      {
        LebaGridItemInfo localLebaGridItemInfo = (LebaGridItemInfo)paramList.get(i);
        if ((localLebaGridItemInfo.c == paramInt) && (localLebaGridItemInfo.b == 1)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.header.LebaGridUtils
 * JD-Core Version:    0.7.0.1
 */