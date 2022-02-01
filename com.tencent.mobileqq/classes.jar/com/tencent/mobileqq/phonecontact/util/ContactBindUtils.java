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
    localContactBindedData.jdField_a_of_type_JavaUtilList = ((List)localObject);
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
      if (localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get(str1) == null) {
        localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.put(str1, new ArrayList());
      }
      ((List)localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get(str1)).add(localPhoneContact);
      if ((paramList != null) && (paramBoolean))
      {
        paramArrayList = paramList.iterator();
        if (paramArrayList.hasNext())
        {
          if (!TextUtils.equals(((PhoneContact)paramArrayList.next()).unifiedCode, localPhoneContact.unifiedCode)) {
            break;
          }
          if (localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get("★") == null) {
            localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", new ArrayList());
          }
          ((List)localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get("★")).add(localPhoneContact);
        }
      }
    }
    label327:
    if (paramList != null)
    {
      localContactBindedData.b = paramList;
      if (!paramBoolean)
      {
        if (localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get("★") == null) {
          localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", new ArrayList());
        }
        ((List)localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get("★")).addAll(paramList);
      }
    }
    paramArrayList = localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap;
    localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    while (c <= 'Z')
    {
      if (paramArrayList.get(String.valueOf(c)) != null) {
        localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), paramArrayList.get(String.valueOf(c)));
      }
      c = (char)(c + '\001');
    }
    if (paramArrayList.get("#") != null) {
      localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", paramArrayList.get("#"));
    }
    if ((paramList != null) && ((((List)localObject).size() > 10) || (!paramBoolean)) && (paramArrayList.get("★") != null)) {
      localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", paramList);
    }
    paramArrayList.clear();
    localContactBindedData.jdField_a_of_type_ArrayOfInt = new int[localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
    localContactBindedData.jdField_a_of_type_ArrayOfJavaLangString = new String[localContactBindedData.jdField_a_of_type_ArrayOfInt.length];
    paramList = new ArrayList(localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.keySet());
    Collections.sort(paramList, new ContactBindUtils.1());
    paramArrayList = paramList.iterator();
    if (localContactBindedData.jdField_a_of_type_ArrayOfInt.length == 0) {
      return localContactBindedData;
    }
    localContactBindedData.jdField_a_of_type_ArrayOfInt[0] = 0;
    int i = 1;
    while (i < localContactBindedData.jdField_a_of_type_ArrayOfInt.length)
    {
      localObject = localContactBindedData.jdField_a_of_type_ArrayOfInt;
      localObject[i] += localContactBindedData.jdField_a_of_type_ArrayOfInt[(i - 1)] + ((List)localContactBindedData.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayList.next())).size() + 1;
      i += 1;
    }
    paramList = paramList.iterator();
    i = j;
    while (paramList.hasNext())
    {
      localContactBindedData.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)paramList.next());
      i += 1;
    }
    return localContactBindedData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.util.ContactBindUtils
 * JD-Core Version:    0.7.0.1
 */