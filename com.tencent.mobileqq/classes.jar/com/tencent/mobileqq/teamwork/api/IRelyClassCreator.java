package com.tencent.mobileqq.teamwork.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRelyClassCreator
  extends QRouteApi
{
  public abstract ISimpleTextView getSimpleTextViewImpl(Context paramContext);
  
  public abstract ITeamWorkFileImportJob getTeamWorkFileImportForH5(Object paramObject, AppInterface paramAppInterface);
  
  public abstract ITeamWorkFileImportJob getTeamWorkFileImportJobForC2C(Object paramObject, AppInterface paramAppInterface);
  
  public abstract ITeamWorkFileImportJob getTeamWorkFileImportJobForDisc(Object paramObject, AppInterface paramAppInterface);
  
  public abstract ITeamWorkFileImportJob getTeamWorkFileImportJobForGroup(Object paramObject, AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.IRelyClassCreator
 * JD-Core Version:    0.7.0.1
 */