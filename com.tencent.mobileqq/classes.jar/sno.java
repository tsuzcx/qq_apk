import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.widget.QQToast;

class sno
  implements sow
{
  sno(snh paramsnh) {}
  
  public void onClick(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo;
    if (paramView.getId() == 2131367610) {
      localBaseArticleInfo = ((pur)paramView.getTag()).a;
    }
    sey localsey;
    for (Object localObject = ((pur)paramView.getTag()).b.innerUniqueID;; localObject = ((pur)paramView.getTag()).a.innerUniqueID)
    {
      localsey = snh.a(localBaseArticleInfo);
      localsey.n = ((String)localObject);
      localsey.l = och.b();
      if ((this.a.jdField_a_of_type_Seu != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_Seu.b()))) {
        localsey.m = this.a.jdField_a_of_type_Seu.b();
      }
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      localsey.h = localObject[0];
      localsey.i = localObject[1];
      localsey.j = paramView.getWidth();
      localsey.k = paramView.getHeight();
      if (!localBaseArticleInfo.isVideoItemForCommonUrlJump()) {
        break;
      }
      pha.d(this.a.jdField_a_of_type_AndroidAppActivity, localBaseArticleInfo.mVideoAdsJumpUrl);
      this.a.b(localsey, localBaseArticleInfo);
      return;
      localBaseArticleInfo = ((pur)paramView.getTag()).b;
    }
    if (localBaseArticleInfo.isVideoItemForWeishiJump())
    {
      if (zmi.a(this.a.jdField_a_of_type_AndroidAppActivity)) {
        ucb.a(this.a.jdField_a_of_type_AndroidAppActivity, "video_type_videopublic");
      }
      for (;;)
      {
        this.a.b(localsey, localBaseArticleInfo);
        return;
        QQToast.a(this.a.jdField_a_of_type_AndroidAppActivity, -1, 2131717007, 0).b(this.a.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298998));
        ucb.b(this.a.jdField_a_of_type_AndroidAppActivity, "video_type_videopublic");
      }
    }
    this.a.a(localsey, localBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sno
 * JD-Core Version:    0.7.0.1
 */