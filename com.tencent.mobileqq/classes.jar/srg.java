import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.lang.ref.WeakReference;
import java.util.List;

public class srg
  implements AdapterView.OnItemClickListener
{
  public srg(EmosmActivity paramEmosmActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Boolean) {}
    EmoticonPackage localEmoticonPackage;
    do
    {
      return;
      localEmoticonPackage = (EmoticonPackage)this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getItem(paramInt);
      if (this.a.b)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(paramInt);
        this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
        paramAdapterView = this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a();
        if ((paramAdapterView != null) && (paramAdapterView.size() > 0))
        {
          this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          return;
        }
        this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
    } while (!EmosmUtils.a(this.a));
    this.a.jdField_a_of_type_Boolean = true;
    paramAdapterView = localEmoticonPackage.epId;
    boolean bool1 = false;
    if (localEmoticonPackage.jobType == 2)
    {
      paramAdapterView = localEmoticonPackage.kinId;
      bool1 = true;
    }
    paramView = null;
    if (localEmoticonPackage.jobType == 4)
    {
      paramView = new Intent();
      paramView.putExtra("EXTRA_KEY_IS_SMALL_EMOTICON", true);
    }
    boolean bool2;
    if (localEmoticonPackage.jobType == 4)
    {
      bool2 = true;
      if (1 != this.a.getIntent().getExtras().getInt("emojimall_src", 3)) {
        break label284;
      }
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.app.getAccount(), 8, paramAdapterView, bool1, paramView, bool2);
    }
    for (;;)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "ep_mall", "Clk_ep_mine_detail", 0, 0, localEmoticonPackage.epId, "", "", "");
      return;
      bool2 = false;
      break;
      label284:
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.app.getAccount(), 4, paramAdapterView, bool1, paramView, bool2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     srg
 * JD-Core Version:    0.7.0.1
 */