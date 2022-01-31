import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class tfg
  implements bbsh
{
  tfg(String paramString, tcp paramtcp, tex paramtex) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramBaseResp.transaction)) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -3: 
    case -1: 
    default: 
      if (this.jdField_a_of_type_Tcp != null) {
        this.jdField_a_of_type_Tcp.b(this.jdField_a_of_type_Tex);
      }
      break;
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      if (this.jdField_a_of_type_Tcp != null)
      {
        this.jdField_a_of_type_Tcp.a(this.jdField_a_of_type_Tex);
        continue;
        if (this.jdField_a_of_type_Tcp != null)
        {
          this.jdField_a_of_type_Tcp.c(this.jdField_a_of_type_Tex);
          continue;
          if (this.jdField_a_of_type_Tcp != null) {
            this.jdField_a_of_type_Tcp.b(this.jdField_a_of_type_Tex);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfg
 * JD-Core Version:    0.7.0.1
 */