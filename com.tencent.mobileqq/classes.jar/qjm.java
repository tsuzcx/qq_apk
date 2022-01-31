import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class qjm<T>
  implements quk
{
  public int a()
  {
    return 0;
  }
  
  protected abstract List<T> a();
  
  public List<qul> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = a();
      a(paramInt, paramBoolean, localList, localArrayList);
      b(paramInt - a(), paramBoolean, localList, localArrayList);
    }
    return localArrayList;
  }
  
  protected abstract qul a(T paramT);
  
  protected void a(int paramInt, boolean paramBoolean, List<T> paramList, List<qul> paramList1)
  {
    int j = paramInt + 1;
    paramList1.size();
    if (j < paramList.size())
    {
      if (paramBoolean) {}
      for (int i = 4;; i = 3)
      {
        int k = Math.min(i + paramInt, paramList.size() - 1);
        paramInt = 0;
        i = j;
        for (;;)
        {
          j = paramInt;
          if (i > k) {
            break;
          }
          paramList1.add(a(paramList.get(i)));
          i += 1;
          paramInt += 1;
        }
      }
    }
    j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("DefaultVideoPreDownloadController", 2, "scroll to next = " + paramBoolean + " preDownload to forward = " + j);
    }
  }
  
  public boolean a()
  {
    return bbev.h(BaseApplicationImpl.getApplication().getApplicationContext());
  }
  
  protected void b(int paramInt, boolean paramBoolean, List<T> paramList, List<qul> paramList1)
  {
    int j = paramInt - 1;
    paramList1.size();
    if (j >= 0)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 2)
      {
        int k = Math.max(paramInt - i, 0);
        paramInt = 0;
        i = j;
        for (;;)
        {
          j = paramInt;
          if (i < k) {
            break;
          }
          paramList1.add(a(paramList.get(i)));
          i -= 1;
          paramInt += 1;
        }
      }
    }
    j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("DefaultVideoPreDownloadController", 2, "scroll to next = " + paramBoolean + " preDownload to backward = " + j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qjm
 * JD-Core Version:    0.7.0.1
 */