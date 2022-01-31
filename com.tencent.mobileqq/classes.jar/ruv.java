import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.4;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class ruv
  implements ocu
{
  public ruv(ReadInjoyWebShareHelper.4 param4) {}
  
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
      vvp.a(1, 2131653595);
      bool = false;
    }
    while (this.a.a)
    {
      rus.a(this.a.this$0, "we_chat", bool);
      return;
      vvp.a(2, 2131653612);
      continue;
      bool = false;
    }
    rus.a(this.a.this$0, "we_chat_circle", bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ruv
 * JD-Core Version:    0.7.0.1
 */