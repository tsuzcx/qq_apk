package dov.com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.image.VideoDrawable.OnPlayerOneFrameListener;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;

public class ImageViewVideoPlayer
  extends LinearLayout
  implements URLDrawableDownListener, VideoDrawable.OnPlayRepeatListener, VideoDrawable.OnPlayerOneFrameListener
{
  private static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-14342358);
  public int a;
  public Bitmap a;
  public BitmapDrawable a;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable = null;
  public URLImageView a;
  public VideoDrawable a;
  public ImageViewVideoPlayer.IMPFrameListener a;
  public ImageViewVideoPlayer.IMPlayerEndListener a;
  private PlayerProgressBar jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar;
  private String jdField_a_of_type_JavaLangString = null;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = null;
  public boolean b;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e = true;
  private boolean f = false;
  
  public ImageViewVideoPlayer(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentImageVideoDrawable = null;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$IMPlayerEndListener = null;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$IMPFrameListener = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    this.jdField_b_of_type_Boolean = true;
    a(paramContext);
  }
  
  public ImageViewVideoPlayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentImageVideoDrawable = null;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$IMPlayerEndListener = null;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$IMPFrameListener = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    this.jdField_b_of_type_Boolean = true;
    a(paramContext);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {}
    try
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localDrawable != null) && ((localDrawable instanceof VideoDrawable)))
      {
        this.jdField_a_of_type_ComTencentImageVideoDrawable = ((VideoDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
        boolean bool2 = this.jdField_a_of_type_ComTencentImageVideoDrawable.isAudioPlaying();
        if ((!CameraCompatibleList.d(CameraCompatibleList.c)) && (!CameraCompatibleList.a(CameraCompatibleList.d))) {
          break label141;
        }
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.i("ImageViewVideoPlayer", 2, "initPlayer: audioPlaying= " + bool2 + " black=" + bool1);
        }
        if (bool1) {
          this.jdField_a_of_type_ComTencentImageVideoDrawable.disableGlobalPause();
        }
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ImageViewVideoPlayer", 2, "checkAndGetVideoDrawable mUrlDrawable==null", localNullPointerException);
        }
        Object localObject = null;
        continue;
        label141:
        boolean bool1 = false;
      }
    }
  }
  
  private void a(Context paramContext)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    super.addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar = new PlayerProgressBar(paramContext);
    super.addView(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar, localLayoutParams);
    super.setVisibility(8);
    this.jdField_a_of_type_Int = 1;
  }
  
  private void f()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidGraphicsBitmap = a();
      c();
      e();
      getHandler().postAtFrontOfQueue(new ImageViewVideoPlayer.3(this));
    }
  }
  
  public int a(String paramString)
  {
    int i = -1;
    if (paramString == null) {
      i = -4;
    }
    File localFile;
    do
    {
      do
      {
        return i;
        localFile = new File(paramString);
        if ((localFile.exists()) && (localFile.isDirectory())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), videoDir not exist");
      return -1;
      paramString = localFile.list();
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), files = null");
    return -1;
    String str = localFile.getAbsolutePath() + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), sourceDirFile =" + localFile.getAbsolutePath() + ",files = " + Arrays.toString(paramString) + ",filse count = " + localFile.listFiles().length);
    }
    int j = paramString.length;
    i = 0;
    while (i < j)
    {
      localFile = paramString[i];
      if (QLog.isColorLevel()) {
        QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), current file = " + localFile);
      }
      if (localFile.endsWith(".af")) {
        this.jdField_b_of_type_JavaLangString = (str + localFile);
      }
      if ((localFile.endsWith(".vf")) && (FileUtils.a(str + localFile) > 0L)) {
        this.jdField_a_of_type_JavaLangString = (str + localFile);
      }
      i += 1;
    }
    if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString))) {
      return -3;
    }
    if ((this.jdField_b_of_type_JavaLangString == null) || ("".equals(this.jdField_b_of_type_JavaLangString))) {
      return -2;
    }
    this.f = false;
    if (FileUtils.a(this.jdField_b_of_type_JavaLangString) > 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), mNeedPlayAudio = " + this.f);
      }
      this.f = true;
    }
    return 0;
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null) {
      return this.jdField_a_of_type_ComTencentImageVideoDrawable.getCurrentBitmap();
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean, int paramInt3)
  {
    int i = (int)(paramInt1 * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.i("ImageViewVideoPlayer", 2, "updateUISize width" + paramInt1 + "height" + i + "screenHeight=" + paramInt2);
    }
    if (i < paramInt2) {}
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
      this.e = paramBoolean;
      if (this.e)
      {
        localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt3);
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.setLayoutParams(localLayoutParams);
        return;
      }
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.setVisibility(8);
      return;
      paramInt2 = i;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaLangString = paramString3;
    return a(paramInt1, paramInt2, paramInt3, paramString1, false);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Boolean) && (a(paramString) != 0)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentImageVideoDrawable = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_Int = (paramInt3 - 3);
    if (this.e)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.jdField_c_of_type_Int = paramInt3;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.setCurrentProgress(0, false);
    }
    paramString = URLDrawable.URLDrawableOptions.obtain();
    paramString.mFailedDrawable = null;
    paramString.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
      paramString.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
    }
    VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
    localVideoDrawableParams.mVideoRoundCorner = 0;
    localVideoDrawableParams.mRequestedFPS = -1;
    localVideoDrawableParams.mEnableAntiAlias = true;
    localVideoDrawableParams.mEnableFilter = true;
    localVideoDrawableParams.mPlayAudioFrame = this.f;
    localVideoDrawableParams.mPlayVideoFrame = true;
    localVideoDrawableParams.mDecodeType = 1;
    localVideoDrawableParams.mAfPath = this.jdField_b_of_type_JavaLangString;
    localVideoDrawableParams.mVfPath = this.jdField_a_of_type_JavaLangString;
    localVideoDrawableParams.mTotalTime = paramInt2;
    localVideoDrawableParams.mVideoFrames = paramInt3;
    paramString.mExtraInfo = localVideoDrawableParams;
    if ((!this.d) || (!paramBoolean)) {
      paramString.mUseMemoryCache = false;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(new File(this.jdField_a_of_type_JavaLangString), paramString);
    this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
    a();
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayRepeatListener(this);
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayerOneFrameListener(this);
      if (!this.d) {
        this.jdField_a_of_type_ComTencentImageVideoDrawable.resetAndPlayAudioOnce();
      }
    }
    this.jdField_a_of_type_Int = 2;
    this.jdField_c_of_type_Boolean = false;
    return true;
  }
  
  public void b()
  {
    super.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
    this.jdField_a_of_type_Int = 3;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageVideoDrawable != null)) {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.stopAudio();
    }
    Handler localHandler = super.getHandler();
    if (localHandler != null) {
      localHandler.postAtFrontOfQueue(new ImageViewVideoPlayer.1(this));
    }
    this.jdField_a_of_type_Int = 4;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null) {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.resetPlay();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.enableGlobalPause();
      this.jdField_a_of_type_ComTencentImageVideoDrawable.removeOnPlayRepeatListener(this);
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayRepeatListener(null);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Int = 1;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    a();
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    a();
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    a();
    if (this.jdField_a_of_type_ComTencentImageVideoDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayRepeatListener(this);
      this.jdField_a_of_type_ComTencentImageVideoDrawable.setOnPlayerOneFrameListener(this);
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentImageVideoDrawable.disableRequireAudioFocus();
      }
    }
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ImageViewVideoPlayer", 2, "onPlayRepeat: repeatTimes= " + paramInt);
    }
    if (!this.d)
    {
      if (this.e) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.setCurrentProgress(this.jdField_c_of_type_Int, true);
      }
      f();
      return;
    }
    this.jdField_c_of_type_Int = 0;
    getHandler().postAtFrontOfQueue(new ImageViewVideoPlayer.2(this, paramInt));
  }
  
  public void oneFrameDrawed()
  {
    this.jdField_c_of_type_Int += 1;
    if (this.jdField_c_of_type_Int >= this.jdField_b_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.e) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetPlayerProgressBar.setCurrentProgress(this.jdField_c_of_type_Int, bool);
      }
      if ((bool) && (!this.d)) {
        f();
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$IMPFrameListener != null) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$IMPFrameListener.a(this.jdField_c_of_type_Int);
      }
      return;
    }
  }
  
  public void setCyclePlay(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setIMPFrameListener(ImageViewVideoPlayer.IMPFrameListener paramIMPFrameListener)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$IMPFrameListener = paramIMPFrameListener;
  }
  
  public void setIMPlayerEndListener(ImageViewVideoPlayer.IMPlayerEndListener paramIMPlayerEndListener)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer$IMPlayerEndListener = paramIMPlayerEndListener;
  }
  
  public void setNeedPlayAudio(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer
 * JD-Core Version:    0.7.0.1
 */