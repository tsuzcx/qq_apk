package com.tencent.mobileqq.richmedia.mediacodec;

import ahob;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.IMp4ReEncoder;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import com.tencent.qphone.base.util.QLog;

public class MergeEditVideo
{
  private volatile int jdField_a_of_type_Int = 0;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private void a(MergeEditVideo.EditParam paramEditParam, EncodeConfig paramEncodeConfig)
  {
    int i = 1;
    boolean bool1 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish;
    if (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 1)
    {
      boolean bool2 = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("is_hw_encode", false);
      if ((!bool1) && (bool2)) {
        break label50;
      }
    }
    label50:
    do
    {
      return;
      i = 0;
      break;
      if ((i != 0) || (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 9))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MergeEditVideo", 2, "adjust encode config orientation:" + paramEncodeConfig.toString());
        }
        paramEncodeConfig.g = 0;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + paramEncodeConfig.toString());
  }
  
  public int a(String arg1, String paramString2, MergeEditVideo.EditParam paramEditParam)
  {
    if ((paramEditParam == null) || (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null)) {
      i = -1;
    }
    String str;
    Object localObject;
    do
    {
      return i;
      str = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("subtitleData", "");
      localObject = new MediaMetadataUtils.MetaData();
      j = MediaMetadataUtils.a(???, (MediaMetadataUtils.MetaData)localObject);
      i = j;
    } while (j != 0);
    int k = localObject.a[0];
    int m = localObject.a[1];
    int n = localObject.a[2];
    int i = localObject.a[4];
    int i1 = paramEditParam.jdField_a_of_type_Int;
    int j = 0;
    i = j;
    if (!paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isLocalPublish)
    {
      i = j;
      if (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("is_hw_encode", false))
      {
        i = j;
        if (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 1)
        {
          i = j;
          if (n != 0) {
            i = 1;
          }
        }
      }
    }
    if ((paramEditParam.c == 0) && (paramEditParam.b == 0) && (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath == null) && (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath == null) && (paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId != 9) && (TextUtils.isEmpty(str)) && (!paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments) && (TextUtils.isEmpty(paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fragments)) && (i == 0)) {
      return -1;
    }
    boolean bool = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("enable_flow_decode", true);
    QLog.d("MergeEditVideo", 2, "mergeVideo. enableFlowDecode = " + bool + ", speedMode = " + paramEditParam.c);
    j = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart;
    i = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd;
    if ((!bool) && (paramEditParam.c == 3))
    {
      ??? = paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mIFrameVideoPath;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 0;
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 0;
      if ((bool) && (paramEditParam.c == 3))
      {
        localObject = new Mp4FlowReEncoder();
        arrayOfInt[0] = 1;
      }
      for (;;)
      {
        DecodeConfig localDecodeConfig = new DecodeConfig(???, paramEditParam.c, false, true, j, i);
        if (((paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 10) && ((n == 270) || (n == 90))) || ((paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.businessId == 12) && ((n == 270) || (n == 90))))
        {
          ??? = new EncodeConfig(paramString2, m, k, i1, 1, 30, paramEditParam.b, false, 0, paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, str, false);
          ???.i = n;
          localDecodeConfig.c = true;
          label509:
          a(paramEditParam, ???);
          localDecodeConfig.b = n;
          ???.j = paramEditParam.d;
          ???.k = paramEditParam.e;
          ((IMp4ReEncoder)localObject).a(localDecodeConfig, ???, new ahob(this, arrayOfInt), null);
          if (!this.jdField_a_of_type_Boolean) {
            synchronized (this.jdField_a_of_type_JavaLangObject)
            {
              bool = this.jdField_a_of_type_Boolean;
              if (bool) {}
            }
          }
        }
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait();
          label591:
          return this.jdField_a_of_type_Int;
          localObject = new Mp4ReEncoder();
          arrayOfInt[0] = 2;
          continue;
          ??? = new EncodeConfig(paramString2, k, m, i1, 1, 30, paramEditParam.b, false, n, paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath, paramEditParam.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath, str, false);
          break label509;
          paramString2 = finally;
          throw paramString2;
        }
        catch (InterruptedException paramString2)
        {
          break label591;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo
 * JD-Core Version:    0.7.0.1
 */