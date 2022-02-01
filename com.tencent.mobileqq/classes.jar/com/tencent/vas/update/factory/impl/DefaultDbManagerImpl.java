package com.tencent.vas.update.factory.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.vas.update.factory.api.ICommonManager;
import com.tencent.vas.update.factory.api.IDbManager;
import com.tencent.vas.update.factory.api.IDbManager.ItemInfo;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DefaultDbManagerImpl
  implements IDbManager
{
  private String b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return "table_file_md5";
      }
      return "table_should_update";
    }
    return "table_local";
  }
  
  public String a(int paramInt, String paramString)
  {
    String str = b(paramInt);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return VasUpdateWrapper.getCommonManager().b().getSharedPreferences(str, 0).getString(paramString, null);
  }
  
  public List<IDbManager.ItemInfo> a(int paramInt)
  {
    Object localObject1 = b(paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    Object localObject2 = VasUpdateWrapper.getCommonManager().b().getSharedPreferences((String)localObject1, 0).getAll();
    if ((localObject2 != null) && (((Map)localObject2).size() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        IDbManager.ItemInfo localItemInfo = new IDbManager.ItemInfo();
        localItemInfo.a = ((String)localEntry.getKey());
        localItemInfo.b = ((String)localEntry.getValue());
        ((ArrayList)localObject1).add(localItemInfo);
      }
      return localObject1;
    }
    return null;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = b(paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = VasUpdateWrapper.getCommonManager().b().getSharedPreferences((String)localObject, 0).edit();
    ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void b(int paramInt, String paramString)
  {
    Object localObject = b(paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = VasUpdateWrapper.getCommonManager().b().getSharedPreferences((String)localObject, 0).edit();
    ((SharedPreferences.Editor)localObject).remove(paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.factory.impl.DefaultDbManagerImpl
 * JD-Core Version:    0.7.0.1
 */