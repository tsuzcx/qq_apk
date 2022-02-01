package cooperation.qwallet.plugin.impl;

import cooperation.qwallet.plugin.IFakeUrl.FakeInfo;
import cooperation.qwallet.plugin.IFakeUrl.FakeListener;

public abstract class FakeUrlImpl$FakeAdapter
  implements IFakeUrl.FakeListener
{
  public boolean onBlHandleFakeurl(IFakeUrl.FakeInfo paramFakeInfo, int paramInt)
  {
    return false;
  }
  
  public boolean onClickUrl(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.FakeUrlImpl.FakeAdapter
 * JD-Core Version:    0.7.0.1
 */