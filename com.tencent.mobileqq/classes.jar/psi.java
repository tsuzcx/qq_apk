import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.widget.QQToast;

class psi
  implements pnq
{
  psi(psf parampsf) {}
  
  public void onClick(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo;
    if (paramView.getId() == 2131367847) {
      localBaseArticleInfo = ((sxn)paramView.getTag()).a;
    }
    spk localspk;
    for (Object localObject = ((sxn)paramView.getTag()).b.innerUniqueID;; localObject = ((sxn)paramView.getTag()).a.innerUniqueID)
    {
      localspk = prt.a(localBaseArticleInfo);
      localspk.n = ((String)localObject);
      localspk.l = omx.b();
      if ((psf.a(this.a).a().a() != null) && (!TextUtils.isEmpty(psf.a(this.a).a().a().b()))) {
        localspk.m = psf.a(this.a).a().a().b();
      }
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      localspk.h = localObject[0];
      localspk.i = localObject[1];
      localspk.j = paramView.getWidth();
      localspk.k = paramView.getHeight();
      if (!localBaseArticleInfo.isVideoItemForCommonUrlJump()) {
        break;
      }
      pqx.a(psf.a(this.a).a().a(), localBaseArticleInfo.mVideoAdsJumpUrl);
      psu.a(localspk, localBaseArticleInfo, psf.a(this.a));
      return;
      localBaseArticleInfo = ((sxn)paramView.getTag()).b;
    }
    if (localBaseArticleInfo.isVideoItemForWeishiJump())
    {
      if (zfn.a(psf.a(this.a).a().a())) {
        uwq.a(psf.a(this.a).a().a(), "video_type_videopublic");
      }
      for (;;)
      {
        psu.a(localspk, localBaseArticleInfo, psf.a(this.a));
        return;
        QQToast.a(psf.a(this.a).a().a(), -1, 2131717726, 0).b(psf.a(this.a).a().a().getResources().getDimensionPixelSize(2131299080));
        uwq.b(psf.a(this.a).a().a(), "video_type_videopublic");
      }
    }
    psf.a(this.a).a().a().a(localspk, localBaseArticleInfo, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psi
 * JD-Core Version:    0.7.0.1
 */