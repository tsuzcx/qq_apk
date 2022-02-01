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

public class lgt
  implements Handler.Callback
{
  private bkys jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
  private final ConcurrentHashMap<String, lgu> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  private final ConcurrentLinkedQueue<String> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) && (!this.jdField_a_of_type_Bkys.hasMessages(1))) {
      this.jdField_a_of_type_Bkys.sendEmptyMessage(1);
    }
  }
  
  private void b(String paramString, lgu paramlgu)
  {
    if (paramlgu == null)
    {
      a();
      return;
    }
    if (paramlgu.a())
    {
      a();
      return;
    }
    if (paramlgu.jdField_a_of_type_Lgx == null)
    {
      paramlgu.jdField_a_of_type_Int += 1;
      a();
      return;
    }
    paramlgu.jdField_a_of_type_Int += 1;
    ThreadManager.excute(new Checker.1(this, paramlgu, paramString), 16, null, false);
  }
  
  public void a(String paramString, lgu paramlgu)
  {
    boolean bool = paramlgu.jdField_a_of_type_Lgx.isUsable();
    int j;
    if ((bool) && (!FileUtils.fileExists(paramlgu.jdField_b_of_type_JavaLangString))) {
      j = 1;
    }
    for (;;)
    {
      if (j != 0) {}
      try
      {
        FileUtils.uncompressZip(paramlgu.jdField_a_of_type_JavaLangString, paramlgu.jdField_b_of_type_JavaLangString, false);
        paramlgu.jdField_b_of_type_Boolean = true;
        if ((!paramlgu.jdField_b_of_type_Boolean) && (paramlgu.a()) && (paramlgu.jdField_a_of_type_Boolean))
        {
          FileUtils.deleteFile(paramlgu.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("Checker", 2, "realCheck, del zip id[" + paramString + "], path[" + paramlgu.jdField_a_of_type_JavaLangString + "]");
          }
        }
        return;
        if ((bool) && (paramlgu.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          i = 0;
          label144:
          if (i < paramlgu.jdField_a_of_type_JavaUtilArrayList.size())
          {
            String str = (String)paramlgu.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (TextUtils.isEmpty(str)) {}
            label327:
            for (;;)
            {
              i += 1;
              break label144;
              if (paramlgu.jdField_b_of_type_JavaLangString.endsWith(File.separator)) {}
              for (str = paramlgu.jdField_b_of_type_JavaLangString + str;; str = paramlgu.jdField_b_of_type_JavaLangString + File.separator + str)
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
                FileUtils.deleteDirectory(paramlgu.jdField_b_of_type_JavaLangString);
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
          paramlgu.jdField_b_of_type_Boolean = false;
          QLog.i("Checker", 2, "realCheck, uncompressZip fail, record[" + paramlgu + "]", localIOException);
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
  
  public void a(lgx paramlgx, String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject;
    if (paramlgx == null)
    {
      localObject = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(localObject))) {
        break label51;
      }
    }
    label51:
    lgu locallgu1;
    do
    {
      return;
      localObject = paramlgx.getId();
      break;
      if (QLog.isColorLevel()) {
        QLog.i("Checker", 2, "addToCheck, item[" + paramlgx + "]");
      }
      lgu locallgu2 = (lgu)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      locallgu1 = locallgu2;
      if (locallgu2 == null)
      {
        locallgu1 = new lgu(paramlgx, paramArrayList, paramBoolean);
        locallgu1.jdField_a_of_type_JavaLangString = paramString1;
        locallgu1.jdField_b_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, locallgu1);
      }
    } while (locallgu1.a());
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
        paramMessage = (lgu)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      b(str, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgt
 * JD-Core Version:    0.7.0.1
 */