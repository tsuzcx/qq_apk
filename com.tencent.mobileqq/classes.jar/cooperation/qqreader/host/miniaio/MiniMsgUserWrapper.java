package cooperation.qqreader.host.miniaio;

import android.content.ContextWrapper;
import bjbm;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;

public class MiniMsgUserWrapper
{
  private MiniMsgUser a;
  
  public MiniMsgUserWrapper(ContextWrapper paramContextWrapper, MiniMsgUserParamWrapper paramMiniMsgUserParamWrapper)
  {
    paramContextWrapper = bjbm.a(paramContextWrapper);
    if (paramContextWrapper != null) {
      this.a = new MiniMsgUser(paramContextWrapper, paramMiniMsgUserParamWrapper.mParam);
    }
  }
  
  public void destroy()
  {
    if (this.a != null) {
      this.a.destroy();
    }
  }
  
  public void onBackground()
  {
    if (this.a != null) {
      this.a.onBackground();
    }
  }
  
  public void onForeground()
  {
    if (this.a != null) {
      this.a.onForeground();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.miniaio.MiniMsgUserWrapper
 * JD-Core Version:    0.7.0.1
 */