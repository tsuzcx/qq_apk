package dov.com.qq.im.aeeditor.module.params;

class DefaultImageParamStrategy
  implements ImageParamStrategy
{
  public int a()
  {
    return 960;
  }
  
  public int b()
  {
    return ((Integer)ParamsUtil.a(Integer.valueOf(1024), Integer.valueOf(2048))).intValue();
  }
  
  public int c()
  {
    return (int)(b() * 1.3D);
  }
  
  public int d()
  {
    return ((Integer)ParamsUtil.a(Integer.valueOf(1080), Integer.valueOf(1920), Integer.valueOf(2560))).intValue();
  }
  
  public int e()
  {
    return 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.params.DefaultImageParamStrategy
 * JD-Core Version:    0.7.0.1
 */