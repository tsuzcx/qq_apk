package kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;

@Documented
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
@java.lang.annotation.Target({})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ReplaceWith;", "", "expression", "", "imports", "", "()Ljava/lang/String;", "()[Ljava/lang/String;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@kotlin.annotation.Target(allowedTargets={})
public @interface ReplaceWith
{
  String expression();
  
  String[] imports();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.ReplaceWith
 * JD-Core Version:    0.7.0.1
 */