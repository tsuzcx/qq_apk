package com.tencent.mobileqq.selectmember.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.Hashtable;
import mqq.app.MobileQQ;

public abstract class FacePreloadBaseAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  protected IFaceDecoder a;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public FacePreloadBaseAdapter(Context paramContext, AppInterface paramAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  protected Bitmap a()
  {
    return BaseImageUtil.f();
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    if (AppConstants.SEC_MSG_UIN.equals(paramString)) {}
    try
    {
      paramString = BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), 2130847660);
      return paramString;
    }
    catch (OutOfMemoryError paramString) {}
    return a(paramString, paramInt, (byte)0);
    return null;
  }
  
  protected Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt, true, paramByte);
    }
    return a();
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetListView;
    if ((localObject != null) && (((ListView)localObject).getOnScrollListener() == this)) {
      this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    this.jdField_a_of_type_ComTencentWidgetListView = null;
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetListView;
      if (localObject != null)
      {
        int j = ((ListView)localObject).getChildCount();
        int i = 0;
        while (i < j)
        {
          localObject = (FacePreloadBaseAdapter.ViewHolder)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
          if ((localObject != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject).a != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject).a.length() > 0) && (((FacePreloadBaseAdapter.ViewHolder)localObject).a.equals(paramString)))
          {
            ((FacePreloadBaseAdapter.ViewHolder)localObject).c.setImageBitmap(paramBitmap);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    paramInt2 = 0;
    if (bool)
    {
      if (paramInt1 == 0) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
    {
      if (paramBitmap != null) {
        this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
      }
      if (paramInt1 <= 0)
      {
        paramInt1 = this.jdField_a_of_type_Int;
        if ((paramInt1 == 0) || (paramInt1 == 1))
        {
          int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
          paramInt1 = paramInt2;
          while (paramInt1 < i)
          {
            paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag();
            if ((paramString != null) && ((paramString instanceof FacePreloadBaseAdapter.ViewHolder)))
            {
              paramString = (FacePreloadBaseAdapter.ViewHolder)paramString;
              if ((paramString != null) && (paramString.a != null) && (paramString.a.length() > 0))
              {
                paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.a);
                if (paramBitmap != null) {
                  paramString.c.setImageBitmap(paramBitmap);
                }
              }
            }
            paramInt1 += 1;
          }
        }
        this.jdField_a_of_type_JavaUtilHashtable.clear();
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    int i = 0;
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetListView;
      if (localObject != null)
      {
        int j = ((ListView)localObject).getChildCount();
        while (i < j)
        {
          localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
          if ((localObject != null) && ((localObject instanceof FacePreloadBaseAdapter.ViewHolder)))
          {
            localObject = (FacePreloadBaseAdapter.ViewHolder)localObject;
            if ((localObject != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject).a != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject).a.length() > 0)) {
              ((FacePreloadBaseAdapter.ViewHolder)localObject).c.setImageBitmap(a(((FacePreloadBaseAdapter.ViewHolder)localObject).jdField_b_of_type_Int, ((FacePreloadBaseAdapter.ViewHolder)localObject).a));
            }
          }
          i += 1;
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.adapter.FacePreloadBaseAdapter
 * JD-Core Version:    0.7.0.1
 */