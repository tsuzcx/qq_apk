import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import java.lang.ref.WeakReference;

public class ocp
  implements oco
{
  public ocp(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt == nmf.aw) && (oal.f(ReadInJoyArticleBottomVideoView.a(this.a))))
    {
      oal.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), ReadInJoyArticleBottomVideoView.a(this.a), paramInt);
      return;
    }
    nmf.a(new nyg().a(ReadInJoyArticleBottomVideoView.a(this.a)).a(ReadInJoyArticleBottomVideoView.a(this.a)).a(nmf.a).b(nmf.K).a(ReadInJoyArticleBottomVideoView.a(this.a)).d(paramInt).a());
    if (paramInt == nmf.ax)
    {
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
        bool1 = bbfd.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), (String)localObject);
        long l = ReadInJoyArticleBottomVideoView.a(this.a).c;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          bool2 = nlx.a((Context)ReadInJoyArticleBottomVideoView.a(this.a).get(), (String)localObject);
        }
      }
    }
    for (;;)
    {
      if ((bool1) || (bool2)) {
        if (bool1) {
          break label284;
        }
      }
      label284:
      for (localObject = new nyc(false);; localObject = null)
      {
        sht.c((Activity)paramView.getContext(), oav.a(ReadInJoyArticleBottomVideoView.a(this.a)), null, 2, true, (nyc)localObject);
        oav.a(ReadInJoyArticleBottomVideoView.a(this.a));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocp
 * JD-Core Version:    0.7.0.1
 */