import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class ney
  implements bbsh
{
  ney(String paramString, run paramrun) {}
  
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
      vvp.b(1, 2131653595);
      bool = false;
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      if (this.jdField_a_of_type_Run == null) {
        break;
      }
      this.jdField_a_of_type_Run.a(bool);
      return;
      vvp.b(2, 2131653612);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ney
 * JD-Core Version:    0.7.0.1
 */