package dov.com.qq.im.capture.util;

import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.Random;

public class PasterUtil
{
  private static Random a = new Random();
  
  public static PasterUtil.Position a()
  {
    int i = ScreenUtil.a / 4;
    int j = a.nextInt(ScreenUtil.a / 2);
    int k = ScreenUtil.a / 4;
    int m = a.nextInt(ScreenUtil.a / 2);
    return new PasterUtil.Position(i - j + ScreenUtil.a / 2, k - m + (ScreenUtil.b - ScreenUtil.a(249.0F)) / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.util.PasterUtil
 * JD-Core Version:    0.7.0.1
 */