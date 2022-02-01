package com.tencent.mobileqq.kandian.biz.ugc.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoFragment;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/api/impl/RIJDeliverUGCUtils;", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJDeliverUGCUtils;", "()V", "URL_PREFIX", "", "generateReadInJoyIntent", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "data", "getReadInJoyDeliverBiuActivityClazz", "Ljava/lang/Class;", "getReadInJoyDeliverUgcActivityClazz", "getReadInJoyDeliverVideoActivityClazz", "isUgcContent", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "isUgcVideo", "type", "", "openSelectVideoPage", "", "context", "Landroid/content/Context;", "config", "Lorg/json/JSONObject;", "from", "replaceUrlInLog", "str", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDeliverUGCUtils
  implements IRIJDeliverUGCUtils
{
  public static final RIJDeliverUGCUtils INSTANCE = new RIJDeliverUGCUtils();
  private static final String URL_PREFIX = "https://qqpublic.qpic.cn/qq_public/";
  
  @NotNull
  public Intent generateReadInJoyIntent(@NotNull Activity paramActivity, @Nullable Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intent localIntent = new Intent((Context)paramActivity, ReadInJoyDeliverVideoActivity.class);
    localIntent.putExtra("arg_video_source", 2);
    paramActivity = paramActivity.getIntent();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getExtras();
      if (paramActivity != null) {
        localIntent.putExtras(paramActivity);
      }
    }
    if (paramIntent != null)
    {
      paramActivity = paramIntent.getParcelableArrayListExtra("key_read_in_joy_video_upload_report");
      if (paramActivity != null) {
        localIntent.putParcelableArrayListExtra("key_read_in_joy_video_upload_report", paramActivity);
      }
    }
    return localIntent;
  }
  
  @NotNull
  public Class<? extends Activity> getReadInJoyDeliverBiuActivityClazz()
  {
    return ReadInJoyDeliverBiuActivity.class;
  }
  
  @NotNull
  public Class<? extends Activity> getReadInJoyDeliverUgcActivityClazz()
  {
    return ReadInJoyDeliverUGCActivity.class;
  }
  
  @NotNull
  public Class<? extends Activity> getReadInJoyDeliverVideoActivityClazz()
  {
    return ReadInJoyDeliverVideoActivity.class;
  }
  
  public boolean isUgcContent(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJItemViewTypeUtils.o(paramAbsBaseArticleInfo);
  }
  
  public boolean isUgcVideo(int paramInt)
  {
    return RIJItemViewTypeUtils.b(paramInt);
  }
  
  public void openSelectVideoPage(@Nullable Context paramContext, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramJSONObject != null) {
      localIntent.putExtra("extra", paramJSONObject.toString());
    }
    localIntent.putExtra("key_from", paramInt);
    PublicFragmentActivity.a(paramContext, localIntent, SelectVideoFragment.class);
  }
  
  @Nullable
  public String replaceUrlInLog(@Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return paramString;
    }
    if (paramString != null)
    {
      paramString = StringsKt.replace$default(paramString, "\\/", "/", false, 4, null);
      if (paramString != null)
      {
        paramString = (CharSequence)paramString;
        return new Regex(URL_PREFIX).replace(paramString, "");
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.api.impl.RIJDeliverUGCUtils
 * JD-Core Version:    0.7.0.1
 */