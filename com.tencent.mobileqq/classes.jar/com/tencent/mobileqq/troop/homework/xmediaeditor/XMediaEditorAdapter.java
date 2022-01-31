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
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditorViewHolderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class XMediaEditorAdapter
  extends RecyclerView.Adapter
{
  int jdField_a_of_type_Int = 0;
  public EditorViewHolderManager a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public XMediaEditorAdapter(SparseArray paramSparseArray)
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
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return (EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public String a()
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      EditItemInfoBase localEditItemInfoBase = (EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localEditItemInfoBase.b() == -1) {}
      for (;;)
      {
        i += 1;
        break;
        localJSONArray.put(localEditItemInfoBase.a());
      }
    }
    return localJSONArray.toString();
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      EditItemInfoBase localEditItemInfoBase = (EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((localEditItemInfoBase instanceof UploadEditItemInfo)) && (((UploadEditItemInfo)localEditItemInfoBase).g != 3)) {
        localArrayList.add((UploadEditItemInfo)localEditItemInfoBase);
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
      localEditItemInfoBase.a(paramString);
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
  
  public void a(ArrayList paramArrayList)
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
    int j;
    for (;;)
    {
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
          localObject = EditItemInfoFactory.a(paramJSONArray.getJSONObject(i));
          if (localObject == null) {
            break label252;
          }
          a((EditItemInfoBase)localObject);
          break label252;
        }
        j = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        i = 0;
        paramJSONArray = null;
        if (j < 0) {
          break label244;
        }
        Object localObject = (EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (!(localObject instanceof TextInfo)) {
          break label271;
        }
        if (paramJSONArray != null) {
          break label249;
        }
        paramJSONArray = (TextInfo)localObject;
        if (i == 0) {
          break label266;
        }
        TextInfo localTextInfo = (TextInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1);
        localObject = (TextInfo)localObject;
        if (TextUtils.isEmpty(localTextInfo.a))
        {
          b(j + 1);
          break;
        }
        if (TextUtils.isEmpty(((TextInfo)localObject).a))
        {
          ((TextInfo)localObject).a = localTextInfo.a;
          continue;
        }
        ((TextInfo)localObject).a = (((TextInfo)localObject).a + "\n" + localTextInfo.a);
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      continue;
      label244:
      notifyDataSetChanged();
      return;
      label249:
      continue;
      label252:
      i += 1;
    }
    for (;;)
    {
      j -= 1;
      break;
      label266:
      i = 1;
      continue;
      label271:
      i = 0;
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
  
  public ArrayList b()
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
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.c((EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
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
    QLog.i("xmediaEditor", 2, "Adapter onBindViewHolder, holder type:" + paramViewHolder.getItemViewType() + ", position:" + paramInt);
    EditItemInfoBase localEditItemInfoBase = (EditItemInfoBase)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localEditItemInfoBase.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.a(paramViewHolder, localEditItemInfoBase, this.jdField_a_of_type_Int);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.i("xmediaEditor", 2, "Adapter onCreateViewHolder, type:" + paramInt);
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.a(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewAttachedToWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewAttachedToWindow(paramViewHolder);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.c(paramViewHolder);
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewDetachedFromWindow, holder type:" + paramViewHolder.getItemViewType());
    super.onViewDetachedFromWindow(paramViewHolder);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.b(paramViewHolder);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.i("xmediaEditor", 2, "Adapter onViewRecycled, holder type:" + paramViewHolder.getItemViewType());
    super.onViewRecycled(paramViewHolder);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditorViewHolderManager.a(paramViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter
 * JD-Core Version:    0.7.0.1
 */