package com.tencent.ttpic.shader;

import android.opengl.GLES20;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum ShaderManager
{
  INSTANCE;
  
  private Map<String, Shader> shaderMap = new HashMap();
  
  private ShaderManager() {}
  
  public static ShaderManager getInstance()
  {
    return INSTANCE;
  }
  
  public boolean bind(String paramString)
  {
    paramString = (Shader)this.shaderMap.get(paramString);
    if (paramString == null) {
      return false;
    }
    paramString.bind();
    return true;
  }
  
  public void clear()
  {
    Iterator localIterator = this.shaderMap.values().iterator();
    while (localIterator.hasNext()) {
      GLES20.glDeleteProgram(((Shader)localIterator.next()).getShaderProgram());
    }
    this.shaderMap.clear();
  }
  
  public boolean clearShader(String paramString)
  {
    Shader localShader = (Shader)this.shaderMap.get(paramString);
    if (localShader == null) {
      return false;
    }
    GLES20.glDeleteProgram(localShader.getShaderProgram());
    this.shaderMap.remove(paramString);
    return true;
  }
  
  public void compile()
  {
    Iterator localIterator = this.shaderMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Shader)localIterator.next()).compile();
    }
  }
  
  public void createShader(String paramString1, String paramString2, String paramString3)
    throws IllegalArgumentException
  {
    paramString2 = new Shader(ShaderEncryptUtil.decrypt(paramString2), ShaderEncryptUtil.decrypt(paramString3));
    this.shaderMap.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.shader.ShaderManager
 * JD-Core Version:    0.7.0.1
 */