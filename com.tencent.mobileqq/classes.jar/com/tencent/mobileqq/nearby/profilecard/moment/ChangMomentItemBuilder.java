package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ChangMomentFeedInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class ChangMomentItemBuilder
  extends BaseMomentItemBuilder
{
  public ChangMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return 3;
  }
  
  public View a(ViewGroup paramViewGroup, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (ChangMomentItemBuilder.ChangViewHolder)paramMomentViewHolder;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561225, paramViewGroup, false);
    paramMomentViewHolder.g = ((TextView)paramViewGroup.findViewById(2131379920));
    paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369331));
    paramMomentViewHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369441));
    paramMomentViewHolder.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131366660);
    paramMomentViewHolder.jdField_f_of_type_AndroidViewView = paramViewGroup.findViewById(2131366661);
    return paramViewGroup;
  }
  
  public BaseMomentItemBuilder.MomentViewHolder a()
  {
    return new ChangMomentItemBuilder.ChangViewHolder(this);
  }
  
  public String b(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return ((ChangMomentFeedInfo)((ChangMomentItemBuilder.ChangViewHolder)paramMomentViewHolder).a).jdField_a_of_type_JavaLangString;
  }
  
  public void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (ChangMomentItemBuilder.ChangViewHolder)paramMomentViewHolder;
    Object localObject1 = (ChangMomentFeedInfo)paramMomentViewHolder.a;
    if (((ChangMomentFeedInfo)localObject1).c > 1)
    {
      paramMomentViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramMomentViewHolder.jdField_f_of_type_AndroidViewView.setVisibility(0);
    }
    else
    {
      paramMomentViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
      paramMomentViewHolder.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
    paramMomentViewHolder.g.setMovementMethod(LinkMovementMethod.getInstance());
    if (TextUtils.isEmpty(((ChangMomentFeedInfo)localObject1).n))
    {
      paramMomentViewHolder.g.setVisibility(8);
    }
    else
    {
      paramMomentViewHolder.g.setVisibility(0);
      paramMomentViewHolder.g.setText(((ChangMomentFeedInfo)localObject1).n);
    }
    int k = UIUtils.a(this.a, 200.0F);
    int i;
    if ((((ChangMomentFeedInfo)localObject1).jdField_a_of_type_Int > 0) && (((ChangMomentFeedInfo)localObject1).jdField_b_of_type_Int > 0)) {
      i = ((ChangMomentFeedInfo)localObject1).jdField_b_of_type_Int * k / ((ChangMomentFeedInfo)localObject1).jdField_a_of_type_Int;
    } else {
      i = k;
    }
    int m = k * 4;
    int j = i;
    if (i * 3 > m) {
      j = m / 3;
    }
    if (!TextUtils.equals((String)paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.getTag(2131378314), ((ChangMomentFeedInfo)localObject1).jdField_b_of_type_JavaLangString))
    {
      paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setTag(2131378314, ((ChangMomentFeedInfo)localObject1).jdField_b_of_type_JavaLangString);
      Object localObject2 = (FrameLayout.LayoutParams)paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localObject2 == null)
      {
        localObject2 = new FrameLayout.LayoutParams(k, j);
        paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      else if ((((FrameLayout.LayoutParams)localObject2).width != k) || (((FrameLayout.LayoutParams)localObject2).height != j))
      {
        ((FrameLayout.LayoutParams)localObject2).width = k;
        ((FrameLayout.LayoutParams)localObject2).height = j;
        paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      try
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845650);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845650);
        localObject1 = URLDrawable.getDrawable(((ChangMomentFeedInfo)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.b(k, j, DisplayUtil.a(this.a, 3.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.d);
        paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        return;
      }
      catch (Exception localException)
      {
        paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130845650));
        if (QLog.isColorLevel()) {
          QLog.i("BaseMomentItemBuilder", 1, localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.ChangMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */