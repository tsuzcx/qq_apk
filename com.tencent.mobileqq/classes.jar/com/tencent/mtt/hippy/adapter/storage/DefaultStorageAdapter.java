package com.tencent.mtt.hippy.adapter.storage;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mtt.hippy.common.HippyArray;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DefaultStorageAdapter
  implements HippyStorageAdapter
{
  static final int MAX_SQL_KEYS = 999;
  private Executor mExecutor;
  private ExecutorService mExecutorService;
  private final IHippySQLiteHelper mSQLiteHelper;
  
  public DefaultStorageAdapter(Context paramContext)
  {
    this.mSQLiteHelper = new SQLiteHelper(paramContext);
  }
  
  public DefaultStorageAdapter(Context paramContext, Executor paramExecutor)
  {
    this.mSQLiteHelper = new SQLiteHelper(paramContext);
    this.mExecutor = paramExecutor;
  }
  
  public DefaultStorageAdapter(Executor paramExecutor, IHippySQLiteHelper paramIHippySQLiteHelper)
  {
    this.mSQLiteHelper = paramIHippySQLiteHelper;
    this.mExecutor = paramExecutor;
  }
  
  static String buildKeySelection(int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    Arrays.fill(arrayOfString, "?");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key IN (");
    localStringBuilder.append(TextUtils.join(", ", arrayOfString));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  static String[] buildKeySelectionArgs(HippyArray paramHippyArray, int paramInt1, int paramInt2)
  {
    String[] arrayOfString = new String[paramInt2];
    int i = 0;
    while (i < paramInt2)
    {
      arrayOfString[i] = paramHippyArray.getString(paramInt1 + i);
      i += 1;
    }
    return arrayOfString;
  }
  
  private void execute(Runnable paramRunnable)
  {
    if (this.mExecutor == null)
    {
      if (this.mExecutorService == null) {
        this.mExecutorService = Executors.newSingleThreadExecutor();
      }
      this.mExecutor = this.mExecutorService;
    }
    if (paramRunnable != null) {
      this.mExecutor.execute(paramRunnable);
    }
  }
  
  public void destroyIfNeed()
  {
    Object localObject = this.mExecutorService;
    if ((localObject != null) && (!((ExecutorService)localObject).isShutdown()))
    {
      this.mExecutorService.shutdown();
      this.mExecutorService = null;
    }
    localObject = this.mSQLiteHelper;
    if (localObject != null) {
      ((IHippySQLiteHelper)localObject).onDestroy();
    }
  }
  
  public void getAllKeys(HippyStorageAdapter.Callback<HippyArray> paramCallback)
  {
    execute(new DefaultStorageAdapter.4(this, paramCallback));
  }
  
  public void multiGet(HippyArray paramHippyArray, HippyStorageAdapter.Callback<List<HippyStorageKeyValue>> paramCallback)
  {
    execute(new DefaultStorageAdapter.1(this, paramCallback, paramHippyArray));
  }
  
  public void multiRemove(HippyArray paramHippyArray, HippyStorageAdapter.Callback<Void> paramCallback)
  {
    execute(new DefaultStorageAdapter.3(this, paramCallback, paramHippyArray));
  }
  
  public void multiSet(List<HippyStorageKeyValue> paramList, HippyStorageAdapter.Callback<Void> paramCallback)
  {
    execute(new DefaultStorageAdapter.2(this, paramCallback, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter
 * JD-Core Version:    0.7.0.1
 */