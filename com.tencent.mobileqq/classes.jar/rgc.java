import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.HashSet;

public class rgc
  extends pen
{
  private rgc(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
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
        break label204;
      }
      paramString1.a.add(paramString2);
      if (!paramString1.d) {
        new ArrayList(paramString1.a);
      }
    }
    label103:
    if (paramString1.e)
    {
      paramString2 = new QQToast(this.a.getActivity().getApplicationContext());
      paramString2.d(2000);
      if (!paramBoolean) {
        break label212;
      }
      paramString2.a(QQToast.a(2));
      paramString2.c(2131692402);
      paramString2.b(this.a.getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131298914) - (int)bdgz.a(this.a.getActivity().getApplicationContext(), 5.0F));
    }
    for (;;)
    {
      paramString1.e = false;
      return;
      label204:
      if (paramInt != 2) {
        break label103;
      }
      break label103;
      break;
      label212:
      paramString2.a(QQToast.a(1));
      paramString2.c(2131692403);
      paramString2.b(this.a.getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131298914) - (int)bdgz.a(this.a.getActivity().getApplicationContext(), 5.0F));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rgc
 * JD-Core Version:    0.7.0.1
 */