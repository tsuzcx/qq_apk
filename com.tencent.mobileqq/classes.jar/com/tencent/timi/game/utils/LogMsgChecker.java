package com.tencent.timi.game.utils;

import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/utils/LogMsgChecker;", "", "()V", "TAG", "", "invalidStackList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sensitiveMsgList", "check", "", "msg", "getStackString", "isValid", "Lcom/tencent/timi/game/utils/LogMsgChecker$ValidCheckResult;", "ValidCheckResult", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LogMsgChecker
{
  public static final LogMsgChecker a = new LogMsgChecker();
  private static final ArrayList<String> b = new ArrayList();
  private static final ArrayList<String> c = new ArrayList();
  
  static
  {
    Object localObject = MobileQQ.sMobileQQ;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MobileQQ.sMobileQQ");
    localObject = ((MobileQQ)localObject).getFirstSimpleAccount();
    if (localObject != null) {
      b.add(((SimpleAccount)localObject).getUin());
    }
  }
  
  private final LogMsgChecker.ValidCheckResult b(String paramString)
  {
    if (paramString == null) {
      return new LogMsgChecker.ValidCheckResult(true, null, 2, null);
    }
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      CharSequence localCharSequence = (CharSequence)paramString;
      Intrinsics.checkExpressionValueIsNotNull(str, "sensitiveMsg");
      if (StringsKt.contains$default(localCharSequence, (CharSequence)str, false, 2, null))
      {
        paramString = new StringBuilder();
        paramString.append("msg contains sensitive string ");
        paramString.append(str);
        return new LogMsgChecker.ValidCheckResult(false, paramString.toString());
      }
    }
    return new LogMsgChecker.ValidCheckResult(true, null, 2, null);
  }
  
  public final void a(@Nullable String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.LogMsgChecker
 * JD-Core Version:    0.7.0.1
 */