package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mobileqq.kandian.glue.webplugin.TribeWebViewPlugin;
import com.tencent.mobileqq.kandian.glue.webplugin.TribeWebViewPlugin.BaseTribePluginProcessor;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/ShowShareMenuProcessor;", "Lcom/tencent/mobileqq/kandian/glue/webplugin/TribeWebViewPlugin$BaseTribePluginProcessor;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Landroid/content/DialogInterface$OnCancelListener;", "Landroid/content/DialogInterface$OnDismissListener;", "plugin", "Lcom/tencent/mobileqq/kandian/glue/webplugin/TribeWebViewPlugin;", "(Lcom/tencent/mobileqq/kandian/glue/webplugin/TribeWebViewPlugin;)V", "actionToIdMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "callbackId", "hasInit", "", "idToActionMap", "shareActionSheet", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareToComputerHelper", "Lcom/tencent/mobileqq/kandian/biz/share/ShareToComputerHelper;", "init", "", "initMaps", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onItemClick", "item", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "process", "json", "Lorg/json/JSONObject;", "putToMap", "id", "action", "showActionSheet", "showRecentFriend", "paths", "", "operations", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ShowShareMenuProcessor
  extends TribeWebViewPlugin.BaseTribePluginProcessor
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, ShareActionSheet.OnItemClickListener
{
  private boolean a;
  private String b = "";
  private ShareActionSheet c;
  private ShareToComputerHelper d;
  private final HashMap<String, Integer> e = new HashMap();
  private final HashMap<Integer, String> f = new HashMap();
  
  public ShowShareMenuProcessor(@NotNull TribeWebViewPlugin paramTribeWebViewPlugin)
  {
    super(paramTribeWebViewPlugin);
  }
  
  private final ShareActionSheet a(boolean paramBoolean, List<? extends ShareActionSheetBuilder.ActionSheetItem> paramList1, List<? extends ShareActionSheetBuilder.ActionSheetItem> paramList2)
  {
    Object localObject = a().mRuntime;
    if (localObject != null) {
      localObject = ((WebViewPlugin.PluginRuntime)localObject).d();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      if (localObject != null) {
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_feeds_buluo");
      }
    }
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
    }
    ((ShareActionSheet)localObject).setActionSheetItems(paramList1, paramList2);
    paramList1 = this.c;
    if (paramList1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
    }
    paramList1.setItemClickListenerV2((ShareActionSheet.OnItemClickListener)this);
    paramList1 = this.c;
    if (paramList1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
    }
    paramList1.setCancelListener((DialogInterface.OnCancelListener)this);
    paramList1 = this.c;
    if (paramList1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
    }
    paramList1.setOnDismissListener((DialogInterface.OnDismissListener)this);
    paramList1 = this.c;
    if (paramList1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
    }
    paramList1.setIntentForStartForwardRecentActivity(new Intent());
    paramList1 = this.c;
    if (paramList1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    paramList1.setRowVisibility(i, 0, 0);
    paramList1 = this.c;
    if (paramList1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
    }
    paramList1.show();
    paramList1 = this.c;
    if (paramList1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
    }
    return paramList1;
  }
  
  private final void a(String paramString, int paramInt)
  {
    ((Map)this.e).put(paramString, Integer.valueOf(paramInt));
    ((Map)this.f).put(Integer.valueOf(paramInt), paramString);
  }
  
  private final void b()
  {
    Object localObject1 = new ShareActionSheetV2.Param();
    WebViewPlugin.PluginRuntime localPluginRuntime = a().mRuntime;
    if (localPluginRuntime != null)
    {
      Object localObject2 = a().mRuntime;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "plugin.mRuntime");
      localObject2 = ((WebViewPlugin.PluginRuntime)localObject2).d();
      ((ShareActionSheetV2.Param)localObject1).context = ((Context)localObject2);
      localObject1 = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "ShareActionSheetFactory.create(param)");
      this.c = ((ShareActionSheet)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity");
      ((Activity)localObject2).getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
      this.d = new ShareToComputerHelper(localPluginRuntime.b());
    }
    c();
  }
  
  private final void c()
  {
    a("Qfriend", 2);
    a("Qzone", 3);
    a("wechat", 9);
    a("wechat_", 10);
    a("weibo", 12);
    a("sys_browser", 4);
    a("sent_pc", 26);
    a("add_to_digest", 145);
    a("cancel_digest", 146);
    a("interest", 147);
    a("look_owner", 148);
    a("push_topics", 149);
    a("pull_black", 150);
    a("feedback", 151);
    a("colornote", 70);
    a("colornote_cancel", 82);
    a("save", 43);
    a("adjust_font", 7);
    a("copy_link", 1);
    a("report", 11);
    a("aio_position", 54);
    a("collect", 6);
    a("collect_cancel", 84);
    a("stick", 96);
    a("unstick", 97);
    a("follow", 87);
    a("unfollow", 32);
  }
  
  public void a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    if (!this.a)
    {
      this.a = true;
      b();
    }
    Object localObject = paramJSONObject.optJSONArray("secondLineIcons");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("thirdLineIcons");
    boolean bool = paramJSONObject.optBoolean("needRecentFriend");
    ArrayList localArrayList = new ArrayList();
    int k = ((JSONArray)localObject).length();
    int j = 0;
    int i = 0;
    Integer localInteger;
    while (i < k)
    {
      localInteger = (Integer)((Map)this.e).get(((JSONArray)localObject).get(i));
      if (localInteger != null) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(localInteger.intValue()));
      }
      i += 1;
    }
    localObject = new ArrayList();
    k = localJSONArray.length();
    i = j;
    while (i < k)
    {
      localInteger = (Integer)((Map)this.e).get(localJSONArray.get(i));
      if (localInteger != null) {
        ((ArrayList)localObject).add(ShareActionSheetBuilder.ActionSheetItem.build(localInteger.intValue()));
      }
      i += 1;
    }
    paramJSONObject = paramJSONObject.optString("callback");
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "json.optString(\"callback\")");
    this.b = paramJSONObject;
    a(bool, (List)localArrayList, (List)localObject);
  }
  
  public void onCancel(@Nullable DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    Integer localInteger = Integer.valueOf(0);
    paramDialogInterface.putOpt("id", localInteger);
    paramDialogInterface.putOpt("shared", Boolean.valueOf(false));
    paramDialogInterface.putOpt("toUin", Long.valueOf(0L));
    paramDialogInterface.putOpt("uinType", localInteger);
    a().callJs(this.b, new String[] { paramDialogInterface.toString() });
  }
  
  public void onDismiss(@Nullable DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    Integer localInteger = Integer.valueOf(0);
    paramDialogInterface.putOpt("id", localInteger);
    paramDialogInterface.putOpt("shared", Boolean.valueOf(false));
    paramDialogInterface.putOpt("toUin", Long.valueOf(0L));
    paramDialogInterface.putOpt("uinType", localInteger);
    a().callJs(this.b, new String[] { paramDialogInterface.toString() });
  }
  
  public void onItemClick(@Nullable ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, @Nullable ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem != null)
    {
      JSONObject localJSONObject = new JSONObject();
      paramShareActionSheet = (String)this.f.get(Integer.valueOf(paramActionSheetItem.action));
      if (paramShareActionSheet == null) {
        paramShareActionSheet = Integer.valueOf(0);
      }
      localJSONObject.putOpt("id", paramShareActionSheet);
      localJSONObject.putOpt("shared", Boolean.valueOf(true));
      paramShareActionSheet = paramActionSheetItem.uin;
      if (paramShareActionSheet != null)
      {
        paramShareActionSheet = StringsKt.toLongOrNull(paramShareActionSheet);
        if (paramShareActionSheet != null) {}
      }
      else
      {
        paramShareActionSheet = Long.valueOf(0L);
      }
      localJSONObject.putOpt("toUin", paramShareActionSheet);
      localJSONObject.putOpt("uinType", Integer.valueOf(paramActionSheetItem.uinType));
      a().callJs(this.b, new String[] { localJSONObject.toString() });
      paramActionSheetItem = this.c;
      if (paramActionSheetItem == null) {
        Intrinsics.throwUninitializedPropertyAccessException("shareActionSheet");
      }
      paramActionSheetItem.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ShowShareMenuProcessor
 * JD-Core Version:    0.7.0.1
 */