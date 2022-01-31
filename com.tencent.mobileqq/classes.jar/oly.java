import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.Mp4VideoFragmentInfo;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder;
import java.util.List;

public class oly
  implements Runnable
{
  public int a;
  public int b = 1;
  public int c;
  
  public oly(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = 30;
    this.b = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
    this.c = paramInt3;
  }
  
  @TargetApi(17)
  public void run()
  {
    SLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", "start convert i frame video. mVideoPath = " + HWEditLocalVideoPlayer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer));
    Object localObject1 = new MediaMetadataRetriever();
    try
    {
      ((MediaMetadataRetriever)localObject1).setDataSource(HWEditLocalVideoPlayer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer));
      Object localObject2 = ((MediaMetadataRetriever)localObject1).extractMetadata(18);
      String str1 = ((MediaMetadataRetriever)localObject1).extractMetadata(19);
      String str2 = ((MediaMetadataRetriever)localObject1).extractMetadata(24);
      ((MediaMetadataRetriever)localObject1).release();
      int i;
      int j;
      int k;
      long l1;
      long l2;
      return;
    }
    catch (Exception localException)
    {
      try
      {
        i = Integer.valueOf(str2).intValue();
        j = Integer.valueOf((String)localObject2).intValue();
        k = Integer.valueOf(str1).intValue();
        HWEditLocalVideoPlayer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer, new Mp4ReEncoder());
        localObject1 = HWEditLocalVideoPlayer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer) + "_" + this.c + ".IFrames.mp4";
        if (this.b != 0) {
          HWEditLocalVideoPlayer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer).jdField_a_of_type_Int = (this.b * this.jdField_a_of_type_Int);
        }
        localObject2 = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer.a.get(this.c);
        l1 = HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject2);
        l2 = HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject2);
        HWEditLocalVideoPlayer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer).a(new DecodeConfig(HWEditLocalVideoPlayer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer), 0, false, true, l1, l2), new EncodeConfig((String)localObject1, j, k, 12582912, this.b, this.jdField_a_of_type_Int, 0, false, i, null, null, null, false), new olz(this, (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject2), new omc(this));
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "video info error, videoFilePath=" + HWEditLocalVideoPlayer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoHWEditLocalVideoPlayer));
      }
      localException = localException;
      SLog.c("Q.qqstory.record.HWEditLocalVideoPlayer", "setDataSource failed when convert i frame", localException);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oly
 * JD-Core Version:    0.7.0.1
 */