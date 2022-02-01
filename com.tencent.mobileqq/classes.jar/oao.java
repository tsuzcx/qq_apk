import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class oao
{
  public long a;
  private ArrayList<oap> a = new ArrayList();
  public boolean a;
  public long b;
  private ArrayList<oap> b = new ArrayList();
  public long c;
  
  public ArrayList<oap> a()
  {
    return this.a;
  }
  
  public void a(ArrayList<oap> paramArrayList)
  {
    if (paramArrayList != null) {
      this.a.addAll(paramArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("addOldDynamicInfoItemList", 2, "mDynamicInfoList.size():" + this.a.size());
    }
  }
  
  public ArrayList<oap> b()
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
          oap localoap = new oap();
          localoap.a(str);
          this.b.add(localoap);
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
 * Qualified Name:     oao
 * JD-Core Version:    0.7.0.1
 */