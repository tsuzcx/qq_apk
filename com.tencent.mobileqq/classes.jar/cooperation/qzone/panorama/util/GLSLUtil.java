package cooperation.qzone.panorama.util;

public class GLSLUtil
{
  public static final String FRAGMENT_SHADER = "precision mediump float;\nuniform sampler2D uTexture;\nvarying vec2 vTextureCoord;\nvoid main(){\n\tgl_FragColor = texture2D(uTexture, vTextureCoord);\n}";
  public static final String VERTEX_SHADER = "attribute vec4 aPosition;\nuniform mat4 uProjectMatrix;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main(){\n\tgl_Position = uProjectMatrix * aPosition;\n    vTextureCoord = aTextureCoord;\n}";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.util.GLSLUtil
 * JD-Core Version:    0.7.0.1
 */