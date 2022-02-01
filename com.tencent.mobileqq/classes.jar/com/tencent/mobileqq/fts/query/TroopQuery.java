package com.tencent.mobileqq.fts.query;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.api.impl.FTSDBRuntimeServiceImpl;
import com.tencent.mobileqq.fts.data.troop.TroopIndex;
import com.tencent.mobileqq.fts.operator.FTSTroopOperator;
import com.tencent.mobileqq.fts.utils.FTSUtils;
import com.tencent.mobileqq.fts.v2.FTSQueryArgsV2.Builder;
import com.tencent.mobileqq.fts.v2.FTSQueryArgsV2.MatchKey;
import java.util.List;
import mqq.app.AppRuntime;

public class TroopQuery
  implements IQuery
{
  AppRuntime a;
  
  private <T> List<T> a(String paramString)
  {
    FTSTroopOperator localFTSTroopOperator = (FTSTroopOperator)((FTSDBRuntimeServiceImpl)this.a.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(2);
    if ((localFTSTroopOperator != null) && (paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      FTSQueryArgsV2.Builder localBuilder = new FTSQueryArgsV2.Builder().a(TroopIndex.class).a(new FTSQueryArgsV2.MatchKey[] { new FTSQueryArgsV2.MatchKey("TroopIndex", paramString, true) }).a(true);
      if (((FTSUtils.d(paramString)) || (FTSUtils.e(paramString))) && (!FTSUtils.f(paramString))) {
        localBuilder.a(200);
      }
      return localFTSTroopOperator.a(localBuilder.a());
    }
    return null;
  }
  
  private <T> List<T> b(String paramString)
  {
    FTSTroopOperator localFTSTroopOperator = (FTSTroopOperator)((FTSDBRuntimeServiceImpl)this.a.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(2);
    if ((localFTSTroopOperator != null) && (paramString != null) && (!TextUtils.isEmpty(paramString))) {
      return localFTSTroopOperator.a(new FTSQueryArgsV2.Builder().a(TroopIndex.class).a(new FTSQueryArgsV2.MatchKey[] { new FTSQueryArgsV2.MatchKey("ext1", paramString, true) }).a(true).a());
    }
    return null;
  }
  
  public <T> List<T> a(QueryArgs paramQueryArgs)
  {
    this.a = paramQueryArgs.a;
    if (paramQueryArgs.b == 1) {
      return a(paramQueryArgs.c);
    }
    if (paramQueryArgs.b == 2) {
      return b(paramQueryArgs.c);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.query.TroopQuery
 * JD-Core Version:    0.7.0.1
 */