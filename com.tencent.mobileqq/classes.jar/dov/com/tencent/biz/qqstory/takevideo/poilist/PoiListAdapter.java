package dov.com.tencent.biz.qqstory.takevideo.poilist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class PoiListAdapter
  extends XBaseAdapter
{
  public static final TroopBarPOI a;
  protected LayoutInflater a;
  protected ArrayList a;
  protected TroopBarPOI b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI("-1", "", "不显示位置", 0, "", 0, "");
  }
  
  public PoiListAdapter(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(ArrayList paramArrayList, TroopBarPOI paramTroopBarPOI)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (paramTroopBarPOI != null) {
      this.b = new TroopBarPOI(paramTroopBarPOI);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopBarPOI localTroopBarPOI;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968948, null);
      paramViewGroup = new QQStoryPoiListAdapter.ViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364337));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364336));
      paramView.setTag(paramViewGroup);
      localTroopBarPOI = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopBarPOI.c);
      paramViewGroup = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      if (!localTroopBarPOI.equals(this.b)) {
        break label135;
      }
    }
    label135:
    for (paramInt = 0;; paramInt = 8)
    {
      paramViewGroup.setVisibility(paramInt);
      paramView.setContentDescription(localTroopBarPOI.c);
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      return paramView;
      paramViewGroup = (QQStoryPoiListAdapter.ViewHolder)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.poilist.PoiListAdapter
 * JD-Core Version:    0.7.0.1
 */