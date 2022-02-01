package com.tencent.ttpic.filter.shader;

public abstract interface ReshapeFragmentShaderVtfContent
{
  public static final String CONTENT = "#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n\n    //vec2 diffPosition = textureCoordinate;\n    //float ddx = (diffPosition.x + 1.0) / 2.0;\n    //float ddy = (diffPosition.y + 1.0) / 2.0;\n    //diffPosition = vec2(ddx,ddy);\n    //vec2 a = fract(diffPosition * 255.0 / 256.0);\n    //vec2 b = fract(diffPosition * 255.0 * 255.0 / 256.0);\n    //gl_FragColor = vec4(a,b);\n\n    // 新版的 shader 颜色通道中记录的是位移偏移量，只有在最后 combinedFilter 才最终将所有 filter 的位移量叠加，去图上取点。这样的好处是：\n    // 1. 只有 128 * 128 个点\n    // 2. smoothstep 会更平滑，128 * 128 个点取插值，原来的处理方法会使像素点变模糊\n    // 3. 两个矩形交叠的地方，位移处理的先后顺序不影响结果（不能说这是好还是坏，因为 PS 的液化是作用在原图上的）\n\n    // 至于此处要改为 * 255 再 / 255 是为了提升精度（浮点纹理 iOS 不支持，而一个字节只能表示 256 个不同值）\n    // 本来小奇使用了浮点纹理，但是发现有机型不支持，不用浮点纹理又精度不够，所以采用这个方法，变成2个字节表示一个值，提升了精度。\n    vec2 diffPosition = textureCoordinate;\n    diffPosition = 0.5 * (diffPosition + 1.0) * 255.0;  // 0.5 * (diffPosition + 1.0) 是将(-1, 1)间的值转换到(0, 1)，\n    vec2 a = floor(diffPosition) / 255.0;\n    vec2 b = fract(diffPosition);\n    gl_FragColor = vec4(a, b);\n\n\n    //vec2 diffPosition = textureCoordinate;\n    //diffPosition = 0.5 * (diffPosition + 1.0) * 256.0;\n    //vec2 a = floor(diffPosition) / 256.0;\n    //vec2 b = fract(diffPosition);\n    //gl_FragColor = vec4(a, b);\n}\n";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.shader.ReshapeFragmentShaderVtfContent
 * JD-Core Version:    0.7.0.1
 */