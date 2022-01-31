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

public class ljk
  implements Handler.Callback
{
  private bhow jdField_a_of_type_Bhow = new bhow(Looper.getMainLooper(), this);
  private final ConcurrentHashMap<String, ljl> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  private final ConcurrentLinkedQueue<String> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) && (!this.jdField_a_of_type_Bhow.hasMessages(1))) {
      this.jdField_a_of_type_Bhow.sendEmptyMessage(1);
    }
  }
  
  private void b(String paramString, ljl paramljl)
  {
    if (paramljl == null)
    {
      a();
      return;
    }
    if (paramljl.a())
    {
      a();
      return;
    }
    if (paramljl.jdField_a_of_type_Ljo == null)
    {
      paramljl.jdField_a_of_type_Int += 1;
      a();
      return;
    }
    paramljl.jdField_a_of_type_Int += 1;
    ThreadManager.excute(new Checker.1(this, paramljl, paramString), 16, null, false);
  }
  
  public void a(String paramString, ljl paramljl)
  {
    boolean bool = paramljl.jdField_a_of_type_Ljo.isUsable();
    int j;
    if ((bool) && (!bdcs.a(paramljl.jdField_b_of_type_JavaLangString))) {
      j = 1;
    }
    for (;;)
    {
      if (j != 0) {}
      try
      {
        bdcs.a(paramljl.jdField_a_of_type_JavaLangString, paramljl.jdField_b_of_type_JavaLangString, false);
        paramljl.jdField_b_of_type_Boolean = true;
        if ((!paramljl.jdField_b_of_type_Boolean) && (paramljl.a()) && (paramljl.jdField_a_of_type_Boolean))
        {
          bdcs.d(paramljl.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("Checker", 2, "realCheck, del zip id[" + paramString + "], path[" + paramljl.jdField_a_of_type_JavaLangString + "]");
          }
        }
        return;
        if ((bool) && (paramljl.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          i = 0;
          label144:
          if (i < paramljl.jdField_a_of_type_JavaUtilArrayList.size())
          {
            String str = (String)paramljl.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (TextUtils.isEmpty(str)) {}
            label327:
            for (;;)
            {
              i += 1;
              break label144;
              if (paramljl.jdField_b_of_type_JavaLangString.endsWith(File.separator)) {}
              for (str = paramljl.jdField_b_of_type_JavaLangString + str;; str = paramljl.jdField_b_of_type_JavaLangString + File.separator + str)
              {
                if (bdcs.a(str)) {
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
                bdcs.a(paramljl.jdField_b_of_type_JavaLangString);
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
          paramljl.jdField_b_of_type_Boolean = false;
          QLog.i("Checker", 2, "realCheck, uncompressZip fail, record[" + paramljl + "]", localIOException);
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
  
  public void a(ljo paramljo, String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject;
    if (paramljo == null)
    {
      localObject = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(localObject))) {
        break label51;
      }
    }
    label51:
    ljl localljl1;
    do
    {
      return;
      localObject = paramljo.getId();
      break;
      if (QLog.isColorLevel()) {
        QLog.i("Checker", 2, "addToCheck, item[" + paramljo + "]");
      }
      ljl localljl2 = (ljl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      localljl1 = localljl2;
      if (localljl2 == null)
      {
        localljl1 = new ljl(paramljo, paramArrayList, paramBoolean);
        localljl1.jdField_a_of_type_JavaLangString = paramString1;
        localljl1.jdField_b_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localljl1);
      }
    } while (localljl1.a());
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
        paramMessage = (ljl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      b(str, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ljk
 * JD-Core Version:    0.7.0.1
 */