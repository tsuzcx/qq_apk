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

public class qbi
  implements pxw
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
  
  public qbi(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void k(qeq paramqeq)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_b_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localObject = URLDrawable.getDrawable(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b, (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    if (this.jdField_a_of_type_Boolean) {
      qcn.b(this.jdField_a_of_type_ComTencentImageURLImageView, 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      l(paramqeq);
      this.jdField_a_of_type_Boolean = true;
      return;
      qcn.b(this.jdField_a_of_type_ComTencentImageURLImageView, 8, 0);
    }
  }
  
  private void l(qeq paramqeq)
  {
    if (paramqeq.jdField_a_of_type_AndroidViewView != null)
    {
      paramqeq.jdField_a_of_type_AndroidViewView.scrollTo(0, 0);
      int j = this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildCount();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatVideoUIDelegate", 2, "makeSureVideoLayoutState: isn't preplaying scroll " + paramqeq.jdField_a_of_type_AndroidViewView.hashCode() + " to 0,0");
      }
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildAt(i);
        if (localView != paramqeq.jdField_a_of_type_AndroidViewView)
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
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOutlineProvider(new beie(bajq.a(3.0F)));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setClipToOutline(true);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new qbj(this));
    this.jdField_a_of_type_AndroidWidgetSeekBar = new SeekBar(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, bajq.a(1.0F));
    localLayoutParams.gravity = 80;
    this.jdField_a_of_type_AndroidWidgetSeekBar.setPadding(bajq.a(1.5F), 0, bajq.a(1.5F), 0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setThumb(new ColorDrawable());
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgressDrawable(paramContext.getResources().getDrawable(2130841204));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView = new View(paramContext);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-14277082);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, -1, -1);
    paramFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetSeekBar);
    paramFrameLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, -1, -1);
    paramFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(qeq paramqeq)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      qcn.b(this.jdField_a_of_type_ComTencentImageURLImageView, 8, 500);
    }
  }
  
  public void a(qeq paramqeq, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qeq paramqeq, int paramInt, boolean paramBoolean)
  {
    if (paramInt > 300) {
      paramInt -= 300;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramqeq = new AlphaAnimation(0.0F, 1.0F);
      paramqeq.setDuration(300L);
      paramqeq.setStartOffset(paramInt);
      this.jdField_a_of_type_AndroidViewView.setAnimation(paramqeq);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new qbk(this));
      paramqeq.setAnimationListener(new qbl(this, localAlphaAnimation));
      paramqeq.start();
      return;
      paramInt = 0;
    }
  }
  
  public void a(qeq paramqeq, long paramLong1, long paramLong2)
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
  
  public void a(qeq paramqeq, boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {
      k(paramqeq);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean a(qeq paramqeq)
  {
    return false;
  }
  
  public void b(qeq paramqeq)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      qcn.b(this.jdField_a_of_type_ComTencentImageURLImageView, 8, 500);
    }
  }
  
  public void b(qeq paramqeq, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(qeq paramqeq)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      qcn.b(this.jdField_a_of_type_ComTencentImageURLImageView, 0, 0);
    }
  }
  
  public void d(qeq paramqeq) {}
  
  public void e(qeq paramqeq)
  {
    k(paramqeq);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void f(qeq paramqeq) {}
  
  public void g(qeq paramqeq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatVideoUIDelegate", 2, "onVideoViewAttached: new videoView=" + paramqeq.jdField_a_of_type_AndroidViewView.hashCode());
    }
    if (paramqeq.jdField_a_of_type_Boolean)
    {
      paramqeq.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_Int, 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatVideoUIDelegate", 2, "onVideoViewAttached: preplaying scroll " + paramqeq.jdField_a_of_type_AndroidViewView.hashCode() + " to " + this.jdField_a_of_type_Int + ",0");
      }
      return;
    }
    l(paramqeq);
  }
  
  public void h(qeq paramqeq) {}
  
  public void i(qeq paramqeq) {}
  
  public void j(qeq paramqeq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbi
 * JD-Core Version:    0.7.0.1
 */