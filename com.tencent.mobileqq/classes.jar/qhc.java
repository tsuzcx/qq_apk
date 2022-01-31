import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.TopBarInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class qhc
  implements DialogInterface.OnShowListener, View.OnClickListener, vph
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private qhd jdField_a_of_type_Qhd;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public qhc(Activity paramActivity, View paramView, qhd paramqhd, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Qhd = paramqhd;
  }
  
  private void a(VideoInfo paramVideoInfo, ViewGroup paramViewGroup, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(paramVideoInfo, paramViewGroup, paramImageView1, paramTextView, paramImageView2, paramBoolean1))
    {
      if ((paramBoolean2) && (paramViewGroup.getVisibility() == 0)) {
        qcn.a(paramViewGroup, 200);
      }
      if (this.jdField_a_of_type_Boolean) {
        a(paramVideoInfo, "0X800929D", true);
      }
    }
    else
    {
      return;
    }
    a(paramVideoInfo, "0X800924D", false);
  }
  
  private void a(VideoInfo paramVideoInfo, String paramString, boolean paramBoolean)
  {
    qmv localqmv = new qmv(paramVideoInfo);
    if ((paramVideoInfo.a != null) && (!TextUtils.isEmpty(paramVideoInfo.a.d))) {
      localqmv.a(paramVideoInfo.a.d);
    }
    for (;;)
    {
      localqmv.h(paramVideoInfo.g).v(this.jdField_b_of_type_Int).w(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0)).f(paramBoolean);
      ndn.b(null, "", paramString, paramString, 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", localqmv.a().a(), false);
      return;
      localqmv.a(paramVideoInfo.N);
    }
  }
  
  private void a(qaq paramqaq)
  {
    if ((paramqaq instanceof qap))
    {
      paramqaq = (qap)paramqaq;
      if (paramqaq.j != null) {
        paramqaq.j.setVisibility(8);
      }
    }
  }
  
  private boolean a(VideoInfo paramVideoInfo, ViewGroup paramViewGroup, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2, boolean paramBoolean)
  {
    paramVideoInfo = paramVideoInfo.a;
    int i;
    if ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.b)) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)))
    {
      paramTextView.setText(paramVideoInfo.b);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseAutoScaleParams = false;
      if (paramBoolean)
      {
        i = 12;
        i = aciy.a(i, this.jdField_a_of_type_AndroidAppActivity.getResources());
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = i;
        localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
        paramImageView1.setImageDrawable(URLDrawable.getDrawable(paramVideoInfo.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        paramViewGroup.setVisibility(0);
        if ((paramBoolean) && (!TextUtils.isEmpty(paramVideoInfo.c)))
        {
          paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
          paramViewGroup.mRequestWidth = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 23.0F);
          paramViewGroup.mRequestHeight = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 23.0F);
          paramImageView2.setImageDrawable(URLDrawable.getDrawable(paramVideoInfo.c, paramViewGroup));
        }
      }
      do
      {
        do
        {
          return bool;
          i = 18;
          break;
        } while (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null);
        paramImageView2.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return bool;
        paramViewGroup.setVisibility(8);
        paramTextView.setText("");
        paramImageView1.setImageDrawable(null);
      } while (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null);
      paramImageView2.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return bool;
    }
  }
  
  public void a(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Qhd != null)
    {
      paramDialogInterface = this.jdField_a_of_type_Qhd;
      if (paramInt != 0) {
        bool = true;
      }
      paramDialogInterface.a(bool);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, qaq paramqaq, boolean paramBoolean)
  {
    ImageView localImageView = null;
    if ((paramVideoInfo == null) || (paramqaq == null) || (paramVideoInfo.a == null)) {
      a(paramqaq);
    }
    label228:
    for (;;)
    {
      return;
      Object localObject;
      ViewGroup localViewGroup;
      TextView localTextView;
      if ((paramqaq instanceof qap))
      {
        localObject = (qap)paramqaq;
        if (((qap)localObject).j == null)
        {
          ((qap)localObject).j = ((ViewGroup)((ViewStub)((qap)localObject).q.findViewById(2131313153)).inflate());
          ((qap)localObject).b = ((ImageView)((qap)localObject).j.findViewById(2131313143));
          ((qap)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((qap)localObject).j.findViewById(2131313144));
          ((qap)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((qap)localObject).j.findViewById(2131313151));
        }
        localViewGroup = ((qap)paramqaq).j;
        localObject = ((qap)paramqaq).jdField_a_of_type_AndroidWidgetImageView;
        localTextView = ((qap)paramqaq).jdField_a_of_type_AndroidWidgetTextView;
        localImageView = ((qap)paramqaq).b;
      }
      for (paramqaq = localViewGroup;; paramqaq = null)
      {
        if ((paramqaq == null) || (localObject == null) || (localTextView == null)) {
          break label228;
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localImageView.getDrawable();
        }
        paramqaq.setOnClickListener(this);
        if (paramqaq.getVisibility() == 0) {
          break;
        }
        a(paramVideoInfo, paramqaq, (ImageView)localObject, localTextView, localImageView, true, paramBoolean);
        return;
        localTextView = null;
        localObject = null;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void onClick(View paramView)
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_Qhd.a(paramView);
    if (localVideoInfo == null) {
      return;
    }
    switch (paramView.getId())
    {
    }
    while (this.jdField_a_of_type_Boolean)
    {
      a(localVideoInfo, "0x800929E", true);
      return;
      if ((localVideoInfo.a != null) && (localVideoInfo.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null)) {
        qcn.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      }
    }
    a(localVideoInfo, "0X800924E", false);
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Qhd != null) {
      this.jdField_a_of_type_Qhd.g();
    }
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhc
 * JD-Core Version:    0.7.0.1
 */