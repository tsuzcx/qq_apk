package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoFactory;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HeaderInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HomeWorkInfoInterface;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.UploadEditItemInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditItemBase.OnEditItemListener;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.HeaderItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.TextViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;

public class XMediaEditor
  extends RecyclerView
{
  private int jdField_a_of_type_Int = 0;
  private Bundle jdField_a_of_type_AndroidOsBundle = new Bundle();
  private View jdField_a_of_type_AndroidViewView;
  private XMediaEditor.ICommitStateChangeListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$ICommitStateChangeListener;
  private XMediaEditor.IContentLengthChangeListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$IContentLengthChangeListener;
  private XMediaEditor.IFocusChangeListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$IFocusChangeListener;
  XMediaEditorAdapter jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter;
  private TextInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
  EditItemBase.OnEditItemListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener = new XMediaEditor.3(this);
  private HeaderItem jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiHeaderItem;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 2147483647;
  private boolean jdField_c_of_type_Boolean = false;
  private int d;
  
  public XMediaEditor(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public XMediaEditor(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public XMediaEditor(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new LinearLayoutManager(paramContext);
    addItemDecoration(new XMediaEditor.SpaceItemDecoration(26));
    setLayoutManager(paramAttributeSet);
    paramAttributeSet = new SparseArray();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiHeaderItem = new HeaderItem(this, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiHeaderItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener);
    paramAttributeSet.put(-1, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiHeaderItem);
    paramAttributeSet.put(0, new TextItem(this, paramContext).a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener));
    paramAttributeSet.put(3, new AudioItem(this, paramContext).a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener));
    paramAttributeSet.put(1, new ImageItem(this).a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener));
    paramAttributeSet.put(2, new VideoItem(this).a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter = new XMediaEditorAdapter(paramAttributeSet);
    setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter);
    setDefaultContent();
  }
  
  private <T extends View> T a(Class<T> paramClass, View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if (paramClass.isInstance(paramView)) {
      return (View)paramClass.cast(paramView);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = paramView.getChildCount();
      if (i > 0) {
        return a(paramClass, paramView.getChildAt(i - 1));
      }
    }
    return null;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.getItemCount(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(i) != null)
      {
        k = j;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(i).b() == paramInt) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a();
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
  }
  
  public ArrayList<UploadEditItemInfo> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a();
  }
  
  public ArrayList<EditItemInfoBase> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.getItemCount())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(i) != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(i).b() == paramInt)) {
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
    ((TextInfo)localObject).jdField_a_of_type_Boolean = true;
    localObject = (TextItem.TextViewHolder)findViewHolderForAdapterPosition(((TextInfo)localObject).jdField_c_of_type_Int);
    if (localObject != null)
    {
      ((TextItem.TextViewHolder)localObject).a.setFocusable(true);
      ((TextItem.TextViewHolder)localObject).a.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new XMediaEditor.1(this, (TextItem.TextViewHolder)localObject));
    }
  }
  
  public void a(int paramInt)
  {
    int j = 0;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter;
    int i = paramInt - 1;
    Object localObject2 = ((XMediaEditorAdapter)localObject1).a(i);
    int k = paramInt + 1;
    if (k < this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.getItemCount()) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(k);
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      if ((localObject2 instanceof TextInfo))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
        if (localObject1 != null) {
          ((TextInfo)localObject1).jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
      return;
    }
    if (((localObject1 instanceof TextInfo)) && ((localObject2 instanceof TextInfo)))
    {
      localObject1 = (TextInfo)localObject1;
      localObject2 = (TextInfo)localObject2;
      ((TextInfo)localObject2).jdField_a_of_type_Int = ((TextInfo)localObject2).jdField_a_of_type_JavaLangString.length();
      Object localObject3 = (TextItem.TextViewHolder)findViewHolderForAdapterPosition(((TextInfo)localObject2).jdField_c_of_type_Int);
      if (localObject3 != null) {
        ((TextItem.TextViewHolder)localObject3).a.setSelection(((TextInfo)localObject2).jdField_a_of_type_Int);
      }
      if (!TextUtils.isEmpty(((TextInfo)localObject1).jdField_a_of_type_JavaLangString)) {
        if (TextUtils.isEmpty(((TextInfo)localObject2).jdField_a_of_type_JavaLangString))
        {
          ((TextInfo)localObject2).jdField_a_of_type_JavaLangString = ((TextInfo)localObject1).jdField_a_of_type_JavaLangString;
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((TextInfo)localObject2).jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject3).append(((TextInfo)localObject1).jdField_a_of_type_JavaLangString);
          ((TextInfo)localObject2).jdField_a_of_type_JavaLangString = ((StringBuilder)localObject3).toString();
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
      if (localObject1 != null) {
        ((TextInfo)localObject1).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b(k);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
      paramInt = j;
      if (i >= 0) {
        paramInt = i;
      }
      scrollToPosition(paramInt);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
  }
  
  public void a(EditItemInfoBase paramEditItemInfoBase)
  {
    if (paramEditItemInfoBase == null)
    {
      Toast.makeText(getContext(), "插入的EditItemInfoBase为空", 0).show();
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.getItemCount();
    Object localObject1 = "";
    if (i == 0)
    {
      if ((paramEditItemInfoBase instanceof TextInfo))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(paramEditItemInfoBase);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)paramEditItemInfoBase);
        paramEditItemInfoBase = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
        paramEditItemInfoBase.jdField_c_of_type_Int = 0;
        paramEditItemInfoBase.jdField_a_of_type_Boolean = true;
        return;
      }
      localObject1 = new TextInfo("");
      localObject2 = new TextInfo("");
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a((EditItemInfoBase)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(paramEditItemInfoBase);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a((EditItemInfoBase)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)localObject2);
      paramEditItemInfoBase = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
      paramEditItemInfoBase.jdField_a_of_type_Boolean = true;
      paramEditItemInfoBase.jdField_c_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
      scrollToPosition(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_c_of_type_Int);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo == null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter;
      localObject2 = ((XMediaEditorAdapter)localObject2).a(((XMediaEditorAdapter)localObject2).getItemCount() - 1);
      if ((localObject2 instanceof TextInfo))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)localObject2);
      }
      else
      {
        localObject2 = new TextInfo("");
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.getItemCount();
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a((EditItemInfoBase)localObject2);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = true;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_c_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Int < 0) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Int = 0;
    }
    i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Int;
    Object localObject2 = (TextItem.TextViewHolder)findViewHolderForAdapterPosition(j);
    if (localObject2 != null) {
      i = ((TextItem.TextViewHolder)localObject2).a.getSelectionStart();
    }
    Object localObject3;
    if (i == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_JavaLangString.length() == 0)
      {
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      else
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_JavaLangString;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_JavaLangString.substring(0, i);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_JavaLangString.length() != i) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_JavaLangString.substring(i);
      }
    }
    if ((paramEditItemInfoBase instanceof TextInfo))
    {
      paramEditItemInfoBase = (TextInfo)paramEditItemInfoBase;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(paramEditItemInfoBase.jdField_a_of_type_JavaLangString);
      localStringBuilder.append((String)localObject1);
      ((TextInfo)localObject3).a(localStringBuilder.toString());
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
      ((TextInfo)localObject1).jdField_a_of_type_Int += paramEditItemInfoBase.jdField_a_of_type_JavaLangString.length();
    }
    else
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(j);
      if ((localObject3 instanceof TextInfo))
      {
        ((TextInfo)localObject3).a((String)localObject2);
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("insert item 类型不对 insertPosition");
        ((StringBuilder)localObject2).append(j);
        QLog.d("XMediaEditor", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = new TextInfo((String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = false;
      ((TextInfo)localObject1).jdField_a_of_type_Boolean = true;
      ((TextInfo)localObject1).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter;
      i = j + 1;
      ((XMediaEditorAdapter)localObject2).a(i, (EditItemInfoBase)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(i, paramEditItemInfoBase);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_c_of_type_Int = (j + 2);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
    }
    scrollToPosition(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
  }
  
  public void a(ArrayList<UploadEditItemInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(paramArrayList);
  }
  
  public void a(List<EditItemInfoBase> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a((EditItemInfoBase)paramList.get(i));
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b();
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<HomeWorkInfoInterface> b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b();
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo;
    ((TextInfo)localObject).jdField_a_of_type_Boolean = false;
    localObject = (TextItem.TextViewHolder)findViewHolderForAdapterPosition(((TextInfo)localObject).jdField_c_of_type_Int);
    if (localObject != null)
    {
      ((TextItem.TextViewHolder)localObject).a.setFocusable(false);
      ((TextItem.TextViewHolder)localObject).a.setFocusableInTouchMode(false);
      ThreadManager.getUIHandler().post(new XMediaEditor.2(this, (TextItem.TextViewHolder)localObject));
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    setDefaultContent();
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return (this.jdField_a_of_type_Boolean) && (super.canScrollVertically(paramInt));
  }
  
  public int d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiHeaderItem.a(null);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = this.jdField_c_of_type_Int;
    if (i != 2147483647) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((d() == 0) && (paramMotionEvent.getAction() == 1))
    {
      EditText localEditText = (EditText)a(EditText.class, this);
      if (localEditText != null)
      {
        int[] arrayOfInt = new int[2];
        localEditText.getLocationOnScreen(arrayOfInt);
        float f = paramMotionEvent.getRawY();
        if (arrayOfInt[1] <= f)
        {
          if (QLog.isColorLevel()) {
            QLog.d("XMediaEditor", 2, "Oops! found et");
          }
          if (!localEditText.isFocused())
          {
            localEditText.setFocusable(true);
            localEditText.setFocusableInTouchMode(true);
            localEditText.requestFocus();
          }
          InputMethodUtil.a(localEditText);
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChildClickable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCommitStateChangeListener(XMediaEditor.ICommitStateChangeListener paramICommitStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$ICommitStateChangeListener = paramICommitStateChangeListener;
  }
  
  public void setContentLengthChangeListener(XMediaEditor.IContentLengthChangeListener paramIContentLengthChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$IContentLengthChangeListener = paramIContentLengthChangeListener;
  }
  
  public void setData(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(new JSONArray(paramString));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(null, false);
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(this.jdField_a_of_type_Int, i);
      this.jdField_a_of_type_Int = i;
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setDataByEdit(JSONArray paramJSONArray)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramJSONArray.length())
        {
          EditItemInfoBase localEditItemInfoBase = EditItemInfoFactory.a(paramJSONArray.getJSONObject(i));
          if (localEditItemInfoBase != null)
          {
            if ((localEditItemInfoBase instanceof UploadEditItemInfo))
            {
              ((UploadEditItemInfo)localEditItemInfoBase).f = 3;
              if ((localEditItemInfoBase instanceof ImageInfo)) {
                ((ImageInfo)localEditItemInfoBase).e = 100;
              }
            }
            if ((localEditItemInfoBase instanceof TextInfo))
            {
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.a(((TextInfo)localEditItemInfoBase).jdField_a_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Int = ((TextInfo)localEditItemInfoBase).jdField_a_of_type_JavaLangString.length();
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
            }
            else
            {
              a(localEditItemInfoBase);
            }
          }
        }
        else
        {
          int j = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b();
          i = 0;
          if (i < j)
          {
            paramJSONArray = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(i);
            if (!(paramJSONArray instanceof TextInfo)) {
              break label204;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)paramJSONArray);
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo.jdField_a_of_type_Boolean = true;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
          scrollToPosition(0);
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
      label204:
      i += 1;
    }
  }
  
  public void setDefaultContent()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(new TextInfo("").toString());
    localStringBuilder.append("]");
    setData(localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelTextInfo = ((TextInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(0));
  }
  
  public void setExtraValue(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString(paramString1, paramString2);
  }
  
  public void setFocusChangeListener(XMediaEditor.IFocusChangeListener paramIFocusChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor$IFocusChangeListener = paramIFocusChangeListener;
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView == null)
    {
      d();
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiHeaderItem.a(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(0, new HeaderInfo());
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.notifyDataSetChanged();
  }
  
  public void setHint(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setLeftRightPadding(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setShowType(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditorAdapter.a(paramInt);
  }
  
  public void setSizeLimit(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor
 * JD-Core Version:    0.7.0.1
 */