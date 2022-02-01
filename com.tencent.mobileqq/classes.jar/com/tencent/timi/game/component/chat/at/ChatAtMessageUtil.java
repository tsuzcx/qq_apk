package com.tencent.timi.game.component.chat.at;

import android.text.Spannable;
import android.text.TextUtils;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ltrpc.yes.common.CommonOuterClass.QQUserId;>;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/at/ChatAtMessageUtil;", "", "()V", "findNameFromMap", "Lkotlin/Pair;", "", "", "startPos", "txtStr", "atUserInfoMap", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "realSetAtSpan", "", "spannable", "Landroid/text/Spannable;", "color", "underLine", "", "clickable", "Lcom/tencent/timi/game/component/chat/at/AtMessageClickListener;", "subStartPos", "subEndPos", "atUserId", "resetAtContentSpan", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ChatAtMessageUtil
{
  public static final ChatAtMessageUtil a = new ChatAtMessageUtil();
  
  private final Pair<Integer, String> a(int paramInt, String paramString, Map<String, CommonOuterClass.QQUserId> paramMap)
  {
    List localList = (List)new ArrayList();
    Object localObject1 = new Pair(Integer.valueOf(-1), "");
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = (Map<String, CommonOuterClass.QQUserId>)localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      if (!TextUtils.isEmpty((CharSequence)((Map.Entry)localObject1).getKey()))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append('@');
        ((StringBuilder)localObject2).append((String)((Map.Entry)localObject1).getKey());
        localObject2 = ((StringBuilder)localObject2).toString();
        int i = StringsKt.indexOf$default((CharSequence)paramString, (String)localObject2, paramInt, false, 4, null);
        if ((i >= 0) && ((i < ((Number)paramMap.getFirst()).intValue()) || (((Number)paramMap.getFirst()).intValue() < 0)))
        {
          paramMap = new Pair(Integer.valueOf(((String)localObject2).length() + i), ((Map.Entry)localObject1).getKey());
          localList.add(Integer.valueOf(i + ((String)localObject2).length()));
        }
      }
    }
    return paramMap;
  }
  
  private final void a(Spannable paramSpannable, int paramInt1, boolean paramBoolean, AtMessageClickListener paramAtMessageClickListener, int paramInt2, int paramInt3, CommonOuterClass.QQUserId paramQQUserId)
  {
    paramSpannable.setSpan(Integer.valueOf(paramInt1), paramInt2, paramInt3, 33);
    if (paramAtMessageClickListener != null) {
      paramSpannable.setSpan(new ChatAtMessageUtil.realSetAtSpan.1(paramAtMessageClickListener, paramQQUserId, paramInt1, paramBoolean), paramInt2, paramInt3, 33);
    }
  }
  
  @NotNull
  public final List<Pair<Integer, String>> a(int paramInt1, @NotNull String paramString, @NotNull Map<String, CommonOuterClass.QQUserId> paramMap, @NotNull Spannable paramSpannable, int paramInt2, boolean paramBoolean, @Nullable AtMessageClickListener paramAtMessageClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "txtStr");
    Intrinsics.checkParameterIsNotNull(paramMap, "atUserInfoMap");
    Intrinsics.checkParameterIsNotNull(paramSpannable, "spannable");
    Logger.b("ChatAtMessageUtil", "resetAtContentSpan start");
    List localList = (List)new ArrayList();
    if ((paramMap.isEmpty() ^ true))
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((!TextUtils.isEmpty(localCharSequence)) && (StringsKt.contains$default(localCharSequence, (CharSequence)"@", false, 2, null))) {
        for (int i = 1;; i = 0)
        {
          if ((paramInt1 > paramString.length()) || (i == 0)) {
            break label241;
          }
          i = StringsKt.indexOf$default(localCharSequence, "@", paramInt1, false, 4, null);
          if (i >= paramInt1)
          {
            Object localObject = a(i, paramString, paramMap);
            int j = ((Number)((Pair)localObject).getFirst()).intValue();
            if ((j > i) && (j <= paramString.length()))
            {
              localList.add(localObject);
              localObject = paramString.substring(i + 1, j);
              Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              if (paramMap.containsKey(localObject))
              {
                a(paramSpannable, paramInt2, paramBoolean, paramAtMessageClickListener, i, j, (CommonOuterClass.QQUserId)paramMap.get(localObject));
                paramInt1 = j + 1;
              }
              else
              {
                paramInt1 += 1;
              }
              break;
            }
          }
        }
      }
    }
    label241:
    Logger.b("ChatAtMessageUtil", "resetAtContentSpan end");
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.at.ChatAtMessageUtil
 * JD-Core Version:    0.7.0.1
 */