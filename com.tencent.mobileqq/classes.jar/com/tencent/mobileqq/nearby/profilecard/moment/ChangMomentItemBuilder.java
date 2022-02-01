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
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561386, paramViewGroup, false);
    paramMomentViewHolder.g = ((TextView)paramViewGroup.findViewById(2131380639));
    paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369628));
    paramMomentViewHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131369750));
    paramMomentViewHolder.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131366796);
    paramMomentViewHolder.jdField_f_of_type_AndroidViewView = paramViewGroup.findViewById(2131366797);
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
    label69:
    int j;
    if (((ChangMomentFeedInfo)localObject1).c > 1)
    {
      paramMomentViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
      paramMomentViewHolder.jdField_f_of_type_AndroidViewView.setVisibility(0);
      paramMomentViewHolder.g.setMovementMethod(LinkMovementMethod.getInstance());
      if (!TextUtils.isEmpty(((ChangMomentFeedInfo)localObject1).n)) {
        break label307;
      }
      paramMomentViewHolder.g.setVisibility(8);
      j = UIUtils.a(this.a, 200.0F);
      if ((((ChangMomentFeedInfo)localObject1).jdField_a_of_type_Int <= 0) || (((ChangMomentFeedInfo)localObject1).jdField_b_of_type_Int <= 0)) {
        break label414;
      }
    }
    label414:
    for (int i = ((ChangMomentFeedInfo)localObject1).jdField_b_of_type_Int * j / ((ChangMomentFeedInfo)localObject1).jdField_a_of_type_Int;; i = j)
    {
      if (i * 3 > j * 4) {
        i = j * 4 / 3;
      }
      for (;;)
      {
        for (;;)
        {
          Object localObject2;
          if (!TextUtils.equals((String)paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.getTag(2131378926), ((ChangMomentFeedInfo)localObject1).jdField_b_of_type_JavaLangString))
          {
            paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setTag(2131378926, ((ChangMomentFeedInfo)localObject1).jdField_b_of_type_JavaLangString);
            localObject2 = (FrameLayout.LayoutParams)paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
            if (localObject2 != null) {
              break label330;
            }
            localObject2 = new FrameLayout.LayoutParams(j, i);
            paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          try
          {
            for (;;)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845777);
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845777);
              localObject1 = URLDrawable.getDrawable(((ChangMomentFeedInfo)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
              ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.b(j, i, DisplayUtil.a(this.a, 3.0F)));
              ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.e);
              paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              return;
              paramMomentViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
              paramMomentViewHolder.jdField_f_of_type_AndroidViewView.setVisibility(8);
              break;
              label307:
              paramMomentViewHolder.g.setVisibility(0);
              paramMomentViewHolder.g.setText(((ChangMomentFeedInfo)localObject1).n);
              break label69;
              label330:
              if ((((FrameLayout.LayoutParams)localObject2).width != j) || (((FrameLayout.LayoutParams)localObject2).height != i))
              {
                ((FrameLayout.LayoutParams)localObject2).width = j;
                ((FrameLayout.LayoutParams)localObject2).height = i;
                paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          catch (Exception localException)
          {
            do
            {
              paramMomentViewHolder.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(this.a.getResources().getDrawable(2130845777));
            } while (!QLog.isColorLevel());
            QLog.i("BaseMomentItemBuilder", 1, localException.toString());
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.ChangMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */