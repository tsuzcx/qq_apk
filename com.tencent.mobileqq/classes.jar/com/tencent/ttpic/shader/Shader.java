package com.tencent.ttpic.shader;

import android.opengl.GLES20;
import com.tencent.ttpic.gles.ProgramTools;

public class Shader
{
  private final String fragmentShaderSource;
  private int shaderProgram = 0;
  private final String vertexShaderSource;
  
  public Shader(String paramString1, String paramString2)
  {
    this.fragmentShaderSource = paramString2;
    this.vertexShaderSource = paramString1;
  }
  
  public void bind()
  {
    GLES20.glUseProgram(this.shaderProgram);
  }
  
  public void compile()
  {
    this.shaderProgram = ProgramTools.createProgram(this.vertexShaderSource, this.fragmentShaderSource);
  }
  
  String getFragmentShaderSource()
  {
    return this.fragmentShaderSource;
  }
  
  int getShaderProgram()
  {
    return this.shaderProgram;
  }
  
  String getVertexShaderSource()
  {
    return this.vertexShaderSource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.shader.Shader
 * JD-Core Version:    0.7.0.1
 */