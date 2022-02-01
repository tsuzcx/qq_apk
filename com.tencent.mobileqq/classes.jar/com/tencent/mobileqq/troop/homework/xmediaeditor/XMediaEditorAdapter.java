package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoFactory;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HomeWorkInfoInterface;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.UploadEditItemInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditItemBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditorViewHolderManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class XMediaEditorAdapter
  extends RecyclerView.Adapter
{
  int jdField_a_of_type_Int = 0;
  public EditorViewHolderManager a;
  private ArrayList<EditItemInfoBase> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public XMediaEditorAdapter(SparseArray<EditItemBase> paramSparseArray)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager = new EditorViewHolderManager();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.a(paramSparseArray);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public EditItemInfoBase a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size())) {
        return (EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getEditItemInfo index out of bound, index:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", mItemList.size():");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.e("XMediaEditor", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public String a()
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      EditItemInfoBase localEditItemInfoBase = (EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localEditItemInfoBase.b() != -1) {
        localJSONArray.put(localEditItemInfoBase.a());
      }
      i += 1;
    }
    return localJSONArray.toString();
  }
  
  public ArrayList<UploadEditItemInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localObject instanceof UploadEditItemInfo))
      {
        localObject = (UploadEditItemInfo)localObject;
        if (((UploadEditItemInfo)localObject).f != 3) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, EditItemInfoBase paramEditItemInfoBase)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.a(paramEditItemInfoBase);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramEditItemInfoBase);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    EditItemInfoBase localEditItemInfoBase = a(paramInt);
    if (localEditItemInfoBase != null)
    {
      localEditItemInfoBase.c(paramString);
      notifyItemChanged(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.b(localEditItemInfoBase);
    }
  }
  
  public void a(EditItemInfoBase paramEditItemInfoBase)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.a(paramEditItemInfoBase);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramEditItemInfoBase);
    }
  }
  
  public void a(ArrayList<UploadEditItemInfo> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      UploadEditItemInfo localUploadEditItemInfo = (UploadEditItemInfo)paramArrayList.get(i);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.a(localUploadEditItemInfo);
      i += 1;
    }
  }
  
  public void a(JSONArray paramJSONArray)
  {
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.c((EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
          continue;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i = 0;
        if (i < paramJSONArray.length())
        {
          localObject1 = EditItemInfoFactory.a(paramJSONArray.getJSONObject(i));
          if (localObject1 != null) {
            a((EditItemInfoBase)localObject1);
          }
        }
        else
        {
          localObject1 = null;
          j = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
          i = 0;
          if (j >= 0)
          {
            Object localObject2 = (EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(j);
            if (!(localObject2 instanceof TextInfo)) {
              break label286;
            }
            paramJSONArray = (JSONArray)localObject1;
            if (localObject1 == null) {
              paramJSONArray = (TextInfo)localObject2;
            }
            if (i == 0) {
              break label281;
            }
            localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
            int k = j + 1;
            localObject1 = (TextInfo)((ArrayList)localObject1).get(k);
            localObject2 = (TextInfo)localObject2;
            if (!TextUtils.isEmpty(((TextInfo)localObject1).a)) {
              if (TextUtils.isEmpty(((TextInfo)localObject2).a))
              {
                ((TextInfo)localObject2).a = ((TextInfo)localObject1).a;
              }
              else
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(((TextInfo)localObject2).a);
                localStringBuilder.append("\n");
                localStringBuilder.append(((TextInfo)localObject1).a);
                ((TextInfo)localObject2).a = localStringBuilder.toString();
              }
            }
            b(k);
            break label291;
          }
          notifyDataSetChanged();
          return;
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      i += 1;
      continue;
      label281:
      i = 1;
      break label291;
      label286:
      i = 0;
      paramJSONArray = (JSONArray)localObject1;
      label291:
      j -= 1;
      Object localObject1 = paramJSONArray;
    }
  }
  
  public boolean a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (!((EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int b()
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      j += ((EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
    }
    return j;
  }
  
  public ArrayList<HomeWorkInfoInterface> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      EditItemInfoBase localEditItemInfoBase = (EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localEditItemInfoBase instanceof HomeWorkInfoInterface)) {
        localArrayList.add((HomeWorkInfoInterface)localEditItemInfoBase);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.c((EditItemInfoBase)localArrayList.get(paramInt));
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (((EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b() == -1);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return ((EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).hashCode();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Adapter onBindViewHolder, holder type:");
    ((StringBuilder)localObject).append(paramViewHolder.getItemViewType());
    ((StringBuilder)localObject).append(", position:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("xmediaEditor", 2, ((StringBuilder)localObject).toString());
    localObject = (EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ((EditItemInfoBase)localObject).c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.a(paramViewHolder, (EditItemInfoBase)localObject, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Adapter onCreateViewHolder, type:");
    localStringBuilder.append(paramInt);
    QLog.i("xmediaEditor", 2, localStringBuilder.toString());
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.a(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Adapter onViewAttachedToWindow, holder type:");
    localStringBuilder.append(paramViewHolder.getItemViewType());
    QLog.i("xmediaEditor", 2, localStringBuilder.toString());
    super.onViewAttachedToWindow(paramViewHolder);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.c(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Adapter onViewDetachedFromWindow, holder type:");
    localStringBuilder.append(paramViewHolder.getItemViewType());
    QLog.i("xmediaEditor", 2, localStringBuilder.toString());
    super.onViewDetachedFromWindow(paramViewHolder);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.b(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Adapter onViewRecycled, holder type:");
    localStringBuilder.append(paramViewHolder.getItemViewType());
    QLog.i("xmediaEditor", 2, localStringBuilder.toString());
    super.onViewRecycled(paramViewHolder);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.a(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter
 * JD-Core Version:    0.7.0.1
 */