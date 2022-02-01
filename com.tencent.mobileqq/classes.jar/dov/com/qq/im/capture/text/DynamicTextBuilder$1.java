package dov.com.qq.im.capture.text;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import dov.com.qq.im.capture.CaptureContext;
import java.util.Arrays;
import java.util.Map;

final class DynamicTextBuilder$1
  implements Runnable
{
  public void run()
  {
    String str = CaptureContext.a().getCurrentNickname();
    DynamicTextBuilder.a().put(Integer.valueOf(5), Arrays.asList(new String[] { HardCodeUtil.a(2131703625), "MY JOURNEY \n" + str }));
    DynamicTextBuilder.a().put(Integer.valueOf(27), Arrays.asList(new String[] { "悠闲的\n下午。", str }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextBuilder.1
 * JD-Core Version:    0.7.0.1
 */