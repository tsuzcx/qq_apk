package cooperation.qzone.webviewplugin;

import bhkl;
import bhkn;
import bhrl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QzoneDynamicAlbumPlugin$7
  implements Runnable
{
  public QzoneDynamicAlbumPlugin$7(bhrl parambhrl, List paramList, String[] paramArrayOfString) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (this.jdField_a_of_type_JavaUtilList.get(i) == null) {}
      label167:
      for (;;)
      {
        i += 1;
        break;
        boolean bool = bhrl.a(BaseApplicationImpl.getContext(), (String)this.jdField_a_of_type_JavaUtilList.get(i), this.jdField_a_of_type_ArrayOfJavaLangString[i], bhrl.b()[0], bhrl.b()[1]);
        if ((bool) && (i == 0) && (!bhrl.b(this.this$0)))
        {
          QLog.d("QzoneDynamicAlbumPlugin", 1, "pickDynamicAlbumImage uploadFirstDynamicPhoto:" + this.jdField_a_of_type_ArrayOfJavaLangString[0]);
          bhkl.a().a().a(this.jdField_a_of_type_ArrayOfJavaLangString[0], this.jdField_a_of_type_JavaUtilList.size());
        }
        for (;;)
        {
          if (bool) {
            break label167;
          }
          QLog.e("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin compress failed! ");
          break;
          QLog.d("QzoneDynamicAlbumPlugin", 4, "no launch uploadFirstDynamicPhoto;");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZLog", 2, "DynamicQzoneDynamicAlbumPlugin compress all done  ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.7
 * JD-Core Version:    0.7.0.1
 */