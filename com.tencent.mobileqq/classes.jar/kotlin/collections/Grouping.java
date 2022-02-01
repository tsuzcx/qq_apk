package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/Grouping;", "T", "K", "", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract interface Grouping<T, K>
{
  public abstract K keyOf(T paramT);
  
  @NotNull
  public abstract Iterator<T> sourceIterator();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.Grouping
 * JD-Core Version:    0.7.0.1
 */