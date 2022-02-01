package com.tencent.mobileqq.kandian.glue.router;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/router/RIJDailyJumpParser$RIJDailyScheme;", "", "scheme", "", "(Ljava/lang/String;)V", "algorithmId", "getAlgorithmId", "()Ljava/lang/String;", "setAlgorithmId", "articleUrl", "getArticleUrl", "setArticleUrl", "channelId", "", "getChannelId", "()I", "setChannelId", "(I)V", "insertCard", "getInsertCard", "setInsertCard", "rowKey", "getRowKey", "setRowKey", "showFloatingWindow", "", "getShowFloatingWindow", "()Z", "setShowFloatingWindow", "(Z)V", "target", "getTarget", "setTarget", "violaJson", "getViolaJson", "setViolaJson", "init", "", "parseChannelId", "channelIdStr", "toString", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDailyJumpParser$RIJDailyScheme
{
  @Nullable
  private String a = "";
  private int b = -1;
  @Nullable
  private String c = "";
  @Nullable
  private String d = "";
  @Nullable
  private String e = "";
  private boolean f;
  @Nullable
  private String g = "";
  @Nullable
  private String h = "0";
  
  public RIJDailyJumpParser$RIJDailyScheme(@Nullable String paramString)
  {
    a(paramString);
  }
  
  private final void a(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return;
    }
    Uri localUri = Uri.parse(paramString);
    this.a = localUri.getQueryParameter("target");
    paramString = localUri.getQueryParameter("channelid");
    if (paramString == null) {
      paramString = "";
    }
    this.b = b(paramString);
    this.c = localUri.getQueryParameter("rowkey");
    this.d = localUri.getQueryParameter("algorithmid");
    this.e = localUri.getQueryParameter("article_url");
    this.f = TextUtils.equals((CharSequence)"1", (CharSequence)localUri.getQueryParameter("show_floating_window"));
    paramString = localUri.getQueryParameter("viola_json");
    if (paramString == null) {
      paramString = "";
    }
    this.g = paramString;
    paramString = localUri.getQueryParameter("insert_card");
    if (paramString == null) {
      paramString = "0";
    }
    this.h = paramString;
  }
  
  private final int b(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[parseChannelId] channelIdStr = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", e = ");
      localStringBuilder.append(localNumberFormatException);
      localStringBuilder.append(',');
      QLog.i("RIJDailyJumpParser", 1, localStringBuilder.toString());
    }
    return -1;
  }
  
  @Nullable
  public final String a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  @Nullable
  public final String c()
  {
    return this.c;
  }
  
  @Nullable
  public final String d()
  {
    return this.e;
  }
  
  public final boolean e()
  {
    return this.f;
  }
  
  @Nullable
  public final String f()
  {
    return this.g;
  }
  
  @Nullable
  public final String g()
  {
    return this.h;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" target = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", channelId = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", rowKey = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", algorithmId = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", articleUrl = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", showFloatingWindow = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", violaJson = ");
    localStringBuilder.append(this.g);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.RIJDailyJumpParser.RIJDailyScheme
 * JD-Core Version:    0.7.0.1
 */