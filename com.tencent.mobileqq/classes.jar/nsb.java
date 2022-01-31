import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity.ButtonConfig;
import com.tencent.biz.qqstory.storyHome.discover.view.StoryDiscoverActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public final class nsb
  implements View.OnClickListener
{
  public nsb(QQStoryMainActivity.ButtonConfig paramButtonConfig, Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity$ButtonConfig.c)) && (HttpUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity$ButtonConfig.c))) {}
    for (paramView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity$ButtonConfig.c; this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity$ButtonConfig.a == 1; paramView = "https://story.now.qq.com/mobile/find.html?_wv=3&_bid=2542")
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      StoryReportor.a("hall", "exp", 0, 0, new String[] { "" });
      if (!"troopStoryHallConfig".equals(this.jdField_a_of_type_JavaLangString)) {
        break label195;
      }
      StoryReportor.a("story_grp", "clk_find_left", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity$ButtonConfig.a == 2) {
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof TroopStoryMainActivity)) {
        break label209;
      }
    }
    label195:
    label209:
    for (int i = 2;; i = 1)
    {
      StoryDiscoverActivity.a(this.jdField_a_of_type_AndroidAppActivity, "日迹", i);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity$ButtonConfig.a != 3) {
        break;
      }
      break;
      StoryReportor.a("home_page", "clk_find_entry", 0, 0, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsb
 * JD-Core Version:    0.7.0.1
 */