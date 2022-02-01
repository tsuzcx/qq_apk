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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.TopicHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ShortVideoMomentItemBuilder
  extends PublishableMomentItemBuilder
{
  public ShortVideoMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return 1;
  }
  
  public View a(ViewGroup paramViewGroup, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (ShortVideoMomentItemBuilder.ShortVideoViewHolder)paramMomentViewHolder;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561386, paramViewGroup, false);
    paramMomentViewHolder.g = ((TextView)paramViewGroup.findViewById(2131380639));
    paramMomentViewHolder.e = ((ImageView)paramViewGroup.findViewById(2131369628));
    paramMomentViewHolder.f = ((ImageView)paramViewGroup.findViewById(2131369750));
    return paramViewGroup;
  }
  
  public BaseMomentItemBuilder.MomentViewHolder a()
  {
    return new ShortVideoMomentItemBuilder.ShortVideoViewHolder(this);
  }
  
  public String a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    long l = ((ShortVideoMomentFeedInfo)((ShortVideoMomentItemBuilder.ShortVideoViewHolder)paramMomentViewHolder).a).jdField_b_of_type_Long;
    if (l % 1000L > 500L) {}
    for (l = (int)l / 1000 + 1;; l = (int)l / 1000) {
      return String.valueOf(l);
    }
  }
  
  public void d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    ShortVideoMomentFeedInfo localShortVideoMomentFeedInfo = (ShortVideoMomentFeedInfo)paramMomentViewHolder.a;
    if ((localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      NearbyMomentUtils.a(this.a, localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 2);
      return;
    }
    super.d(paramMomentViewHolder);
  }
  
  public void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    ShortVideoMomentItemBuilder.ShortVideoViewHolder localShortVideoViewHolder = (ShortVideoMomentItemBuilder.ShortVideoViewHolder)paramMomentViewHolder;
    ShortVideoMomentFeedInfo localShortVideoMomentFeedInfo = (ShortVideoMomentFeedInfo)localShortVideoViewHolder.a;
    paramMomentViewHolder = TopicHelper.a(this.a, localShortVideoViewHolder.a.a, localShortVideoMomentFeedInfo.n);
    int j;
    String str;
    File localFile;
    boolean bool;
    if (TextUtils.isEmpty(paramMomentViewHolder))
    {
      localShortVideoViewHolder.g.setVisibility(8);
      j = UIUtils.a(this.a, 180.0F);
      str = (String)localShortVideoViewHolder.e.getTag(2131378926);
      if (localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label544;
      }
      localFile = new File(localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
      bool = localFile.exists();
    }
    for (;;)
    {
      Object localObject;
      int i;
      if (bool)
      {
        localObject = localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
        if (localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth <= 0) {
          break label539;
        }
        paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
        if (localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight <= 0) {
          break label539;
        }
        i = localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight * j / localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
        paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
      }
      for (;;)
      {
        label195:
        if (i * 3 > j * 4) {
          i = j * 4 / 3;
        }
        for (;;)
        {
          if (!TextUtils.equals(str, paramMomentViewHolder))
          {
            localShortVideoViewHolder.e.setTag(2131378926, paramMomentViewHolder);
            localObject = (FrameLayout.LayoutParams)localShortVideoViewHolder.e.getLayoutParams();
            if (localObject != null) {
              break label444;
            }
            localObject = new FrameLayout.LayoutParams(j, i);
            localShortVideoViewHolder.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getResources().getDrawable(2130845777);
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130845777);
              if (!bool) {
                continue;
              }
              paramMomentViewHolder = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
              paramMomentViewHolder.setTag(URLDrawableDecodeHandler.b(j, i, DisplayUtil.a(this.a, 3.0F)));
              paramMomentViewHolder.setDecodeHandler(URLDrawableDecodeHandler.e);
              localShortVideoViewHolder.e.setImageDrawable(paramMomentViewHolder);
              return;
            }
            catch (Exception paramMomentViewHolder)
            {
              label444:
              localShortVideoViewHolder.e.setImageDrawable(this.a.getResources().getDrawable(2130845777));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ShortVideoMomentItemBuilder", 1, paramMomentViewHolder.toString());
              return;
            }
            localShortVideoViewHolder.g.setVisibility(0);
            if ((paramMomentViewHolder instanceof SpannableString)) {
              localShortVideoViewHolder.g.setMovementMethod(LinkMovementMethod.getInstance());
            }
            localShortVideoViewHolder.g.setText(paramMomentViewHolder);
            break;
            localObject = localShortVideoMomentFeedInfo.jdField_a_of_type_JavaLangString;
            paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
            if (localShortVideoMomentFeedInfo.jdField_a_of_type_Int <= 0) {
              break label539;
            }
            paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
            if (localShortVideoMomentFeedInfo.jdField_b_of_type_Int <= 0) {
              break label539;
            }
            i = localShortVideoMomentFeedInfo.jdField_b_of_type_Int * j / localShortVideoMomentFeedInfo.jdField_a_of_type_Int;
            paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
            break label195;
            if ((((FrameLayout.LayoutParams)localObject).width != j) || (((FrameLayout.LayoutParams)localObject).height != i))
            {
              ((FrameLayout.LayoutParams)localObject).width = j;
              ((FrameLayout.LayoutParams)localObject).height = i;
              localShortVideoViewHolder.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
              continue;
              paramMomentViewHolder = URLDrawable.getDrawable(paramMomentViewHolder, (URLDrawable.URLDrawableOptions)localObject);
            }
          }
        }
        label539:
        i = j;
      }
      label544:
      bool = false;
      localFile = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.ShortVideoMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */