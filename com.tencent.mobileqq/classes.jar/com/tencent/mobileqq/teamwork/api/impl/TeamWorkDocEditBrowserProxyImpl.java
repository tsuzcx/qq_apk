package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;

public class TeamWorkDocEditBrowserProxyImpl
  implements ITeamWorkDocEditBrowserProxy
{
  public Intent getClassIntent(Context paramContext)
  {
    return new Intent(paramContext, TeamWorkDocEditBrowserActivity.class);
  }
  
  public Intent getOpenTeamWorkIntent(Intent paramIntent, String paramString, Context paramContext)
  {
    return TeamWorkDocEditBrowserActivity.a(paramIntent, paramString, paramContext);
  }
  
  public boolean isInstanceClass(Activity paramActivity)
  {
    return paramActivity instanceof TeamWorkDocEditBrowserActivity;
  }
  
  public boolean openDocsMiniApp(Context paramContext, String paramString1, String paramString2)
  {
    return TeamWorkDocEditBrowserActivity.a(paramContext, paramString1, paramString2);
  }
  
  public void openTeamWorkDocEditBrowserActivity(Context paramContext, Bundle paramBundle, boolean paramBoolean)
  {
    TeamWorkDocEditBrowserActivity.a(paramContext, paramBundle, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkDocEditBrowserProxyImpl
 * JD-Core Version:    0.7.0.1
 */