package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
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
    View localView3 = paramView;
    if (paramView == null) {
      localView3 = LayoutInflater.from(this.a.jdField_a_of_type_AndroidContentContext).inflate(2131560724, null);
    }
    TroopFeedViewFactory.NormalViewProvider.ViewHolder localViewHolder = (TroopFeedViewFactory.NormalViewProvider.ViewHolder)localView3.getTag();
    if (localViewHolder == null)
    {
      localViewHolder = new TroopFeedViewFactory.NormalViewProvider.ViewHolder(this);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView3.findViewById(2131373117));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView3.findViewById(2131379432));
      localViewHolder.b = ((TextView)localView3.findViewById(2131365294));
      localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView3.findViewById(2131361822));
      localView3.setOnClickListener(this.a);
      localView3.setTag(localViewHolder);
    }
    for (;;)
    {
      localViewHolder.jdField_a_of_type_Int = paramInt;
      localViewHolder.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localViewHolder.b.setVisibility(0);
      localViewHolder.b.setSingleLine(false);
      localViewHolder.b.setMaxLines(2);
      localViewHolder.b.setText("");
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      String str = HardCodeUtil.a(2131715169) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title;
      if (paramTroopFeedItem.type == 5)
      {
        if (this.a.b == null) {
          this.a.b = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843872);
        }
        paramView = this.a.b;
        if (StringUtil.a(paramTroopFeedItem.picPath)) {
          break label1164;
        }
      }
      for (;;)
      {
        try
        {
          paramInt = AIOUtils.a(61.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
          URLDrawable localURLDrawable = URLDrawable.getDrawable(paramTroopFeedItem.picPath, paramInt, paramInt, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          Object localObject;
          if (!paramTroopFeedItem.isStoryType())
          {
            localObject = str;
            if (paramTroopFeedItem.type != 5)
            {
              localObject = str;
              if (paramTroopFeedItem.type != 19)
              {
                localObject = str;
                if (paramTroopFeedItem.type == 99) {}
              }
            }
          }
          else
          {
            paramView = str;
            if (!StringUtil.a(paramTroopFeedItem.publishUin))
            {
              paramView = str + " " + paramTroopFeedItem.publishUin;
              ((TextView)localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372288)).setText(paramTroopFeedItem.publishUin);
            }
            localObject = paramView;
            if (!StringUtil.a(paramTroopFeedItem.feedTime))
            {
              try
              {
                localObject = HardCodeUtil.a(2131715172) + TroopFeedParserHelper.a(Long.parseLong(paramTroopFeedItem.feedTime));
                ((TextView)localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131361821)).setText((CharSequence)localObject);
                localObject = paramView + (String)localObject;
                paramInt = 1;
                if (paramInt != 0)
                {
                  localViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                  localViewHolder.b.setVisibility(8);
                }
                if (paramTroopFeedItem.type != 131) {
                  continue;
                }
                localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(FileManagerUtil.b(paramTroopFeedItem.title));
                paramView = (View)localObject;
                paramTroopFeedItem = paramView;
                if (!paramBoolean) {
                  paramTroopFeedItem = paramView + " " + HardCodeUtil.a(2131715173);
                }
                localView3.setContentDescription(paramTroopFeedItem);
                return localView3;
              }
              catch (NumberFormatException localNumberFormatException)
              {
                localView2 = paramView;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("TroopFeedViewFactory", 2, "item.feedTime:" + paramTroopFeedItem.feedTime);
                localView2 = paramView;
              }
              if (paramTroopFeedItem.type == 132)
              {
                if (this.a.c == null) {
                  this.a.c = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843874);
                }
                paramView = this.a.c;
                break;
              }
              if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843872);
              }
              paramView = this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localView1 = paramView;
          continue;
          View localView2;
          paramInt = 0;
          continue;
          if ((paramTroopFeedItem.type == 5) || (paramTroopFeedItem.type == 19))
          {
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            localViewHolder.b.setText(paramTroopFeedItem.content);
            localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
            paramView = localView2 + " " + paramTroopFeedItem.content;
            continue;
          }
          if ((paramTroopFeedItem.type == 133) || (paramTroopFeedItem.type == 18) || (paramTroopFeedItem.type == 0))
          {
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
            paramView = localView2;
            continue;
          }
          if (paramTroopFeedItem.type == 12)
          {
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843877);
            paramView = localView2;
            continue;
          }
          if ((paramTroopFeedItem.type == 10) || (paramTroopFeedItem.type == 132))
          {
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localView1);
            localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843876);
            paramView = localView2;
            continue;
          }
          paramView = localView2;
          if (paramTroopFeedItem.orginType != 99) {
            continue;
          }
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localView1);
          localViewHolder.b.setText(paramTroopFeedItem.content);
          if (!paramTroopFeedItem.tag.equals(HardCodeUtil.a(2131715166)))
          {
            localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
            localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
          }
          paramView = localView2 + " " + paramTroopFeedItem.content;
          continue;
        }
        label1164:
        View localView1 = paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.NormalViewProvider
 * JD-Core Version:    0.7.0.1
 */