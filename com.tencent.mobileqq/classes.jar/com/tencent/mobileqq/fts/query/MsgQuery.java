package com.tencent.mobileqq.fts.query;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.api.impl.FTSDBRuntimeServiceImpl;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.operator.FTSMsgOperator;
import com.tencent.mobileqq.fts.utils.FTSUtils;
import com.tencent.mobileqq.fts.v1.FTSArgsFactory;
import com.tencent.mobileqq.fts.v1.FTSQueryArgs;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;

public class MsgQuery
  implements IQuery
{
  AppRuntime a;
  
  private FTSQueryArgs a(FTSQueryArgs paramFTSQueryArgs, QueryArgs paramQueryArgs)
  {
    if (paramQueryArgs.d != null)
    {
      paramFTSQueryArgs.f = paramQueryArgs.k;
      paramFTSQueryArgs.g = paramQueryArgs.l;
      return paramFTSQueryArgs;
    }
    paramQueryArgs = FTSArgsFactory.a(FTSMessage.class, String.valueOf(paramQueryArgs.j));
    paramFTSQueryArgs.a = paramQueryArgs.a;
    paramFTSQueryArgs.b = paramQueryArgs.b;
    return paramFTSQueryArgs;
  }
  
  private String[] a(String paramString)
  {
    long l1 = System.nanoTime();
    paramString = FTSUtils.b(paramString.trim().toLowerCase());
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("query segments = ");
      localStringBuilder.append(Arrays.toString(paramString));
      QLog.i("Q.fts.MsgQuery", 2, localStringBuilder.toString());
    }
    if ((paramString != null) && (paramString.length != 0))
    {
      long l2 = System.nanoTime();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("query: segments cost = ");
        localStringBuilder.append((l2 - l1) / 1000000L);
        localStringBuilder.append("ms");
        QLog.i("Q.fts.MsgQuery", 2, localStringBuilder.toString());
      }
      return paramString;
    }
    return null;
  }
  
  private <T> List<T> b(QueryArgs paramQueryArgs)
  {
    if (paramQueryArgs.c != null)
    {
      if (TextUtils.isEmpty(paramQueryArgs.c)) {
        return null;
      }
      FTSMsgOperator localFTSMsgOperator = (FTSMsgOperator)((FTSDBRuntimeServiceImpl)this.a.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(1);
      if (localFTSMsgOperator == null) {
        return null;
      }
      Object localObject = a(paramQueryArgs.c);
      if (localObject == null) {
        return null;
      }
      ArrayList localArrayList = FTSUtils.c(paramQueryArgs.c);
      localObject = FTSArgsFactory.a((String[])localObject, (String[])localArrayList.toArray(new String[localArrayList.size()]), paramQueryArgs.d, paramQueryArgs.e);
      ((FTSQueryArgs)localObject).d = paramQueryArgs.f;
      ((FTSQueryArgs)localObject).i = paramQueryArgs.i;
      if (paramQueryArgs.j != -1L) {
        return localFTSMsgOperator.a(a((FTSQueryArgs)localObject, paramQueryArgs), paramQueryArgs.m);
      }
      ((FTSQueryArgs)localObject).f = paramQueryArgs.k;
      ((FTSQueryArgs)localObject).g = paramQueryArgs.l;
      return localFTSMsgOperator.a((FTSQueryArgs)localObject);
    }
    return null;
  }
  
  public <T> List<T> a(QueryArgs paramQueryArgs)
  {
    this.a = paramQueryArgs.a;
    return b(paramQueryArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.query.MsgQuery
 * JD-Core Version:    0.7.0.1
 */