package com.tencent.mobileqq.statistics;

import aclo;
import aohi;
import aoog;
import avty;
import avub;
import awoi;
import bbnu;
import bdhp;
import bdkc;
import bdki;
import bdlg;
import biis;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.ChatItemAnimLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerInitialler;
import com.tencent.mobileqq.javahook.BGLocateMonitor;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.open.base.MD5Utils;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;
import zfc;

public final class CaughtExceptionReport$1
  extends HashSet<String>
{
  public CaughtExceptionReport$1(int paramInt)
  {
    super(paramInt);
    add(BaseActivity.class.getName());
    add(bdkc.class.getName());
    add(biis.class.getName());
    add(bdhp.class.getName());
    add(zfc.class.getName());
    add(bbnu.class.getName());
    add(aclo.class.getName());
    add(SingleLineTextView.class.getName());
    add(BaseBubbleBuilder.class.getName());
    add(ChatItemAnimLayout.class.getName());
    add(SecurityUtile.class.getName());
    add(aoog.class.getName());
    add(avub.class.getName());
    add(avty.class.getName());
    add(awoi.class.getName());
    add(bdki.class.getName());
    add(ThreadManagerInitialler.class.getName());
    add(bdlg.class.getName());
    add(MD5Utils.class.getName());
    add(aohi.class.getName());
    add(BGLocateMonitor.class.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.CaughtExceptionReport.1
 * JD-Core Version:    0.7.0.1
 */