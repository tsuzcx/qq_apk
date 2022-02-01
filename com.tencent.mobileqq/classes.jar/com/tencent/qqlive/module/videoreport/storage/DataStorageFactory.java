package com.tencent.qqlive.module.videoreport.storage;

import android.content.Context;
import com.tencent.qqlive.module.videoreport.storage.database.DatabaseStorage;
import com.tencent.qqlive.module.videoreport.storage.preference.PreferenceStorage;

public class DataStorageFactory
{
  public static final int TYPE_DATABASE = 0;
  public static final int TYPE_SP = 1;
  
  public static IDataStorage getInstance(Context paramContext, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return PreferenceStorage.getInstance(paramContext);
      }
      paramContext = new StringBuilder();
      paramContext.append("Type ");
      paramContext.append(paramInt);
      paramContext.append(" is not supported.");
      throw new IllegalArgumentException(paramContext.toString());
    }
    return DatabaseStorage.getInstance(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.DataStorageFactory
 * JD-Core Version:    0.7.0.1
 */