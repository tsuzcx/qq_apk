import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

public class spk
  extends syv
{
  public spk(BridgeModule paramBridgeModule) {}
  
  public ShareActionSheetBuilder.ActionSheetItem a(Integer paramInteger)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = super.a(paramInteger);
    if ((paramInteger.intValue() == 11) && (localActionSheetItem != null))
    {
      localActionSheetItem.icon = 2130843856;
      localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131693497);
    }
    return localActionSheetItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     spk
 * JD-Core Version:    0.7.0.1
 */