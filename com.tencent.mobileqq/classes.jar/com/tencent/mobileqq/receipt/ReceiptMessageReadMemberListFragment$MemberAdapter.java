package com.tencent.mobileqq.receipt;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ReceiptMessageReadMemberListFragment$MemberAdapter
  extends RecyclerView.Adapter<ReceiptMessageReadMemberListFragment.MemberViewHolder>
  implements DecodeTaskCompletionListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new ReceiptMessageReadMemberListFragment.MemberAdapter.1(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private List<ReceiptMessageReadMemberListFragment.MemberInfo> jdField_a_of_type_JavaUtilList;
  private Map<String, Bitmap> jdField_a_of_type_JavaUtilMap;
  
  private ReceiptMessageReadMemberListFragment$MemberAdapter(Context paramContext, IFaceDecoder paramIFaceDecoder, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.c();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    paramRecyclerView.setOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
  }
  
  private Bitmap a(String paramString)
  {
    return a(paramString, 1, (byte)0);
  }
  
  private Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt, true, paramByte);
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  private void a()
  {
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i);
      localObject = (ReceiptMessageReadMemberListFragment.MemberViewHolder)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
      Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.get(ReceiptMessageReadMemberListFragment.MemberViewHolder.a((ReceiptMessageReadMemberListFragment.MemberViewHolder)localObject));
      if (localBitmap != null) {
        ReceiptMessageReadMemberListFragment.MemberViewHolder.a((ReceiptMessageReadMemberListFragment.MemberViewHolder)localObject).setImageBitmap(localBitmap);
      }
      i += 1;
    }
  }
  
  public ReceiptMessageReadMemberListFragment.MemberViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ReceiptMessageReadMemberListFragment.MemberViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562905, paramViewGroup, false), null);
  }
  
  public void a(ReceiptMessageReadMemberListFragment.MemberViewHolder paramMemberViewHolder, int paramInt)
  {
    ReceiptMessageReadMemberListFragment.MemberInfo localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ReceiptMessageReadMemberListFragment.MemberViewHolder.a(paramMemberViewHolder, localMemberInfo.a);
    ReceiptMessageReadMemberListFragment.MemberViewHolder.a(paramMemberViewHolder).setText(localMemberInfo.b);
    ReceiptMessageReadMemberListFragment.MemberViewHolder.a(paramMemberViewHolder).setImageBitmap(a(localMemberInfo.a));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramMemberViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<ReceiptMessageReadMemberListFragment.MemberInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramBitmap);
    if (paramInt1 <= 0)
    {
      if (this.jdField_a_of_type_Int == 0) {
        a();
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberAdapter
 * JD-Core Version:    0.7.0.1
 */