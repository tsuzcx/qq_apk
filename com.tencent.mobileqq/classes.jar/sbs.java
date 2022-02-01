import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class sbs
  extends sbh
{
  sbs(sbi paramsbi) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    sbi.a(this.a, false);
    Object localObject = null;
    try
    {
      paramActionSheetItem = URLEncoder.encode(paramString, "UTF-8");
      if (!TextUtils.isEmpty(paramBaseArticleInfo.getSubscribeUin()))
      {
        paramString = paramBaseArticleInfo.getSubscribeUin();
        paramBaseArticleInfo = "https://post.mp.qq.com/jubao/index?_wv=3&puin=" + paramString + "&uin_type=0&url=" + paramActionSheetItem + "&type=4&key=" + paramBaseArticleInfo.getInnerUniqueID();
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "click jubao btn, reportUrl:" + paramBaseArticleInfo);
        }
        paramString = new Intent(sbi.a(this.a), QQBrowserActivity.class);
        paramString.putExtra("url", paramBaseArticleInfo);
        paramString.putExtra("hide_more_button", true);
        sbi.a(this.a).startActivity(paramString);
        return;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramActionSheetItem = localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "encode url failed, because UTF-8 is unknown");
          paramActionSheetItem = localObject;
          continue;
          if (!TextUtils.isEmpty(paramBaseArticleInfo.thirdUin)) {
            paramString = paramBaseArticleInfo.thirdUin;
          } else {
            paramString = "0";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbs
 * JD-Core Version:    0.7.0.1
 */