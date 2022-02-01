package com.tencent.mobileqq.minigame.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/utils/PluginLogger;", "", "()V", "gApiCount", "", "gUniKeyPrev", "mBlackList", "", "", "", "mCallbackID2EventMap", "Ljava/util/HashMap;", "mCallbackID2StartTimeMap", "", "mFailAPIList", "", "", "kotlin.jvm.PlatformType", "mWhiteList", "changeCallbackId", "callbackId", "cutString", "str", "extractState", "data", "getKey", "contextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "eventName", "jsonParams", "isApiFailed", "", "result", "isEnableLog", "printEndLog", "", "printFailedApi", "printStartLog", "recordApiIfFailed", "detail", "setConfig", "whiteList", "blackList", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class PluginLogger
{
  public static final PluginLogger.Companion Companion = new PluginLogger.Companion(null);
  private static final Pattern FAIL_PATTERN = Pattern.compile("\"(errMsg|state)\":\".*(fail|error|exception).*\"");
  private static final int MAX_CALLBACKID = 1048576;
  private static final int MAX_UNIKEYID = 1024;
  private static final int RESERVER_BIT = 11;
  private static final Pattern STATE_PATTERN = Pattern.compile("(?<=state\":\")\\w+");
  private static final String TAG = "<API>";
  private int gApiCount;
  private int gUniKeyPrev;
  private Map<String, ? extends Set<String>> mBlackList;
  private final HashMap<Integer, String> mCallbackID2EventMap = new HashMap();
  private final HashMap<Integer, Long> mCallbackID2StartTimeMap = new HashMap();
  private final List<String> mFailAPIList = Collections.synchronizedList((List)new ArrayList());
  private Map<String, ? extends Set<String>> mWhiteList;
  
  private final String cutString(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.length() < 256) {
        return paramString;
      }
      str = paramString.substring(0, 256);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    return str;
  }
  
  private final String extractState(String paramString)
  {
    String str = (String)null;
    Object localObject = (CharSequence)paramString;
    paramString = str;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = STATE_PATTERN.matcher((CharSequence)localObject);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "STATE_PATTERN.matcher(data)");
      paramString = str;
      if (((Matcher)localObject).find()) {
        paramString = ((Matcher)localObject).group();
      }
    }
    return paramString;
  }
  
  private final boolean isApiFailed(String paramString)
  {
    paramString = (CharSequence)paramString;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return FAIL_PATTERN.matcher(paramString).find();
  }
  
  private final boolean isEnableLog(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty((CharSequence)paramString1)) {
      return false;
    }
    Map localMap = this.mWhiteList;
    if (localMap != null)
    {
      if (localMap == null) {
        Intrinsics.throwNpe();
      }
      if (localMap != null)
      {
        if (localMap.containsKey(paramString1))
        {
          paramString2 = extractState(paramString2);
          if (!TextUtils.isEmpty((CharSequence)paramString2))
          {
            localMap = this.mWhiteList;
            if (localMap == null) {
              Intrinsics.throwNpe();
            }
            paramString1 = (Set)localMap.get(paramString1);
            if (paramString1 != null) {
              return paramString1.contains(paramString2);
            }
          }
          return true;
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      }
    }
    localMap = this.mBlackList;
    if (localMap != null)
    {
      if (localMap == null) {
        Intrinsics.throwNpe();
      }
      if (localMap != null)
      {
        if (localMap.containsKey(paramString1))
        {
          paramString2 = extractState(paramString2);
          if (!TextUtils.isEmpty((CharSequence)paramString2))
          {
            localMap = this.mBlackList;
            if (localMap == null) {
              Intrinsics.throwNpe();
            }
            paramString1 = (Set)localMap.get(paramString1);
            if (paramString1 != null) {
              return paramString1.contains(paramString2) ^ true;
            }
          }
          return false;
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      }
    }
    return true;
  }
  
  private final void recordApiIfFailed(String paramString1, String paramString2)
  {
    if (isApiFailed(paramString1)) {
      this.mFailAPIList.add(paramString2);
    }
  }
  
  public final int changeCallbackId(int paramInt)
  {
    if (paramInt < 1048576)
    {
      int i = this.gUniKeyPrev;
      this.gUniKeyPrev = (i + 1);
      i = (paramInt << 11) + i;
      paramInt = i;
      if (this.gUniKeyPrev > 1024)
      {
        this.gUniKeyPrev = 0;
        return i;
      }
    }
    else
    {
      GameLog.getInstance().e("<API>", "callbackId is toooo large, start vs end might not match");
    }
    return paramInt;
  }
  
  @NotNull
  public final String getKey(@NotNull ScriptContextType paramScriptContextType, @Nullable String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptContextType, "contextType");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramScriptContextType);
    localStringBuilder.append(" api(");
    int i = this.gApiCount;
    this.gApiCount = (i + 1);
    localStringBuilder.append(i);
    localStringBuilder.append(") : eventName=[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("] Params=[");
    localStringBuilder.append(cutString(paramString2));
    localStringBuilder.append("]");
    paramScriptContextType = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramScriptContextType, "sb.toString()");
    return paramScriptContextType;
  }
  
  public final int printEndLog(int paramInt, @Nullable String paramString)
  {
    if (this.mCallbackID2EventMap.containsKey(Integer.valueOf(paramInt)))
    {
      String str = (String)this.mCallbackID2EventMap.remove(Integer.valueOf(paramInt));
      Object localObject = (Long)this.mCallbackID2StartTimeMap.remove(Integer.valueOf(paramInt));
      StringBuffer localStringBuffer = new StringBuffer("end ");
      if ((localObject != null) && (((Long)localObject).longValue() > 0L))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cost:");
        localStringBuilder.append(System.currentTimeMillis() - ((Long)localObject).longValue());
        localStringBuilder.append("ms ");
        localObject = localStringBuilder.toString();
      }
      else
      {
        localObject = "";
      }
      localStringBuffer.append((String)localObject);
      localStringBuffer.append(str);
      localStringBuffer.append(" R=[");
      localStringBuffer.append(cutString(paramString));
      localStringBuffer.append("]");
      localObject = localStringBuffer.toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "sb.toString()");
      GameLog.getInstance().i("<API>", (String)localObject);
      recordApiIfFailed(paramString, (String)localObject);
    }
    return paramInt >> 11;
  }
  
  public final void printEndLog(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "eventName");
    if (!isEnableLog(paramString1, paramString2)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("eventName:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", Params:");
    ((StringBuilder)localObject).append(paramString2);
    paramString1 = cutString(((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty((CharSequence)paramString1))
    {
      localObject = GameLog.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("end subscribeJS():");
      localStringBuilder.append(paramString1);
      ((GameLog)localObject).i("<API>", localStringBuilder.toString());
    }
    recordApiIfFailed(paramString2, paramString1);
  }
  
  public final void printFailedApi()
  {
    Object localObject1 = new ArrayList((Collection)this.mFailAPIList);
    this.mFailAPIList.clear();
    Object localObject2 = GameLog.getInstance();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("==================== printFailLog start, total:");
    ((StringBuilder)localObject3).append(((ArrayList)localObject1).size());
    ((StringBuilder)localObject3).append(" ====================");
    ((GameLog)localObject2).e("<API>", ((StringBuilder)localObject3).toString());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = GameLog.getInstance();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((GameLog)localObject3).e("<API>", (String)localObject2);
    }
    GameLog.getInstance().e("<API>", "==================== printFailLog end ====================");
  }
  
  public final void printStartLog(@NotNull ScriptContextType paramScriptContextType, @Nullable String paramString1, @Nullable String paramString2, int paramInt, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptContextType, "contextType");
    Intrinsics.checkParameterIsNotNull(paramString3, "result");
    if (!isEnableLog(paramString1, null)) {
      return;
    }
    paramString1 = getKey(paramScriptContextType, paramString1, paramString2);
    paramString2 = new StringBuilder("start ");
    paramString2.append(paramString1);
    if ((!Intrinsics.areEqual("{}", paramString3)) && (!Intrinsics.areEqual("", paramString3)))
    {
      paramScriptContextType = new StringBuilder();
      paramScriptContextType.append(" R=[");
      paramScriptContextType.append(cutString(paramString3));
      paramScriptContextType.append("]");
      paramScriptContextType = paramScriptContextType.toString();
    }
    else
    {
      paramScriptContextType = " ###NEED CALLBACK###";
    }
    paramString2.append(paramScriptContextType);
    paramScriptContextType = paramString2.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramScriptContextType, "sb.toString()");
    GameLog.getInstance().i("<API>", paramScriptContextType);
    ((Map)this.mCallbackID2EventMap).put(Integer.valueOf(paramInt), paramString1);
    ((Map)this.mCallbackID2StartTimeMap).put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
    recordApiIfFailed(paramString3, paramScriptContextType);
  }
  
  public final void setConfig(@NotNull Map<String, ? extends Set<String>> paramMap1, @NotNull Map<String, ? extends Set<String>> paramMap2)
  {
    Intrinsics.checkParameterIsNotNull(paramMap1, "whiteList");
    Intrinsics.checkParameterIsNotNull(paramMap2, "blackList");
    this.mWhiteList = paramMap1;
    this.mBlackList = paramMap2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.PluginLogger
 * JD-Core Version:    0.7.0.1
 */