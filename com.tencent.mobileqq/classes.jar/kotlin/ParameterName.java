package kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.MustBeDocumented;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ParameterName;", "", "name", "", "()Ljava/lang/String;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@MustBeDocumented
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.TYPE})
@SinceKotlin(version="1.1")
public @interface ParameterName
{
  String name();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ParameterName
 * JD-Core Version:    0.7.0.1
 */