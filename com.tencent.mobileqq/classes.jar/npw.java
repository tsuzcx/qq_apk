import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class npw
  implements bcww
{
  npw(String paramString, shc paramshc) {}
  
  public void a(BaseResp paramBaseResp)
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
      wij.b(1, 2131719487);
      bool = false;
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      if (this.jdField_a_of_type_Shc == null) {
        break;
      }
      this.jdField_a_of_type_Shc.a(bool);
      return;
      wij.b(2, 2131719506);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npw
 * JD-Core Version:    0.7.0.1
 */