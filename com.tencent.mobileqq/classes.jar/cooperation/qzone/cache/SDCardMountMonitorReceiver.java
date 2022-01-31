package cooperation.qzone.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import bftg;
import bftq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SDCardMountMonitorReceiver
  extends BroadcastReceiver
{
  private static SDCardMountMonitorReceiver jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver;
  private List<bftq> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public static SDCardMountMonitorReceiver a()
  {
    if (jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver == null) {
      jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver = new SDCardMountMonitorReceiver();
    }
    return jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver;
  }
  
  private void a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      bftq[] arrayOfbftq = new bftq[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfbftq);
      if (arrayOfbftq != null)
      {
        int j = arrayOfbftq.length;
        int i = 0;
        if (i < j)
        {
          arrayOfbftq[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  private boolean b()
  {
    if (!this.d) {
      if ((!Environment.getExternalStorageDirectory().canWrite()) || (!bftg.c(Environment.getExternalStorageDirectory().getAbsolutePath()))) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      this.d = true;
      return this.c;
    }
  }
  
  private boolean c()
  {
    if (!this.e) {}
    try
    {
      this.b = "mounted".equals(Environment.getExternalStorageState());
      this.e = true;
      return this.b;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("CacheManager", 2, "getExternalStorageState error:" + localException.getMessage());
      }
    }
  }
  
  public void a()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
      localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
      localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
      localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
      localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
      localIntentFilter.addDataScheme("file");
      BaseApplicationImpl.getContext().registerReceiver(this, localIntentFilter);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(bftq parambftq)
  {
    if (parambftq == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(parambftq)) {
        this.jdField_a_of_type_JavaUtilList.add(parambftq);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return (c()) && (b());
  }
  
  public void b()
  {
    if ((jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver != null) && (jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver.jdField_a_of_type_Boolean == true))
    {
      BaseApplicationImpl.getContext().unregisterReceiver(jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver);
      jdField_a_of_type_CooperationQzoneCacheSDCardMountMonitorReceiver.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.b = "mounted".equals(Environment.getExternalStorageState());
    if (this.b) {
      if ((!Environment.getExternalStorageDirectory().canWrite()) || (!bftg.c(Environment.getExternalStorageDirectory().getAbsolutePath()))) {
        break label109;
      }
    }
    label109:
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      this.d = true;
      this.e = true;
      bftg.a();
      a(this.b);
      QLog.i("CacheManager", 1, "SDCardMountMonitorReceiver onReceive mIsSDCardMount:" + this.b + ",canWrite" + this.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.cache.SDCardMountMonitorReceiver
 * JD-Core Version:    0.7.0.1
 */