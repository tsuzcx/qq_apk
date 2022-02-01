package com.tencent.mobileqq.winkpublish.util;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckListUtil
{
  public static final String a = "CheckListUtil";
  
  public static ArrayList<String> a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if ((!TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString1.trim())))
    {
      String str = paramString1;
      if (paramBoolean) {
        str = paramString1.toLowerCase();
      }
      paramString1 = str.split(paramString2);
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        paramString2 = paramString1[i];
        if (!TextUtils.isEmpty(paramString2)) {
          localArrayList.add(paramString2.trim());
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static void a(String paramString)
  {
    QLog.i(a, 1, paramString);
  }
  
  private static void a(ArrayList<String> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start$$ ");
      Object localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append((String)((Iterator)localObject).next());
        localStringBuilder.append(" $#$ ");
      }
      localStringBuilder.append(" $$end");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(":size=%s, %s");
      a(String.format(((StringBuilder)localObject).toString(), new Object[] { Integer.valueOf(paramArrayList.size()), localStringBuilder.toString() }));
      return;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append(paramString);
    paramArrayList.append(": null or empty");
    a(paramArrayList.toString());
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(a(paramString1, paramString2, true), paramString3, paramString4);
  }
  
  public static boolean a(ArrayList<String> paramArrayList, String paramString1, String paramString2)
  {
    if (QCircleHostConstants._AppSetting.isDebugVersion()) {
      a(paramArrayList, String.format("[%s]", new Object[] { paramString2 }));
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return false;
      }
      paramString2 = paramString1;
      if (!TextUtils.isEmpty(paramString1)) {
        paramString2 = paramString1.trim();
      }
      return paramArrayList.contains(paramString2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.util.CheckListUtil
 * JD-Core Version:    0.7.0.1
 */