package com.tencent.mobileqq.trooponline;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.text.ColorNickText;

class TroopOnlineMemberListAdapter$TmiCallBackForName
  implements TroopManager.ITroopMemberInfoCallBack
{
  public TroopOnlineMemberListAdapter.ViewHolder a;
  
  private TroopOnlineMemberListAdapter$TmiCallBackForName(TroopOnlineMemberListAdapter paramTroopOnlineMemberListAdapter) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    TroopOnlineMemberListAdapter.ViewHolder localViewHolder = this.a;
    if ((localViewHolder != null) && (paramTroopMemberInfo != null) && (TextUtils.equals(localViewHolder.b, paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = new ColorNickText(((TroopManager)this.b.c.getManager(QQManagerFactory.TROOP_MANAGER)).e(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin), 13).b();
      this.a.e.setText(paramTroopMemberInfo);
      if (AppSetting.e) {
        TroopOnlineMemberListAdapter.a(this.b, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberListAdapter.TmiCallBackForName
 * JD-Core Version:    0.7.0.1
 */