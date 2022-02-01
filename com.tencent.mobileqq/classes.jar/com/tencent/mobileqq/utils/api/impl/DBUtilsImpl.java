package com.tencent.mobileqq.utils.api.impl;

import android.content.Context;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.api.IDBUtils;

public class DBUtilsImpl
  implements IDBUtils
{
  public int getSubAccountVersion(Context paramContext)
  {
    return DBUtils.a().a(paramContext);
  }
  
  public void setShowSubAccountInRecentList(Context paramContext, String paramString, boolean paramBoolean)
  {
    DBUtils.a().a(paramContext, paramString, paramBoolean);
  }
  
  public void setSubAccountVersion(Context paramContext)
  {
    DBUtils.a().a(paramContext);
  }
  
  public boolean showSubAccountInRecentList(Context paramContext, String paramString)
  {
    return DBUtils.a().b(paramContext, paramString);
  }
  
  public boolean subAccountOldVersionUpdate(Context paramContext, String paramString)
  {
    return DBUtils.a().a(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.api.impl.DBUtilsImpl
 * JD-Core Version:    0.7.0.1
 */