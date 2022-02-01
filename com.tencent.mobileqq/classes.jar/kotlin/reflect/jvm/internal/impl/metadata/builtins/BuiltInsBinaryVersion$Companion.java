package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

public final class BuiltInsBinaryVersion$Companion
{
  @NotNull
  public final BuiltInsBinaryVersion readFrom(@NotNull InputStream paramInputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "stream");
    paramInputStream = new DataInputStream(paramInputStream);
    Object localObject = (Iterable)new IntRange(1, paramInputStream.readInt());
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ((IntIterator)localObject).nextInt();
      localCollection.add(Integer.valueOf(paramInputStream.readInt()));
    }
    paramInputStream = CollectionsKt.toIntArray((Collection)localCollection);
    return new BuiltInsBinaryVersion(Arrays.copyOf(paramInputStream, paramInputStream.length));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion.Companion
 * JD-Core Version:    0.7.0.1
 */