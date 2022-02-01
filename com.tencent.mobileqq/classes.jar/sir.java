import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class sir
  extends sif
{
  sir(sig paramsig) {}
  
  private void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    try
    {
      if (!sig.a(this.a).isShowing())
      {
        if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.isInFullScreenBlackList()))
        {
          sig.a(this.a).getWindow().setFlags(8, 8);
          sig.a(this.a).getWindow().getDecorView().setSystemUiVisibility(sig.a(this.a).getWindow().getDecorView().getSystemUiVisibility());
          sig.a(this.a).setOnShowListener(new siv(this));
        }
        sig.a(this.a).show();
        odq.b(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, new sie(ofe.a(null, null, null, null, paramJSONObject)).i(paramBaseArticleInfo.innerUniqueID).a().a(), false);
      }
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "dislikeSheet.show exception=" + paramBaseArticleInfo);
    }
  }
  
  public int a()
  {
    return 7;
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    sig.a(this.a, false);
    paramString = new JSONObject();
    try
    {
      paramString.put("channel_id", sig.a(this.a));
      paramString.put("source", 1);
      if ((paramBaseArticleInfo.mDislikeInfos != null) && (paramBaseArticleInfo.mDislikeInfos.size() > 0))
      {
        sig.a(this.a, (bjnw)bjon.a(sig.a(this.a), null));
        paramActionSheetItem = new sis(this);
        sig.a(this.a).a(paramActionSheetItem);
        paramActionSheetItem = new ReadInJoyDisLikeDialogView(sig.a(this.a));
        paramActionSheetItem.setOnUninterestConfirmListener(new sit(this, paramBaseArticleInfo, paramString));
        paramActionSheetItem.setUninterestData(paramBaseArticleInfo.mDislikeInfos);
        sig.a(this.a).a(paramActionSheetItem, null);
        a(paramBaseArticleInfo, paramString);
        return;
      }
    }
    catch (JSONException paramActionSheetItem)
    {
      do
      {
        for (;;)
        {
          paramActionSheetItem.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "文章ID为：" + paramBaseArticleInfo.mArticleID + "的负反馈数据为空!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sir
 * JD-Core Version:    0.7.0.1
 */