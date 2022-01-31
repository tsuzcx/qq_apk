import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.HashSet;

public class qez
  extends ont
{
  private qez(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    VideoFeedsPlayActivity.a("handleDoFavoriteResult isSuccess = " + paramBoolean + ", operationType = " + paramInt + ", cid = " + paramString2);
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      paramString1 = VideoFeedsRecommendFragment.a(this.a).a(paramString1);
    } while (paramString1 == null);
    if (paramBoolean)
    {
      if (paramInt != 1) {
        break label235;
      }
      paramString1.a.add(paramString2);
      if (!paramString1.d)
      {
        paramString2 = new ArrayList(paramString1.a);
        onp.a().a(this.a.getActivity(), VideoFeedsRecommendFragment.a(this.a).c(), 2, paramString1.g, paramString2);
      }
    }
    label134:
    if (paramString1.e)
    {
      paramString2 = new bbmy(this.a.getActivity().getApplicationContext());
      paramString2.d(2000);
      if (!paramBoolean) {
        break label243;
      }
      paramString2.a(bbmy.a(2));
      paramString2.c(2131626723);
      paramString2.b(this.a.getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131167766) - (int)bacc.a(this.a.getActivity().getApplicationContext(), 5.0F));
    }
    for (;;)
    {
      paramString1.e = false;
      return;
      label235:
      if (paramInt != 2) {
        break label134;
      }
      break label134;
      break;
      label243:
      paramString2.a(bbmy.a(1));
      paramString2.c(2131626724);
      paramString2.b(this.a.getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131167766) - (int)bacc.a(this.a.getActivity().getApplicationContext(), 5.0F));
      paramString1.d = false;
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList<String> paramArrayList)
  {
    VideoFeedsPlayActivity.a("handleFavoriteStatus isSuccess = " + paramBoolean1 + ", rowkey = " + paramString + ", isFavorite = " + paramBoolean2);
    if ((!paramBoolean1) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramString = VideoFeedsRecommendFragment.a(this.a).a(paramString);
    } while (paramString == null);
    paramString.d = paramBoolean2;
    paramString.a.addAll(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qez
 * JD-Core Version:    0.7.0.1
 */