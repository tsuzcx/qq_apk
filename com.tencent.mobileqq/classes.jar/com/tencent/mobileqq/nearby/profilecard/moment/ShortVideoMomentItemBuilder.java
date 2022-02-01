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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
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
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561225, paramViewGroup, false);
    paramMomentViewHolder.g = ((TextView)paramViewGroup.findViewById(2131379920));
    paramMomentViewHolder.e = ((ImageView)paramViewGroup.findViewById(2131369331));
    paramMomentViewHolder.f = ((ImageView)paramViewGroup.findViewById(2131369441));
    return paramViewGroup;
  }
  
  public BaseMomentItemBuilder.MomentViewHolder a()
  {
    return new ShortVideoMomentItemBuilder.ShortVideoViewHolder(this);
  }
  
  public String a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    long l = ((ShortVideoMomentFeedInfo)((ShortVideoMomentItemBuilder.ShortVideoViewHolder)paramMomentViewHolder).a).jdField_b_of_type_Long;
    int i;
    if (l % 1000L > 500L) {
      i = (int)l / 1000 + 1;
    } else {
      i = (int)l / 1000;
    }
    return String.valueOf(i);
  }
  
  public void d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    ShortVideoMomentFeedInfo localShortVideoMomentFeedInfo = (ShortVideoMomentFeedInfo)paramMomentViewHolder.a;
    if ((localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry != null) && (localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.publishState != 0))
    {
      NearbyMomentUtils.a(this.a, localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry, 2);
      return;
    }
    super.d(paramMomentViewHolder);
  }
  
  public void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    ShortVideoMomentItemBuilder.ShortVideoViewHolder localShortVideoViewHolder = (ShortVideoMomentItemBuilder.ShortVideoViewHolder)paramMomentViewHolder;
    ShortVideoMomentFeedInfo localShortVideoMomentFeedInfo = (ShortVideoMomentFeedInfo)localShortVideoViewHolder.a;
    paramMomentViewHolder = TopicHelper.a(this.a, localShortVideoViewHolder.a.a, localShortVideoMomentFeedInfo.n);
    boolean bool2 = TextUtils.isEmpty(paramMomentViewHolder);
    boolean bool1 = false;
    if (bool2)
    {
      localShortVideoViewHolder.g.setVisibility(8);
    }
    else
    {
      localShortVideoViewHolder.g.setVisibility(0);
      if ((paramMomentViewHolder instanceof SpannableString)) {
        localShortVideoViewHolder.g.setMovementMethod(LinkMovementMethod.getInstance());
      }
      localShortVideoViewHolder.g.setText(paramMomentViewHolder);
    }
    int k = UIUtils.a(this.a, 180.0F);
    String str = (String)localShortVideoViewHolder.e.getTag(2131378314);
    File localFile = null;
    if (localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry != null)
    {
      paramMomentViewHolder = new StringBuilder();
      paramMomentViewHolder.append(localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.thumbPath);
      paramMomentViewHolder.append("");
      localFile = new File(paramMomentViewHolder.toString());
      bool1 = localFile.exists();
    }
    Object localObject;
    if (bool1)
    {
      localObject = localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.thumbPath;
      paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
      if (localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoWidth > 0)
      {
        paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
        if (localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoHeight > 0)
        {
          i = localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoHeight * k / localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoWidth;
          paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
          break label308;
        }
      }
    }
    else
    {
      localObject = localShortVideoMomentFeedInfo.jdField_a_of_type_JavaLangString;
      paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
      if (localShortVideoMomentFeedInfo.jdField_a_of_type_Int > 0)
      {
        paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
        if (localShortVideoMomentFeedInfo.jdField_b_of_type_Int > 0)
        {
          i = localShortVideoMomentFeedInfo.jdField_b_of_type_Int * k / localShortVideoMomentFeedInfo.jdField_a_of_type_Int;
          paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
          break label308;
        }
      }
    }
    int i = k;
    label308:
    int m = k * 4;
    int j = i;
    if (i * 3 > m) {
      j = m / 3;
    }
    if (!TextUtils.equals(str, paramMomentViewHolder))
    {
      localShortVideoViewHolder.e.setTag(2131378314, paramMomentViewHolder);
      localObject = (FrameLayout.LayoutParams)localShortVideoViewHolder.e.getLayoutParams();
      if (localObject == null)
      {
        localObject = new FrameLayout.LayoutParams(k, j);
        localShortVideoViewHolder.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      else if ((((FrameLayout.LayoutParams)localObject).width != k) || (((FrameLayout.LayoutParams)localObject).height != j))
      {
        ((FrameLayout.LayoutParams)localObject).width = k;
        ((FrameLayout.LayoutParams)localObject).height = j;
        localShortVideoViewHolder.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      try
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getResources().getDrawable(2130845650);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130845650);
        if (bool1) {
          paramMomentViewHolder = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
        } else {
          paramMomentViewHolder = URLDrawable.getDrawable(paramMomentViewHolder, (URLDrawable.URLDrawableOptions)localObject);
        }
        paramMomentViewHolder.setTag(URLDrawableDecodeHandler.b(k, j, DisplayUtil.a(this.a, 3.0F)));
        paramMomentViewHolder.setDecodeHandler(URLDrawableDecodeHandler.d);
        localShortVideoViewHolder.e.setImageDrawable(paramMomentViewHolder);
        return;
      }
      catch (Exception paramMomentViewHolder)
      {
        localShortVideoViewHolder.e.setImageDrawable(this.a.getResources().getDrawable(2130845650));
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoMomentItemBuilder", 1, paramMomentViewHolder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.ShortVideoMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */