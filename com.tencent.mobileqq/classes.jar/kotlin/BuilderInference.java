package kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.experimental.ExperimentalTypeInference;

@java.lang.annotation.Retention(RetentionPolicy.CLASS)
@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/BuilderInference;", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.VALUE_PARAMETER, kotlin.annotation.AnnotationTarget.FUNCTION, kotlin.annotation.AnnotationTarget.PROPERTY})
@SinceKotlin(version="1.3")
@ExperimentalTypeInference
public @interface BuilderInference {}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.BuilderInference
 * JD-Core Version:    0.7.0.1
 */