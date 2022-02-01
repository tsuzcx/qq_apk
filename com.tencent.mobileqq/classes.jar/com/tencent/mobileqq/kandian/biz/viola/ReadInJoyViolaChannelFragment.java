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
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.viola.contract.IViolaFragmentCommonContract;
import com.tencent.mobileqq.kandian.biz.viola.contract.ViolaFragmentCommonLogicContract;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaUiDelegate;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaChannelVisibilityChangedEvent;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;
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
  private static ReadInJoyViolaChannelFragment.GuidingJumpPendingInfo jdField_a_of_type_ComTencentMobileqqKandianBizViolaReadInJoyViolaChannelFragment$GuidingJumpPendingInfo;
  protected int a;
  protected ViewGroup a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ViolaFragmentCommonLogicContract jdField_a_of_type_ComTencentMobileqqKandianBizViolaContractViolaFragmentCommonLogicContract = new ViolaFragmentCommonLogicContract();
  private ViolaUiDelegate jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate;
  protected ViolaBaseView a;
  protected String a;
  protected String b;
  private String c;
  private boolean e = true;
  
  public ReadInJoyViolaChannelFragment()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "viola";
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
  
  private void a()
  {
    try
    {
      if ((this.jdField_a_of_type_Int == 41726) && (!TextUtils.isEmpty(this.c)) && (this.c.contains("v_bg_color")) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(ViolaAccessHelper.a(this.c, "v_bg_color"));
        localObject = ((StringBuilder)localObject).toString();
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(Color.parseColor((String)localObject));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ReadInJoyViolaChannelFragment", 1, localThrowable.getMessage());
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqKandianBizViolaReadInJoyViolaChannelFragment$GuidingJumpPendingInfo == null) {
      jdField_a_of_type_ComTencentMobileqqKandianBizViolaReadInJoyViolaChannelFragment$GuidingJumpPendingInfo = new ReadInJoyViolaChannelFragment.GuidingJumpPendingInfo(null);
    }
    ReadInJoyViolaChannelFragment.GuidingJumpPendingInfo localGuidingJumpPendingInfo = jdField_a_of_type_ComTencentMobileqqKandianBizViolaReadInJoyViolaChannelFragment$GuidingJumpPendingInfo;
    localGuidingJumpPendingInfo.jdField_a_of_type_Int = paramInt;
    localGuidingJumpPendingInfo.jdField_a_of_type_JavaLangString = new String(Base64.decode(paramString, 0));
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("saveGuidingJumpPendingInfo, channelId: ");
      paramString.append(paramInt);
      paramString.append(", url: ");
      paramString.append(jdField_a_of_type_ComTencentMobileqqKandianBizViolaReadInJoyViolaChannelFragment$GuidingJumpPendingInfo.jdField_a_of_type_JavaLangString);
      QLog.d("ReadInJoyViolaChannelFragment", 2, paramString.toString());
    }
  }
  
  private void c(int paramInt)
  {
    Object localObject = jdField_a_of_type_ComTencentMobileqqKandianBizViolaReadInJoyViolaChannelFragment$GuidingJumpPendingInfo;
    if (localObject == null) {
      return;
    }
    if (paramInt == ((ReadInJoyViolaChannelFragment.GuidingJumpPendingInfo)localObject).jdField_a_of_type_Int)
    {
      this.c = jdField_a_of_type_ComTencentMobileqqKandianBizViolaReadInJoyViolaChannelFragment$GuidingJumpPendingInfo.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("replaceViolaUrl, channelId: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", url: ");
        ((StringBuilder)localObject).append(jdField_a_of_type_ComTencentMobileqqKandianBizViolaReadInJoyViolaChannelFragment$GuidingJumpPendingInfo.jdField_a_of_type_JavaLangString);
        QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    localObject = jdField_a_of_type_ComTencentMobileqqKandianBizViolaReadInJoyViolaChannelFragment$GuidingJumpPendingInfo;
    ((ReadInJoyViolaChannelFragment.GuidingJumpPendingInfo)localObject).jdField_a_of_type_Int = -1;
    ((ReadInJoyViolaChannelFragment.GuidingJumpPendingInfo)localObject).jdField_a_of_type_JavaLangString = null;
  }
  
  private void i()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reload viola Page mChannelName :");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("; mChannelId :");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("ReadInJoyViolaChannelFragment", 2, localStringBuilder.toString());
    }
    j();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(new ReadInJoyViolaChannelFragment.4(this));
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if ((paramInt == 5) || (paramInt == 3))
    {
      ViolaBaseView localViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
      if ((localViolaBaseView != null) && (localViolaBaseView.c())) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(ViolaBizUtils.b(2).toString());
      }
    }
  }
  
  public void a(String paramString)
  {
    this.c = ViolaAccessHelper.a(paramString);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("notifyShowSelf mChannelName :");
      paramActivity.append(this.jdField_a_of_type_JavaLangString);
      paramActivity.append("; mChannelId :");
      paramActivity.append(this.jdField_a_of_type_Int);
      QLog.d("ReadInJoyViolaChannelFragment", 2, paramActivity.toString());
    }
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if ((paramActivity != null) && (paramActivity.b()) && (b()) && (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()))
    {
      if (!this.e)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.onActivityResume();
        this.e = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(true);
      SimpleEventBus.getInstance().dispatchEvent(new ViolaChannelVisibilityChangedEvent(true, this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a()));
    }
    else if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView == null))
    {
      i();
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(3, null);
  }
  
  public void az_()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyTabDoubleClick mChannelName :");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("; mChannelId :");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("ReadInJoyViolaChannelFragment", 2, localStringBuilder.toString());
    }
    super.az_();
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
  }
  
  public void d() {}
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyHideSelf mChannelName :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("; mChannelId :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localObject != null)
    {
      ((ViolaBaseView)localObject).b();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.c())
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(false);
        SimpleEventBus.getInstance().dispatchEvent(new ViolaChannelVisibilityChangedEvent(false, this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a()));
      }
    }
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("notifyClickSelf mChannelName :");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("; mChannelId :");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ViolaChanel_");
    ((StringBuilder)localObject1).append(this.c);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if ((localObject2 != null) && (((ViolaBaseView)localObject2).c())) {
      localObject2 = new ArrayList();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", this.c);
      if ((((ArrayList)localObject2).size() == 0) && (!TextUtils.isEmpty(this.c)))
      {
        localObject3 = Uri.parse(this.c);
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
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(ViolaBizUtils.b(1).toString());
  }
  
  protected boolean f()
  {
    return true;
  }
  
  public boolean g()
  {
    ViolaBaseView localViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localViolaBaseView != null) {
      return localViolaBaseView.d();
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ViolaBaseView localViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localViolaBaseView != null) {
      localViolaBaseView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.jdField_a_of_type_Int = localBundle.getInt("channel_id");
      this.jdField_a_of_type_JavaLangString = localBundle.getString("channel_name");
      this.b = localBundle.getString("channel_version");
      int i = this.jdField_a_of_type_Int;
      if ((i == 41660) || (i == 8)) {
        if (LiveRoomHelper.isPluginInstalledInQQ()) {
          LiveRoomPluginLoader.preLoadPlugin();
        } else {
          LiveRoomPluginInstaller.getInstance().installFromQQ(null, "Readinjoy pre");
        }
      }
      c(this.jdField_a_of_type_Int);
    }
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @android.support.annotation.Nullable ViewGroup paramViewGroup, @android.support.annotation.Nullable Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append("onCreateView mChannelName :");
      paramLayoutInflater.append(this.jdField_a_of_type_JavaLangString);
      paramLayoutInflater.append("; mChannelId :");
      paramLayoutInflater.append(this.jdField_a_of_type_Int);
      QLog.d("ReadInJoyViolaChannelFragment", 2, paramLayoutInflater.toString());
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558494, paramViewGroup, false));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373730));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaUiDelegate = new ViolaUiDelegate(this);
    if ((getUserVisibleHint()) || (!ReadInJoyUtils.a())) {
      i();
    }
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewViewGroup, "14");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewViewGroup, new RIJDtParamBuilder().a(Integer.valueOf(this.jdField_a_of_type_Int)).a());
    a();
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy mChannelName :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("; mChannelId :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localObject != null) {}
    try
    {
      ((ViolaBaseView)localObject).onActivityDestroy();
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView = null;
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("; mChannelId :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localObject != null)
    {
      ((ViolaBaseView)localObject).onActivityPause();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.c()) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(false);
      }
    }
    this.e = false;
  }
  
  public void onResume()
  {
    super.onResume();
    ViolaBaseView localViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localViolaBaseView != null)
    {
      if ((localViolaBaseView.b()) && (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()) && (b()))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.onActivityResume();
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(true);
        this.e = true;
        return;
      }
      this.e = false;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStart mChannelName :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("; mChannelId :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject).toString());
    }
    VideoReport.addToDetectionWhitelist(a());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("; mChannelId :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("ReadInJoyViolaChannelFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localObject != null)
    {
      ((ViolaBaseView)localObject).onActivityStop();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.c()) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(false);
      }
    }
  }
  
  public void openFrameDropUpload(@org.jetbrains.annotations.Nullable String paramString)
  {
    ViolaFragmentCommonLogicContract localViolaFragmentCommonLogicContract = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaContractViolaFragmentCommonLogicContract;
    if (localViolaFragmentCommonLogicContract != null) {
      localViolaFragmentCommonLogicContract.openFrameDropUpload(paramString);
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    ViolaBaseView localViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localViolaBaseView != null)
    {
      boolean bool;
      if (paramBoolean)
      {
        bool = localViolaBaseView.b();
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.onActivityResume();
        if ((bool) && (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()) && (b())) {
          this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(true);
        }
        this.e = true;
      }
      else
      {
        bool = localViolaBaseView.c();
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.onActivityPause();
        if (bool) {
          this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(false);
        }
        this.e = false;
      }
    }
    super.setUserVisibleHint(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.ReadInJoyViolaChannelFragment
 * JD-Core Version:    0.7.0.1
 */