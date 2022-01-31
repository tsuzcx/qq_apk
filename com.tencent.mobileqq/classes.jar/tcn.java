import com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager.1;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import cooperation.qzone.LocalMultiProcConfig;

public class tcn
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
  
  public static tcn a()
  {
    return tcp.a();
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
      tlo.d("WSRedDotPreloadManager", "sendRequest wsPushMsgData: null");
      return;
    }
    tlo.d("WSRedDotPreloadManager", "=====realPreloadRedData redDotUinSeq=" + paramLong + ", wsPushMsgData.mMsgData=" + paramWSRedDotPushMsg.mMsgData);
    tkn localtkn = new tkn(null, (byte)0, (byte)1, null, 8, null, null, null, paramWSRedDotPushMsg.mMsgData);
    localtkn.b = String.valueOf(paramLong);
    paramWSRedDotPushMsg = new the(localtkn, null, new tco(this, paramWSRedDotPushMsg), 1001);
    this.jdField_a_of_type_Boolean = true;
    tgx.a().a(paramWSRedDotPushMsg);
  }
  
  private void a(WSRedDotPushMsg paramWSRedDotPushMsg, long paramLong, int paramInt)
  {
    tlo.b("WSRedDotPreloadManager", "checkSendRequest checkCount: " + paramInt);
    if (paramInt == 0) {
      return;
    }
    boolean bool = tlv.a();
    tlo.b("WSRedDotPreloadManager", "checkSendRequest inRealActionLoginB: " + bool);
    if (!bool)
    {
      a(paramWSRedDotPushMsg, paramLong);
      tlo.b("WSRedDotPreloadManager", "checkSendRequest sendRequest!");
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable = new WSRedDotPreloadManager.1(this, paramWSRedDotPushMsg, paramLong, paramInt);
    tgx.a().a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    tlo.b("WSRedDotPreloadManager", "checkSendRequest postDelayed start!");
  }
  
  private void a(MessageForStructing paramMessageForStructing, WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    WSPushPreloadModel localWSPushPreloadModel = a(paramWSRedDotPushMsg);
    if ((localWSPushPreloadModel == null) || (!localWSPushPreloadModel.jdField_a_of_type_Boolean))
    {
      tlo.d("WSRedDotPreloadManager", "preloadData wsPushPreloadModel:" + localWSPushPreloadModel + ", mHadCleanPreCache:" + this.b);
      if (!this.b) {
        tcq.a().a();
      }
      this.b = true;
    }
    do
    {
      return;
      tlo.b("WSRedDotPreloadManager", "preloadData mCurrentUniSeq=structMsg.uniSeq: " + paramMessageForStructing.uniseq);
      if (this.jdField_a_of_type_Long != paramMessageForStructing.uniseq) {
        break;
      }
    } while (this.jdField_a_of_type_Boolean);
    if (tcq.a().a())
    {
      tlo.d("WSRedDotPreloadManager", "preloadData isRedCacheInValidDuration: true");
      return;
    }
    tlo.d("WSRedDotPreloadManager", "preloadData mIsPreloadOutValidDuration: " + localWSPushPreloadModel.b);
    if (!localWSPushPreloadModel.b)
    {
      tlo.d("WSRedDotPreloadManager", "preloadData mIsPreloadOutValidDuration: false");
      return;
      a(paramMessageForStructing.uniseq);
    }
    tlo.d("WSRedDotPreloadManager", "preloadData mCurrentUniSeq: " + this.jdField_a_of_type_Long + ", mIsSendingRequest: " + this.jdField_a_of_type_Boolean);
    b();
    a(paramWSRedDotPushMsg, this.jdField_a_of_type_Long, 3);
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        tlo.b("WSRedDotPreloadManager", "===startPreloadRedData===");
        Object localObject = tlv.a();
        if (localObject == null)
        {
          tlo.d("WSRedDotPreloadManager", "preloadData weishiMgr: null");
          return;
        }
        localObject = ((oye)localObject).a();
        if (localObject == null) {
          continue;
        }
        WSRedDotPushMsg localWSRedDotPushMsg = tlv.a((MessageForStructing)localObject);
        if (localWSRedDotPushMsg == null)
        {
          tlo.d("WSRedDotPreloadManager", "preloadData wsPushMsgData: null");
          continue;
        }
        a(localMessageForStructing, localWSRedDotPushMsg);
      }
      finally {}
      tbv.a().a();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      tgx.a().b(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
      tlo.b("WSRedDotPreloadManager", "===== cancelPostDelayRunnable ! =====");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tcn
 * JD-Core Version:    0.7.0.1
 */