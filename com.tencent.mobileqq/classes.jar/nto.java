import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class nto
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private HashSet<Long> jdField_a_of_type_JavaUtilHashSet;
  private ntl jdField_a_of_type_Ntl;
  private prv jdField_a_of_type_Prv;
  private TextView b;
  
  private void b()
  {
    if ((this.jdField_a_of_type_Prv != null) && (this.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList != null))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition())
      {
        if ((i >= 1) && (i <= this.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          prx localprx = (prx)this.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList.get(i - 1);
          ogy.a().a(Long.valueOf(localprx.a));
          this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(localprx.a));
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Prv == null) || (this.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList.size() == 0))
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
      if ((this.jdField_a_of_type_Prv.jdField_a_of_type_Prw != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Prv.jdField_a_of_type_Prw.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Prv.jdField_a_of_type_Prw.jdField_a_of_type_JavaLangString);
      }
    }
    else
    {
      if ((this.b == null) || (this.jdField_a_of_type_Prv.b == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Prv.b.jdField_b_of_type_JavaLangString))) {
        break label272;
      }
      this.b.setVisibility(0);
      if (TextUtils.isEmpty(this.jdField_a_of_type_Prv.b.jdField_a_of_type_JavaLangString)) {
        break label257;
      }
      this.b.setText(this.jdField_a_of_type_Prv.b.jdField_a_of_type_JavaLangString);
      label220:
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Prv.b.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_a_of_type_Ntl.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131638881));
      break;
      label257:
      this.b.setText(ajjy.a(2131638882));
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
      return;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
    obz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    str = "";
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", "" + obz.d);
        if (!badq.h(this.jdField_a_of_type_AndroidContentContext)) {
          continue;
        }
        paramView = "2";
        localJSONObject.put("network_type", paramView);
        paramView = localJSONObject.toString();
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
        paramView = str;
        continue;
      }
      ndn.a(null, "", "0X8008451", "0X8008451", 0, 0, "", "", "", paramView, false);
      return;
      paramView = "1";
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt == 0) || (paramInt == this.jdField_a_of_type_Ntl.getCount() - 1)) {}
    prx localprx;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Prv == null) || (this.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 1) || (paramInt > this.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList.size()));
      localprx = (prx)this.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
    } while ((localprx == null) || (TextUtils.isEmpty(localprx.jdField_b_of_type_JavaLangString)));
    obz.a(this.jdField_a_of_type_AndroidContentContext, localprx.jdField_b_of_type_JavaLangString);
    paramView = "";
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", "" + obz.d);
        if (!badq.h(this.jdField_a_of_type_AndroidContentContext)) {
          continue;
        }
        paramAdapterView = "2";
        localJSONObject.put("network_type", paramAdapterView);
        paramAdapterView = localJSONObject.toString();
      }
      catch (JSONException paramAdapterView)
      {
        paramAdapterView.printStackTrace();
        paramAdapterView = paramView;
        continue;
      }
      ndn.a(null, "", "0X8008450", "0X8008450", 0, 0, String.valueOf(localprx.a), String.valueOf(paramInt - 1), String.valueOf(localprx.jdField_b_of_type_Int), paramAdapterView, false);
      localprx.jdField_b_of_type_Int = 0;
      ogy.a().a(this.jdField_a_of_type_Prv);
      this.jdField_a_of_type_Ntl.a(this.jdField_a_of_type_Prv.jdField_a_of_type_JavaUtilArrayList);
      a();
      return;
      paramAdapterView = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nto
 * JD-Core Version:    0.7.0.1
 */