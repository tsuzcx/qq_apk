import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyCapsuleView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

class rop
  implements URLDrawable.URLDrawableListener, rot
{
  private static ror jdField_a_of_type_Ror = new ror(null);
  private ChannelCoverInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  private ReadInJoyCapsuleView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private boolean jdField_a_of_type_Boolean;
  
  rop(ReadInJoyCapsuleView paramReadInJoyCapsuleView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView = paramReadInJoyCapsuleView;
  }
  
  private void a(boolean paramBoolean)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = roj.a();
    localURLDrawableOptions.mFailedDrawable = roj.a();
    localURLDrawableOptions.mPlayGifImage = paramBoolean;
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(new URL(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.externalExposureBackgroundUrl), localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setBackgroundSrc(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      QLog.e("ReadInJoyFeedsHeaderVie", 2, "fail to set background", localMalformedURLException);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setTextColor(Color.parseColor("#777777"));
    int i = roj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId, false);
    if (i != 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setDrawableLeft(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.getContext().getResources().getDrawable(i));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setBackgroundSrc(new ColorDrawable(Color.parseColor("#F1F3F6")));
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = true;
    a(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setColorFilter(roj.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setTextColor(-1);
    int i = roj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId, true);
    if (i != 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setDrawableLeft(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.getContext().getResources().getDrawable(i));
    }
  }
  
  private void e()
  {
    a(true);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) {
        onLoadSuccessed(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
    }
  }
  
  public ChannelCoverInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  }
  
  public void a()
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "onPlayOnce: pause the animation - " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverName);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localDrawable instanceof GifDrawable))
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable.setIndividualPause(true);
        ((GifDrawable)localDrawable).getImage().reset();
        this.jdField_a_of_type_ComTencentImageURLDrawable.setGIFPlayOnceListener(null);
        a(false);
        QLog.d("ReadInJoyFeedsHeaderVie", 2, "reset gif");
      }
    }
  }
  
  void a(ChannelCoverInfo paramChannelCoverInfo, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo = paramChannelCoverInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setOnClickListener(new roq(this, paramOnClickListener));
    if ((TextUtils.isEmpty(paramChannelCoverInfo.externalExposureBackgroundUrl)) || (bhvy.c(paramChannelCoverInfo.mChannelCoverId)))
    {
      c();
      return;
    }
    e();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    jdField_a_of_type_Ror.a();
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "onLoadCanceled: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.externalExposureBackgroundUrl);
    c();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "onLoadFialed: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.externalExposureBackgroundUrl);
    c();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "onLoadSuccessed: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverName);
    d();
    AbstractGifImage.resumeAll();
    jdField_a_of_type_Ror.a(this, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rop
 * JD-Core Version:    0.7.0.1
 */