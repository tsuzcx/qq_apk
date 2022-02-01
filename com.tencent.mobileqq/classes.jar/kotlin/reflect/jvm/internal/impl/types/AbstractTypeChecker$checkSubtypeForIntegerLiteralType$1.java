package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;

final class AbstractTypeChecker$checkSubtypeForIntegerLiteralType$1
  extends Lambda
  implements Function3<SimpleTypeMarker, SimpleTypeMarker, Boolean, Boolean>
{
  AbstractTypeChecker$checkSubtypeForIntegerLiteralType$1(AbstractTypeCheckerContext paramAbstractTypeCheckerContext)
  {
    super(3);
  }
  
  public final boolean invoke(@NotNull SimpleTypeMarker paramSimpleTypeMarker1, @NotNull SimpleTypeMarker paramSimpleTypeMarker2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker1, "integerLiteralType");
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker2, "type");
    paramSimpleTypeMarker1 = (Iterable)this.$this_checkSubtypeForIntegerLiteralType.possibleIntegerTypes(paramSimpleTypeMarker1);
    boolean bool1 = paramSimpleTypeMarker1 instanceof Collection;
    boolean bool2 = false;
    if ((bool1) && (((Collection)paramSimpleTypeMarker1).isEmpty())) {
      return false;
    }
    paramSimpleTypeMarker1 = paramSimpleTypeMarker1.iterator();
    int i;
    do
    {
      bool1 = bool2;
      if (!paramSimpleTypeMarker1.hasNext()) {
        break;
      }
      KotlinTypeMarker localKotlinTypeMarker = (KotlinTypeMarker)paramSimpleTypeMarker1.next();
      if ((!Intrinsics.areEqual(this.$this_checkSubtypeForIntegerLiteralType.typeConstructor(localKotlinTypeMarker), this.$this_checkSubtypeForIntegerLiteralType.typeConstructor(paramSimpleTypeMarker2))) && ((!paramBoolean) || (!AbstractTypeChecker.INSTANCE.isSubtypeOf(this.$this_checkSubtypeForIntegerLiteralType, (KotlinTypeMarker)paramSimpleTypeMarker2, localKotlinTypeMarker)))) {
        i = 0;
      } else {
        i = 1;
      }
    } while (i == 0);
    bool1 = true;
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.checkSubtypeForIntegerLiteralType.1
 * JD-Core Version:    0.7.0.1
 */