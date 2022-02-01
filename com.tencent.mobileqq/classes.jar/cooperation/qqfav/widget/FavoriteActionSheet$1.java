package cooperation.qqfav.widget;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class FavoriteActionSheet$1
  implements ShareActionSheet.OnItemClickListener
{
  FavoriteActionSheet$1(FavoriteActionSheet paramFavoriteActionSheet) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramShareActionSheet != null) {
      paramShareActionSheet.dismiss();
    }
    int i = paramActionSheetItem.action;
    this.a.a(i, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.widget.FavoriteActionSheet.1
 * JD-Core Version:    0.7.0.1
 */