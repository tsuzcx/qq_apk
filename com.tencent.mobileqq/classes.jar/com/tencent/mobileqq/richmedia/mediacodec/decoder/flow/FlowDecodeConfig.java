package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import com.tencent.mobileqq.richmedia.mediacodec.decoder.DecodeConfig;

public class FlowDecodeConfig
  extends DecodeConfig
{
  public android.opengl.EGLContext a;
  public javax.microedition.khronos.egl.EGLContext a;
  public int c = 0;
  
  public FlowDecodeConfig(DecodeConfig paramDecodeConfig)
  {
    super(paramDecodeConfig.jdField_a_of_type_JavaLangString, paramDecodeConfig.jdField_a_of_type_Int, paramDecodeConfig.jdField_b_of_type_Boolean, paramDecodeConfig.jdField_a_of_type_Boolean, paramDecodeConfig.jdField_a_of_type_Long, paramDecodeConfig.jdField_b_of_type_Long);
  }
  
  public FlowDecodeConfig(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    super(paramString, paramInt, paramBoolean1, paramBoolean2, paramLong1, paramLong2);
  }
  
  public boolean a(DecodeConfig paramDecodeConfig)
  {
    boolean bool = super.a(paramDecodeConfig);
    if ((paramDecodeConfig instanceof FlowDecodeConfig))
    {
      paramDecodeConfig = (FlowDecodeConfig)paramDecodeConfig;
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != paramDecodeConfig.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)
      {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = paramDecodeConfig.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
        bool = true;
      }
      if (this.jdField_a_of_type_AndroidOpenglEGLContext != paramDecodeConfig.jdField_a_of_type_AndroidOpenglEGLContext)
      {
        this.jdField_a_of_type_AndroidOpenglEGLContext = paramDecodeConfig.jdField_a_of_type_AndroidOpenglEGLContext;
        bool = true;
      }
      if (this.c != paramDecodeConfig.c)
      {
        this.c = paramDecodeConfig.c;
        return true;
      }
    }
    else
    {
      throw new IllegalArgumentException("should be FlowDecodeConfig's instance");
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeConfig
 * JD-Core Version:    0.7.0.1
 */