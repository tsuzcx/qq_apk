import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import java.lang.ref.WeakReference;

public class otb
  implements ota
{
  public otb(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt == nxw.aA) && (opz.g(ReadInJoyArticleBottomVideoView.a(this.a))))
    {
      opz.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), ReadInJoyArticleBottomVideoView.a(this.a), paramInt);
      return;
    }
    if (paramInt == nxw.aB)
    {
      nxw.a(new omp().a(ReadInJoyArticleBottomVideoView.a(this.a)).a(ReadInJoyArticleBottomVideoView.a(this.a)).a(nxw.a).b(ReadInJoyArticleBottomVideoView.a(this.a)).a(ReadInJoyArticleBottomVideoView.a(this.a)).d(paramInt).a());
      ReadInJoyArticleBottomVideoView.a(this.a);
      return;
    }
    Object localObject;
    boolean bool1;
    boolean bool2;
    if (ReadInJoyArticleBottomVideoView.a(this.a) != null) {
      if (ReadInJoyArticleBottomVideoView.a(this.a).D != null)
      {
        localObject = ReadInJoyArticleBottomVideoView.a(this.a).D;
        bool1 = bgnw.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), (String)localObject);
        long l = ReadInJoyArticleBottomVideoView.a(this.a).c;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          bool2 = nxp.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), (String)localObject);
        }
      }
    }
    for (;;)
    {
      if ((bool1) || (bool2)) {
        if (bool1) {
          break label307;
        }
      }
      label307:
      for (localObject = new oml(false);; localObject = null)
      {
        ubb.c(paramView.getContext(), oqk.a(ReadInJoyArticleBottomVideoView.a(this.a)), null, 2, true, (oml)localObject);
        olm.a(true, (Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), oqk.a(ReadInJoyArticleBottomVideoView.a(this.a)), 2, nxw.a, 3);
        return;
        ReadInJoyArticleBottomVideoView.a(this.a, paramView, true, paramInt);
        return;
      }
      bool2 = false;
      continue;
      bool1 = false;
      localObject = "";
      break;
      bool2 = false;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otb
 * JD-Core Version:    0.7.0.1
 */