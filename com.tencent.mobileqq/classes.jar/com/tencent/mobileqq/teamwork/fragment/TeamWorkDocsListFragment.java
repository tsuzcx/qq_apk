package com.tencent.mobileqq.teamwork.fragment;

import android.app.Activity;
import android.content.Intent;
import badq;
import badt;
import bedf;
import beei;
import befb;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import zbj;

public class TeamWorkDocsListFragment
  extends WebViewFragment
{
  public void c()
  {
    beei localbeei = (beei)this.jdField_a_of_type_Bedf.a(4);
    if (localbeei != null)
    {
      zbj localzbj = b();
      if ((localzbj != null) && (badt.a(localzbj.a())))
      {
        a().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
        localbeei.a = new badq(a());
      }
      localbeei.a(localzbj, this.jdField_a_of_type_Befb.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment
 * JD-Core Version:    0.7.0.1
 */