import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.widget.QQToast;

class ses
  implements sga
{
  ses(sel paramsel) {}
  
  public void onClick(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo;
    if (paramView.getId() == 2131367679) {
      localBaseArticleInfo = ((pne)paramView.getTag()).a;
    }
    rwc localrwc;
    for (Object localObject = ((pne)paramView.getTag()).b.innerUniqueID;; localObject = ((pne)paramView.getTag()).a.innerUniqueID)
    {
      localrwc = sel.a(localBaseArticleInfo);
      localrwc.n = ((String)localObject);
      localrwc.l = odr.b();
      if ((this.a.jdField_a_of_type_Rvy != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_Rvy.b()))) {
        localrwc.m = this.a.jdField_a_of_type_Rvy.b();
      }
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      localrwc.h = localObject[0];
      localrwc.i = localObject[1];
      localrwc.j = paramView.getWidth();
      localrwc.k = paramView.getHeight();
      if (!localBaseArticleInfo.isVideoItemForCommonUrlJump()) {
        break;
      }
      ozs.d(this.a.jdField_a_of_type_AndroidAppActivity, localBaseArticleInfo.mVideoAdsJumpUrl);
      this.a.b(localrwc, localBaseArticleInfo);
      return;
      localBaseArticleInfo = ((pne)paramView.getTag()).b;
    }
    if (localBaseArticleInfo.isVideoItemForWeishiJump())
    {
      if (zqd.a(this.a.jdField_a_of_type_AndroidAppActivity)) {
        ucd.a(this.a.jdField_a_of_type_AndroidAppActivity, "video_type_videopublic");
      }
      for (;;)
      {
        this.a.b(localrwc, localBaseArticleInfo);
        return;
        QQToast.a(this.a.jdField_a_of_type_AndroidAppActivity, -1, 2131717123, 0).b(this.a.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299011));
        ucd.b(this.a.jdField_a_of_type_AndroidAppActivity, "video_type_videopublic");
      }
    }
    this.a.a(localrwc, localBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ses
 * JD-Core Version:    0.7.0.1
 */