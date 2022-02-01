package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.IGroupTeamWorkAdapter;
import com.tencent.mobileqq.teamwork.OnItemLongClickListener;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkAdapterCreator;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkAdapter;

public class GroupTeamWorkAdapterCreatorImpl
  implements IGroupTeamWorkAdapterCreator
{
  public IGroupTeamWorkAdapter getGroupTeamWorkAdapter(AppInterface paramAppInterface, Activity paramActivity, OnItemLongClickListener paramOnItemLongClickListener, Handler paramHandler)
  {
    return new GroupTeamWorkAdapter(paramAppInterface, paramActivity, paramOnItemLongClickListener, paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.GroupTeamWorkAdapterCreatorImpl
 * JD-Core Version:    0.7.0.1
 */