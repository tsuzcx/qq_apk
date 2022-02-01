package com.tencent.mobileqq.vip;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;

public class KCWraperV2InOtherProcess
  extends KCWraper
{
  String a()
  {
    return "KC.KCWraper.Other";
  }
  
  void a(ViewGroup paramViewGroup)
  {
    a("can not call bindActivationView");
  }
  
  void a(TMSManager.Callback paramCallback, boolean paramBoolean)
  {
    a("queryKingCard : from cache");
    Pair localPair = a();
    if (paramCallback != null)
    {
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new KCWraperV2InOtherProcess.1(this, paramCallback, localPair));
      }
    }
    else {
      return;
    }
    paramCallback.a(true, ((Boolean)localPair.first).booleanValue(), ((Integer)localPair.second).intValue());
  }
  
  void a(Runnable paramRunnable)
  {
    a("tryLoad : do nothing");
  }
  
  boolean a()
  {
    a("isReady : do nothing");
    return true;
  }
  
  boolean a(Activity paramActivity)
  {
    if (c())
    {
      PublicFragmentActivity.a(paramActivity, KingCardActivationFragment.class);
      return true;
    }
    return false;
  }
  
  boolean b()
  {
    boolean bool = c();
    a("supportActivationView = " + bool);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KCWraperV2InOtherProcess
 * JD-Core Version:    0.7.0.1
 */