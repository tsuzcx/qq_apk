import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

final class ofg
  implements WXShareHelper.WXShareListener
{
  ofg(String paramString, uhe paramuhe) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramBaseResp.transaction))) {
      return;
    }
    BaseApplicationImpl.getContext();
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      yyi.b(1, 2131718380);
      bool = false;
    }
    for (;;)
    {
      WXShareHelper.getInstance().removeObserver(this);
      if (this.jdField_a_of_type_Uhe == null) {
        break;
      }
      this.jdField_a_of_type_Uhe.a(bool);
      return;
      yyi.b(2, 2131718398);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofg
 * JD-Core Version:    0.7.0.1
 */