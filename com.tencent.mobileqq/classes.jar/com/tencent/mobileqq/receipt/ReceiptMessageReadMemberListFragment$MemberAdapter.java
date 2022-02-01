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
  private Context a;
  private IFaceDecoder b;
  private Bitmap c = null;
  private List<ReceiptMessageReadMemberListFragment.MemberInfo> d;
  private Map<String, Bitmap> e;
  private RecyclerView f;
  private int g = 0;
  private RecyclerView.OnScrollListener h = new ReceiptMessageReadMemberListFragment.MemberAdapter.1(this);
  
  private ReceiptMessageReadMemberListFragment$MemberAdapter(Context paramContext, IFaceDecoder paramIFaceDecoder, RecyclerView paramRecyclerView)
  {
    this.a = paramContext;
    this.b = paramIFaceDecoder;
    this.c = ImageUtil.k();
    this.b.setDecodeTaskCompletionListener(this);
    this.e = new HashMap();
    this.f = paramRecyclerView;
    paramRecyclerView.setOnScrollListener(this.h);
  }
  
  private Bitmap a(String paramString)
  {
    return a(paramString, 1, (byte)0);
  }
  
  private Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    Bitmap localBitmap = this.b.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.b.isPausing()) {
      this.b.requestDecodeFace(paramString, paramInt, true, paramByte);
    }
    return this.c;
  }
  
  private void a()
  {
    int j = this.f.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.f.getChildAt(i);
      localObject = (ReceiptMessageReadMemberListFragment.MemberViewHolder)this.f.getChildViewHolder((View)localObject);
      Bitmap localBitmap = (Bitmap)this.e.get(ReceiptMessageReadMemberListFragment.MemberViewHolder.c((ReceiptMessageReadMemberListFragment.MemberViewHolder)localObject));
      if (localBitmap != null) {
        ReceiptMessageReadMemberListFragment.MemberViewHolder.b((ReceiptMessageReadMemberListFragment.MemberViewHolder)localObject).setImageBitmap(localBitmap);
      }
      i += 1;
    }
  }
  
  public ReceiptMessageReadMemberListFragment.MemberViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ReceiptMessageReadMemberListFragment.MemberViewHolder(LayoutInflater.from(this.a).inflate(2131629154, paramViewGroup, false), null);
  }
  
  public void a(ReceiptMessageReadMemberListFragment.MemberViewHolder paramMemberViewHolder, int paramInt)
  {
    ReceiptMessageReadMemberListFragment.MemberInfo localMemberInfo = (ReceiptMessageReadMemberListFragment.MemberInfo)this.d.get(paramInt);
    ReceiptMessageReadMemberListFragment.MemberViewHolder.a(paramMemberViewHolder, localMemberInfo.a);
    ReceiptMessageReadMemberListFragment.MemberViewHolder.a(paramMemberViewHolder).setText(localMemberInfo.b);
    ReceiptMessageReadMemberListFragment.MemberViewHolder.b(paramMemberViewHolder).setImageBitmap(a(localMemberInfo.a));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramMemberViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<ReceiptMessageReadMemberListFragment.MemberInfo> paramList)
  {
    this.d = paramList;
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    List localList = this.d;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.e.put(paramString, paramBitmap);
    if (paramInt1 <= 0)
    {
      if (this.g == 0) {
        a();
      }
      this.e.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberAdapter
 * JD-Core Version:    0.7.0.1
 */