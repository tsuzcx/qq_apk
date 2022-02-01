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

class rtr
  extends sbh
{
  rtr(rsx paramrsx) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    rsx.b(this.a, true);
    paramVideoInfo = new JSONObject();
    try
    {
      paramVideoInfo.put("channel_id", 409409);
      paramVideoInfo.put("source", 2);
      paramString = rsx.a(this.a);
      if ((paramString.a != null) && (paramString.a.size() > 0))
      {
        rsx.a(this.a, (blir)blji.a(rsx.a(this.a), null));
        paramActionSheetItem = new rts(this);
        rsx.a(this.a).a(paramActionSheetItem);
        paramActionSheetItem = new ReadInJoyDisLikeDialogView(rsx.a(this.a));
        paramActionSheetItem.setOnUninterestConfirmListener(new rtt(this, paramString, paramVideoInfo));
        paramActionSheetItem.setUninterestData(paramString.a);
        rsx.a(this.a).a(paramActionSheetItem, null);
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        try
        {
          if (!rsx.a(this.a).isShowing())
          {
            if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.c()))
            {
              rsx.a(this.a).getWindow().setFlags(8, 8);
              rsx.a(this.a).getWindow().getDecorView().setSystemUiVisibility(rsx.a(this.a).getWindow().getDecorView().getSystemUiVisibility());
              rsx.a(this.a).setOnShowListener(new rtu(this));
            }
            rsx.a(this.a).show();
            ocd.b(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, new sbg(odr.a(null, null, null, null, paramVideoInfo)).i(paramString.g).a().a(), false);
          }
          return;
        }
        catch (Exception paramVideoInfo)
        {
          rsx.a(this.a, "dislikeSheet.show exception=" + paramVideoInfo);
          return;
        }
        paramString = paramString;
        paramString.printStackTrace();
      }
    }
    rsx.a(this.a, "文章ID为：" + paramString.g + anzj.a(2131715022));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtr
 * JD-Core Version:    0.7.0.1
 */