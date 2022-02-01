package com.tencent.mobileqq.richstatus;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.SparseArray;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$1
  extends AsyncTask<Void, Integer, Integer>
{
  StatusManager$1(StatusManager paramStatusManager) {}
  
  private void a(long paramLong)
  {
    long l = StatusManager.a(this.a).getLong("k_icon", 0L);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mUpdateLocalTask clearIcons ");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(104L);
      QLog.d("Q.richstatus.xml", 2, ((StringBuilder)localObject).toString());
    }
    if (l < paramLong)
    {
      localObject = null;
      if (paramLong > 104L) {
        try
        {
          InputStream localInputStream = StatusManager.a(this.a).getApp().getAssets().open("rich_status.xml");
          localObject = localInputStream;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      } else {
        try
        {
          FileInputStream localFileInputStream = new FileInputStream(new File(StatusManager.a(this.a).getApp().getFilesDir(), "rich_status.xml"));
          localObject = localFileInputStream;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
        }
      }
      localObject = (SparseArray)StatusManager.a(this.a, localObject)[0];
      StatusManager localStatusManager = this.a;
      if (StatusManager.a(localStatusManager, (SparseArray)localObject, StatusManager.a(localStatusManager))) {
        StatusManager.a(this.a).edit().putLong("k_icon", paramLong).commit();
      }
    }
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    long l2 = StatusManager.a(this.a).getLong("k_version", 0L);
    if (QLog.isColorLevel())
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("updateActions_Local with file ");
      paramVarArgs.append(l2);
      paramVarArgs.append(", ");
      paramVarArgs.append(104L);
      QLog.d("Q.richstatus.xml", 2, paramVarArgs.toString());
    }
    if (l2 > 104L) {
      try
      {
        paramVarArgs = new FileInputStream(new File(StatusManager.a(this.a).getApp().getFilesDir(), "rich_status.xml"));
      }
      catch (FileNotFoundException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    } else {
      paramVarArgs = null;
    }
    long l1 = l2;
    Object localObject1 = paramVarArgs;
    if (paramVarArgs == null) {
      try
      {
        localObject1 = StatusManager.a(this.a).getApp().getAssets().open("rich_status.xml");
        l1 = 104L;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        ??? = paramVarArgs;
        l1 = l2;
      }
    }
    ??? = StatusManager.a(this.a, (InputStream)???);
    paramVarArgs = (SparseArray)???[0];
    ArrayList localArrayList = (ArrayList)???[1];
    if ((paramVarArgs != null) && (paramVarArgs.size() != 0) && (localArrayList != null) && (localArrayList.size() != 0)) {
      synchronized (StatusManager.a(this.a))
      {
        if ((!isCancelled()) && (StatusManager.a(this.a).size() == 0))
        {
          StatusManager.a(this.a, paramVarArgs);
          StatusManager.a(this.a).clear();
          StatusManager.a(this.a).addAll(localArrayList);
          publishProgress(new Integer[] { Integer.valueOf(102) });
        }
        else
        {
          cancel(true);
        }
      }
    }
    publishProgress(new Integer[] { Integer.valueOf(-1) });
    a(l1);
    return Integer.valueOf(100);
  }
  
  protected void a(Integer paramInteger)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mUpdateLocalTask onPostExecute ");
      localStringBuilder.append(paramInteger);
      QLog.d("Q.richstatus.xml", 2, localStringBuilder.toString());
    }
    StatusManager.a(this.a, null);
    if (101 == StatusManager.a(this.a, false)) {
      StatusManager.a(this.a);
    }
    this.a.a(false);
  }
  
  protected void a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[0].intValue();
    if (QLog.isColorLevel())
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("mUpdateLocalTask onProgressUpdate ");
      paramVarArgs.append(i);
      QLog.d("Q.richstatus.xml", 2, paramVarArgs.toString());
    }
    if (StatusManager.a(this.a) != null)
    {
      paramVarArgs = StatusManager.a(this.a).iterator();
      while (paramVarArgs.hasNext()) {
        ((IActionListener)paramVarArgs.next()).a(i, 300);
      }
    }
    VasFontIPCModule.a().c(i, 300);
  }
  
  protected void onCancelled()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "mUpdateLocalTask onCancelled");
    }
    StatusManager.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.1
 * JD-Core Version:    0.7.0.1
 */