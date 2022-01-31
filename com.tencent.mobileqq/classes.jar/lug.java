import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.commonsdk.cache.QQLruCache;
import java.util.List;

public class lug
  extends QQLruCache
{
  public lug(FastWebModule paramFastWebModule, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(boolean paramBoolean, String paramString, List paramList1, List paramList2)
  {
    super.entryRemoved(paramBoolean, paramString, paramList1, paramList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lug
 * JD-Core Version:    0.7.0.1
 */