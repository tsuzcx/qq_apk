package kotlinx.coroutines;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import kotlin.RequiresOptIn.Level;
import kotlin.annotation.AnnotationRetention;

@java.lang.annotation.Retention(RetentionPolicy.CLASS)
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/InternalCoroutinesApi;", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.CLASS, kotlin.annotation.AnnotationTarget.FUNCTION, kotlin.annotation.AnnotationTarget.TYPEALIAS, kotlin.annotation.AnnotationTarget.PROPERTY})
@RequiresOptIn(level=RequiresOptIn.Level.ERROR, message="This is an internal kotlinx.coroutines API that should not be used from outside of kotlinx.coroutines. No compatibility guarantees are provided.It is recommended to report your use-case of internal API to kotlinx.coroutines issue tracker, so stable API could be provided instead")
public @interface InternalCoroutinesApi {}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.InternalCoroutinesApi
 * JD-Core Version:    0.7.0.1
 */