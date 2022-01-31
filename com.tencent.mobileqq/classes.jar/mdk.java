import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class mdk
  extends ReadInJoyAtlasManager.AtlasCallbackImpl
{
  public mdk(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "handleDoFavoriteResult isSuccess = " + paramBoolean + ", operationType = " + paramInt + ", cid = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    label177:
    label339:
    for (;;)
    {
      return;
      Iterator localIterator = VideoFeedsPlayActivity.a(this.a).iterator();
      VideoInfo localVideoInfo;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localVideoInfo = (VideoInfo)localIterator.next();
      } while (!paramString1.equals(localVideoInfo.g));
      for (paramString1 = localVideoInfo;; paramString1 = null)
      {
        if (paramString1 == null) {
          break label339;
        }
        if (paramBoolean)
        {
          if (paramInt != 1) {
            break label269;
          }
          paramString1.a.add(paramString2);
          if (!paramString1.d)
          {
            paramString2 = new ArrayList(paramString1.a);
            ReadInJoyAtlasManager.a().a(this.a, VideoFeedsPlayActivity.a(this.a).c(), 2, paramString1.g, paramString2);
          }
        }
        if (paramString1.e)
        {
          paramString2 = new QQToast(this.a.getApplicationContext());
          paramString2.d(2000);
          if (!paramBoolean) {
            break label277;
          }
          paramString2.a(QQToast.a(2));
          paramString2.c(2131431572);
          paramString2.b(this.a.getApplicationContext().getResources().getDimensionPixelSize(2131558448) - (int)DisplayUtils.a(this.a.getApplicationContext(), 5.0F));
        }
        for (;;)
        {
          paramString1.e = false;
          return;
          if (paramInt != 2) {
            break label177;
          }
          break label177;
          break;
          paramString2.a(QQToast.a(1));
          paramString2.c(2131431580);
          paramString2.b(this.a.getApplicationContext().getResources().getDimensionPixelSize(2131558448) - (int)DisplayUtils.a(this.a.getApplicationContext(), 5.0F));
          paramString1.d = false;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "handleFavoriteStatus isSuccess = " + paramBoolean1 + ", rowkey = " + paramString + ", isFavorite = " + paramBoolean2);
    }
    if ((!paramBoolean1) || (TextUtils.isEmpty(paramString))) {}
    VideoInfo localVideoInfo;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = VideoFeedsPlayActivity.a(this.a).iterator();
      }
      localVideoInfo = (VideoInfo)localIterator.next();
    } while (!paramString.equals(localVideoInfo.g));
    localVideoInfo.d = paramBoolean2;
    localVideoInfo.a.addAll(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdk
 * JD-Core Version:    0.7.0.1
 */