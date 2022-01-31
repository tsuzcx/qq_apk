import NS_KING_INTERFACE.stPostFeedDingRsp;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.qphone.base.util.BaseApplication;

final class slx
  implements slk
{
  slx(Handler paramHandler, int paramInt) {}
  
  public void a(slv paramslv)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    if ((paramslv == null) || (paramslv.jdField_a_of_type_JavaLangObject == null))
    {
      localMessage.what = 4302;
      localMessage.obj = Integer.valueOf(-1);
      Log.e(slw.a, "点赞失败:-1");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
      if ((paramslv.jdField_a_of_type_JavaLangObject instanceof stPostFeedDingRsp))
      {
        stPostFeedDingRsp localstPostFeedDingRsp = (stPostFeedDingRsp)paramslv.jdField_a_of_type_JavaLangObject;
        if (localstPostFeedDingRsp == null)
        {
          Log.e(slw.a, "服务器失败！！！");
          localMessage.what = 4302;
          localMessage.obj = Integer.valueOf(paramslv.jdField_a_of_type_Int);
        }
        else
        {
          int i = localstPostFeedDingRsp.is_ding;
          localMessage.what = 4301;
          localMessage.obj = Integer.valueOf(i);
          paramslv = new Intent("weishi_public_account_ding_state_change");
          paramslv.putExtra("position", this.jdField_a_of_type_Int);
          paramslv.putExtra("is_ding", i);
          BaseApplication.getContext().sendBroadcast(paramslv);
          Log.e(slw.a, "发送了点赞广播");
          if (i == 0) {
            Log.e(slw.a, "请求后变成：没有点赞-by微视");
          } else {
            Log.e(slw.a, "请求后变成：已经点赞-by微视");
          }
        }
      }
      else
      {
        Log.e(slw.a, "点赞失败:-2");
        localMessage.what = 4302;
        localMessage.obj = Integer.valueOf(-2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     slx
 * JD-Core Version:    0.7.0.1
 */