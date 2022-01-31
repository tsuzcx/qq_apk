import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareHelper;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

public class mjh
  extends ReadInJoyAtlasManager.AtlasCallbackImpl
{
  public mjh(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "handleDoFavoriteResult isSuccess = " + paramBoolean + ", operationType = " + paramInt + ", cid = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    while (!VideoShareHelper.a(this.a).contains(paramString1)) {
      return;
    }
    paramString2 = new QQToast(VideoShareHelper.a(this.a));
    paramString2.d(2000);
    if (paramBoolean)
    {
      paramString2.a(QQToast.a(2));
      paramString2.c(2131431583);
      paramString2.b(VideoShareHelper.a(this.a).getResources().getDimensionPixelSize(2131558448) - (int)DisplayUtils.a(VideoShareHelper.a(this.a), 5.0F));
    }
    for (;;)
    {
      VideoShareHelper.a(this.a).remove(paramString1);
      return;
      paramString2.a(QQToast.a(1));
      paramString2.c(2131431591);
      paramString2.b(VideoShareHelper.a(this.a).getResources().getDimensionPixelSize(2131558448) - (int)DisplayUtils.a(VideoShareHelper.a(this.a), 5.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mjh
 * JD-Core Version:    0.7.0.1
 */