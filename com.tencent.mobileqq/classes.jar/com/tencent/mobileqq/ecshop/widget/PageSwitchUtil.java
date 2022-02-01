package com.tencent.mobileqq.ecshop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.chat.api.IChatActivityApi;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/widget/PageSwitchUtil;", "", "()V", "switchToAioPage", "", "context", "Landroid/content/Context;", "hasHippyPage", "", "switchToHippyPage", "tabId", "", "url", "", "switchToWebPage", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class PageSwitchUtil
{
  public static final PageSwitchUtil a = new PageSwitchUtil();
  
  public final void a(@NotNull Context paramContext, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intent localIntent = new Intent();
    HashMap localHashMap = new HashMap();
    localHashMap.put("_source", "tab");
    localIntent.putExtra("jump_url", EcshopUtils.a(paramString, (Map)localHashMap, false));
    localIntent.putExtra("req_qgg_title", EcshopUtils.c());
    localIntent.putExtra("tab_id", paramInt);
    localIntent.putExtra("req_qgg_hide_tab", false);
    localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3046055438"));
    localIntent.setFlags(603979776);
    QPublicFragmentActivityForTool.a(paramContext, localIntent, EcshopNewPageFragment.class);
    if ((paramContext instanceof Activity))
    {
      if (!(paramContext instanceof QPublicFragmentActivity)) {
        ((Activity)paramContext).finish();
      }
      ((Activity)paramContext).overridePendingTransition(0, 0);
    }
  }
  
  public final void a(@NotNull Context paramContext, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Object localObject = QRoute.api(IChatActivityApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IChatActivityApi::class.java)");
    localObject = new Intent(paramContext, ((IChatActivityApi)localObject).getChatActivityClass());
    ((Intent)localObject).putExtra("uin", "3046055438");
    ((Intent)localObject).putExtra("uintype", 1008);
    ((Intent)localObject).putExtra("uinname", paramContext.getResources().getString(2131888821));
    ((Intent)localObject).putExtra("req_qgg_hide_tab", false);
    ((Intent)localObject).putExtra("leftViewText", paramContext.getString(2131887625));
    ((Intent)localObject).setFlags(4194304);
    paramContext.startActivity((Intent)localObject);
    if ((paramContext instanceof Activity))
    {
      if ((paramBoolean) && ((paramContext instanceof QPublicFragmentActivityForTool))) {
        ((Activity)paramContext).finish();
      }
      ((Activity)paramContext).overridePendingTransition(0, 0);
    }
  }
  
  public final void b(@NotNull Context paramContext, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    localMap.put("_source", "tab");
    SerializableMap localSerializableMap = new SerializableMap();
    localSerializableMap.wrapMap(localHashMap);
    localBundle.putSerializable("qqshopParams", (Serializable)localSerializableMap);
    localBundle.putString("errorUrl", EcshopUtils.a(paramString, localMap, false));
    localBundle.putString("bundleName", "qqshop");
    localBundle.putString("domain", "qianbao.qq.com");
    localIntent.putExtra("params", localBundle);
    localIntent.putExtra("tab_id", paramInt);
    localIntent.putExtra("req_qgg_title", EcshopUtils.c());
    localIntent.putExtra("req_qgg_hide_tab", false);
    localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3046055438"));
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.setFlags(603979776);
    QPublicFragmentActivity.start(paramContext, localIntent, QQShopPAHippyFragment.class);
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      paramContext.finish();
      paramContext.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.PageSwitchUtil
 * JD-Core Version:    0.7.0.1
 */