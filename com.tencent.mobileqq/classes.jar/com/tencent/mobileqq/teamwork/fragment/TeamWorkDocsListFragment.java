package com.tencent.mobileqq.teamwork.fragment;

import aadf;
import android.app.Activity;
import android.content.Intent;
import bcvp;
import bcvs;
import bgvt;
import bgww;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;

public class TeamWorkDocsListFragment
  extends WebViewFragment
{
  public void showActionSheet()
  {
    bgww localbgww = (bgww)this.mComponentsProvider.a(4);
    if (localbgww != null)
    {
      aadf localaadf = ensureShare();
      if ((localaadf != null) && (bcvs.a(localaadf.a())))
      {
        getHostActivity().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
        localbgww.a = new bcvp(getHostActivity());
      }
      localbgww.a(localaadf, this.mUIStyle.mRulesFromUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment
 * JD-Core Version:    0.7.0.1
 */