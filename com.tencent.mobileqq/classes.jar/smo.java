import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class smo
  extends smk<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  
  public smo(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    super(paramWSRedDotPushMsg);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Int == 2)
    {
      sni.a(paramContext, null, 0, null, null, (WSRedDotPushMsg)this.jdField_a_of_type_Smd, 2);
      paramWSPushStrategyInfo = sni.a();
      if ((paramWSPushStrategyInfo != null) && ((paramContext instanceof Activity))) {
        paramWSPushStrategyInfo.a((Activity)paramContext);
      }
      sni.a();
      bool = true;
    }
    while (this.jdField_a_of_type_Int != 6) {
      return bool;
    }
    sjs.a((Activity)paramContext, this.jdField_a_of_type_AndroidContentIntent, (WSRedDotPushMsg)this.jdField_a_of_type_Smd);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     smo
 * JD-Core Version:    0.7.0.1
 */