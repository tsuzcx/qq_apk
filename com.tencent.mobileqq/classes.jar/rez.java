import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.LikeAnimationInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import mqq.app.AppRuntime;

public class rez
{
  private static int jdField_a_of_type_Int;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LikeAnimationInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoLikeAnimationInfo;
  private Random jdField_a_of_type_JavaUtilRandom;
  private rey jdField_a_of_type_Rey;
  private rfa jdField_a_of_type_Rfa;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private URLDrawable[] jdField_a_of_type_ArrayOfComTencentImageURLDrawable;
  
  public rez(Activity paramActivity, int paramInt)
  {
    if ((paramActivity == null) || (paramActivity.getWindow() == null) || (paramActivity.getWindow().getDecorView() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsLikeAnimateManager", 2, "activity in a invalid state");
      }
    }
    label236:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramActivity.getWindow().getDecorView().findViewById(16908290));
          } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
          this.jdField_a_of_type_ArrayOfInt = new int[2];
          jdField_a_of_type_Int = aepi.a(28.0F, paramActivity.getResources());
          this.jdField_a_of_type_AndroidViewViewGroup.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
          this.jdField_a_of_type_JavaUtilRandom = new Random();
          paramActivity = a();
          if (paramActivity != null)
          {
            this.jdField_a_of_type_Rey = ((rey)paramActivity.a(138));
            this.jdField_a_of_type_Rfa = new rfa(this);
            paramActivity.addObserver(this.jdField_a_of_type_Rfa);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoLikeAnimationInfo = bkbq.a();
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoLikeAnimationInfo == null) {
            break label236;
          }
          if ((this.jdField_a_of_type_Rey == null) || (!bkbq.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoLikeAnimationInfo.jdField_a_of_type_Int))) {
            break;
          }
          this.jdField_a_of_type_Rey.a(paramInt);
          bkbq.a(System.currentTimeMillis());
        } while (!QLog.isColorLevel());
        QLog.d("VideoFeedsLikeAnimateManager", 2, "fetch icon list");
        return;
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoLikeAnimationInfo);
      } while (!QLog.isColorLevel());
      QLog.d("VideoFeedsLikeAnimateManager", 2, "use local icon list");
      return;
    } while (this.jdField_a_of_type_Rey == null);
    this.jdField_a_of_type_Rey.a(paramInt);
    bkbq.a(System.currentTimeMillis());
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = ors.a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(LikeAnimationInfo paramLikeAnimationInfo)
  {
    if ((paramLikeAnimationInfo == null) || (paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString == null) || (paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString.length == 0)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable = null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = jdField_a_of_type_Int;
    localURLDrawableOptions.mRequestHeight = jdField_a_of_type_Int;
    this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable = new URLDrawable[paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString.length];
    int i = 0;
    while (i < paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      String str = paramLikeAnimationInfo.jdField_a_of_type_ArrayOfJavaLangString[i];
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(new URL(str), localURLDrawableOptions);
        localURLDrawable.startDownload();
        this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable[i] = localURLDrawable;
        i += 1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsLikeAnimateManager", 2, "illegal url format: " + str);
          }
        }
      }
    }
  }
  
  private boolean a()
  {
    boolean bool2;
    if ((this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable == null) || (this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable.length == 0))
    {
      bool2 = false;
      return bool2;
    }
    URLDrawable[] arrayOfURLDrawable = this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable;
    int m = arrayOfURLDrawable.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      URLDrawable localURLDrawable = arrayOfURLDrawable[i];
      k = j;
      if (localURLDrawable != null)
      {
        k = j;
        if (localURLDrawable.getStatus() == 1) {
          k = j + 1;
        }
      }
      i += 1;
    }
    if (j == this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable.length) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoFeedsLikeAnimateManager", 2, "isHit: " + bool1);
      return bool1;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 1;
    }
    return 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable = null;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Rfa);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsLikeAnimateManager", 2, "parent view is null");
      }
      return;
    }
    VideoFeedsLikeAnimate localVideoFeedsLikeAnimate = new VideoFeedsLikeAnimate(this.jdField_a_of_type_AndroidViewViewGroup, paramFloat1 - this.jdField_a_of_type_ArrayOfInt[0], paramFloat2 - this.jdField_a_of_type_ArrayOfInt[1], this.jdField_a_of_type_JavaUtilRandom);
    if (a()) {
      localVideoFeedsLikeAnimate.a(this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable, 4, jdField_a_of_type_Int);
    }
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      localVideoFeedsLikeAnimate.a();
      return;
      localVideoFeedsLikeAnimate.a(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rez
 * JD-Core Version:    0.7.0.1
 */