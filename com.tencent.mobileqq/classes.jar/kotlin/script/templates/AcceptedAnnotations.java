package kotlin.script.templates;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/templates/AcceptedAnnotations;", "", "supportedAnnotationClasses", "", "Lkotlin/reflect/KClass;", "()[Ljava/lang/Class;", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.FUNCTION, kotlin.annotation.AnnotationTarget.CLASS})
public @interface AcceptedAnnotations
{
  Class<? extends Annotation>[] supportedAnnotationClasses();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.templates.AcceptedAnnotations
 * JD-Core Version:    0.7.0.1
 */