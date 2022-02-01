package com.tencent.mobileqq.teamwork.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportForH5;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForC2C;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForDisc;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForGroup;
import com.tencent.mobileqq.teamwork.api.IRelyClassCreator;
import com.tencent.mobileqq.teamwork.api.ISimpleTextView;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportJob;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;

public class RelyClassCreatorImpl
  implements IRelyClassCreator
{
  public ISimpleTextView getSimpleTextViewImpl(Context paramContext)
  {
    return new SimpleTextViewImpl(paramContext);
  }
  
  public ITeamWorkFileImportJob getTeamWorkFileImportForH5(Object paramObject, AppInterface paramAppInterface)
  {
    if (((paramObject instanceof TeamWorkFileImportInfo)) && ((paramAppInterface instanceof QQAppInterface))) {
      return new TeamWorkFileImportForH5((TeamWorkFileImportInfo)paramObject, (QQAppInterface)paramAppInterface);
    }
    return null;
  }
  
  public ITeamWorkFileImportJob getTeamWorkFileImportJobForC2C(Object paramObject, AppInterface paramAppInterface)
  {
    if (((paramObject instanceof TeamWorkFileImportInfo)) && ((paramAppInterface instanceof QQAppInterface))) {
      return new TeamWorkFileImportJobForC2C((TeamWorkFileImportInfo)paramObject, (QQAppInterface)paramAppInterface);
    }
    return null;
  }
  
  public ITeamWorkFileImportJob getTeamWorkFileImportJobForDisc(Object paramObject, AppInterface paramAppInterface)
  {
    if (((paramObject instanceof TeamWorkFileImportInfo)) && ((paramAppInterface instanceof QQAppInterface))) {
      return new TeamWorkFileImportJobForDisc((TeamWorkFileImportInfo)paramObject, (QQAppInterface)paramAppInterface);
    }
    return null;
  }
  
  public ITeamWorkFileImportJob getTeamWorkFileImportJobForGroup(Object paramObject, AppInterface paramAppInterface)
  {
    if (((paramObject instanceof TeamWorkFileImportInfo)) && ((paramAppInterface instanceof QQAppInterface))) {
      return new TeamWorkFileImportJobForGroup((TeamWorkFileImportInfo)paramObject, (QQAppInterface)paramAppInterface);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.RelyClassCreatorImpl
 * JD-Core Version:    0.7.0.1
 */