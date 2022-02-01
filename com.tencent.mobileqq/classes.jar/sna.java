import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class sna
  extends suv
{
  sna(smg paramsmg) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    smg.b(this.a, true);
    paramVideoInfo = new JSONObject();
    try
    {
      paramVideoInfo.put("channel_id", 409409);
      paramVideoInfo.put("source", 2);
      paramString = smg.a(this.a);
      if ((paramString.a != null) && (paramString.a.size() > 0))
      {
        smg.a(this.a, (bkzi)bkzz.a(smg.a(this.a), null));
        paramActionSheetItem = new snb(this);
        smg.a(this.a).a(paramActionSheetItem);
        paramActionSheetItem = new ReadInJoyDisLikeDialogView(smg.a(this.a));
        paramActionSheetItem.setOnUninterestConfirmListener(new snc(this, paramString, paramVideoInfo));
        paramActionSheetItem.setUninterestData(paramString.a);
        smg.a(this.a).a(paramActionSheetItem, null);
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        try
        {
          if (!smg.a(this.a).isShowing())
          {
            if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.isInFullScreenBlackList()))
            {
              smg.a(this.a).getWindow().setFlags(8, 8);
              smg.a(this.a).getWindow().getDecorView().setSystemUiVisibility(smg.a(this.a).getWindow().getDecorView().getSystemUiVisibility());
              smg.a(this.a).setOnShowListener(new snd(this));
            }
            smg.a(this.a).show();
            olh.b(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, new suu(omx.a(null, null, null, null, paramVideoInfo)).i(paramString.g).a().a(), false);
          }
          return;
        }
        catch (Exception paramVideoInfo)
        {
          smg.a(this.a, "dislikeSheet.show exception=" + paramVideoInfo);
          return;
        }
        paramString = paramString;
        paramString.printStackTrace();
      }
    }
    smg.a(this.a, "文章ID为：" + paramString.g + anvx.a(2131715604));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sna
 * JD-Core Version:    0.7.0.1
 */