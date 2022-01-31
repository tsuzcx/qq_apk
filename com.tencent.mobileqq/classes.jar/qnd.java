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

public class qnd
  implements qjs
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
  
  public qnd(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void k(qql paramqql)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_b_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localObject = URLDrawable.getDrawable(paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b, (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    if (this.jdField_a_of_type_Boolean) {
      qoi.a(this.jdField_a_of_type_ComTencentImageURLImageView, 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      l(paramqql);
      this.jdField_a_of_type_Boolean = true;
      return;
      qoi.a(this.jdField_a_of_type_ComTencentImageURLImageView, 8, 0);
    }
  }
  
  private void l(qql paramqql)
  {
    if (paramqql.jdField_a_of_type_AndroidViewView != null)
    {
      paramqql.jdField_a_of_type_AndroidViewView.scrollTo(0, 0);
      int j = this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildCount();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatVideoUIDelegate", 2, "makeSureVideoLayoutState: isn't preplaying scroll " + paramqql.jdField_a_of_type_AndroidViewView.hashCode() + " to 0,0");
      }
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildAt(i);
        if (localView != paramqql.jdField_a_of_type_AndroidViewView)
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
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOutlineProvider(new bfqp(bbll.a(3.0F)));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setClipToOutline(true);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new qne(this));
    this.jdField_a_of_type_AndroidWidgetSeekBar = new SeekBar(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, bbll.a(1.0F));
    localLayoutParams.gravity = 80;
    this.jdField_a_of_type_AndroidWidgetSeekBar.setPadding(bbll.a(1.5F), 0, bbll.a(1.5F), 0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setThumb(new ColorDrawable());
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgressDrawable(paramContext.getResources().getDrawable(2130841280));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView = new View(paramContext);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-14277082);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, -1, -1);
    paramFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetSeekBar);
    paramFrameLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, -1, -1);
    paramFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(qql paramqql)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      qoi.a(this.jdField_a_of_type_ComTencentImageURLImageView, 8, 500);
    }
  }
  
  public void a(qql paramqql, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qql paramqql, int paramInt, boolean paramBoolean)
  {
    if (paramInt > 300) {
      paramInt -= 300;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramqql = new AlphaAnimation(0.0F, 1.0F);
      paramqql.setDuration(300L);
      paramqql.setStartOffset(paramInt);
      this.jdField_a_of_type_AndroidViewView.setAnimation(paramqql);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new qnf(this));
      paramqql.setAnimationListener(new qng(this, localAlphaAnimation));
      paramqql.start();
      return;
      paramInt = 0;
    }
  }
  
  public void a(qql paramqql, long paramLong1, long paramLong2)
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
  
  public void a(qql paramqql, boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {
      k(paramqql);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean a(qql paramqql)
  {
    return false;
  }
  
  public void b(qql paramqql)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      qoi.a(this.jdField_a_of_type_ComTencentImageURLImageView, 8, 500);
    }
  }
  
  public void b(qql paramqql, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(qql paramqql)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      qoi.a(this.jdField_a_of_type_ComTencentImageURLImageView, 0, 0);
    }
  }
  
  public void d(qql paramqql) {}
  
  public void e(qql paramqql)
  {
    k(paramqql);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void f(qql paramqql) {}
  
  public void g(qql paramqql)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatVideoUIDelegate", 2, "onVideoViewAttached: new videoView=" + paramqql.jdField_a_of_type_AndroidViewView.hashCode());
    }
    if (paramqql.jdField_a_of_type_Boolean)
    {
      paramqql.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_Int, 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatVideoUIDelegate", 2, "onVideoViewAttached: preplaying scroll " + paramqql.jdField_a_of_type_AndroidViewView.hashCode() + " to " + this.jdField_a_of_type_Int + ",0");
      }
      return;
    }
    l(paramqql);
  }
  
  public void h(qql paramqql) {}
  
  public void i(qql paramqql) {}
  
  public void j(qql paramqql) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qnd
 * JD-Core Version:    0.7.0.1
 */