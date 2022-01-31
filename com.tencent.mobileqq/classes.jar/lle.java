import com.tencent.biz.pubaccount.readinjoy.common.ThirdDataSourceAdapter;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.image.AbsThirdDataSourceAdapter.OnPreparedCallback;

public class lle
  implements ThirdVideoManager.UUIDToUrlCallback
{
  public lle(ThirdDataSourceAdapter paramThirdDataSourceAdapter) {}
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    ThirdDataSourceAdapter.a(this.a, 2);
    ThirdDataSourceAdapter localThirdDataSourceAdapter = this.a;
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = "";
    }
    ThirdDataSourceAdapter.a(localThirdDataSourceAdapter, paramString2);
    if (paramInt == 1) {
      ThirdDataSourceAdapter.b(this.a, 1);
    }
    for (;;)
    {
      if (ThirdDataSourceAdapter.a(this.a) != null) {
        ThirdDataSourceAdapter.a(this.a).onPrepared();
      }
      return;
      ThirdDataSourceAdapter.b(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lle
 * JD-Core Version:    0.7.0.1
 */