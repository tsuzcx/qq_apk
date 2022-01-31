package com.tencent.mobileqq.shortvideo.dancemachine;

public class GLShaderFile
{
  public static final String BASE_KEY = "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT";
  public static final String GL_VIEW_FRAGMENT = "precision mediump float;uniform sampler2D u_texture;\nvarying vec2 v_texCoord;\nvarying vec4 v_color;\nvoid main()\n{\n    gl_FragColor = v_color * texture2D(u_texture, v_texCoord);\n}";
  public static final String GL_VIEW_FRAGMENT_MASK = "precision mediump float;uniform sampler2D u_texture;\nuniform sampler2D u_texture_mask;\nvarying vec2 v_texCoord;\nvarying vec2 v_texCoord_mask;\nvarying vec4 v_color;\nvoid main()\n{\n    vec4 color;\n    vec4 mask = texture2D(u_texture_mask, v_texCoord_mask);\n    vec4 scan = texture2D(u_texture, v_texCoord);\n    if(mask.a == 1.0){\n       color = scan;\n    }else{\n       discard;\n    }\n    gl_FragColor = v_color * color;\n}";
  public static final String GL_VIEW_VERTEX = "precision highp float;\nattribute vec3 a_position;\nattribute vec2 a_texCoord;\nattribute vec4 a_color;\nuniform mat4 u_projectionMatrix;\nvarying vec2 v_texCoord;\nvarying vec4 v_color;\nvoid main()\n{\n    gl_Position = u_projectionMatrix * vec4(a_position, 1);\n    v_texCoord = a_texCoord;\n    v_color = a_color;\n}";
  public static final String GL_VIEW_VERTEX_MASK = "precision highp float;\nattribute vec3 a_position;\nattribute vec2 a_texCoord;\nattribute vec4 a_color;\nattribute vec2 a_texCoordMask;\nuniform mat4 u_projectionMatrix;\nvarying vec2 v_texCoord;\nvarying vec2 v_texCoord_mask;\nvarying vec4 v_color;\nvoid main()\n{\n    gl_Position = u_projectionMatrix * vec4(a_position, 1);\n    v_texCoord = a_texCoord;\n    v_texCoord_mask = a_texCoordMask;\n    v_color = a_color;\n}";
  public static final String MASK_KEY = "GL_VIEW_VERTEX_MASK_GL_VIEW_FRAGMENT_MASK";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLShaderFile
 * JD-Core Version:    0.7.0.1
 */