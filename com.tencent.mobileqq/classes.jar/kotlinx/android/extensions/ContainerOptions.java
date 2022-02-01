package kotlinx.android.extensions;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/android/extensions/ContainerOptions;", "", "cache", "Lkotlinx/android/extensions/CacheImplementation;", "()Lkotlinx/android/extensions/CacheImplementation;", "kotlin-android-extensions-runtime"}, k=1, mv={1, 1, 16})
public @interface ContainerOptions
{
  CacheImplementation cache() default CacheImplementation.HASH_MAP;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlinx.android.extensions.ContainerOptions
 * JD-Core Version:    0.7.0.1
 */