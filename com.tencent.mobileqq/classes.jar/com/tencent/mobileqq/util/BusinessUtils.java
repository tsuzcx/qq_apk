package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class BusinessUtils
  extends Utils
{
  public static ArrayList<String> a(String paramString, int paramInt1, int paramInt2, ArrayList<AtTroopMemberInfo> paramArrayList, ArrayList<ArrayList<AtTroopMemberInfo>> paramArrayList1)
  {
    String str1 = paramString;
    ArrayList localArrayList = new ArrayList();
    int i3 = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    Object localObject1 = null;
    int i = 0;
    int n = 0;
    int m = 0;
    for (;;)
    {
      Object localObject2 = paramArrayList;
      if (j >= i3) {
        break;
      }
      int i2 = str1.codePointAt(j);
      int k = i;
      if (localObject2 != null) {
        for (;;)
        {
          k = i;
          if (i >= paramArrayList.size()) {
            break;
          }
          localAtTroopMemberInfo = (AtTroopMemberInfo)((ArrayList)localObject2).get(i);
          if ((localAtTroopMemberInfo != null) && (localAtTroopMemberInfo.isValid()))
          {
            k = i;
            break label127;
          }
          i += 1;
        }
      }
      AtTroopMemberInfo localAtTroopMemberInfo = null;
      label127:
      String str2;
      int i1;
      if ((localAtTroopMemberInfo != null) && (localAtTroopMemberInfo.startPos == j))
      {
        str2 = str1.substring(localAtTroopMemberInfo.startPos, localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen);
        i = f(str2);
        localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + n));
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localAtTroopMemberInfo);
        k += 1;
        i1 = i + 11 + 8;
        localObject1 = localObject2;
      }
      else
      {
        if (i2 == 20)
        {
          i = j + 1;
          if ((i < i3) && ((str1.charAt(i) == 'ÿ') || (str1.charAt(i) == 'ǿ'))) {
            i = 20;
          } else if ((i < i3) && (str1.charAt(i) >= 'Ą')) {
            i = 40;
          } else {
            i = 12;
          }
        }
        else
        {
          i = b(i2);
        }
        str2 = null;
        i1 = i;
      }
      m += i1;
      if (m > paramInt1)
      {
        str1 = localStringBuilder.toString();
        if (localObject1 == null)
        {
          int i4 = str1.length() - paramInt2;
          m = 0;
          i = -1;
          while (m < a.length)
          {
            i = str1.lastIndexOf(a[m]);
            if (i > i4) {
              break;
            }
            m += 1;
          }
          m = str1.lastIndexOf('\024');
          if ((i > i4) && (m == -1))
          {
            i += 1;
            str1 = localStringBuilder.substring(0, i);
            localObject2 = localStringBuilder.substring(i);
            localStringBuilder.setLength(0);
            m = f((String)localObject2);
            localStringBuilder.append((String)localObject2);
            break label615;
          }
          int i5 = m - 2;
          if (i5 >= 0)
          {
            i = m;
            if (str1.charAt(m - 1) == 'ÿ')
            {
              i = m;
              if (str1.charAt(i5) == '\024') {
                i = m - 2;
              }
            }
          }
          else
          {
            i = m;
          }
          if (i > i4)
          {
            str1 = localStringBuilder.substring(0, i);
            localObject2 = localStringBuilder.substring(i);
            localStringBuilder.setLength(0);
            m = f((String)localObject2);
            localStringBuilder.append((String)localObject2);
            break label615;
          }
          localStringBuilder.setLength(0);
        }
        else
        {
          localStringBuilder.setLength(0);
        }
        m = 0;
        label615:
        n -= str1.length();
        localArrayList.add(str1);
        paramArrayList1.add(localObject1);
        if (str2 != null)
        {
          localStringBuilder.append(str2);
          j += localAtTroopMemberInfo.textLen - 1;
        }
        for (;;)
        {
          break;
          if (i2 > 65535)
          {
            localStringBuilder.appendCodePoint(i2);
            j += 1;
          }
          else
          {
            localStringBuilder.append((char)i2);
          }
        }
        if (i2 == 20)
        {
          i = j + 1;
          if (i >= i3)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("there is no other char behind EMO_HEAD_CODE,msg is:");
              ((StringBuilder)localObject1).append(paramString);
              QLog.e("TroopMemberUtil", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            localObject1 = paramString;
            if ('ÿ' == ((String)localObject1).charAt(i))
            {
              i2 = j + 4;
              if (i2 < i3)
              {
                localStringBuilder.append(((String)localObject1).charAt(i));
                localStringBuilder.append(((String)localObject1).charAt(j + 2));
                localStringBuilder.append(((String)localObject1).charAt(j + 3));
                localStringBuilder.append(((String)localObject1).charAt(i2));
                i = i2;
                break label881;
              }
            }
            else
            {
              localStringBuilder.append(((String)localObject1).charAt(i));
              break label881;
            }
          }
        }
        i = j;
        label881:
        str1 = paramString;
        m += i1;
        localObject1 = null;
      }
      else
      {
        if (str2 != null)
        {
          localStringBuilder.append(str2);
          j += localAtTroopMemberInfo.textLen - 1;
        }
        for (;;)
        {
          break;
          if (i2 > 65535)
          {
            localStringBuilder.appendCodePoint(i2);
            j += 1;
          }
          else
          {
            localStringBuilder.append((char)i2);
          }
        }
        if (i2 == 20)
        {
          i = j + 1;
          if (i >= i3)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("there is no other char behind EMO_HEAD_CODE,msg is:");
              ((StringBuilder)localObject2).append(str1);
              QLog.e("TroopMemberUtil", 2, ((StringBuilder)localObject2).toString());
            }
          }
          else if ('ÿ' == str1.charAt(i))
          {
            i1 = j + 4;
            if (i1 < i3)
            {
              localStringBuilder.append(str1.charAt(i));
              localStringBuilder.append(str1.charAt(j + 2));
              localStringBuilder.append(str1.charAt(j + 3));
              localStringBuilder.append(str1.charAt(i1));
              i = i1;
              break label1135;
            }
          }
          else
          {
            localStringBuilder.append(str1.charAt(i));
            break label1135;
          }
        }
        i = j;
      }
      label1135:
      j = i + 1;
      i = k;
    }
    if (localStringBuilder.length() > 0)
    {
      localArrayList.add(localStringBuilder.toString());
      paramArrayList1.add(localObject1);
    }
    return localArrayList;
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      return;
    }
    ThreadManager.postImmediately(new BusinessUtils.1((QQAppInterface)paramAppRuntime), null, false);
    try
    {
      StatisticCollector.getInstance(BaseApplicationImpl.sApplication).setContact(paramString);
      QQCrashReportManager.a(paramString);
    }
    catch (Throwable paramAppRuntime)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loginSuccess throwable: ");
        localStringBuilder.append(paramAppRuntime);
        QLog.d("login", 2, localStringBuilder.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("loginSuccess set CURRENT_ACCOUNT: ");
      paramAppRuntime.append(paramString);
      QLog.d("login", 2, paramAppRuntime.toString());
    }
    SharedPreUtils.a(BaseApplicationImpl.sApplication, paramString, true);
    BaseApplicationImpl.sApplication.refreAccountList();
  }
  
  public static boolean a(Context paramContext)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(d)) && (!TextUtils.isEmpty(d.trim())))
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", Utils.d.trim());
      paramContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.BusinessUtils
 * JD-Core Version:    0.7.0.1
 */