package kotlin.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/internal/RequireKotlinVersionKind;", "", "(Ljava/lang/String;I)V", "LANGUAGE_VERSION", "COMPILER_VERSION", "API_VERSION", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.2")
public enum RequireKotlinVersionKind
{
  static
  {
    RequireKotlinVersionKind localRequireKotlinVersionKind1 = new RequireKotlinVersionKind("LANGUAGE_VERSION", 0);
    LANGUAGE_VERSION = localRequireKotlinVersionKind1;
    RequireKotlinVersionKind localRequireKotlinVersionKind2 = new RequireKotlinVersionKind("COMPILER_VERSION", 1);
    COMPILER_VERSION = localRequireKotlinVersionKind2;
    RequireKotlinVersionKind localRequireKotlinVersionKind3 = new RequireKotlinVersionKind("API_VERSION", 2);
    API_VERSION = localRequireKotlinVersionKind3;
    $VALUES = new RequireKotlinVersionKind[] { localRequireKotlinVersionKind1, localRequireKotlinVersionKind2, localRequireKotlinVersionKind3 };
  }
  
  private RequireKotlinVersionKind() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.internal.RequireKotlinVersionKind
 * JD-Core Version:    0.7.0.1
 */