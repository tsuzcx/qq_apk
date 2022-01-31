import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.4;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class szf
  implements osn
{
  public szf(ReadInjoyWebShareHelper.4 param4) {}
  
  public void a(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((this.a.this$0.a == null) || (!this.a.this$0.a.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      ybk.a(1, 2131720031);
      bool = false;
    }
    while (this.a.a)
    {
      szc.a(this.a.this$0, "we_chat", bool);
      return;
      ybk.a(2, 2131720050);
      continue;
      bool = false;
    }
    szc.a(this.a.this$0, "we_chat_circle", bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     szf
 * JD-Core Version:    0.7.0.1
 */