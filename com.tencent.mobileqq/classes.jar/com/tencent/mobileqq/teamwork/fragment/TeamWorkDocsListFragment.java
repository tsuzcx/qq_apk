package com.tencent.mobileqq.teamwork.fragment;

import ayfr;
import ayfv;
import bcdq;
import bcet;
import bcfm;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import xmt;

public class TeamWorkDocsListFragment
  extends WebViewFragment
{
  public void c()
  {
    bcet localbcet = (bcet)this.jdField_a_of_type_Bcdq.a(4);
    if (localbcet != null)
    {
      xmt localxmt = b();
      if ((localxmt != null) && (ayfv.a(localxmt.a()))) {
        localbcet.a = new ayfr(a());
      }
      localbcet.a(localxmt, this.jdField_a_of_type_Bcfm.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment
 * JD-Core Version:    0.7.0.1
 */