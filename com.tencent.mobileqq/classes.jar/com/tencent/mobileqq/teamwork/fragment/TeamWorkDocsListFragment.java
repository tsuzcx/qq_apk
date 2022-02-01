package com.tencent.mobileqq.teamwork.fragment;

import aasr;
import android.app.Activity;
import android.content.Intent;
import beco;
import becr;
import bigl;
import biho;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;

public class TeamWorkDocsListFragment
  extends WebViewFragment
{
  public void showActionSheet()
  {
    biho localbiho = (biho)this.mComponentsProvider.a(4);
    if (localbiho != null)
    {
      aasr localaasr = ensureShare();
      if ((localaasr != null) && (becr.a(localaasr.a())))
      {
        getHostActivity().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
        localbiho.a = new beco(getHostActivity());
      }
      localbiho.a(localaasr, this.mUIStyle.mRulesFromUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment
 * JD-Core Version:    0.7.0.1
 */