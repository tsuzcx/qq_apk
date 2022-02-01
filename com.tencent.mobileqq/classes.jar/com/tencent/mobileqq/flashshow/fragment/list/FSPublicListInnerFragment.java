package com.tencent.mobileqq.flashshow.fragment.list;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.flashshow.fragment.FSBaseFragment;
import com.tencent.mobileqq.flashshow.list.blocks.FSBaseListBlock;
import com.tencent.mobileqq.flashshow.personal.widget.FSRefreshHeaderView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FSPublicListInnerFragment
  extends FSBaseFragment
{
  protected BlockPart b;
  protected FSBaseListBlock c;
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    g();
  }
  
  protected void a(FSBaseListBlock paramFSBaseListBlock)
  {
    this.c = paramFSBaseListBlock;
  }
  
  public String b()
  {
    return "PublicListInnerFragment";
  }
  
  protected int c()
  {
    FSBaseListBlock localFSBaseListBlock = this.c;
    if ((localFSBaseListBlock != null) && (localFSBaseListBlock.getContentLayoutId() != 0)) {
      return this.c.getContentLayoutId();
    }
    return 2131624812;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.b = new BlockPart(2131431490, h(), 3, 1);
    localArrayList.add(this.b);
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((FSBaseListBlock)localObject).getCustomParts();
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        localArrayList.addAll((Collection)localObject);
      }
    }
    return localArrayList;
  }
  
  public String e()
  {
    return "pg_ks_my_message_page";
  }
  
  protected void g()
  {
    this.b.i().setRefreshHeader(new FSRefreshHeaderView(getActivity()));
    this.b.i().setEnableRefresh(true);
    this.b.i().setEnableLoadMore(true);
    this.b.i().setParentFragment(this);
    this.b.i().getBlockMerger().b(3);
    this.b.i().getRecyclerView().addOnScrollListener(new FSPublicListInnerFragment.1(this));
  }
  
  protected List<MultiViewBlock> h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.c);
    return localArrayList;
  }
  
  public BlockContainer i()
  {
    BlockPart localBlockPart = this.b;
    if (localBlockPart != null) {
      return localBlockPart.i();
    }
    return null;
  }
  
  public int j()
  {
    FSBaseListBlock localFSBaseListBlock = this.c;
    if (localFSBaseListBlock != null) {
      return localFSBaseListBlock.getStatusBarColor();
    }
    return 0;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.list.FSPublicListInnerFragment
 * JD-Core Version:    0.7.0.1
 */