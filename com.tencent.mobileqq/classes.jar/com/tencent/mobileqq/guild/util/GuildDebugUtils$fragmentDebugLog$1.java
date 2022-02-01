package com.tencent.mobileqq.guild.util;

import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class GuildDebugUtils$fragmentDebugLog$1
  extends Lambda
  implements Function0<String>
{
  GuildDebugUtils$fragmentDebugLog$1(String paramString1, Fragment paramFragment1, View paramView, Fragment paramFragment2, String paramString2)
  {
    super(0);
  }
  
  @NotNull
  public final String invoke()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    localStringBuilder.append(this.$name);
    localStringBuilder.append("] fragment: ");
    Object localObject = this.$fragment;
    if (localObject != null) {
      localObject = ((Fragment)localObject).getTag();
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" id: ");
    localStringBuilder.append(System.identityHashCode(this.$fragment));
    localStringBuilder.append(", ");
    localStringBuilder.append("fragmentContainer: ");
    localStringBuilder.append(System.identityHashCode(this.$guildMainContainer));
    localStringBuilder.append(", ");
    localStringBuilder.append("guildFragment: ");
    localStringBuilder.append(System.identityHashCode(this.$guildFragment));
    localStringBuilder.append(" method: ");
    localStringBuilder.append(this.$method);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.GuildDebugUtils.fragmentDebugLog.1
 * JD-Core Version:    0.7.0.1
 */