package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.IGroupTeamWorkAdapter;
import com.tencent.mobileqq.teamwork.OnItemLongClickListener;

@QAPI(process={"all"})
public abstract interface IGroupTeamWorkAdapterCreator
  extends QRouteApi
{
  public abstract IGroupTeamWorkAdapter getGroupTeamWorkAdapter(AppInterface paramAppInterface, Activity paramActivity, OnItemLongClickListener paramOnItemLongClickListener, Handler paramHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.IGroupTeamWorkAdapterCreator
 * JD-Core Version:    0.7.0.1
 */