package com.tencent.tkd.topicsdk.debug;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/debug/DebugView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "enterPublishHideAssociate", "", "enterPublishOnlyShowCommunity", "enterPublishOnlyShowTopic", "enterPublishShowTopicAndCommunity", "enterPublishWithCommunityInfo", "enterPublishWithTopicInfo", "getCommonPublishConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "openPublishArticlePageWithConfig", "config", "updateClosePublishEntryView", "closePublishEntryView", "Landroid/widget/TextView;", "updateCloseTopicEntryView", "closeTopicEntryView", "updateDebugCircleIdView", "useDebugCircleIdView", "updateKolPermissionView", "kolPermissionView", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DebugView
  extends LinearLayout
{
  public DebugView(@NotNull Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(R.layout.b, (ViewGroup)this, true);
    findViewById(R.id.x).setOnClickListener((View.OnClickListener)new DebugView.1(this));
    findViewById(R.id.y).setOnClickListener((View.OnClickListener)new DebugView.2(this));
    findViewById(R.id.z).setOnClickListener((View.OnClickListener)new DebugView.3(this));
    findViewById(R.id.A).setOnClickListener((View.OnClickListener)new DebugView.4(this));
    findViewById(R.id.B).setOnClickListener((View.OnClickListener)new DebugView.5(this));
    findViewById(R.id.C).setOnClickListener((View.OnClickListener)new DebugView.6(this));
    TextView localTextView = (TextView)findViewById(R.id.at);
    localTextView.setOnClickListener((View.OnClickListener)new DebugView.7(this, localTextView));
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "kolPermissionView");
    a(localTextView);
    localTextView = (TextView)findViewById(R.id.w);
    localTextView.setOnClickListener((View.OnClickListener)new DebugView.8(this, localTextView));
    if (!StorageManager.a.a("closeCreateTopicEntry")) {
      StorageManager.a.a("closeCreateTopicEntry", false);
    }
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "closeTopicEntryView");
    b(localTextView);
    localTextView = (TextView)findViewById(R.id.v);
    localTextView.setOnClickListener((View.OnClickListener)new DebugView.9(this, localTextView));
    if (!StorageManager.a.a("closePublishEntryView")) {
      StorageManager.a.a("closePublishEntryView", false);
    }
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "closePublishEntryView");
    c(localTextView);
    localTextView = (TextView)findViewById(R.id.bS);
    localTextView.setOnClickListener((View.OnClickListener)new DebugView.10(this, localTextView));
    if (!StorageManager.a.a("useDebugCircleIdView")) {
      StorageManager.a.a("useDebugCircleIdView", true);
    }
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "useDebugCircleIdView");
    b(localTextView);
    d(localTextView);
    ((TextView)findViewById(R.id.aI)).setOnClickListener((View.OnClickListener)new DebugView.11(paramContext));
  }
  
  private final GlobalPublisherConfig a()
  {
    GlobalPublisherConfig localGlobalPublisherConfig = new GlobalPublisherConfig();
    if (StorageManager.a.a("useDebugCircleIdView", true)) {
      localGlobalPublisherConfig.setCircleId("q_1345078251_1508915917578995");
    }
    localGlobalPublisherConfig.applyValidProtect();
    return localGlobalPublisherConfig;
  }
  
  private final void a(GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    TopicSDK localTopicSDK = TopicSDK.a.a();
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "this.context");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("global_publisher_config", (Serializable)paramGlobalPublisherConfig);
    TopicSDK.a(localTopicSDK, localContext, localBundle, null, 4, null);
  }
  
  public final void a()
  {
    a(a());
  }
  
  public final void a(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "kolPermissionView");
    if (StorageManager.a.a("kolPermissionView", false))
    {
      paramTextView.setText((CharSequence)"已打开KOL入口");
      return;
    }
    paramTextView.setText((CharSequence)"已关闭KOL入口");
  }
  
  public final void b()
  {
    GlobalPublisherConfig localGlobalPublisherConfig = a();
    localGlobalPublisherConfig.setShowTopicSelector(true);
    localGlobalPublisherConfig.setShowCommunitySelector(true);
    a(localGlobalPublisherConfig);
  }
  
  public final void b(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "closeTopicEntryView");
    if (StorageManager.a.a("closeCreateTopicEntry", false))
    {
      paramTextView.setText((CharSequence)"已关闭创建栏目入口");
      return;
    }
    paramTextView.setText((CharSequence)"已打开创建栏目入口");
  }
  
  public final void c()
  {
    GlobalPublisherConfig localGlobalPublisherConfig = a();
    localGlobalPublisherConfig.setShowTopicSelector(true);
    a(localGlobalPublisherConfig);
  }
  
  public final void c(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "closePublishEntryView");
    if (StorageManager.a.a("closePublishEntryView", false))
    {
      paramTextView.setText((CharSequence)"已关闭发表入口");
      return;
    }
    paramTextView.setText((CharSequence)"已打开发表入口");
  }
  
  public final void d()
  {
    GlobalPublisherConfig localGlobalPublisherConfig = a();
    localGlobalPublisherConfig.setShowCommunitySelector(true);
    a(localGlobalPublisherConfig);
  }
  
  public final void d(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "useDebugCircleIdView");
    if (StorageManager.a.a("useDebugCircleIdView", true))
    {
      paramTextView.setText((CharSequence)"使用调试用CircleId");
      return;
    }
    paramTextView.setText((CharSequence)"禁用调试用CircleId");
  }
  
  public final void e()
  {
    GlobalPublisherConfig localGlobalPublisherConfig = a();
    TopicInfo localTopicInfo = new TopicInfo(0L, null, null, null, false, 0L, 0, 127, null);
    localTopicInfo.setTopicId(100L);
    localTopicInfo.setTitle("测试栏目");
    localGlobalPublisherConfig.setShowTopicSelector(true);
    localGlobalPublisherConfig.setTopicInfo(localTopicInfo);
    a(localGlobalPublisherConfig);
  }
  
  public final void f()
  {
    Object localObject = a();
    CommunityInfo localCommunityInfo = new CommunityInfo(null, null, null, null, null, 31, null);
    localCommunityInfo.setCommunityId("10000");
    localCommunityInfo.setTitle("测试社区");
    ((GlobalPublisherConfig)localObject).setShowCommunitySelector(true);
    ((GlobalPublisherConfig)localObject).setCommunityInfo(localCommunityInfo);
    a((GlobalPublisherConfig)localObject);
    localObject = Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.debug.DebugView
 * JD-Core Version:    0.7.0.1
 */