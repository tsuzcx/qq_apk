package com.tencent.mobileqq.richstatus;

import PersonalState.UserProfile;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import mqq.os.MqqHandler;

class StatusManager$3
  extends StatusObserver
{
  StatusManager$3(StatusManager paramStatusManager) {}
  
  @TargetApi(9)
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new StatusManager.3.1(this, paramBoolean, paramBundle));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetSyncShuoshuo ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("Q.richstatus.shuo", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean1)
    {
      StatusManager.c(this.a, 0L);
      StatusManager.b(this.a, paramBoolean2);
    }
    else
    {
      StatusManager.c(this.a, System.currentTimeMillis() - 180000L + 60000L);
      paramBoolean2 = StatusManager.h(this.a).getBoolean("k_sync_ss", false);
    }
    if (StatusManager.i(this.a) != null)
    {
      localObject = StatusManager.i(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IStatusListener localIStatusListener = (IStatusListener)((Iterator)localObject).next();
        int i;
        if (paramBoolean1) {
          i = 100;
        } else {
          i = -1;
        }
        localIStatusListener.b(i, paramBoolean2);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, byte[] paramArrayOfByte, ArrayList<UserProfile> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetStatusMate ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramArrayList.size());
      QLog.d("Q.richstatus.mate", 2, localStringBuilder.toString());
    }
    if (paramArrayList == null) {
      return;
    }
    if (paramBoolean1) {
      StatusManager.a(this.a, paramArrayOfByte);
    } else if (paramBoolean2) {
      StatusManager.a(this.a, null);
    }
    paramArrayOfByte = paramArrayList;
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        if (StatusManager.j(this.a) != null)
        {
          StatusManager.a(this.a, paramArrayList);
          return;
        }
        if (StatusManager.k(this.a) == null) {
          StatusManager.b(this.a, new ArrayList());
        }
        paramArrayOfByte = this.a;
        paramArrayOfByte = paramArrayOfByte.a(StatusManager.k(paramArrayOfByte), paramArrayList, paramInt);
      }
      else
      {
        paramArrayOfByte = this.a.b(paramArrayList);
      }
    }
    boolean bool;
    if ((StatusManager.l(this.a) != null) && (StatusManager.l(this.a).length > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (StatusManager.m(this.a) != null)
    {
      paramArrayList = StatusManager.m(this.a).iterator();
      while (paramArrayList.hasNext()) {
        ((ISameStatusListener)paramArrayList.next()).a(paramBoolean1, paramBoolean2, paramInt, paramArrayOfByte, bool);
      }
    }
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new StatusManager.3.2(this, paramBoolean));
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetSyncShuoshuo ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("Q.richstatus.shuo", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean1) {
      StatusManager.b(this.a, paramBoolean2);
    } else {
      paramBoolean2 = StatusManager.h(this.a).getBoolean("k_sync_ss", false);
    }
    if (StatusManager.i(this.a) != null)
    {
      localObject = StatusManager.i(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IStatusListener localIStatusListener = (IStatusListener)((Iterator)localObject).next();
        int i;
        if (paramBoolean1) {
          i = 100;
        } else {
          i = -1;
        }
        localIStatusListener.a(i, paramBoolean2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3
 * JD-Core Version:    0.7.0.1
 */