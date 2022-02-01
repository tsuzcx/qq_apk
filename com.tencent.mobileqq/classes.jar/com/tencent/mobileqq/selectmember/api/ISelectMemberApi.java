package com.tencent.mobileqq.selectmember.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface ISelectMemberApi
  extends QRouteApi
{
  public abstract void addFriend(Context paramContext, Object paramObject, String paramString, boolean paramBoolean);
  
  public abstract Object getContactsInnerFrameHandler(AppInterface paramAppInterface);
  
  public abstract int getContactsInnerFrame_RELOAD_CONTACTS_Value();
  
  public abstract Map<String, List<TroopMemberInfo>> getIndexedFriends(Activity paramActivity);
  
  public abstract CharDividedFacePreloadBaseAdapter getMemberListAdapter(Activity paramActivity);
  
  public abstract boolean getSelectMemberActivity_sNeedBlockDiscussSelfInviteMsg();
  
  public abstract Intent getStartSelectMemberActivityIntentForJsPlugin(Context paramContext);
  
  public abstract ArrayList<String> getTopayTips(Activity paramActivity);
  
  public abstract boolean isSelectMemberActivityInstance(Activity paramActivity);
  
  public abstract void notifyListOrSearchChange(Activity paramActivity, boolean paramBoolean);
  
  public abstract void setSelectMemberActivity_sNeedBlockDiscussSelfInviteMsg(boolean paramBoolean);
  
  public abstract void startBlessSelectMemberActivity(Context paramContext, Intent paramIntent);
  
  public abstract void startBlessSelectMemberActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void startSelectMemberActivity(Context paramContext, Intent paramIntent);
  
  public abstract void startSelectMemberActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void startSelectMemberActivityForResult(Activity paramActivity, Bundle paramBundle, int paramInt);
  
  public abstract void updateGameData(Activity paramActivity, Map<String, List<TroopMemberInfo>> paramMap, int[] paramArrayOfInt, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.api.ISelectMemberApi
 * JD-Core Version:    0.7.0.1
 */