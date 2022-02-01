package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.net.Uri;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQFileUtils;
import com.tencent.mobileqq.qroute.QRoute;

public class QQFileUtils
{
  public static int a()
  {
    return d().getIPStackType();
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return d().getAIOFileBubbleShowType(paramInt1, paramInt2);
  }
  
  public static int a(String paramString)
  {
    return d().getIpAddrTypeOfUrl(paramString);
  }
  
  public static String a(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
      break;
    case 8: 
      str = "screen-dsc-";
      break;
    case 7: 
      str = "qxlarge-dsc-";
      break;
    case 6: 
      str = "xlarge-dsc-";
      break;
    case 5: 
      str = "qlarge-dsc-";
      break;
    case 4: 
      str = "large-dsc-";
      break;
    case 3: 
      str = "middle-dsc-";
      break;
    case 2: 
      str = "small-dsc-";
      break;
    case 1: 
      str = "minni-dsc-";
      break;
    case 0: 
      str = "micro-dsc-";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, TextView paramTextView1, TextView paramTextView2, String paramString1, String paramString2)
  {
    return d().getAIOFileBubbleShowName(paramContext, paramInt1, paramInt2, paramTextView1, paramTextView2, paramString1, paramString2);
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    d().setFileDescription(paramContext, paramTextView, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramTipsClickedInterface);
  }
  
  public static boolean a(Context paramContext, String paramString, Uri paramUri)
  {
    return d().copyFileToMediaStore(paramContext, paramString, paramUri);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return d().checkComplexMessage(paramMessageRecord);
  }
  
  public static int b()
  {
    return d().getReportIPStackType();
  }
  
  public static int b(String paramString)
  {
    return d().getIpAddrType(paramString);
  }
  
  public static int c()
  {
    return d().getReportLoginIPStackType();
  }
  
  private static IQFileUtils d()
  {
    return (IQFileUtils)QRoute.api(IQFileUtils.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileUtils
 * JD-Core Version:    0.7.0.1
 */