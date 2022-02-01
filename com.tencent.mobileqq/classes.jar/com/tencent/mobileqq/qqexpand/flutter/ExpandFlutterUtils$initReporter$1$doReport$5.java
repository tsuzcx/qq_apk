package com.tencent.mobileqq.qqexpand.flutter;

import com.tencent.mobileqq.statistics.QQUserAction;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.LongRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandFlutterUtils$initReporter$1$doReport$5
  implements Runnable
{
  ExpandFlutterUtils$initReporter$1$doReport$5(ExpandFlutterUtils.initReporter.1 param1, String paramString1, String paramString2, Ref.BooleanRef paramBooleanRef1, Ref.LongRef paramLongRef1, Ref.LongRef paramLongRef2, Map paramMap, Ref.BooleanRef paramBooleanRef2) {}
  
  public final void run()
  {
    ExpandFlutterUtils.initReporter.1 local1 = this.this$0;
    QQUserAction.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_KotlinJvmInternalRef$BooleanRef.element, this.jdField_a_of_type_KotlinJvmInternalRef$LongRef.element, this.jdField_b_of_type_KotlinJvmInternalRef$LongRef.element, this.jdField_a_of_type_JavaUtilMap, this.jdField_b_of_type_KotlinJvmInternalRef$BooleanRef.element, this.jdField_b_of_type_KotlinJvmInternalRef$BooleanRef.element);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterUtils.initReporter.1.doReport.5
 * JD-Core Version:    0.7.0.1
 */