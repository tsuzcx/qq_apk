package dov.com.qq.im.aeeditor.module.autotemplate;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/module/autotemplate/AEAutoTemplateRet;", "", "status", "", "template", "Ldov/com/qq/im/aeeditor/module/autotemplate/AEEditorAutoTemplateBean;", "(JLdov/com/qq/im/aeeditor/module/autotemplate/AEEditorAutoTemplateBean;)V", "getStatus", "()J", "getTemplate", "()Ldov/com/qq/im/aeeditor/module/autotemplate/AEEditorAutoTemplateBean;", "setTemplate", "(Ldov/com/qq/im/aeeditor/module/autotemplate/AEEditorAutoTemplateBean;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AEAutoTemplateRet
{
  public static final AEAutoTemplateRet.Companion a;
  private final long jdField_a_of_type_Long;
  @Nullable
  private AEEditorAutoTemplateBean jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean;
  
  static
  {
    jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateRet$Companion = new AEAutoTemplateRet.Companion(null);
  }
  
  public AEAutoTemplateRet(long paramLong, @Nullable AEEditorAutoTemplateBean paramAEEditorAutoTemplateBean)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean = paramAEEditorAutoTemplateBean;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public final AEEditorAutoTemplateBean a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof AEAutoTemplateRet))
      {
        paramObject = (AEAutoTemplateRet)paramObject;
        if ((this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) || (!Intrinsics.areEqual(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean, paramObject.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = this.jdField_a_of_type_Long;
    int j = (int)(l ^ l >>> 32);
    AEEditorAutoTemplateBean localAEEditorAutoTemplateBean = this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean;
    if (localAEEditorAutoTemplateBean != null) {}
    for (int i = localAEEditorAutoTemplateBean.hashCode();; i = 0) {
      return i + j * 31;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "AEAutoTemplateRet(status=" + this.jdField_a_of_type_Long + ", template=" + this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateRet
 * JD-Core Version:    0.7.0.1
 */