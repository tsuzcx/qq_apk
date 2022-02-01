package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.kandian.base.video.compress.VideoCompressUtil;
import com.tencent.mobileqq.kandian.biz.publisher.api.IKanDianPublisher;
import com.tencent.mobileqq.kandian.biz.ugc.AlbumUtils.LocalMediaInfo;
import com.tencent.mobileqq.kandian.biz.ugc.PageLoadManager;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcEntryExtraInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import java.io.File;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class SelectVideoPresenter
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private AlbumUtils.LocalMediaInfo jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo;
  private PageLoadManager jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager = new PageLoadManager();
  private ConditionChecker jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoConditionChecker = new ConditionChecker();
  private ISelectVideoView jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoISelectVideoView;
  private SelectVideoUIDelegate jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoSelectVideoUIDelegate = new SelectVideoUIDelegate();
  
  public SelectVideoPresenter(Activity paramActivity, ISelectVideoView paramISelectVideoView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoISelectVideoView = paramISelectVideoView;
    c();
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject3 = new JSONObject();
    IKanDianPublisher localIKanDianPublisher = (IKanDianPublisher)QRoute.api(IKanDianPublisher.class);
    Object localObject4 = localObject3;
    if (paramIntent != null)
    {
      localObject4 = paramIntent.getStringExtra("extra");
      Object localObject1 = localObject3;
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        try
        {
          localObject1 = new JSONObject((String)localObject4);
        }
        catch (JSONException localJSONException)
        {
          QLog.e("RIJUGC.SelectVideoPresenter", 1, localJSONException.getMessage());
          localObject2 = localObject3;
        }
      }
      int i = paramIntent.getIntExtra("key_from", 0);
      localObject3 = paramIntent.getStringExtra("arg_callback");
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo;
      if ((localObject4 != null) && (((AlbumUtils.LocalMediaInfo)localObject4).jdField_b_of_type_JavaLangString != null)) {
        localIKanDianPublisher.buildSelectVideoInfo(localObject2, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo.d, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo.e, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo.b(), this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo.jdField_b_of_type_JavaLangString);
      }
      localIKanDianPublisher.buildPublisherScene(localObject2, i, (String)localObject3);
      localObject3 = (ColumnInfo)paramIntent.getParcelableExtra("key_column_info");
      if ((localObject3 != null) && (((ColumnInfo)localObject3).valid())) {
        localIKanDianPublisher.buildVideoOriginTopicInfo(localObject2, ((ColumnInfo)localObject3).columnID, ((ColumnInfo)localObject3).title);
      }
      localObject3 = (CommunityInfo)paramIntent.getParcelableExtra("key_kd_community_info");
      if (localObject3 != null) {
        localIKanDianPublisher.buildKDCommunityInfo(localObject2, ((CommunityInfo)localObject3).getCommunityId(), ((CommunityInfo)localObject3).getTitle());
      }
      paramIntent = (UgcEntryExtraInfo)paramIntent.getParcelableExtra("key_ugc_entry_extra_info");
      localObject4 = localObject2;
      if (paramIntent != null)
      {
        localIKanDianPublisher.buildUgcEntryExtraInfo(localObject2, paramIntent);
        localObject4 = localObject2;
      }
    }
    localIKanDianPublisher.openPublishArticlePageForResult(this.jdField_a_of_type_AndroidAppActivity, 10001, (JSONObject)localObject4);
  }
  
  private void a(Bitmap paramBitmap, String paramString)
  {
    paramBitmap = new SavePicTask(paramBitmap, paramString);
    paramBitmap.a(new SelectVideoPresenter.8(this));
    paramBitmap.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoConditionChecker.a("暂不支持该类视频格式", new SelectVideoPresenter.1(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoConditionChecker.a("视频时长短于5秒，无法上传", new SelectVideoPresenter.2(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoConditionChecker.a("视频文件不存在", new SelectVideoPresenter.3(this));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("视频大小超过");
    ((StringBuilder)localObject).append(VideoCompressUtil.b());
    ((StringBuilder)localObject).append("，无法上传");
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoConditionChecker.a(localObject, new SelectVideoPresenter.4(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager.a(new SelectVideoPresenter.5(this));
  }
  
  private void d()
  {
    URL localURL = AlbumUtil.generateAlbumVideoThumbURL(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo.jdField_b_of_type_JavaLangString, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo.e = AbsDownloader.getFilePath(localURL.toString());
    if (new File(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo.e).exists())
    {
      f();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(localURL, null);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
    {
      a(ImageUtil.b(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()), this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo.e);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new SelectVideoPresenter.7(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void e()
  {
    AlbumUtils.LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo;
    int j = 0;
    int i;
    if (localLocalMediaInfo == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = j;
      while (i < this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoISelectVideoView.a())
      {
        localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoISelectVideoView.a(i);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoConditionChecker.a(localLocalMediaInfo, null))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoISelectVideoView.b(i);
          return;
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.SelectVideoPresenter", 2, "not found the select video...");
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131694483, 1).a();
    }
  }
  
  private void f()
  {
    a(this.jdField_a_of_type_AndroidAppActivity.getIntent());
  }
  
  private void g()
  {
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "请选择一个视频", 0).a();
  }
  
  public SelectVideoUIDelegate a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoSelectVideoUIDelegate;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager.a(paramInt);
  }
  
  public void a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo = paramLocalMediaInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoSelectVideoUIDelegate.a(paramLocalMediaInfo);
  }
  
  public boolean a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectvideoConditionChecker.a(paramLocalMediaInfo, new SelectVideoPresenter.6(this));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcAlbumUtils$LocalMediaInfo == null)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "saveVideoCoverAndJump failed for selectMediaInfo is null.");
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoPresenter
 * JD-Core Version:    0.7.0.1
 */