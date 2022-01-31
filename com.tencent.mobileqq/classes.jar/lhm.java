import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.business.manager.Checker.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class lhm
  implements Handler.Callback
{
  private bfnk jdField_a_of_type_Bfnk = new bfnk(Looper.getMainLooper(), this);
  private final ConcurrentHashMap<String, lhn> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  private final ConcurrentLinkedQueue<String> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) && (!this.jdField_a_of_type_Bfnk.hasMessages(1))) {
      this.jdField_a_of_type_Bfnk.sendEmptyMessage(1);
    }
  }
  
  private void b(String paramString, lhn paramlhn)
  {
    if (paramlhn == null)
    {
      a();
      return;
    }
    if (paramlhn.a())
    {
      a();
      return;
    }
    if (paramlhn.jdField_a_of_type_Lhq == null)
    {
      paramlhn.jdField_a_of_type_Int += 1;
      a();
      return;
    }
    paramlhn.jdField_a_of_type_Int += 1;
    ThreadManager.excute(new Checker.1(this, paramlhn, paramString), 16, null, false);
  }
  
  public void a(String paramString, lhn paramlhn)
  {
    boolean bool = paramlhn.jdField_a_of_type_Lhq.isUsable();
    int j;
    if ((bool) && (!bbdj.a(paramlhn.jdField_b_of_type_JavaLangString))) {
      j = 1;
    }
    for (;;)
    {
      if (j != 0) {}
      try
      {
        bbdj.a(paramlhn.jdField_a_of_type_JavaLangString, paramlhn.jdField_b_of_type_JavaLangString, false);
        paramlhn.jdField_b_of_type_Boolean = true;
        if ((!paramlhn.jdField_b_of_type_Boolean) && (paramlhn.a()) && (paramlhn.jdField_a_of_type_Boolean))
        {
          bbdj.d(paramlhn.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("Checker", 2, "realCheck, del zip id[" + paramString + "], path[" + paramlhn.jdField_a_of_type_JavaLangString + "]");
          }
        }
        return;
        if ((bool) && (paramlhn.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          i = 0;
          label144:
          if (i < paramlhn.jdField_a_of_type_JavaUtilArrayList.size())
          {
            String str = (String)paramlhn.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (TextUtils.isEmpty(str)) {}
            label327:
            for (;;)
            {
              i += 1;
              break label144;
              if (paramlhn.jdField_b_of_type_JavaLangString.endsWith(File.separator)) {}
              for (str = paramlhn.jdField_b_of_type_JavaLangString + str;; str = paramlhn.jdField_b_of_type_JavaLangString + File.separator + str)
              {
                if (bbdj.a(str)) {
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
                bbdj.a(paramlhn.jdField_b_of_type_JavaLangString);
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
          paramlhn.jdField_b_of_type_Boolean = false;
          QLog.i("Checker", 2, "realCheck, uncompressZip fail, record[" + paramlhn + "]", localIOException);
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
  
  public void a(lhq paramlhq, String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject;
    if (paramlhq == null)
    {
      localObject = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(localObject))) {
        break label51;
      }
    }
    label51:
    lhn locallhn1;
    do
    {
      return;
      localObject = paramlhq.getId();
      break;
      if (QLog.isColorLevel()) {
        QLog.i("Checker", 2, "addToCheck, item[" + paramlhq + "]");
      }
      lhn locallhn2 = (lhn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      locallhn1 = locallhn2;
      if (locallhn2 == null)
      {
        locallhn1 = new lhn(paramlhq, paramArrayList, paramBoolean);
        locallhn1.jdField_a_of_type_JavaLangString = paramString1;
        locallhn1.jdField_b_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, locallhn1);
      }
    } while (locallhn1.a());
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
        paramMessage = (lhn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      b(str, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lhm
 * JD-Core Version:    0.7.0.1
 */