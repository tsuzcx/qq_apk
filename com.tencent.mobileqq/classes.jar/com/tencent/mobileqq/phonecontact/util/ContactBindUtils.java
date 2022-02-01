package com.tencent.mobileqq.phonecontact.util;

import android.text.TextUtils;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.data.ContactBindedData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class ContactBindUtils
{
  public static ContactBindedData a(List<PhoneContact> paramList, ArrayList<PhoneContact> paramArrayList, boolean paramBoolean)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    ContactBindedData localContactBindedData = new ContactBindedData();
    localContactBindedData.d = ((List)localObject);
    if (paramArrayList != null) {
      paramList = (List)paramArrayList.clone();
    } else {
      paramList = null;
    }
    Iterator localIterator = ((List)localObject).iterator();
    char c;
    int j;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      c = 'A';
      String str2 = "#";
      j = 0;
      if (!bool) {
        break label327;
      }
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      if (TextUtils.isEmpty(localPhoneContact.pinyinFirst)) {
        paramArrayList = "#";
      } else {
        paramArrayList = String.valueOf(localPhoneContact.pinyinFirst.charAt(0));
      }
      i = paramArrayList.charAt(0);
      String str1;
      if ((65 > i) || (i > 90))
      {
        str1 = str2;
        if (97 <= i)
        {
          str1 = str2;
          if (i > 122) {}
        }
      }
      else
      {
        str1 = paramArrayList.toUpperCase();
      }
      if (localContactBindedData.a.get(str1) == null) {
        localContactBindedData.a.put(str1, new ArrayList());
      }
      ((List)localContactBindedData.a.get(str1)).add(localPhoneContact);
      if ((paramList != null) && (paramBoolean))
      {
        paramArrayList = paramList.iterator();
        if (paramArrayList.hasNext())
        {
          if (!TextUtils.equals(((PhoneContact)paramArrayList.next()).unifiedCode, localPhoneContact.unifiedCode)) {
            break;
          }
          if (localContactBindedData.a.get("★") == null) {
            localContactBindedData.a.put("★", new ArrayList());
          }
          ((List)localContactBindedData.a.get("★")).add(localPhoneContact);
        }
      }
    }
    label327:
    if (paramList != null)
    {
      localContactBindedData.e = paramList;
      if (!paramBoolean)
      {
        if (localContactBindedData.a.get("★") == null) {
          localContactBindedData.a.put("★", new ArrayList());
        }
        ((List)localContactBindedData.a.get("★")).addAll(paramList);
      }
    }
    paramArrayList = localContactBindedData.a;
    localContactBindedData.a = new LinkedHashMap();
    while (c <= 'Z')
    {
      if (paramArrayList.get(String.valueOf(c)) != null) {
        localContactBindedData.a.put(String.valueOf(c), paramArrayList.get(String.valueOf(c)));
      }
      c = (char)(c + '\001');
    }
    if (paramArrayList.get("#") != null) {
      localContactBindedData.a.put("#", paramArrayList.get("#"));
    }
    if ((paramList != null) && ((((List)localObject).size() > 10) || (!paramBoolean)) && (paramArrayList.get("★") != null)) {
      localContactBindedData.a.put("★", paramList);
    }
    paramArrayList.clear();
    localContactBindedData.b = new int[localContactBindedData.a.keySet().size()];
    localContactBindedData.c = new String[localContactBindedData.b.length];
    paramList = new ArrayList(localContactBindedData.a.keySet());
    Collections.sort(paramList, new ContactBindUtils.1());
    paramArrayList = paramList.iterator();
    if (localContactBindedData.b.length == 0) {
      return localContactBindedData;
    }
    localContactBindedData.b[0] = 0;
    int i = 1;
    while (i < localContactBindedData.b.length)
    {
      localObject = localContactBindedData.b;
      localObject[i] += localContactBindedData.b[(i - 1)] + ((List)localContactBindedData.a.get(paramArrayList.next())).size() + 1;
      i += 1;
    }
    paramList = paramList.iterator();
    i = j;
    while (paramList.hasNext())
    {
      localContactBindedData.c[i] = ((String)paramList.next());
      i += 1;
    }
    return localContactBindedData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.util.ContactBindUtils
 * JD-Core Version:    0.7.0.1
 */