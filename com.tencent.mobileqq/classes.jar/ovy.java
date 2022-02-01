import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class ovy
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private HashSet<Long> jdField_a_of_type_JavaUtilHashSet;
  private ovv jdField_a_of_type_Ovv;
  private rii jdField_a_of_type_Rii;
  private TextView b;
  
  private void b()
  {
    if ((this.jdField_a_of_type_Rii != null) && (this.jdField_a_of_type_Rii.jdField_a_of_type_JavaUtilArrayList != null))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition())
      {
        if ((i >= 1) && (i <= this.jdField_a_of_type_Rii.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          rik localrik = (rik)this.jdField_a_of_type_Rii.jdField_a_of_type_JavaUtilArrayList.get(i - 1);
          pmh.a().a(Long.valueOf(localrik.a));
          this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(localrik.a));
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Rii == null) || (this.jdField_a_of_type_Rii.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Rii.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentWidgetListView != null) {
        this.jdField_a_of_type_ComTencentWidgetListView.removeHeaderView(this.jdField_a_of_type_AndroidViewView);
      }
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount() < 1)) {
      this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if ((this.jdField_a_of_type_Rii.jdField_a_of_type_Rij != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Rii.jdField_a_of_type_Rij.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Rii.jdField_a_of_type_Rij.jdField_a_of_type_JavaLangString);
      }
    }
    else
    {
      if ((this.b == null) || (this.jdField_a_of_type_Rii.b == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Rii.b.jdField_b_of_type_JavaLangString))) {
        break label272;
      }
      this.b.setVisibility(0);
      if (TextUtils.isEmpty(this.jdField_a_of_type_Rii.b.jdField_a_of_type_JavaLangString)) {
        break label257;
      }
      this.b.setText(this.jdField_a_of_type_Rii.b.jdField_a_of_type_JavaLangString);
      label220:
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Rii.b.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_a_of_type_Ovv.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131703457));
      break;
      label257:
      this.b.setText(anni.a(2131703458));
      break label220;
      label272:
      if (this.b != null)
      {
        this.b.setVisibility(8);
        this.jdField_a_of_type_JavaLangString = null;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    pha.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    str3 = "";
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", "" + pha.d);
        if (!bgnt.h(this.jdField_a_of_type_AndroidContentContext)) {
          continue;
        }
        str1 = "2";
        localJSONObject.put("network_type", str1);
        str1 = localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        String str1;
        localJSONException.printStackTrace();
        String str2 = str3;
        continue;
      }
      oat.a(null, "", "0X8008451", "0X8008451", 0, 0, "", "", "", str1, false);
      break;
      str1 = "1";
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt == 0) || (paramInt == this.jdField_a_of_type_Ovv.getCount() - 1)) {}
    rik localrik;
    do
    {
      do
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
      } while ((this.jdField_a_of_type_Rii == null) || (this.jdField_a_of_type_Rii.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 1) || (paramInt > this.jdField_a_of_type_Rii.jdField_a_of_type_JavaUtilArrayList.size()));
      localrik = (rik)this.jdField_a_of_type_Rii.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
    } while ((localrik == null) || (TextUtils.isEmpty(localrik.jdField_b_of_type_JavaLangString)));
    pha.a(this.jdField_a_of_type_AndroidContentContext, localrik.jdField_b_of_type_JavaLangString);
    str3 = "";
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", "" + pha.d);
        if (!bgnt.h(this.jdField_a_of_type_AndroidContentContext)) {
          continue;
        }
        str1 = "2";
        localJSONObject.put("network_type", str1);
        str1 = localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        String str1;
        localJSONException.printStackTrace();
        String str2 = str3;
        continue;
      }
      oat.a(null, "", "0X8008450", "0X8008450", 0, 0, String.valueOf(localrik.a), String.valueOf(paramInt - 1), String.valueOf(localrik.jdField_b_of_type_Int), str1, false);
      localrik.jdField_b_of_type_Int = 0;
      pmh.a().a(this.jdField_a_of_type_Rii);
      this.jdField_a_of_type_Ovv.a(this.jdField_a_of_type_Rii.jdField_a_of_type_JavaUtilArrayList);
      a();
      break;
      str1 = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovy
 * JD-Core Version:    0.7.0.1
 */