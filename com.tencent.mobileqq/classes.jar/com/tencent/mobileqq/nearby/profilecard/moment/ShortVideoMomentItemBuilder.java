package com.tencent.mobileqq.nearby.profilecard.moment;

import aeyu;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
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
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadListener;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PublishableMomentInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ShortVideoMomentItemBuilder
  extends PublishableMomentItemBuilder
{
  private static VideoFeedsUploader.UploadListener a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadListener = new aeyu();
  }
  
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
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970438, paramViewGroup, false);
    paramMomentViewHolder.j = ((TextView)paramViewGroup.findViewById(2131367080));
    paramMomentViewHolder.f = ((ImageView)paramViewGroup.findViewById(2131366351));
    paramMomentViewHolder.g = ((ImageView)paramViewGroup.findViewById(2131370699));
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
  
  public boolean c(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    ShortVideoMomentFeedInfo localShortVideoMomentFeedInfo = (ShortVideoMomentFeedInfo)paramMomentViewHolder.a;
    if ((localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0)) {
      return false;
    }
    return super.c(paramMomentViewHolder);
  }
  
  public void d(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    ShortVideoMomentFeedInfo localShortVideoMomentFeedInfo = (ShortVideoMomentFeedInfo)paramMomentViewHolder.a;
    if ((localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      NearbyMomentUtils.a(this.jdField_a_of_type_AndroidContentContext, localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 2);
      return;
    }
    super.d(paramMomentViewHolder);
  }
  
  public void e(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    super.e(paramMomentViewHolder);
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "当前网络不可用，请检查你的网络设置", 0).a();
      return;
    }
    paramMomentViewHolder.i.setVisibility(8);
    VideoFeedsUploader.a(((PublishableMomentInfo)paramMomentViewHolder.a).jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadListener);
  }
  
  public void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    ShortVideoMomentItemBuilder.ShortVideoViewHolder localShortVideoViewHolder = (ShortVideoMomentItemBuilder.ShortVideoViewHolder)paramMomentViewHolder;
    ShortVideoMomentFeedInfo localShortVideoMomentFeedInfo = (ShortVideoMomentFeedInfo)localShortVideoViewHolder.a;
    int j;
    String str;
    File localFile;
    boolean bool;
    if (TextUtils.isEmpty(localShortVideoMomentFeedInfo.i))
    {
      localShortVideoViewHolder.j.setVisibility(8);
      j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 200.0F);
      str = (String)localShortVideoViewHolder.f.getTag(2131362360);
      if (localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label513;
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
          break label508;
        }
        paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
        if (localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight <= 0) {
          break label508;
        }
        i = localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight * j / localShortVideoMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
        paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
      }
      for (;;)
      {
        label178:
        if (i * 3 > j * 4) {
          i = j * 4 / 3;
        }
        for (;;)
        {
          if (!TextUtils.equals(str, paramMomentViewHolder))
          {
            localShortVideoViewHolder.f.setTag(2131362360, paramMomentViewHolder);
            localObject = (FrameLayout.LayoutParams)localShortVideoViewHolder.f.getLayoutParams();
            if (localObject != null) {
              break label413;
            }
            localObject = new FrameLayout.LayoutParams(j, i);
            localShortVideoViewHolder.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842715);
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842715);
              if (!bool) {
                continue;
              }
              paramMomentViewHolder = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
              paramMomentViewHolder.setTag(URLDrawableDecodeHandler.a(j, i, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 3.0F)));
              paramMomentViewHolder.setDecodeHandler(URLDrawableDecodeHandler.d);
              localShortVideoViewHolder.f.setImageDrawable(paramMomentViewHolder);
              return;
            }
            catch (Exception paramMomentViewHolder)
            {
              label413:
              localShortVideoViewHolder.f.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842715));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ShortVideoMomentItemBuilder", 1, paramMomentViewHolder.toString());
              return;
            }
            localShortVideoViewHolder.j.setVisibility(0);
            localShortVideoViewHolder.j.setText(localShortVideoMomentFeedInfo.i);
            break;
            localObject = localShortVideoMomentFeedInfo.jdField_a_of_type_JavaLangString;
            paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
            if (localShortVideoMomentFeedInfo.jdField_a_of_type_Int <= 0) {
              break label508;
            }
            paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
            if (localShortVideoMomentFeedInfo.jdField_b_of_type_Int <= 0) {
              break label508;
            }
            i = localShortVideoMomentFeedInfo.jdField_b_of_type_Int * j / localShortVideoMomentFeedInfo.jdField_a_of_type_Int;
            paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
            break label178;
            if ((((FrameLayout.LayoutParams)localObject).width != j) || (((FrameLayout.LayoutParams)localObject).height != i))
            {
              ((FrameLayout.LayoutParams)localObject).width = j;
              ((FrameLayout.LayoutParams)localObject).height = i;
              localShortVideoViewHolder.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
              continue;
              paramMomentViewHolder = URLDrawable.getDrawable(paramMomentViewHolder, (URLDrawable.URLDrawableOptions)localObject);
            }
          }
        }
        label508:
        i = j;
      }
      label513:
      bool = false;
      localFile = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.ShortVideoMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */