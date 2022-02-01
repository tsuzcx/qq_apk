package com.tencent.mobileqq.campuscircle;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.List;

public class CampusCircleIpcClient
  implements EIPCResultCallback
{
  private static CampusCircleIpcClient a;
  
  public static CampusCircleIpcClient a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new CampusCircleIpcClient();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(int paramInt)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("nSwitchValue", paramInt);
    QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_confess_update_switch", (Bundle)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateConfessSwitch nSwitchValue: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("CampusCircleIpcClient", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportRedPoint, seq=");
        ((StringBuilder)localObject1).append(paramLong);
        QLog.d("CampusCircleIpcClient", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramLong < 0L)
      {
        QLog.d("CampusCircleIpcClient", 1, "reportRedPoint, seq < 0");
        return;
      }
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("seq", paramLong);
      QIPCClientHelper.getInstance().callServer("CampusCircleIpcServer_Model", "action_report_red_point", (Bundle)localObject1, this);
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcClient", 2, "clearRedPoint_confess");
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("from", "web");
      localBundle.putString("tag", paramString);
      QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_confess_clear_red_point", localBundle, this);
      return;
    }
    finally {}
  }
  
  public Bundle b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcClient", 2, "getRedPoint");
      }
      Object localObject1 = new Bundle();
      localObject1 = QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_get_red_point", (Bundle)localObject1);
      if ((localObject1 != null) && (((EIPCResult)localObject1).isSuccess()) && (((EIPCResult)localObject1).data != null))
      {
        localObject1 = ((EIPCResult)localObject1).data;
        return localObject1;
      }
      return null;
    }
    finally {}
  }
  
  public Object[] b(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getTroopMembers ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("CampusCircleIpcClient", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("troopUin", paramString);
      localObject1 = QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_confess_get_troop_members", (Bundle)localObject1);
      if ((localObject1 != null) && (((EIPCResult)localObject1).code == 0))
      {
        Object localObject2 = ((EIPCResult)localObject1).data;
        if (localObject2 != null) {
          try
          {
            localObject2 = (List)((EIPCResult)localObject1).data.getSerializable("troopUin");
            boolean bool1 = ((EIPCResult)localObject1).data.getBoolean("isAdmin", false);
            boolean bool2 = ((EIPCResult)localObject1).data.getBoolean("enableMemInvite", false);
            if (QLog.isColorLevel()) {
              QLog.i("CampusCircleIpcClient", 2, String.format("getTroopMembers troopUin:%s isAdmin:%s enableInvite:%s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
            }
            return new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject2 };
          }
          catch (Exception paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.i("CampusCircleIpcClient", 2, "getTroopMembers err", paramString);
            }
            return null;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("CampusCircleIpcClient", 2, "getTroopMembers err");
      }
      return null;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcClient", 2, "reportMedalRedPoint");
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("from", "web");
      QIPCClientHelper.getInstance().callServer("CampusCircleIpcServer_Model", "action_report_medal_red_point", localBundle, this);
      return;
    }
    finally {}
  }
  
  public Bundle d()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircleIpcClient", 2, "getRedPoint_allPeopleVote");
        }
        Object localObject1 = new Bundle();
        localObject1 = QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_allpeoplevote_getredpoint", (Bundle)localObject1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getRedPoint_allPeopleVote result!=null ");
          boolean bool2 = true;
          if (localObject1 != null)
          {
            bool1 = true;
            localStringBuilder.append(bool1);
            localStringBuilder.append(" result.suc ");
            if ((localObject1 == null) || (!((EIPCResult)localObject1).isSuccess())) {
              break label163;
            }
            bool1 = bool2;
            localStringBuilder.append(bool1);
            QLog.i("CampusCircleIpcClient", 4, localStringBuilder.toString());
          }
        }
        else
        {
          if ((localObject1 != null) && (((EIPCResult)localObject1).isSuccess()) && (((EIPCResult)localObject1).data != null))
          {
            localObject1 = ((EIPCResult)localObject1).data;
            return localObject1;
          }
          return null;
        }
      }
      finally {}
      boolean bool1 = false;
      continue;
      label163:
      bool1 = false;
    }
  }
  
  public void e()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcClient", 2, "clearRedPoint_allPeopleVote");
      }
      QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_allpeoplevote_clearredpoint", new Bundle());
      return;
    }
    finally {}
  }
  
  public Object[] f()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new Bundle();
        localObject1 = QIPCClientHelper.getInstance().getClient().callServer("CampusCircleIpcServer_Model", "action_confess_is_in_troop_aio", (Bundle)localObject1);
        if ((localObject1 != null) && (((EIPCResult)localObject1).code == 0) && (((EIPCResult)localObject1).data != null))
        {
          bool2 = ((EIPCResult)localObject1).data.getBoolean("isInTroopAIO", false);
          if (!QLog.isColorLevel()) {
            break label137;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("isInTroopAIO isInAIO ");
          ((StringBuilder)localObject1).append(bool2);
          QLog.i("CampusCircleIpcClient", 2, ((StringBuilder)localObject1).toString());
          break label137;
        }
        if (!QLog.isColorLevel()) {
          break label142;
        }
        QLog.i("CampusCircleIpcClient", 2, "isInTroopAIO err");
      }
      finally {}
      return new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) };
      label137:
      boolean bool1 = true;
      continue;
      label142:
      bool1 = false;
      boolean bool2 = false;
    }
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCallback, result=");
      localStringBuilder.append(paramEIPCResult);
      localStringBuilder.append(", data=");
      if (paramEIPCResult == null) {
        paramEIPCResult = "null";
      } else {
        paramEIPCResult = paramEIPCResult.data;
      }
      localStringBuilder.append(paramEIPCResult);
      QLog.d("CampusCircleIpcClient", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleIpcClient
 * JD-Core Version:    0.7.0.1
 */