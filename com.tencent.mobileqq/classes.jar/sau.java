import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class sau
  extends sif
{
  sau(sab paramsab) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Object localObject = null;
    paramActionSheetItem = localObject;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramActionSheetItem = URLEncoder.encode(paramString, "UTF-8");
      if (!TextUtils.isEmpty(paramVideoInfo.j))
      {
        paramString = paramVideoInfo.j;
        paramInt = 0;
        if (paramVideoInfo.a == 6) {
          paramInt = 1;
        }
        paramVideoInfo = "https://post.mp.qq.com/jubao/index?_wv=3&puin=" + paramString + "&uin_type=" + paramInt + "&url=" + paramActionSheetItem + "&type=4&key=" + paramVideoInfo.g;
        sab.a(this.a, "click jubao btn, reportUrl:" + paramVideoInfo);
        sab.a(this.a).b(sab.b(this.a));
        paramString = new Intent(sab.a(this.a), QQBrowserActivity.class);
        paramString.putExtra("url", paramVideoInfo);
        paramString.putExtra("hide_more_button", true);
        sab.a(this.a).startActivity(paramString);
        return;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        sab.a(this.a, "encode url failed, because UTF-8 is unknown");
        paramActionSheetItem = localObject;
        continue;
        paramString = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sau
 * JD-Core Version:    0.7.0.1
 */