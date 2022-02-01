package com.tencent.mobileqq.kandian.biz.fastweb.event;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.FastWebMergeAdapter.OnGetViewListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;
import java.util.List;

public class ItemHeightHelper
  implements FastWebMergeAdapter.OnGetViewListener
{
  private final XListView jdField_a_of_type_ComTencentWidgetXListView;
  private final List<BaseData> jdField_a_of_type_JavaUtilList;
  
  public ItemHeightHelper(XListView paramXListView, List<BaseData> paramList, FastWebMergeAdapter paramFastWebMergeAdapter)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramFastWebMergeAdapter.a(this);
  }
  
  private FastWebMergeAdapter a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() instanceof HeaderViewListAdapter))
    {
      HeaderViewListAdapter localHeaderViewListAdapter = (HeaderViewListAdapter)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
      if ((localHeaderViewListAdapter.getWrappedAdapter() instanceof FastWebMergeAdapter)) {
        return (FastWebMergeAdapter)localHeaderViewListAdapter.getWrappedAdapter();
      }
    }
    return null;
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (paramInt < 0) {
        return true;
      }
      if ((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt) == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" data == null index: ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("   itemArrayList.size() :");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
        AIOUtils.a("ItemHeightHelper", "", new IllegalArgumentException(localStringBuilder.toString()));
        return true;
      }
      return false;
    }
    return true;
  }
  
  private int b(int paramInt)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getWidth();
    int i = Utils.dp2px(300.0D);
    j = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
    if ((Build.VERSION.SDK_INT <= 19) && (paramInt == 0)) {
      return i;
    }
    Object localObject = a();
    if (localObject == null) {
      return i;
    }
    try
    {
      localObject = ((FastWebMergeAdapter)localObject).a(paramInt, null, this.jdField_a_of_type_ComTencentWidgetXListView, true);
      ((View)localObject).measure(j, 0);
      j = ((View)localObject).getMeasuredHeight();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getItemMeasureHeight index : ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" height : ");
      ((StringBuilder)localObject).append(j);
      QLog.d("ItemHeightHelper", 2, ((StringBuilder)localObject).toString());
      return j;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" index : ");
      localStringBuilder.append(paramInt);
      QLog.d("ItemHeightHelper", 2, localException, new Object[] { localStringBuilder.toString() });
    }
    return i;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int a(int paramInt)
  {
    if (a(paramInt)) {
      return -1;
    }
    BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localBaseData.y > 0) {
      return localBaseData.y;
    }
    localBaseData.y = b(paramInt);
    return localBaseData.y;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (a(paramInt1)) {
      return;
    }
    ((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).y = paramInt2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" index : ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("   height: ");
    localStringBuilder.append(paramInt2);
    QLog.d("ItemHeightHelper", 2, localStringBuilder.toString());
  }
  
  public void a(int paramInt, View paramView)
  {
    if (a(paramInt)) {
      return;
    }
    if (((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt)).y <= 0) {
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(new ItemHeightHelper.1(this, paramInt, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.event.ItemHeightHelper
 * JD-Core Version:    0.7.0.1
 */