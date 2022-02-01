import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.business.manager.Checker.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class lgh
  implements Handler.Callback
{
  private bjng jdField_a_of_type_Bjng = new bjng(Looper.getMainLooper(), this);
  private final ConcurrentHashMap<String, lgi> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  private final ConcurrentLinkedQueue<String> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) && (!this.jdField_a_of_type_Bjng.hasMessages(1))) {
      this.jdField_a_of_type_Bjng.sendEmptyMessage(1);
    }
  }
  
  private void b(String paramString, lgi paramlgi)
  {
    if (paramlgi == null)
    {
      a();
      return;
    }
    if (paramlgi.a())
    {
      a();
      return;
    }
    if (paramlgi.jdField_a_of_type_Lgl == null)
    {
      paramlgi.jdField_a_of_type_Int += 1;
      a();
      return;
    }
    paramlgi.jdField_a_of_type_Int += 1;
    ThreadManager.excute(new Checker.1(this, paramlgi, paramString), 16, null, false);
  }
  
  public void a(String paramString, lgi paramlgi)
  {
    boolean bool = paramlgi.jdField_a_of_type_Lgl.isUsable();
    int j;
    if ((bool) && (!FileUtils.fileExists(paramlgi.jdField_b_of_type_JavaLangString))) {
      j = 1;
    }
    for (;;)
    {
      if (j != 0) {}
      try
      {
        FileUtils.uncompressZip(paramlgi.jdField_a_of_type_JavaLangString, paramlgi.jdField_b_of_type_JavaLangString, false);
        paramlgi.jdField_b_of_type_Boolean = true;
        if ((!paramlgi.jdField_b_of_type_Boolean) && (paramlgi.a()) && (paramlgi.jdField_a_of_type_Boolean))
        {
          FileUtils.deleteFile(paramlgi.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("Checker", 2, "realCheck, del zip id[" + paramString + "], path[" + paramlgi.jdField_a_of_type_JavaLangString + "]");
          }
        }
        return;
        if ((bool) && (paramlgi.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          i = 0;
          label144:
          if (i < paramlgi.jdField_a_of_type_JavaUtilArrayList.size())
          {
            String str = (String)paramlgi.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (TextUtils.isEmpty(str)) {}
            label327:
            for (;;)
            {
              i += 1;
              break label144;
              if (paramlgi.jdField_b_of_type_JavaLangString.endsWith(File.separator)) {}
              for (str = paramlgi.jdField_b_of_type_JavaLangString + str;; str = paramlgi.jdField_b_of_type_JavaLangString + File.separator + str)
              {
                if (FileUtils.fileExists(str)) {
                  break label327;
                }
                if (!QLog.isColorLevel()) {
                  break label371;
                }
                QLog.i("Checker", 2, "realCheck, id[" + paramString + "], unExistFile[" + str + "]");
                i = 1;
                j = i;
                if (i == 0) {
                  break;
                }
                FileUtils.deleteDirectory(paramlgi.jdField_b_of_type_JavaLangString);
                j = i;
                break;
              }
            }
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramlgi.jdField_b_of_type_Boolean = false;
          QLog.i("Checker", 2, "realCheck, uncompressZip fail, record[" + paramlgi + "]", localIOException);
          continue;
          label371:
          int i = 1;
          continue;
          i = 0;
        }
        j = 0;
      }
    }
  }
  
  public void a(lgl paramlgl, String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject;
    if (paramlgl == null)
    {
      localObject = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(localObject))) {
        break label51;
      }
    }
    label51:
    lgi locallgi1;
    do
    {
      return;
      localObject = paramlgl.getId();
      break;
      if (QLog.isColorLevel()) {
        QLog.i("Checker", 2, "addToCheck, item[" + paramlgl + "]");
      }
      lgi locallgi2 = (lgi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      locallgi1 = locallgi2;
      if (locallgi2 == null)
      {
        locallgi1 = new lgi(paramlgl, paramArrayList, paramBoolean);
        locallgi1.jdField_a_of_type_JavaLangString = paramString1;
        locallgi1.jdField_b_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, locallgi1);
      }
    } while (locallgi1.a());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(localObject);
    a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      paramMessage = null;
      if (!TextUtils.isEmpty(str)) {
        paramMessage = (lgi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      b(str, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgh
 * JD-Core Version:    0.7.0.1
 */