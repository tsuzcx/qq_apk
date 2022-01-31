import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class lpe
{
  int jdField_a_of_type_Int = 0;
  baps jdField_a_of_type_Baps;
  loy jdField_a_of_type_Loy = null;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  
  boolean a(loy paramloy)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_Loy == paramloy) || (TextUtils.isEmpty(paramloy.b)) || (paramloy.b.equals(this.jdField_a_of_type_Loy.b))) {
        break label273;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavGPDownloadManager", 2, String.format("GPsoDownloadTask, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(bool) }));
      }
      if (!bool)
      {
        return this.jdField_a_of_type_Boolean;
        bool = true;
      }
      else
      {
        if (this.jdField_a_of_type_Baps != null)
        {
          Object localObject = BaseApplicationImpl.sApplication.getRuntime();
          if ((localObject instanceof AppInterface))
          {
            localObject = ((AppInterface)localObject).getNetEngine(0);
            if (localObject != null)
            {
              QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_Baps.a() }));
              ((bapv)localObject).b(this.jdField_a_of_type_Baps);
            }
          }
        }
        this.jdField_a_of_type_Loy = paramloy;
        this.jdField_a_of_type_Baps = null;
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        if (!lpg.a(this.jdField_a_of_type_Loy)) {
          this.jdField_a_of_type_Int += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavGPDownloadManager", 2, String.format("DownloadContrl, isNeedDownload[%s], mInfo[%s]", new Object[] { Boolean.valueOf(false), this.jdField_a_of_type_Loy }));
        }
        if (this.jdField_a_of_type_Int == 0) {
          return this.jdField_a_of_type_Boolean;
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_Loy, 3);
        return this.jdField_a_of_type_Boolean;
        label273:
        bool = false;
      }
    }
  }
  
  boolean a(loy paramloy, int paramInt)
  {
    String str2;
    String str1;
    String str3;
    boolean bool2;
    if (!lpg.a(paramloy))
    {
      str2 = paramloy.jdField_a_of_type_JavaLangString;
      str1 = paramloy.b;
      str3 = lpg.a() + str1;
      if (paramInt < 0)
      {
        QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载死循环了. info[%s]", new Object[] { paramloy }));
        lpd.a(-3);
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      lpd.a(100);
      return false;
    }
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Bapx = new lpf(this, str1, paramloy, paramInt);
    localbaps.a(str1);
    localbaps.jdField_a_of_type_JavaLangString = str2;
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.jdField_c_of_type_JavaLangString = new File(str3).getPath();
    localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
    paramloy = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramloy instanceof QQAppInterface))
    {
      paramloy = ((QQAppInterface)paramloy).getNetEngine(0);
      if (paramloy != null)
      {
        this.jdField_a_of_type_Baps = localbaps;
        paramloy.a(this.jdField_a_of_type_Baps);
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        lpd.a(-2);
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QavGPDownloadManager", 2, String.format("downloadRes, md5[%s], etr[%s]", new Object[] { str1, Boolean.valueOf(bool1) }));
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lpe
 * JD-Core Version:    0.7.0.1
 */