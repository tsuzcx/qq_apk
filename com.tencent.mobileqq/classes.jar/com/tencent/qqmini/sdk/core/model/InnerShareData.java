package com.tencent.qqmini.sdk.core.model;

import android.app.Activity;
import bgjo;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.model.ShareData;

public class InnerShareData
  extends ShareData
{
  public Activity a;
  public EntryModel a;
  public ShareChatModel a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public int a()
  {
    switch (this.shareTarget)
    {
    default: 
      return 6;
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 4;
  }
  
  public MiniAppInfo a()
  {
    return this.miniAppInfo;
  }
  
  public void a()
  {
    bgjo.a().a(this);
  }
  
  public void b()
  {
    bgjo.a().c(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.model.InnerShareData
 * JD-Core Version:    0.7.0.1
 */