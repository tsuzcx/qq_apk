package cooperation.qwallet.plugin;

public abstract interface FakeUrl$FakeListener
{
  public static final int BNT_INDEX_LEFT = 0;
  public static final int BNT_INDEX_RIGHT = 1;
  
  public abstract boolean onBlHandleFakeurl(FakeUrl.FakeInfo paramFakeInfo, int paramInt);
  
  public abstract boolean onClickUrl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qwallet.plugin.FakeUrl.FakeListener
 * JD-Core Version:    0.7.0.1
 */