package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class QFileUtils
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 * 1.0F / paramInt2 >= 1.777778F) {
      return 2;
    }
    return 1;
  }
  
  public static String a(long paramLong)
  {
    if (paramLong <= 0L) {
      return "00:00:00";
    }
    paramLong /= 1000L;
    String str1;
    String str2;
    if (paramLong / 3600L > 9L)
    {
      str1 = paramLong / 3600L + "";
      if (paramLong % 3600L / 60L <= 9L) {
        break label201;
      }
      str2 = paramLong % 3600L / 60L + "";
      label95:
      if (paramLong % 3600L % 60L <= 9L) {
        break label232;
      }
    }
    label201:
    label232:
    for (String str3 = paramLong % 3600L % 60L + "";; str3 = "0" + paramLong % 3600L % 60L)
    {
      return str1 + ":" + str2 + ":" + str3;
      str1 = "0" + paramLong / 3600L;
      break;
      str2 = "0" + paramLong % 3600L / 60L;
      break label95;
    }
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, TextView paramTextView1, TextView paramTextView2, String paramString1, String paramString2)
  {
    paramTextView1 = paramTextView1.getPaint();
    paramTextView2 = paramTextView2.getPaint();
    int i = AIOUtils.a(7.0F, paramContext.getResources());
    int j = (int)paramTextView2.measureText(paramString2);
    int k = AIOUtils.a(15.0F, paramContext.getResources());
    switch (paramInt1)
    {
    case 1: 
    default: 
      return paramString1;
    }
    return (String)TextUtils.ellipsize(paramString1, paramTextView1, paramInt2 - i * 2 - j - k, TextUtils.TruncateAt.END);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    int i;
    int j;
    if (paramFileManagerEntity != null)
    {
      i = paramFileManagerEntity.nOpType;
      j = paramFileManagerEntity.status;
    }
    return ((i != 21) && (i != 22) && (i != 24) && (i != 25) && (i != 28) && (i != 30)) || ((j != 0) && (j != 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QFileUtils
 * JD-Core Version:    0.7.0.1
 */