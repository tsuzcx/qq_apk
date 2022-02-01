package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.IShareUtils;
import com.tencent.mobileqq.teamwork.api.ICameraHelper;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.IVoiceInputHelper;
import com.tencent.mobileqq.teamworkforgroup.ShareUtils;
import com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class TeamWorkFacadeCreatorImpl
  implements ITeamWorkFacadeCreator
{
  public ICameraHelper getCameraHelper(WebViewPlugin paramWebViewPlugin)
  {
    return new CameraHelperImpl(paramWebViewPlugin);
  }
  
  public String getExportHandlerName()
  {
    return TeamWorkFileExportHandlerImpl.getClassName();
  }
  
  public String getGroupTeamWorkHandlerName()
  {
    return GroupTeamWorkHandlerImpl.getClassName();
  }
  
  public IVoiceInputHelper getIVoiceInputHelper(WebViewPlugin paramWebViewPlugin)
  {
    return new VoiceInputHelperImpl(paramWebViewPlugin);
  }
  
  public String getImportHandlerName()
  {
    return TeamWorkFileImportHandlerImpl.getClassName();
  }
  
  public IShareUtils getShareUtils(Activity paramActivity, AppInterface paramAppInterface)
  {
    return new ShareUtils(paramActivity, paramAppInterface);
  }
  
  public Class getTeamWorkHandlerClass()
  {
    return TeamWorkHandlerImpl.class;
  }
  
  public String getTeamWorkHandlerName()
  {
    return TeamWorkHandlerImpl.getClassName();
  }
  
  public Dialog getTroopTeamWorkFileSearchDialog(Activity paramActivity, View paramView, AppInterface paramAppInterface, long paramLong)
  {
    return new TroopTeamWorkFileSearchDialog(paramActivity, paramView, paramAppInterface, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFacadeCreatorImpl
 * JD-Core Version:    0.7.0.1
 */