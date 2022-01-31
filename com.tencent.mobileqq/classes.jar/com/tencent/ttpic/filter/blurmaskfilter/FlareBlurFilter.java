package com.tencent.ttpic.filter.blurmaskfilter;

import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.util.FrameUtil;

public class FlareBlurFilter
  extends BaseFilter
  implements BlurMaskFilter.IBlurMaskFilter
{
  private static final String mDefaultShapePath = "assets://camera/camera_video/faceOff/grayImages/heart.jpg";
  private static final String mFlareMaskFragment = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform int width;\nuniform int height;\nuniform float textualwidth;\nuniform float textualheight;\nuniform int r;\nuniform float lumi_weight;\nuniform float lumi_threshold;\n\n\nvoid main()\n{\n vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n\n float mask3Color = texture2D(inputImageTexture3,textureCoordinate).r>0.02?0.01:0.0;//\n if(mask3Color<1.0){\n    float this_weight = (textureColor.r + textureColor.g + textureColor.b) * 0.33333;\n    vec4 total_color = vec4(0.0);\n    float total_weight = 0.0;\n    int radius = 16;//r;//8;//4;//r;//12;//8;//r;\n    int radius_2 = radius*2 + 1;\n    float i = 0.0;\n    float j = 0.0;\n    for(int k=0; k<radius_2*radius_2; k++)\n    {//遍历范围内的所有点\n      i = floor(float(k)/float(radius_2));//取radius_2正方形的行数\n      j = float(k) - i*float(radius_2);//取列数\n      float tempx = 1.0 - i/float(radius_2);//从右下角开始读\n      float tempy = 1.0 - j/float(radius_2);//估计原因是原图像做了上下翻转，所以mask需要从左下，但是左下计算估计复杂点，而图又左右对称，估计就右下了\n\n      float mask = texture2D(inputImageTexture2, vec2(tempx, tempy)).r;//获取对应mask的值\n\n      i -= float(radius);\n      j -= float(radius);//按照中心点位置平移到0点\n\n\n      vec2 coord = vec2(i*textualwidth, j*textualheight);//获取到平移点后，对应原图中的相对坐标位置\n      coord += textureCoordinate;\n      vec4 color = texture2D(inputImageTexture, coord);//获取原图中值\n      float weight = (color.r + color.g + color.b) * 0.33333;//RGB均值\n      float lumi = lumi_weight;//0.1;//0.3;//lumi_weight + 0.2;\n  /*    if(weight > lumi_threshold)//当均值大于某一阈值时，进行对应点的赋值\n       {\n          float mag = weight*255.0 * 0.055;\n          mag *= lumi; //2.5\n          weight = pow(2.0, mag) * 0.001;\n       }\n       else\n       {\n          weight = 0.001;\n       }*/\n       weight *= mask;\n\n       total_color += color * weight;\n       total_weight += weight;\n\n    }\n    vec4 res = total_color / total_weight;\n    res.a = 1.0;\n    float alpha=texture2D(inputImageTexture3,textureCoordinate).r>0.02?1.0:0.0;\n    gl_FragColor = res*(1.0-alpha);\n  }else{\n    gl_FragColor = textureColor;\n   }\n}\n";
  private float lumiThreshold = 0.0F;
  private float lumiWeight = (float)(1.0D / Math.exp(0.0D));
  private int mFrameHeight;
  private int mFrameWidth;
  private int radius = 8;
  
  public FlareBlurFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform int width;\nuniform int height;\nuniform float textualwidth;\nuniform float textualheight;\nuniform int r;\nuniform float lumi_weight;\nuniform float lumi_threshold;\n\n\nvoid main()\n{\n vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n\n float mask3Color = texture2D(inputImageTexture3,textureCoordinate).r>0.02?0.01:0.0;//\n if(mask3Color<1.0){\n    float this_weight = (textureColor.r + textureColor.g + textureColor.b) * 0.33333;\n    vec4 total_color = vec4(0.0);\n    float total_weight = 0.0;\n    int radius = 16;//r;//8;//4;//r;//12;//8;//r;\n    int radius_2 = radius*2 + 1;\n    float i = 0.0;\n    float j = 0.0;\n    for(int k=0; k<radius_2*radius_2; k++)\n    {//遍历范围内的所有点\n      i = floor(float(k)/float(radius_2));//取radius_2正方形的行数\n      j = float(k) - i*float(radius_2);//取列数\n      float tempx = 1.0 - i/float(radius_2);//从右下角开始读\n      float tempy = 1.0 - j/float(radius_2);//估计原因是原图像做了上下翻转，所以mask需要从左下，但是左下计算估计复杂点，而图又左右对称，估计就右下了\n\n      float mask = texture2D(inputImageTexture2, vec2(tempx, tempy)).r;//获取对应mask的值\n\n      i -= float(radius);\n      j -= float(radius);//按照中心点位置平移到0点\n\n\n      vec2 coord = vec2(i*textualwidth, j*textualheight);//获取到平移点后，对应原图中的相对坐标位置\n      coord += textureCoordinate;\n      vec4 color = texture2D(inputImageTexture, coord);//获取原图中值\n      float weight = (color.r + color.g + color.b) * 0.33333;//RGB均值\n      float lumi = lumi_weight;//0.1;//0.3;//lumi_weight + 0.2;\n  /*    if(weight > lumi_threshold)//当均值大于某一阈值时，进行对应点的赋值\n       {\n          float mag = weight*255.0 * 0.055;\n          mag *= lumi; //2.5\n          weight = pow(2.0, mag) * 0.001;\n       }\n       else\n       {\n          weight = 0.001;\n       }*/\n       weight *= mask;\n\n       total_color += color * weight;\n       total_weight += weight;\n\n    }\n    vec4 res = total_color / total_weight;\n    res.a = 1.0;\n    float alpha=texture2D(inputImageTexture3,textureCoordinate).r>0.02?1.0:0.0;\n    gl_FragColor = res*(1.0-alpha);\n  }else{\n    gl_FragColor = textureColor;\n   }\n}\n");
    setFlareShape("assets://camera/camera_video/faceOff/grayImages/heart.jpg");
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33986));
    addParam(new UniformParam.FloatParam("lumi_threshold", this.lumiThreshold));
    addParam(new UniformParam.FloatParam("lumi_weight", this.lumiWeight));
    addParam(new UniformParam.IntParam("r", this.radius));
  }
  
  private void setFlareShape(String paramString)
  {
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramString, 2147483647, 2147483647), 33986, true));
  }
  
  public Frame RenderProcess(Frame paramFrame1, Frame paramFrame2)
  {
    RenderProcess(paramFrame1.getTextureId(), this.mFrameWidth, this.mFrameHeight, -1, 0.0D, paramFrame2);
    return FrameUtil.getLastRenderFrame(paramFrame2);
  }
  
  public void clear()
  {
    super.ClearGLSL();
  }
  
  public void setMaskTextureId(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt, 33986));
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    this.mFrameWidth = paramInt1;
    this.mFrameHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.FlareBlurFilter
 * JD-Core Version:    0.7.0.1
 */