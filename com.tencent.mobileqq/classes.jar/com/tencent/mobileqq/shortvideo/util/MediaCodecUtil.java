package com.tencent.mobileqq.shortvideo.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MediaCodecUtil
{
  public static final List<String> a = Arrays.asList(new String[] { "VIVO X7", "VIVO XPLAY5A", "VIVO X6SPLUS", "VIVO X6S A", "REDMI NOTE 3", "REDMI NOTE 4X", "MI 5", "MI-4C", "CAM-AL00", "MLA-AL10", "CAZ-AL10", "VNS-AL00" });
  
  public static boolean a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Build.MANUFACTURER);
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append(Build.MODEL);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = "Meizu;PRO 6 Plus|samsung;SM-G9250|samsung;SM-G955FD|HUAWEI;CAM-TL00|OPPO;OPPO A37m|OPPO;OPPO A59s|samsung;SM-G9280|samsung;SM-G9200|samsung;SM-G955F|Meizu;Meizu S6".split("\\|");
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        if ((localObject3 != null) && (localObject3.equals(localObject1)))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("isFollowBlackPhone true: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("MediaCodecUtil", 2, ((StringBuilder)localObject2).toString());
          }
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    int i = Build.VERSION.SDK_INT;
    if ((i == 22) || (i == 23) || (i == 24))
    {
      String str = Build.MODEL.toUpperCase();
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        if (str.contains((String)localIterator.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean c()
  {
    return (Build.MANUFACTURER.toLowerCase().contains("samsung")) && (Build.VERSION.SDK_INT == 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.MediaCodecUtil
 * JD-Core Version:    0.7.0.1
 */