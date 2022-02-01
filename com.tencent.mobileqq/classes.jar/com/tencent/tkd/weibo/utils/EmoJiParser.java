package com.tencent.tkd.weibo.utils;

import com.tencent.tkd.weibo.RichTextBridge;
import com.tencent.tkd.weibo.RichTextBridge.Companion;
import com.tencent.tkd.weibo.framework.IEmoJiBridge;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/utils/EmoJiParser;", "", "text", "", "(Ljava/lang/String;)V", "emoJiPositionList", "", "", "getEmoJiPositionList", "()Ljava/util/List;", "setEmoJiPositionList", "(Ljava/util/List;)V", "emoJiTabList", "getEmoJiTabList", "setEmoJiTabList", "hasEmoJi", "", "getHasEmoJi", "()Z", "setHasEmoJi", "(Z)V", "isEmoJiListEmpty", "getText", "()Ljava/lang/String;", "setText", "checkIfEmoJiInText", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class EmoJiParser
{
  private boolean a;
  @NotNull
  private List<String> b;
  @NotNull
  private List<Integer> c;
  @NotNull
  private String d;
  
  public EmoJiParser(@NotNull String paramString)
  {
    this.d = paramString;
    this.b = ((List)new ArrayList());
    this.c = ((List)new ArrayList());
    this.a = e();
  }
  
  private final boolean e()
  {
    Object localObject = RichTextBridge.a.a().a();
    if (localObject != null)
    {
      localObject = ((IEmoJiBridge)localObject).a();
      int i;
      if (((CharSequence)this.d).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        if (localObject == null) {
          return false;
        }
        localObject = ((Pattern)localObject).matcher((CharSequence)this.d);
        while (((Matcher)localObject).find())
        {
          List localList = this.b;
          String str = ((Matcher)localObject).group();
          Intrinsics.checkExpressionValueIsNotNull(str, "matcher.group()");
          localList.add(str);
          this.c.add(Integer.valueOf(((Matcher)localObject).start()));
        }
        return d();
      }
    }
    return false;
  }
  
  public final boolean a()
  {
    return this.a;
  }
  
  @NotNull
  public final List<String> b()
  {
    return this.b;
  }
  
  @NotNull
  public final List<Integer> c()
  {
    return this.c;
  }
  
  public final boolean d()
  {
    return ((((Collection)this.b).isEmpty() ^ true)) && ((((Collection)this.c).isEmpty() ^ true)) && (this.c.size() == this.b.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.utils.EmoJiParser
 * JD-Core Version:    0.7.0.1
 */