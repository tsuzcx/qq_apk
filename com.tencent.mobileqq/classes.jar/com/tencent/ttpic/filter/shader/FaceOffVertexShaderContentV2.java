package com.tencent.ttpic.filter.shader;

public abstract interface FaceOffVertexShaderContentV2
{
  public static final String CONTENT = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec2 inputGrayTextureCoordinate;\nattribute vec2 inputModelTextureCoordinate;\nattribute float pointsVisValue;\nattribute float opacity;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvarying vec2 modelTextureCoordinate;\nvarying float pointVisValue;\nvarying float opacityValue;\n\nuniform vec2 canvasSize;\nuniform float positionRotate;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    canvasCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n    grayTextureCoordinate = inputGrayTextureCoordinate;\n    modelTextureCoordinate = inputModelTextureCoordinate;\n    pointVisValue = pointsVisValue;\n    opacityValue = opacity;\n}\n";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.shader.FaceOffVertexShaderContentV2
 * JD-Core Version:    0.7.0.1
 */