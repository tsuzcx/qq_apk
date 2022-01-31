package dov.com.tencent.mobileqq.richmedia.mediacodec;

import android.text.TextUtils;
import aovw;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DoodleUtil;
import dov.com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder;
import dov.com.tencent.mobileqq.shortvideo.filter.QQEncodeFilterRender;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MergeEditVideo
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private void a(MergeEditVideo.EditParam paramEditParam, EncodeConfig paramEncodeConfig)
  {
    int k = 960;
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
      if (i <= 960) {
        break label371;
      }
      j = (int)(j * 960.0D / i);
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
  
  public int a(String arg1, String paramString2, MergeEditVideo.EditParam paramEditParam, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((paramEditParam == null) || (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null)) {
      return -1;
    }
    boolean bool = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("hasAVFilter", false);
    Object localObject3 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONArrayExtra("jsonAVFilterData");
    Object localObject1 = null;
    if (localObject3 == null) {
      bool = false;
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("transfer_effect_data", null);
      paramEditParam.a(paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode);
      if ((paramEditParam.jdField_c_of_type_Int != 0) || (paramEditParam.b != 0) || (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath != null) || (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath != null) || (bool) || (localObject2 != null) || ((paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 1) && (paramPublishVideoEntry.isLocalPublish)) || (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments) || (!TextUtils.isEmpty(paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fragments))) {
        break;
      }
      return -1;
      localObject2 = FilterDesc.a((JSONArray)localObject3);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((ArrayList)localObject2).isEmpty()) {}
      }
      else
      {
        bool = false;
        localObject1 = localObject2;
      }
    }
    paramPublishVideoEntry = new MediaMetadataUtils.MetaData();
    int i = MediaMetadataUtils.a(???, paramPublishVideoEntry);
    if (i != 0) {
      return i;
    }
    int m = paramPublishVideoEntry.a[0];
    int n = paramPublishVideoEntry.a[1];
    int i1 = paramPublishVideoEntry.a[2];
    i = paramPublishVideoEntry.a[4];
    int i2 = paramEditParam.jdField_a_of_type_Int;
    i = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart;
    int j = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd;
    int k;
    if (paramEditParam.jdField_c_of_type_Int == 5)
    {
      ??? = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath;
      j = 0;
      i = 0;
      if (localObject1 == null) {
        break label694;
      }
      com.tencent.sveffects.SvEffectSdkInitor.jdField_a_of_type_Boolean = true;
      JSONObject localJSONObject = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getJSONExtra("jsonMusicData");
      paramPublishVideoEntry = null;
      if (localJSONObject != null) {
        paramPublishVideoEntry = new MusicItemInfo(localJSONObject);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("MergeEditVideo", 2, "getAVFilterJSONArray " + ((JSONArray)localObject3).toString());
        localObject3 = new StringBuilder().append("getMusicInfo id = ");
        if (paramPublishVideoEntry == null) {
          break label688;
        }
        k = paramPublishVideoEntry.jdField_a_of_type_Int;
        label399:
        QLog.d("MergeEditVideo", 2, k);
      }
    }
    label669:
    label686:
    label688:
    label694:
    for (paramPublishVideoEntry = new QQEncodeFilterRender((List)localObject1, paramPublishVideoEntry, m, n);; paramPublishVideoEntry = null)
    {
      localObject1 = new Mp4ReEncoder();
      paramString2 = new EncodeConfig(paramString2, m, n, i2, 1, 30, paramEditParam.b, false, i1, paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, null, paramEditParam.jdField_a_of_type_Boolean);
      ??? = new DecodeConfig(???, paramEditParam.jdField_c_of_type_Int, false, true, i, j);
      a(paramEditParam, paramString2);
      ???.jdField_c_of_type_Boolean = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("local_import", false);
      ???.jdField_c_of_type_Int = i1;
      localObject3 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("dynamic_Sticker_data", null);
      if (localObject3 != null) {
        ((Mp4ReEncoder)localObject1).a(DoodleUtil.a((String)localObject3));
      }
      localObject3 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("tracker_Sticker_data", null);
      if (localObject3 != null) {
        ((Mp4ReEncoder)localObject1).b(TrackerStickerParam.a((String)localObject3));
      }
      paramString2.j = paramEditParam.d;
      paramString2.k = paramEditParam.e;
      if (localObject2 != null) {
        ((Mp4ReEncoder)localObject1).b((String)localObject2);
      }
      ((Mp4ReEncoder)localObject1).a(???, paramString2, new aovw(this, paramPublishVideoEntry, m, n), paramPublishVideoEntry);
      if (!this.jdField_a_of_type_Boolean)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          bool = this.jdField_a_of_type_Boolean;
          if (bool) {}
        }
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait();
          break label686;
          paramString2 = finally;
          throw paramString2;
        }
        catch (InterruptedException paramString2)
        {
          break label669;
        }
        break;
      }
      return 0;
      k = -1;
      break label399;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo
 * JD-Core Version:    0.7.0.1
 */