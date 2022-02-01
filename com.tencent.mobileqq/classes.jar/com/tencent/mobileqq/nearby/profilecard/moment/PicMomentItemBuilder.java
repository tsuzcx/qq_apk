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
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
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
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561385, paramViewGroup, false);
    paramMomentViewHolder.g = ((TextView)paramViewGroup.findViewById(2131380639));
    paramMomentViewHolder.e = ((ImageView)paramViewGroup.findViewById(2131369746));
    return paramViewGroup;
  }
  
  public BaseMomentItemBuilder.MomentViewHolder a()
  {
    return new PicMomentItemBuilder.PicViewHolder(this);
  }
  
  public void d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    PicMomentFeedInfo localPicMomentFeedInfo = (PicMomentFeedInfo)paramMomentViewHolder.a;
    if ((localPicMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localPicMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      NearbyMomentUtils.a(this.a, localPicMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 4);
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
    Object localObject2;
    if (TextUtils.isEmpty(paramMomentViewHolder))
    {
      localPicViewHolder.g.setVisibility(8);
      localObject2 = (String)localPicViewHolder.e.getTag(2131378926);
      if (((PicMomentFeedInfo)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label475;
      }
      paramMomentViewHolder = new File(((PicMomentFeedInfo)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
    }
    for (boolean bool = paramMomentViewHolder.exists();; bool = false)
    {
      label132:
      int i;
      if (bool)
      {
        localObject1 = ((PicMomentFeedInfo)localObject1).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
        {
          localPicViewHolder.e.setTag(2131378926, localObject1);
          localObject2 = (LinearLayout.LayoutParams)localPicViewHolder.e.getLayoutParams();
          i = UIUtils.a(BaseApplicationImpl.getContext(), 180.0F);
          if (localObject2 != null) {
            break label368;
          }
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          localPicViewHolder.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.a.getResources().getDrawable(2130845777);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.a.getResources().getDrawable(2130845777);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "profileCard";
          if (!bool) {
            continue;
          }
          paramMomentViewHolder = URLDrawable.getDrawable(paramMomentViewHolder, (URLDrawable.URLDrawableOptions)localObject2);
          paramMomentViewHolder.setTag(URLDrawableDecodeHandler.a(DisplayUtil.a(localPicViewHolder.e.getContext(), 3.0F), 0, 0));
          paramMomentViewHolder.setDecodeHandler(URLDrawableDecodeHandler.f);
          localPicViewHolder.e.setImageDrawable(paramMomentViewHolder);
        }
        catch (Exception paramMomentViewHolder)
        {
          label368:
          localPicViewHolder.e.setImageDrawable(this.a.getResources().getDrawable(2130845777));
          QLog.i("PicMomentItemBuilder", 1, paramMomentViewHolder.toString());
          continue;
        }
        localPicViewHolder.e.setTag(localPicViewHolder);
        localPicViewHolder.e.setOnClickListener(this);
        return;
        localPicViewHolder.g.setVisibility(0);
        if ((paramMomentViewHolder instanceof SpannableString)) {
          localPicViewHolder.g.setMovementMethod(LinkMovementMethod.getInstance());
        }
        localPicViewHolder.g.setText(paramMomentViewHolder);
        break;
        localObject1 = ((PicMomentFeedInfo)localObject1).jdField_a_of_type_JavaLangString;
        break label132;
        if ((((LinearLayout.LayoutParams)localObject2).width <= i) && (((LinearLayout.LayoutParams)localObject2).height <= i)) {
          if (((LinearLayout.LayoutParams)localObject2).weight < ((LinearLayout.LayoutParams)localObject2).height)
          {
            ((LinearLayout.LayoutParams)localObject2).height = i;
            localPicViewHolder.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          else
          {
            ((LinearLayout.LayoutParams)localObject2).width = i;
            continue;
            paramMomentViewHolder = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          }
        }
      }
      label475:
      paramMomentViewHolder = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.PicMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */