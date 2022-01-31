import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import java.io.File;

public class onp
  extends ont
{
  public onp(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    super(paramTroopStoryMemoriesListAdapter, paramView);
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
  {
    TroopStoryMemoriesListAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter, paramTroopStoryItemInfo, this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_AndroidWidgetTextView);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.getResources().getDrawable(2130843797);
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "troop_story_message";
      localObject = URLDrawable.getDrawable(new File(paramTroopStoryItemInfo.videoThumbUrl), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 50.0F), UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 70.0F), UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a, 3.0F)));
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.g);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      localDrawable = this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.getResources().getDrawable(2130843794);
      localDrawable.setBounds(0, 0, 26, 26);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("上传失败, 点击重试");
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-65536);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new onq(this, paramTroopStoryItemInfo));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(localDrawable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     onp
 * JD-Core Version:    0.7.0.1
 */