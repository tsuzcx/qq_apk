package com.tencent.mobileqq.shortvideo.dancemachine;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.util.HashMap;

public class GLShaderManager
{
  private static HashMap<String, GLShaderManager.GLProgram> sShaderMgr = new HashMap();
  
  private static int buildProgram(String paramString)
  {
    if (paramString.equals("GL_VIEW_VERTEX_GL_VIEW_FRAGMENT")) {
      return GlUtil.createProgram("precision highp float;\nattribute vec3 a_position;\nattribute vec2 a_texCoord;\nattribute vec4 a_color;\nuniform mat4 u_projectionMatrix;\nvarying vec2 v_texCoord;\nvarying vec4 v_color;\nvoid main()\n{\n    gl_Position = u_projectionMatrix * vec4(a_position, 1);\n    v_texCoord = a_texCoord;\n    v_color = a_color;\n}", "precision mediump float;uniform sampler2D u_texture;\nvarying vec2 v_texCoord;\nvarying vec4 v_color;\nvoid main()\n{\n    gl_FragColor = v_color * texture2D(u_texture, v_texCoord);\n}");
    }
    if (paramString.equals("GL_VIEW_VERTEX_MASK_GL_VIEW_FRAGMENT_MASK")) {
      return GlUtil.createProgram("precision highp float;\nattribute vec3 a_position;\nattribute vec2 a_texCoord;\nattribute vec4 a_color;\nattribute vec2 a_texCoordMask;\nuniform mat4 u_projectionMatrix;\nvarying vec2 v_texCoord;\nvarying vec2 v_texCoord_mask;\nvarying vec4 v_color;\nvoid main()\n{\n    gl_Position = u_projectionMatrix * vec4(a_position, 1);\n    v_texCoord = a_texCoord;\n    v_texCoord_mask = a_texCoordMask;\n    v_color = a_color;\n}", "precision mediump float;uniform sampler2D u_texture;\nuniform sampler2D u_texture_mask;\nvarying vec2 v_texCoord;\nvarying vec2 v_texCoord_mask;\nvarying vec4 v_color;\nvoid main()\n{\n    vec4 color;\n    vec4 mask = texture2D(u_texture_mask, v_texCoord_mask);\n    vec4 scan = texture2D(u_texture, v_texCoord);\n    if(mask.a == 1.0){\n       color = scan;\n    }else{\n       discard;\n    }\n    gl_FragColor = v_color * color;\n}");
    }
    return 0;
  }
  
  public static void clearShaderManager()
  {
    sShaderMgr.clear();
    DanceLog.printFrameQueue("GLShaderManager", "clearShaderManager");
  }
  
  static GLShaderManager.GLProgram createProgram(String paramString)
  {
    GLShaderManager.GLProgram localGLProgram2 = (GLShaderManager.GLProgram)sShaderMgr.get(paramString);
    GLShaderManager.GLProgram localGLProgram1 = localGLProgram2;
    if (localGLProgram2 == null)
    {
      localGLProgram1 = createProgramInit(paramString);
      if (localGLProgram1 == null) {
        break label44;
      }
      sShaderMgr.put(paramString, localGLProgram1);
    }
    for (;;)
    {
      DanceLog.printFrameQueue("GLShaderManager", "createProgram");
      return localGLProgram1;
      label44:
      DanceLog.printFrameQueue("GLShaderManager", "createProgram[Init]program=null");
    }
  }
  
  private static GLShaderManager.GLProgram createProgramInit(String paramString)
  {
    int i = buildProgram(paramString);
    DanceLog.printFrameQueue("GLShaderManager", "createProgramInit program=" + i);
    if (i != 0)
    {
      GLShaderManager.GLProgram localGLProgram = new GLShaderManager.GLProgram();
      localGLProgram.programId = i;
      GLES20.glUseProgram(i);
      if (paramString.equals("GL_VIEW_VERTEX_GL_VIEW_FRAGMENT"))
      {
        localGLProgram.attribute.put("a_position", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_position")));
        localGLProgram.attribute.put("a_texCoord", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_texCoord")));
        localGLProgram.attribute.put("a_color", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_color")));
        localGLProgram.uniform.put("u_projectionMatrix", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_projectionMatrix")));
        localGLProgram.uniform.put("u_texture", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_texture")));
        localGLProgram.vertexSize = 3;
        localGLProgram.textureSize = 2;
        localGLProgram.colorSize = 4;
      }
      for (;;)
      {
        GLES20.glUseProgram(0);
        return localGLProgram;
        if (paramString.equals("GL_VIEW_VERTEX_MASK_GL_VIEW_FRAGMENT_MASK"))
        {
          localGLProgram.attribute.put("a_position", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_position")));
          localGLProgram.attribute.put("a_texCoord", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_texCoord")));
          localGLProgram.attribute.put("a_color", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_color")));
          localGLProgram.attribute.put("a_texCoordMask", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_texCoordMask")));
          localGLProgram.uniform.put("u_projectionMatrix", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_projectionMatrix")));
          localGLProgram.uniform.put("u_texture", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_texture")));
          localGLProgram.uniform.put("u_texture_mask", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_texture_mask")));
          localGLProgram.vertexSize = 3;
          localGLProgram.textureSize = 2;
          localGLProgram.colorSize = 4;
          localGLProgram.textureMaskSize = 2;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLShaderManager
 * JD-Core Version:    0.7.0.1
 */