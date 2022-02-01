package com.tencent.mobileqq.kandian.biz.viola;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoader;
import com.tencent.mobileqq.kandian.biz.push.OnTabRedNumsChangeListenner;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.qwallet.utils.FlymeOSStatusBarFontUtils;
import org.json.JSONObject;

public class ReadInJoySelfCenterViolaFragment
  extends ReadInJoyViolaChannelFragment
  implements OnTabRedNumsChangeListenner
{
  private ReadInJoyObserver o = new ReadInJoySelfCenterViolaFragment.1(this);
  
  public static ReadInJoySelfCenterViolaFragment a(String paramString)
  {
    ReadInJoySelfCenterViolaFragment localReadInJoySelfCenterViolaFragment = new ReadInJoySelfCenterViolaFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("url_key", paramString);
    localReadInJoySelfCenterViolaFragment.setArguments(localBundle);
    return localReadInJoySelfCenterViolaFragment;
  }
  
  private void x()
  {
    if (u() != null)
    {
      int i = u().getTabRedNums(3);
      if ((this.m != null) && (this.m.c())) {
        this.m.a(ViolaBizUtils.a(i).toString());
      }
    }
  }
  
  private void y()
  {
    if (u() != null) {
      u().clearMsgBoxRedPnt();
    }
  }
  
  private void z()
  {
    if (MxFlutterResourceLoader.a.d()) {
      MxFlutterResourceLoader.a.a("4630", true, null);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    b(paramBoolean, paramActivity, paramBundle);
    x();
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void da_()
  {
    x();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      Object localObject = localBundle.getString("url_key");
      int i = u().getTabRedNums(3);
      paramBundle = (Bundle)localObject;
      if (i > 0)
      {
        paramBundle = new StringBuilder();
        paramBundle.append((String)localObject);
        paramBundle.append("&unreadMessageCount=");
        paramBundle.append(i);
        paramBundle = paramBundle.toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("&statusBarStyle=0");
      paramBundle = ((StringBuilder)localObject).toString();
      if (!TextUtils.isEmpty(paramBundle)) {
        b(paramBundle);
      }
      this.c = localBundle.getString("channel_version_key", "");
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.o);
    FlymeOSStatusBarFontUtils.a(v(), true);
    z();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.o);
  }
  
  public void onResume()
  {
    super.onResume();
    x();
  }
  
  public void t()
  {
    x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.ReadInJoySelfCenterViolaFragment
 * JD-Core Version:    0.7.0.1
 */