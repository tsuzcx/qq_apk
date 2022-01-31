import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;

final class tge
  implements begw
{
  tge(CommentEntry paramCommentEntry, begr parambegr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramView = "16384";
      QQUserUIItem localQQUserUIItem = ((sqs)sqg.a(2)).b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.authorUnionId);
      if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.qq))) {
        new syc().a(localQQUserUIItem.qq, localQQUserUIItem.isFriend(), paramView, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.content);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_Begr.dismiss();
      return;
      paramView = "2";
      break;
      paramView = "1";
      break;
      paramView = "4";
      break;
      urk.d("Q.qqstory.player.PlayModeUtils", "report comment error because evil uin is empty.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tge
 * JD-Core Version:    0.7.0.1
 */