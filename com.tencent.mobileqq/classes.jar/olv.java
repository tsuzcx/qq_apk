import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.DiffUtil.Callback;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager.SlideItemInfo;
import java.util.List;

public class olv
  extends DiffUtil.Callback
{
  private List a;
  private List b;
  
  public olv(List paramList1, List paramList2)
  {
    this.a = paramList1;
    this.b = paramList2;
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return TextUtils.equals(((SlideShowPhotoListManager.SlideItemInfo)this.a.get(paramInt1)).a, ((SlideShowPhotoListManager.SlideItemInfo)this.b.get(paramInt2)).a);
  }
  
  public int b()
  {
    return this.b.size();
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     olv
 * JD-Core Version:    0.7.0.1
 */