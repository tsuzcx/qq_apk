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
      if (localGLProgram1 != null) {
        sShaderMgr.put(paramString, localGLProgram1);
      } else {
        DanceLog.printFrameQueue("GLShaderManager", "createProgram[Init]program=null");
      }
    }
    DanceLog.printFrameQueue("GLShaderManager", "createProgram");
    return localGLProgram1;
  }
  
  private static GLShaderManager.GLProgram createProgramInit(String paramString)
  {
    int i = buildProgram(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createProgramInit program=");
    ((StringBuilder)localObject).append(i);
    DanceLog.printFrameQueue("GLShaderManager", ((StringBuilder)localObject).toString());
    if (i != 0)
    {
      localObject = new GLShaderManager.GLProgram();
      ((GLShaderManager.GLProgram)localObject).programId = i;
      GLES20.glUseProgram(i);
      if (paramString.equals("GL_VIEW_VERTEX_GL_VIEW_FRAGMENT"))
      {
        ((GLShaderManager.GLProgram)localObject).attribute.put("a_position", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_position")));
        ((GLShaderManager.GLProgram)localObject).attribute.put("a_texCoord", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_texCoord")));
        ((GLShaderManager.GLProgram)localObject).attribute.put("a_color", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_color")));
        ((GLShaderManager.GLProgram)localObject).uniform.put("u_projectionMatrix", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_projectionMatrix")));
        ((GLShaderManager.GLProgram)localObject).uniform.put("u_texture", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_texture")));
        ((GLShaderManager.GLProgram)localObject).vertexSize = 3;
        ((GLShaderManager.GLProgram)localObject).textureSize = 2;
        ((GLShaderManager.GLProgram)localObject).colorSize = 4;
      }
      else if (paramString.equals("GL_VIEW_VERTEX_MASK_GL_VIEW_FRAGMENT_MASK"))
      {
        ((GLShaderManager.GLProgram)localObject).attribute.put("a_position", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_position")));
        ((GLShaderManager.GLProgram)localObject).attribute.put("a_texCoord", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_texCoord")));
        ((GLShaderManager.GLProgram)localObject).attribute.put("a_color", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_color")));
        ((GLShaderManager.GLProgram)localObject).attribute.put("a_texCoordMask", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_texCoordMask")));
        ((GLShaderManager.GLProgram)localObject).uniform.put("u_projectionMatrix", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_projectionMatrix")));
        ((GLShaderManager.GLProgram)localObject).uniform.put("u_texture", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_texture")));
        ((GLShaderManager.GLProgram)localObject).uniform.put("u_texture_mask", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_texture_mask")));
        ((GLShaderManager.GLProgram)localObject).vertexSize = 3;
        ((GLShaderManager.GLProgram)localObject).textureSize = 2;
        ((GLShaderManager.GLProgram)localObject).colorSize = 4;
        ((GLShaderManager.GLProgram)localObject).textureMaskSize = 2;
      }
      GLES20.glUseProgram(0);
      return localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLShaderManager
 * JD-Core Version:    0.7.0.1
 */