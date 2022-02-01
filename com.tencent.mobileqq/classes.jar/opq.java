import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.concurrent.CopyOnWriteArrayList;

public class opq
{
  private CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList();
  
  public void a(Context paramContext, pxk parampxk, int paramInt1, int paramInt2)
  {
    if ((this.a == null) || (parampxk.a() == null) || (parampxk.a().mSmallMiniGameInfo == null) || (parampxk.a().mSmallMiniGameInfo.a == null)) {}
    String str;
    do
    {
      return;
      str = parampxk.a().mSmallMiniGameInfo.b + "_" + ((omw)parampxk.a().mSmallMiniGameInfo.a.get(paramInt1)).a;
    } while (this.a.contains(str));
    this.a.add(str);
    nxw.a(paramContext, parampxk.a(), parampxk.h(), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opq
 * JD-Core Version:    0.7.0.1
 */