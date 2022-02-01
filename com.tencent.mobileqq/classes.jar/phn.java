import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.widget.QQToast;

class phn
  implements pen
{
  phn(phl paramphl) {}
  
  public void onClick(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo;
    if (paramView.getId() == 2131367711) {
      localBaseArticleInfo = ((skd)paramView.getTag()).a;
    }
    sdg localsdg;
    for (Object localObject = ((skd)paramView.getTag()).b.innerUniqueID;; localObject = ((skd)paramView.getTag()).a.innerUniqueID)
    {
      localsdg = phe.a(localBaseArticleInfo);
      localsdg.n = ((String)localObject);
      localsdg.l = ofe.b();
      if ((phl.a(this.a).a().a() != null) && (!TextUtils.isEmpty(phl.a(this.a).a().a().b()))) {
        localsdg.m = phl.a(this.a).a().a().b();
      }
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      localsdg.h = localObject[0];
      localsdg.i = localObject[1];
      localsdg.j = paramView.getWidth();
      localsdg.k = paramView.getHeight();
      if (!localBaseArticleInfo.isVideoItemForCommonUrlJump()) {
        break;
      }
      pay.d(phl.a(this.a).a().a(), localBaseArticleInfo.mVideoAdsJumpUrl);
      phy.a(localsdg, localBaseArticleInfo, phl.a(this.a));
      return;
      localBaseArticleInfo = ((skd)paramView.getTag()).b;
    }
    if (localBaseArticleInfo.isVideoItemForWeishiJump())
    {
      if (yqu.a(phl.a(this.a).a().a())) {
        uit.a(phl.a(this.a).a().a(), "video_type_videopublic");
      }
      for (;;)
      {
        phy.a(localsdg, localBaseArticleInfo, phl.a(this.a));
        return;
        QQToast.a(phl.a(this.a).a().a(), -1, 2131717360, 0).b(phl.a(this.a).a().a().getResources().getDimensionPixelSize(2131299076));
        uit.b(phl.a(this.a).a().a(), "video_type_videopublic");
      }
    }
    phl.a(this.a).a().a().a(localsdg, localBaseArticleInfo, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phn
 * JD-Core Version:    0.7.0.1
 */