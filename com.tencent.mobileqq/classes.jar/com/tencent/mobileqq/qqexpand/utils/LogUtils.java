package com.tencent.mobileqq.qqexpand.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/LogUtils;", "", "()V", "logger", "Lcom/tencent/mobileqq/qqexpand/utils/ILog;", "getLogger", "()Lcom/tencent/mobileqq/qqexpand/utils/ILog;", "setLogger", "(Lcom/tencent/mobileqq/qqexpand/utils/ILog;)V", "color", "", "tag", "", "block", "Lkotlin/Function0;", "d", "dev", "e", "throwable", "", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public final class LogUtils
{
  @NotNull
  private static ILog a;
  public static final LogUtils a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqQqexpandUtilsLogUtils = new LogUtils();
    jdField_a_of_type_ComTencentMobileqqQqexpandUtilsILog = (ILog)new LogUtils.logger.1();
  }
  
  @NotNull
  public final ILog a()
  {
    return jdField_a_of_type_ComTencentMobileqqQqexpandUtilsILog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.LogUtils
 * JD-Core Version:    0.7.0.1
 */