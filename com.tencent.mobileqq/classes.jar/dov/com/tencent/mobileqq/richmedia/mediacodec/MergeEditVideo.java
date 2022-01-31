package dov.com.tencent.mobileqq.richmedia.mediacodec;

import android.text.TextUtils;
import anxb;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DoodleUtil;
import dov.com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder;
import dov.com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder.EncodeFilterRender;
import dov.com.tencent.mobileqq.shortvideo.filter.QQEncodeFilterRender;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;

public class MergeEditVideo
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private void a(MergeEditVideo.EditParam paramEditParam, EncodeConfig paramEncodeConfig)
  {
    int k = 1280;
    int i = 1;
    boolean bool1 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
    int j = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getIntExtra("video_rotation", 0);
    boolean bool2 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false);
    if (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 1)
    {
      if (!bool1) {
        break label267;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("MergeEditVideo", 2, "before adjust rotation: " + j);
        QLog.d("MergeEditVideo", 2, "before adjust config: " + paramEncodeConfig.toString());
      }
      if (j != 0)
      {
        paramEncodeConfig.h = j;
        if (i == 0) {
          break label244;
        }
        paramEncodeConfig.g = 0;
      }
      label139:
      j = Math.min(paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.b);
      i = Math.max(paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.b);
      if (i <= 1280) {
        break label371;
      }
      j = (int)(j * 1280.0D / i);
      i = k;
    }
    label267:
    label371:
    for (;;)
    {
      paramEncodeConfig.jdField_a_of_type_Int = CaptureUtil.a(j);
      paramEncodeConfig.b = CaptureUtil.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + paramEncodeConfig.toString());
      }
      label244:
      do
      {
        return;
        i = 0;
        break;
        if (bool2)
        {
          paramEncodeConfig.g = 270;
          break label139;
        }
        paramEncodeConfig.g = 0;
        break label139;
        if (QLog.isColorLevel())
        {
          QLog.d("MergeEditVideo", 2, "before adjust rotation: " + j);
          QLog.d("MergeEditVideo", 2, "before adjust config: " + paramEncodeConfig.toString());
        }
        if (i != 0) {
          paramEncodeConfig.g = 0;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + paramEncodeConfig.toString());
      return;
    }
  }
  
  public int a(String arg1, String paramString2, MergeEditVideo.EditParam paramEditParam)
  {
    if ((paramEditParam == null) || (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null)) {
      i = -1;
    }
    Object localObject2;
    do
    {
      return i;
      localObject1 = QQFilterRenderManagerHolder.a(QQFilterRenderManagerHolder.jdField_c_of_type_Int);
      paramEditParam.a(paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode);
      if ((paramEditParam.jdField_c_of_type_Int == 0) && (paramEditParam.b == 0) && (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath == null) && (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath == null) && ((localObject1 == null) || (!((QQFilterRenderManager)localObject1).a())) && (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 1) && (!paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments) && (TextUtils.isEmpty(paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fragments))) {
        return -1;
      }
      localObject2 = new MediaMetadataUtils.MetaData();
      j = MediaMetadataUtils.a(???, (MediaMetadataUtils.MetaData)localObject2);
      i = j;
    } while (j != 0);
    int m = localObject2.a[0];
    int n = localObject2.a[1];
    int i1 = localObject2.a[2];
    int i = localObject2.a[4];
    int i2 = paramEditParam.jdField_a_of_type_Int;
    i = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart;
    int j = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd;
    Object localObject3;
    int k;
    if (paramEditParam.jdField_c_of_type_Int == 5)
    {
      ??? = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath;
      j = 0;
      i = 0;
      if (localObject1 == null) {
        break label538;
      }
      localObject2 = ((QQFilterRenderManager)localObject1).a();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("getMusicInfo id = ");
        if (localObject2 == null) {
          break label532;
        }
        k = ((MusicItemInfo)localObject2).jdField_a_of_type_Int;
        label271:
        QLog.d("MergeEditVideo", 2, k);
      }
    }
    label513:
    label530:
    label532:
    label538:
    for (Object localObject1 = new QQEncodeFilterRender(((QQFilterRenderManager)localObject1).a(), (MusicItemInfo)localObject2, m, n);; localObject1 = null)
    {
      localObject2 = new Mp4ReEncoder();
      paramString2 = new EncodeConfig(paramString2, m, n, i2, 1, 30, paramEditParam.b, false, i1, paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, null, paramEditParam.jdField_a_of_type_Boolean);
      ??? = new DecodeConfig(???, paramEditParam.jdField_c_of_type_Int, false, true, i, j);
      a(paramEditParam, paramString2);
      ???.jdField_c_of_type_Boolean = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
      ???.jdField_c_of_type_Int = i1;
      localObject3 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("dynamic_Sticker_data", null);
      if (localObject3 != null) {
        ((Mp4ReEncoder)localObject2).a(DoodleUtil.a((String)localObject3));
      }
      paramEditParam = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("tracker_Sticker_data", null);
      if (paramEditParam != null) {
        ((Mp4ReEncoder)localObject2).b(TrackerStickerParam.a(paramEditParam));
      }
      ((Mp4ReEncoder)localObject2).a(???, paramString2, new anxb(this, (QQEncodeFilterRender)localObject1, m, n), (Mp4ReEncoder.EncodeFilterRender)localObject1);
      if (!this.jdField_a_of_type_Boolean)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          boolean bool = this.jdField_a_of_type_Boolean;
          if (bool) {}
        }
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait();
          break label530;
          paramString2 = finally;
          throw paramString2;
        }
        catch (InterruptedException paramString2)
        {
          break label513;
        }
        break;
      }
      return 0;
      k = -1;
      break label271;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo
 * JD-Core Version:    0.7.0.1
 */