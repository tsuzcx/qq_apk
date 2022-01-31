package dov.com.qq.im.capture.text;

import ajya;
import bjal;
import bjhi;
import com.tencent.common.app.AppInterface;
import java.util.Arrays;
import java.util.Map;

public final class DynamicTextBuilder$1
  implements Runnable
{
  public void run()
  {
    String str = bjal.a().getCurrentNickname();
    bjhi.a().put(Integer.valueOf(5), Arrays.asList(new String[] { ajya.a(2131703603), "MY JOURNEY \n" + str }));
    bjhi.a().put(Integer.valueOf(27), Arrays.asList(new String[] { "悠闲的\n下午。", str }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextBuilder.1
 * JD-Core Version:    0.7.0.1
 */