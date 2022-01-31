package com.tencent.ttpic.openapi.shader;

import com.tencent.aekit.openrender.internal.Shader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShaderManager
{
  private static final ThreadLocal<ShaderManager> shaderManager = new ShaderManager.1();
  private Map<ShaderCreateFactory.PROGRAM_TYPE, Shader> shaderMap = new HashMap();
  
  public static ShaderManager getInstance()
  {
    return (ShaderManager)shaderManager.get();
  }
  
  public boolean bind(ShaderCreateFactory.PROGRAM_TYPE paramPROGRAM_TYPE)
  {
    paramPROGRAM_TYPE = (Shader)this.shaderMap.get(paramPROGRAM_TYPE);
    if (paramPROGRAM_TYPE == null) {
      return false;
    }
    paramPROGRAM_TYPE.bind();
    return true;
  }
  
  public void clear()
  {
    Iterator localIterator = this.shaderMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Shader)localIterator.next()).clear();
    }
    this.shaderMap.clear();
  }
  
  public boolean clearShader(ShaderCreateFactory.PROGRAM_TYPE paramPROGRAM_TYPE)
  {
    Shader localShader = (Shader)this.shaderMap.get(paramPROGRAM_TYPE);
    if (localShader == null) {
      return false;
    }
    localShader.clear();
    this.shaderMap.remove(paramPROGRAM_TYPE);
    return true;
  }
  
  public void compile()
  {
    Iterator localIterator = this.shaderMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Shader)localIterator.next()).compile();
    }
  }
  
  public Shader getShader(ShaderCreateFactory.PROGRAM_TYPE paramPROGRAM_TYPE)
  {
    if (!this.shaderMap.containsKey(paramPROGRAM_TYPE))
    {
      Shader localShader = ShaderCreateFactory.createShader(paramPROGRAM_TYPE);
      this.shaderMap.put(paramPROGRAM_TYPE, localShader);
    }
    return (Shader)this.shaderMap.get(paramPROGRAM_TYPE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.shader.ShaderManager
 * JD-Core Version:    0.7.0.1
 */