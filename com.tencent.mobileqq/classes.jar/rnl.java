import android.content.Context;
import android.os.Looper;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;

public class rnl
{
  private static String jdField_a_of_type_JavaLangString = rnl.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private HashMap<Integer, rns> jdField_a_of_type_JavaUtilHashMap;
  private rnr jdField_a_of_type_Rnr;
  private rnt jdField_a_of_type_Rnt;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  
  public rnl(Context paramContext, String paramString, HashMap<Integer, rns> paramHashMap, long paramLong)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void c()
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, "", "");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new rnm(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new rnn(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new rno(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new rnp(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnExtractFrameListener(new rnq(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString, 0L, 0L, localTVK_PlayerVideoInfo);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null);
    this.jdField_a_of_type_Rnt = new rnt(this, Looper.getMainLooper());
    this.jdField_a_of_type_Rnt.sendEmptyMessageDelayed(1, this.jdField_a_of_type_Long);
    c();
  }
  
  public void a(rnr paramrnr)
  {
    this.jdField_a_of_type_Rnr = paramrnr;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Rnt != null)
    {
      this.jdField_a_of_type_Rnt.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Rnt = null;
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    this.jdField_a_of_type_Rnr = null;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnl
 * JD-Core Version:    0.7.0.1
 */