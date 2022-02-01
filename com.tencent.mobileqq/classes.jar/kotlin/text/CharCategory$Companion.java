package kotlin.text;

import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/CharCategory$Companion;", "", "()V", "categoryMap", "", "", "Lkotlin/text/CharCategory;", "getCategoryMap", "()Ljava/util/Map;", "categoryMap$delegate", "Lkotlin/Lazy;", "valueOf", "category", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class CharCategory$Companion
{
  private final Map<Integer, CharCategory> getCategoryMap()
  {
    Lazy localLazy = CharCategory.access$getCategoryMap$cp();
    Companion localCompanion = CharCategory.Companion;
    return (Map)localLazy.getValue();
  }
  
  @NotNull
  public final CharCategory valueOf(int paramInt)
  {
    Object localObject = (CharCategory)((Companion)this).getCategoryMap().get(Integer.valueOf(paramInt));
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Category #");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" is not defined.");
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.text.CharCategory.Companion
 * JD-Core Version:    0.7.0.1
 */