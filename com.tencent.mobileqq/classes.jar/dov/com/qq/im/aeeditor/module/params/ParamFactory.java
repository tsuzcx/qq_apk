package dov.com.qq.im.aeeditor.module.params;

public class ParamFactory
{
  public static ImageParamStrategy a()
  {
    return new DefaultImageParamStrategy();
  }
  
  public static VideoParamStrategy a()
  {
    return new DefaultVideoParamStrategy();
  }
  
  public static VideoParamStrategy b()
  {
    return new CoverParamStrategy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.params.ParamFactory
 * JD-Core Version:    0.7.0.1
 */