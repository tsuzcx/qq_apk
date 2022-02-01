package com.tencent.mobileqq.fragment;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.troop.robot.TroopRobotData;
import com.tencent.mobileqq.troop.robot.api.TroopRobotObserver;
import com.tencent.qphone.base.util.QLog;

class TroopRobotFragment$1
  extends TroopRobotObserver
{
  TroopRobotFragment$1(TroopRobotFragment paramTroopRobotFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = String.valueOf(paramLong1);
    if ((localObject != null) && (((String)localObject).equals(TroopRobotFragment.a(this.a))))
    {
      TroopRobotFragment.a(this.a, paramLong1);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAddRobot  net troopuin");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" cur ");
    ((StringBuilder)localObject).append(TroopRobotFragment.a(this.a));
    QLog.i("TroopRobotFragment", 2, ((StringBuilder)localObject).toString());
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, TroopRobotData paramTroopRobotData)
  {
    String str = String.valueOf(paramLong);
    if ((str != null) && (str.equals(TroopRobotFragment.a(this.a))))
    {
      if ((paramBoolean) && (paramTroopRobotData != null) && (this.a.getActivity() != null))
      {
        QLog.d("TroopRobotFragment", 2, "onGetAllRobots");
        this.a.getActivity().runOnUiThread(new TroopRobotFragment.1.1(this, paramTroopRobotData));
        return;
      }
      paramTroopRobotData = new StringBuilder();
      paramTroopRobotData.append("onGetAllRobots err ");
      paramTroopRobotData.append(paramInt);
      paramTroopRobotData.append(" :");
      paramTroopRobotData.append(paramLong);
      QLog.e("TroopRobotFragment", 2, paramTroopRobotData.toString());
      TroopRobotFragment.a(this.a, paramLong);
      return;
    }
    paramTroopRobotData = new StringBuilder();
    paramTroopRobotData.append("onGetAllRobots  net troopuin");
    paramTroopRobotData.append(paramLong);
    paramTroopRobotData.append(" cur ");
    paramTroopRobotData.append(TroopRobotFragment.a(this.a));
    QLog.i("TroopRobotFragment", 2, paramTroopRobotData.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TroopRobotFragment.1
 * JD-Core Version:    0.7.0.1
 */