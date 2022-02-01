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

class scw
  extends skd
{
  scw(sce paramsce) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    sce.b(this.a, true);
    paramVideoInfo = new JSONObject();
    try
    {
      paramVideoInfo.put("channel_id", 409409);
      paramVideoInfo.put("source", 2);
      paramString = sce.a(this.a);
      if ((paramString.b != null) && (paramString.b.size() > 0))
      {
        sce.a(this.a, (bkho)bkif.a(sce.a(this.a), null));
        paramActionSheetItem = new scx(this);
        sce.a(this.a).a(paramActionSheetItem);
        paramActionSheetItem = new ReadInJoyDisLikeDialogView(sce.a(this.a));
        paramActionSheetItem.setOnUninterestConfirmListener(new scy(this, paramString, paramVideoInfo));
        paramActionSheetItem.setUninterestData(paramString.b);
        sce.a(this.a).a(paramActionSheetItem, null);
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        try
        {
          if (!sce.a(this.a).isShowing())
          {
            if ((VersionUtils.isJellyBean()) && (!ShortVideoUtils.c()))
            {
              sce.a(this.a).getWindow().setFlags(8, 8);
              sce.a(this.a).getWindow().getDecorView().setSystemUiVisibility(sce.a(this.a).getWindow().getDecorView().getSystemUiVisibility());
              sce.a(this.a).setOnShowListener(new scz(this));
            }
            sce.a(this.a).show();
            oat.b(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, new skc(och.a(null, null, null, null, paramVideoInfo)).h(paramString.g).a().a(), false);
          }
          return;
        }
        catch (Exception paramVideoInfo)
        {
          sce.a(this.a, "dislikeSheet.show exception=" + paramVideoInfo);
          return;
        }
        paramString = paramString;
        paramString.printStackTrace();
      }
    }
    sce.a(this.a, "文章ID为：" + paramString.g + anni.a(2131714913));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scw
 * JD-Core Version:    0.7.0.1
 */