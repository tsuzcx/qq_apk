package com.tencent.mobileqq.lightReply;

import aebu;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.List;

public class LightReplyAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public List a;
  public List b;
  
  public LightReplyAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = new ArrayList();
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130841444, paramContext.getTheme());
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130841444);
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView.setTranslationY(800.0F);
    paramView.animate().translationY(0.0F).setStartDelay((this.b.size() - paramInt) * 50).setInterpolator(new DecelerateInterpolator(3.0F)).setDuration(400L).start();
    paramView.setAlpha(0.0F);
    paramView.animate().alpha(1.0F).setStartDelay((this.b.size() - paramInt) * 50).setInterpolator(new DecelerateInterpolator(1.0F)).setDuration(300L).start();
  }
  
  public LightReplyEmojs a(int paramInt)
  {
    if ((this.b != null) && (paramInt < this.b.size())) {
      return (LightReplyEmojs)this.b.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (LightReplyEmojs)this.b.get(paramInt);
    if (localObject == null) {
      return null;
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramViewGroup = new LightReplyAdapter.ViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ViewGroup.LayoutParams(AIOUtils.a(41.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(33.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView = new RelativeLayout.LayoutParams(AIOUtils.a(33.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(33.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setMargins(AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0, 0);
      paramView.addRule(13, -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, paramView);
      paramView = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyEmojs = ((LightReplyEmojs)this.b.get(paramInt));
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject = URLDrawable.getDrawable(((LightReplyEmojs)localObject).smallUrl, localURLDrawableOptions);
      if ((((URLDrawable)localObject).getStatus() != 1) && ((((URLDrawable)localObject).getStatus() == 2) || (((URLDrawable)localObject).getStatus() == 3))) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new aebu(this, paramViewGroup));
      a(paramView, paramInt);
      return paramView;
      paramViewGroup = (LightReplyAdapter.ViewHolder)paramView.getTag();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.lightReply.LightReplyAdapter
 * JD-Core Version:    0.7.0.1
 */