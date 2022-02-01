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

class sav
  extends sif
{
  sav(sab paramsab) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    sab.b(this.a, true);
    paramVideoInfo = new JSONObject();
    try
    {
      paramVideoInfo.put("channel_id", 409409);
      paramVideoInfo.put("source", 2);
      paramString = sab.a(this.a);
      if ((paramString.a != null) && (paramString.a.size() > 0))
      {
        sab.a(this.a, (bjnw)bjon.a(sab.a(this.a), null));
        paramActionSheetItem = new saw(this);
        sab.a(this.a).a(paramActionSheetItem);
        paramActionSheetItem = new ReadInJoyDisLikeDialogView(sab.a(this.a));
        paramActionSheetItem.setOnUninterestConfirmListener(new sax(this, paramString, paramVideoInfo));
        paramActionSheetItem.setUninterestData(paramString.a);
        sab.a(this.a).a(paramActionSheetItem, null);
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        try
        {
          if (!sab.a(this.a).isShowing())
          {
            if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.isInFullScreenBlackList()))
            {
              sab.a(this.a).getWindow().setFlags(8, 8);
              sab.a(this.a).getWindow().getDecorView().setSystemUiVisibility(sab.a(this.a).getWindow().getDecorView().getSystemUiVisibility());
              sab.a(this.a).setOnShowListener(new say(this));
            }
            sab.a(this.a).show();
            odq.b(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, new sie(ofe.a(null, null, null, null, paramVideoInfo)).i(paramString.g).a().a(), false);
          }
          return;
        }
        catch (Exception paramVideoInfo)
        {
          sab.a(this.a, "dislikeSheet.show exception=" + paramVideoInfo);
          return;
        }
        paramString = paramString;
        paramString.printStackTrace();
      }
    }
    sab.a(this.a, "文章ID为：" + paramString.g + amtj.a(2131715256));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sav
 * JD-Core Version:    0.7.0.1
 */