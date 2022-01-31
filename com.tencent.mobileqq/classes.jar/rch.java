import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.SeekBar;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

public class rch
  implements qyz
{
  private int jdField_a_of_type_Int;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public rch(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void k(rfs paramrfs)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_b_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localObject = URLDrawable.getDrawable(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b, (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    if (this.jdField_a_of_type_Boolean) {
      rdm.a(this.jdField_a_of_type_ComTencentImageURLImageView, 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      l(paramrfs);
      this.jdField_a_of_type_Boolean = true;
      return;
      rdm.a(this.jdField_a_of_type_ComTencentImageURLImageView, 8, 0);
    }
  }
  
  private void l(rfs paramrfs)
  {
    if (paramrfs.jdField_a_of_type_AndroidViewView != null)
    {
      paramrfs.jdField_a_of_type_AndroidViewView.scrollTo(0, 0);
      int j = this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildCount();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatVideoUIDelegate", 2, "makeSureVideoLayoutState: isn't preplaying scroll " + paramrfs.jdField_a_of_type_AndroidViewView.hashCode() + " to 0,0");
      }
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildAt(i);
        if (localView != paramrfs.jdField_a_of_type_AndroidViewView)
        {
          localView.scrollTo(this.jdField_a_of_type_Int, 0);
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsFloatVideoUIDelegate", 2, "makeSureVideoLayoutState:  isn't preplaying scroll " + localView.hashCode() + " to " + this.jdField_a_of_type_Int + ",0");
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(Context paramContext, FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-14277082);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOutlineProvider(new bhvs(bdoo.a(3.0F)));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setClipToOutline(true);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new rci(this));
    this.jdField_a_of_type_AndroidWidgetSeekBar = new SeekBar(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, bdoo.a(1.0F));
    localLayoutParams.gravity = 80;
    this.jdField_a_of_type_AndroidWidgetSeekBar.setPadding(bdoo.a(1.5F), 0, bdoo.a(1.5F), 0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setThumb(new ColorDrawable());
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgressDrawable(paramContext.getResources().getDrawable(2130841401));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView = new View(paramContext);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-14277082);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, -1, -1);
    paramFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetSeekBar);
    paramFrameLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, -1, -1);
    paramFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(rfs paramrfs)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      rdm.a(this.jdField_a_of_type_ComTencentImageURLImageView, 8, 500);
    }
  }
  
  public void a(rfs paramrfs, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(rfs paramrfs, int paramInt, boolean paramBoolean)
  {
    if (paramInt > 300) {
      paramInt -= 300;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramrfs = new AlphaAnimation(0.0F, 1.0F);
      paramrfs.setDuration(300L);
      paramrfs.setStartOffset(paramInt);
      this.jdField_a_of_type_AndroidViewView.setAnimation(paramrfs);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new rcj(this));
      paramrfs.setAnimationListener(new rck(this, localAlphaAnimation));
      paramrfs.start();
      return;
      paramInt = 0;
    }
  }
  
  public void a(rfs paramrfs, long paramLong1, long paramLong2)
  {
    int i = 100;
    if (paramLong2 == 0L) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    }
    while (paramLong1 == 0L) {
      return;
    }
    int j = (int)((float)paramLong1 * 100.0F / (float)paramLong2 + 0.5D);
    if (j + 1 >= 100) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
      return;
      i = j + 1;
    }
  }
  
  public void a(rfs paramrfs, boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {
      k(paramrfs);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean a(rfs paramrfs)
  {
    return false;
  }
  
  public void b(rfs paramrfs)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      rdm.a(this.jdField_a_of_type_ComTencentImageURLImageView, 8, 500);
    }
  }
  
  public void b(rfs paramrfs, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(rfs paramrfs)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      rdm.a(this.jdField_a_of_type_ComTencentImageURLImageView, 0, 0);
    }
  }
  
  public void d(rfs paramrfs) {}
  
  public void e(rfs paramrfs)
  {
    k(paramrfs);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void f(rfs paramrfs) {}
  
  public void g(rfs paramrfs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatVideoUIDelegate", 2, "onVideoViewAttached: new videoView=" + paramrfs.jdField_a_of_type_AndroidViewView.hashCode());
    }
    if (paramrfs.jdField_a_of_type_Boolean)
    {
      paramrfs.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_Int, 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatVideoUIDelegate", 2, "onVideoViewAttached: preplaying scroll " + paramrfs.jdField_a_of_type_AndroidViewView.hashCode() + " to " + this.jdField_a_of_type_Int + ",0");
      }
      return;
    }
    l(paramrfs);
  }
  
  public void h(rfs paramrfs) {}
  
  public void i(rfs paramrfs) {}
  
  public void j(rfs paramrfs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rch
 * JD-Core Version:    0.7.0.1
 */