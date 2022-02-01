package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Intent;

public class ForwardData
{
  private String a;
  private String b;
  private int c;
  private boolean d;
  private int e;
  private int f;
  
  public ForwardData a(Intent paramIntent)
  {
    this.a = paramIntent.getStringExtra("targetUin");
    this.b = paramIntent.getStringExtra("srcDiscGroup");
    this.c = paramIntent.getIntExtra("peerType", 0);
    this.d = paramIntent.getBooleanExtra("rootEntrace", true);
    this.e = paramIntent.getIntExtra("busiType", 0);
    this.f = paramIntent.getIntExtra("enterfrom", 0);
    return this;
  }
  
  public boolean a()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ForwardData
 * JD-Core Version:    0.7.0.1
 */