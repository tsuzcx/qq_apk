package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.HashMap;

class GLShaderManager$GLProgram
{
  HashMap<String, Integer> attribute = new HashMap();
  int colorSize;
  int programId;
  int textureMaskSize = 0;
  int textureSize;
  HashMap<String, Integer> uniform = new HashMap();
  int vertexSize;
  
  int getColorOffset()
  {
    return this.vertexSize + this.textureSize;
  }
  
  int getMaskOffset()
  {
    return this.vertexSize + this.textureSize + this.colorSize;
  }
  
  int getTextureOffset()
  {
    return this.vertexSize;
  }
  
  int getVertexAttributeSize()
  {
    return this.vertexSize + this.textureSize + this.colorSize + this.textureMaskSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLShaderManager.GLProgram
 * JD-Core Version:    0.7.0.1
 */