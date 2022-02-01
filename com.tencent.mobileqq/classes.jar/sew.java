import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class sew
  implements sga
{
  sew(sel paramsel) {}
  
  public void onClick(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramView.getTag();
    String str2 = null;
    String str1;
    label65:
    String str3;
    long l;
    if ((!TextUtils.isEmpty(localBaseArticleInfo.getSubscribeUin())) && (!"16888".equals(localBaseArticleInfo.getSubscribeUin())))
    {
      str1 = localBaseArticleInfo.getSubscribeUin();
      if ((str1 == null) || (localBaseArticleInfo.unowned)) {
        break label279;
      }
      sel.a(this.a, str1);
      str2 = localBaseArticleInfo.mVideoVid;
      str3 = String.valueOf(localBaseArticleInfo.innerUniqueID);
      if (this.a.jdField_a_of_type_Rvy != null) {
        break label317;
      }
      l = 0L;
      label94:
      str3 = new sbg(null, str1, str2, str3, l, localBaseArticleInfo.mVideoDuration * 1000).a(this.a.c).a().a();
      if (TextUtils.isEmpty(localBaseArticleInfo.innerUniqueID)) {
        break label331;
      }
    }
    label279:
    label317:
    label331:
    for (str2 = String.valueOf(localBaseArticleInfo.innerUniqueID);; str2 = "0")
    {
      ocd.a(null, str1, "0X8007410", "0X8007410", 0, 0, "2", "", str2, str3, false);
      ubd.a(this.a.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localBaseArticleInfo, this.a, 56);
      ubd.a(this.a.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localBaseArticleInfo, this.a, 56, true, null);
      if (paramView.getId() == 2131361876) {
        pms.a(paramView);
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
      if (!QLog.isColorLevel()) {
        break label65;
      }
      QLog.d("ReadInJoyBaseAdapter", 2, "onClick: handleAccountViewGroupClick articleinfo unowned = " + localBaseArticleInfo.unowned);
      break label65;
      l = this.a.jdField_a_of_type_Rvy.a();
      break label94;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sew
 * JD-Core Version:    0.7.0.1
 */