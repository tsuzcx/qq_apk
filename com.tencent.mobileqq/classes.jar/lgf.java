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

public class lgf
  implements Handler.Callback
{
  private bkgm jdField_a_of_type_Bkgm = new bkgm(Looper.getMainLooper(), this);
  private final ConcurrentHashMap<String, lgg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  private final ConcurrentLinkedQueue<String> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) && (!this.jdField_a_of_type_Bkgm.hasMessages(1))) {
      this.jdField_a_of_type_Bkgm.sendEmptyMessage(1);
    }
  }
  
  private void b(String paramString, lgg paramlgg)
  {
    if (paramlgg == null)
    {
      a();
      return;
    }
    if (paramlgg.a())
    {
      a();
      return;
    }
    if (paramlgg.jdField_a_of_type_Lgj == null)
    {
      paramlgg.jdField_a_of_type_Int += 1;
      a();
      return;
    }
    paramlgg.jdField_a_of_type_Int += 1;
    ThreadManager.excute(new Checker.1(this, paramlgg, paramString), 16, null, false);
  }
  
  public void a(String paramString, lgg paramlgg)
  {
    boolean bool = paramlgg.jdField_a_of_type_Lgj.isUsable();
    int j;
    if ((bool) && (!bgmg.a(paramlgg.jdField_b_of_type_JavaLangString))) {
      j = 1;
    }
    for (;;)
    {
      if (j != 0) {}
      try
      {
        bgmg.a(paramlgg.jdField_a_of_type_JavaLangString, paramlgg.jdField_b_of_type_JavaLangString, false);
        paramlgg.jdField_b_of_type_Boolean = true;
        if ((!paramlgg.jdField_b_of_type_Boolean) && (paramlgg.a()) && (paramlgg.jdField_a_of_type_Boolean))
        {
          bgmg.d(paramlgg.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("Checker", 2, "realCheck, del zip id[" + paramString + "], path[" + paramlgg.jdField_a_of_type_JavaLangString + "]");
          }
        }
        return;
        if ((bool) && (paramlgg.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          i = 0;
          label144:
          if (i < paramlgg.jdField_a_of_type_JavaUtilArrayList.size())
          {
            String str = (String)paramlgg.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (TextUtils.isEmpty(str)) {}
            label327:
            for (;;)
            {
              i += 1;
              break label144;
              if (paramlgg.jdField_b_of_type_JavaLangString.endsWith(File.separator)) {}
              for (str = paramlgg.jdField_b_of_type_JavaLangString + str;; str = paramlgg.jdField_b_of_type_JavaLangString + File.separator + str)
              {
                if (bgmg.a(str)) {
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
                bgmg.a(paramlgg.jdField_b_of_type_JavaLangString);
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
          paramlgg.jdField_b_of_type_Boolean = false;
          QLog.i("Checker", 2, "realCheck, uncompressZip fail, record[" + paramlgg + "]", localIOException);
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
  
  public void a(lgj paramlgj, String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject;
    if (paramlgj == null)
    {
      localObject = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(localObject))) {
        break label51;
      }
    }
    label51:
    lgg locallgg1;
    do
    {
      return;
      localObject = paramlgj.getId();
      break;
      if (QLog.isColorLevel()) {
        QLog.i("Checker", 2, "addToCheck, item[" + paramlgj + "]");
      }
      lgg locallgg2 = (lgg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      locallgg1 = locallgg2;
      if (locallgg2 == null)
      {
        locallgg1 = new lgg(paramlgj, paramArrayList, paramBoolean);
        locallgg1.jdField_a_of_type_JavaLangString = paramString1;
        locallgg1.jdField_b_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, locallgg1);
      }
    } while (locallgg1.a());
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
        paramMessage = (lgg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      b(str, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgf
 * JD-Core Version:    0.7.0.1
 */