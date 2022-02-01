package dov.com.qq.im.aeeditor.module.music;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.util.AEThemeUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AEEditorMusicAdapter
  extends RecyclerView.Adapter<AEEditorMusicAdapter.AEEditorMusicViewHolder>
{
  private final int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private AEEditorMusicAdapter.ClickCallback jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$ClickCallback;
  private List<AEEditorMusicAdapter.AEEditorMusicInfo> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Set<AEEditorMusicAdapter.AEEditorMusicViewHolder> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = false;
  
  public AEEditorMusicAdapter(@NonNull Context paramContext, @Nullable AEEditorMusicAdapter.ClickCallback paramClickCallback)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$ClickCallback = paramClickCallback;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131296364);
    this.jdField_a_of_type_Boolean = AEThemeUtil.a();
  }
  
  @NonNull
  public AEEditorMusicAdapter.AEEditorMusicViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new AEEditorMusicAdapter.AEEditorMusicViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558582, paramViewGroup, false), this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$ClickCallback, this.jdField_a_of_type_Int);
  }
  
  public List<AEEditorMusicAdapter.AEEditorMusicInfo> a()
  {
    return new LinkedList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    if (CollectionUtils.isEmpty(this.jdField_a_of_type_JavaUtilSet)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext()) {
        ((AEEditorMusicAdapter.AEEditorMusicViewHolder)localIterator.next()).a();
      }
    }
  }
  
  public void a(AEEditorMusicAdapter.AEEditorMusicViewHolder paramAEEditorMusicViewHolder)
  {
    super.onViewAttachedToWindow(paramAEEditorMusicViewHolder);
    this.jdField_a_of_type_JavaUtilSet.add(paramAEEditorMusicViewHolder);
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicViewHolder paramAEEditorMusicViewHolder, int paramInt)
  {
    paramAEEditorMusicViewHolder.a((AEEditorMusicAdapter.AEEditorMusicInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt, this.jdField_a_of_type_JavaUtilList.size());
    EventCollector.getInstance().onRecyclerBindViewHolder(paramAEEditorMusicViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(@NonNull List<AEEditorMusicAdapter.AEEditorMusicInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public void b(AEEditorMusicAdapter.AEEditorMusicViewHolder paramAEEditorMusicViewHolder)
  {
    super.onViewDetachedFromWindow(paramAEEditorMusicViewHolder);
    this.jdField_a_of_type_JavaUtilSet.remove(paramAEEditorMusicViewHolder);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localIterator.next();
        if (localAEEditorMusicInfo != null) {
          localAEEditorMusicInfo.jdField_a_of_type_Boolean = false;
        }
      }
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicAdapter
 * JD-Core Version:    0.7.0.1
 */