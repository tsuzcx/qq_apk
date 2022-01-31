import android.content.Context;
import android.os.Looper;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;

public class qlg
{
  private static String jdField_a_of_type_JavaLangString = qlg.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private HashMap<Integer, qln> jdField_a_of_type_JavaUtilHashMap;
  private qlm jdField_a_of_type_Qlm;
  private qlo jdField_a_of_type_Qlo;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  
  public qlg(Context paramContext, String paramString, HashMap<Integer, qln> paramHashMap, long paramLong)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void c()
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, "", "");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new qlh(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new qli(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new qlj(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new qlk(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnExtractFrameListener(new qll(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString, 0L, 0L, localTVK_PlayerVideoInfo);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null);
    this.jdField_a_of_type_Qlo = new qlo(this, Looper.getMainLooper());
    this.jdField_a_of_type_Qlo.sendEmptyMessageDelayed(1, this.jdField_a_of_type_Long);
    c();
  }
  
  public void a(qlm paramqlm)
  {
    this.jdField_a_of_type_Qlm = paramqlm;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Qlo != null)
    {
      this.jdField_a_of_type_Qlo.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Qlo = null;
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    this.jdField_a_of_type_Qlm = null;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlg
 * JD-Core Version:    0.7.0.1
 */