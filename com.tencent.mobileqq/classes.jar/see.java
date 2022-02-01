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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class see
  implements DialogInterface.OnShowListener, View.OnClickListener, zom
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private sef jdField_a_of_type_Sef;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public see(Activity paramActivity, View paramView, sef paramsef, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Sef = paramsef;
  }
  
  private void a(VideoInfo paramVideoInfo, ViewGroup paramViewGroup, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(paramVideoInfo, paramViewGroup, paramImageView1, paramTextView, paramImageView2, paramBoolean1))
    {
      if ((paramBoolean2) && (paramViewGroup.getVisibility() == 0)) {
        ryx.a(paramViewGroup, 200);
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
    skc localskc = new skc(paramVideoInfo);
    if ((paramVideoInfo.a != null) && (!TextUtils.isEmpty(paramVideoInfo.a.d))) {
      localskc.a(paramVideoInfo.a.d);
    }
    for (;;)
    {
      localskc.h(paramVideoInfo.g).v(this.jdField_b_of_type_Int).w(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0)).g(paramBoolean);
      oat.b(null, "", paramString, paramString, 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", localskc.a().a(), false);
      return;
      localskc.a(paramVideoInfo.B);
    }
  }
  
  private void a(rxy paramrxy)
  {
    if ((paramrxy instanceof rxv))
    {
      paramrxy = (rxv)paramrxy;
      if (paramrxy.j != null) {
        paramrxy.j.setVisibility(8);
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
        i = afur.a(i, this.jdField_a_of_type_AndroidAppActivity.getResources());
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
          paramViewGroup.mRequestWidth = bggq.a(this.jdField_a_of_type_AndroidAppActivity, 23.0F);
          paramViewGroup.mRequestHeight = bggq.a(this.jdField_a_of_type_AndroidAppActivity, 23.0F);
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
    if (this.jdField_a_of_type_Sef != null)
    {
      paramDialogInterface = this.jdField_a_of_type_Sef;
      if (paramInt != 0) {
        bool = true;
      }
      paramDialogInterface.a(bool);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, rxy paramrxy, boolean paramBoolean)
  {
    ImageView localImageView = null;
    if ((paramVideoInfo == null) || (paramrxy == null) || (paramVideoInfo.a == null)) {
      a(paramrxy);
    }
    label228:
    for (;;)
    {
      return;
      Object localObject;
      ViewGroup localViewGroup;
      TextView localTextView;
      if ((paramrxy instanceof rxv))
      {
        localObject = (rxv)paramrxy;
        if (((rxv)localObject).j == null)
        {
          ((rxv)localObject).j = ((ViewGroup)((ViewStub)((rxv)localObject).r.findViewById(2131380670)).inflate());
          ((rxv)localObject).d = ((ImageView)((rxv)localObject).j.findViewById(2131380638));
          ((rxv)localObject).c = ((ImageView)((rxv)localObject).j.findViewById(2131380639));
          ((rxv)localObject).a = ((TextView)((rxv)localObject).j.findViewById(2131380660));
        }
        localViewGroup = ((rxv)paramrxy).j;
        localObject = ((rxv)paramrxy).c;
        localTextView = ((rxv)paramrxy).a;
        localImageView = ((rxv)paramrxy).d;
      }
      for (paramrxy = localViewGroup;; paramrxy = null)
      {
        if ((paramrxy == null) || (localObject == null) || (localTextView == null)) {
          break label228;
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localImageView.getDrawable();
        }
        paramrxy.setOnClickListener(this);
        if (paramrxy.getVisibility() == 0) {
          break;
        }
        a(paramVideoInfo, paramrxy, (ImageView)localObject, localTextView, localImageView, true, paramBoolean);
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
    VideoInfo localVideoInfo = this.jdField_a_of_type_Sef.a(paramView);
    if (localVideoInfo == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label97;
        }
        a(localVideoInfo, "0x800929E", true);
        break;
        if ((localVideoInfo.a != null) && (localVideoInfo.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null)) {
          ryx.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
        }
      }
      label97:
      a(localVideoInfo, "0X800924E", false);
    }
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Sef != null) {
      this.jdField_a_of_type_Sef.g();
    }
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     see
 * JD-Core Version:    0.7.0.1
 */