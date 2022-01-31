import android.view.View;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.newshare.mode.InfoCardShareMode;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.controller.QQStoryMemoriesPresenter;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class obc
  implements ActionSheet.OnButtonClickListener
{
  public obc(StoryMemoriesFragment paramStoryMemoriesFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d();
    paramInt = StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment, this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt));
    int j = StoryMemoriesFragment.a(StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_Int);
    String str1;
    label79:
    String str2;
    if (StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
    {
      paramView = "1";
      if (!StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip()) {
        break label231;
      }
      str1 = "1";
      if ((!StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isFriend()) && (!StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())) {
        break label238;
      }
      str2 = "1";
      label115:
      StoryReportor.a("memory", "clk_more_one", j, 0, new String[] { paramView, str1, str2, StoryMemoriesFragment.a(paramInt, StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe(), StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe()) });
      switch (paramInt)
      {
      }
    }
    label231:
    label238:
    do
    {
      return;
      paramView = "2";
      break;
      str1 = "2";
      break label79;
      str2 = "2";
      break label115;
      StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment.a(StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem);
      QQToast.a(PlayModeUtils.a(), 2, "更多资料", 0).a();
      return;
      if (StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe())
      {
        paramInt = 1;
        paramView = (QQStoryHandler)PlayModeUtils.a().a(98);
        if (!StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip()) {
          break label354;
        }
      }
      for (;;)
      {
        paramView.a(i, StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_JavaLangString, paramInt, 2);
        return;
        paramInt = 0;
        break;
        i = 0;
      }
      PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment.getActivity(), StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem, new obd(this));
      return;
      if (StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
      {
        StoryMemoriesFragment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment);
        return;
      }
      StoryMemoriesFragment.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment);
      return;
    } while (UIUtils.b());
    label354:
    if (StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment) == null) {
      StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment, StoryShare.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment.getActivity()));
    }
    StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).a(2131433114).a(new InfoCardShareMode(StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem)).a(new obe(this)).a();
    StoryReportor.a("memory", "clk_share", StoryMemoriesFragment.a(StoryMemoriesFragment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment).jdField_a_of_type_Int), 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obc
 * JD-Core Version:    0.7.0.1
 */