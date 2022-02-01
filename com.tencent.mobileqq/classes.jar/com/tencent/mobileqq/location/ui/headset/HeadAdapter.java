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
import com.tencent.mobileqq.location.ui.LocationAvatarHelper;
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
  private final Context jdField_a_of_type_AndroidContentContext;
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
  
  protected static <T extends View> T a(View paramView, int paramInt)
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
    } else {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(0);
    }
    super.notifyDataSetChanged();
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
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559289, null);
      localObject1 = new HeadAdapter.VH(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("HeadAdapter", 2, new Object[] { "getView: invoked. ", " position: ", Integer.valueOf(paramInt) });
      }
      ((HeadAdapter.VH)localObject1).jdField_a_of_type_JavaLangString = str;
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (HeadAdapter.VH)paramView.getTag();
      ((HeadAdapter.VH)localObject1).jdField_a_of_type_JavaLangString = str;
    }
    paramView.setOnClickListener(new HeadAdapter.1(this, str));
    Bitmap localBitmap = LocationAvatarHelper.a().a(((HeadAdapter.VH)localObject1).jdField_a_of_type_JavaLangString);
    Object localObject2 = localBitmap;
    if (localBitmap == null) {
      localObject2 = BaseImageUtil.f();
    }
    ((HeadAdapter.VH)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
    Object localObject1 = ((IFriendNameService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFriendNameService.class, "")).getFriendNick(str);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("正在共享位置");
    MapUtils.a(paramView, ((StringBuilder)localObject2).toString());
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(paramInt1).getTag();
      if ((localObject instanceof HeadAdapter.VH))
      {
        localObject = (HeadAdapter.VH)localObject;
        if ((paramString != null) && (paramString.equals(((HeadAdapter.VH)localObject).jdField_a_of_type_JavaLangString)))
        {
          if (paramBitmap == null) {
            break;
          }
          paramString = LocationAvatarHelper.a().a(paramString);
          if (paramString == null) {
            break;
          }
          ((HeadAdapter.VH)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
          return;
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.headset.HeadAdapter
 * JD-Core Version:    0.7.0.1
 */