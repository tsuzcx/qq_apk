import com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager.1;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import cooperation.qzone.LocalMultiProcConfig;

public class sjs
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
  
  public static sjs a()
  {
    return sju.a();
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
      snb.d("WSRedDotPreloadManager", "sendRequest wsPushMsgData: null");
      return;
    }
    snb.d("WSRedDotPreloadManager", "=====realPreloadRedData redDotUinSeq=" + paramLong + ", wsPushMsgData.mMsgData=" + paramWSRedDotPushMsg.mMsgData);
    smv localsmv = new smv(null, (byte)0, (byte)1, null, 8, null, null, null, paramWSRedDotPushMsg.mMsgData);
    localsmv.b = String.valueOf(paramLong);
    paramWSRedDotPushMsg = new sls(localsmv, null, new sjt(this, paramWSRedDotPushMsg), 1001);
    this.jdField_a_of_type_Boolean = true;
    sll.a().a(paramWSRedDotPushMsg);
  }
  
  private void a(WSRedDotPushMsg paramWSRedDotPushMsg, long paramLong, int paramInt)
  {
    snb.b("WSRedDotPreloadManager", "checkSendRequest checkCount: " + paramInt);
    if (paramInt == 0) {
      return;
    }
    boolean bool = snf.a();
    snb.b("WSRedDotPreloadManager", "checkSendRequest inRealActionLoginB: " + bool);
    if (!bool)
    {
      a(paramWSRedDotPushMsg, paramLong);
      snb.b("WSRedDotPreloadManager", "checkSendRequest sendRequest!");
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable = new WSRedDotPreloadManager.1(this, paramWSRedDotPushMsg, paramLong, paramInt);
    sll.a().a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    snb.b("WSRedDotPreloadManager", "checkSendRequest postDelayed start!");
  }
  
  private void a(MessageForStructing paramMessageForStructing, WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    WSPushPreloadModel localWSPushPreloadModel = a(paramWSRedDotPushMsg);
    if ((localWSPushPreloadModel == null) || (!localWSPushPreloadModel.jdField_a_of_type_Boolean))
    {
      snb.d("WSRedDotPreloadManager", "preloadData wsPushPreloadModel:" + localWSPushPreloadModel + ", mHadCleanPreCache:" + this.b);
      if (!this.b) {
        sjv.a().a();
      }
      this.b = true;
    }
    do
    {
      return;
      snb.b("WSRedDotPreloadManager", "preloadData mCurrentUniSeq=structMsg.uniSeq: " + paramMessageForStructing.uniseq);
      if (this.jdField_a_of_type_Long != paramMessageForStructing.uniseq) {
        break;
      }
    } while (this.jdField_a_of_type_Boolean);
    if (sjv.a().a())
    {
      snb.d("WSRedDotPreloadManager", "preloadData isRedCacheInValidDuration: true");
      return;
    }
    snb.d("WSRedDotPreloadManager", "preloadData mIsPreloadOutValidDuration: " + localWSPushPreloadModel.b);
    if (!localWSPushPreloadModel.b)
    {
      snb.d("WSRedDotPreloadManager", "preloadData mIsPreloadOutValidDuration: false");
      return;
      a(paramMessageForStructing.uniseq);
    }
    snb.d("WSRedDotPreloadManager", "preloadData mCurrentUniSeq: " + this.jdField_a_of_type_Long + ", mIsSendingRequest: " + this.jdField_a_of_type_Boolean);
    b();
    a(paramWSRedDotPushMsg, this.jdField_a_of_type_Long, 3);
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        snb.b("WSRedDotPreloadManager", "===startPreloadRedData===");
        Object localObject = snf.a();
        if (localObject == null)
        {
          snb.d("WSRedDotPreloadManager", "preloadData weishiMgr: null");
          return;
        }
        localObject = ((otm)localObject).a();
        if (localObject == null) {
          continue;
        }
        WSRedDotPushMsg localWSRedDotPushMsg = snf.a((MessageForStructing)localObject);
        if (localWSRedDotPushMsg == null)
        {
          snb.d("WSRedDotPreloadManager", "preloadData wsPushMsgData: null");
          continue;
        }
        a(localMessageForStructing, localWSRedDotPushMsg);
      }
      finally {}
      sjc.a().a();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      sll.a().b(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
      snb.b("WSRedDotPreloadManager", "===== cancelPostDelayRunnable ! =====");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjs
 * JD-Core Version:    0.7.0.1
 */