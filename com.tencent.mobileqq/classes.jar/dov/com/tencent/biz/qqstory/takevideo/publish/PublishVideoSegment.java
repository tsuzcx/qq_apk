package dov.com.tencent.biz.qqstory.takevideo.publish;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import java.io.File;
import java.util.TimeZone;

public class PublishVideoSegment
  extends MeasureJobSegment
{
  private final EditVideoParams a;
  
  public PublishVideoSegment(@NonNull EditVideoParams paramEditVideoParams)
  {
    this.a = paramEditVideoParams;
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    SLog.c("Q.qqstory.publish.edit.PublishVideoSegment", "PublishVideoSegment.");
    PublishVideoEntry localPublishVideoEntry = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    localPublishVideoEntry.publishFrom = this.a.b();
    localPublishVideoEntry.businessId = this.a.jdField_a_of_type_Int;
    localPublishVideoEntry.fakeVid = StoryVideoItem.makeFakeVid();
    localPublishVideoEntry.mLocalDate = FeedManager.a();
    localPublishVideoEntry.timeZoneOffset = TimeZone.getDefault().getRawOffset();
    if (localPublishVideoEntry.createTime == 0L) {
      localPublishVideoEntry.createTime = NetConnInfoCenter.getServerTimeMillis();
    }
    SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish date:%s and time:%d", new Object[] { localPublishVideoEntry.mLocalDate, Long.valueOf(localPublishVideoEntry.createTime) });
    localPublishVideoEntry.publishState = 1;
    localPublishVideoEntry.videoUploadTempDir = paramGenerateContext.jdField_b_of_type_JavaLangString;
    int i;
    label724:
    Object localObject2;
    Object localObject1;
    if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      localPublishVideoEntry.hwEncodeRecordVideo = true;
      localPublishVideoEntry.isPicture = false;
      localPublishVideoEntry.isLocalPublish = false;
      paramJobContext = (EditTakeVideoSource)paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      localPublishVideoEntry.mLocalRawVideoDir = paramJobContext.a();
      localPublishVideoEntry.recordTime = paramJobContext.a.mDuration;
      localPublishVideoEntry.recordFrames = ((int)paramJobContext.a.mDuration * 30);
      localPublishVideoEntry.mAudioFilePath = paramJobContext.jdField_b_of_type_JavaLangString;
      if (VideoUtils.b(paramJobContext.a()) % 180 > 0) {
        localPublishVideoEntry.videoWidth = paramJobContext.b();
      }
      for (localPublishVideoEntry.videoHeight = paramJobContext.a();; localPublishVideoEntry.videoHeight = paramJobContext.b())
      {
        localPublishVideoEntry.videoDuration = paramJobContext.a.mDuration;
        if ((localPublishVideoEntry.saveMode != 5) || (com.tencent.biz.qqstory.utils.FileUtils.c(localPublishVideoEntry.mIFrameVideoPath))) {
          break;
        }
        super.notifyError(new ErrorMessage(-1, "back mode but iframe file is empty"));
        return;
        localPublishVideoEntry.videoWidth = paramJobContext.a();
      }
      localPublishVideoEntry.videoCreateTime = paramJobContext.a.addedDate;
      i = 1;
      if (i != 0) {
        VideoFilterTools.a().a(localPublishVideoEntry);
      }
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : edit source = %s", new Object[] { paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fake vid = %s", new Object[] { localPublishVideoEntry.fakeVid });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : mLocalRawVideoDir = %s", new Object[] { localPublishVideoEntry.mLocalRawVideoDir });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : width = %d, height = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.videoWidth), Integer.valueOf(localPublishVideoEntry.videoHeight) });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : duration = %d, recordTime = %d", new Object[] { Integer.valueOf((int)localPublishVideoEntry.videoDuration), Integer.valueOf((int)localPublishVideoEntry.recordTime) });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : businessId = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.businessId) });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : thumbPath = %s", new Object[] { localPublishVideoEntry.thumbPath });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleImagePath = %s", new Object[] { localPublishVideoEntry.doodlePath });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleRawImagePath = %s", new Object[] { localPublishVideoEntry.doodleRawPath });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : atDoodleImagePath = %s", new Object[] { localPublishVideoEntry.atDoodlePath });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fragmentGroupId = %s", new Object[] { localPublishVideoEntry.multiFragmentGroupId });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : isLocalPublish = %s", new Object[] { Boolean.valueOf(localPublishVideoEntry.isLocalPublish) });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : hasFragments = %s", new Object[] { Boolean.valueOf(localPublishVideoEntry.hasFragments) });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fragments = %s", new Object[] { localPublishVideoEntry.fragments });
      SLog.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : publishFrom = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.publishFrom) });
      if (TextUtils.isEmpty(localPublishVideoEntry.mLocalRawVideoDir)) {
        super.notifyError(new ErrorMessage(-1, "mLocalRawVideoDir is empty"));
      }
    }
    else if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      localPublishVideoEntry.isPicture = false;
      if (this.a.a("extra_is_slide_show_video", false))
      {
        i = 2;
        localPublishVideoEntry.putExtra("video_type", Integer.valueOf(i));
        localPublishVideoEntry.isLocalPublish = true;
        localObject2 = (EditLocalVideoSource)paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        paramJobContext = ((EditLocalVideoSource)localObject2).a();
        if (this.a.a() == 1) {
          break label2097;
        }
        localObject1 = new File(paramJobContext);
        localObject1 = AppConstants.aT + localPublishVideoEntry.fakeVid + File.separator + ((File)localObject1).getName();
        if (!com.tencent.mobileqq.utils.FileUtils.d(paramJobContext, (String)localObject1)) {
          break label2097;
        }
        paramJobContext = (JobContext)localObject1;
      }
    }
    label1965:
    label2094:
    label2097:
    for (;;)
    {
      localPublishVideoEntry.mLocalRawVideoDir = paramJobContext;
      localPublishVideoEntry.recordTime = ((EditLocalVideoSource)localObject2).a.mDuration;
      localPublishVideoEntry.recordFrames = ((int)((EditLocalVideoSource)localObject2).a.mDuration * 30);
      if (VideoUtils.b(((EditLocalVideoSource)localObject2).a()) % 180 > 0) {
        localPublishVideoEntry.videoWidth = ((EditLocalVideoSource)localObject2).b();
      }
      for (localPublishVideoEntry.videoHeight = ((EditLocalVideoSource)localObject2).a();; localPublishVideoEntry.videoHeight = ((EditLocalVideoSource)localObject2).b())
      {
        localPublishVideoEntry.videoDuration = ((EditLocalVideoSource)localObject2).a.mDuration;
        localPublishVideoEntry.videoCreateTime = ((EditLocalVideoSource)localObject2).a.addedDate;
        i = 1;
        break;
        i = 0;
        break label724;
        localPublishVideoEntry.videoWidth = ((EditLocalVideoSource)localObject2).a();
      }
      if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
      {
        localPublishVideoEntry.isPicture = false;
        localPublishVideoEntry.isLocalPublish = false;
        paramJobContext = (EditRecordVideoSource)paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        localPublishVideoEntry.mLocalRawVideoDir = paramJobContext.a();
        localPublishVideoEntry.recordTime = paramJobContext.jdField_a_of_type_Long;
        localPublishVideoEntry.recordFrames = paramJobContext.jdField_a_of_type_Int;
        localPublishVideoEntry.videoWidth = paramJobContext.a();
        localPublishVideoEntry.videoHeight = paramJobContext.b();
        if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode == 1) {
          localPublishVideoEntry.videoDuration = (paramJobContext.jdField_a_of_type_Long / 2L);
        }
        for (;;)
        {
          i = 1;
          break;
          if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode == 2) {
            localPublishVideoEntry.videoDuration = (paramJobContext.jdField_a_of_type_Long * 2L);
          } else if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode == 4) {
            localPublishVideoEntry.videoDuration = (paramJobContext.jdField_a_of_type_Long * 4L);
          } else if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode == 3) {
            localPublishVideoEntry.videoDuration = (((float)paramJobContext.jdField_a_of_type_Long / 1.5F));
          } else {
            localPublishVideoEntry.videoDuration = paramJobContext.jdField_a_of_type_Long;
          }
        }
      }
      if (((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)))
      {
        localPublishVideoEntry.isPicture = true;
        paramJobContext = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
        if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
        {
          localObject1 = (EditLocalPhotoSource)paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
          localPublishVideoEntry.isLocalPublish = true;
          localPublishVideoEntry.videoCreateTime = ((EditLocalPhotoSource)localObject1).a.addedDate;
        }
        for (;;)
        {
          if (localPublishVideoEntry.thumbPath == null) {
            break label1355;
          }
          localPublishVideoEntry.mLocalRawVideoDir = localPublishVideoEntry.thumbPath;
          if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
            localPublishVideoEntry.mLocalRawPicPath = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_JavaLangString;
          }
          localPublishVideoEntry.recordTime = 5000.0D;
          localPublishVideoEntry.recordFrames = 150000;
          paramJobContext = new BitmapFactory.Options();
          paramJobContext.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(localPublishVideoEntry.mLocalRawVideoDir, paramJobContext);
          localPublishVideoEntry.videoWidth = paramJobContext.outWidth;
          localPublishVideoEntry.videoHeight = paramJobContext.outHeight;
          localPublishVideoEntry.videoDuration = 5000L;
          i = 0;
          break;
          localPublishVideoEntry.isLocalPublish = false;
        }
        label1355:
        if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean) || (!paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_Boolean)) {
          break label2094;
        }
        paramJobContext = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_JavaLangString;
      }
      for (;;)
      {
        localPublishVideoEntry.mLocalRawVideoDir = paramJobContext;
        break;
        super.notifyError(new ErrorMessage(-1, "illegal argument " + paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource));
        return;
        if (localPublishVideoEntry.thumbPath != null)
        {
          paramJobContext = new File(localPublishVideoEntry.thumbPath);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile()) || (paramJobContext.length() <= 0L))
          {
            super.notifyError(new ErrorMessage(-1, "thumbFile is invalid : " + paramJobContext));
            return;
          }
        }
        if (localPublishVideoEntry.doodlePath != null)
        {
          paramJobContext = new File(localPublishVideoEntry.doodlePath);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile()) || (paramJobContext.length() <= 0L))
          {
            super.notifyError(new ErrorMessage(-1, "doodleFile is invalid : " + paramJobContext));
            return;
          }
        }
        if (localPublishVideoEntry.mosaicPath != null)
        {
          paramJobContext = new File(localPublishVideoEntry.mosaicPath);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile()) || (paramJobContext.length() <= 0L))
          {
            super.notifyError(new ErrorMessage(-1, "mosaicfile is invalid : " + paramJobContext));
            return;
          }
        }
        if (localPublishVideoEntry.doodleRawPath != null)
        {
          paramJobContext = new File(localPublishVideoEntry.doodleRawPath);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile()) || (paramJobContext.length() <= 0L))
          {
            super.notifyError(new ErrorMessage(-1, "doodleRawFile is invalid : " + paramJobContext));
            return;
          }
        }
        QQStoryContext.a().a().createEntityManager().b(localPublishVideoEntry);
        SLog.c("Q.qqstory.publish.edit.PublishVideoSegment", "after persist or replace.");
        i = 0;
        if (paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode != 0) {
          i = 1;
        }
        if (paramGenerateContext.jdField_b_of_type_Boolean) {
          i = 1;
        }
        if (localPublishVideoEntry.isMuteRecordVoice) {
          i = 1;
        }
        if (localPublishVideoEntry.backgroundMusicPath != null) {
          i = 1;
        }
        if (localPublishVideoEntry.doodlePath != null) {
          i = 1;
        }
        if (localPublishVideoEntry.doodleRawPath != null) {
          i = 1;
        }
        if (paramGenerateContext.c) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            VideoEditReport.a("0X80076BD");
          }
          paramJobContext = localPublishVideoEntry.fakeVid;
          localObject1 = localPublishVideoEntry.thumbPath;
          localObject2 = localPublishVideoEntry.doodlePath;
          String str1 = localPublishVideoEntry.videoLabel;
          String str2 = localPublishVideoEntry.videoDoodleDescription;
          String str3 = localPublishVideoEntry.videoAddress;
          int n = localPublishVideoEntry.videoWidth;
          int i1 = localPublishVideoEntry.videoHeight;
          long l = localPublishVideoEntry.videoDuration;
          int i2 = localPublishVideoEntry.videoMaxrate;
          int i3 = localPublishVideoEntry.videoMinrate;
          int i4 = localPublishVideoEntry.saveMode;
          int i5 = localPublishVideoEntry.recordFrames;
          String str4 = localPublishVideoEntry.atDoodlePath;
          String str5 = localPublishVideoEntry.atJsonData;
          int j;
          int k;
          if (localPublishVideoEntry.isPicture)
          {
            j = 1;
            if (!paramGenerateContext.d) {
              break label2079;
            }
            k = 1;
            if (!localPublishVideoEntry.hwEncodeRecordVideo) {
              break label2085;
            }
          }
          for (int m = 1;; m = 0)
          {
            paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam = new PublishParam(paramJobContext, (String)localObject1, (String)localObject2, str1, str2, str3, n, i1, l, i2, i3, i, i4, i5, str4, str5, j, k, m, localPublishVideoEntry.mLocalRawVideoDir, localPublishVideoEntry.mAudioFilePath, localPublishVideoEntry.mIFrameVideoPath, localPublishVideoEntry.mosaicPath, paramGenerateContext.jdField_b_of_type_Int, localPublishVideoEntry.isLocalPublish, localPublishVideoEntry.videoLocationDescription, localPublishVideoEntry.videoLongitude, localPublishVideoEntry.videoLatitude);
            super.notifyResult(paramGenerateContext);
            return;
            j = 0;
            break;
            k = 0;
            break label1965;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.PublishVideoSegment
 * JD-Core Version:    0.7.0.1
 */