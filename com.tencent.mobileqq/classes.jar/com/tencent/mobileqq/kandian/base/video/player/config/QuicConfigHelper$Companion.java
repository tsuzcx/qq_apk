package com.tencent.mobileqq.kandian.base.video.player.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/config/QuicConfigHelper$Companion;", "", "()V", "PROTOCOL_QUIC", "", "connectionMigrationEnable", "", "getQuicEnableMode", "", "context", "Landroid/content/Context;", "url", "getQuicHostList", "", "isUrlCanUseQuic", "plainTextEnable", "quicCongestionType", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class QuicConfigHelper$Companion
{
  public final int a()
  {
    return QuicConfig.a.c();
  }
  
  public final int a(@Nullable Context paramContext, @Nullable String paramString)
  {
    int i = 0;
    if (paramContext == null) {
      return 0;
    }
    if (((Companion)this).a(paramString)) {
      if (NetworkUtil.isWifiConnected(paramContext)) {
        i = QuicConfig.a.a();
      } else {
        i = QuicConfig.a.b();
      }
    }
    return i;
  }
  
  @NotNull
  public final List<String> a()
  {
    return StringsKt.split$default((CharSequence)QuicConfig.a.a(), new String[] { "," }, false, 0, 6, null);
  }
  
  public final boolean a()
  {
    return QuicConfig.a.a();
  }
  
  public final boolean a(@Nullable String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    if (TextUtils.isEmpty(localCharSequence)) {
      return false;
    }
    Iterator localIterator = ((Companion)this).a().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramString != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("http[s]?://");
        localStringBuilder.append(str);
        localStringBuilder.append(".*");
        if (new Regex(localStringBuilder.toString()).matches(localCharSequence) == true) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final boolean b()
  {
    return QuicConfig.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.config.QuicConfigHelper.Companion
 * JD-Core Version:    0.7.0.1
 */