package kotlinx.android.extensions;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/android/extensions/CacheImplementation;", "", "(Ljava/lang/String;I)V", "SPARSE_ARRAY", "HASH_MAP", "NO_CACHE", "Companion", "kotlin-android-extensions-runtime"}, k=1, mv={1, 1, 16})
public enum CacheImplementation
{
  public static final CacheImplementation.Companion Companion = new CacheImplementation.Companion(null);
  @NotNull
  private static final CacheImplementation DEFAULT = HASH_MAP;
  
  static
  {
    CacheImplementation localCacheImplementation1 = new CacheImplementation("SPARSE_ARRAY", 0);
    SPARSE_ARRAY = localCacheImplementation1;
    CacheImplementation localCacheImplementation2 = new CacheImplementation("HASH_MAP", 1);
    HASH_MAP = localCacheImplementation2;
    CacheImplementation localCacheImplementation3 = new CacheImplementation("NO_CACHE", 2);
    NO_CACHE = localCacheImplementation3;
    $VALUES = new CacheImplementation[] { localCacheImplementation1, localCacheImplementation2, localCacheImplementation3 };
  }
  
  private CacheImplementation() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlinx.android.extensions.CacheImplementation
 * JD-Core Version:    0.7.0.1
 */