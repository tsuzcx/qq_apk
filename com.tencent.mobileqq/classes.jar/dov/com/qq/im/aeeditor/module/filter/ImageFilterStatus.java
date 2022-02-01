package dov.com.qq.im.aeeditor.module.filter;

import dov.com.qq.im.aeeditor.module.aifilter.AIFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.ComicsFilterResult;

public class ImageFilterStatus
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 0;
  private AIFilterResult jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterResult;
  private ComicsFilterResult jdField_a_of_type_DovComQqImAeeditorModuleAifilterComicsFilterResult;
  private AEEditorFilterBean.FilterID jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.NON;
  private String jdField_a_of_type_JavaLangString = null;
  private int b = 0;
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public AIFilterResult a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterResult;
  }
  
  public ComicsFilterResult a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterComicsFilterResult;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = this.b;
    this.b = 0;
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.NON;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(AIFilterResult paramAIFilterResult)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterResult = paramAIFilterResult;
    this.jdField_a_of_type_Int = this.b;
    this.b = 1;
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.AIFilter;
  }
  
  public void a(ComicsFilterResult paramComicsFilterResult, int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterComicsFilterResult = paramComicsFilterResult;
    this.jdField_a_of_type_Int = this.b;
    this.b = paramInt;
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.NETWORK;
  }
  
  public void a(String paramString, float paramFloat, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = this.b;
    this.b = paramInt;
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID = AEEditorFilterBean.FilterID.CLIENT;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID == AEEditorFilterBean.FilterID.NON;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID == AEEditorFilterBean.FilterID.AIFilter;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean$FilterID == AEEditorFilterBean.FilterID.NETWORK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.ImageFilterStatus
 * JD-Core Version:    0.7.0.1
 */