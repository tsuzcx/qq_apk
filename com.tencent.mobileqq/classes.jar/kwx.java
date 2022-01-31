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

public class kwx
  implements Handler.Callback
{
  private befq jdField_a_of_type_Befq = new befq(Looper.getMainLooper(), this);
  private final ConcurrentHashMap<String, kwy> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  private final ConcurrentLinkedQueue<String> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) && (!this.jdField_a_of_type_Befq.hasMessages(1))) {
      this.jdField_a_of_type_Befq.sendEmptyMessage(1);
    }
  }
  
  private void b(String paramString, kwy paramkwy)
  {
    if (paramkwy == null)
    {
      a();
      return;
    }
    if (paramkwy.a())
    {
      a();
      return;
    }
    if (paramkwy.jdField_a_of_type_Kxb == null)
    {
      paramkwy.jdField_a_of_type_Int += 1;
      a();
      return;
    }
    paramkwy.jdField_a_of_type_Int += 1;
    ThreadManager.excute(new Checker.1(this, paramkwy, paramString), 16, null, false);
  }
  
  public void a(String paramString, kwy paramkwy)
  {
    boolean bool = paramkwy.jdField_a_of_type_Kxb.isUsable();
    int j;
    if ((bool) && (!bace.a(paramkwy.jdField_b_of_type_JavaLangString))) {
      j = 1;
    }
    for (;;)
    {
      if (j != 0) {}
      try
      {
        bace.a(paramkwy.jdField_a_of_type_JavaLangString, paramkwy.jdField_b_of_type_JavaLangString, false);
        paramkwy.jdField_b_of_type_Boolean = true;
        if ((!paramkwy.jdField_b_of_type_Boolean) && (paramkwy.a()) && (paramkwy.jdField_a_of_type_Boolean))
        {
          bace.d(paramkwy.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("Checker", 2, "realCheck, del zip id[" + paramString + "], path[" + paramkwy.jdField_a_of_type_JavaLangString + "]");
          }
        }
        return;
        if ((bool) && (paramkwy.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          i = 0;
          label144:
          if (i < paramkwy.jdField_a_of_type_JavaUtilArrayList.size())
          {
            String str = (String)paramkwy.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (TextUtils.isEmpty(str)) {}
            label327:
            for (;;)
            {
              i += 1;
              break label144;
              if (paramkwy.jdField_b_of_type_JavaLangString.endsWith(File.separator)) {}
              for (str = paramkwy.jdField_b_of_type_JavaLangString + str;; str = paramkwy.jdField_b_of_type_JavaLangString + File.separator + str)
              {
                if (bace.a(str)) {
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
                bace.a(paramkwy.jdField_b_of_type_JavaLangString);
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
          paramkwy.jdField_b_of_type_Boolean = false;
          QLog.i("Checker", 2, "realCheck, uncompressZip fail, record[" + paramkwy + "]", localIOException);
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
  
  public void a(kxb paramkxb, String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject;
    if (paramkxb == null)
    {
      localObject = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(localObject))) {
        break label51;
      }
    }
    label51:
    kwy localkwy1;
    do
    {
      return;
      localObject = paramkxb.getId();
      break;
      if (QLog.isColorLevel()) {
        QLog.i("Checker", 2, "addToCheck, item[" + paramkxb + "]");
      }
      kwy localkwy2 = (kwy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      localkwy1 = localkwy2;
      if (localkwy2 == null)
      {
        localkwy1 = new kwy(paramkxb, paramArrayList, paramBoolean);
        localkwy1.jdField_a_of_type_JavaLangString = paramString1;
        localkwy1.jdField_b_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localkwy1);
      }
    } while (localkwy1.a());
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
        paramMessage = (kwy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      b(str, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kwx
 * JD-Core Version:    0.7.0.1
 */