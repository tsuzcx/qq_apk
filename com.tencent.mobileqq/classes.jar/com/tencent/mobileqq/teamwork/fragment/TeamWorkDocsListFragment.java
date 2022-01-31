package com.tencent.mobileqq.teamwork.fragment;

import axfo;
import axfs;
import bbaq;
import bbbt;
import bbcm;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import xdt;

public class TeamWorkDocsListFragment
  extends WebViewFragment
{
  public void c()
  {
    bbbt localbbbt = (bbbt)this.jdField_a_of_type_Bbaq.a(4);
    if (localbbbt != null)
    {
      xdt localxdt = b();
      if ((localxdt != null) && (axfs.a(localxdt.a()))) {
        localbbbt.a = new axfo(a());
      }
      localbbbt.a(localxdt, this.jdField_a_of_type_Bbcm.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment
 * JD-Core Version:    0.7.0.1
 */