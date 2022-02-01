package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import org.jetbrains.annotations.NotNull;

class ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1
  extends ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor
{
  ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1(ReadKotlinClassHeaderAnnotationVisitor.KotlinMetadataArgumentVisitor paramKotlinMetadataArgumentVisitor) {}
  
  protected void visitEnd(@NotNull String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      $$$reportNull$$$0(0);
    }
    ReadKotlinClassHeaderAnnotationVisitor.access$802(this.this$1.this$0, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.KotlinMetadataArgumentVisitor.1
 * JD-Core Version:    0.7.0.1
 */