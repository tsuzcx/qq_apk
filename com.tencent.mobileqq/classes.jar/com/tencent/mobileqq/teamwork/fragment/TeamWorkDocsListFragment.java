package com.tencent.mobileqq.teamwork.fragment;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;

public class TeamWorkDocsListFragment
  extends WebViewFragment
{
  public void showActionSheet()
  {
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.mComponentsProvider.a(4);
    if (localSwiftBrowserShareMenuHandler != null)
    {
      Share localShare = ensureShare();
      if ((localShare != null) && (TeamWorkUtils.a(localShare.a())))
      {
        getHostActivity().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
        localSwiftBrowserShareMenuHandler.a = new TeamWorkShareActionSheetBuilder(getHostActivity());
      }
      localSwiftBrowserShareMenuHandler.a(localShare, this.mUIStyle.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment
 * JD-Core Version:    0.7.0.1
 */