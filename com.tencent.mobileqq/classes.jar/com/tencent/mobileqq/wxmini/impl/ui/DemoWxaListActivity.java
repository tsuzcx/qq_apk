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
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx769668f9dcf81f5d", "???????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx8e66eba7ee5e1698", "?????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxe5f52902cf4de896", "???????????????", "https://mmbiz.qpic.cn/mmbiz_png/Cr5VxZfYgAKMoTeEpuXiaK7AsT1RWB0ia0an9WD8PTOFqWX3icK56mNk3xMTLicIeWwjcNPkE51MHKFsiaTv0pIsrcQ/640?wx_fmt=png&wxfrom=200", 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxc297db62adbdb10c", "???????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxb825ab501296672e", "Now??????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx40f8626ddf43d362", "weapp_test02", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxc2bbeac4e36a812c", "jonyqin?????????1???", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx6d5a6c4a1cdd4e8a", "weiqizhu????????????", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx3a902e983371c676", "????????????", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx1e5b107d2364b18b", "????????????(Internal Release)?????????", null, 2, 4, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx308bd2aeb83d3345", "??????????????????\n(?????????)", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx9e9b87595c41dbb7", "????????????", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxc297db62adbdb10c", "???????????????", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx91d27dbf599dff74", "????????????", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx60d176f873ca2d67", "????????????", null, 0, 12, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxdbb4c5f1b8ee7da1", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx71d589ea01ce3321", "?????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx93c3c5b012d07abf", "?????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxd0e404d795ea6f80", "???????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxdde587a4aebfe4f3", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxd45c635d754dbf59", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx7ca43cf8fb832566", "???????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx7c8d593b2c3a7703", "?????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx89728e4ca6fb48cc", "???????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx504e2b5e77713844", "???????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxb032bc789053daf4", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx32540bd863b27570", "?????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxbfc40bfcb8a18fd8", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx6e918a04a2eb8ebd", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx40f8626ddf43d362", "weapp_test02", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxc2bbeac4e36a812c", "jonyqin?????????1???", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxa75efa648b60994b", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxb8b0988833c048eb", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxa717aca07db3bb5a", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxac48d234d44e23e3", "?????????????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxffc1051032845ffa", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxeb39b10e39bf6b54", "??????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxada7aab80ba27074", "QQ??????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxcd10170e55a1f55d", "?????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxb11f14b08a38ba44", "?????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx0db0304107fa8d04", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx79a83b1a1e8a7978", "???????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx2c348cf579062e56", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxb10c47503e8c8e01", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxa2c453d902cdd452", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx80f41b391c5ef8f7", "minigamesharetimelinetest", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx55965328effd38c1", "?????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxd7d16981491bbabe", "TodoReminder", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxd7911e4c177690e4", "?????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxe309be0f325d17d6", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxca1fe42a16552094", "??????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wxfa32dc0ed212dadc", "????????????", null, 0, 8, null));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx0daa2fc779233606", "complexzeng?????????demo", null, 1));
    localArrayList.add(new DemoWxaListActivity.WxaInfo("wx23d8d7ea22039466", "???????????????", null, 0, 8, null));
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