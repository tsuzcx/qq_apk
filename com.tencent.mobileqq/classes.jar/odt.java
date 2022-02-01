import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class odt
  implements bjig
{
  odt(String paramString, uap paramuap) {}
  
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
      zyx.b(1, 2131718139);
      bool = false;
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      if (this.jdField_a_of_type_Uap == null) {
        break;
      }
      this.jdField_a_of_type_Uap.a(bool);
      return;
      zyx.b(2, 2131718157);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odt
 * JD-Core Version:    0.7.0.1
 */