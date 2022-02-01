package com.tencent.mobileqq.teamwork.fragment;

import abcr;
import android.app.Activity;
import android.content.Intent;
import bdjd;
import bdjg;
import bhos;
import bhpv;
import bhqo;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class TeamWorkDocsListFragment
  extends WebViewFragment
{
  public void showActionSheet()
  {
    bhpv localbhpv = (bhpv)this.mComponentsProvider.a(4);
    if (localbhpv != null)
    {
      abcr localabcr = ensureShare();
      if ((localabcr != null) && (bdjg.a(localabcr.a())))
      {
        getHostActivity().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
        localbhpv.a = new bdjd(getHostActivity());
      }
      localbhpv.a(localabcr, this.mUIStyle.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment
 * JD-Core Version:    0.7.0.1
 */