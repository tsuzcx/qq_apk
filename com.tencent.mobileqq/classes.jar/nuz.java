import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nuz
  extends ampt
{
  public nuz(ShopWebViewFragment paramShopWebViewFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((this.a.jdField_a_of_type_ComTencentCommonAppAppInterface == null) || (this.a.jdField_a_of_type_JavaUtilList == null)) {}
    ArrayList localArrayList;
    double d1;
    double d2;
    do
    {
      do
      {
        return;
      } while ((paramInt != 0) || (paramSosoLbsInfo == null));
      localArrayList = new ArrayList();
      Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        RecentShopParcel localRecentShopParcel = (RecentShopParcel)localIterator.next();
        if (localRecentShopParcel.c != 1) {
          try
          {
            localArrayList.add(Long.valueOf(Long.valueOf(localRecentShopParcel.a).longValue()));
          }
          catch (Exception localException) {}
        }
      }
      d1 = paramSosoLbsInfo.a.a;
      d2 = paramSosoLbsInfo.a.b;
    } while (this.a.jdField_a_of_type_Nun == null);
    this.a.jdField_a_of_type_Nun.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, localArrayList, d2, d1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nuz
 * JD-Core Version:    0.7.0.1
 */