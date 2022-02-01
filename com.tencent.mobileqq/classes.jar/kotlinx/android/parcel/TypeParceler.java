package kotlinx.android.parcel;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Repeatable;

@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/android/parcel/TypeParceler;", "T", "P", "Lkotlinx/android/parcel/Parceler;", "", "kotlin-android-extensions-runtime"}, k=1, mv={1, 1, 16})
@Repeatable
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.CLASS, kotlin.annotation.AnnotationTarget.PROPERTY})
public @interface TypeParceler<T, P extends Parceler<? super T>>
  extends Annotation
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlinx.android.parcel.TypeParceler
 * JD-Core Version:    0.7.0.1
 */