package dov.com.qq.im.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.TemplateGroupItem;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class QIMPtvTemplateViewPagerAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  ProviderView.ProviderViewListener jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public HashMap a;
  
  public QIMPtvTemplateViewPagerAdapter(Context paramContext, ProviderView.ProviderViewListener paramProviderViewListener, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener = paramProviderViewListener;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public TemplateGroupItem a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt) && (paramInt >= 0)) {
      return (TemplateGroupItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public TemplateGroupItem a(TemplateGroupItem paramTemplateGroupItem)
  {
    if (paramTemplateGroupItem == null) {
      return paramTemplateGroupItem;
    }
    int i;
    label14:
    int j;
    label22:
    TemplateGroupItem localTemplateGroupItem;
    if (!SoLoader.f())
    {
      i = 1;
      if (PtvFilterSoLoad.f()) {
        break label184;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label187;
      }
      localTemplateGroupItem = new TemplateGroupItem();
      localTemplateGroupItem.jdField_a_of_type_Int = paramTemplateGroupItem.jdField_a_of_type_Int;
      localTemplateGroupItem.jdField_a_of_type_JavaLangString = paramTemplateGroupItem.jdField_a_of_type_JavaLangString;
      localTemplateGroupItem.jdField_a_of_type_Boolean = paramTemplateGroupItem.jdField_a_of_type_Boolean;
      localTemplateGroupItem.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((paramTemplateGroupItem.jdField_a_of_type_JavaUtilList == null) || (paramTemplateGroupItem.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label195;
      }
      paramTemplateGroupItem = paramTemplateGroupItem.jdField_a_of_type_JavaUtilList.iterator();
    }
    label184:
    label187:
    label193:
    for (;;)
    {
      label107:
      if (!paramTemplateGroupItem.hasNext()) {
        break label195;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramTemplateGroupItem.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 11))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label193;
        }
        localTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label107;
        i = 0;
        break label14;
        j = 0;
        break label22;
        break;
      }
    }
    label195:
    return localTemplateGroupItem;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (GridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (QIMPtvTemplateAdapter)paramViewGroup.a();
      ((QIMPtvTemplateManager)QIMManager.a(3)).a(paramViewGroup);
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "instantiateItem position = " + paramInt);
    }
    GridView localGridView = (GridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    QIMPtvTemplateAdapter localQIMPtvTemplateAdapter;
    QIMPtvTemplateManager localQIMPtvTemplateManager;
    if (localGridView == null)
    {
      localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
      localGridView.setNumColumns(-1);
      int m = AIOUtils.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(m);
      int i = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int n = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - j * 2;
      int k = n / m;
      m = n - m * k;
      if (m > 0)
      {
        localGridView.setHorizontalSpacing(m / (k - 1));
        localGridView.setVerticalSpacing(i);
        localGridView.setVerticalScrollBarEnabled(false);
        localGridView.setPadding(j, j, j, AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 4);
        localGridView.setClipToPadding(false);
        localGridView.setSelector(new ColorDrawable(0));
        localQIMPtvTemplateAdapter = new QIMPtvTemplateAdapter(this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener, this.jdField_a_of_type_Int);
        localQIMPtvTemplateManager = (QIMPtvTemplateManager)QIMManager.a(3);
        localQIMPtvTemplateManager.a(localQIMPtvTemplateAdapter, 112);
        localQIMPtvTemplateManager.a(localQIMPtvTemplateAdapter, 113);
        if (paramInt == 0) {
          localQIMPtvTemplateManager.a(localQIMPtvTemplateAdapter, 111);
        }
        localGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localGridView);
      }
    }
    for (;;)
    {
      localQIMPtvTemplateAdapter.a(a((TemplateGroupItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localGridView.setAdapter(localQIMPtvTemplateAdapter);
      paramViewGroup.addView(localGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localQIMPtvTemplateAdapter);
      }
      return localGridView;
      localGridView.setHorizontalSpacing(0);
      break;
      localQIMPtvTemplateAdapter = (QIMPtvTemplateAdapter)localGridView.a();
      localQIMPtvTemplateManager = (QIMPtvTemplateManager)QIMManager.a(3);
      localQIMPtvTemplateManager.a(localQIMPtvTemplateAdapter, 112);
      localQIMPtvTemplateManager.a(localQIMPtvTemplateAdapter, 113);
      if (paramInt == 0) {
        localQIMPtvTemplateManager.a(localQIMPtvTemplateAdapter, 111);
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */