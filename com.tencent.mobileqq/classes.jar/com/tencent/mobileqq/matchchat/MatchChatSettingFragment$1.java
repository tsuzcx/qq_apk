package com.tencent.mobileqq.matchchat;

import com.tencent.mobileqq.qqexpand.bean.match.TagInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MatchChatSettingFragment$1
  extends ExpandObserver
{
  MatchChatSettingFragment$1(MatchChatSettingFragment paramMatchChatSettingFragment) {}
  
  protected void a(boolean paramBoolean1, ArrayList<TagInfo> paramArrayList, boolean paramBoolean2, int paramInt, ArrayList<String> paramArrayList1, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("onGetUnLimitBaseInfo suc:");
      paramArrayList.append(paramBoolean1);
      paramArrayList.append(" chatSwitchOpen:");
      paramArrayList.append(paramBoolean2);
      QLog.i("MatchChatSettingFragment", 2, paramArrayList.toString());
    }
    if (paramBoolean1) {
      MatchChatSettingFragment.a(this.a, paramBoolean2);
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetUnLimitBaseInfo suc:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("MatchChatSettingFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      localObject = this.a;
      MatchChatSettingFragment.a((MatchChatSettingFragment)localObject, MatchChatSettingFragment.a((MatchChatSettingFragment)localObject).a() ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */