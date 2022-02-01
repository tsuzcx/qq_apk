package com.tencent.mobileqq.wxmini.impl.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.luggage.wxaapi.LaunchByUsernameResultListener;
import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wxmini/impl/ui/DemoWxaListActivity;", "Landroid/app/Activity;", "()V", "mBtn", "Landroid/widget/Button;", "mBtn2", "mEditText", "Landroid/widget/EditText;", "mEditText2", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "handleIntent", "", "initWxaInfos", "", "Lcom/tencent/mobileqq/wxmini/impl/ui/DemoWxaListActivity$WxaInfo;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "startApp", "appId", "", "versionType", "", "enterPath", "startAppByUserName", "userName", "Companion", "ItemAdapter", "WxaInfo", "wxmini_impl_release"}, k=1, mv={1, 1, 16})
public final class DemoWxaListActivity
  extends Activity
{
  @Deprecated
  public static final DemoWxaListActivity.Companion a = new DemoWxaListActivity.Companion(null);
  private RecyclerView b;
  private EditText c;
  private EditText d;
  private Button e;
  private Button f;
  
  private final void a(String paramString1, int paramInt, String paramString2)
  {
    WxMiniSDKImpl.a.c().launchWxaApp((Context)this, paramString1, paramInt, paramString2, (LaunchWxaAppResultListener)new DemoWxaListActivity.startApp.1(this));
  }
  
  private final void b()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      String str = localIntent.getStringExtra("appId");
      Object localObject = (CharSequence)str;
      int i;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        localObject = localIntent.getStringExtra("versionType");
        if (localObject == null) {
          localObject = "0";
        }
        i = Integer.parseInt((String)localObject);
        localObject = localIntent.getStringExtra("enterPath");
        Intrinsics.checkExpressionValueIsNotNull(str, "appId");
        a(str, i, (String)localObject);
      }
    }
  }
  
  private final void b(String paramString1, int paramInt, String paramString2)
  {
    WxMiniSDKImpl.a.c().launchByUsername((Context)this, paramString1, paramInt, paramString2, (LaunchByUsernameResultListener)new DemoWxaListActivity.startAppByUserName.1(this));
  }
  
  private final List<DemoWxaListActivity.WxaInfo> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx769668f9dcf81f5d", "广州微警务", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx8e66eba7ee5e1698", "粤康码", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxe5f52902cf4de896", "小程序示例", "https://mmbiz.qpic.cn/mmbiz_png/Cr5VxZfYgAKMoTeEpuXiaK7AsT1RWB0ia0an9WD8PTOFqWX3icK56mNk3xMTLicIeWwjcNPkE51MHKFsiaTv0pIsrcQ/640?wx_fmt=png&wxfrom=200", 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxc297db62adbdb10c", "腾讯云视频", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxb825ab501296672e", "Now直播", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx40f8626ddf43d362", "weapp_test02", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxc2bbeac4e36a812c", "jonyqin的测试1号", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx6d5a6c4a1cdd4e8a", "weiqizhu的测试号", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx3a902e983371c676", "轩辕传奇", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx1e5b107d2364b18b", "轩辕传奇(Internal Release)体验版", null, 2, 4, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx308bd2aeb83d3345", "微信城市服务\n(黑名单)", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx9e9b87595c41dbb7", "青桔骑行", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxc297db62adbdb10c", "腾讯视频云", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx91d27dbf599dff74", "京东购物", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx60d176f873ca2d67", "看点直播", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxdbb4c5f1b8ee7da1", "猫眼演出", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx71d589ea01ce3321", "车来了", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx93c3c5b012d07abf", "跑步机", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxd0e404d795ea6f80", "欢乐斗地主", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxdde587a4aebfe4f3", "儿童故事", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxd45c635d754dbf59", "腾讯文档", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx7ca43cf8fb832566", "西单大悦城", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx7c8d593b2c3a7703", "跳一跳", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx89728e4ca6fb48cc", "我不是猪头", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx504e2b5e77713844", "成语小秀才", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxb032bc789053daf4", "腾讯健康", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx32540bd863b27570", "拼多多", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxbfc40bfcb8a18fd8", "糖豆视频", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx6e918a04a2eb8ebd", "微信相框", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx40f8626ddf43d362", "weapp_test02", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxc2bbeac4e36a812c", "jonyqin的测试1号", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxa75efa648b60994b", "腾讯视频", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxb8b0988833c048eb", "动物餐厅", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxa717aca07db3bb5a", "开眼视频", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxac48d234d44e23e3", "腾讯视频亲情版", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxffc1051032845ffa", "丁香医生", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxeb39b10e39bf6b54", "知乎", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxada7aab80ba27074", "QQ音乐", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxcd10170e55a1f55d", "爱奇艺", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxb11f14b08a38ba44", "下厨房", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx0db0304107fa8d04", "腾讯天气", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx79a83b1a1e8a7978", "快手短视频", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx2c348cf579062e56", "美团外卖", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxb10c47503e8c8e01", "腾讯新闻", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxa2c453d902cdd452", "腾讯课堂", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx80f41b391c5ef8f7", "minigamesharetimelinetest", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx55965328effd38c1", "英雄杀", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxd7d16981491bbabe", "TodoReminder", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxd7911e4c177690e4", "小年糕", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxe309be0f325d17d6", "企鹅小店", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxca1fe42a16552094", "京喜", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxfa32dc0ed212dadc", "武汉天地", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx0daa2fc779233606", "complexzeng的测试demo", null, 1));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx23d8d7ea22039466", "班级小管家", null, 0, 8, null));
    return (List)localArrayList;
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(1862467585);
    b();
    paramBundle = findViewById(1862402061);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "findViewById(R.id.wxa_list_recyclerview)");
    this.b = ((RecyclerView)paramBundle);
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    }
    paramBundle = (Context)this;
    ((RecyclerView)localObject).setAdapter((RecyclerView.Adapter)new DemoWxaListActivity.ItemAdapter(paramBundle, c()));
    localObject = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "this.resources");
    if (((Resources)localObject).getConfiguration().orientation == 2)
    {
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
      }
      if (localObject != null) {
        ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(paramBundle, 4));
      }
    }
    else
    {
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
      }
      if (localObject != null) {
        ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(paramBundle, 2));
      }
    }
    paramBundle = findViewById(1862402059);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "findViewById(R.id.wxa_edittext)");
    this.c = ((EditText)paramBundle);
    paramBundle = findViewById(1862402060);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "findViewById(R.id.wxa_edittext_2)");
    this.d = ((EditText)paramBundle);
    paramBundle = findViewById(1862402057);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "findViewById(R.id.wxa_btn)");
    this.e = ((Button)paramBundle);
    paramBundle = this.e;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new DemoWxaListActivity.onCreate.1(this));
    paramBundle = findViewById(1862402058);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "findViewById(R.id.wxa_btn_2)");
    this.f = ((Button)paramBundle);
    paramBundle = this.f;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBtn2");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new DemoWxaListActivity.onCreate.2(this));
  }
  
  protected void onNewIntent(@Nullable Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.DemoWxaListActivity
 * JD-Core Version:    0.7.0.1
 */