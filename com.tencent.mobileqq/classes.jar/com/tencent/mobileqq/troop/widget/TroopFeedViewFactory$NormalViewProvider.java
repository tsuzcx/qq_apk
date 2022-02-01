package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.data.TroopFeedParserHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

class TroopFeedViewFactory$NormalViewProvider
  extends TroopFeedViewFactory.ViewProvider
{
  TroopFeedViewFactory$NormalViewProvider(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2131560612, null);
    } else {
      localView = paramView;
    }
    paramView = (TroopFeedViewFactory.NormalViewProvider.ViewHolder)localView.getTag();
    Object localObject2 = paramView;
    if (paramView == null)
    {
      localObject2 = new TroopFeedViewFactory.NormalViewProvider.ViewHolder(this);
      ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131372696));
      ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378784));
      ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).b = ((TextView)localView.findViewById(2131365169));
      ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131361828));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject2);
    }
    ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_Int = paramInt;
    ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
    ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
    paramView = new StringBuilder();
    paramView.append("[");
    paramView.append(paramTroopFeedItem.tag);
    paramView.append("] ");
    paramView.append(paramTroopFeedItem.title);
    paramView = paramView.toString();
    ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).b.setVisibility(0);
    ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).b.setSingleLine(false);
    ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).b.setMaxLines(2);
    ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).b.setText("");
    ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView = new StringBuilder();
    paramView.append(HardCodeUtil.a(2131715092));
    paramView.append(paramTroopFeedItem.tag);
    paramView.append(" ");
    paramView.append(paramTroopFeedItem.title);
    Object localObject4 = paramView.toString();
    if (paramTroopFeedItem.type == 5)
    {
      if (this.a.b == null)
      {
        paramView = this.a;
        paramView.b = paramView.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843792);
      }
      paramView = this.a.b;
    }
    else if (paramTroopFeedItem.type == 132)
    {
      if (this.a.c == null)
      {
        paramView = this.a;
        paramView.c = paramView.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843794);
      }
      paramView = this.a.c;
    }
    else
    {
      if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        paramView = this.a;
        paramView.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramView.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843792);
      }
      paramView = this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    Object localObject3 = paramView;
    if (!StringUtil.a(paramTroopFeedItem.picPath)) {}
    try
    {
      paramInt = AIOUtils.b(61.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
      localObject3 = URLDrawable.getDrawable(paramTroopFeedItem.picPath, paramInt, paramInt, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      Object localObject1;
      if (!paramTroopFeedItem.isStoryType())
      {
        localObject1 = localObject4;
        if (paramTroopFeedItem.type != 5)
        {
          localObject1 = localObject4;
          if (paramTroopFeedItem.type != 19)
          {
            localObject1 = localObject4;
            if (paramTroopFeedItem.type != 99) {
              break label587;
            }
          }
        }
      }
      for (;;)
      {
        paramInt = 0;
        break;
        label587:
        paramView = (View)localObject4;
        if (!StringUtil.a(paramTroopFeedItem.publishUin))
        {
          paramView = new StringBuilder();
          paramView.append((String)localObject4);
          paramView.append(" ");
          paramView.append(paramTroopFeedItem.publishUin);
          paramView = paramView.toString();
          ((TextView)((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371877)).setText(paramTroopFeedItem.publishUin);
        }
        localObject1 = paramView;
        if (!StringUtil.a(paramTroopFeedItem.feedTime)) {}
        try
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131715095));
          ((StringBuilder)localObject1).append(TroopFeedParserHelper.a(Long.parseLong(paramTroopFeedItem.feedTime)));
          localObject1 = ((StringBuilder)localObject1).toString();
          ((TextView)((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131361827)).setText((CharSequence)localObject1);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramView);
          ((StringBuilder)localObject4).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject4).toString();
          paramInt = 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label766:
          break label766;
        }
        localObject1 = paramView;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("item.feedTime:");
          ((StringBuilder)localObject1).append(paramTroopFeedItem.feedTime);
          QLog.e("TroopFeedViewFactory", 2, ((StringBuilder)localObject1).toString());
          localObject1 = paramView;
        }
      }
      if (paramInt != 0)
      {
        ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).b.setVisibility(8);
      }
      if (paramTroopFeedItem.type == 131)
      {
        ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageResource(FileManagerUtil.b(paramTroopFeedItem.title));
        paramView = (View)localObject1;
      }
      else if ((paramTroopFeedItem.type != 5) && (paramTroopFeedItem.type != 19))
      {
        if ((paramTroopFeedItem.type != 133) && (paramTroopFeedItem.type != 18) && (paramTroopFeedItem.type != 0))
        {
          if (paramTroopFeedItem.type == 12)
          {
            ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843797);
            paramView = (View)localObject1;
          }
          else if ((paramTroopFeedItem.type != 10) && (paramTroopFeedItem.type != 132))
          {
            paramView = (View)localObject1;
            if (paramTroopFeedItem.orginType == 99)
            {
              ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
              ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).b.setText(paramTroopFeedItem.content);
              if (!paramTroopFeedItem.tag.equals(HardCodeUtil.a(2131715089)))
              {
                ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
                ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
              }
              paramView = new StringBuilder();
              paramView.append((String)localObject1);
              paramView.append(" ");
              paramView.append(paramTroopFeedItem.content);
              paramView = paramView.toString();
            }
          }
          else
          {
            ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
            ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject3);
            ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843796);
            paramView = (View)localObject1;
          }
        }
        else
        {
          ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          paramView = (View)localObject1;
        }
      }
      else
      {
        ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
        ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).b.setText(paramTroopFeedItem.content);
        ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
        ((TroopFeedViewFactory.NormalViewProvider.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
        paramView = new StringBuilder();
        paramView.append((String)localObject1);
        paramView.append(" ");
        paramView.append(paramTroopFeedItem.content);
        paramView = paramView.toString();
      }
      paramTroopFeedItem = paramView;
      if (!paramBoolean)
      {
        paramTroopFeedItem = new StringBuilder();
        paramTroopFeedItem.append(paramView);
        paramTroopFeedItem.append(" ");
        paramTroopFeedItem.append(HardCodeUtil.a(2131715096));
        paramTroopFeedItem = paramTroopFeedItem.toString();
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localObject3 = paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.NormalViewProvider
 * JD-Core Version:    0.7.0.1
 */