package com.tencent.mobileqq.selectmember.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.selectmember.BlessSelectMemberActivity;
import com.tencent.mobileqq.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectMemberApiImpl
  implements ISelectMemberApi
{
  private static final String TAG = "SelectMemberApiImpl";
  
  public void addFriend(Context paramContext, Object paramObject, String paramString, boolean paramBoolean)
  {
    TroopAddFrdsInnerFrame.a(paramContext, (TroopMemberInfo)paramObject, paramString, paramBoolean);
  }
  
  public Object getContactsInnerFrameHandler(AppInterface paramAppInterface)
  {
    return paramAppInterface.getHandler(ContactsInnerFrame.class);
  }
  
  public int getContactsInnerFrame_RELOAD_CONTACTS_Value()
  {
    return 3;
  }
  
  public Map<String, List<TroopMemberInfo>> getIndexedFriends(Activity paramActivity)
  {
    return ((SelectMemberActivity)paramActivity).getIndexedFriends();
  }
  
  public CharDividedFacePreloadBaseAdapter getMemberListAdapter(Activity paramActivity)
  {
    return ((SelectMemberActivity)paramActivity).getMemberListAdapter();
  }
  
  public boolean getSelectMemberActivity_sNeedBlockDiscussSelfInviteMsg()
  {
    return SelectMemberActivity.sNeedBlockDiscussSelfInviteMsg;
  }
  
  public Intent getStartSelectMemberActivityIntentForJsPlugin(Context paramContext)
  {
    return new Intent(paramContext, SelectMemberActivity.class);
  }
  
  public ArrayList<String> getTopayTips(Activity paramActivity)
  {
    return ((SelectMemberActivity)paramActivity).mTopayTips;
  }
  
  public boolean isSelectMemberActivityInstance(Activity paramActivity)
  {
    return paramActivity instanceof SelectMemberActivity;
  }
  
  public void notifyListOrSearchChange(Activity paramActivity, boolean paramBoolean)
  {
    ((SelectMemberActivity)paramActivity).notifyListOrSearchChange(paramBoolean);
  }
  
  public void setSelectMemberActivity_sNeedBlockDiscussSelfInviteMsg(boolean paramBoolean)
  {
    SelectMemberActivity.sNeedBlockDiscussSelfInviteMsg = paramBoolean;
  }
  
  public void startBlessSelectMemberActivity(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberApiImpl", 2, " call startBlessSelectMemberActivity");
      }
      paramIntent.setClass(paramContext, BlessSelectMemberActivity.class);
      paramContext.startActivity(paramIntent);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startBlessSelectMemberActivity return, context = ");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(",intent = ");
    localStringBuilder.append(paramIntent);
    QLog.e("SelectMemberApiImpl", 1, localStringBuilder.toString());
  }
  
  public void startBlessSelectMemberActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramActivity != null) && (paramIntent != null) && (!paramActivity.isFinishing()) && ((Build.VERSION.SDK_INT < 17) || (!paramActivity.isDestroyed())))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberApiImpl", 2, " call startBlessSelectMemberActivityForResult by Intent");
      }
      paramIntent.setClass(paramActivity, BlessSelectMemberActivity.class);
      paramActivity.startActivityForResult(paramIntent, paramInt);
      return;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("startBlessSelectMemberActivityForResult by Intent, activity is null/finished. sdk_int: ");
    paramActivity.append(Build.VERSION.SDK_INT);
    QLog.e("SelectMemberApiImpl", 1, paramActivity.toString());
  }
  
  public void startSelectMemberActivity(Context paramContext, Intent paramIntent)
  {
    if ((paramContext != null) && (paramIntent != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberApiImpl", 2, " call startSelectMemberActivity");
      }
      paramIntent.setClass(paramContext, SelectMemberActivity.class);
      paramContext.startActivity(paramIntent);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startSelectMemberActivity return, context = ");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(",intent = ");
    localStringBuilder.append(paramIntent);
    QLog.e("SelectMemberApiImpl", 1, localStringBuilder.toString());
  }
  
  public void startSelectMemberActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramActivity != null) && (paramIntent != null) && (!paramActivity.isFinishing()) && ((Build.VERSION.SDK_INT < 17) || (!paramActivity.isDestroyed())))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" call startSelectMemberActivityForResult by Intent,intent.extra = ");
        localStringBuilder.append(paramIntent.getExtras());
        QLog.i("SelectMemberApiImpl", 2, localStringBuilder.toString());
      }
      paramIntent.setClass(paramActivity, SelectMemberActivity.class);
      paramActivity.startActivityForResult(paramIntent, paramInt);
      return;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("startSelectMemberActivityForResult by Intent, activity is null/finished. sdk_int: ");
    paramActivity.append(Build.VERSION.SDK_INT);
    QLog.e("SelectMemberApiImpl", 1, paramActivity.toString());
  }
  
  public void startSelectMemberActivityForResult(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()) && ((Build.VERSION.SDK_INT < 17) || (!paramActivity.isDestroyed())))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberApiImpl", 2, " call startSelectMemberActivityForResult");
      }
      Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
      localIntent.putExtras(paramBundle);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("startSelectMemberActivityForResult, activity is null/finished. sdk_int: ");
    paramActivity.append(Build.VERSION.SDK_INT);
    QLog.e("SelectMemberApiImpl", 1, paramActivity.toString());
  }
  
  public void updateGameData(Activity paramActivity, Map<String, List<TroopMemberInfo>> paramMap, int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    ((SelectMemberActivity)paramActivity).updateGameData(paramMap, paramArrayOfInt, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.api.impl.SelectMemberApiImpl
 * JD-Core Version:    0.7.0.1
 */