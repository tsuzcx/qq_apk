package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
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
import com.tencent.mobileqq.nearby.profilecard.moment.data.PicMomentFeedInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
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
    paramViewGroup = LayoutInflater.from(this.a).inflate(2130970490, paramViewGroup, false);
    paramMomentViewHolder.i = ((TextView)paramViewGroup.findViewById(2131367129));
    paramMomentViewHolder.f = ((ImageView)paramViewGroup.findViewById(2131370825));
    return paramViewGroup;
  }
  
  public BaseMomentItemBuilder.MomentViewHolder a()
  {
    return new PicMomentItemBuilder.PicViewHolder(this);
  }
  
  public boolean a(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return false;
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
  
  public void e(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    PicMomentItemBuilder.PicViewHolder localPicViewHolder = (PicMomentItemBuilder.PicViewHolder)paramMomentViewHolder;
    PicMomentFeedInfo localPicMomentFeedInfo = (PicMomentFeedInfo)localPicViewHolder.a;
    paramMomentViewHolder = localPicMomentFeedInfo.i;
    int j;
    String str;
    File localFile;
    boolean bool;
    if (TextUtils.isEmpty(paramMomentViewHolder))
    {
      localPicViewHolder.i.setVisibility(8);
      j = UIUtils.a(BaseApplicationImpl.getContext(), 200.0F);
      str = (String)localPicViewHolder.f.getTag(2131362363);
      if (localPicMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label507;
      }
      localFile = new File(localPicMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
      bool = localFile.exists();
    }
    for (;;)
    {
      Object localObject;
      int i;
      if (bool)
      {
        localObject = localPicMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
        if (localPicMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth <= 0) {
          break label502;
        }
        paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
        if (localPicMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight <= 0) {
          break label502;
        }
        i = localPicMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight * j / localPicMomentFeedInfo.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
        paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
      }
      for (;;)
      {
        label414:
        for (;;)
        {
          label179:
          if (i * 3 > j * 4)
          {
            i = j * 4 / 3;
            if (!TextUtils.equals(str, paramMomentViewHolder))
            {
              localPicViewHolder.f.setTag(2131362363, paramMomentViewHolder);
              localObject = (LinearLayout.LayoutParams)localPicViewHolder.f.getLayoutParams();
              if (localObject != null) {
                break label414;
              }
              localObject = new LinearLayout.LayoutParams(j, i);
              localPicViewHolder.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            try
            {
              label253:
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getResources().getDrawable(2130842848);
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130842848);
              if (bool) {}
              for (paramMomentViewHolder = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);; paramMomentViewHolder = URLDrawable.getDrawable(paramMomentViewHolder, (URLDrawable.URLDrawableOptions)localObject))
              {
                paramMomentViewHolder.setTag(URLDrawableDecodeHandler.a(j, i, DisplayUtil.a(localPicViewHolder.f.getContext(), 3.0F)));
                paramMomentViewHolder.setDecodeHandler(URLDrawableDecodeHandler.d);
                localPicViewHolder.f.setImageDrawable(paramMomentViewHolder);
                return;
                localPicViewHolder.i.setVisibility(0);
                localPicViewHolder.i.setText(paramMomentViewHolder);
                break;
                localObject = localPicMomentFeedInfo.jdField_a_of_type_JavaLangString;
                paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
                if (localPicMomentFeedInfo.jdField_a_of_type_Int <= 0) {
                  break label502;
                }
                paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
                if (localPicMomentFeedInfo.b <= 0) {
                  break label502;
                }
                i = localPicMomentFeedInfo.b * j / localPicMomentFeedInfo.jdField_a_of_type_Int;
                paramMomentViewHolder = (BaseMomentItemBuilder.MomentViewHolder)localObject;
                break label179;
                if ((((LinearLayout.LayoutParams)localObject).width == j) && (((LinearLayout.LayoutParams)localObject).height == i)) {
                  break label253;
                }
                ((LinearLayout.LayoutParams)localObject).width = j;
                ((LinearLayout.LayoutParams)localObject).height = i;
                localPicViewHolder.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
                break label253;
              }
            }
            catch (Exception paramMomentViewHolder)
            {
              localPicViewHolder.f.setImageDrawable(this.a.getResources().getDrawable(2130842848));
              QLog.i("PicMomentItemBuilder", 1, paramMomentViewHolder.toString());
              return;
            }
          }
        }
        label502:
        i = j;
      }
      label507:
      bool = false;
      localFile = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.PicMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */