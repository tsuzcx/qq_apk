package com.tencent.mobileqq.teamwork.fragment;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;

public class TeamWorkDocsListFragment
  extends WebViewFragment
{
  public void showActionSheet()
  {
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.mComponentsProvider.a(4);
    if (localSwiftBrowserShareMenuHandler != null)
    {
      Share localShare = (Share)getShare();
      if ((localShare != null) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsUrl(localShare.getShareUrl())))
      {
        getHostActivity().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
        localSwiftBrowserShareMenuHandler.a = new TeamWorkShareActionSheetBuilder(getHostActivity());
      }
      localSwiftBrowserShareMenuHandler.a(localShare, getUIStyle().a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment
 * JD-Core Version:    0.7.0.1
 */