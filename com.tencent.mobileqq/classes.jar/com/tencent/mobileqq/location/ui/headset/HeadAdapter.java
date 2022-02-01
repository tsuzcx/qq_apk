package com.tencent.mobileqq.location.ui.headset;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.location.ui.HeadSetView;
import com.tencent.mobileqq.location.ui.LocationShareController;
import com.tencent.mobileqq.location.ui.MapUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class HeadAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private final HeadSetView jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView;
  private LocationShareController jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController;
  private final HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public HeadAdapter(Context paramContext, HorizontalListView paramHorizontalListView, HeadSetView paramHeadSetView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView = paramHeadSetView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  protected static final <T extends View> T a(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  private void b(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(LocationShareController paramLocationShareController)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController = paramLocationShareController;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController.a(this);
  }
  
  public void a(@NonNull List<String> paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilList.equals(paramList)) && (QLog.isColorLevel())) {
      QLog.d("HeadAdapter", 2, new Object[] { "notifyDataSetChangedAdvance: invoked. same list, ", " newHeadSetList: ", paramList, " headSetList: ", this.jdField_a_of_type_JavaUtilList });
    }
    b(paramList);
    if (this.jdField_a_of_type_JavaUtilList.size() <= this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetView.a()) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(1);
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(0);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = (String)getItem(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559414, null);
      localObject = new HeadAdapter.VH(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("HeadAdapter", 2, new Object[] { "getView: invoked. ", " position: ", Integer.valueOf(paramInt) });
      }
      ((HeadAdapter.VH)localObject).jdField_a_of_type_JavaLangString = str;
      paramView.setTag(localObject);
    }
    for (;;)
    {
      paramView.setOnClickListener(new HeadAdapter.1(this, str));
      Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController.a(((HeadAdapter.VH)localObject).jdField_a_of_type_JavaLangString);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = BaseImageUtil.c();
      }
      ((HeadAdapter.VH)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
      localObject = ((IFriendNameService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFriendNameService.class, "")).getFriendNick(str);
      MapUtils.a(paramView, (String)localObject + "正在共享位置");
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (HeadAdapter.VH)paramView.getTag();
      ((HeadAdapter.VH)localObject).jdField_a_of_type_JavaLangString = str;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(paramInt1).getTag();
        if (!(localObject instanceof HeadAdapter.VH)) {
          break label87;
        }
        localObject = (HeadAdapter.VH)localObject;
        if ((paramString == null) || (!paramString.equals(((HeadAdapter.VH)localObject).jdField_a_of_type_JavaLangString))) {
          break label87;
        }
        if (paramBitmap != null)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController.a(paramString);
          if (paramString != null) {
            ((HeadAdapter.VH)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
          }
        }
      }
      return;
      label87:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.headset.HeadAdapter
 * JD-Core Version:    0.7.0.1
 */