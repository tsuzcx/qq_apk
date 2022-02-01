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
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class BusinessUtils
  extends Utils
{
  public static ArrayList<String> a(String paramString, int paramInt1, int paramInt2, ArrayList<AtTroopMemberInfo> paramArrayList, ArrayList<ArrayList<AtTroopMemberInfo>> paramArrayList1)
  {
    ArrayList localArrayList2 = new ArrayList();
    int i2 = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    ArrayList localArrayList1 = null;
    int i1 = 0;
    int k = 0;
    int n = 0;
    int i3;
    int j;
    label62:
    AtTroopMemberInfo localAtTroopMemberInfo;
    String str1;
    label171:
    label195:
    String str2;
    int i4;
    String str3;
    if (k < i2)
    {
      i3 = paramString.codePointAt(k);
      j = i;
      if (paramArrayList == null) {
        break label1152;
      }
      j = i;
      if (i >= paramArrayList.size()) {
        break label1152;
      }
      localAtTroopMemberInfo = (AtTroopMemberInfo)paramArrayList.get(i);
      if ((localAtTroopMemberInfo != null) && (localAtTroopMemberInfo.isValid()))
      {
        if ((localAtTroopMemberInfo == null) || (localAtTroopMemberInfo.startPos != k)) {
          break label476;
        }
        str1 = paramString.substring(localAtTroopMemberInfo.startPos, localAtTroopMemberInfo.startPos + localAtTroopMemberInfo.textLen);
        j = a(str1);
        localAtTroopMemberInfo.startPos = ((short)(localAtTroopMemberInfo.startPos + i1));
        if (localArrayList1 != null) {
          break label1149;
        }
        localArrayList1 = new ArrayList();
        localArrayList1.add(localAtTroopMemberInfo);
        j = j + 11 + 8;
        i += 1;
        if (n + j <= paramInt1) {
          break label866;
        }
        str2 = localStringBuilder.toString();
        m = -1;
        if (localArrayList1 != null) {
          break label699;
        }
        i4 = str2.length() - paramInt2;
        n = 0;
      }
      for (;;)
      {
        if (n < a.length)
        {
          m = str2.lastIndexOf(a[n]);
          if (m <= i4) {}
        }
        else
        {
          n = str2.lastIndexOf('\024');
          if ((m <= i4) || (n != -1)) {
            break label595;
          }
          str2 = localStringBuilder.substring(0, m + 1);
          str3 = localStringBuilder.substring(m + 1);
          localStringBuilder.setLength(0);
          m = a(str3);
          localStringBuilder.append(str3);
          label326:
          i4 = str2.length();
          localArrayList2.add(str2);
          paramArrayList1.add(localArrayList1);
          if (str1 == null) {
            break label711;
          }
          localStringBuilder.append(str1);
          n = localAtTroopMemberInfo.textLen - 1 + k;
          label374:
          k = n;
          if (i3 == 20)
          {
            if (n + 1 < i2) {
              break label751;
            }
            k = n;
            if (QLog.isColorLevel())
            {
              QLog.e("TroopMemberUtil", 2, "there is no other char behind EMO_HEAD_CODE,msg is:" + paramString);
              k = n;
            }
          }
          label433:
          localArrayList1 = null;
          m += j;
          j = i1 - i4;
          k += 1;
          i1 = j;
          n = m;
          break;
          i += 1;
          break label62;
          label476:
          if (i3 == 20)
          {
            if ((k + 1 < i2) && ((paramString.charAt(k + 1) == 'ÿ') || (paramString.charAt(k + 1) == 'ǿ')))
            {
              str1 = null;
              j = 20;
              break label195;
            }
            if ((k + 1 < i2) && (paramString.charAt(k + 1) >= 'Ą'))
            {
              str1 = null;
              j = 40;
              break label195;
            }
            str1 = null;
            j = 12;
            break label195;
          }
          j = a(i3);
          str1 = null;
          break label195;
        }
        n += 1;
      }
      label595:
      if ((n - 2 < 0) || (str2.charAt(n - 1) != 'ÿ') || (str2.charAt(n - 2) != '\024')) {
        break label1162;
      }
    }
    label1152:
    label1162:
    for (int m = n - 2;; m = n)
    {
      if (m > i4)
      {
        str2 = localStringBuilder.substring(0, m);
        str3 = localStringBuilder.substring(m);
        localStringBuilder.setLength(0);
        m = a(str3);
        localStringBuilder.append(str3);
        break label326;
      }
      localStringBuilder.setLength(0);
      m = 0;
      break label326;
      label699:
      localStringBuilder.setLength(0);
      m = 0;
      break label326;
      label711:
      if (i3 > 65535)
      {
        localStringBuilder.appendCodePoint(i3);
        n = k + 1;
        break label374;
      }
      localStringBuilder.append((char)i3);
      n = k;
      break label374;
      label751:
      if ('ÿ' == paramString.charAt(n + 1))
      {
        k = n;
        if (n + 4 >= i2) {
          break label433;
        }
        localStringBuilder.append(paramString.charAt(n + 1));
        localStringBuilder.append(paramString.charAt(n + 2));
        localStringBuilder.append(paramString.charAt(n + 3));
        localStringBuilder.append(paramString.charAt(n + 4));
        k = n + 4;
        break label433;
      }
      localStringBuilder.append(paramString.charAt(n + 1));
      k = n + 1;
      break label433;
      label866:
      if (str1 != null)
      {
        localStringBuilder.append(str1);
        m = localAtTroopMemberInfo.textLen - 1 + k;
        label891:
        k = m;
        if (i3 == 20)
        {
          if (m + 1 < i2) {
            break label1004;
          }
          k = m;
          if (QLog.isColorLevel())
          {
            QLog.e("TroopMemberUtil", 2, "there is no other char behind EMO_HEAD_CODE,msg is:" + paramString);
            k = m;
          }
        }
      }
      for (;;)
      {
        m = n + j;
        j = i1;
        break;
        if (i3 > 65535)
        {
          localStringBuilder.appendCodePoint(i3);
          m = k + 1;
          break label891;
        }
        localStringBuilder.append((char)i3);
        m = k;
        break label891;
        label1004:
        if ('ÿ' == paramString.charAt(m + 1))
        {
          k = m;
          if (m + 4 < i2)
          {
            localStringBuilder.append(paramString.charAt(m + 1));
            localStringBuilder.append(paramString.charAt(m + 2));
            localStringBuilder.append(paramString.charAt(m + 3));
            localStringBuilder.append(paramString.charAt(m + 4));
            k = m + 4;
          }
        }
        else
        {
          localStringBuilder.append(paramString.charAt(m + 1));
          k = m + 1;
        }
      }
      if (localStringBuilder.length() > 0)
      {
        localArrayList2.add(localStringBuilder.toString());
        paramArrayList1.add(localArrayList1);
      }
      return localArrayList2;
      label1149:
      break label171;
      localAtTroopMemberInfo = null;
      i = j;
      break;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      return;
    }
    ThreadManager.postImmediately(new BusinessUtils.1((QQAppInterface)paramAppRuntime, paramString), null, false);
    try
    {
      StatisticCollector.getInstance(BaseApplicationImpl.sApplication).setContact(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("login", 2, "loginSuccess set CURRENT_ACCOUNT: " + paramString);
      }
      SharedPreUtils.a(BaseApplicationImpl.sApplication, paramString, true);
      BaseApplicationImpl.sApplication.refreAccountList();
      return;
    }
    catch (Throwable paramAppRuntime)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("login", 2, "loginSuccess throwable: " + paramAppRuntime);
        }
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(b)) || (TextUtils.isEmpty(b.trim()))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", Utils.b.trim());
    paramContext.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.BusinessUtils
 * JD-Core Version:    0.7.0.1
 */