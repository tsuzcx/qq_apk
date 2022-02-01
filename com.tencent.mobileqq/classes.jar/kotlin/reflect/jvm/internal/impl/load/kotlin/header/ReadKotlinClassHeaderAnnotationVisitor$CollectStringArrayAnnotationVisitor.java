package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

abstract class ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor
  implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
{
  private final List<String> strings = new ArrayList();
  
  public void visit(@Nullable Object paramObject)
  {
    if ((paramObject instanceof String)) {
      this.strings.add((String)paramObject);
    }
  }
  
  public void visitClassLiteral(@NotNull ClassLiteralValue paramClassLiteralValue)
  {
    if (paramClassLiteralValue == null) {
      $$$reportNull$$$0(2);
    }
  }
  
  public void visitEnd()
  {
    visitEnd((String[])this.strings.toArray(new String[0]));
  }
  
  protected abstract void visitEnd(@NotNull String[] paramArrayOfString);
  
  public void visitEnum(@NotNull ClassId paramClassId, @NotNull Name paramName)
  {
    if (paramClassId == null) {
      $$$reportNull$$$0(0);
    }
    if (paramName == null) {
      $$$reportNull$$$0(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor
 * JD-Core Version:    0.7.0.1
 */