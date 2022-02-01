package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor
  implements KotlinJvmBinaryClass.AnnotationArgumentVisitor
{
  private ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor paramReadKotlinClassHeaderAnnotationVisitor) {}
  
  @NotNull
  private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor()
  {
    return new ReadKotlinClassHeaderAnnotationVisitor.KotlinMetadataArgumentVisitor.1(this);
  }
  
  @NotNull
  private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor()
  {
    return new ReadKotlinClassHeaderAnnotationVisitor.KotlinMetadataArgumentVisitor.2(this);
  }
  
  public void visit(@Nullable Name paramName, @Nullable Object paramObject)
  {
    if (paramName == null) {
      return;
    }
    paramName = paramName.asString();
    if ("k".equals(paramName))
    {
      if ((paramObject instanceof Integer)) {
        ReadKotlinClassHeaderAnnotationVisitor.access$202(this.this$0, KotlinClassHeader.Kind.getById(((Integer)paramObject).intValue()));
      }
    }
    else if ("mv".equals(paramName))
    {
      if ((paramObject instanceof int[])) {
        ReadKotlinClassHeaderAnnotationVisitor.access$302(this.this$0, (int[])paramObject);
      }
    }
    else if ("bv".equals(paramName))
    {
      if ((paramObject instanceof int[])) {
        ReadKotlinClassHeaderAnnotationVisitor.access$402(this.this$0, new JvmBytecodeBinaryVersion((int[])paramObject));
      }
    }
    else if ("xs".equals(paramName))
    {
      if ((paramObject instanceof String)) {
        ReadKotlinClassHeaderAnnotationVisitor.access$502(this.this$0, (String)paramObject);
      }
    }
    else if ("xi".equals(paramName))
    {
      if ((paramObject instanceof Integer)) {
        ReadKotlinClassHeaderAnnotationVisitor.access$602(this.this$0, ((Integer)paramObject).intValue());
      }
    }
    else if (("pn".equals(paramName)) && ((paramObject instanceof String))) {
      ReadKotlinClassHeaderAnnotationVisitor.access$702(this.this$0, (String)paramObject);
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
    if ("d1".equals(paramName)) {
      return dataArrayVisitor();
    }
    if ("d2".equals(paramName)) {
      return stringsArrayVisitor();
    }
    return null;
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
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.KotlinMetadataArgumentVisitor
 * JD-Core Version:    0.7.0.1
 */