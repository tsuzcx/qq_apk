package com.tencent.mobileqq.kandian.base.utils;

import com.tencent.mobileqq.utils.StringUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/ValueJudgeUtil;", "", "()V", "isValidate", "", "obj", "judgeAndGet", "T", "first", "second", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "judgeAndGetInt", "", "judgeAndGetLong", "", "judgeAndGetString", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ValueJudgeUtil
{
  public static final ValueJudgeUtil a = new ValueJudgeUtil();
  
  private final <T> T a(T paramT1, T paramT2)
  {
    if (a(paramT1)) {
      return paramT1;
    }
    if (a(paramT2)) {
      return paramT2;
    }
    return paramT1;
  }
  
  private final boolean a(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      if (((Number)paramObject).intValue() > 0) {
        return true;
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (!(paramObject instanceof Long)) {
            break;
          }
        } while (((Number)paramObject).longValue() <= 0L);
        return true;
        if (!(paramObject instanceof String)) {
          break;
        }
      } while (StringUtil.isEmpty((String)paramObject));
      return true;
    } while (paramObject == null);
    return true;
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    return ((Number)a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2))).intValue();
  }
  
  public final long a(long paramLong1, long paramLong2)
  {
    return ((Number)a(Long.valueOf(paramLong1), Long.valueOf(paramLong2))).longValue();
  }
  
  @Nullable
  public final String a(@Nullable String paramString1, @Nullable String paramString2)
  {
    return (String)a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.ValueJudgeUtil
 * JD-Core Version:    0.7.0.1
 */