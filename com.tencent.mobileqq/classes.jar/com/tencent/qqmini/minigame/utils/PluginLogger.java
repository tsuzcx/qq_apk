package com.tencent.qqmini.minigame.utils;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/utils/PluginLogger;", "", "()V", "gApiCount", "", "gUniKeyPrev", "mBlackList", "", "", "", "mCallbackID2EventMap", "Ljava/util/HashMap;", "mCallbackID2StartTimeMap", "", "mFailAPIList", "", "", "kotlin.jvm.PlatformType", "mWhiteList", "changeCallbackId", "callbackId", "cutString", "str", "extractState", "data", "getKey", "contextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "eventName", "jsonParams", "isApiFailed", "", "result", "isEnableLog", "printEndLog", "", "printFailedApi", "printStartLog", "recordApiIfFailed", "detail", "setConfig", "whiteList", "blackList", "Companion", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
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
    if ((paramString == null) || (paramString.length() < 256)) {
      return paramString;
    }
    paramString = paramString.substring(0, 256);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString;
  }
  
  private final String extractState(String paramString)
  {
    String str2 = (String)null;
    String str1 = str2;
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      paramString = STATE_PATTERN.matcher((CharSequence)paramString);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "STATE_PATTERN.matcher(data)");
      str1 = str2;
      if (paramString.find()) {
        str1 = paramString.group();
      }
    }
    return str1;
  }
  
  private final boolean isApiFailed(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return false;
    }
    return FAIL_PATTERN.matcher((CharSequence)paramString).find();
  }
  
  private final boolean isEnableLog(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty((CharSequence)paramString1)) {}
    do
    {
      do
      {
        return false;
        if (this.mWhiteList != null)
        {
          localMap = this.mWhiteList;
          if (localMap == null) {
            Intrinsics.throwNpe();
          }
          if (localMap == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
          }
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
        if (this.mBlackList == null) {
          break;
        }
        localMap = this.mBlackList;
        if (localMap == null) {
          Intrinsics.throwNpe();
        }
        if (localMap == null) {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        }
        if (!localMap.containsKey(paramString1)) {
          break;
        }
        paramString2 = extractState(paramString2);
      } while (TextUtils.isEmpty((CharSequence)paramString2));
      Map localMap = this.mBlackList;
      if (localMap == null) {
        Intrinsics.throwNpe();
      }
      paramString1 = (Set)localMap.get(paramString1);
    } while (paramString1 == null);
    if (!paramString1.contains(paramString2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
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
      if (this.gUniKeyPrev > 1024) {
        this.gUniKeyPrev = 0;
      }
      return (paramInt << 11) + i;
    }
    GameLog.getInstance().e("<API>", "callbackId is toooo large, start vs end might not match");
    return paramInt;
  }
  
  @NotNull
  public final String getKey(@NotNull ScriptContextType paramScriptContextType, @Nullable String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptContextType, "contextType");
    paramScriptContextType = new StringBuilder().append(paramScriptContextType).append(" api(");
    int i = this.gApiCount;
    this.gApiCount = (i + 1);
    paramScriptContextType.append(i).append(") : eventName=[").append(paramString1).append("] Params=[").append(cutString(paramString2)).append("]");
    paramScriptContextType = paramScriptContextType.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramScriptContextType, "sb.toString()");
    return paramScriptContextType;
  }
  
  public final int printEndLog(int paramInt, @Nullable String paramString)
  {
    String str;
    StringBuffer localStringBuffer;
    if (this.mCallbackID2EventMap.containsKey(Integer.valueOf(paramInt)))
    {
      str = (String)this.mCallbackID2EventMap.remove(Integer.valueOf(paramInt));
      localObject = (Long)this.mCallbackID2StartTimeMap.remove(Integer.valueOf(paramInt));
      localStringBuffer = new StringBuffer("end ");
      if ((localObject == null) || (((Long)localObject).longValue() <= 0L)) {
        break label165;
      }
    }
    label165:
    for (Object localObject = "cost:" + (System.currentTimeMillis() - ((Long)localObject).longValue()) + "ms ";; localObject = "")
    {
      localObject = (String)localObject + str + " R=[" + cutString(paramString) + "]";
      Intrinsics.checkExpressionValueIsNotNull(localObject, "sb.toString()");
      GameLog.getInstance().i("<API>", (String)localObject);
      recordApiIfFailed(paramString, (String)localObject);
      return paramInt >> 11;
    }
  }
  
  public final void printEndLog(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "eventName");
    if (!isEnableLog(paramString1, paramString2)) {
      return;
    }
    paramString1 = cutString("eventName:" + paramString1 + ", Params:" + paramString2);
    if (!TextUtils.isEmpty((CharSequence)paramString1)) {
      GameLog.getInstance().i("<API>", "end subscribeJS():" + paramString1);
    }
    recordApiIfFailed(paramString2, paramString1);
  }
  
  public final void printFailedApi()
  {
    Object localObject = new ArrayList((Collection)this.mFailAPIList);
    this.mFailAPIList.clear();
    GameLog.getInstance().e("<API>", "==================== printFailLog start, total:" + ((ArrayList)localObject).size() + " ====================");
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      GameLog localGameLog = GameLog.getInstance();
      if (str == null) {
        Intrinsics.throwNpe();
      }
      localGameLog.e("<API>", str);
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
    paramString2 = new StringBuilder("start ").append(paramString1);
    if ((Intrinsics.areEqual("{}", paramString3)) || (Intrinsics.areEqual("", paramString3))) {}
    for (paramScriptContextType = " ###NEED CALLBACK###";; paramScriptContextType = " R=[" + cutString(paramString3) + "]")
    {
      paramScriptContextType = paramScriptContextType;
      Intrinsics.checkExpressionValueIsNotNull(paramScriptContextType, "sb.toString()");
      GameLog.getInstance().i("<API>", paramScriptContextType);
      ((Map)this.mCallbackID2EventMap).put(Integer.valueOf(paramInt), paramString1);
      ((Map)this.mCallbackID2StartTimeMap).put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
      recordApiIfFailed(paramString3, paramScriptContextType);
      return;
    }
  }
  
  public final void setConfig(@NotNull Map<String, ? extends Set<String>> paramMap1, @NotNull Map<String, ? extends Set<String>> paramMap2)
  {
    Intrinsics.checkParameterIsNotNull(paramMap1, "whiteList");
    Intrinsics.checkParameterIsNotNull(paramMap2, "blackList");
    this.mWhiteList = paramMap1;
    this.mBlackList = paramMap2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.PluginLogger
 * JD-Core Version:    0.7.0.1
 */