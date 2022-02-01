package com.tencent.mobileqq.kandian.biz.viola;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.viola.contract.IViolaFragmentCommonContract;
import com.tencent.mobileqq.kandian.biz.viola.contract.ViolaFragmentCommonLogicContract;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.glue.router.ReadInJoyDailyJumpToKDTabUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaUiDelegate;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaChannelVisibilityChangedEvent;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;
import com.tencent.mobileqq.kandian.glue.viola.wormhole.WormholeEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.liveroom.LiveRoomHelper;
import cooperation.liveroom.LiveRoomPluginInstaller;
import cooperation.liveroom.LiveRoomPluginLoader;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyViolaChannelFragment
  extends ReadInJoyBaseFragment
  implements IViolaFragmentCommonContract
{
  private static ReadInJoyViolaChannelFragment.GuidingJumpPendingInfo r;
  protected int a = -1;
  protected String b = "viola";
  protected String c;
  protected ViewGroup d;
  protected ViolaBaseView m;
  public boolean n = true;
  private LinearLayout o;
  private ViolaUiDelegate p;
  private String q;
  private ViolaFragmentCommonLogicContract s = new ViolaFragmentCommonLogicContract();
  
  private void A()
  {
    if (this.o.getVisibility() == 0) {
      this.o.setVisibility(8);
    }
  }
  
  private void B()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reload viola Page mChannelName :");
      localStringBuilder.append(this.b);
      localStringBuilder.append("; mChannelId :");
      localStringBuilder.append(this.a);
      QLog.d("ReadInJoyViolaChannelFragment", 2, localStringBuilder.toString());
    }
    z();
    this.m.a(new ReadInJoyViolaChannelFragment.4(this));
  }
  
  public static ReadInJoyViolaChannelFragment a(int paramInt, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("channel_id", paramInt);
    localBundle.putString("channel_name", paramString1);
    localBundle.putString("channel_version", paramString2);
    paramString1 = new ReadInJoyViolaChannelFragment();
    paramString1.setArguments(localBundle);
    return paramString1;
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (r == null) {
      r = new ReadInJoyViolaChannelFragment.GuidingJumpPendingInfo(null);
    }
    ReadInJoyViolaChannelFragment.GuidingJumpPendingInfo localGuidingJumpPendingInfo = r;
    localGuidingJumpPendingInfo.a = paramInt;
    localGuidingJumpPendingInfo.b = new String(Base64.decode(paramString, 0));
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("saveGuidingJumpPendingInfo, channelId: ");
      paramString.append(paramInt);
      paramString.append(", url: ");
      paramString.append(r.b);
      QLog.d("ReadInJoyViolaChannelFragment", 2, paramString.toString());
    }
  }
  
  private void d(int paramInt)
  {
    Object localObject = r;
    if (localObject == null) {
      return;
    }
    if (paramInt == ((ReadInJoyViolaChannelFragment.GuidingJumpPendingInfo)localObject).a)
    {
      this.q = r.b;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("replaceViolaUrl, channelId: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", url: ");
        ((StringBuilder)localObject).append(r.b);
        QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    localObject = r;
    ((ReadInJoyViolaChannelFragment.GuidingJumpPendingInfo)localObject).a = -1;
    ((ReadInJoyViolaChannelFragment.GuidingJumpPendingInfo)localObject).b = null;
  }
  
  private void x()
  {
    try
    {
      if ((this.a == 41726) && (!TextUtils.isEmpty(this.q)) && (this.q.contains("v_bg_color")) && (this.d != null))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(ViolaAccessHelper.a(this.q, "v_bg_color"));
        localObject = ((StringBuilder)localObject).toString();
        this.d.setBackgroundColor(Color.parseColor((String)localObject));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ReadInJoyViolaChannelFragment", 1, localThrowable.getMessage());
    }
  }
  
  private void y()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void z()
  {
    if (this.o.getVisibility() == 8) {
      this.o.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if ((paramInt == 5) || (paramInt == 3))
    {
      ViolaBaseView localViolaBaseView = this.m;
      if ((localViolaBaseView != null) && (localViolaBaseView.c())) {
        this.m.a(ViolaBizUtils.b(2).toString());
      }
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("notifyShowSelf mChannelName :");
      paramActivity.append(this.b);
      paramActivity.append("; mChannelId :");
      paramActivity.append(this.a);
      QLog.d("ReadInJoyViolaChannelFragment", 2, paramActivity.toString());
    }
    paramActivity = this.m;
    if ((paramActivity != null) && (paramActivity.b()) && (e()) && (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()))
    {
      if (!this.n)
      {
        this.m.onActivityResume();
        this.n = true;
      }
      this.m.a(true);
      SimpleEventBus.getInstance().dispatchEvent(new ViolaChannelVisibilityChangedEvent(true, this.m.getViolaInstanceId()));
    }
    else if ((this.d != null) && (this.m == null))
    {
      y();
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(3, null);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void b(String paramString)
  {
    this.q = ViolaAccessHelper.a(paramString);
  }
  
  public void b(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
  }
  
  public int d()
  {
    return this.a;
  }
  
  public void g()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyTabDoubleClick mChannelName :");
      localStringBuilder.append(this.b);
      localStringBuilder.append("; mChannelId :");
      localStringBuilder.append(this.a);
      QLog.d("ReadInJoyViolaChannelFragment", 2, localStringBuilder.toString());
    }
    super.g();
  }
  
  @NonNull
  public String getBusinessDescription()
  {
    return this.s.a();
  }
  
  public void h() {}
  
  public void k()
  {
    super.k();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyHideSelf mChannelName :");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("; mChannelId :");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.m;
    if (localObject != null)
    {
      ((ViolaBaseView)localObject).f();
      if (this.m.c())
      {
        this.m.a(false);
        SimpleEventBus.getInstance().dispatchEvent(new ViolaChannelVisibilityChangedEvent(false, this.m.getViolaInstanceId()));
      }
    }
  }
  
  public void l()
  {
    super.l();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("notifyClickSelf mChannelName :");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append("; mChannelId :");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ViolaChanel_");
    ((StringBuilder)localObject1).append(this.q);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = this.m;
    if ((localObject2 != null) && (((ViolaBaseView)localObject2).c())) {
      localObject2 = new ArrayList();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", this.q);
      if ((((ArrayList)localObject2).size() == 0) && (!TextUtils.isEmpty(this.q)))
      {
        localObject3 = Uri.parse(this.q);
        if (((Uri)localObject3).isHierarchical()) {
          ((ArrayList)localObject2).add(((Uri)localObject3).getHost());
        }
      }
      Object localObject3 = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      ((Intent)localObject3).putExtra("broadcast", true);
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(String.valueOf(System.currentTimeMillis()));
      ((StringBuilder)localObject4).append((int)(Math.random() * 1000000.0D));
      ((Intent)localObject3).putExtra("unique", ((StringBuilder)localObject4).toString());
      ((Intent)localObject3).putExtra("event", (String)localObject1);
      localObject4 = new JSONObject();
      ((JSONObject)localObject4).put("eventName", "tabClick");
      ((Intent)localObject3).putExtra("data", ((JSONObject)localObject4).toString());
      ((Intent)localObject3).putStringArrayListExtra("domains", (ArrayList)localObject2);
      ((Intent)localObject3).putExtra("source", localJSONObject.toString());
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyViolaChannelFragment", 2, String.format("send event broadcast, event: %s, data: %s, domains: %s, source: %s", new Object[] { localObject1, ((JSONObject)localObject4).toString(), TextUtils.join(",", (Iterable)localObject2), localJSONObject }));
      }
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject3, "com.tencent.msg.permission.pushnotify");
    }
    catch (JSONException localJSONException)
    {
      label377:
      break label377;
    }
    this.m.a(ViolaBizUtils.b(1).toString());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ViolaBaseView localViolaBaseView = this.m;
    if (localViolaBaseView != null) {
      localViolaBaseView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.a = localBundle.getInt("channel_id");
      this.b = localBundle.getString("channel_name");
      this.c = localBundle.getString("channel_version");
      int i = this.a;
      if ((i == 41660) || (i == 8)) {
        if (LiveRoomHelper.isPluginInstalledInQQ()) {
          LiveRoomPluginLoader.preLoadPlugin();
        } else {
          LiveRoomPluginInstaller.getInstance().installFromQQ(null, "Readinjoy pre");
        }
      }
      d(this.a);
    }
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @android.support.annotation.Nullable ViewGroup paramViewGroup, @android.support.annotation.Nullable Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append("onCreateView mChannelName :");
      paramLayoutInflater.append(this.b);
      paramLayoutInflater.append("; mChannelId :");
      paramLayoutInflater.append(this.a);
      QLog.d("ReadInJoyViolaChannelFragment", 2, paramLayoutInflater.toString());
    }
    this.e = LayoutInflater.from(v());
    this.d = ((ViewGroup)this.e.inflate(2131624045, paramViewGroup, false));
    this.o = ((LinearLayout)this.d.findViewById(2131441404));
    this.o.setOnClickListener(null);
    this.p = new ViolaUiDelegate(this);
    if ((getUserVisibleHint()) || (!ReadInJoyUtils.g())) {
      y();
    }
    VideoReport.setPageId(this.d, "14");
    VideoReport.setPageParams(this.d, new RIJDtParamBuilder().a(Integer.valueOf(this.a)).b());
    x();
    WormholeEngine.a();
    return this.d;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy mChannelName :");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("; mChannelId :");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.m;
    if (localObject != null) {}
    try
    {
      ((ViolaBaseView)localObject).onActivityDestroy();
      this.d.removeAllViews();
      this.m = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPause mChannelName :");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("; mChannelId :");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.m;
    if (localObject != null)
    {
      ((ViolaBaseView)localObject).onActivityPause();
      if (this.m.c()) {
        this.m.a(false);
      }
    }
    this.n = false;
  }
  
  public void onResume()
  {
    super.onResume();
    ViolaBaseView localViolaBaseView = this.m;
    if (localViolaBaseView != null) {
      if ((localViolaBaseView.b()) && (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()) && (e()))
      {
        this.m.onActivityResume();
        this.m.a(true);
        this.n = true;
      }
      else
      {
        this.n = false;
      }
    }
    if (getActivity() != null) {
      ReadInJoyDailyJumpToKDTabUtils.a(getActivity(), getActivity().getIntent(), d());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStart mChannelName :");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("; mChannelId :");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject).toString());
    }
    VideoReport.addToDetectionWhitelist(v());
    Object localObject = this.m;
    if (localObject != null) {
      ((ViolaBaseView)localObject).onActivityStart();
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(3, null);
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStop mChannelName :");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("; mChannelId :");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.m;
    if (localObject != null)
    {
      ((ViolaBaseView)localObject).onActivityStop();
      if (this.m.c()) {
        this.m.a(false);
      }
    }
  }
  
  public void openFrameDropUpload(@org.jetbrains.annotations.Nullable String paramString)
  {
    ViolaFragmentCommonLogicContract localViolaFragmentCommonLogicContract = this.s;
    if (localViolaFragmentCommonLogicContract != null) {
      localViolaFragmentCommonLogicContract.openFrameDropUpload(paramString);
    }
  }
  
  public String p()
  {
    return this.c;
  }
  
  public boolean q()
  {
    return false;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    ViolaBaseView localViolaBaseView = this.m;
    if (localViolaBaseView != null)
    {
      boolean bool;
      if (paramBoolean)
      {
        bool = localViolaBaseView.b();
        this.m.onActivityResume();
        if ((bool) && (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()) && (e())) {
          this.m.a(true);
        }
        this.n = true;
      }
      else
      {
        bool = localViolaBaseView.c();
        this.m.onActivityPause();
        if (bool) {
          this.m.a(false);
        }
        this.n = false;
      }
    }
    super.setUserVisibleHint(paramBoolean);
  }
  
  public boolean w()
  {
    ViolaBaseView localViolaBaseView = this.m;
    if (localViolaBaseView != null) {
      return localViolaBaseView.e();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.ReadInJoyViolaChannelFragment
 * JD-Core Version:    0.7.0.1
 */