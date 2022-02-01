package kotlin.jvm;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;

@Documented
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
@java.lang.annotation.Target({})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/JvmPackageName;", "", "name", "", "()Ljava/lang/String;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.FILE})
@SinceKotlin(version="1.2")
public @interface JvmPackageName
{
  String name();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.jvm.JvmPackageName
 * JD-Core Version:    0.7.0.1
 */