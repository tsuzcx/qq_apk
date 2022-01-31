import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ovm
  extends ovg<String, DynamicChannelDataModel>
{
  private ovl a;
  public final String b = "ReadInJoyCGIDynamicChannelAdapter";
  
  public ovm(Activity paramActivity, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter, int paramInt)
  {
    super(paramActivity, paramRecyclerViewWithHeaderFooter, paramInt);
    this.jdField_a_of_type_Ovl = new ovl();
    this.jdField_a_of_type_Ovl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, 0);
  }
  
  public long a()
  {
    long l2 = -1L;
    long l1 = l2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      l1 = l2;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        l1 = -1L;
        if (localIterator.hasNext())
        {
          DynamicChannelDataModel localDynamicChannelDataModel = (DynamicChannelDataModel)localIterator.next();
          if (localDynamicChannelDataModel.recommendSeq <= l1) {
            break label85;
          }
          l1 = localDynamicChannelDataModel.recommendSeq;
        }
      }
    }
    label85:
    for (;;)
    {
      break;
      return l1;
    }
  }
  
  public biej a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Ovl.a(paramInt))
    {
      Object localObject = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramViewGroup = ovf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(), (String)localObject);
        if ((paramInt == ovd.b) && (paramViewGroup != null)) {
          paramViewGroup.setVisibility(8);
        }
        QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, new Object[] { "onCreateViewHolder, viewType = ", Integer.valueOf(paramInt), ", styleID = ", localObject });
        localObject = paramViewGroup;
        if (paramViewGroup == null)
        {
          localObject = new ProteusItemView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext());
          QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, "proteusItemView is null");
        }
        return new ovn(this, (View)localObject);
      }
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, "onCreateViewHolder styleID is empty");
    }
    for (;;)
    {
      paramViewGroup = null;
      break;
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, "onCreateViewHolder not the right type");
    }
  }
  
  public void a(biej parambiej, int paramInt)
  {
    DynamicChannelDataModel localDynamicChannelDataModel = (DynamicChannelDataModel)a(paramInt);
    int i = parambiej.getItemViewType();
    parambiej = (ProteusItemView)parambiej.itemView;
    if (localDynamicChannelDataModel != null)
    {
      if (!this.jdField_a_of_type_Ovl.a(i)) {
        break label139;
      }
      if (i != ovd.b) {
        break label120;
      }
      parambiej.setVisibility(8);
    }
    for (;;)
    {
      a(localDynamicChannelDataModel.uniqueID, localDynamicChannelDataModel);
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 2, new Object[] { "onBindViewHolder, dataModel = ", localDynamicChannelDataModel, ", proteusItemView = ", parambiej, " , position = ", Integer.valueOf(paramInt), ", type = ", Integer.valueOf(i) });
      return;
      label120:
      this.jdField_a_of_type_Ovl.a(parambiej, i, localDynamicChannelDataModel, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt);
      continue;
      label139:
      QLog.d("ReadInJoyCGIDynamicChannelAdapter", 1, "onBindViewHolder not the right type");
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = (DynamicChannelDataModel)a(paramInt);
    int i = ovd.b;
    paramInt = i;
    if (localObject != null)
    {
      paramInt = i;
      if (this.jdField_a_of_type_Ovl.a((DynamicChannelDataModel)localObject))
      {
        i = this.jdField_a_of_type_Ovl.a((DynamicChannelDataModel)localObject);
        localObject = ((DynamicChannelDataModel)localObject).styleID;
        paramInt = i;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), localObject);
          paramInt = i;
        }
      }
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ovm
 * JD-Core Version:    0.7.0.1
 */