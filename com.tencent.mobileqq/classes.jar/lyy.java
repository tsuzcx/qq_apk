import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class lyy
  implements bjig
{
  lyy(lyw paramlyw, String paramString, Context paramContext, int paramInt1, int paramInt2) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    int i = 2;
    QLog.w("ShareChat", 1, "onWXShareResp, mWXTransaction[" + this.jdField_a_of_type_JavaLangString + "], transaction[" + paramBaseResp.transaction + "], errCode[" + paramBaseResp.errCode + "], seq[" + this.jdField_a_of_type_Lyw.a + "]");
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)) {
      return;
    }
    lyw locallyw;
    int j;
    int k;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131718139), 0).a();
    case -2: 
      WXShareHelper.a().b(this);
      locallyw = this.jdField_a_of_type_Lyw;
      j = this.jdField_a_of_type_Int;
      k = this.b;
      if (paramBaseResp.errCode != 0) {
        break;
      }
    }
    for (;;)
    {
      locallyw.a(j, k, i);
      return;
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_AndroidContentContext.getString(2131718157), 0).a();
      break;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lyy
 * JD-Core Version:    0.7.0.1
 */