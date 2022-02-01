package kotlin.script.experimental.location;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@Deprecated(message="Experimental API")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/experimental/location/ScriptExpectedLocations;", "", "value", "", "Lkotlin/script/experimental/location/ScriptExpectedLocation;", "()[Lkotlin/script/experimental/location/ScriptExpectedLocation;", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.CLASS})
public @interface ScriptExpectedLocations
{
  ScriptExpectedLocation[] value() default {ScriptExpectedLocation.SourcesOnly, ScriptExpectedLocation.TestsOnly};
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.location.ScriptExpectedLocations
 * JD-Core Version:    0.7.0.1
 */