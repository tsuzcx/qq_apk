package dov.com.qq.im.capture.text;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

class JourneyTextItem$2
  implements DynamicTextItem.PreHandleTextHandler
{
  JourneyTextItem$2(JourneyTextItem paramJourneyTextItem) {}
  
  @NonNull
  public String a(int paramInt, @NonNull String paramString)
  {
    String str = paramString;
    if (paramInt == 0) {
      str = TroopFileUtils.b(paramString);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.JourneyTextItem.2
 * JD-Core Version:    0.7.0.1
 */