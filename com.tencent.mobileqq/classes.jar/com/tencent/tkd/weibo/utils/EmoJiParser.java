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
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private List<String> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  @NotNull
  private List<Integer> b;
  
  public EmoJiParser(@NotNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.b = ((List)new ArrayList());
    this.jdField_a_of_type_Boolean = c();
  }
  
  private final boolean c()
  {
    Object localObject = RichTextBridge.a.a().a();
    if (localObject != null)
    {
      localObject = ((IEmoJiBridge)localObject).a();
      if (((CharSequence)this.jdField_a_of_type_JavaLangString).length() == 0) {}
      for (int i = 1; (i != 0) || (localObject == null); i = 0) {
        return false;
      }
      localObject = ((Pattern)localObject).matcher((CharSequence)this.jdField_a_of_type_JavaLangString);
      while (((Matcher)localObject).find())
      {
        List localList = this.jdField_a_of_type_JavaUtilList;
        String str = ((Matcher)localObject).group();
        Intrinsics.checkExpressionValueIsNotNull(str, "matcher.group()");
        localList.add(str);
        this.b.add(Integer.valueOf(((Matcher)localObject).start()));
      }
      return b();
    }
    return false;
  }
  
  @NotNull
  public final List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @NotNull
  public final List<Integer> b()
  {
    return this.b;
  }
  
  public final boolean b()
  {
    if (!((Collection)this.jdField_a_of_type_JavaUtilList).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label75;
      }
      if (((Collection)this.b).isEmpty()) {
        break label70;
      }
    }
    label70:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (this.b.size() != this.jdField_a_of_type_JavaUtilList.size())) {
        break label75;
      }
      return true;
      i = 0;
      break;
    }
    label75:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.utils.EmoJiParser
 * JD-Core Version:    0.7.0.1
 */