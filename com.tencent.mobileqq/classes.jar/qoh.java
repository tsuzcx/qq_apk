import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotSearch;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class qoh
  extends BaseAdapter
{
  private List<qwe> jdField_a_of_type_JavaUtilList;
  
  public qoh(ComponentContentHotSearch paramComponentContentHotSearch) {}
  
  public qwe a(int paramInt)
  {
    return (qwe)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<qwe> paramList)
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
      localObject1 = new qoi(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch);
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560204, null);
      ((qoi)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368622));
      ((qoi)localObject1).b = ((TextView)paramView.findViewById(2131379030));
      paramView.setOnClickListener((View.OnClickListener)localObject1);
      paramView.setTag(localObject1);
    }
    for (;;)
    {
      qwe localqwe = a(paramInt);
      if (!TextUtils.isEmpty(localqwe.jdField_a_of_type_JavaLangString)) {
        ((qoi)localObject1).b.setText(localqwe.jdField_a_of_type_JavaLangString);
      }
      ((qoi)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + 1 + "");
      Object localObject2 = ((qoi)localObject1).jdField_a_of_type_AndroidWidgetTextView;
      int i;
      if (!TextUtils.isEmpty(localqwe.c))
      {
        i = Color.parseColor(localqwe.c);
        label159:
        ((TextView)localObject2).setTextColor(i);
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(bhgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch.getContext(), 2.0F));
        if (TextUtils.isEmpty(localqwe.d)) {
          break label422;
        }
        i = Color.parseColor(localqwe.d);
        ((GradientDrawable)localObject2).setColor(i);
        ((qoi)localObject1).jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject2);
        ((qoi)localObject1).jdField_a_of_type_Qwe = localqwe;
        if (!localqwe.jdField_a_of_type_Boolean)
        {
          localqwe.jdField_a_of_type_Boolean = true;
          localObject1 = ozs.a(localqwe.jdField_a_of_type_JavaLangString, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID, paramInt + 1);
        }
      }
      try
      {
        ocd.a(null, "CliOper", "", "", "0X80096DC", "0X80096DC", 0, 0, "", "", "", ((JSONObject)localObject1).toString(), false);
        localObject1 = new ArrayList();
        localObject2 = new ReportInfo();
        ((ReportInfo)localObject2).mUin = ozs.a();
        ((ReportInfo)localObject2).mOperation = 52;
        ((ReportInfo)localObject2).mInnerId = ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID;
        ((ReportInfo)localObject2).mHotWord = localqwe.jdField_a_of_type_JavaLangString;
        ((List)localObject1).add(localObject2);
        pfa.a().a((List)localObject1);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = (qoi)paramView.getTag();
        continue;
        i = Color.parseColor("#8C000000");
        break label159;
        label422:
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e(ComponentContentHotSearch.jdField_a_of_type_JavaLangString, 1, "getView, e = " + localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qoh
 * JD-Core Version:    0.7.0.1
 */