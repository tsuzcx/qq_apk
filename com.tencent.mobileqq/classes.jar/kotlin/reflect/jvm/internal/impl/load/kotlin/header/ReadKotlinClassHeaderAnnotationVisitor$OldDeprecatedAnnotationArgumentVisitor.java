package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor
  implements KotlinJvmBinaryClass.AnnotationArgumentVisitor
{
  private ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor paramReadKotlinClassHeaderAnnotationVisitor) {}
  
  @NotNull
  private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor()
  {
    return new ReadKotlinClassHeaderAnnotationVisitor.OldDeprecatedAnnotationArgumentVisitor.1(this);
  }
  
  @NotNull
  private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor()
  {
    return new ReadKotlinClassHeaderAnnotationVisitor.OldDeprecatedAnnotationArgumentVisitor.2(this);
  }
  
  public void visit(@Nullable Name paramName, @Nullable Object paramObject)
  {
    if (paramName == null) {
      return;
    }
    paramName = paramName.asString();
    if ("version".equals(paramName))
    {
      if ((paramObject instanceof int[]))
      {
        paramName = this.this$0;
        paramObject = (int[])paramObject;
        ReadKotlinClassHeaderAnnotationVisitor.access$302(paramName, paramObject);
        if (ReadKotlinClassHeaderAnnotationVisitor.access$400(this.this$0) == null) {
          ReadKotlinClassHeaderAnnotationVisitor.access$402(this.this$0, new JvmBytecodeBinaryVersion(paramObject));
        }
      }
    }
    else if ("multifileClassName".equals(paramName))
    {
      ReadKotlinClassHeaderAnnotationVisitor localReadKotlinClassHeaderAnnotationVisitor = this.this$0;
      if ((paramObject instanceof String)) {
        paramName = (String)paramObject;
      } else {
        paramName = null;
      }
      ReadKotlinClassHeaderAnnotationVisitor.access$502(localReadKotlinClassHeaderAnnotationVisitor, paramName);
    }
  }
  
  @Nullable
  public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull Name paramName, @NotNull ClassId paramClassId)
  {
    if (paramName == null) {
      $$$reportNull$$$0(6);
    }
    if (paramClassId == null) {
      $$$reportNull$$$0(7);
    }
    return null;
  }
  
  @Nullable
  public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@NotNull Name paramName)
  {
    if (paramName == null) {
      $$$reportNull$$$0(2);
    }
    paramName = paramName.asString();
    if ((!"data".equals(paramName)) && (!"filePartClassNames".equals(paramName)))
    {
      if ("strings".equals(paramName)) {
        return stringsArrayVisitor();
      }
      return null;
    }
    return dataArrayVisitor();
  }
  
  public void visitClassLiteral(@NotNull Name paramName, @NotNull ClassLiteralValue paramClassLiteralValue)
  {
    if (paramName == null) {
      $$$reportNull$$$0(0);
    }
    if (paramClassLiteralValue == null) {
      $$$reportNull$$$0(1);
    }
  }
  
  public void visitEnd() {}
  
  public void visitEnum(@NotNull Name paramName1, @NotNull ClassId paramClassId, @NotNull Name paramName2)
  {
    if (paramName1 == null) {
      $$$reportNull$$$0(3);
    }
    if (paramClassId == null) {
      $$$reportNull$$$0(4);
    }
    if (paramName2 == null) {
      $$$reportNull$$$0(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.OldDeprecatedAnnotationArgumentVisitor
 * JD-Core Version:    0.7.0.1
 */