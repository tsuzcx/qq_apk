package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

public class DoodleLinePath
{
  public int a;
  
  public DoodleLinePath(int paramInt)
  {
    this.a = paramInt;
  }
  
  public String a()
  {
    switch (this.a)
    {
    default: 
      return "未知";
    case 101: 
      return "纯色";
    case 102: 
      return "静态个性";
    case 103: 
      return "马赛克";
    case 104: 
      return "马赛克笔触（图片）";
    }
    return "视频马赛克";
  }
  
  public void a() {}
  
  public boolean a(int paramInt)
  {
    return this.a == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLinePath
 * JD-Core Version:    0.7.0.1
 */