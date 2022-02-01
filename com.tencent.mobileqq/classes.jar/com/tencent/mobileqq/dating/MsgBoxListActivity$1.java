package com.tencent.mobileqq.dating;

import EncounterSvc.RespEncounterInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

class MsgBoxListActivity$1
  extends LBSObserver
{
  MsgBoxListActivity$1(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  protected void d(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramBoolean) && (paramArrayOfObject != null) && ((paramArrayOfObject instanceof Object[])) && (MsgBoxListActivity.access$000(this.a) != null))
    {
      MsgBoxListActivity.access$000(this.a).a((List)paramArrayOfObject[0], 0, (ArrayList)paramArrayOfObject[1]);
      paramArrayOfObject = this.a;
      paramArrayOfObject.mConfig = MsgBoxListActivity.access$000(paramArrayOfObject).a();
      this.a.app.getPreferences().edit().putLong("sp_key_dating_config_time", System.currentTimeMillis()).commit();
      this.a.runOnUiThread(new MsgBoxListActivity.1.3(this));
    }
  }
  
  protected void e(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramBoolean)
    {
      int j = 0;
      int i;
      if (paramArrayOfObject != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (((i & paramArrayOfObject instanceof Object[]) != 0) && (this.a.recommandCarrier != null) && (this.a.chatPushCarrierHelper != null) && (((Integer)paramArrayOfObject[1]).intValue() == 1))
      {
        paramArrayOfObject = (List)paramArrayOfObject[0];
        LinearLayout localLinearLayout = (LinearLayout)this.a.recommandCarrier.findViewById(2131373294);
        if (localLinearLayout.getChildCount() == 0)
        {
          this.a.runOnUiThread(new MsgBoxListActivity.1.1(this, paramArrayOfObject));
          return;
        }
        if (localLinearLayout.getChildCount() == paramArrayOfObject.size())
        {
          i = j;
          while (i < localLinearLayout.getChildCount())
          {
            View localView = localLinearLayout.getChildAt(i);
            RespEncounterInfo localRespEncounterInfo = (RespEncounterInfo)paramArrayOfObject.get(i);
            this.a.runOnUiThread(new MsgBoxListActivity.1.2(this, localView, localRespEncounterInfo));
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity.1
 * JD-Core Version:    0.7.0.1
 */