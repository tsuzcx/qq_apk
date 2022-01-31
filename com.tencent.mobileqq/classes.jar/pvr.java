import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotSearch;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class pvr
  extends BaseAdapter
{
  private List<qbd> jdField_a_of_type_JavaUtilList;
  
  public pvr(ComponentContentHotSearch paramComponentContentHotSearch) {}
  
  public qbd a(int paramInt)
  {
    return (qbd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<qbd> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (0 == 0)
    {
      paramView = new pvs(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch);
      localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559948, null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131368072));
      paramView.b = ((TextView)((View)localObject1).findViewById(2131377435));
      ((View)localObject1).setOnClickListener(paramView);
      ((View)localObject1).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = a(paramInt);
      if (!TextUtils.isEmpty(((qbd)localObject1).jdField_a_of_type_JavaLangString)) {
        paramViewGroup.b.setText(((qbd)localObject1).jdField_a_of_type_JavaLangString);
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + 1 + "");
      Object localObject2 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
      int i;
      if (!TextUtils.isEmpty(((qbd)localObject1).c))
      {
        i = Color.parseColor(((qbd)localObject1).c);
        label161:
        ((TextView)localObject2).setTextColor(i);
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(baxn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch.getContext(), 2.0F));
        if (TextUtils.isEmpty(((qbd)localObject1).d)) {
          break label402;
        }
        i = Color.parseColor(((qbd)localObject1).d);
        ((GradientDrawable)localObject2).setColor(i);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject2);
        paramViewGroup.jdField_a_of_type_Qbd = ((qbd)localObject1);
        if (!((qbd)localObject1).jdField_a_of_type_Boolean)
        {
          ((qbd)localObject1).jdField_a_of_type_Boolean = true;
          paramViewGroup = onh.a(((qbd)localObject1).jdField_a_of_type_JavaLangString, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID, paramInt + 1);
        }
      }
      try
      {
        nol.a(null, "CliOper", "", "", "0X80096DC", "0X80096DC", 0, 0, "", "", "", paramViewGroup.toString(), false);
        paramViewGroup = new ArrayList();
        localObject2 = new ReportInfo();
        ((ReportInfo)localObject2).mUin = onh.a();
        ((ReportInfo)localObject2).mOperation = 52;
        ((ReportInfo)localObject2).mInnerId = ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID;
        ((ReportInfo)localObject2).mHotWord = ((qbd)localObject1).jdField_a_of_type_JavaLangString;
        paramViewGroup.add(localObject2);
        osg.a().a(paramViewGroup);
        return paramView;
        paramViewGroup = (pvs)paramView.getTag();
        continue;
        i = Color.parseColor("#8C000000");
        break label161;
        label402:
        i = 0;
      }
      catch (Exception paramViewGroup)
      {
        for (;;)
        {
          QLog.e(ComponentContentHotSearch.jdField_a_of_type_JavaLangString, 1, "getView, e = " + paramViewGroup);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pvr
 * JD-Core Version:    0.7.0.1
 */