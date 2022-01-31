import com.tencent.biz.pubaccount.readinjoy.common.ThirdDataSourceAdapter;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.image.AbsThirdDataSourceAdapter.OnPreparedCallback;

public class lkz
  implements ThirdVideoManager.UUIDToUrlCallback
{
  public lkz(ThirdDataSourceAdapter paramThirdDataSourceAdapter) {}
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3)
  {
    ThirdDataSourceAdapter.a(this.a, 2);
    paramString3 = this.a;
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = "";
    }
    ThirdDataSourceAdapter.a(paramString3, paramString2);
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
 * Qualified Name:     lkz
 * JD-Core Version:    0.7.0.1
 */