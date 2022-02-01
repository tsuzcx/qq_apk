import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeShareView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import java.util.Iterator;
import java.util.List;

public class qed
  extends BaseAdapter
  implements bljm
{
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<ShareActionSheetBuilder.ActionSheetItem> jdField_a_of_type_JavaUtilList;
  private qee jdField_a_of_type_Qee;
  
  public qed(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public ShareActionSheetBuilder.ActionSheetItem a(int paramInt)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0))
    {
      localActionSheetItem = null;
      return localActionSheetItem;
    }
    int j = -1;
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label89;
      }
      localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)this.jdField_a_of_type_JavaUtilList.get(i);
      int k = j;
      if (localActionSheetItem != null)
      {
        k = j;
        if (localActionSheetItem.visibility == 0) {
          k = j + 1;
        }
      }
      if (k == paramInt) {
        break;
      }
      i += 1;
      j = k;
    }
    label89:
    return null;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
      if ((localActionSheetItem == null) || (localActionSheetItem.visibility != 0)) {
        break label60;
      }
      i += 1;
    }
    label60:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidContentResResources == null) {
      this.jdField_a_of_type_AndroidContentResResources = paramViewGroup.getContext().getResources();
    }
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentResResources.getDimension(2131296740));
    }
    if (this.jdField_a_of_type_Qee == null) {
      this.jdField_a_of_type_Qee = new qee(paramViewGroup.getContext());
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559982, paramViewGroup, false);
      localObject1 = new bbxf();
      ((bbxf)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377494));
      ((bbxf)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377495));
      paramView.setTag(localObject1);
      paramView.setFocusable(true);
    }
    for (;;)
    {
      ((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem = a(paramInt);
      if (((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem != null) {
        break;
      }
      QLog.e("NativeShareView", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = (bbxf)paramView.getTag();
    }
    paramView.setId(((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.id);
    Object localObject2 = ((bbxf)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    Object localObject3 = ((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label;
    int i;
    if (((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.firstLineCount > 0)
    {
      i = ((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.firstLineCount;
      label254:
      ((TextView)localObject2).setText(NativeShareView.a((String)localObject3, i));
      i = -16578534;
      localObject2 = ((bbxf)localObject1).jdField_a_of_type_AndroidWidgetTextView;
      if (!((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable) {
        break label505;
      }
      label288:
      ((TextView)localObject2).setTextColor(i);
      if (!((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconNeedBg) {
        break label574;
      }
      if (((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable == null) {
        break label512;
      }
      localObject2 = ((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable;
      label327:
      i = ((Drawable)localObject2).getIntrinsicWidth();
      int k = ((Drawable)localObject2).getIntrinsicHeight();
      if (this.jdField_a_of_type_Int <= i) {
        break label532;
      }
      i = (int)((this.jdField_a_of_type_Int - i) / 2.0F);
      label363:
      if (this.jdField_a_of_type_Int > k) {
        j = (int)((this.jdField_a_of_type_Int - k) / 2.0F);
      }
      localObject2 = this.jdField_a_of_type_Qee.a((Drawable)localObject2, i, j);
      if (!((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.enable) {
        break label538;
      }
      localObject3 = qee.a(this.jdField_a_of_type_Qee, (Drawable)localObject2);
      localObject2 = this.jdField_a_of_type_Qee.a((Drawable)localObject2, (Drawable)localObject3);
      ((bbxf)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      label445:
      if (Build.VERSION.SDK_INT < 16) {
        break label562;
      }
      ((bbxf)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
      label462:
      if (AppSetting.c) {
        if (((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label == null) {
          break label661;
        }
      }
    }
    label512:
    label532:
    label661:
    for (Object localObject1 = ((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.label;; localObject1 = "")
    {
      paramView.setContentDescription((CharSequence)localObject1);
      break;
      i = 6;
      break label254;
      label505:
      i = 2130905114;
      break label288;
      localObject2 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
      break label327;
      i = 0;
      break label363;
      label538:
      localObject2 = qee.b(this.jdField_a_of_type_Qee, (Drawable)localObject2);
      ((bbxf)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      break label445;
      label562:
      ((bbxf)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      break label462;
      label574:
      ((bbxf)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837562);
      if (((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable != null)
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          ((bbxf)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackground(((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
          break label462;
        }
        ((bbxf)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.iconDrawable);
        break label462;
      }
      ((bbxf)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(((bbxf)localObject1).jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$ActionSheetItem.icon);
      break label462;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qed
 * JD-Core Version:    0.7.0.1
 */