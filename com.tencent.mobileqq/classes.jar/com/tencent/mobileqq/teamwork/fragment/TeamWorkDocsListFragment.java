package com.tencent.mobileqq.teamwork.fragment;

import abgu;
import android.app.Activity;
import android.content.Intent;
import beby;
import becb;
import bipn;
import biqq;
import birj;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class TeamWorkDocsListFragment
  extends WebViewFragment
{
  public void showActionSheet()
  {
    biqq localbiqq = (biqq)this.mComponentsProvider.a(4);
    if (localbiqq != null)
    {
      abgu localabgu = ensureShare();
      if ((localabgu != null) && (becb.a(localabgu.a())))
      {
        getHostActivity().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
        localbiqq.a = new beby(getHostActivity());
      }
      localbiqq.a(localabgu, this.mUIStyle.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment
 * JD-Core Version:    0.7.0.1
 */