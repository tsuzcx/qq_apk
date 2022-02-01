package com.tencent.vas.update.module.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.callback.IDbManager;
import com.tencent.vas.update.callback.IDbManager.ItemInfo;
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
  private String getTableName(int paramInt)
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
  
  public void deleteItem(int paramInt, String paramString)
  {
    Object localObject = getTableName(paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = VasUpdateWrapper.getCommonManager().getApplicationContext().getSharedPreferences((String)localObject, 0).edit();
    ((SharedPreferences.Editor)localObject).remove(paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public List<IDbManager.ItemInfo> selectAllItem(int paramInt)
  {
    Object localObject1 = getTableName(paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    Object localObject2 = VasUpdateWrapper.getCommonManager().getApplicationContext().getSharedPreferences((String)localObject1, 0).getAll();
    if ((localObject2 != null) && (((Map)localObject2).size() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        IDbManager.ItemInfo localItemInfo = new IDbManager.ItemInfo();
        localItemInfo.itemId = ((String)localEntry.getKey());
        localItemInfo.content = ((String)localEntry.getValue());
        ((ArrayList)localObject1).add(localItemInfo);
      }
      return localObject1;
    }
    return null;
  }
  
  public String selectItem(int paramInt, String paramString)
  {
    String str = getTableName(paramInt);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return VasUpdateWrapper.getCommonManager().getApplicationContext().getSharedPreferences(str, 0).getString(paramString, null);
  }
  
  public void updateItem(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = getTableName(paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = VasUpdateWrapper.getCommonManager().getApplicationContext().getSharedPreferences((String)localObject, 0).edit();
    ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.DefaultDbManagerImpl
 * JD-Core Version:    0.7.0.1
 */