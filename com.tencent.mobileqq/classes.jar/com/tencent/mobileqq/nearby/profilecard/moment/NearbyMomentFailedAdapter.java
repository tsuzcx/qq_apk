package com.tencent.mobileqq.nearby.profilecard.moment;

import aews;
import aewu;
import aewv;
import aewx;
import aewz;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.LocalMediaInfo;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.ImageFeedsUploader.UploadListener;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadInfo;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadListener;
import com.tencent.mobileqq.nearby.now.send.uploader.VideoFeedsUploader.UploadResult;
import com.tencent.mobileqq.nearby.profilecard.moment.data.PublishableMomentInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.data.ShortVideoMomentFeedInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyMomentFailedAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private static ImageFeedsUploader.UploadListener jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$UploadListener = new aewx();
  private static VideoFeedsUploader.UploadListener jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadListener = new aewv();
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-1644826);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public NearbyMomentFailedAdapter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a(PicFeedUploadInfo paramPicFeedUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedId", paramPicFeedUploadInfo.feedId);
      localJSONObject.put("uin", paramPicFeedUploadInfo.anchorUin);
      localJSONObject.put("feed_type", 4);
      localJSONObject.put("cover_pic", paramUploadResult.e);
      localJSONObject.put("city", paramPicFeedUploadInfo.city);
      localJSONObject.put("like_num", 0);
      localJSONObject.put("pic_url", paramUploadResult.e);
      if (!paramPicFeedUploadInfo.photoInfo.isEmpty())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramPicFeedUploadInfo.photoInfo.get(0);
        localJSONObject.put("video_width", localLocalMediaInfo.c);
        localJSONObject.put("video_height", localLocalMediaInfo.d);
      }
      localJSONObject.put("video_url", paramUploadResult.e);
      localJSONObject.put("longitude", paramPicFeedUploadInfo.locationInfo.lng);
      localJSONObject.put("latitude", paramPicFeedUploadInfo.locationInfo.lat);
      localJSONObject.put("desc", paramPicFeedUploadInfo.desc);
    }
    catch (JSONException paramPicFeedUploadInfo)
    {
      for (;;)
      {
        QLog.e("NearbyMomentFailedAdapter", 1, "createExtraDataForJS faile", paramPicFeedUploadInfo);
      }
    }
    return localJSONObject.toString();
  }
  
  public static String a(VideoFeedsUploader.UploadInfo paramUploadInfo, VideoFeedsUploader.UploadResult paramUploadResult)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedId", paramUploadResult.d);
      localJSONObject.put("uin", paramUploadInfo.jdField_j_of_type_Long);
      localJSONObject.put("feed_type", 3);
      localJSONObject.put("cover_pic", paramUploadResult.e);
      localJSONObject.put("city", paramUploadInfo.jdField_j_of_type_JavaLangString);
      localJSONObject.put("like_num", 0);
      localJSONObject.put("pic_url", paramUploadResult.e);
      localJSONObject.put("video_width", paramUploadInfo.jdField_g_of_type_Long);
      localJSONObject.put("video_height", paramUploadInfo.h);
      localJSONObject.put("video_url", paramUploadResult.jdField_g_of_type_JavaLangString);
      localJSONObject.put("longitude", paramUploadInfo.a.lng);
      localJSONObject.put("latitude", paramUploadInfo.a.lat);
      localJSONObject.put("desc", paramUploadInfo.jdField_g_of_type_JavaLangString);
      return localJSONObject.toString();
    }
    catch (JSONException paramUploadInfo)
    {
      for (;;)
      {
        QLog.e("NearbyMomentFailedAdapter", 1, "createExtraDataForJS faile", paramUploadInfo);
      }
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969122, paramViewGroup, false);
      paramView = new aewz(this);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365246));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365250);
      paramView.c = localView.findViewById(2131365248);
      paramView.b = localView.findViewById(2131365247);
      paramView.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.c.setOnClickListener(this);
      localView.setTag(paramView);
    }
    paramView = (aewz)localView.getTag();
    paramViewGroup = (PublishableMomentInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramView.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataPublishableMomentInfo = paramViewGroup;
    if ((paramViewGroup instanceof ShortVideoMomentFeedInfo)) {
      paramView.b.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup = paramViewGroup.a.thumbPath;
      if (!TextUtils.equals(paramViewGroup, (String)paramView.jdField_a_of_type_AndroidWidgetImageView.getTag(2131362360)))
      {
        paramViewGroup = new File(paramViewGroup);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = UIUtils.a(localView.getContext(), 40.0F);
        localURLDrawableOptions.mRequestHeight = UIUtils.a(localView.getContext(), 40.0F);
        localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramViewGroup = URLDrawable.getDrawable(paramViewGroup, localURLDrawableOptions);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
      }
      return localView;
      paramView.b.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    PublishableMomentInfo localPublishableMomentInfo = ((aewz)NearbyMomentUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataPublishableMomentInfo;
    switch (i)
    {
    case 2131365249: 
    default: 
      return;
    case 2131365250: 
      if (!NetworkUtil.g(paramView.getContext()))
      {
        QQToast.a(paramView.getContext(), 1, "当前网络不可用，请检查你的网络设置", 0).a();
        return;
      }
      if ((localPublishableMomentInfo instanceof ShortVideoMomentFeedInfo)) {
        VideoFeedsUploader.a(localPublishableMomentInfo.a, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderVideoFeedsUploader$UploadListener);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilList.remove(localPublishableMomentInfo);
        notifyDataSetChanged();
        return;
        ImageFeedsUploader.a(localPublishableMomentInfo.a, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_ComTencentMobileqqNearbyNowSendUploaderImageFeedsUploader$UploadListener);
      }
    }
    DialogUtil.a(paramView.getContext(), 230).setTitle("你确定要删除该动态吗？").setNegativeButton(2131432998, new aewu(this, localPublishableMomentInfo)).setPositiveButton(2131434024, new aews(this, localPublishableMomentInfo)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFailedAdapter
 * JD-Core Version:    0.7.0.1
 */