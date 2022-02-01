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

public class lgn
  implements Handler.Callback
{
  private blhq jdField_a_of_type_Blhq = new blhq(Looper.getMainLooper(), this);
  private final ConcurrentHashMap<String, lgo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  private final ConcurrentLinkedQueue<String> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0) && (!this.jdField_a_of_type_Blhq.hasMessages(1))) {
      this.jdField_a_of_type_Blhq.sendEmptyMessage(1);
    }
  }
  
  private void b(String paramString, lgo paramlgo)
  {
    if (paramlgo == null)
    {
      a();
      return;
    }
    if (paramlgo.a())
    {
      a();
      return;
    }
    if (paramlgo.jdField_a_of_type_Lgr == null)
    {
      paramlgo.jdField_a_of_type_Int += 1;
      a();
      return;
    }
    paramlgo.jdField_a_of_type_Int += 1;
    ThreadManager.excute(new Checker.1(this, paramlgo, paramString), 16, null, false);
  }
  
  public void a(String paramString, lgo paramlgo)
  {
    boolean bool = paramlgo.jdField_a_of_type_Lgr.isUsable();
    int j;
    if ((bool) && (!bhmi.a(paramlgo.jdField_b_of_type_JavaLangString))) {
      j = 1;
    }
    for (;;)
    {
      if (j != 0) {}
      try
      {
        bhmi.a(paramlgo.jdField_a_of_type_JavaLangString, paramlgo.jdField_b_of_type_JavaLangString, false);
        paramlgo.jdField_b_of_type_Boolean = true;
        if ((!paramlgo.jdField_b_of_type_Boolean) && (paramlgo.a()) && (paramlgo.jdField_a_of_type_Boolean))
        {
          bhmi.d(paramlgo.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("Checker", 2, "realCheck, del zip id[" + paramString + "], path[" + paramlgo.jdField_a_of_type_JavaLangString + "]");
          }
        }
        return;
        if ((bool) && (paramlgo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          i = 0;
          label144:
          if (i < paramlgo.jdField_a_of_type_JavaUtilArrayList.size())
          {
            String str = (String)paramlgo.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (TextUtils.isEmpty(str)) {}
            label327:
            for (;;)
            {
              i += 1;
              break label144;
              if (paramlgo.jdField_b_of_type_JavaLangString.endsWith(File.separator)) {}
              for (str = paramlgo.jdField_b_of_type_JavaLangString + str;; str = paramlgo.jdField_b_of_type_JavaLangString + File.separator + str)
              {
                if (bhmi.a(str)) {
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
                bhmi.a(paramlgo.jdField_b_of_type_JavaLangString);
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
          paramlgo.jdField_b_of_type_Boolean = false;
          QLog.i("Checker", 2, "realCheck, uncompressZip fail, record[" + paramlgo + "]", localIOException);
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
  
  public void a(lgr paramlgr, String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject;
    if (paramlgr == null)
    {
      localObject = null;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(localObject))) {
        break label51;
      }
    }
    label51:
    lgo locallgo1;
    do
    {
      return;
      localObject = paramlgr.getId();
      break;
      if (QLog.isColorLevel()) {
        QLog.i("Checker", 2, "addToCheck, item[" + paramlgr + "]");
      }
      lgo locallgo2 = (lgo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      locallgo1 = locallgo2;
      if (locallgo2 == null)
      {
        locallgo1 = new lgo(paramlgr, paramArrayList, paramBoolean);
        locallgo1.jdField_a_of_type_JavaLangString = paramString1;
        locallgo1.jdField_b_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, locallgo1);
      }
    } while (locallgo1.a());
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
        paramMessage = (lgo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      }
      b(str, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgn
 * JD-Core Version:    0.7.0.1
 */