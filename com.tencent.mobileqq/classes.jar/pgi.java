import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class pgi
  implements pen
{
  pgi(pgg parampgg) {}
  
  public void onClick(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramView.getTag();
    String str2 = null;
    String str1;
    label78:
    String str3;
    long l;
    if ((!TextUtils.isEmpty(localBaseArticleInfo.getSubscribeUin())) && (!"16888".equals(localBaseArticleInfo.getSubscribeUin())))
    {
      str1 = localBaseArticleInfo.getSubscribeUin();
      if ((str1 == null) || (localBaseArticleInfo.unowned)) {
        break label337;
      }
      pgg.a(this.a, str1, pgg.a(this.a).a().a());
      str2 = localBaseArticleInfo.mVideoVid;
      str3 = String.valueOf(localBaseArticleInfo.innerUniqueID);
      if (pgg.a(this.a).a().a() != null) {
        break label375;
      }
      l = 0L;
      label113:
      str3 = new sie(null, str1, str2, str3, l, localBaseArticleInfo.mVideoDuration * 1000).a(pgg.a(this.a).a().b()).a().a();
      if (TextUtils.isEmpty(localBaseArticleInfo.innerUniqueID)) {
        break label395;
      }
    }
    label395:
    for (str2 = String.valueOf(localBaseArticleInfo.innerUniqueID);; str2 = "0")
    {
      odq.a(null, str1, "0X8007410", "0X8007410", 0, 0, "2", "", str2, str3, false);
      uhs.a(pgg.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, pgg.a(this.a).a().a(), 56);
      uhs.a((Activity)pgg.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, pgg.a(this.a).a().a(), 56, true, null);
      if (paramView.getId() == 2131361876) {
        psf.a(paramView);
      }
      return;
      str1 = str2;
      if (TextUtils.isEmpty(localBaseArticleInfo.thirdUin)) {
        break;
      }
      str1 = str2;
      if ("16888".equals(localBaseArticleInfo.thirdUin)) {
        break;
      }
      str1 = localBaseArticleInfo.thirdUin;
      break;
      label337:
      if (!QLog.isColorLevel()) {
        break label78;
      }
      QLog.d("RIJFrameworkHandleClick", 2, "onClick: handleAccountViewGroupClick articleinfo unowned = " + localBaseArticleInfo.unowned);
      break label78;
      label375:
      l = pgg.a(this.a).a().a().a();
      break label113;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgi
 * JD-Core Version:    0.7.0.1
 */