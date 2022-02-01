package com.tencent.mobileqq.qassistant.core;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qassistant.config.FriendSortConfig;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class FriendSortHelper
{
  private static FriendSortConfig a;
  private static float b = 0.85F;
  
  public static float a()
  {
    return b;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      new JSONObject(paramString);
      return true;
    }
    catch (Throwable paramString)
    {
      label11:
      break label11;
    }
    return false;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)AssistantUtils.c().getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      bool1 = bool2;
      if (localRecentUserProxy != null)
      {
        paramString = localRecentUserProxy.c(paramString, paramInt);
        bool1 = bool2;
        if (paramString != null)
        {
          bool1 = bool2;
          if (paramString.showUpTime > 0L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private long b(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)AssistantUtils.c().getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      if (localRecentUserProxy != null)
      {
        paramString = localRecentUserProxy.c(paramString, paramInt);
        if (paramString != null) {
          return paramString.lastmsgtime;
        }
      }
    }
    return 0L;
  }
  
  private FriendSortConfig b()
  {
    if (a == null)
    {
      a = b(AssistantUtils.d().getSharedPreferences("qq_assistant_sp_key", 0).getString("FriendSort", ""));
      if (a == null) {
        a = new FriendSortConfig();
      }
    }
    return a;
  }
  
  public static FriendSortConfig b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (a(paramString))) {
      try
      {
        paramString = new JSONObject(paramString);
        localObject = new FriendSortConfig();
        ((FriendSortConfig)localObject).a = Float.valueOf(paramString.getString("recognitionWeight")).floatValue();
        ((FriendSortConfig)localObject).b = Float.valueOf(paramString.getString("messageTime")).floatValue();
        ((FriendSortConfig)localObject).c = Float.valueOf(paramString.getString("topFriend")).floatValue();
        ((FriendSortConfig)localObject).d = Float.valueOf(paramString.getString("careFriend")).floatValue();
        a = (FriendSortConfig)localObject;
        return localObject;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseContent exception :");
        ((StringBuilder)localObject).append(paramString.getMessage());
        AssistantUtils.a("FriendSortHelper", ((StringBuilder)localObject).toString());
        return null;
      }
      catch (JSONException paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseContent exception :");
        ((StringBuilder)localObject).append(paramString.getMessage());
        AssistantUtils.a("FriendSortHelper", ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private List<FriendItemInfo> b(List<FriendItemInfo> paramList)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private List<FriendItemInfo> c(List<FriendItemInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Collections.sort(paramList, new FriendSortComparator(2));
      Object localObject = paramList.iterator();
      int j = 0;
      int i = 0;
      while (((Iterator)localObject).hasNext()) {
        if (((FriendItemInfo)((Iterator)localObject).next()).g > 0L) {
          i += 1;
        }
      }
      int k = i + 1;
      int m = paramList.size();
      i = j;
      while (i < m)
      {
        localObject = (FriendItemInfo)paramList.get(i);
        j = k - i - 1;
        if ((((FriendItemInfo)localObject).g > 0L) && (j > 0)) {
          ((FriendItemInfo)localObject).i = (j * 1.0F / k);
        } else {
          ((FriendItemInfo)localObject).i = 0.0F;
        }
        i += 1;
      }
      return paramList;
    }
    AssistantUtils.a("FriendSortHelper", "computeRecentTimeWeight friendInfoList is null");
    return null;
  }
  
  public static void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        b = Float.parseFloat(paramString);
        return;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseFriendConfidence exception :");
        localStringBuilder.append(paramString.getMessage());
        AssistantUtils.a("FriendSortHelper", localStringBuilder.toString());
        return;
      }
    }
    AssistantUtils.a("FriendSortHelper", "parseFriendConfidence confidence is null");
  }
  
  private List<FriendItemInfo> d(List<FriendItemInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      FriendSortConfig localFriendSortConfig = b();
      if (localFriendSortConfig == null)
      {
        AssistantUtils.a("FriendSortHelper", "computeTotalScore sortConfig is null");
        return paramList;
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FriendItemInfo localFriendItemInfo = (FriendItemInfo)localIterator.next();
        localFriendItemInfo.l = (localFriendSortConfig.a * localFriendItemInfo.h + localFriendSortConfig.b * localFriendItemInfo.i + localFriendSortConfig.c * localFriendItemInfo.j + localFriendSortConfig.d * localFriendItemInfo.k);
      }
      return paramList;
    }
    AssistantUtils.a("FriendSortHelper", "computeTotalScore friendInfoList is null");
    return null;
  }
  
  public List<FriendItemInfo> a(List<FriendItemInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      b(paramList);
      Collections.sort(paramList, new FriendSortComparator(1));
      Object localObject = paramList;
      if (paramList.size() > 5) {
        localObject = paramList.subList(0, 5);
      }
      return localObject;
    }
    AssistantUtils.a("FriendSortHelper", "sortFriendList friendInfoList is null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.FriendSortHelper
 * JD-Core Version:    0.7.0.1
 */