package dov.com.tencent.biz.qqstory.takevideo.doodle.model;

import android.text.TextUtils;
import java.io.File;
import java.util.Comparator;

public class DoodleEmojiManager$DoodleEmojiItemComparator
  implements Comparator<DoodleEmojiItem>
{
  private final String a;
  
  public int a(DoodleEmojiItem paramDoodleEmojiItem1, DoodleEmojiItem paramDoodleEmojiItem2)
  {
    if (TextUtils.equals(this.a, paramDoodleEmojiItem2.pack_id)) {}
    label68:
    label81:
    label111:
    label116:
    label121:
    label127:
    long l;
    do
    {
      int i;
      int j;
      do
      {
        return 1;
        if (TextUtils.equals(this.a, paramDoodleEmojiItem1.pack_id)) {
          return -1;
        }
        paramDoodleEmojiItem1 = paramDoodleEmojiItem1.getLocalEmojiFolderPath();
        paramDoodleEmojiItem2 = paramDoodleEmojiItem2.getLocalEmojiFolderPath();
        if (paramDoodleEmojiItem1 != null)
        {
          paramDoodleEmojiItem1 = new File(paramDoodleEmojiItem1);
          if (paramDoodleEmojiItem2 == null) {
            break label111;
          }
          paramDoodleEmojiItem2 = new File(paramDoodleEmojiItem2);
          if ((paramDoodleEmojiItem1 == null) || (!paramDoodleEmojiItem1.exists())) {
            break label116;
          }
          i = 1;
          if ((paramDoodleEmojiItem2 == null) || (!paramDoodleEmojiItem2.exists())) {
            break label121;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i != 0) || (j != 0)) {
            break label127;
          }
          return 0;
          paramDoodleEmojiItem1 = null;
          break;
          paramDoodleEmojiItem2 = null;
          break label68;
          i = 0;
          break label81;
        }
      } while (i == 0);
      if (j == 0) {
        return -1;
      }
      l = paramDoodleEmojiItem1.lastModified();
    } while (paramDoodleEmojiItem2.lastModified() >= l);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiItemComparator
 * JD-Core Version:    0.7.0.1
 */