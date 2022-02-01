package com.tencent.mobileqq.qwallet.hb;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HbInfo
{
  public static final List<String> a = new ArrayList(Arrays.asList(new String[] { "4", "5", "7" }));
  public static final List<String> b = new ArrayList(Arrays.asList(new String[] { "1", "4", "5", "7" }));
  public static final List<String> c = new ArrayList(Arrays.asList(new String[] { "2", "3", "6", "", null }));
  public static final List<String> d = new ArrayList(Arrays.asList(new String[] { "2", "3", "", null }));
  public static final List<String> e = new ArrayList(Arrays.asList(new String[] { "2", "3" }));
  public static final List<String> f = new ArrayList(Arrays.asList(new String[] { "6" }));
  
  public static void a(Bundle paramBundle, HbInfo.BundleInfo paramBundleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    for (Object localObject1 = paramBundleInfo.getClass(); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      localArrayList.addAll(Arrays.asList(((Class)localObject1).getDeclaredFields()));
    }
    int i = 0;
    while (i < localArrayList.size())
    {
      localObject1 = (Field)localArrayList.get(i);
      String str1 = ((Field)localObject1).getName();
      String str2 = ((Field)localObject1).getType().getSimpleName();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("key = ");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(" tname = ");
      ((StringBuilder)localObject2).append(str2);
      QLog.i("HbInfo", 2, ((StringBuilder)localObject2).toString());
      localObject2 = paramBundle.getString(str1);
      if (localObject2 != null) {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("set ");
          localStringBuilder.append(str1);
          localStringBuilder.append(" = ");
          localStringBuilder.append((String)localObject2);
          QLog.i("HbInfo", 2, localStringBuilder.toString());
          if (str2.equals("String")) {
            ((Field)localObject1).set(paramBundleInfo, localObject2);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.HbInfo
 * JD-Core Version:    0.7.0.1
 */