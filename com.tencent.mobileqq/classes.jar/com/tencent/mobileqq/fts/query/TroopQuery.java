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
    FTSTroopOperator localFTSTroopOperator = (FTSTroopOperator)((FTSDBRuntimeServiceImpl)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(2);
    if ((localFTSTroopOperator != null) && (paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      FTSQueryArgsV2.Builder localBuilder = new FTSQueryArgsV2.Builder().a(TroopIndex.class).a(new FTSQueryArgsV2.MatchKey[] { new FTSQueryArgsV2.MatchKey("TroopIndex", paramString, true) }).a(true);
      if (((FTSUtils.a(paramString)) || (FTSUtils.b(paramString))) && (!FTSUtils.c(paramString))) {
        localBuilder.a(200);
      }
      return localFTSTroopOperator.a(localBuilder.a());
    }
    return null;
  }
  
  private <T> List<T> b(String paramString)
  {
    FTSTroopOperator localFTSTroopOperator = (FTSTroopOperator)((FTSDBRuntimeServiceImpl)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(2);
    if ((localFTSTroopOperator != null) && (paramString != null) && (!TextUtils.isEmpty(paramString))) {
      return localFTSTroopOperator.a(new FTSQueryArgsV2.Builder().a(TroopIndex.class).a(new FTSQueryArgsV2.MatchKey[] { new FTSQueryArgsV2.MatchKey("ext1", paramString, true) }).a(true).a());
    }
    return null;
  }
  
  public <T> List<T> a(QueryArgs paramQueryArgs)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramQueryArgs.jdField_a_of_type_MqqAppAppRuntime;
    if (paramQueryArgs.jdField_a_of_type_Int == 1) {
      return a(paramQueryArgs.jdField_a_of_type_JavaLangString);
    }
    if (paramQueryArgs.jdField_a_of_type_Int == 2) {
      return b(paramQueryArgs.jdField_a_of_type_JavaLangString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.query.TroopQuery
 * JD-Core Version:    0.7.0.1
 */