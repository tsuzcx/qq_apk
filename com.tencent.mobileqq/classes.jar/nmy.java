import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.VideoInfoObserver;
import com.tencent.biz.qqstory.playvideo.QQStoryWarningActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.mobileqq.widget.QQToast;

public final class nmy
  extends PlayModeUtils.VideoInfoObserver
{
  public nmy(Activity paramActivity, String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString2, int paramInt4) {}
  
  public void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    if ((paramInt == 0) && (paramStoryVideoItem != null))
    {
      StoryPlayVideoActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mOwnerUid, "", this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_b_of_type_Int, this.c, this.jdField_b_of_type_JavaLangString, this.d);
      return;
    }
    if (paramInt == 10100)
    {
      paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryWarningActivity.class);
      paramString.putExtra("tipsResource", "该视频已被删除");
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, paramString, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, "拉取视频出错：" + paramInt, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmy
 * JD-Core Version:    0.7.0.1
 */