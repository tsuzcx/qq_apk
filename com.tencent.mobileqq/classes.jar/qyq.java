import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class qyq<T>
  implements rjw
{
  protected abstract String a();
  
  protected abstract List<T> a();
  
  public List<rjx> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = a();
      int i = paramInt;
      if (b()) {
        i = paramInt - 1;
      }
      a(i, paramBoolean, localList, localArrayList);
      b(i, paramBoolean, localList, localArrayList);
    }
    return localArrayList;
  }
  
  protected abstract rjn a();
  
  protected abstract rjx a(T paramT);
  
  protected void a(int paramInt, boolean paramBoolean, List<T> paramList, List<rjx> paramList1)
  {
    int j = paramInt + 1;
    int i = 0;
    int k = 0;
    paramList1.size();
    if (j < paramList.size())
    {
      int m = Math.min(rmd.a().a(a(), paramInt) + paramInt, paramList.size() - 1);
      paramInt = k;
      for (;;)
      {
        i = paramInt;
        if (j > m) {
          break;
        }
        paramList1.add(a(paramList.get(j)));
        j += 1;
        paramInt += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DefaultVideoPreDownloadController", 2, "scroll to next = " + paramBoolean + " preDownload to forward = " + i);
    }
  }
  
  public boolean a()
  {
    return rmd.a().a(a());
  }
  
  protected void b(int paramInt, boolean paramBoolean, List<T> paramList, List<rjx> paramList1)
  {
    int i = 0;
    int k = 0;
    int j = paramInt - 1;
    paramList1.size();
    if (j >= 0)
    {
      int m = Math.max(paramInt - rmd.a().a(), 0);
      paramInt = k;
      for (;;)
      {
        i = paramInt;
        if (j < m) {
          break;
        }
        paramList1.add(a(paramList.get(j)));
        j -= 1;
        paramInt += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DefaultVideoPreDownloadController", 2, "scroll to next = " + paramBoolean + " preDownload to backward = " + i);
    }
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qyq
 * JD-Core Version:    0.7.0.1
 */