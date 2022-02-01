package cooperation.ilive.share;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import org.json.JSONException;

class IliveShareHelper$SheetItemClickProcessor
  implements ShareActionSheet.OnItemClickListener
{
  IliveShareHelper$SheetItemClickProcessor(IliveShareHelper paramIliveShareHelper) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.this$0.dismiss();
    if (this.this$0.mHostActivity == null) {
      return;
    }
    int i = paramActionSheetItem.action;
    if (i != 2)
    {
      if (i != 3)
      {
        if ((i != 9) && (i != 10)) {
          return;
        }
        IliveShareHelper.access$400(this.this$0, i);
        return;
      }
      try
      {
        IliveShareHelper.access$300(this.this$0);
        return;
      }
      catch (JSONException paramActionSheetItem)
      {
        paramActionSheetItem.printStackTrace();
        return;
      }
    }
    IliveShareHelper.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.share.IliveShareHelper.SheetItemClickProcessor
 * JD-Core Version:    0.7.0.1
 */