package com.tencent.mobileqq.conditionsearch.data;

import com.tencent.mobileqq.utils.ChnToSpell;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class BaseAddress
  implements Serializable
{
  public static final int ADDRESS_TYPE_CITY = 2;
  public static final int ADDRESS_TYPE_COUNTY = 0;
  public static final int ADDRESS_TYPE_DISTRICT = 3;
  public static final int ADDRESS_TYPE_PROVINCE = 1;
  public int addressType;
  public String code;
  public LinkedHashMap<String, BaseAddress> dataMap;
  public boolean hasCity;
  public boolean hasDistrict;
  public boolean hasProvince;
  public String name;
  public String pinyinAll;
  public String pinyinFirst;
  
  public BaseAddress(String paramString1, String paramString2, int paramInt)
  {
    this.name = paramString1;
    this.code = paramString2;
    this.addressType = paramInt;
    if (paramInt == 0)
    {
      this.pinyinAll = ChnToSpell.a(paramString1, 1);
      this.pinyinFirst = String.valueOf(this.pinyinAll.charAt(0)).toUpperCase();
    }
    this.dataMap = new LinkedHashMap(15);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null) {
      return ((BaseAddress)paramObject).code.equals(this.code);
    }
    return false;
  }
  
  public int getColumnNember()
  {
    int j = 0;
    if (this.hasProvince) {
      j = 1;
    }
    int i = j;
    if (this.hasCity) {
      i = j + 1;
    }
    j = i;
    if (this.hasDistrict) {
      j = i + 1;
    }
    return j;
  }
  
  public ArrayList<BaseAddress> getDataList()
  {
    if (this.dataMap != null) {
      return new ArrayList(this.dataMap.values());
    }
    return null;
  }
  
  public int hashCode()
  {
    return this.code.hashCode();
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.data.BaseAddress
 * JD-Core Version:    0.7.0.1
 */