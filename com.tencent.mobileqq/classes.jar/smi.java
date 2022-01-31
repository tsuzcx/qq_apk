import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class smi
  extends smh<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int a;
  
  public smi(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt)
  {
    super(paramWSRedDotPushMsg);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    int i = 2;
    boolean bool1 = true;
    if (paramWSPushStrategyInfo == null) {
      return false;
    }
    boolean bool2 = TextUtils.isEmpty(paramWSPushStrategyInfo.mScheme);
    if (!bool2)
    {
      sjp.a(paramContext, paramWSPushStrategyInfo.mScheme);
      paramContext = snf.a();
      if (paramContext != null) {
        paramContext.a(null);
      }
      snf.a();
    }
    if (this.jdField_a_of_type_Int == 2) {
      if (bool2)
      {
        i = 2;
        if (this.jdField_a_of_type_Sma != null) {
          break label93;
        }
        paramContext = "";
        label74:
        smp.a(i, 1, paramContext);
        label80:
        if (bool2) {
          break label133;
        }
      }
    }
    for (;;)
    {
      return bool1;
      i = 1;
      break;
      label93:
      paramContext = ((WSRedDotPushMsg)this.jdField_a_of_type_Sma).mFeedIds;
      break label74;
      if (this.jdField_a_of_type_Int != 6) {
        break label80;
      }
      if (bool2) {}
      for (;;)
      {
        smp.d(i);
        break;
        i = 1;
      }
      label133:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     smi
 * JD-Core Version:    0.7.0.1
 */