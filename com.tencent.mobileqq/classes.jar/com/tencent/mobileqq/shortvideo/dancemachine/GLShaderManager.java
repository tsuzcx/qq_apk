package com.tencent.mobileqq.shortvideo.dancemachine;

import aiff;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.util.HashMap;

public class GLShaderManager
{
  private static HashMap a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private static int a(String paramString)
  {
    if (paramString.equals("GL_VIEW_VERTEX_GL_VIEW_FRAGMENT")) {
      return GlUtil.a("precision highp float;\nattribute vec3 a_position;\nattribute vec2 a_texCoord;\nattribute vec4 a_color;\nuniform mat4 u_projectionMatrix;\nvarying vec2 v_texCoord;\nvarying vec4 v_color;\nvoid main()\n{\n    gl_Position = u_projectionMatrix * vec4(a_position, 1);\n    v_texCoord = a_texCoord;\n    v_color = a_color;\n}", "precision mediump float;uniform sampler2D u_texture;\nvarying vec2 v_texCoord;\nvarying vec4 v_color;\nvoid main()\n{\n    gl_FragColor = v_color * texture2D(u_texture, v_texCoord);\n}");
    }
    if (paramString.equals("GL_VIEW_VERTEX_MASK_GL_VIEW_FRAGMENT_MASK")) {
      return GlUtil.a("precision highp float;\nattribute vec3 a_position;\nattribute vec2 a_texCoord;\nattribute vec4 a_color;\nattribute vec2 a_texCoordMask;\nuniform mat4 u_projectionMatrix;\nvarying vec2 v_texCoord;\nvarying vec2 v_texCoord_mask;\nvarying vec4 v_color;\nvoid main()\n{\n    gl_Position = u_projectionMatrix * vec4(a_position, 1);\n    v_texCoord = a_texCoord;\n    v_texCoord_mask = a_texCoordMask;\n    v_color = a_color;\n}", "precision mediump float;uniform sampler2D u_texture;\nuniform sampler2D u_texture_mask;\nvarying vec2 v_texCoord;\nvarying vec2 v_texCoord_mask;\nvarying vec4 v_color;\nvoid main()\n{\n    vec4 color;\n    vec4 mask = texture2D(u_texture_mask, v_texCoord_mask);\n    vec4 scan = texture2D(u_texture, v_texCoord);\n    if(mask.a == 1.0){\n       color = scan;\n    }else{\n       discard;\n    }\n    gl_FragColor = v_color * color;\n}");
    }
    return 0;
  }
  
  static aiff a(String paramString)
  {
    aiff localaiff2 = (aiff)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    aiff localaiff1 = localaiff2;
    if (localaiff2 == null)
    {
      localaiff1 = b(paramString);
      if (localaiff1 == null) {
        break label44;
      }
      jdField_a_of_type_JavaUtilHashMap.put(paramString, localaiff1);
    }
    for (;;)
    {
      DanceLog.b("GLShaderManager", "createProgram");
      return localaiff1;
      label44:
      DanceLog.b("GLShaderManager", "createProgram[Init]program=null");
    }
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    DanceLog.b("GLShaderManager", "clearShaderManager");
  }
  
  private static aiff b(String paramString)
  {
    int i = a(paramString);
    DanceLog.b("GLShaderManager", "createProgramInit program=" + i);
    if (i != 0)
    {
      aiff localaiff = new aiff();
      localaiff.jdField_a_of_type_Int = i;
      GLES20.glUseProgram(i);
      if (paramString.equals("GL_VIEW_VERTEX_GL_VIEW_FRAGMENT"))
      {
        localaiff.jdField_a_of_type_JavaUtilHashMap.put("a_position", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_position")));
        localaiff.jdField_a_of_type_JavaUtilHashMap.put("a_texCoord", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_texCoord")));
        localaiff.jdField_a_of_type_JavaUtilHashMap.put("a_color", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_color")));
        localaiff.jdField_b_of_type_JavaUtilHashMap.put("u_projectionMatrix", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_projectionMatrix")));
        localaiff.jdField_b_of_type_JavaUtilHashMap.put("u_texture", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_texture")));
        localaiff.jdField_b_of_type_Int = 3;
        localaiff.c = 2;
        localaiff.d = 4;
      }
      for (;;)
      {
        GLES20.glUseProgram(0);
        return localaiff;
        if (paramString.equals("GL_VIEW_VERTEX_MASK_GL_VIEW_FRAGMENT_MASK"))
        {
          localaiff.jdField_a_of_type_JavaUtilHashMap.put("a_position", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_position")));
          localaiff.jdField_a_of_type_JavaUtilHashMap.put("a_texCoord", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_texCoord")));
          localaiff.jdField_a_of_type_JavaUtilHashMap.put("a_color", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_color")));
          localaiff.jdField_a_of_type_JavaUtilHashMap.put("a_texCoordMask", Integer.valueOf(GLES20.glGetAttribLocation(i, "a_texCoordMask")));
          localaiff.jdField_b_of_type_JavaUtilHashMap.put("u_projectionMatrix", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_projectionMatrix")));
          localaiff.jdField_b_of_type_JavaUtilHashMap.put("u_texture", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_texture")));
          localaiff.jdField_b_of_type_JavaUtilHashMap.put("u_texture_mask", Integer.valueOf(GLES20.glGetUniformLocation(i, "u_texture_mask")));
          localaiff.jdField_b_of_type_Int = 3;
          localaiff.c = 2;
          localaiff.d = 4;
          localaiff.e = 2;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLShaderManager
 * JD-Core Version:    0.7.0.1
 */