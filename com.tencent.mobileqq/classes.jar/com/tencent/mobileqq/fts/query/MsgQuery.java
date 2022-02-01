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
    if (paramQueryArgs.jdField_a_of_type_JavaLangClass != null)
    {
      paramFTSQueryArgs.jdField_b_of_type_Int = paramQueryArgs.d;
      paramFTSQueryArgs.jdField_b_of_type_JavaLangString = paramQueryArgs.jdField_b_of_type_JavaLangString;
      return paramFTSQueryArgs;
    }
    paramQueryArgs = FTSArgsFactory.a(FTSMessage.class, String.valueOf(paramQueryArgs.jdField_b_of_type_Long));
    paramFTSQueryArgs.jdField_a_of_type_JavaLangString = paramQueryArgs.jdField_a_of_type_JavaLangString;
    paramFTSQueryArgs.jdField_a_of_type_ArrayOfJavaLangString = paramQueryArgs.jdField_a_of_type_ArrayOfJavaLangString;
    return paramFTSQueryArgs;
  }
  
  private String[] a(String paramString)
  {
    long l1 = System.nanoTime();
    paramString = FTSUtils.a(paramString.trim().toLowerCase());
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
    if (paramQueryArgs.jdField_a_of_type_JavaLangString != null)
    {
      if (TextUtils.isEmpty(paramQueryArgs.jdField_a_of_type_JavaLangString)) {
        return null;
      }
      FTSMsgOperator localFTSMsgOperator = (FTSMsgOperator)((FTSDBRuntimeServiceImpl)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(1);
      if (localFTSMsgOperator == null) {
        return null;
      }
      Object localObject = a(paramQueryArgs.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        return null;
      }
      ArrayList localArrayList = FTSUtils.a(paramQueryArgs.jdField_a_of_type_JavaLangString);
      localObject = FTSArgsFactory.a((String[])localObject, (String[])localArrayList.toArray(new String[localArrayList.size()]), paramQueryArgs.jdField_a_of_type_JavaLangClass, paramQueryArgs.jdField_a_of_type_Boolean);
      ((FTSQueryArgs)localObject).jdField_b_of_type_Boolean = paramQueryArgs.jdField_b_of_type_Boolean;
      ((FTSQueryArgs)localObject).c = paramQueryArgs.c;
      if (paramQueryArgs.jdField_b_of_type_Long != -1L) {
        return localFTSMsgOperator.a(a((FTSQueryArgs)localObject, paramQueryArgs), paramQueryArgs.jdField_a_of_type_AndroidUtilPair);
      }
      ((FTSQueryArgs)localObject).jdField_b_of_type_Int = paramQueryArgs.d;
      ((FTSQueryArgs)localObject).jdField_b_of_type_JavaLangString = paramQueryArgs.jdField_b_of_type_JavaLangString;
      return localFTSMsgOperator.a((FTSQueryArgs)localObject);
    }
    return null;
  }
  
  public <T> List<T> a(QueryArgs paramQueryArgs)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramQueryArgs.jdField_a_of_type_MqqAppAppRuntime;
    return b(paramQueryArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.query.MsgQuery
 * JD-Core Version:    0.7.0.1
 */