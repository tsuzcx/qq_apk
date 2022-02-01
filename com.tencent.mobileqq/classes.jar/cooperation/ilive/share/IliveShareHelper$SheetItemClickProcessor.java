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
    switch (i)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return;
    case 2: 
      IliveShareHelper.access$200(this.this$0);
      return;
    case 3: 
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
    IliveShareHelper.access$400(this.this$0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.share.IliveShareHelper.SheetItemClickProcessor
 * JD-Core Version:    0.7.0.1
 */