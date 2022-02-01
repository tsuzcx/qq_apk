package com.tencent.mobileqq.flashshow.widgets.comment.adapter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.flashshow.bean.FSCommentItemInfo;
import com.tencent.mobileqq.flashshow.bean.FSReplyItemInfo;
import com.tencent.mobileqq.flashshow.widgets.FSBaseMultiViewBlock;
import com.tencent.mobileqq.flashshow.widgets.comment.FSCommentItemView;
import com.tencent.mobileqq.flashshow.widgets.comment.OnCommentElementClickListener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FSCommentPanelBlock
  extends FSBaseMultiViewBlock<FSCommentItemInfo>
{
  private OnCommentElementClickListener a;
  private FeedCloudMeta.StFeed b;
  private RecyclerView c;
  private int d = 3;
  private int e = 3;
  
  public FSCommentPanelBlock(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private int a(String paramString, int paramInt1, int paramInt2, FSCommentItemInfo paramFSCommentItemInfo)
  {
    int i = 0;
    while (i < paramFSCommentItemInfo.b.size())
    {
      FeedCloudMeta.StReply localStReply = ((FSReplyItemInfo)paramFSCommentItemInfo.b.get(i)).b;
      if ((localStReply != null) && (paramString.equals(localStReply.id.get())))
      {
        paramFSCommentItemInfo.a(paramString, this.d);
        return paramInt2;
      }
      i += 1;
    }
    return paramInt1;
  }
  
  private List<FSReplyItemInfo> a(FSCommentItemInfo paramFSCommentItemInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramFSCommentItemInfo.a.vecReply.size())
    {
      FeedCloudMeta.StReply localStReply = (FeedCloudMeta.StReply)paramFSCommentItemInfo.a.vecReply.get(i);
      if ((!a(paramFSCommentItemInfo, localStReply)) && (localArrayList.size() < paramInt)) {
        localArrayList.add(new FSReplyItemInfo(1, localStReply));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private List<FSCommentItemInfo> a(List<FeedCloudMeta.StComment> paramList)
  {
    if (paramList == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator.next();
      FSCommentItemInfo localFSCommentItemInfo = new FSCommentItemInfo(localStComment);
      int i;
      if (paramList.size() == 1)
      {
        i = localStComment.vecReply.size();
      }
      else
      {
        j = localStComment.vecReply.size();
        i = this.d;
        if (j <= i) {
          i = localStComment.vecReply.size();
        }
      }
      int j = 0;
      while (j < i)
      {
        localFSCommentItemInfo.a(1, (FeedCloudMeta.StReply)localStComment.vecReply.get(j));
        j += 1;
      }
      if (i < localStComment.vecReply.size()) {
        localFSCommentItemInfo.a(2, localStComment.vecReply.size() - i);
      }
      localArrayList.add(localFSCommentItemInfo);
    }
    return localArrayList;
  }
  
  private void a()
  {
    RecyclerView localRecyclerView = this.c;
    if (localRecyclerView == null) {
      return;
    }
    localRecyclerView.setItemAnimator(null);
  }
  
  private void a(FSCommentItemInfo paramFSCommentItemInfo)
  {
    if (paramFSCommentItemInfo.a.vecReply.size() <= this.d)
    {
      int i = 0;
      while (i < paramFSCommentItemInfo.b.size())
      {
        FSReplyItemInfo localFSReplyItemInfo = (FSReplyItemInfo)paramFSCommentItemInfo.b.get(i);
        if ((localFSReplyItemInfo != null) && ((localFSReplyItemInfo.a == 2) || (localFSReplyItemInfo.a == 3)))
        {
          paramFSCommentItemInfo.b.remove(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void a(String paramString, FSCommentItemInfo paramFSCommentItemInfo)
  {
    int i = 0;
    while (i < paramFSCommentItemInfo.a.vecReply.get().size())
    {
      FeedCloudMeta.StReply localStReply = (FeedCloudMeta.StReply)paramFSCommentItemInfo.a.vecReply.get(i);
      if ((localStReply != null) && (paramString.equals(localStReply.id.get())))
      {
        paramFSCommentItemInfo.a.vecReply.remove(i);
        return;
      }
      i += 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    RecyclerView localRecyclerView = this.c;
    if (localRecyclerView != null)
    {
      if (localRecyclerView.isComputingLayout())
      {
        this.c.post(new FSCommentPanelBlock.1(this, paramBoolean));
        return;
      }
      if (paramBoolean) {
        a();
      }
      notifyDataSetChanged();
    }
  }
  
  private boolean a(FSCommentItemInfo paramFSCommentItemInfo, FeedCloudMeta.StReply paramStReply)
  {
    paramFSCommentItemInfo = paramFSCommentItemInfo.b.iterator();
    while (paramFSCommentItemInfo.hasNext())
    {
      FSReplyItemInfo localFSReplyItemInfo = (FSReplyItemInfo)paramFSCommentItemInfo.next();
      if ((localFSReplyItemInfo.a == 1) && (TextUtils.equals(localFSReplyItemInfo.b.id.get(), paramStReply.id.get()))) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    RecyclerView localRecyclerView = this.c;
    if (localRecyclerView == null) {
      return;
    }
    localRecyclerView.setItemAnimator(new DefaultItemAnimator());
    if (!(this.c.getItemAnimator() instanceof SimpleItemAnimator)) {
      return;
    }
    ((SimpleItemAnimator)this.c.getItemAnimator()).setSupportsChangeAnimations(false);
  }
  
  private void b(int paramInt)
  {
    RecyclerView localRecyclerView = this.c;
    if (localRecyclerView != null)
    {
      if (localRecyclerView.isComputingLayout())
      {
        this.c.post(new FSCommentPanelBlock.3(this, paramInt));
        return;
      }
      c(paramInt);
    }
  }
  
  private void c(int paramInt)
  {
    try
    {
      b();
      notifyItemRemoved(paramInt);
      notifyItemRangeChanged(paramInt, this.mDataList.size() - paramInt);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FSCommentPanelBlock", 1, localException, new Object[0]);
    }
  }
  
  private void d(int paramInt)
  {
    RecyclerView localRecyclerView = this.c;
    if (localRecyclerView != null)
    {
      if (localRecyclerView.isComputingLayout())
      {
        this.c.post(new FSCommentPanelBlock.4(this, paramInt));
        return;
      }
      b();
      notifyItemChanged(paramInt);
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.mDataList.size() <= paramInt1) {
      return;
    }
    Object localObject = (FSCommentItemInfo)this.mDataList.get(paramInt1);
    if (((FSCommentItemInfo)localObject).b.size() > paramInt2)
    {
      if (((FSReplyItemInfo)((FSCommentItemInfo)localObject).b.get(paramInt2)).a != 2) {
        return;
      }
      paramInt1 = this.e;
      int i;
      if (((FSReplyItemInfo)((FSCommentItemInfo)localObject).b.get(paramInt2)).c <= paramInt1)
      {
        paramInt1 = ((FSReplyItemInfo)((FSCommentItemInfo)localObject).b.get(paramInt2)).c;
        i = 1;
      }
      else
      {
        i = 0;
      }
      List localList = a((FSCommentItemInfo)localObject, paramInt1);
      ((FSCommentItemInfo)localObject).b.addAll(paramInt2, localList);
      paramInt2 = ((FSCommentItemInfo)localObject).b.size() - 1;
      if (i != 0)
      {
        ((FSReplyItemInfo)((FSCommentItemInfo)localObject).b.get(paramInt2)).a = 3;
        ((FSReplyItemInfo)((FSCommentItemInfo)localObject).b.get(paramInt2)).c = 0;
      }
      else
      {
        localObject = (FSReplyItemInfo)((FSCommentItemInfo)localObject).b.get(paramInt2);
        ((FSReplyItemInfo)localObject).c -= paramInt1;
      }
      a(false);
    }
  }
  
  public void a(int paramInt, FeedCloudMeta.StComment paramStComment)
  {
    if ((paramStComment != null) && (paramInt <= this.mDataList.size())) {
      this.mDataList.add(paramInt, new FSCommentItemInfo(paramStComment));
    }
    a(false);
    paramStComment = this.c;
    if (paramStComment != null) {
      paramStComment.scrollToPosition(paramInt);
    }
  }
  
  public void a(OnCommentElementClickListener paramOnCommentElementClickListener)
  {
    this.a = paramOnCommentElementClickListener;
  }
  
  public void a(FeedCloudMeta.StComment paramStComment)
  {
    if ((this.mDataList.size() > 0) && (((FSCommentItemInfo)this.mDataList.get(0)).a.typeFlag.get() == 1))
    {
      a(1, paramStComment);
      return;
    }
    a(0, paramStComment);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, List<FeedCloudMeta.StComment> paramList)
  {
    this.b = paramStFeed;
    this.mDataList.clear();
    a(true);
    this.mDataList.addAll(a(paramList));
    a(true);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
    while (i < this.mDataList.size())
    {
      if (((FSCommentItemInfo)this.mDataList.get(i)).a.id.get().equals(paramString))
      {
        this.mDataList.remove(i);
        break label69;
      }
      i += 1;
    }
    i = -1;
    label69:
    if (i != -1) {
      b(i);
    }
  }
  
  public void a(String paramString, FeedCloudMeta.StComment paramStComment)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
    while (i < this.mDataList.size())
    {
      if (paramString.equals(((FSCommentItemInfo)this.mDataList.get(i)).a.id.get()))
      {
        this.mDataList.set(i, new FSCommentItemInfo(paramStComment));
        break label77;
      }
      i += 1;
    }
    i = -1;
    label77:
    if (i != -1) {
      d(i);
    }
  }
  
  public void a(String paramString, FeedCloudMeta.StReply paramStReply)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
    while (i < this.mDataList.size())
    {
      FSCommentItemInfo localFSCommentItemInfo = (FSCommentItemInfo)this.mDataList.get(i);
      if (paramString.equals(localFSCommentItemInfo.a.id.get()))
      {
        localFSCommentItemInfo.a.vecReply.get().add(paramStReply);
        localFSCommentItemInfo.a(1, paramStReply);
        break label89;
      }
      i += 1;
    }
    i = -1;
    label89:
    if (i != -1) {
      d(i);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      int i = 0;
      while (i < this.mDataList.size())
      {
        FSCommentItemInfo localFSCommentItemInfo = (FSCommentItemInfo)this.mDataList.get(i);
        if ((paramString1.equals(localFSCommentItemInfo.a.id.get())) && (localFSCommentItemInfo.b != null) && (localFSCommentItemInfo.b.size() > 0))
        {
          a(paramString2, localFSCommentItemInfo);
          i = a(paramString2, -1, i, localFSCommentItemInfo);
          a(localFSCommentItemInfo);
          break label115;
        }
        i += 1;
      }
      i = -1;
      label115:
      if (i != -1) {
        d(i);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, FeedCloudMeta.StReply paramStReply)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      int i = 0;
      while (i < this.mDataList.size())
      {
        FSCommentItemInfo localFSCommentItemInfo = (FSCommentItemInfo)this.mDataList.get(i);
        if (paramString1.equals(localFSCommentItemInfo.a.id.get()))
        {
          int j = localFSCommentItemInfo.a.vecReply.get().size() - 1;
          while (j >= 0)
          {
            if (paramString2.equals(((FeedCloudMeta.StReply)localFSCommentItemInfo.a.vecReply.get(j)).id.get()))
            {
              localFSCommentItemInfo.a.vecReply.get().set(j, paramStReply);
              localFSCommentItemInfo.a(paramString2, paramStReply);
              break label167;
            }
            j -= 1;
          }
        }
        i += 1;
      }
      i = -1;
      label167:
      if (i != -1) {
        d(i);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.mDataList.size() <= paramInt1) {
      return;
    }
    FSCommentItemInfo localFSCommentItemInfo = (FSCommentItemInfo)this.mDataList.get(paramInt1);
    if (localFSCommentItemInfo.b.size() > paramInt2)
    {
      if (((FSReplyItemInfo)localFSCommentItemInfo.b.get(paramInt2)).a != 3) {
        return;
      }
      Iterator localIterator = localFSCommentItemInfo.b.iterator();
      paramInt1 = 0;
      while (localIterator.hasNext())
      {
        FSReplyItemInfo localFSReplyItemInfo = (FSReplyItemInfo)localIterator.next();
        if (paramInt1 < this.d)
        {
          paramInt1 += 1;
        }
        else
        {
          if (localFSReplyItemInfo.a == 3)
          {
            localFSReplyItemInfo.a = 2;
            localFSReplyItemInfo.c = (localFSCommentItemInfo.a.vecReply.size() - (localFSCommentItemInfo.b.size() - 1));
            break;
          }
          localIterator.remove();
        }
      }
      a(false);
    }
  }
  
  public void clearData()
  {
    this.mDataList.clear();
    a(true);
  }
  
  public int getItemCount()
  {
    if (this.mDataList == null) {
      return 0;
    }
    return this.mDataList.size();
  }
  
  public int getViewTypeCount()
  {
    return 0;
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > paramInt)) {
      ((FSCommentPanelBlock.CommentItemHolder)paramViewHolder).a(paramInt, this.b, (FSCommentItemInfo)this.mDataList.get(paramInt), this.a);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new FSCommentPanelBlock.CommentItemHolder(this, new FSCommentItemView(paramViewGroup.getContext()), null);
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    this.c = getParentRecyclerView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.adapter.FSCommentPanelBlock
 * JD-Core Version:    0.7.0.1
 */