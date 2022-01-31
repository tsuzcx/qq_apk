package com.tencent.ttpic.filters;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.model.StickerItem;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class SwitchFaceFilterBase
  extends BaseFilter
{
  public static final float[] a;
  public static final float[] b;
  public static final float[] c;
  protected int a;
  protected StickerItem a;
  private Map jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F };
    jdField_c_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  }
  
  public SwitchFaceFilterBase(String paramString1, String paramString2, StickerItem paramStickerItem)
  {
    super(paramString1, paramString2);
    this.jdField_a_of_type_ComTencentTtpicModelStickerItem = paramStickerItem;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 4;
  }
  
  public void ApplyGLSLFilter()
  {
    a();
    super.ApplyGLSLFilter();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).initialParams(getmProgramIds());
    }
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(getmProgramIds(), "inputImageTexture");
  }
  
  public void OnDrawFrameGLSL()
  {
    super.OnDrawFrameGLSL();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).setParams(getmProgramIds());
    }
  }
  
  public void a()
  {
    setPositions(jdField_b_of_type_ArrayOfFloat);
    setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
  }
  
  public void a(String paramString, float[] paramArrayOfFloat)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      AttributeParam localAttributeParam2 = (AttributeParam)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      AttributeParam localAttributeParam1 = localAttributeParam2;
      if (localAttributeParam2 == null)
      {
        localAttributeParam1 = new AttributeParam(paramString, paramArrayOfFloat);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localAttributeParam1);
      }
      localAttributeParam1.setVertices(paramArrayOfFloat);
    }
  }
  
  public boolean a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return true;
  }
  
  public boolean a(float[] paramArrayOfFloat)
  {
    a("inputGrayTextureCoordinate", paramArrayOfFloat);
    return true;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.jdField_a_of_type_Int, 0);
    if (this.jdField_a_of_type_Boolean)
    {
      GLES20.glDrawArrays(5, 0, this.jdField_b_of_type_Int);
      if (this.jdField_c_of_type_Int != 0) {
        break label124;
      }
      GLES20.glFinish();
    }
    label124:
    while (this.jdField_c_of_type_Int != 1)
    {
      return true;
      if (this.jdField_b_of_type_Boolean)
      {
        GLES20.glDrawArrays(4, 0, this.jdField_b_of_type_Int);
        break;
      }
      GLES20.glDrawArrays(6, 0, this.jdField_b_of_type_Int);
      break;
    }
    GLES20.glFlush();
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    a("position", paramArrayOfFloat);
    return true;
  }
  
  public boolean setRenderMode(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    a("inputTextureCoordinate", paramArrayOfFloat);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filters.SwitchFaceFilterBase
 * JD-Core Version:    0.7.0.1
 */