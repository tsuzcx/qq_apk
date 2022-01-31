package com.tencent.mobileqq.teamwork.fragment;

import android.app.Activity;
import android.content.Intent;
import bahz;
import baic;
import beho;
import beir;
import bejk;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import zfy;

public class TeamWorkDocsListFragment
  extends WebViewFragment
{
  public void c()
  {
    beir localbeir = (beir)this.jdField_a_of_type_Beho.a(4);
    if (localbeir != null)
    {
      zfy localzfy = b();
      if ((localzfy != null) && (baic.a(localzfy.a())))
      {
        a().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
        localbeir.a = new bahz(a());
      }
      localbeir.a(localzfy, this.jdField_a_of_type_Bejk.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment
 * JD-Core Version:    0.7.0.1
 */