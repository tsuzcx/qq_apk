package com.tencent.mobileqq.troop.troopnotification;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.stranger.data.Stranger;
import com.tencent.mobileqq.stranger.observer.StrangerObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

class TroopNotificationFragment$32
  extends StrangerObserver
{
  TroopNotificationFragment$32(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (paramBoolean)
    {
      if (paramPBRepeatMessageField != null)
      {
        paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
        while (paramPBRepeatMessageField.hasNext())
        {
          oidb_0x5d4.DelResult localDelResult = (oidb_0x5d4.DelResult)paramPBRepeatMessageField.next();
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ondelete: uin ");
          ((StringBuilder)localObject).append(localDelResult.uin.get());
          QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject).toString());
          if (this.a.d != null)
          {
            int i = 0;
            while (i < this.a.d.size())
            {
              localObject = (Stranger)this.a.d.get(i);
              if (((Stranger)localObject).uin.equals(String.valueOf(localDelResult.uin.get()))) {
                this.a.d.remove(localObject);
              }
              i += 1;
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationFragment", 2, "onDelete is failed");
    }
  }
  
  public void a(boolean paramBoolean, List<Stranger> paramList)
  {
    if (paramBoolean)
    {
      if (paramList != null)
      {
        this.a.d.clear();
        this.a.d.addAll(paramList);
        paramList = new StringBuilder();
        paramList.append("onGetListRemote :");
        paramList.append(this.a.d.size());
        QLog.d("TroopNotificationFragment", 2, paramList.toString());
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationFragment", 2, "onGetListRemote is failed");
    }
  }
  
  public void b(boolean paramBoolean, List<Stranger> paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      this.a.d.clear();
      this.a.d.addAll(paramList);
      paramList = new StringBuilder();
      paramList.append("onGetListLocal :");
      paramList.append(this.a.d.size());
      QLog.d("TroopNotificationFragment", 2, paramList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.32
 * JD-Core Version:    0.7.0.1
 */