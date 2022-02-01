package dov.com.qq.im.aeeditor.module.autotemplate;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/module/autotemplate/AEAutoTemplateRet;", "", "status", "", "template", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "(JLcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "getStatus", "()J", "getTemplate", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "setTemplate", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEAutoTemplateRet
{
  public static final AEAutoTemplateRet.Companion a;
  private final long jdField_a_of_type_Long;
  @Nullable
  private MetaMaterial jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
  
  static
  {
    jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateRet$Companion = new AEAutoTemplateRet.Companion(null);
  }
  
  public AEAutoTemplateRet(long paramLong, @Nullable MetaMaterial paramMetaMaterial)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = paramMetaMaterial;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public final MetaMaterial a()
  {
    return this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof AEAutoTemplateRet))
      {
        paramObject = (AEAutoTemplateRet)paramObject;
        if ((this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) && (Intrinsics.areEqual(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, paramObject.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    long l = this.jdField_a_of_type_Long;
    int j = (int)(l ^ l >>> 32);
    MetaMaterial localMetaMaterial = this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
    int i;
    if (localMetaMaterial != null) {
      i = localMetaMaterial.hashCode();
    } else {
      i = 0;
    }
    return j * 31 + i;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AEAutoTemplateRet(status=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", template=");
    localStringBuilder.append(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateRet
 * JD-Core Version:    0.7.0.1
 */