package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReadKotlinClassHeaderAnnotationVisitor
  implements KotlinJvmBinaryClass.AnnotationVisitor
{
  private static final Map<ClassId, KotlinClassHeader.Kind> HEADER_KINDS;
  private static final boolean IGNORE_OLD_METADATA = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
  private JvmBytecodeBinaryVersion bytecodeVersion = null;
  private String[] data = null;
  private int extraInt = 0;
  private String extraString = null;
  private KotlinClassHeader.Kind headerKind = null;
  private String[] incompatibleData = null;
  private int[] metadataVersionArray = null;
  private String packageName = null;
  private String[] strings = null;
  
  static
  {
    HEADER_KINDS = new HashMap();
    HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
    HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
    HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
    HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
    HEADER_KINDS.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
  }
  
  private boolean shouldHaveData()
  {
    return (this.headerKind == KotlinClassHeader.Kind.CLASS) || (this.headerKind == KotlinClassHeader.Kind.FILE_FACADE) || (this.headerKind == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
  }
  
  @Nullable
  public KotlinClassHeader createHeader()
  {
    if (this.headerKind != null)
    {
      Object localObject = this.metadataVersionArray;
      if (localObject == null) {
        return null;
      }
      boolean bool;
      if ((this.extraInt & 0x8) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      JvmMetadataVersion localJvmMetadataVersion = new JvmMetadataVersion((int[])localObject, bool);
      if (!localJvmMetadataVersion.isCompatible())
      {
        this.incompatibleData = this.data;
        this.data = null;
      }
      else if ((shouldHaveData()) && (this.data == null))
      {
        return null;
      }
      KotlinClassHeader.Kind localKind = this.headerKind;
      localObject = this.bytecodeVersion;
      if (localObject == null) {
        localObject = JvmBytecodeBinaryVersion.INVALID_VERSION;
      }
      return new KotlinClassHeader(localKind, localJvmMetadataVersion, (JvmBytecodeBinaryVersion)localObject, this.data, this.incompatibleData, this.strings, this.extraString, this.extraInt, this.packageName);
    }
    return null;
  }
  
  @Nullable
  public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId paramClassId, @NotNull SourceElement paramSourceElement)
  {
    if (paramClassId == null) {
      $$$reportNull$$$0(0);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(1);
    }
    if (paramClassId.asSingleFqName().equals(JvmAnnotationNames.METADATA_FQ_NAME)) {
      return new ReadKotlinClassHeaderAnnotationVisitor.KotlinMetadataArgumentVisitor(this, null);
    }
    if (IGNORE_OLD_METADATA) {
      return null;
    }
    if (this.headerKind != null) {
      return null;
    }
    paramClassId = (KotlinClassHeader.Kind)HEADER_KINDS.get(paramClassId);
    if (paramClassId != null)
    {
      this.headerKind = paramClassId;
      return new ReadKotlinClassHeaderAnnotationVisitor.OldDeprecatedAnnotationArgumentVisitor(this, null);
    }
    return null;
  }
  
  public void visitEnd() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor
 * JD-Core Version:    0.7.0.1
 */