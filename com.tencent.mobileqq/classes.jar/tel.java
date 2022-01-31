import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.List;

public class tel
{
  public int a;
  public SparseIntArray a;
  public String a;
  public List<stSimpleMetaFeed> a;
  private thl a;
  public String b;
  public List<stFeed> b;
  
  private tel()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  }
  
  private List<stSimpleMetaFeed> a(List<stFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (tlf.a(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      stFeed localstFeed = (stFeed)paramList.get(i);
      if ((localstFeed.feed_type == 2) && (localstFeed.feed != null))
      {
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_b_of_type_JavaUtilList.size() + i, this.jdField_a_of_type_JavaUtilList.size() + localArrayList.size());
        localArrayList.add(localstFeed.feed);
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    tlo.b("WSVideoDataManager", "position map: " + this.jdField_a_of_type_AndroidUtilSparseIntArray.toString());
    return localArrayList;
  }
  
  public static tel a()
  {
    return ten.a();
  }
  
  private tgt a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, teo paramteo)
  {
    return new tem(this, paramBoolean1, paramBoolean2, paramteo, paramInt);
  }
  
  private void a(List<stFeed> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2, teo paramteo)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    }
    List localList = a(paramList);
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    if (paramteo == null) {}
    do
    {
      return;
      if (paramInt == 9)
      {
        if (paramBoolean1)
        {
          paramteo.a(false, this.jdField_b_of_type_JavaUtilList, paramBoolean2);
          return;
        }
        paramteo.a(true, paramList, paramBoolean2);
        return;
      }
    } while (paramInt != 10);
    paramteo.a(true, localList, paramBoolean2);
  }
  
  public thf a(tgd paramtgd)
  {
    thf localthf = paramtgd.jdField_a_of_type_Thf;
    Object localObject = localthf;
    if (localthf == null) {
      localObject = new tif();
    }
    ((tif)localObject).a(paramtgd);
    return localObject;
  }
  
  public thl a()
  {
    return this.jdField_a_of_type_Thl;
  }
  
  public thl a(tgd paramtgd, long paramLong, int paramInt)
  {
    thl localthl2 = paramtgd.jdField_a_of_type_Thl;
    thl localthl1 = localthl2;
    if (localthl2 == null) {
      localthl1 = new thl();
    }
    localthl1.jdField_a_of_type_Thp = paramtgd.jdField_a_of_type_Thp;
    localthl1.jdField_a_of_type_AndroidViewViewGroup = paramtgd.a();
    localthl1.jdField_a_of_type_Thf = paramtgd.jdField_a_of_type_Thf;
    localthl1.jdField_a_of_type_Int = 2;
    localthl1.jdField_a_of_type_Long = paramLong;
    localthl1.jdField_b_of_type_Boolean = false;
    localthl1.jdField_b_of_type_Int = paramInt;
    localthl1.jdField_a_of_type_JavaLangString = "follow_tab";
    return localthl1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_Thl != null) {
      this.jdField_a_of_type_Thl = null;
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseIntArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    }
  }
  
  public void a(List<stFeed> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = 15;
    a(paramList);
  }
  
  public void a(tgd paramtgd)
  {
    paramtgd = paramtgd.jdField_a_of_type_Thl;
    if ((paramtgd != null) && ((paramtgd.jdField_a_of_type_Boolean) || ((paramtgd.jdField_a_of_type_Tho != null) && (paramtgd.jdField_a_of_type_Tho.e() != 0)))) {
      paramtgd.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(thl paramthl)
  {
    this.jdField_a_of_type_Thl = paramthl;
  }
  
  public <T> void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, teo<T> paramteo)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {}
    for (String str = this.jdField_a_of_type_JavaLangString;; str = "")
    {
      paramString = new the(new tke(str, paramBoolean1, paramBoolean2, paramString, paramInt), null, a(paramBoolean1, paramBoolean2, paramInt, paramteo), 3001);
      tgx.a().a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tel
 * JD-Core Version:    0.7.0.1
 */