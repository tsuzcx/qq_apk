package kotlin.script.extensions;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/extensions/SamWithReceiverAnnotations;", "", "annotations", "", "", "()[Ljava/lang/String;", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.CLASS})
public @interface SamWithReceiverAnnotations
{
  String[] annotations();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.extensions.SamWithReceiverAnnotations
 * JD-Core Version:    0.7.0.1
 */