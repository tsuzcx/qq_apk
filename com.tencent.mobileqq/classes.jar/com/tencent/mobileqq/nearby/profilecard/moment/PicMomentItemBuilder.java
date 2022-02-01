package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PicMomentFeedInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.TopicHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PicMomentItemBuilder
  extends PublishableMomentItemBuilder
{
  public PicMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return 2;
  }
  
  public View a(ViewGroup paramViewGroup, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (PicMomentItemBuilder.PicViewHolder)paramMomentViewHolder;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561224, paramViewGroup, false);
    paramMomentViewHolder.g = ((TextView)paramViewGroup.findViewById(2131379920));
    paramMomentViewHolder.e = ((ImageView)paramViewGroup.findViewById(2131369437));
    return paramViewGroup;
  }
  
  public BaseMomentItemBuilder.MomentViewHolder a()
  {
    return new PicMomentItemBuilder.PicViewHolder(this);
  }
  
  public void d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    PicMomentFeedInfo localPicMomentFeedInfo = (PicMomentFeedInfo)paramMomentViewHolder.a;
    if ((localPicMomentFeedInfo.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry != null) && (localPicMomentFeedInfo.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.publishState != 0))
    {
      NearbyMomentUtils.a(this.a, localPicMomentFeedInfo.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry, 4);
      return;
    }
    super.d(paramMomentViewHolder);
  }
  
  public void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    PicMomentItemBuilder.PicViewHolder localPicViewHolder = (PicMomentItemBuilder.PicViewHolder)paramMomentViewHolder;
    Object localObject1 = (PicMomentFeedInfo)localPicViewHolder.a;
    paramMomentViewHolder = ((PicMomentFeedInfo)localObject1).n;
    paramMomentViewHolder = TopicHelper.a(this.a, localPicViewHolder.a.a, paramMomentViewHolder);
    if (TextUtils.isEmpty(paramMomentViewHolder))
    {
      localPicViewHolder.g.setVisibility(8);
    }
    else
    {
      localPicViewHolder.g.setVisibility(0);
      if ((paramMomentViewHolder instanceof SpannableString)) {
        localPicViewHolder.g.setMovementMethod(LinkMovementMethod.getInstance());
      }
      localPicViewHolder.g.setText(paramMomentViewHolder);
    }
    Object localObject2 = (String)localPicViewHolder.e.getTag(2131378314);
    paramMomentViewHolder = null;
    boolean bool;
    if (((PicMomentFeedInfo)localObject1).jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry != null)
    {
      paramMomentViewHolder = new StringBuilder();
      paramMomentViewHolder.append(((PicMomentFeedInfo)localObject1).jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.thumbPath);
      paramMomentViewHolder.append("");
      paramMomentViewHolder = new File(paramMomentViewHolder.toString());
      bool = paramMomentViewHolder.exists();
    }
    else
    {
      bool = false;
    }
    if (bool) {
      localObject1 = ((PicMomentFeedInfo)localObject1).jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.thumbPath;
    } else {
      localObject1 = ((PicMomentFeedInfo)localObject1).jdField_a_of_type_JavaLangString;
    }
    if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
    {
      localPicViewHolder.e.setTag(2131378314, localObject1);
      localObject2 = (LinearLayout.LayoutParams)localPicViewHolder.e.getLayoutParams();
      int i = UIUtils.a(BaseApplicationImpl.getContext(), 180.0F);
      if (localObject2 == null)
      {
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        localPicViewHolder.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      else if ((((LinearLayout.LayoutParams)localObject2).width <= i) && (((LinearLayout.LayoutParams)localObject2).height <= i))
      {
        if (((LinearLayout.LayoutParams)localObject2).weight < ((LinearLayout.LayoutParams)localObject2).height) {
          ((LinearLayout.LayoutParams)localObject2).height = i;
        } else {
          ((LinearLayout.LayoutParams)localObject2).width = i;
        }
        localPicViewHolder.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      try
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845650);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845650);
        ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "profileCard";
        if (bool) {
          paramMomentViewHolder = URLDrawable.getDrawable(paramMomentViewHolder, (URLDrawable.URLDrawableOptions)localObject2);
        } else {
          paramMomentViewHolder = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        }
        paramMomentViewHolder.setTag(URLDrawableDecodeHandler.a(DisplayUtil.a(localPicViewHolder.e.getContext(), 3.0F), 0, 0));
        paramMomentViewHolder.setDecodeHandler(URLDrawableDecodeHandler.e);
        localPicViewHolder.e.setImageDrawable(paramMomentViewHolder);
      }
      catch (Exception paramMomentViewHolder)
      {
        localPicViewHolder.e.setImageDrawable(this.a.getResources().getDrawable(2130845650));
        QLog.i("PicMomentItemBuilder", 1, paramMomentViewHolder.toString());
      }
    }
    localPicViewHolder.e.setTag(localPicViewHolder);
    localPicViewHolder.e.setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.PicMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */