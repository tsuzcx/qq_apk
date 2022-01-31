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

public class qcl
  extends BaseAdapter
{
  private List<qkz> jdField_a_of_type_JavaUtilList;
  
  public qcl(ComponentContentHotSearch paramComponentContentHotSearch) {}
  
  public qkz a(int paramInt)
  {
    return (qkz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<qkz> paramList)
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
      paramView = new qcm(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch);
      localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560046, null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131368210));
      paramView.b = ((TextView)((View)localObject1).findViewById(2131377972));
      ((View)localObject1).setOnClickListener(paramView);
      ((View)localObject1).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = a(paramInt);
      if (!TextUtils.isEmpty(((qkz)localObject1).jdField_a_of_type_JavaLangString)) {
        paramViewGroup.b.setText(((qkz)localObject1).jdField_a_of_type_JavaLangString);
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt + 1 + "");
      Object localObject2 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
      int i;
      if (!TextUtils.isEmpty(((qkz)localObject1).c))
      {
        i = Color.parseColor(((qkz)localObject1).c);
        label161:
        ((TextView)localObject2).setTextColor(i);
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setShape(0);
        ((GradientDrawable)localObject2).setCornerRadius(bcwh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch.getContext(), 2.0F));
        if (TextUtils.isEmpty(((qkz)localObject1).d)) {
          break label402;
        }
        i = Color.parseColor(((qkz)localObject1).d);
        ((GradientDrawable)localObject2).setColor(i);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject2);
        paramViewGroup.jdField_a_of_type_Qkz = ((qkz)localObject1);
        if (!((qkz)localObject1).jdField_a_of_type_Boolean)
        {
          ((qkz)localObject1).jdField_a_of_type_Boolean = true;
          paramViewGroup = ors.a(((qkz)localObject1).jdField_a_of_type_JavaLangString, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID, paramInt + 1);
        }
      }
      try
      {
        nrt.a(null, "CliOper", "", "", "0X80096DC", "0X80096DC", 0, 0, "", "", "", paramViewGroup.toString(), false);
        paramViewGroup = new ArrayList();
        localObject2 = new ReportInfo();
        ((ReportInfo)localObject2).mUin = ors.a();
        ((ReportInfo)localObject2).mOperation = 52;
        ((ReportInfo)localObject2).mInnerId = ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID;
        ((ReportInfo)localObject2).mHotWord = ((qkz)localObject1).jdField_a_of_type_JavaLangString;
        paramViewGroup.add(localObject2);
        owy.a().a(paramViewGroup);
        return paramView;
        paramViewGroup = (qcm)paramView.getTag();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qcl
 * JD-Core Version:    0.7.0.1
 */