import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.handler.AccountDetailBaseItemClickHandler;

public class kqc
  implements View.OnClickListener
{
  public kqc(AccountDetailBaseItemClickHandler paramAccountDetailBaseItemClickHandler, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
    AccountDetailBaseItemClickHandler.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailHandlerAccountDetailBaseItemClickHandler).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqc
 * JD-Core Version:    0.7.0.1
 */