package com.tencent.mobileqq.kandian.biz.comment;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.feeds.entity.SerializableMap;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegateConstants;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/TKDCommentFragment$Companion;", "", "()V", "FLAG_COMMENT_FIRST", "", "getFLAG_COMMENT_FIRST", "()I", "FLAG_COMMENT_OTHER", "getFLAG_COMMENT_OTHER", "FLAG_COMMENT_SECOND", "getFLAG_COMMENT_SECOND", "MODULE_NAME", "", "getMODULE_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "create", "Lcom/tencent/mobileqq/kandian/biz/comment/TKDCommentFragment;", "originalUrl", "configMap", "Lcom/tencent/mobileqq/kandian/biz/feeds/entity/SerializableMap;", "hideTitle", "", "newInstance", "bundle", "Landroid/os/Bundle;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentFragment$Companion
{
  @JvmStatic
  private final TKDCommentFragment a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new TKDCommentFragment();
    paramBundle.setArguments(localBundle);
    return paramBundle;
  }
  
  public final int a()
  {
    return TKDCommentFragment.c();
  }
  
  @JvmStatic
  @NotNull
  public final TKDCommentFragment a(@Nullable String paramString, @Nullable SerializableMap paramSerializableMap, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localBundle.putSerializable(ViolaFragment.BUNDLE_PAGE_CONFIG_DATA, (Serializable)paramSerializableMap);
    if (paramBoolean) {
      localBundle.putInt(IViolaUiDelegateConstants.b, 1);
    }
    localBundle.putLong("openPageStart", System.currentTimeMillis());
    return ((Companion)this).a(localBundle);
  }
  
  @NotNull
  public final String a()
  {
    return TKDCommentFragment.a();
  }
  
  public final int b()
  {
    return TKDCommentFragment.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.TKDCommentFragment.Companion
 * JD-Core Version:    0.7.0.1
 */