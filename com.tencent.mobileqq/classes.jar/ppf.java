import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.commonsdk.cache.QQLruCache;
import java.util.List;

class ppf
  extends QQLruCache<String, List<BaseData>>
{
  ppf(ppe paramppe, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
  {
    super.entryRemoved(paramBoolean, paramString, paramList1, paramList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppf
 * JD-Core Version:    0.7.0.1
 */