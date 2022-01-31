import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;

public class rzs
  extends rzo<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  
  public rzs(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
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
      sam.a(paramContext, null, 0, null, null, (WSRedDotPushMsg)this.jdField_a_of_type_Rzh, 2);
      paramWSPushStrategyInfo = sam.a();
      if ((paramWSPushStrategyInfo != null) && ((paramContext instanceof Activity))) {
        paramWSPushStrategyInfo.a((Activity)paramContext);
      }
      sam.a();
      bool = true;
    }
    while (this.jdField_a_of_type_Int != 6) {
      return bool;
    }
    rww.a((Activity)paramContext, this.jdField_a_of_type_AndroidContentIntent, (WSRedDotPushMsg)this.jdField_a_of_type_Rzh);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rzs
 * JD-Core Version:    0.7.0.1
 */