import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class lob
  implements bbsh
{
  lob(loa paramloa, String paramString, Context paramContext, int paramInt1, int paramInt2) {}
  
  public void a(BaseResp paramBaseResp)
  {
    int i = 2;
    QLog.w("ShareChat", 1, "onWXShareResp, mWXTransaction[" + this.jdField_a_of_type_JavaLangString + "], transaction[" + paramBaseResp.transaction + "], errCode[" + paramBaseResp.errCode + "], seq[" + this.jdField_a_of_type_Loa.a + "]");
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)) {
      return;
    }
    loa localloa;
    int j;
    int k;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131653595), 0).a();
    case -2: 
      WXShareHelper.a().b(this);
      localloa = this.jdField_a_of_type_Loa;
      j = this.jdField_a_of_type_Int;
      k = this.b;
      if (paramBaseResp.errCode != 0) {
        break;
      }
    }
    for (;;)
    {
      localloa.a(j, k, i);
      return;
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2, this.jdField_a_of_type_AndroidContentContext.getString(2131653612), 0).a();
      break;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lob
 * JD-Core Version:    0.7.0.1
 */