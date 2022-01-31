import com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager.1;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import cooperation.qzone.LocalMultiProcConfig;

public class rwz
{
  private long jdField_a_of_type_Long = LocalMultiProcConfig.getLong("weishi_usergrowth", "key_red_dot_msg_uin", 0L);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private long a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    paramWSRedDotPushMsg = a(paramWSRedDotPushMsg);
    if (paramWSRedDotPushMsg != null) {
      return paramWSRedDotPushMsg.jdField_a_of_type_Long;
    }
    return 7200000L;
  }
  
  private WSPushPreloadModel a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    if (paramWSRedDotPushMsg == null) {}
    while (!(paramWSRedDotPushMsg.mStrategyInfo instanceof WSPushStrategyInfo)) {
      return null;
    }
    return ((WSPushStrategyInfo)paramWSRedDotPushMsg.mStrategyInfo).mWSPushPreloadModel;
  }
  
  public static rwz a()
  {
    return rxb.a();
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = false;
    LocalMultiProcConfig.putLong("weishi_usergrowth", "key_red_dot_msg_uin", this.jdField_a_of_type_Long);
  }
  
  private void a(WSRedDotPushMsg paramWSRedDotPushMsg, long paramLong)
  {
    if (paramWSRedDotPushMsg == null)
    {
      sai.d("WSRedDotPreloadManager", "sendRequest wsPushMsgData: null");
      return;
    }
    sai.d("WSRedDotPreloadManager", "=====realPreloadRedData redDotUinSeq=" + paramLong + ", wsPushMsgData.mMsgData=" + paramWSRedDotPushMsg.mMsgData);
    sac localsac = new sac(null, (byte)0, (byte)1, null, 8, null, null, null, paramWSRedDotPushMsg.mMsgData);
    localsac.b = String.valueOf(paramLong);
    paramWSRedDotPushMsg = new ryz(localsac, null, new rxa(this, paramWSRedDotPushMsg), 1001);
    this.jdField_a_of_type_Boolean = true;
    rys.a().a(paramWSRedDotPushMsg);
  }
  
  private void a(WSRedDotPushMsg paramWSRedDotPushMsg, long paramLong, int paramInt)
  {
    sai.b("WSRedDotPreloadManager", "checkSendRequest checkCount: " + paramInt);
    if (paramInt == 0) {
      return;
    }
    boolean bool = sam.a();
    sai.b("WSRedDotPreloadManager", "checkSendRequest inRealActionLoginB: " + bool);
    if (!bool)
    {
      a(paramWSRedDotPushMsg, paramLong);
      sai.b("WSRedDotPreloadManager", "checkSendRequest sendRequest!");
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable = new WSRedDotPreloadManager.1(this, paramWSRedDotPushMsg, paramLong, paramInt);
    rys.a().a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    sai.b("WSRedDotPreloadManager", "checkSendRequest postDelayed start!");
  }
  
  public void a()
  {
    for (;;)
    {
      WSRedDotPushMsg localWSRedDotPushMsg;
      try
      {
        sai.b("WSRedDotPreloadManager", "===startPreloadRedData===");
        Object localObject1 = sam.a();
        if (localObject1 == null)
        {
          sai.d("WSRedDotPreloadManager", "preloadData weishiMgr: null");
          return;
        }
        localObject1 = ((oie)localObject1).a();
        if (localObject1 == null) {
          continue;
        }
        localWSRedDotPushMsg = sam.a((MessageForStructing)localObject1);
        if (localWSRedDotPushMsg == null)
        {
          sai.d("WSRedDotPreloadManager", "preloadData wsPushMsgData: null");
          continue;
        }
        localWSPushPreloadModel = a(localWSRedDotPushMsg);
      }
      finally {}
      WSPushPreloadModel localWSPushPreloadModel;
      if ((localWSPushPreloadModel == null) || (!localWSPushPreloadModel.jdField_a_of_type_Boolean))
      {
        sai.d("WSRedDotPreloadManager", "preloadData wsPushPreloadModel:" + localWSPushPreloadModel + ", mHadCleanPreCache:" + this.b);
        if (!this.b) {
          rxc.a().a();
        }
        this.b = true;
      }
      else
      {
        sai.b("WSRedDotPreloadManager", "preloadData mCurrentUniSeq=structMsg.uniSeq: " + localObject2.uniseq);
        if (this.jdField_a_of_type_Long == localObject2.uniseq)
        {
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          if (rxc.a().a())
          {
            sai.d("WSRedDotPreloadManager", "preloadData isRedCacheInValidDuration: true");
            continue;
          }
          sai.d("WSRedDotPreloadManager", "preloadData mIsPreloadOutValidDuration: " + localWSPushPreloadModel.b);
          if (!localWSPushPreloadModel.b) {
            sai.d("WSRedDotPreloadManager", "preloadData mIsPreloadOutValidDuration: false");
          }
        }
        else
        {
          a(localObject2.uniseq);
        }
        sai.d("WSRedDotPreloadManager", "preloadData mCurrentUniSeq: " + this.jdField_a_of_type_Long + ", mIsSendingRequest: " + this.jdField_a_of_type_Boolean);
        b();
        a(localWSRedDotPushMsg, this.jdField_a_of_type_Long, 3);
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      rys.a().b(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
      sai.b("WSRedDotPreloadManager", "===== cancelPostDelayRunnable ! =====");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rwz
 * JD-Core Version:    0.7.0.1
 */