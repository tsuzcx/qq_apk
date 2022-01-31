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

public class lhh
  implements Handler.Callback
{
  private bfob jdField_a_of_type_Bfob = new bfob(Looper.getMainLooper(), this);
  private final ConcurrentHashMap<String, lhi> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  private final ConcurrentLinkedQueue<String> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) && (!this.jdField_a_of_type_Bfob.hasMessages(1))) {
      this.jdField_a_of_type_Bfob.sendEmptyMessage(1);
    }
  }
  
  private void b(String paramString, lhi paramlhi)
  {
    if (paramlhi == null)
    {
      a();
      return;
    }
    if (paramlhi.a())
    {
      a();
      return;
    }
    if (paramlhi.jdField_a_of_type_Lhl == null)
    {
      paramlhi.jdField_a_of_type_Int += 1;
      a();
      return;
    }
    paramlhi.jdField_a_of_type_Int += 1;
    ThreadManager.excute(new Checker.1(this, paramlhi, paramString), 16, null, false);
  }
  
  public void a(String paramString, lhi paramlhi)
  {
    boolean bool = paramlhi.jdField_a_of_type_Lhl.isUsable();
    int j;
    if ((bool) && (!bbdx.a(paramlhi.jdField_b_of_type_JavaLangString))) {
      j = 1;
    }
    for (;;)
    {
      if (j != 0) {}
      try
      {
        bbdx.a(paramlhi.jdField_a_of_type_JavaLangString, paramlhi.jdField_b_of_type_JavaLangString, false);
        paramlhi.jdField_b_of_type_Boolean = true;
        if ((!paramlhi.jdField_b_of_type_Boolean) && (paramlhi.a()) && (paramlhi.jdField_a_of_type_Boolean))
        {
          bbdx.d(paramlhi.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("Checker", 2, "realCheck, del zip id[" + paramString + "], path[" + paramlhi.jdField_a_of_type_JavaLangString + "]");
          }
        }
        return;
        if ((bool) && (paramlhi.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          i = 0;
          label144:
          if (i < paramlhi.jdField_a_of_type_JavaUtilArrayList.size())
          {
            String str = (String)paramlhi.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (TextUtils.isEmpty(str)) {}
            label327:
            for (;;)
            {
              i += 1;
              break label144;
              if (paramlhi.jdField_b_of_type_JavaLangString.endsWith(File.separator)) {}
              for (str = paramlhi.jdField_b_of_type_JavaLangString + str;; str = paramlhi.jdField_b_of_type_JavaLangString + File.separator + str)
              {
                if (bbdx.a(str)) {
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
                bbdx.a(paramlhi.jdField_b_of_type_JavaLangString);
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
          paramlhi.jdField_b_of_type_Boolean = false;
          QLog.i("Checker", 2, "realCheck, uncompressZip fail, record[" + paramlhi + "]", localIOException);
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
  
  public void a(lhl paramlhl, String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject;
    if (paramlhl == null)
    {
      localObject = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(localObject))) {
        break label51;
      }
    }
    label51:
    lhi locallhi1;
    do
    {
      return;
      localObject = paramlhl.getId();
      break;
      if (QLog.isColorLevel()) {
        QLog.i("Checker", 2, "addToCheck, item[" + paramlhl + "]");
      }
      lhi locallhi2 = (lhi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      locallhi1 = locallhi2;
      if (locallhi2 == null)
      {
        locallhi1 = new lhi(paramlhl, paramArrayList, paramBoolean);
        locallhi1.jdField_a_of_type_JavaLangString = paramString1;
        locallhi1.jdField_b_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, locallhi1);
      }
    } while (locallhi1.a());
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
        paramMessage = (lhi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      b(str, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lhh
 * JD-Core Version:    0.7.0.1
 */