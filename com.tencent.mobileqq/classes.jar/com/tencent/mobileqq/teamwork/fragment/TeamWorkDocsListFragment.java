package com.tencent.mobileqq.teamwork.fragment;

import ayft;
import ayfx;
import bcee;
import bcfh;
import bcga;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import xmq;

public class TeamWorkDocsListFragment
  extends WebViewFragment
{
  public void c()
  {
    bcfh localbcfh = (bcfh)this.jdField_a_of_type_Bcee.a(4);
    if (localbcfh != null)
    {
      xmq localxmq = b();
      if ((localxmq != null) && (ayfx.a(localxmq.a()))) {
        localbcfh.a = new ayft(a());
      }
      localbcfh.a(localxmq, this.jdField_a_of_type_Bcga.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment
 * JD-Core Version:    0.7.0.1
 */