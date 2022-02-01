import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class nse
{
  public long a;
  private ArrayList<nsf> a = new ArrayList();
  public boolean a;
  public long b;
  private ArrayList<nsf> b = new ArrayList();
  public long c;
  
  public ArrayList<nsf> a()
  {
    return this.a;
  }
  
  public void a(ArrayList<nsf> paramArrayList)
  {
    if (paramArrayList != null) {
      this.a.addAll(paramArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("addOldDynamicInfoItemList", 2, "mDynamicInfoList.size():" + this.a.size());
    }
  }
  
  public ArrayList<nsf> b()
  {
    return this.b;
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    this.b.clear();
    if (paramArrayList == null) {}
    for (int i = 0;; i = paramArrayList.size())
    {
      int j = 0;
      while (j < i)
      {
        String str = (String)paramArrayList.get(j);
        if (!TextUtils.isEmpty(str))
        {
          nsf localnsf = new nsf();
          localnsf.a(str);
          this.b.add(localnsf);
        }
        j += 1;
      }
    }
    this.a.addAll(this.b);
    if (QLog.isColorLevel()) {
      QLog.d("parceJson2DynamicInfoItemList", 2, "mDynamicInfoList.size():" + this.b.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nse
 * JD-Core Version:    0.7.0.1
 */