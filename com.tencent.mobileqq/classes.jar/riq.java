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

public class riq
  implements DialogInterface.OnShowListener, View.OnClickListener, xqs
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private rir jdField_a_of_type_Rir;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public riq(Activity paramActivity, View paramView, rir paramrir, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Rir = paramrir;
  }
  
  private void a(VideoInfo paramVideoInfo, ViewGroup paramViewGroup, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(paramVideoInfo, paramViewGroup, paramImageView1, paramTextView, paramImageView2, paramBoolean1))
    {
      if ((paramBoolean2) && (paramViewGroup.getVisibility() == 0)) {
        rdm.a(paramViewGroup, 200);
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
    ron localron = new ron(paramVideoInfo);
    if ((paramVideoInfo.a != null) && (!TextUtils.isEmpty(paramVideoInfo.a.d))) {
      localron.a(paramVideoInfo.a.d);
    }
    for (;;)
    {
      localron.h(paramVideoInfo.g).v(this.jdField_b_of_type_Int).w(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("key_source", 0)).g(paramBoolean);
      nrt.b(null, "", paramString, paramString, 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", localron.a().a(), false);
      return;
      localron.a(paramVideoInfo.y);
    }
  }
  
  private void a(rbt paramrbt)
  {
    if ((paramrbt instanceof rbs))
    {
      paramrbt = (rbs)paramrbt;
      if (paramrbt.i != null) {
        paramrbt.i.setVisibility(8);
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
        i = aekt.a(i, this.jdField_a_of_type_AndroidAppActivity.getResources());
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
          paramViewGroup.mRequestWidth = bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 23.0F);
          paramViewGroup.mRequestHeight = bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 23.0F);
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
    if (this.jdField_a_of_type_Rir != null)
    {
      paramDialogInterface = this.jdField_a_of_type_Rir;
      if (paramInt != 0) {
        bool = true;
      }
      paramDialogInterface.a(bool);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, rbt paramrbt, boolean paramBoolean)
  {
    ImageView localImageView = null;
    if ((paramVideoInfo == null) || (paramrbt == null) || (paramVideoInfo.a == null)) {
      a(paramrbt);
    }
    label228:
    for (;;)
    {
      return;
      Object localObject;
      ViewGroup localViewGroup;
      TextView localTextView;
      if ((paramrbt instanceof rbs))
      {
        localObject = (rbs)paramrbt;
        if (((rbs)localObject).i == null)
        {
          ((rbs)localObject).i = ((ViewGroup)((ViewStub)((rbs)localObject).p.findViewById(2131379650)).inflate());
          ((rbs)localObject).b = ((ImageView)((rbs)localObject).i.findViewById(2131379630));
          ((rbs)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((rbs)localObject).i.findViewById(2131379631));
          ((rbs)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((rbs)localObject).i.findViewById(2131379645));
        }
        localViewGroup = ((rbs)paramrbt).i;
        localObject = ((rbs)paramrbt).jdField_a_of_type_AndroidWidgetImageView;
        localTextView = ((rbs)paramrbt).jdField_a_of_type_AndroidWidgetTextView;
        localImageView = ((rbs)paramrbt).b;
      }
      for (paramrbt = localViewGroup;; paramrbt = null)
      {
        if ((paramrbt == null) || (localObject == null) || (localTextView == null)) {
          break label228;
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localImageView.getDrawable();
        }
        paramrbt.setOnClickListener(this);
        if (paramrbt.getVisibility() == 0) {
          break;
        }
        a(paramVideoInfo, paramrbt, (ImageView)localObject, localTextView, localImageView, true, paramBoolean);
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
    VideoInfo localVideoInfo = this.jdField_a_of_type_Rir.a(paramView);
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
        rdm.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
      }
    }
    a(localVideoInfo, "0X800924E", false);
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Rir != null) {
      this.jdField_a_of_type_Rir.g();
    }
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     riq
 * JD-Core Version:    0.7.0.1
 */