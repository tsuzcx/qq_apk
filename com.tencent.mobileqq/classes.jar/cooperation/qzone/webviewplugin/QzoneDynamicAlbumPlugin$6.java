package cooperation.qzone.webviewplugin;

import android.os.Handler;
import android.os.Message;
import bgbz;
import bgcb;
import bgis;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Date;

public class QzoneDynamicAlbumPlugin$6
  implements Runnable
{
  public QzoneDynamicAlbumPlugin$6(bgis parambgis, ArrayList paramArrayList, int paramInt) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.get(i) == null) {}
      for (;;)
      {
        i += 1;
        break;
        String str1 = bgis.jdField_a_of_type_JavaLangString + (new Date().getTime() + i);
        String str2 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        boolean bool = bgis.a(BaseApplicationImpl.getContext(), str2, str1, bgis.b()[0], bgis.b()[1]);
        if ((bool) && (i == 0) && (!bgis.b(this.this$0)))
        {
          QLog.d("QzoneDynamicAlbumPlugin", 4, "pickDynamicAlbumImage uploadFirstDynamicPhoto:" + str1);
          bgbz.a().a().a(str1, this.jdField_a_of_type_JavaUtilArrayList.size());
        }
        for (;;)
        {
          if (!bool) {
            break label234;
          }
          QLog.d("QzoneDynamicAlbumPlugin", 2, "pickDynamicAlbumImage sendMsg: MSG_PICK_PHOTO_COMPRESS_FINISH");
          Message localMessage = Message.obtain();
          localMessage.what = 2;
          localMessage.arg1 = this.jdField_a_of_type_Int;
          localMessage.obj = new String[] { str2, str1 };
          this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
          break;
          QLog.d("QzoneDynamicAlbumPlugin", 4, "no launch uploadFirstDynamicPhoto;");
        }
        label234:
        QLog.e("QzoneDynamicAlbumPlugin", 2, "compressDynamicAlbumImage failed! skip this photo.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.6
 * JD-Core Version:    0.7.0.1
 */