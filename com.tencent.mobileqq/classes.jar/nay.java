import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager.CompositeVideoEvent;
import com.tencent.biz.qqstory.base.videoupload.VideoSaveToAlbumHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Dispatchers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class nay
  implements Runnable
{
  nay(nax paramnax, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    VideoCompositeManager.CompositeVideoEvent localCompositeVideoEvent = new VideoCompositeManager.CompositeVideoEvent(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager);
    localCompositeVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    localCompositeVideoEvent.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_JavaLangString;
    localCompositeVideoEvent.b = this.b;
    if ((this.jdField_a_of_type_Int == 0) && ((TextUtils.isEmpty(this.b)) || (!com.tencent.biz.qqstory.utils.FileUtils.b(this.b)) || (com.tencent.mobileqq.utils.FileUtils.a(this.b) < 100L))) {
      localCompositeVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage(940007, String.format("vid:%s file:%s", new Object[] { this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_JavaLangString, this.b }));
    }
    long l1;
    synchronized (this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_JavaLangString, localCompositeVideoEvent);
      l1 = 0L;
      ??? = "";
    }
    label1794:
    for (;;)
    {
      try
      {
        if (!localCompositeVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
          continue;
        }
        if (!new File(this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mLocalRawVideoDir).isDirectory()) {
          continue;
        }
        localObject3 = com.tencent.mobileqq.utils.FileUtils.a(this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mLocalRawVideoDir).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          str2 = (String)((Iterator)localObject3).next();
          l1 += com.tencent.mobileqq.utils.FileUtils.a(str2);
          ??? = (String)??? + str2;
          continue;
          localDispatchable = finally;
          throw localDispatchable;
        }
        if (!TextUtils.isEmpty((CharSequence)???)) {
          break label1794;
        }
        ??? = this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mLocalRawVideoDir;
      }
      catch (Exception localException)
      {
        synchronized (this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager.b)
        {
          String str2;
          boolean bool2;
          VideoSaveToAlbumHelper localVideoSaveToAlbumHelper;
          String str3;
          this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager.b.notifyAll();
          SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "end composite result:%s", new Object[] { localDispatchable });
          this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager.c();
          l1 = SystemClock.elapsedRealtime();
          long l2 = this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_Long;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath)) {
            break label1781;
          }
          ??? = "0";
          int j = this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager.a(this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
          StoryReportor.b("publish_story", "video_composite", j, localDispatchable.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { localDispatchable.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg, String.valueOf(l1 - l2), String.valueOf(this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDuration), ??? });
          if (this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isPicture) {
            continue;
          }
          if (!this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hwEncodeRecordVideo) {
            break label1789;
          }
          i = 1;
          StoryReportor.b("publish_story", "video_encode", 0, i, new String[] { this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate + "", this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate + "" });
          this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager.a(j, this.b, this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
          return;
          l1 = com.tencent.mobileqq.utils.FileUtils.a(this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mLocalRawVideoDir);
          ??? = "" + this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mLocalRawVideoDir;
          continue;
          localException = localException;
          SLog.c("Q.qqstory.publish.upload.VideoCompositeManager", "", localException);
          continue;
          SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "groupId=%s not all success", new Object[] { this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.multiFragmentGroupId });
          continue;
          i = 0;
          continue;
          boolean bool1 = false;
          continue;
          bool1 = false;
          continue;
          SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "failed to composite. let's save original video to album.");
          if ((this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments) && (!VideoCompositeManager.a(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager).b(this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.multiFragmentGroupId))) {
            continue;
          }
          str1 = this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoUploadTempDir + "mc_audio.mp4";
          Object localObject3 = AudioEncoder.a(null, null, 0);
          ((AudioEncoder.AudioData)localObject3).b = str1;
          ((AudioEncoder.AudioData)localObject3).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mAudioFilePath;
          i = AudioEncoder.a((AudioEncoder.AudioData)localObject3);
          if (i != 0) {
            continue;
          }
          localObject3 = PlayModeUtils.a(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_JavaLangString, false);
          i = HwVideoMerge.a(this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mLocalRawVideoDir, str1, (String)localObject3, 0);
          if (i != 0) {
            continue;
          }
          SLog.b("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. HwVideoMerge->merge: success.");
          com.tencent.biz.qqstory.utils.FileUtils.b(BaseApplication.getContext(), new File((String)localObject3));
          continue;
          SLog.e("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. HwVideoMerge->merge: errcode=%s", new Object[] { Integer.valueOf(i) });
          continue;
          SLog.e("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. AudioEncoder.encodeSafely: errcode=%s" + i);
          continue;
          VideoCompositeManager.a(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager).a();
        }
      }
      l2 = com.tencent.biz.qqstory.utils.FileUtils.a();
      localDispatchable.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg = String.format("errorCode:%d, sdcard free size:%d, vf dir size:%d, vf filename:%s, oMsg:%s", new Object[] { Integer.valueOf(localDispatchable.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode), Long.valueOf(l2), Long.valueOf(l1), ???, localDispatchable.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg });
      if (l1 < 100L) {
        localDispatchable.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode = 940018;
      }
      SLog.e("Q.qqstory.publish.upload.VideoCompositeManager", localDispatchable.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg);
      if ((localDispatchable.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments))
      {
        VideoCompositeHelper.a(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_JavaLangString, PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_SUC);
        l1 = com.tencent.biz.qqstory.utils.FileUtils.a();
        SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "sdcard free size %d MB", new Object[] { Long.valueOf(l1 / 1024L / 1024L) });
        if (l1 < 104857600L)
        {
          if (!VideoCompositeHelper.b(this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.multiFragmentGroupId, PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_SUC)) {
            continue;
          }
          com.tencent.biz.qqstory.utils.FileUtils.d(this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mLocalRawVideoDir);
          SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "groupId=%s all success so delete file:%s", new Object[] { this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.multiFragmentGroupId, this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mLocalRawVideoDir });
        }
      }
      if ((localDispatchable.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) && (this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments)) {
        VideoCompositeHelper.a(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_JavaLangString, PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_FAILED);
      }
      bool2 = this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("isEdited", false);
      if ((this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish) && (bool2))
      {
        i = 1;
        if ((this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 1) || (this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isPicture)) {
          continue;
        }
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.upload.VideoCompositeManager", 2, "save from: story " + bool2 + " " + this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish + " " + bool1);
        }
        if ((bool1) || (i != 0))
        {
          if (!localDispatchable.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
            continue;
          }
          SLog.b("Q.qqstory.publish.upload.VideoCompositeManager", "composite successfully. add save to album task.");
          ??? = VideoCompositeManager.a(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager).a(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_JavaLangString);
          VideoCompositeManager.a(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager).a(this.b, (String)???);
          l1 = this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getLongExtra("groupUin", -1L);
          localObject3 = this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("pl", "");
          str2 = this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("i_l", "");
          SLog.a("Q.qqstory.publish.upload.VideoCompositeManager", "composite successfully. add save to album task. pl: %s", String.valueOf(localObject3));
          localVideoSaveToAlbumHelper = VideoCompositeManager.a(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager);
          str3 = this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_JavaLangString;
          i = this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
          j = this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight;
          if (l1 <= 0L) {
            continue;
          }
          bool1 = true;
          localVideoSaveToAlbumHelper.a(str3, (String)???, null, i, j, bool1, StoryVideoItem.PollLayout.a((String)localObject3), StoryVideoItem.InteractPasterLayout.a(str2));
          if (!this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments) {
            continue;
          }
          if (VideoCompositeManager.a(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager).a(this.jdField_a_of_type_Nax.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.multiFragmentGroupId)) {
            VideoCompositeManager.a(this.jdField_a_of_type_Nax.jdField_a_of_type_Naw.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeManager).a();
          }
        }
        Dispatchers.get().dispatch(localDispatchable);
      }
      label1781:
      String str1 = "1";
      continue;
      label1789:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nay
 * JD-Core Version:    0.7.0.1
 */